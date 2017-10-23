package com.qiaodan.smartball.model;

public class s_moveWithBLOBs extends s_move {
    protected String verJumpPoint;

    protected String trail;

    public String getVerJumpPoint() {
        return verJumpPoint;
    }

    public void setVerJumpPoint(String verJumpPoint) {
        this.verJumpPoint = verJumpPoint == null ? null : verJumpPoint.trim();
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail == null ? null : trail.trim();
    }
}