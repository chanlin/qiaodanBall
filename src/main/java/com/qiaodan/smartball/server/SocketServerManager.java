package com.qiaodan.smartball.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class SocketServerManager extends Thread{
	private static final Logger logger = Logger.getLogger(SocketServerManager.class);
	/**
     * 端口号
     */
    private int port;
 
    /**
     * 最大连接数
     */
    private int max_conn;
 
    /**
     * 缓冲区大小
     * */
    private int max_cache;
 
    /**
     * socket 超时时间
     * */
    private int timeout;
 
    /**
     * server对象
     */
    private ServerSocket server;
    /**
     * 线程池对象
     */
    private ExecutorService exService;
 
    public int getMax_cache() {
        return max_cache;
    }
 
    public void setMax_cache(int max_cache) {
        this.max_cache = max_cache;
    }
 
    public int getTimeout() {
        return timeout;
    }
 
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
 
    public int getPort() {
        return port;
    }
 
    public void setPort(int port) {
        this.port = port;
    }
 
    public int getMax_conn() {
        return max_conn;
    }
 
    public void setMax_conn(int max_conn) {
        this.max_conn = max_conn;
    }
 
    public ServerSocket getServer() {
        return server;
    }
    
    /**
     * 
     * 该构造方法提供设置最大连接数，最大缓存数，超时时间，此处把socket服务端作为一个单独进程；
     * 而把socket连接进程放置到线程池和缓存池，以提高性能
     * 
     * @param port
     *            端口号
     * @param max_conn
     *            最大连接池
     * @param max_cache
     *            最大缓存池
     * @param timeout
     *            超时时间
     */
    public SocketServerManager(int port, int max_conn, int max_cache,
            int timeout) {
 
        this.port = port;
        this.max_conn = max_conn;
        this.timeout = timeout <= 0 ? 0 : timeout;
        this.max_cache = max_cache;
 
        // 将socket连接放到线程池中，如果设置最大连接数为0时，使用自动分配线程
        if (max_conn <= 0) {
            exService = Executors.newCachedThreadPool();
        } else {
            // 如果没有设置缓存值，则随系统资源调配
            if (max_cache <= 0) {
                exService = new ThreadPoolExecutor(0, max_conn, 60000L,
                        TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());// 线程池
                return;
            }
            // 队列池，将无法进入线程池的内容存放socketadapte队列池中
            else {
                ArrayBlockingQueue<Runnable> socketadaptes = new ArrayBlockingQueue<Runnable>(
                        max_cache);
                exService = new ThreadPoolExecutor(0, max_conn, 60000L,
                        TimeUnit.MILLISECONDS, socketadaptes);// 线程池
            }
        }
        // 启动
        this.start();
    }
 
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("port " + port + " is used ,the server is close");
            return;
 
        }
        label: while (true) {
            try {
                Socket socket = null;
                try {
                    socket = server.accept();
                    logger.info("the socket [" + socket.getInetAddress() + ":"
                            + socket.getPort() + "] has been connection ");
                    socket.setKeepAlive(true);
                    if (timeout != 0) {
                        socket.setSoTimeout(timeout);
                    }
                    try {
                        // 将此处的socket监听放置到进程池
                        exService.execute(new SocketAdapt(socket));
                        logger.info("the socket [" + socket.getInetAddress()
                                + ":" + socket.getPort()
                                + "] has been put in ExecutorService");
                    } catch (RejectedExecutionException e) {
                        // TODO: handle exception
                        e.fillInStackTrace();
                        throw new Exception(
                                "becaue the \""
                                        + e.getMessage()
                                        + "\" the thread is full and the thread cache is full ;");
 
                    }
                } catch (SocketException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    if (socket != null)
                        socket.close();
                    throw new Exception("because the error \"" + e.getMessage()
                            + "\" so close this socket");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    if (socket != null)
                        socket.close();
                    throw new Exception("because the error \"" + e.getMessage()
                            + "\" so close this socket");
                }
            } catch (Exception e) {
                e.fillInStackTrace();
                // TODO: handle exception
                logger.error(e.getMessage());
                // 一旦发生异常，还继续进行
                continue label;
            }
 
        }
    }
 
}
