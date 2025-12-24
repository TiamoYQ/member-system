package com.ecommerce.controller;


import com.ecommerce.service.MemberService;
import com.ecommerce.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberList")
public class MemberListController extends HttpServlet {
    private final MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("members", memberService.getAll());
        req.getRequestDispatcher("/memberList.jsp").forward(req, resp);
    }
}