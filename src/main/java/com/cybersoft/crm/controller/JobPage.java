package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JobPage", urlPatterns = {"/job"})
public class JobPage extends HttpServlet {
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("jobs", jobService.getAllJobs());
        req.getRequestDispatcher("/groupwork.jsp").forward(req, resp);
    }
}
