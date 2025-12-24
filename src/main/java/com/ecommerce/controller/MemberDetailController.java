package com.ecommerce.controller;

import com.ecommerce.service.MemberAddressService;
import com.ecommerce.service.MemberService;
import com.ecommerce.service.PointsService;
import com.ecommerce.service.impl.MemberAddressServiceImpl;
import com.ecommerce.service.MemberServiceImpl;
import com.ecommerce.service.impl.PointsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberDetail")
public class MemberDetailController extends HttpServlet {
    private final MemberService memberService = new MemberServiceImpl();
    private final MemberAddressService addressService = new MemberAddressServiceImpl();
    private final PointsService pointsService = new PointsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer memberId = Integer.parseInt(req.getParameter("memberId"));
        req.setAttribute("member", memberService.getById(memberId));
        req.setAttribute("addresses", addressService.getByMemberId(memberId));
        req.setAttribute("points", pointsService.getByMemberId(memberId));
        req.getRequestDispatcher("/memberDetail.jsp").forward(req, resp);
    }
}
