<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会员详情</title>
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin-top: 30px;">
    <h2>会员详情：${member.username}</h2>
    <div class="panel panel-default">
        <div class="panel-heading">基本信息</div>
        <div class="panel-body">
            <p>手机号：${member.phone}</p>
            <p>邮箱：${member.email}</p>
            <p>会员等级：${member.memberLevel.levelName}</p>
            <p>积分：${member.totalPoints}</p>
            <p>注册时间：${member.regTime}</p>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">收货地址</div>
        <div class="panel-body">
            <c:forEach items="${addresses}" var="addr">
                <p>${addr.province}${addr.city}${addr.district}${addr.detailAddress}（${addr.receiver} ${addr.phone}）
                    <c:if test="${addr.isDefault == 1}">[默认]</c:if>
                </p>
            </c:forEach>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">积分记录</div>
        <div class="panel-body">
            <table class="table table-sm">
                <tr>
                    <th>变动值</th>
                    <th>业务类型</th>
                    <th>时间</th>
                    <th>备注</th>
                </tr>
                <c:forEach items="${points}" var="p">
                    <tr>
                        <td>${p.points}</td>
                        <td>${p.bizType}</td>
                        <td>${p.createTime}</td>
                        <td>${p.remark}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>