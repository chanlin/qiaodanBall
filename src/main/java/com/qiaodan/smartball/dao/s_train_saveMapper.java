package com.qiaodan.smartball.dao;

import com.qiaodan.smartball.model.s_train_save;

public interface s_train_saveMapper {
    int deleteByPrimaryKey(String id);

    int insert(s_train_save record);

    int insertSelective(s_train_save record);

    s_train_save selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(s_train_save record);

    int updateByPrimaryKey(s_train_save record);
}