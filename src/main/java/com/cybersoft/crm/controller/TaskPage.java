package com.cybersoft.crm.controller;

import com.cybersoft.crm.payload.ResponseData;
import com.cybersoft.crm.service.TaskService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "taskPage", urlPatterns = {"/task"})
public class TaskPage extends HttpServlet
{
    private TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("task", taskService.getAllTasks());
        req.getRequestDispatcher("/task.jsp").forward(req, resp);
    }
}
