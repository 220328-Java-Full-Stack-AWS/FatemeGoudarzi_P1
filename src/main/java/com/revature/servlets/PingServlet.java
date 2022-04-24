package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PingServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Pong!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        String pass ="All healthy!";
        resp.getWriter().print(pass);
    }
}
