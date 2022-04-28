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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         try{
             String creatorId = req.getHeader("creator_id");
             List model= creatorId == null ?
                     rs.getAllReimbursements() :
                     rs.getReimbursementsByCreatorById(Integer.parseInt(creatorId));
             String json = mapper.writeValueAsString(model);
             resp.getWriter().print(json);
             resp.setStatus(200);
         }catch (SQLException e) {
             e.printStackTrace();
             resp.setStatus(400);
         }
    }

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
            resp.setStatus(400);

        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside Put");
        ReimbursementModel model = mapper.readValue(req.getInputStream(), ReimbursementModel.class);
        System.out.println(model);

        try {
            model = rs.updateReimbursement(model);
            String json = mapper.writeValueAsString(model);
            resp.getWriter().print(json);
            resp.setStatus(201);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(400);

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reimbursementId = req.getHeader("reimbursement_id");

        try {
            rs.deleteReimbursements(Integer.parseInt(reimbursementId));
            resp.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(400);
        }
    }
}
