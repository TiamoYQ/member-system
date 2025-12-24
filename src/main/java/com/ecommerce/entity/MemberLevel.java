package com.ecommerce.entity;

import java.math.BigDecimal;

public class MemberLevel {
    private Integer levelId;
    private String levelName;
    private Integer minPoints;
    private Integer maxPoints;
    private BigDecimal discount;
    private String levelDesc;

    // Getter & Setter
    public Integer getLevelId() { return levelId; }
    public void setLevelId(Integer levelId) { this.levelId = levelId; }
    public String getLevelName() { return levelName; }
    public void setLevelName(String levelName) { this.levelName = levelName; }
    public Integer getMinPoints() { return minPoints; }
    public void setMinPoints(Integer minPoints) { this.minPoints = minPoints; }
    public Integer getMaxPoints() { return maxPoints; }
    public void setMaxPoints(Integer maxPoints) { this.maxPoints = maxPoints; }
    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }
    public String getLevelDesc() { return levelDesc; }
    public void setLevelDesc(String levelDesc) { this.levelDesc = levelDesc; }
}