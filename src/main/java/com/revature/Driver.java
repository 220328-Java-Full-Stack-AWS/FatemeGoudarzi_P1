package com.revature;


import com.revature.models.ReimbursementModel;
import com.revature.services.ReimbursementService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Driver {

    public static void main(String[] args) {


//
//        //Create an account
//        UserService us1 = new UserService();
//        System.out.println(us1.createAccount());

        //Get the list of all users
//        UserService us2 = new UserService();
//        System.out.println(us2.getAllUserNames());

        //Retrive a username
//        UserDAO user = new UserDAO();
//        UserModel model = new UserModel( "ff3","ff4");
//        System.out.println(user.read(model));

//
//        //Login
//        UserService us3 = new UserService();
//        AuthService authService  = new AuthService();
//        UserModel outputModel  = new UserModel();
//        UserModel model  = new UserModel("SaraSmith","superStrong");
//        outputModel = us3.read(model);
//        System.out.println(outputModel);

        //Make a new request
        ReimbursementModel rm = new ReimbursementModel();
        ReimbursementService rs= new ReimbursementService();
        Timestamp currentMoment = new Timestamp(System.currentTimeMillis());
        rm.setCreationDate(currentMoment);
        rm.setReimbursementDescription("description");
        rm.setReimbursementTypeId(201);
        rm.setReimbursementCreator(24);
        rm.setReimbursementAmount(BigDecimal.valueOf(100));
        try {
            System.out.println(rs.createReimbursement(rm));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Approve a request
//        ReimbursementService rs = new ReimbursementService();
//        System.out.println(rs.update());

        //Get a list of all requests
//          RequestDAO rs = new RequestDAO();
//          System.out.println(rs.getAll());

        //Get a list of approved requests
//        RequestDAO rs = new RequestDAO();
//        System.out.println(rs.getAll("Approved"));


        //Get a list of approved requests
//        ReimbursementService rs = new ReimbursementService();
//        System.out.println(rs.getReimbursementsByStatusById("Approve" ,1));

//        System.out.println("Enter username:");
//        Scanner sc = new Scanner(System.in);
//        sc.next();
        //check if there is such a username





    }
}
