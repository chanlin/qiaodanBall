package com.qiaodan.smartball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaodan.smartball.dao.s_moveMapper;
import com.qiaodan.smartball.model.s_moveWithBLOBs;

@Service("moveService")
public class MoveServiceImpl implements MoveServiceI{

	private s_moveMapper moveMapper;
	
	public s_moveMapper getMoveMapper() {
		return moveMapper;
	}
	@Autowired
	public void setMoveMapper(s_moveMapper moveMapper) {
		this.moveMapper = moveMapper;
	}

	public List<s_moveWithBLOBs> getMoveListForUserMobile(String mobile) {
		List<s_moveWithBLOBs> moves = moveMapper.getMoveForUserMobile(mobile);
		return moves;
	}
	public List<s_moveWithBLOBs> getMoveListForUserMobileAndTime(String mobile, String timeLike) {
		return moveMapper.getMoveListForUserMobileAndTime(mobile,timeLike);
	}

}
