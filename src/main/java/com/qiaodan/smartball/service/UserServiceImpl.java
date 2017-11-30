package com.qiaodan.smartball.service;

import static org.hamcrest.CoreMatchers.isA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaodan.smartball.dao.u_vipMapper;
import com.qiaodan.smartball.model.UserAges;
import com.qiaodan.smartball.model.UserData;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private u_vipMapper vipMapper;
	public u_vipMapper getVipMapper(){
		return vipMapper;
	}
	
	@Autowired
	public void setVipMapper(u_vipMapper vipMapper){
		this.vipMapper = vipMapper;
	}
	
	
	public List<UserData> getUserDataForTime(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return vipMapper.getUserDataForTime(beginTime,endTime);
	}

	public List<UserData> getUserData() {
		// TODO Auto-generated method stub
		return vipMapper.getUserData();
	}

	public List<UserData> selectTableOfActiveUser() {
		// TODO Auto-generated method stub
		return vipMapper.selectTableOfActiveUser();
	}

	public List<UserAges> getUserAges(boolean isActive) {
		// TODO Auto-generated method stub
		return vipMapper.getUserAges(isActive);
	}

	public List<UserAges> getUserPosition(boolean isActive) {
		// TODO Auto-generated method stub
		return vipMapper.getUserPosition(isActive);
	}

}
