package com.qiaodan.smartball.pullUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.wzb.helloworld.Mat;
import com.wzb.helloworld.Point;


public class PullHex {

	public static void main(String[] args) {
	
		//pullDatabaseJumpData();
		
		/**
		 * 前100zi
		 */
		String data = "480000000000000029000000020000000000000001000000ac248d42a8c6cb3f3c3c0000040000001a010000010000003263393338393430356432613138376230313564326230303631623730373366898fb359b7291e17d58a5d407100fdbe7f873840";
		
		header(data);

//		String str2 = "7472616bf1c8af3f12731abf0000403f12fb6000,7472616be6b92740331f81bfcbe3273f5ffd6000,7472616b9d777540a237d3bf26d32f3f92ff6000,7472616b17dd9d40ea3219c092b8293fd9016100,7472616bce2fc540ae2941c0696f303f0a046100,7472616bda30ee40253c65c0932e333f32066100,7472616b72d40a41349988c038b5343f55086100,7472616bd9a51d41e1999fc0696f303f860a6100,7472616b20b1314125eeb3c0d5ca333fac0c6100,7472616bc06f3641d0fed6c03c4e113f67126100,7472616bb7a92e416ccdfec016f12a3faa146100,7472616b5d752841778713c10e80283ff5166100,7472616b954c1641cbe713c13c4e113ff01b6100,7472616bd487fe40d1ae0ec1b5f23c3ff81d6100,7472616b9d6cd1404e140cc19c9f353f18206100,7472616b471ca340c16e07c1b5f23c3f20226100,7472616b544f6b405cde00c1d7403d3f27246100,7472616b7a581040fd8ef5c073563c3f31266100,7472616ba4314f3fa4dbecc073563c3f3b286100,7472616bb4551bbf10ccdfc094a43c3f442a6100,7472616b1d212bc04b0fc5c0c4b18e3f7c2c6100,7472616be89926c0d0cda0c03c4e113ffb306100,7472616b30e708c027376ec0ab0b313f2a336100,7472616bc88ed3bf75a11dc0dcc52c3f67356100,7472616b032a56c02361d7c02d581f3fbb756000,7472616bc05e7ec0a8cfb4c070f41f3f22786000,7472616b8f7c8ec0359b91c0b98b193f9e7a6000,7472616b32c4a7c012df63c05717223ffe7c6000,7472616b4e81cac088a04ec03c4e113f88806000,7472616b7f82efc0205429c0e4c0253fdc826000,7472616b3dcfccc0abd23ec03c4e113f74896000,7472616b6108f0c07e9750c03c4e113fd4926000,7472616be083f2c05f5793c0bb772c3f12956000,7472616b1c8907c178cba9c03c4e113fdabc6000656e64".replace(",", "");
//		byte[] ret = hexStringToByte(str2);
//		byteToFile(ret);
//
//		char[] a = encodeHex(fileToByte(), DIGITS_LOWER);
//		String str = new String(a);
//		System.err.println(str);
		
		
		String traktimemin = "c38e77bf";
//		String traktimemax = "9c7e863f";
		byte[] trakBtmin = hexStringToByte(traktimemin);

		System.out.println(trakBtmin[0]+"  "+trakBtmin[1]+"   "+trakBtmin[2]+"   "+trakBtmin[3]);
//		byte[] trakBtmax = hexStringToByte(traktimemax);
		
//		System.out.println(trakBtmax[0]+"   "+trakBtmax[1]+"   "+trakBtmax[2]+"   "+trakBtmax[3]);
//		float trakmax = byte2float(trakBtmax, 0);
//		System.out.println(trakmax);
		float trakmin = byte2float(trakBtmin, 0);
		System.out.println(trakmin);
//		System.err.println(trakmax - trakmin);
		
		
		//pull52();
//		transferLongToDate("MM/dd/yyyy HH:mm:ss",22222222l);
	/*	
		String hex = "7472616b3dd8bdbf02aea03e4a0c423f8d911605,7472616b25a651c07c0c08be3f786c3fc3941605,7472616b8a1ea0c06da169beea835d3f67961605,7472616b5a13d9c0988ab23c880f663fef971605,7472616b0f09e7c0c13cf33fa4d8763f40991605,7472616be09be7c09e7d6c4067c1653fc99a1605,7472616bc6e3e8c03625a440e6ab373f5b9f1605,7472616ba877adc017efb640ac49793fa4a01605,7472616b004a68c0e2ccb4404673653f2ea21605,7472616bb000e6bf1170af40dc8d6b3fa4a31605,7472616bc029b0bd3815b64087995c3f4ba51605,7472616b5c40e13f0a90b8403f786c3fbea61605,7472616b2855c93f7a369440865a133fe0aa1605,7472616b4dad913ff28a3a401cb4623f73ac1605,7472616b00b51d3f5881863f06c3773fc1ad1605";
		hex = hex.replaceAll(",", "");
		byteToFile(hexStringToByte(hex));
	*/	
		
	}

	public static void pullDatabaseJumpData(String jumpStr) {
		/**
		 * 6a756d7014141244e623d63ee37c294080bd0300
		 * ,6a756d7019192a440a2d113fffa299c011c20300
		 * ,6a756d70c4c3a143b74c033ef3aac33fecc70300
		 */
		
		jumpStr = "6a756d708887ad439f17173e50476b3fc057a43e,6a756d70a6a5b1430c591e3ef39748c0c05ca43e,6a756d700000b443fc91223ea405a8bf8060a43e,6a756d707878b043e6411c3e65f2e1c08064a43e,6a756d70bfbe0944ae67be3e4f808d3fc068a43e";
		String[] jumps = jumpStr.split(",");
		for(String jump : jumps){
			System.out.println("----------------------------------");
			float ftime = byte2float(hexStringToByte(jump.substring(8, 16)), 0);
			System.out.println("滞空时间="+ftime);
			float fheigh = byte2float(hexStringToByte(jump.substring(16, 24)), 0);
			System.out.println("跳跃高度="+fheigh);
			float fcord = byte2float(hexStringToByte(jump.substring(24,32)), 0);
			System.out.println("翻转角度="+fcord);
			long ltime = bytes2Long(hexStringToByte(jump.substring(32, 40)), 0)*1000/512;
			System.out.println("相对时间单位="+ltime);
			
		}
	}
	public static void pullTrak(String trail){
		String[] strs = trail.split(",");
		

		ArrayList<Point> xy = new ArrayList<Point>();
		System.err.println("多少个点："+strs.length);
		for(int a = 1; a<strs.length;a++){
			String as = strs[a];
			String latStr = as.substring(8, 16);
			byte[] trakx1 = PullHex.hexStringToByte(latStr);
			float trakxf2 = PullHex.byte2float(trakx1, 0);
//			System.out.println(trakmin);
			

			String lonStr = as.substring(16,24);
			byte[] trakYb = PullHex.hexStringToByte(lonStr);
			float trakYf = PullHex.byte2float(trakYb, 0);
			Point p = new Point();
			p.setX(trakxf2);
			p.setY(trakYf);
			xy.add(p);
		}
//		Point p2 = new Point();
//		/**
//		 * x = 2.852720, y = -1.522520
//		 */
//		p2.setX(2.852720f);
//		p2.setY(-1.522520f);
//		xy.add(p2);
		for(int k = 0 ; k < xy.size();k++){
			System.out.println(xy.get(k).getX()+"	"+xy.get(k).getY());
		}
		
		ArrayList<Point> pxy = new ArrayList<Point>();
		int i;
		for(i=0;i<xy.size();i++){
			Point pi=new Point();
			pxy.add(pi);
		}
		if(xy != null && xy.size() >= 4){
			Mat.data_analysis_v3(xy, xy.size(), pxy,1);
		}
		else{
			pxy = xy;
		}
		System.out.println("转换后的坐标----------------------");
		for(int j = 0 ; j < pxy.size();j++){
			System.out.println(pxy.get(j).getX()+"	"+pxy.get(j).getY());
		}
	}
	public static void header(String data) {
		System.out.println("原数据：" + data + "\nlength = " + data.length());
		// 总步数 (long)
		long bl1 = bytes2Long(hexStringToByte(data.substring(0, 8)), 0);
		System.out.println("芯片返回 = " + data.substring(0, 8) + "	总步数	(long) = " + bl1);
		// 总跑步数 (long)
		long bl2 = bytes2Long(hexStringToByte(data.substring(8, 16)), 0);
		System.out.println("芯片返回 = " + data.substring(8, 16) + "	总跑步数	(long) = " + bl2);
		// 总冲刺数 (long)
		long bl3 = bytes2Long(hexStringToByte(data.substring(16, 24)), 0);
		System.out.println("芯片返回 = " + data.substring(16, 24) + "	总冲刺数	(long) = " + bl3);
		// 横向步数 (long)
		long bl4 = bytes2Long(hexStringToByte(data.substring(24, 32)), 0);
		System.out.println("芯片返回 = " + data.substring(24, 32) + "	横向步数	(long) = " + bl4);
		// 横向跑步数 (long)
		long bl5 = bytes2Long(hexStringToByte(data.substring(32, 40)), 0);
		System.out.println("芯片返回 = " + data.substring(32, 40) + "	横向跑步数	(long) = " + bl5);
		// 横向冲刺数 (long)
		long bl6 = bytes2Long(hexStringToByte(data.substring(40, 48)), 0);
		System.out.println("芯片返回 = " + data.substring(40, 48) + "	横向冲刺数	(long) = " + bl6);
		// 总距离 (float,米)
		float f1 = byte2float(hexStringToByte(data.substring(48, 56)), 0);
		System.out.println("芯片返回 = " + data.substring(48, 56) + "	总距离	(float,米) = " + f1);
		// 横向距离 (float,米)
		float f2 = byte2float(hexStringToByte(data.substring(56, 64)), 0);
		System.out.println("芯片返回 = " + data.substring(56, 64) + "	横向距离	(float,米) = " + f2);
		// 最大移动速度 (float m/s)
		float f3 = byte2float(hexStringToByte(data.substring(64, 72)), 0);
		System.out.println("芯片返回 = " + data.substring(64, 72) + "	最大移动速度	(float m/s) = " + f3
				+"\t\t转换："+(f3*3.6)+"  km/h");
		//long i3 = bytes2Long(hexStringToByte(data.substring(64,66)), 0);
		float avg = Integer.parseInt(data.substring(64,66),16);
		float max = Integer.parseInt(data.substring(66,68),16);
		System.err.println("前48字节输出的数据： 平均冲击力："+avg/10+"\t最大冲击力："+max/10);
		// 变向次数 (long)
		long bl7 = bytes2Long(hexStringToByte(data.substring(72, 80)), 0);
		System.out.println("芯片返回 = " + data.substring(72, 80) + "	变向次数	(long) = " + bl7);
		// 变向平均触地时间 (long,毫秒)
		long bl8 = bytes2Long(hexStringToByte(data.substring(80, 88)), 0);
		System.out.println("芯片返回 = " + data.substring(80, 88) + "	变向平均触地时间	(long,毫秒) = " + bl8);
		// 纵跳次数(long)
		long bl9 = bytes2Long(hexStringToByte(data.substring(88, 96)), 0);
		System.out.println("芯片返回 = " + data.substring(88, 96) + "	纵跳次数(long) = " + bl9);
		
		/**
		 * 这里解析用户数据
		 */
		String userId = decode(data.substring(96,160));
		System.out.println("芯片返回的userID= "+userId);
		long usertime = bytes2Long(hexStringToByte(data.substring(160,168)),0);
		System.out.println("芯片返回的usertime= "+usertime);
		double userlan = byteToDouble(hexStringToByte(data.substring(168,184)));
		System.out.println("芯片返回的userlan= "+userlan);
		double userlon = byteToDouble(hexStringToByte(data.substring(184,200)));
		System.out.println("芯片返回的userlon= "+userlon);
		/**
		 * 活跃占比算法1 ： （总跑+总冲+跳+横步-横冲）/(总步+跳）
		 */
		if((bl1+bl9) != 0){
		float pao = (bl2+bl3+bl4+bl9-bl6)*100/(bl1+bl9);
		String result = String.format("%.2f",pao);
		System.out.println("活跃占比算法1:"+result);
		}
		/**
		 * 活跃占比算法2：（总跑*0.360 + 总冲*0.175 + 总跳 * ）/ 
		 */
		
	}
	
	private static void pull52(){
		// 0102030405060708090a0b0c0d0e0f01020304050102030405060708090a0b0c0d0e0f01020304050102030405060708090a0b0c
		String data = "1b0000000000000000000000030000000000000000000000f50c9341dd241640cd5fc63f02000000360300000a0000003263393338393430356431303534346230313564313063383033383430356539ba32815951f89a85da7e5c40d43dd68b99913640";
		String bl1 = new String(hexStringToByte(data.substring(0 , 64)));//32 字节的userid
		System.out.println("芯片返回 userid = " + bl1);
		long time = bytes2Long(hexStringToByte(data.substring(65, 72)), 0);
		System.out.println("芯片返回 time = " + time);
		double lat = byteToDouble(hexStringToByte(data.substring(73, 88)));
		System.out.println("芯片返回 lat= " + lat);
		double lon = byteToDouble(hexStringToByte(data.substring(89, 104)));
		System.out.println("芯片返回 lon = " + lon);
		
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
    //scanRecords的格式转换  将十六进制序列转String  
	private static String hexString="0123456789ABCDEF"; 
    static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

	/**
	 * 把16进制字符串转换成字节数组
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
//			System.err.println(result[i]);
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789abcdef".indexOf(c);
		return b;
	}

	/**
	 * 将低字节数组转换为int
	 * 
	 * @param b
	 *            byte[]
	 * @return int
	 */
	/**
	 * @Title: lBytesToInt @Description: TODO @param b @return @return
	 *         long @throws
	 */
	public static long lBytesToInt(byte[] b) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			if (b[3 - i] >= 0) {
				s = s + b[3 - i];
			} else {
				s = s + 256 + b[3 - i];
			}
			s = s * 256;
		}
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		return s;
	}

	//-61 -114 119 -65
	// -0.9670221
	public static float byte2float(byte[] b, int index) {
		int l;
		l = b[index + 0];
		l &= 0xff;
		l |= ((long) b[index + 1] << 8);
		l &= 0xffff;
		l |= ((long) b[index + 2] << 16);
		l &= 0xffffff;
		l |= ((long) b[index + 3] << 24);
//		System.out.println("``````````"+l);
		return Float.intBitsToFloat(l);
	}

	//byte[0] a9 
	public static long bytes2Long(byte[] byteNum, int index) {
		long num = 0;
		for (int ix = 3; ix >= 0; ix--) {
			num <<= 8;
			num |= (byteNum[index + ix] & 0xff);
		}
		return num;
	}
	
	/**
	 * 
	 * @param data
	 * @param toDigits
	 * @return
	 */
	protected static char[] encodeHex(byte[] data, char[] toDigits) {
	    int l = data.length;
	    char[] out = new char[l << 1];
	    for (int i = 0, j = 0; i < l; i++) {
	        out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
	        out[j++] = toDigits[0x0F & data[i]];
	    }
	    return out;
	}
	
	/* 
	* 将16进制数字解码成字符串,适用于所有字符（包括中文） 
	*/ 
	public static String decode(String bytes) 
	{ 
	ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2); 
	//将每2位16进制整数组装成一个字节 
	for(int i=0;i<bytes.length();i+=2) 
	baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1)))); 
	return new String(baos.toByteArray()); 
	} 
	//字节到浮点转换
	  public static double byteToDouble(byte[] b){
	    long l;

	    l=b[0];
	    l&=0xff;
	    l|=((long)b[1]<<8);
	    l&=0xffff;
	    l|=((long)b[2]<<16);
	    l&=0xffffff;
	    l|=((long)b[3]<<24);
	    l&=0xffffffffl;
	    l|=((long)b[4]<<32);
	    l&=0xffffffffffl;

	    l|=((long)b[5]<<40);
	    l&=0xffffffffffffl;
	    l|=((long)b[6]<<48);

	    l|=((long)b[7]<<56);
	    return Double.longBitsToDouble(l);
	  }

/**
 * 用于建立十六进制字符的输出的小写字符数组
 */
public static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
}
