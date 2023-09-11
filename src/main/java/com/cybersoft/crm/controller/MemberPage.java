package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberPage", urlPatterns = {"/member"})
public class MemberPage extends HttpServlet {
    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("members", memberService.getAllMembers());
        req.getRequestDispatcher("/user-table.jsp").forward(req, resp);
    }
}
