package com.ecommerce.mapper;

import com.ecommerce.entity.PointsRecord;
import java.util.List;

public interface PointsRecordMapper {
    int insert(PointsRecord record);
    List<PointsRecord> selectByMemberId(Integer memberId);
}