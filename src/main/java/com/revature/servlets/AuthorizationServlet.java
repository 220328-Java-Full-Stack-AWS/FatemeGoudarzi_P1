package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mis.LoginRegisterErrors;
import com.revature.models.UserModel;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthorizationServlet extends HttpServlet {
        private AuthService authService;
        private UserService userService;
        private ObjectMapper mapper;

        @Override
        public void init() throws ServletException {
            this.authService = new AuthService();
            this.userService = new UserService();
            this.mapper = new ObjectMapper();
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserModel model = mapper.readValue(req.getInputStream(), UserModel.class);
            UserModel outputModel = new UserModel();
            switch(req.getHeader("mode")) {
                case "register":
                    outputModel = userService.createAccount(model);
                    String json = mapper.writeValueAsString(outputModel);
                    resp.getWriter().print(json);
                    resp.setHeader("access-control-expose-headers", "authToken");
                    resp.setHeader("authToken", outputModel.getUserName());        
                    resp.setStatus(201);
                    break;
                case "login":
                        UserModel loginResponse = authService.login(model);
                        if(loginResponse.getUserId() > 0) {
                            String loginJson = mapper.writeValueAsString(authService.mapToAuthResponse(loginResponse));
                            resp.setStatus(200);
                            resp.getWriter().print(loginJson);
                            System.out.println(String.valueOf(loginResponse.getUserId()));
                            resp.setHeader("access-control-expose-headers", "authToken");
                            resp.setHeader("authToken", loginResponse.getUserName());

                        } else {
                            String loginErrorJson = mapper.writeValueAsString(new LoginRegisterErrors("Username or password is wrong!"));
                            System.out.println(loginErrorJson);
                            resp.getWriter().print(loginErrorJson);
                            resp.setStatus(401);
                        }
                    break;
                default:
                    resp.setStatus(400);
                    break;
            }
        }

    }

