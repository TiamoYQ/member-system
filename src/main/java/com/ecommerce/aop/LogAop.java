package com.ecommerce.aop;

import com.ecommerce.entity.OperationLog;
import com.ecommerce.mapper.OperationLogMapper;
import com.ecommerce.util.IpUtil;
import com.ecommerce.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;

public class LogAop {
    public static void recordLog(String operateUser, Integer memberId, String type, HttpServletRequest request, String desc) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            OperationLogMapper mapper = session.getMapper(OperationLogMapper.class);
            OperationLog log = new OperationLog();
            log.setOperateUser(operateUser);
            log.setOperateMemberId(memberId);
            log.setOperateType(type);
            log.setOperateIp(IpUtil.getIp(request));
            log.setOperateDesc(desc);
            mapper.insert(log);
        }
    }
}