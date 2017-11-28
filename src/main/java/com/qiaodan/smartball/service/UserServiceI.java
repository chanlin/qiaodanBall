package com.qiaodan.smartball.service;

import java.util.List;

import com.qiaodan.smartball.model.UserData;

public interface UserServiceI {
	public List<UserData> getUserDataForTime(String beginTime,String endTime);
	public List<UserData> getUserData();
	public List<UserData> selectTableOfActiveUser();
	public List<UserData> getUserAges();
	

}
