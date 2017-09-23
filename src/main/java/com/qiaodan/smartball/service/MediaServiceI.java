package com.qiaodan.smartball.service;

import java.util.List;

import com.qiaodan.smartball.model.s_train_save;
import com.qiaodan.smartball.model.sys_media;

public interface MediaServiceI {
	public List<sys_media> getMediaListByMobile(String mobile);

}
