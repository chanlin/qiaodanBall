package com.qiaodan.smartball.model;

import java.util.Date;

public class s_move {
    private String id;

    private Date createTime;

    private String delFlag;

    private String vipId;

    private String sn;

    private String footer;

    private String longitude;

    private String latitude;

    private String address;

    private Date beginTime;

    private String spend;

    private String picture;

    private Date endTime;

    private String totalDist;

    private String totalStep;

    private String totalHorDist;

    private String totalVerDist;

    private String totalTime;

    private String totalActiveTime;

    private String activeRate;

    private String avgSpeed;

    private String maxSpeed;

    private String spurtCount;

    private String breakinCount;

    private String breakinAvgTime;

    private String verJumpCount;

    private String verJumpAvgHigh;

    private String verJumpMaxHigh;

    private String avgHoverTime;

    private String avgTouchAngle;

    private String touchType;

    private String perfRank;

    private String runRank;

    private String breakRank;

    private String bounceRank;

    private String avgShotDist;

    private String maxShotDist;

    private String maxWallup;

    private String avgWallup;

    private String handle;

    private String calorie;

    private String type;

    private String header;

    private String fieldType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId == null ? null : vipId.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer == null ? null : footer.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getSpend() {
        return spend;
    }

    public void setSpend(String spend) {
        this.spend = spend == null ? null : spend.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTotalDist() {
        return totalDist;
    }

    public void setTotalDist(String totalDist) {
        this.totalDist = totalDist == null ? null : totalDist.trim();
    }

    public String getTotalStep() {
        return totalStep;
    }

    public void setTotalStep(String totalStep) {
        this.totalStep = totalStep == null ? null : totalStep.trim();
    }

    public String getTotalHorDist() {
        return totalHorDist;
    }

    public void setTotalHorDist(String totalHorDist) {
        this.totalHorDist = totalHorDist == null ? null : totalHorDist.trim();
    }

    public String getTotalVerDist() {
        return totalVerDist;
    }

    public void setTotalVerDist(String totalVerDist) {
        this.totalVerDist = totalVerDist == null ? null : totalVerDist.trim();
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime == null ? null : totalTime.trim();
    }

    public String getTotalActiveTime() {
        return totalActiveTime;
    }

    public void setTotalActiveTime(String totalActiveTime) {
        this.totalActiveTime = totalActiveTime == null ? null : totalActiveTime.trim();
    }

    public String getActiveRate() {
        return activeRate;
    }

    public void setActiveRate(String activeRate) {
        this.activeRate = activeRate == null ? null : activeRate.trim();
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed == null ? null : avgSpeed.trim();
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed == null ? null : maxSpeed.trim();
    }

    public String getSpurtCount() {
        return spurtCount;
    }

    public void setSpurtCount(String spurtCount) {
        this.spurtCount = spurtCount == null ? null : spurtCount.trim();
    }

    public String getBreakinCount() {
        return breakinCount;
    }

    public void setBreakinCount(String breakinCount) {
        this.breakinCount = breakinCount == null ? null : breakinCount.trim();
    }

    public String getBreakinAvgTime() {
        return breakinAvgTime;
    }

    public void setBreakinAvgTime(String breakinAvgTime) {
        this.breakinAvgTime = breakinAvgTime == null ? null : breakinAvgTime.trim();
    }

    public String getVerJumpCount() {
        return verJumpCount;
    }

    public void setVerJumpCount(String verJumpCount) {
        this.verJumpCount = verJumpCount == null ? null : verJumpCount.trim();
    }

    public String getVerJumpAvgHigh() {
        return verJumpAvgHigh;
    }

    public void setVerJumpAvgHigh(String verJumpAvgHigh) {
        this.verJumpAvgHigh = verJumpAvgHigh == null ? null : verJumpAvgHigh.trim();
    }

    public String getVerJumpMaxHigh() {
        return verJumpMaxHigh;
    }

    public void setVerJumpMaxHigh(String verJumpMaxHigh) {
        this.verJumpMaxHigh = verJumpMaxHigh == null ? null : verJumpMaxHigh.trim();
    }

    public String getAvgHoverTime() {
        return avgHoverTime;
    }

    public void setAvgHoverTime(String avgHoverTime) {
        this.avgHoverTime = avgHoverTime == null ? null : avgHoverTime.trim();
    }

    public String getAvgTouchAngle() {
        return avgTouchAngle;
    }

    public void setAvgTouchAngle(String avgTouchAngle) {
        this.avgTouchAngle = avgTouchAngle == null ? null : avgTouchAngle.trim();
    }

    public String getTouchType() {
        return touchType;
    }

    public void setTouchType(String touchType) {
        this.touchType = touchType == null ? null : touchType.trim();
    }

    public String getPerfRank() {
        return perfRank;
    }

    public void setPerfRank(String perfRank) {
        this.perfRank = perfRank == null ? null : perfRank.trim();
    }

    public String getRunRank() {
        return runRank;
    }

    public void setRunRank(String runRank) {
        this.runRank = runRank == null ? null : runRank.trim();
    }

    public String getBreakRank() {
        return breakRank;
    }

    public void setBreakRank(String breakRank) {
        this.breakRank = breakRank == null ? null : breakRank.trim();
    }

    public String getBounceRank() {
        return bounceRank;
    }

    public void setBounceRank(String bounceRank) {
        this.bounceRank = bounceRank == null ? null : bounceRank.trim();
    }

    public String getAvgShotDist() {
        return avgShotDist;
    }

    public void setAvgShotDist(String avgShotDist) {
        this.avgShotDist = avgShotDist == null ? null : avgShotDist.trim();
    }

    public String getMaxShotDist() {
        return maxShotDist;
    }

    public void setMaxShotDist(String maxShotDist) {
        this.maxShotDist = maxShotDist == null ? null : maxShotDist.trim();
    }

    public String getMaxWallup() {
        return maxWallup;
    }

    public void setMaxWallup(String maxWallup) {
        this.maxWallup = maxWallup == null ? null : maxWallup.trim();
    }

    public String getAvgWallup() {
        return avgWallup;
    }

    public void setAvgWallup(String avgWallup) {
        this.avgWallup = avgWallup == null ? null : avgWallup.trim();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie == null ? null : calorie.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }
}