package com.qiaodan.smartball.model;

public class s_moveWithBLOBs extends s_move {
    private String verJumpPoint;

    private String trail;

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