package com.ecommerce.mapper;

import com.ecommerce.entity.MemberLevel;
import java.util.List;

public interface MemberLevelMapper {
    List<MemberLevel> selectAll();
    MemberLevel selectById(Integer levelId);
    MemberLevel selectByPoints(Integer points);
}