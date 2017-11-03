package com.qiaodan.smartball.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Util;
import com.qiaodan.smartball.common.Result;
import com.qiaodan.smartball.common.Status;
import com.qiaodan.smartball.model.s_move;
import com.qiaodan.smartball.model.s_moveWithBLOBs;
import com.qiaodan.smartball.model.sys_media;
import com.qiaodan.smartball.pullUtils.Utils;
import com.qiaodan.smartball.service.MediaServiceI;
import com.qiaodan.smartball.service.MoveServiceI;

@Controller
@RequestMapping("/mediaController")
@SessionAttributes({"personId","medias"}) 
public class MediaController {
	private static final Logger logger = Logger.getLogger(MediaController.class);
	private MediaServiceI mediaService;
	private MoveServiceI moveService;
	private static Result result = new Result();
	public MediaServiceI getMediaService() {
		return mediaService;
	}
	@Autowired
	public void setMediaService(MediaServiceI mediaService) {
		this.mediaService = mediaService;
	}
	
	public MoveServiceI getMoveService() {
		return moveService;
	}
	@Autowired
	public void setMoveService(MoveServiceI moveService) {
		this.moveService = moveService;
	}
	@RequestMapping(value="/getMediaListByMobile.do",method=RequestMethod.POST)
	public ModelAndView getMediaListByMobile(@PathVariable String mobile){
		
		//String mobile = req.getParameter("mobile");
		List<sys_media> medias = new ArrayList<sys_media>(); 
		if(mobile != null && !"".equals(mobile)){
			medias = mediaService.getMediaListByMobile(mobile); 
		}else{
			logger.warn("输入的手机号为空！");
		}
		result.setStatus(Status.SUCCESS_STATUS);
		result.setInfo(Status.SUCCESS_INFO);
		result.setData(medias);	
		ModelAndView model = new ModelAndView("/WEB-INF/jsp/showData.jsp");

		model.addObject("medias", medias);
		return model;
		
		
		
	}
	
	
	@RequestMapping("/getMedias.do")
	public ModelAndView getMediaListByMobile(HttpServletRequest req){
		
		String mobile = req.getParameter("mobile");
		List<sys_media> medias = new ArrayList<sys_media>(); 
		if(mobile != null && !"".equals(mobile)){
			medias = mediaService.getMediaListByMobile(mobile); 
		}else{
			logger.warn("输入的手机号为空！");
		}
		result.setStatus(Status.SUCCESS_STATUS);
		result.setInfo(Status.SUCCESS_INFO);
		result.setData(medias);	
		ModelAndView mav = new ModelAndView("getMediaListByMobile");  
		mav.addObject("personId", 12);  
		mav.addObject("medias",medias);  
		return mav;
	}
	
	@RequestMapping("/get.do")
	public ModelAndView  get(@RequestParam String mobile){
		
		//String mobile = req.getParameter("mobile");
		List<sys_media> medias = new ArrayList<sys_media>(); 
		if(mobile != null && !"".equals(mobile)){
			medias = mediaService.getMediaListByMobile(mobile); 
		}else{
			logger.warn("输入的手机号为空！");
		}
		result.setStatus(Status.SUCCESS_STATUS);
		result.setInfo(Status.SUCCESS_INFO);
		result.setData(medias);
		//medias.get(1).getFolder();
		
		ModelAndView modelAndView = new ModelAndView();
		  //设置返回试图名称        

        modelAndView.setViewName("getMediaListByMobile");
        modelAndView.addObject("personId", 12);  
        modelAndView.addObject("medias",medias);  
		return modelAndView;
	}
	@RequestMapping("/getMax.do")
	public ModelAndView  getMax(@RequestParam String mobile){
		
		//String mobile = req.getParameter("mobile");
		List<sys_media> medias = new ArrayList<sys_media>(); 
		List<s_moveWithBLOBs> moves = new ArrayList<s_moveWithBLOBs>();
		if(mobile != null && !"".equals(mobile)){
			moves = moveService.getMoveListForUserMobile(mobile);
		}else{
			logger.warn("输入的手机号为空！");
		}
		int perf_rank = 0;//本场表现
		int run_rank = 0;//跑动等级
		int break_rank = 0;//突破等级
		int bounce_rank = 0;//弹跳等级
		Date perfDate = null, runDate = null, breakDate = null, bounceDate = null;
		for (s_moveWithBLOBs move : moves) {
			String perf = move.getPerfRank();
			String run = move.getRunRank();
			String brea = move.getBreakRank();
			String bounce = move.getBounceRank();
			if(!Utils.isEmpty(perf)){
				try {
					if(perf_rank < Integer.parseInt(perf)){
						perf_rank = Integer.parseInt(perf);
						perfDate = move.getEndTime() == null ? perfDate : move.getEndTime();
					}
				} catch (Exception e) {
				}
			}
			if(!Utils.isEmpty(run)){
				try {
					 if(run_rank < Integer.parseInt(run)){
						 run_rank = Integer.parseInt(run);
						 runDate = move.getEndTime() == null ? runDate : move.getEndTime();
					}
				} catch (Exception e) {
				}
			}
			if(!Utils.isEmpty(brea)){
				try {
					if(break_rank < Integer.parseInt(brea)){
						break_rank = Integer.parseInt(brea);
						breakDate = move.getEndTime() == null ? breakDate : move.getEndTime();
					}
				} catch (Exception e) {
				}
			}
			if(!Utils.isEmpty(bounce)){
				try {
					 if(bounce_rank < Integer.parseInt(bounce)){
						 bounce_rank = Integer.parseInt(bounce);
						 bounceDate = move.getEndTime() == null ? bounceDate : move.getEndTime();
					}
				} catch (Exception e) {
				}
			}
		}
		sys_media perfMedia = mediaService.getMediaByTime(mobile,perfDate);
		perfMedia.setName("整场比赛最高分");
		sys_media runMedia = mediaService.getMediaByTime(mobile,runDate);
		sys_media breakMedia = mediaService.getMediaByTime(mobile, breakDate);
		breakMedia.setName("突破最高分");
		sys_media bounceMedia = mediaService.getMediaByTime(mobile, bounceDate);
		bounceMedia.setName("弹跳最高分");
		
		medias.add(perfMedia);
		medias.add(breakMedia);
		medias.add(bounceMedia);
		
		result.setStatus(Status.SUCCESS_STATUS);
		result.setInfo(Status.SUCCESS_INFO);
		result.setData(medias);
		//medias.get(1).getFolder();
		
		ModelAndView modelAndView = new ModelAndView();
		  //设置返回试图名称        

        modelAndView.setViewName("getMaxMediaByMobile");
        modelAndView.addObject("personId", mobile);  
        modelAndView.addObject("medias",medias);  
		return modelAndView;
	}
}
