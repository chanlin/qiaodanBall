package com.qiaodan.smartball.pullUtils;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	private static String dateStr = "yyyy/MM/dd HH:mm";
	static SimpleDateFormat simFor = new SimpleDateFormat(dateStr);
	public static String simpDate(Date date){
		return simFor.format(date);
	}
	/**
     * 把毫秒转化成日期
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */
    private static void transferLongToDate(String dateFormat,Long millSec){
     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
     Date date= new Date(millSec);
      String str =  sdf.format(date);
      System.out.println(str);
    }
	private static File file;
	private static String path;
	public static void makeFileForMoble(Class<?> clazz, String mobile){
		URL url = clazz.getClassLoader().getResource("");
		path = url.getPath()+"/temp/" + mobile + ".txt";
		System.out.println(path);
		file = new File(path);
		if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	public static void writeLog(String tag, String log) {
		if (file == null) {
			throw new NullPointerException("file is not be null !");
		}
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            BufferedWriter out = null;
            try {
                // Create file
                FileWriter fstream = new FileWriter(path, true);
                out = new BufferedWriter(fstream);
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss SSS ");
                String time = sdf.format(new Date(System.currentTimeMillis()));
                out.append(time);
                out.append(tag+"\t");
                out.append(log);
                out.append("\r\n\r\n");
            } catch (Exception e) {// Catch exception if any
                // System.err.println("Error: " + e.getMessage());
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        }

	/**
	 * 文本轉字節
	 * @return 
	 */
	public static byte[] fileToByte(String path){
		File file = new File(path);
		if(file == null){
			return null;
		}
		FileInputStream stream = null;
		ByteArrayOutputStream out = null;
		try {
			stream = new FileInputStream(file);
			out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while((n = stream.read(b)) != -1 ){
				out.write(b, 0, n);
			}
			return out.toByteArray();
		} catch (Exception e) {
			 System.out.println(e.toString());  
		} finally {
			try {  
			       stream.close();  
			                out.close();  
			            } catch (IOException e) {  
			                e.printStackTrace();  
			            }  
			  
			        }  
			   return null;  
	
	}
	/**
	 * 字节输入到文本
	 */
	public static void byteToFile(byte[] bytes) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\r.txt");
		if(file == null){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedOutputStream stream = null;
		FileOutputStream fstream = null;
		byte[] data = bytes;
		try {
			fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
				if (null != fstream) {
					fstream.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
