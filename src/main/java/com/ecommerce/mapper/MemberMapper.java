package com.ecommerce.mapper;

import com.ecommerce.entity.Member;
import java.util.List;

public interface MemberMapper {
    int insert(Member member);
    List<Member> selectAll();
    Member selectById(Integer memberId);
    Member selectByUsername(String username);
    Member selectByPhone(String phone);
    int update(Member member);
    int delete(Integer memberId);
}