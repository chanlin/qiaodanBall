package com.qiaodan.smartball.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qiaodan.smartball.common.Result;
import com.qiaodan.smartball.common.Status;
import com.qiaodan.smartball.model.sys_media;
import com.qiaodan.smartball.service.MediaServiceI;

@Controller
@RequestMapping("/mediaController")
public class MediaController {
	private static final Logger logger = Logger.getLogger(MediaController.class);
	private MediaServiceI mediaService;
	private static Result result = new Result();
	public MediaServiceI getMediaService() {
		return mediaService;
	}
	@Autowired
	public void setMediaService(MediaServiceI mediaService) {
		this.mediaService = mediaService;
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
	
	

}
