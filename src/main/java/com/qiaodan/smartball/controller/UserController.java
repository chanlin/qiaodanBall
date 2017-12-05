package com.qiaodan.smartball.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiaodan.smartball.model.UserAges;
import com.qiaodan.smartball.model.UserData;
import com.qiaodan.smartball.model.UserMoveData;
import com.qiaodan.smartball.model.u_vip;
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
	public List<UserAges> getUserAges(HttpServletRequest req, HttpServletResponse rep){
		//String beginTime = req.getParameter("beginTime");
		//String endTime = req.getParameter("endTime");
		List<UserAges> userAges= new ArrayList<UserAges>();
		/*if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserDataForTime(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}*/
		userAges = userService.getUserAges(false);
		return getUserAgesModel(userAges);
		
	}
	@RequestMapping(value="/getActiveUserAges.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserAges> getActiveUserAges(HttpServletRequest req, HttpServletResponse rep){
		//String beginTime = req.getParameter("beginTime");
		//String endTime = req.getParameter("endTime");
		List<UserAges> userAges= new ArrayList<UserAges>();
		/*if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserDataForTime(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}*/
		userAges = userService.getUserAges(true);
		return getUserAgesModel(userAges);
		
	}
	
	
	private List<UserAges> getUserAgesModel(List<UserAges> userAges){
		int sum = 0;
		for (UserAges user : userAges) {
			sum += Integer.parseInt(user.getUserCount());
			
		}
		List<UserAges> newUserAges = new ArrayList<UserAges>();
		for (int i = 0; i< userAges.size();i++) {
			UserAges agesIndex = userAges.get(i);
			switch(Integer.parseInt(agesIndex.getAges())){
				case 0:
					agesIndex.setAges("其他");
					break;
				case 1:	
					agesIndex.setAges("0-12");
					break;
				case 2:
					agesIndex.setAges("13-20");
					break;
				case 3:
					agesIndex.setAges("21-30");
					break;
				case 4:
					agesIndex.setAges("21-30");
					break;
				case 5:
					agesIndex.setAges(">=40");
					break;
					
			}
			Double e = Double.parseDouble(agesIndex.getUserCount())/sum *100;
			DecimalFormat df = new DecimalFormat("0.00");  
			agesIndex.setUserCount(df.format(e));
			newUserAges.add(agesIndex);
		}
		
		logger.info(newUserAges);
		return newUserAges;
	}
	
	
	
	
	@RequestMapping(value="/getUserPosition.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserAges> getUserPosition(HttpServletRequest req, HttpServletResponse rep){
		String isActive = req.getParameter("isActive");
		List<UserAges> userAges= new ArrayList<UserAges>();
		if(isActive == null || "".equals(isActive)){
			userAges = userService.getUserPosition(true);
		}else{
			userAges = userService.getUserPosition(false);
		}
		
		int sum = 0;
		List<UserAges> newUserAges = new ArrayList<UserAges>();
		for(UserAges user : userAges){
			if(user.getAges() == null || "".equals(user.getAges())){
				//userAges.remove(user);
			}else{
			
				sum += Integer.parseInt(user.getUserCount());
				newUserAges.add(user);
			}
		}
		for(int i = 0; i<newUserAges.size();i++){
			Double temp = Double.parseDouble(newUserAges.get(i).getUserCount());
			Double e = temp/sum *100;
			DecimalFormat df = new DecimalFormat("0.00");  
			newUserAges.get(i).setUserCount(df.format(e));
		}
		return newUserAges;
		
	}
	
	
	/**
	 * 根据时间段 查询运动的数据
	* @Title: getUserMoveData 
	* @Description: TODO 
	* @param req
	* @param rep
	* @return     
	* @return List<u_vip>     
	* @throws
	 */
	@RequestMapping(value="/getUserMoveData.do",method=RequestMethod.GET)
	@ResponseBody
	public List<UserMoveData> getUserMoveData(HttpServletRequest req, HttpServletResponse rep){
		String beginTime = req.getParameter("beginTime");
		String endTime = req.getParameter("endTime");
		List<UserMoveData> userDatas = new ArrayList<UserMoveData>();
		if(beginTime != null && !"".equals(beginTime)
				&& endTime != null && !"".equals(endTime)){
			userDatas = userService.getUserMoveData(beginTime, endTime);
		}else{
			logger.warn("传入的参数为空哦！");
		}
		logger.info(userDatas);
		
		return userDatas;
		
	}
}
