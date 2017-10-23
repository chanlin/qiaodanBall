package com.qiaodan.smartball.model;

import java.util.List;

public class MoveData extends s_moveWithBLOBs {
	List<Point> point;
	List<Float> height;
	public List<Point> getPoint() {
		return point;
	}
	public void setPoint(List<Point> point) {
		this.point = point;
	}
	public List<Float> getHeight() {
		return height;
	}
	public void setHeight(List<Float> height) {
		this.height = height;
	}
	
	
	

}
