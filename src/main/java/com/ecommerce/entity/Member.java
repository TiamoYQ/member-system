package com.ecommerce.entity;

import java.util.Date;

public class Member {
    private Integer memberId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer channelId;
    private Integer levelId;
    private Integer totalPoints;
    private Date regTime;
    private Date updateTime;
    private Integer status;

    // 关联属性（用于页面展示）
    private RegChannel regChannel;
    private MemberLevel memberLevel;

    // Getter & Setter
    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }
    public Integer getLevelId() { return levelId; }
    public void setLevelId(Integer levelId) { this.levelId = levelId; }
    public Integer getTotalPoints() { return totalPoints; }
    public void setTotalPoints(Integer totalPoints) { this.totalPoints = totalPoints; }
    public Date getRegTime() { return regTime; }
    public void setRegTime(Date regTime) { this.regTime = regTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public RegChannel getRegChannel() { return regChannel; }
    public void setRegChannel(RegChannel regChannel) { this.regChannel = regChannel; }
    public MemberLevel getMemberLevel() { return memberLevel; }
    public void setMemberLevel(MemberLevel memberLevel) { this.memberLevel = memberLevel; }
}