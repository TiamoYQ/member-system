package com.ecommerce.service;

import com.ecommerce.entity.Member;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.mapper.MemberMapper;
import com.ecommerce.util.MD5Util;
import com.ecommerce.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

// 会员服务实现类（放在service包下）
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final PointsService pointsService;

    public MemberServiceImpl() {
        SqlSession session = MyBatisUtil.getSqlSession();
        this.memberMapper = session.getMapper(MemberMapper.class);
        // 直接实例化同包下的PointsServiceImpl，无需导入
        this.pointsService = new com.ecommerce.service.PointsServiceImpl();
    }

    @Override
    public boolean register(Member member) {
        // 用户名校验
        if (member.getUsername() == null || member.getUsername().length() < 3) {
            throw new BusinessException("用户名长度不能少于3位");
        }
        // 用户名重复校验
        if (memberMapper.selectByUsername(member.getUsername()) != null) {
            throw new BusinessException("用户名已存在");
        }
        // 密码加密
        member.setPassword(MD5Util.encrypt(member.getPassword()));
        member.setLevelId(1); // 初始普通会员
        member.setTotalPoints(0);
        member.setStatus(1); // 正常状态

        // 插入会员数据
        int rows = memberMapper.insert(member);
        // 注册送100积分（调用PointsService的addRecord方法）
        pointsService.addRecord(member.getMemberId(), 100, "注册", "新用户注册送积分");
        return rows > 0;
    }

    @Override
    public List<Member> getAll() {
        return memberMapper.selectAll();
    }

    @Override
    public Member getById(Integer memberId) {
        Member member = memberMapper.selectById(memberId);
        if (member == null) {
            throw new BusinessException("会员不存在");
        }
        return member;
    }

    @Override
    public boolean update(Member member) {
        return memberMapper.update(member) > 0;
    }

    @Override
    public boolean delete(Integer memberId) {
        return memberMapper.delete(memberId) > 0;
    }

    @Override
    public Member login(String phone, String password) {
        Member member = memberMapper.selectByPhone(phone);
        if (member == null) {
            throw new BusinessException("手机号未注册");
        }
        if (!MD5Util.encrypt(password).equals(member.getPassword())) {
            throw new BusinessException("密码错误");
        }
        return member;
    }
}