package com.ecommerce.service;

import com.ecommerce.entity.MemberAddress;
import java.util.List;

public interface MemberAddressService {
    boolean add(MemberAddress address);
    List<MemberAddress> getByMemberId(Integer memberId);
    boolean update(MemberAddress address);
    boolean setDefault(Integer addressId, Integer memberId);
    boolean delete(Integer addressId);
}