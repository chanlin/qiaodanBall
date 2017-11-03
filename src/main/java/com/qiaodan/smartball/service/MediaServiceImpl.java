package com.qiaodan.smartball.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaodan.smartball.dao.sys_mediaMapper;
import com.qiaodan.smartball.model.sys_media;

@Service("mediaService")
public class MediaServiceImpl implements MediaServiceI {
	private sys_mediaMapper mediaMapper;

	
	public sys_mediaMapper getMediaMapper() {
		return mediaMapper;
	}

	@Autowired
	public void setMediaMapper(sys_mediaMapper mediaMapper) {
		this.mediaMapper = mediaMapper;
	}


	public List<sys_media> getMediaListByMobile(String mobile) {
		List<sys_media> medias = mediaMapper.getMediaListByMobile(mobile);
		return medias;
	}

	public sys_media getMediaByTime(String mobile, Date beginTime) {
		// TODO Auto-generated method stub
		return mediaMapper.getMediaByTime(mobile, beginTime);
	}

}
