package com.ecommerce.service.impl;

import com.ecommerce.entity.Member;
import com.ecommerce.entity.MemberLevel;
import com.ecommerce.entity.PointsRecord;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.mapper.MemberLevelMapper;
import com.ecommerce.mapper.MemberMapper;
import com.ecommerce.mapper.PointsRecordMapper;
import com.ecommerce.service.PointsService;
import com.ecommerce.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PointsServiceImpl implements PointsService {
    private final PointsRecordMapper pointsMapper;
    private final MemberMapper memberMapper;
    private final MemberLevelMapper levelMapper;

    public PointsServiceImpl() {
        SqlSession session = MyBatisUtil.getSqlSession();
        this.pointsMapper = session.getMapper(PointsRecordMapper.class);
        this.memberMapper = session.getMapper(MemberMapper.class);
        this.levelMapper = session.getMapper(MemberLevelMapper.class);
    }

    @Override
    public boolean addRecord(Integer memberId, Integer points, String bizType, String remark) {
        Member member = memberMapper.selectById(memberId);
        if (member == null) throw new BusinessException("会员不存在");
        // 计算新积分
        int newPoints = member.getTotalPoints() + points;
        if (newPoints < 0) throw new BusinessException("积分不足");
        // 更新会员积分和等级
        MemberLevel newLevel = levelMapper.selectByPoints(newPoints);
        member.setTotalPoints(newPoints);
        member.setLevelId(newLevel.getLevelId());
        memberMapper.update(member);
        // 插入积分记录
        PointsRecord record = new PointsRecord();
        record.setMemberId(memberId);
        record.setPoints(points);
        record.setBizType(bizType);
        record.setRemark(remark);
        return pointsMapper.insert(record) > 0;
    }

    @Override
    public List<PointsRecord> getByMemberId(Integer memberId) {
        return pointsMapper.selectByMemberId(memberId);
    }
}