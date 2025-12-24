<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会员列表</title>
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin-top: 30px;">
    <h2>电商会员管理</h2>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>手机号</th>
            <th>会员等级</th>
            <th>积分</th>
            <th>注册渠道</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${members}" var="m">
            <tr>
                <td>${m.memberId}</td>
                <td>${m.username}</td>
                <td>${m.phone}</td>
                <td>${m.memberLevel.levelName}</td>
                <td>${m.totalPoints}</td>
                <td>${m.regChannel.channelName}</td>
                <td><a href="${pageContext.request.contextPath}/memberDetail?memberId=${m.memberId}" class="btn btn-sm btn-info">详情</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>