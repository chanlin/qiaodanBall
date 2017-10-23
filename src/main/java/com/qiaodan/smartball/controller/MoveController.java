package com.qiaodan.smartball.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Util;
import com.qiaodan.smartball.common.Result;
import com.qiaodan.smartball.common.Status;
import com.qiaodan.smartball.model.MoveData;
import com.qiaodan.smartball.model.Point;
import com.qiaodan.smartball.model.s_moveWithBLOBs;
import com.qiaodan.smartball.pullUtils.PullHex;
import com.qiaodan.smartball.pullUtils.Utils;
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
	public ModelAndView getMoveForUserMobile(@RequestParam String mobile){
		List<s_moveWithBLOBs> moves = new ArrayList<s_moveWithBLOBs>();
		if(mobile != null && !"".equals(mobile)){
			moves = moveService.getMoveListForUserMobile(mobile);
		}else{
			logger.warn("输入的手机号为空！");
		}
		List<MoveData> moveDatas = new ArrayList<MoveData>();
		for (s_moveWithBLOBs moveWithBLOBs : moves) {
			MoveData moveData = new MoveData();
			moveData.setCreateTime(moveWithBLOBs.getCreateTime());
			moveData.setVerJumpCount(moveWithBLOBs.getVerJumpCount());
			moveData.setVerJumpMaxHigh(moveWithBLOBs.getVerJumpMaxHigh());
			moveData.setVerJumpAvgHigh(moveWithBLOBs.getVerJumpAvgHigh());
			String jumpStr = moveWithBLOBs.getVerJumpPoint();
			String trailStr = moveWithBLOBs.getTrail();
			List<Point> xy = new ArrayList<Point>();
			List<Float> heights = new ArrayList<Float>();
			if (!Utils.isEmpty(trailStr)) {
				String[] trails = trailStr.split(",");
				for (String s : trails) {
					//7472616b1a04bf3fb44e1b3e0000403f3fdb2300
					float x = PullHex.byte2float(PullHex.hexStringToByte(s.substring(8, 16)),0);//x
					float y = PullHex.byte2float(PullHex.hexStringToByte(s.substring(16, 24)),0);//y
					Point p = new Point(x, y);
					xy.add(p);
				}
			}
			if (!Utils.isEmpty(jumpStr)) {
				String[] jumps = jumpStr.split(",");
				for (String jump : jumps) {
					float fheigh = PullHex.byte2float(PullHex.hexStringToByte(jump.substring(16, 24)), 0);
					heights.add(fheigh);
				}
			}
			moveData.setPoint(xy);
			moveData.setHeight(heights);
			moveDatas.add(moveData);
		}
		ModelAndView modelAndView = new ModelAndView();
		  //设置返回试图名称        
		
	      modelAndView.setViewName("moveDataView");
	      modelAndView.addObject("moveDatas",moveDatas);  
		return modelAndView;
		
	}
	

}
