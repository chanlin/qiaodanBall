package com.qiaodan.smartball.service;

import java.util.List;

import com.qiaodan.smartball.model.s_moveWithBLOBs;

public interface MoveServiceI {
	public List<s_moveWithBLOBs> getMoveListForUserMobile(String mobile);

	public List<s_moveWithBLOBs> getMoveListForUserMobileAndTime(String mobile,String timeLike);

}
