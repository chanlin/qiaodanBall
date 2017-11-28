package com.qiaodan.smartball.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiaodan.smartball.model.UserData;
import com.qiaodan.smartball.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {
	private static final Logger logger = Logger.getLogger(MediaController.class);
	private UserServiceI userService;
	
	 
	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}


	@RequestMapping(value="/selectTableOfUser.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserData> getUserData(HttpServletRequest req, HttpServletResponse rep){
		//String beginTime = req.getParameter("beginTime");
		//String endTime = req.getParameter("endTime");
		List<UserData> userDatas = new ArrayList<UserData>();
		/*if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserDataForTime(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}*/
		userDatas = userService.getUserData();
		logger.info(userDatas);
		
		return userDatas;
		
	}
	
	
	@RequestMapping(value="/selectTableOfActiveUser.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserData> selectTableOfActiveUser(HttpServletRequest req, HttpServletResponse rep){
		//String beginTime = req.getParameter("beginTime");
		//String endTime = req.getParameter("endTime");
		List<UserData> userDatas = new ArrayList<UserData>();
		/*if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserDataForTime(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}*/
		userDatas = userService.selectTableOfActiveUser();
		logger.info(userDatas);
		
		return userDatas;
		
	}
	@RequestMapping(value="/getUserAges.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserData> getUserAges(HttpServletRequest req, HttpServletResponse rep){
		//String beginTime = req.getParameter("beginTime");
		//String endTime = req.getParameter("endTime");
		List<UserData> userDatas = new ArrayList<UserData>();
		/*if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserDataForTime(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}*/
		userDatas = userService.getUserAges();
		logger.info(userDatas);
		
		return userDatas;
		
	}
	
	
}
