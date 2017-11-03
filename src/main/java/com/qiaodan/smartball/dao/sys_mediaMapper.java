package com.qiaodan.smartball.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiaodan.smartball.model.sys_media;

public interface sys_mediaMapper {
    int deleteByPrimaryKey(String id);

    int insert(sys_media record);

    int insertSelective(sys_media record);

    sys_media selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sys_media record);

    int updateByPrimaryKey(sys_media record);
    List<sys_media> getMediaListByMobile(String mobile);

	sys_media getMediaByTime(@Param("mobile")String mobile,@Param("beginTime")Date beginTime);
}