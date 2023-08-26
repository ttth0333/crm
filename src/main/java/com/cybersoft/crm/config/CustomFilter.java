package com.cybersoft.crm.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Kiem tra filter");
//        Cho phép đi vào link client mong muốn

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response  = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
//        if(session.getAttribute("isLogin") != null && !session.getAttribute("isLogin").equals("")){
//            //Đã login
//            boolean isLogin = (boolean) session.getAttribute("isLogin");
//            if(isLogin){
//                //chuyển về page chỉ định
//                if(request.getServletPath().equals("/login")){
//                    //Nếu là trang login
//                    response.sendRedirect(request.getContextPath() + "/home");
//                }else{
//                    filterChain.doFilter(request,response);
//                }
//            }else{
//                //chuyển về page login
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//        }else{
//            //Chưa login
//            //Chuyển về page login
//            if(request.getServletPath().equals("/login")){
                //Nếu là trang login
                filterChain.doFilter(request,response);
//            }else{
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//        }
    }
}
