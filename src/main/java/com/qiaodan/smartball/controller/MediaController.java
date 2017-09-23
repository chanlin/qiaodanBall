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
	@RequestMapping("/getMediaListByMobile")
	public Result getMediaListByMobile(HttpServletRequest req){
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
		return result;
		
		
		
	}
	
	

}
