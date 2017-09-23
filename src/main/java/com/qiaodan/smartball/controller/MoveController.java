package com.qiaodan.smartball.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiaodan.smartball.common.Result;
import com.qiaodan.smartball.common.Status;
import com.qiaodan.smartball.model.s_moveWithBLOBs;
import com.qiaodan.smartball.service.MoveServiceI;

@Controller
@RequestMapping("/moveController")
public class MoveController {
	private static final Logger logger = Logger.getLogger(MoveController.class);
	private MoveServiceI moveService;
	private static Result result = new Result();
	public MoveServiceI getMoveService() {
		return moveService;
	}
	@Autowired
	public void setMoveService(MoveServiceI moveService) {
		this.moveService = moveService;
	}
	
	
	@RequestMapping("/getMoveForUserMobile")
	@ResponseBody
	public Result getMoveForUserMobile(HttpServletRequest req){
		String mobile = req.getParameter("mobile");
		List<s_moveWithBLOBs> moves = new ArrayList<s_moveWithBLOBs>();
		if(mobile != null && !"".equals(mobile)){
			moves = moveService.getMoveListForUserMobile(mobile);
		}else{
			logger.warn("输入的手机号为空！");
		}
		result.setStatus(Status.SUCCESS_STATUS);
		result.setInfo(Status.SUCCESS_INFO);
		result.setData(moves);
		return result;
		
	}
	

}
