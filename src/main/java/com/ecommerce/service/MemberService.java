package com.ecommerce.service;

import com.ecommerce.entity.Member;
import java.util.List;

public interface MemberService {
    boolean register(Member member);
    List<Member> getAll();
    Member getById(Integer memberId);
    boolean update(Member member);
    boolean delete(Integer memberId);
    Member login(String phone, String password);
}