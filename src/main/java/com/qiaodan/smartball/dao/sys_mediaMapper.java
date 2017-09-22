package com.qiaodan.smartball.dao;

import com.qiaodan.smartball.model.sys_media;

public interface sys_mediaMapper {
    int deleteByPrimaryKey(String id);

    int insert(sys_media record);

    int insertSelective(sys_media record);

    sys_media selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sys_media record);

    int updateByPrimaryKey(sys_media record);
}