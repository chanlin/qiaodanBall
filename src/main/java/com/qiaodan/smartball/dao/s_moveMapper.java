package com.qiaodan.smartball.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiaodan.smartball.model.s_move;
import com.qiaodan.smartball.model.s_moveWithBLOBs;

public interface s_moveMapper {
    int deleteByPrimaryKey(String id);

    int insert(s_moveWithBLOBs record);

    int insertSelective(s_moveWithBLOBs record);

    s_moveWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(s_moveWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(s_moveWithBLOBs record);

    int updateByPrimaryKey(s_move record);

	List<s_moveWithBLOBs> getMoveForUserMobile(String mobile);

	List<s_moveWithBLOBs> getMoveListForUserMobileAndTime(@Param("mobile")String mobile,@Param("timeLike")String timeLike);
}