package com.qiaodan.smartball.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiaodan.smartball.model.UserData;
import com.qiaodan.smartball.model.u_vip;

public interface u_vipMapper {
    int deleteByPrimaryKey(String id);

    int insert(u_vip record);

    int insertSelective(u_vip record);

    u_vip selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(u_vip record);

    int updateByPrimaryKey(u_vip record);
    List<UserData> getUserData();

	List<UserData> getUserDataForTime(@Param("beginTime")String beginTime, @Param("endTime")String endTime);

	List<UserData> selectTableOfActiveUser();

	List<UserData> getUserAges();
}