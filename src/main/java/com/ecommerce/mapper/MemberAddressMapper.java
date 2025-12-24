package com.ecommerce.mapper;

import com.ecommerce.entity.MemberAddress;
import java.util.List;

public interface MemberAddressMapper {
    int insert(MemberAddress address);
    List<MemberAddress> selectByMemberId(Integer memberId);
    int update(MemberAddress address);
    int setDefault(Integer addressId, Integer memberId);
    int delete(Integer addressId);
}