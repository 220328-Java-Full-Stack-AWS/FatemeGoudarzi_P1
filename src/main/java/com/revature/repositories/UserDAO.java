package com.revature.repositories;

import com.revature.models.UserModel;
import com.revature.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements CRUDInterface<UserModel>{


    @Override
    public UserModel create(UserModel model) {

        String SQL = " INSERT INTO public.users ( first_name, last_name, user_name, pass_word,email) VALUES(?, ?, ?, ?, ?);";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
            pstmt.setString(1,model.getFirstName());
            pstmt.setString(2,model.getLastName());
            pstmt.setString(3,model.getUserName());
            pstmt.setString(4,model.getPassWord());
            pstmt.setString(5,model.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public UserModel read(UserModel model) {
        UserModel outModel = new UserModel();
        if (model.getPassWord() != null && model.getUserName() != null) {
            String SQL = "SELECT * from public.users WHERE user_name = ? AND pass_word=?";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
                pstmt.setString(1, model.getUserName());
                pstmt.setString(2, model.getPassWord());
                ResultSet rs = pstmt.executeQuery();
                ResultSet keys = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    outModel.setFirstName(rs.getString("first_name"));
                    outModel.setLastName(rs.getString("last_name"));
                    outModel.setUserName(rs.getString("user_name"));
                    outModel.setEmail(rs.getString("email"));
                    outModel.setRoleId(rs.getInt("role_id"));
                    outModel.setPassWord(rs.getString("pass_word"));
                    outModel.setUserId(rs.getInt("user_id"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if(model.getPassWord() == null && model.getUserName() != null){

            String SQL = "SELECT * from public.users WHERE user_name = ? ";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
                pstmt.setString(1, model.getUserName());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    outModel.setFirstName(rs.getString("first_name"));
                    outModel.setLastName(rs.getString("last_name"));
                    outModel.setUserName(rs.getString("user_name"));
                    outModel.setEmail(rs.getString("email"));
                    outModel.setRoleId(rs.getInt("role_id"));
                    outModel.setPassWord(rs.getString("pass_word"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outModel;
    }



    @Override
    public List<UserModel> getAll() {
        List<UserModel> list = new LinkedList<>();
        try {
            String SQL = "SELECT user_id, first_Name, last_Name , role_id FROM public.users";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserModel model = new UserModel();
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setUserId(rs.getInt("user_id"));
                model.setUserName("");
                model.setEmail("");
                model.setRoleId(rs.getInt("role_id"));
                model.setPassWord("");
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public UserModel update(UserModel model) {
        return model;
    }

    @Override
    public void delete(int id) {

    }

}

