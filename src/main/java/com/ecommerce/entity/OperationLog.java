package com.ecommerce.entity;

import java.util.Date;

public class OperationLog {
    private Integer logId;
    private String operateUser;
    private Integer operateMemberId;
    private String operateType;
    private String operateIp;
    private Date operateTime;
    private String operateDesc;

    // Getter & Setter
    public Integer getLogId() { return logId; }
    public void setLogId(Integer logId) { this.logId = logId; }
    public String getOperateUser() { return operateUser; }
    public void setOperateUser(String operateUser) { this.operateUser = operateUser; }
    public Integer getOperateMemberId() { return operateMemberId; }
    public void setOperateMemberId(Integer operateMemberId) { this.operateMemberId = operateMemberId; }
    public String getOperateType() { return operateType; }
    public void setOperateType(String operateType) { this.operateType = operateType; }
    public String getOperateIp() { return operateIp; }
    public void setOperateIp(String operateIp) { this.operateIp = operateIp; }
    public Date getOperateTime() { return operateTime; }
    public void setOperateTime(Date operateTime) { this.operateTime = operateTime; }
    public String getOperateDesc() { return operateDesc; }
    public void setOperateDesc(String operateDesc) { this.operateDesc = operateDesc; }
}