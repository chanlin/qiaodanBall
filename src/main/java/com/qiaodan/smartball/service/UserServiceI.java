package com.qiaodan.smartball.service;

import java.util.List;

import com.qiaodan.smartball.model.UserAges;
import com.qiaodan.smartball.model.UserData;

public interface UserServiceI {
	public List<UserData> getUserDataForTime(String beginTime,String endTime);
	public List<UserData> getUserData();
	public List<UserData> selectTableOfActiveUser();
	public List<UserAges> getUserAges(boolean isActive);
	public List<UserAges> getUserPosition(boolean isActive);
	

}
