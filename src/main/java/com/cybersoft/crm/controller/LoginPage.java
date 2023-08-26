package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginPage", urlPatterns = {"/login"})
public class LoginPage extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        Khai báo một cookie tên là email
//        Cookie cookie = new Cookie("email",email);
//        cookie.setMaxAge(5 * 60);
//        resp.addCookie(cookie);
//
//        Cookie cookie1 = new Cookie("password",password);
//        cookie1.setMaxAge(5 * 60);
//        resp.addCookie(cookie1);

//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println("Name cookie " + cookie.getName() + " - Value " + cookie.getValue());
//        }

//        Yêu cầu sử dụng session


        boolean isLogin = loginService.checkLogin(email,password);

        if(isLogin){
            HttpSession session = req.getSession();
            session.setAttribute("isLogin",true);
            session.setMaxInactiveInterval(8 * 60);
        }

        System.out.println("Kiem tra " + isLogin);

        req.getRequestDispatcher("/login.html").forward(req,resp);
    }
}
