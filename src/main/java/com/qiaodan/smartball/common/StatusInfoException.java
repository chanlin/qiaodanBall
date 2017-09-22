package com.qiaodan.smartball.common;

public class StatusInfoException extends Exception {


	private static final long serialVersionUID = 8467188604793496048L;

	private int status; // 异常状态码

	public StatusInfoException(int status, String message) {
		super(message);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
