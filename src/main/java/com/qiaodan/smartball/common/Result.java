package com.qiaodan.smartball.common;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 返回结果 ，所有返回结果的基类
 * @author ChanLin
 * 
 */
public class Result {
	
	private int status = Status.ERROR_STATUS;
	private String info = Status.ERROR_INFO;
	private Object data = new HashMap<String,Object>();
	
	public void setStatus(int status){
		this.status = status;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public void setData(Object data){
		if(data == null) return;
		this.data = data;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public String getInfo(){
		return this.info;
	}
	
	public Object getData(){
		return this.data;
	}
}
