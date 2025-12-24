package com.ecommerce.service.impl;

import com.ecommerce.entity.MemberAddress;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.mapper.MemberAddressMapper;
import com.ecommerce.service.MemberAddressService;
import com.ecommerce.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MemberAddressServiceImpl implements MemberAddressService {
    private final MemberAddressMapper addressMapper;

    public MemberAddressServiceImpl() {
        SqlSession session = MyBatisUtil.getSqlSession();
        this.addressMapper = session.getMapper(MemberAddressMapper.class);
    }

    @Override
    public boolean add(MemberAddress address) {
        if (address.getMemberId() == null) throw new BusinessException("会员ID不能为空");
        return addressMapper.insert(address) > 0;
    }

    @Override
    public List<MemberAddress> getByMemberId(Integer memberId) {
        return addressMapper.selectByMemberId(memberId);
    }

    @Override
    public boolean update(MemberAddress address) {
        return addressMapper.update(address) > 0;
    }

    @Override
    public boolean setDefault(Integer addressId, Integer memberId) {
        return addressMapper.setDefault(addressId, memberId) > 0;
    }

    @Override
    public boolean delete(Integer addressId) {
        return addressMapper.delete(addressId) > 0;
    }
}