package com.revature.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserModel;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServiceServlet extends HttpServlet {
    private UserService us;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("hi inside userserviceservlet");
        this.us = new UserService();
        this.mapper = new ObjectMapper();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         resp.setStatus(200);
//         List model = us.getAllUserNames();
//         String json = mapper.writeValueAsString(model);
//         resp.getWriter().print(json);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = new UserModel();
        model.setUserName(req.getHeader("userName"));
        model.setPassWord(req.getHeader("passWord"));
        model= us.read(model);
        String json = mapper.writeValueAsString(model);
        resp.setContentType("application/json");
        resp.getWriter().print(json);
        System.out.println(model);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(201);
        UserModel model = mapper.readValue(req.getInputStream() , UserModel.class);
        model = us.createAccount(model);
        String json = mapper.writeValueAsString(model);
        resp.getWriter().print(json);
    }
}
