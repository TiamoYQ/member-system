package com.ecommerce.service;

import com.ecommerce.entity.PointsRecord;
import java.util.List;

public interface PointsService {
    boolean addRecord(Integer memberId, Integer points, String bizType, String remark);
    List<PointsRecord> getByMemberId(Integer memberId);
}