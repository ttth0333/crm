package com.cybersoft.crm.api;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "memberApi", urlPatterns = {"/api/member"})
public class MemberApi extends HttpServlet {
}
