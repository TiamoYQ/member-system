package com.ecommerce.entity;

import java.util.Date;

public class RegChannel {
    private Integer channelId;
    private String channelName;
    private String channelDesc;
    private Date createTime;

    // Getter & Setter
    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }
    public String getChannelName() { return channelName; }
    public void setChannelName(String channelName) { this.channelName = channelName; }
    public String getChannelDesc() { return channelDesc; }
    public void setChannelDesc(String channelDesc) { this.channelDesc = channelDesc; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}