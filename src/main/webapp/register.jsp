<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会员注册</title>
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin-top: 50px; width: 500px;">
    <h2 class="text-center">电商会员注册</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="form-group">
            <label>用户名</label>
            <input type="text" name="username" class="form-control" required minlength="3">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input type="password" name="password" class="form-control" required minlength="6">
        </div>
        <div class="form-group">
            <label>手机号</label>
            <input type="tel" name="phone" class="form-control" required>
        </div>
        <div class="form-group">
            <label>邮箱</label>
            <input type="email" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label>注册渠道</label>
            <select name="channelId" class="form-control" required>
                <option value="1">网页端</option>
                <option value="2">手机APP</option>
                <option value="3">微信小程序</option>
                <option value="4">公众号</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary btn-block">注册</button>
        <c:if test="${not empty error}">
            <div class="text-danger text-center" style="margin-top: 10px;">${error}</div>
        </c:if>
    </form>
</div>
</body>
</html>