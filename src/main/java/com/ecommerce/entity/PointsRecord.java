package com.ecommerce.entity;

import java.util.Date;

public class PointsRecord {
    private Integer recordId;
    private Integer memberId;
    private Integer points;
    private String bizType;
    private String bizId;
    private Date createTime;
    private String remark;

    // Getter & Setter
    public Integer getRecordId() { return recordId; }
    public void setRecordId(Integer recordId) { this.recordId = recordId; }
    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    public String getBizType() { return bizType; }
    public void setBizType(String bizType) { this.bizType = bizType; }
    public String getBizId() { return bizId; }
    public void setBizId(String bizId) { this.bizId = bizId; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}