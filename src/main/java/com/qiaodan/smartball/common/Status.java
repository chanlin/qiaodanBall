package com.qiaodan.smartball.common;

/**
 * 
 * @Description: TODO 程序状态码
 * @author ChanLin
 *
 */
public class Status {
	public static final int SUCCESS_STATUS = 1;
	public static final String SUCCESS_INFO = "操作成功";
	
	/**
	 * 业务逻辑错误
	 */
	public static final int ERROR_STATUS = 99999;
	public static final String ERROR_INFO = "操作失败";
	
	public static final int VALIDATION_REQUIRED_STATUS = 90001;
	public static final String VALIDATION_REQUIRED_INFO = "缺少参数或参数值为空";
	
	public static final int VALIDATION_NUMBER_STATUS = 90002;
	public static final String VALIDATION_NUMBER_INFO = "参数不是一个合法的数字";
	
	

}
