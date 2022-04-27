package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementModel;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementServiceServlet extends HttpServlet {
    private ReimbursementService rs;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("hi. I'm inside of reimbursement servlet initializer!");
        this.rs = new ReimbursementService();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setStatus(200);
         try{
             List model = rs.getAllReimbursements();
             String json = mapper.writeValueAsString(model);
             resp.getWriter().print(json);
         }catch (SQLException e) {
             e.printStackTrace();
         }

    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List model = rs.getReimbursementsByStatusById(req.getHeader("status"), Integer.parseInt(req.getHeader( "creator_id")));
//        String json = mapper.writeValueAsString(model);
//        resp.setContentType("application/json");
//        resp.getWriter().print(json);
//        resp.setStatus(200);
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("Inside Post");
            ReimbursementModel model = mapper.readValue(req.getInputStream(), ReimbursementModel.class);
        try {
            model = rs.createReimbursement(model);
            String json = mapper.writeValueAsString(model);
            System.out.println(json);
            resp.getWriter().print(json);
            resp.setStatus(201);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside Post");
        ReimbursementModel model = mapper.readValue(req.getInputStream(), ReimbursementModel.class);
        try {
            model = rs.updateReimbursement(model);
            String json = mapper.writeValueAsString(model);
            resp.getWriter().print(json);
            resp.setStatus(201);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
