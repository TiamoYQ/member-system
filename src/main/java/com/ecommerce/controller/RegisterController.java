package com.ecommerce.controller;

import com.ecommerce.aop.LogAop;
import com.ecommerce.entity.Member;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.service.MemberService;
import com.ecommerce.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private final MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        Integer channelId = Integer.parseInt(req.getParameter("channelId"));

        try {
            Member member = new Member();
            member.setUsername(username);
            member.setPassword(password);
            member.setPhone(phone);
            member.setEmail(email);
            member.setChannelId(channelId);
            // 注册
            memberService.register(member);
            // 记录日志
            LogAop.recordLog(username, member.getMemberId(), "注册", req, "用户" + username + "注册成功");
            // 跳转列表
            resp.sendRedirect(req.getContextPath() + "/memberList");
        } catch (BusinessException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}