package com.revature.repositories;

import com.revature.models.ReimbursementModel;
import com.revature.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO implements CRUDInterface<ReimbursementModel> {

    @Override
    public ReimbursementModel create(ReimbursementModel model) throws SQLException {
        ResultSet rs ;
        String SQL = "INSERT INTO public.reimbursement (reimbursement_creation_date, reimbursement_type_id, reimbursement_description,reimbursement_amount, reimbursement_creator) VALUES(?,?, ?, ?,?)";
        try{
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
            pstmt.setTimestamp(1, model.getCreationDate());
            pstmt.setInt(2, model.getReimbursementTypeId());
            pstmt.setString(3, model.getReimbursementDescription());
            pstmt.setDouble(4, model.getReimbursementAmount());
            pstmt.setInt(5, model.getReimbursementCreator());
            pstmt.executeUpdate();
        } catch(SQLException e) {
                e.printStackTrace();
        }

        return model;
    }

    @Override
    public ReimbursementModel update(ReimbursementModel model) throws SQLException {
        String SQL = "Update public.reimbursement set " +
                "reimbursement_status_id=? , reimbursement_resolution_date=? ,reimbursement_resolver=?  WHERE reimbursement_id = ?";

        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        pstmt.setInt(1, model.getReimbursementStatus());
        pstmt.setTimestamp(2,model.getResolutionDate());
        pstmt.setInt(3,model.getReimbursementResolver());
        pstmt.setInt(4, model.getReimbursementId());
        pstmt.executeUpdate();

        return model;
    }

    @Override
    public List<ReimbursementModel> getAll() throws SQLException{
        List list = new ArrayList();
        String SQL = "SELECT * FROM public.reimbursement";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ReimbursementModel model = new ReimbursementModel(
                    rs.getInt("reimbursement_id"),
                    rs.getTimestamp("reimbursement_creation_date"),
                    rs.getTimestamp("reimbursement_resolution_date"),
                    rs.getInt("reimbursement_type_id"),
                    rs.getString("reimbursement_description"),
                    rs.getDouble("reimbursement_amount"),
                    rs.getInt("reimbursement_status_id"),
                    rs.getInt("reimbursement_creator"),
                    rs.getInt("reimbursement_resolver")
                    );
            list.add(model);
        }
        return list;
    }

    public List<ReimbursementModel> getAll(String status) throws SQLException{
        List list = new ArrayList();
        String SQL = "SELECT * FROM public.reimbursement where reimbursement_status=?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        pstmt.setString(1,status);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ReimbursementModel model = new ReimbursementModel(
                    rs.getInt("reimbursement_id"),
                    rs.getTimestamp("reimbursement_creation_date"),
                    rs.getTimestamp("reimbursement_resolution_date"),
                    rs.getInt("reimbursement_type_id"),
                    rs.getString("reimbursement_description"),
                    rs.getDouble("reimbursement_amount"),
                    rs.getInt("reimbursement_status_id"),
                    rs.getInt("reimbursement_creator"),
                    rs.getInt("reimbursement_resolver")
            );
            list.add(model);
        }


        return list;
    }

    public List<ReimbursementModel> getAll(String status , int creatorId) throws SQLException{
        List list = new ArrayList();
        String SQL = "SELECT * FROM public.reimbursement where reimbursement_status=? AND reimbursement_creator=? ";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        pstmt.setString(1,status);
        pstmt.setInt(2,creatorId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ReimbursementModel model = new ReimbursementModel(
                    rs.getInt("reimbursement_id"),
                    rs.getTimestamp("reimbursement_creation_date"),
                    rs.getTimestamp("reimbursement_resolution_date"),
                    rs.getInt("reimbursement_type_id"),
                    rs.getString("reimbursement_description"),
                    rs.getDouble("reimbursement_amount"),
                    rs.getInt("reimbursement_status_id"),
                    rs.getInt("reimbursement_creator"),
                    rs.getInt("reimbursement_resolver")
            );
            list.add(model);
        }

        return list;
    }
    public List<ReimbursementModel> getAll(int creatorId)  throws SQLException {
        List list = new ArrayList();

        String SQL = "SELECT * FROM public.reimbursement where reimbursement_creator=? ";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        pstmt.setInt(1,creatorId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ReimbursementModel model = new ReimbursementModel(
                    rs.getInt("reimbursement_id"),
                    rs.getTimestamp("reimbursement_creation_date"),
                    rs.getTimestamp("reimbursement_resolution_date"),
                    rs.getInt("reimbursement_type_id"),
                    rs.getString("reimbursement_description"),
                    rs.getDouble("reimbursement_amount"),
                    rs.getInt("reimbursement_status_id"),
                    rs.getInt("reimbursement_creator"),
                    rs.getInt("reimbursement_resolver")
            );
            list.add(model);
        }

        return list;
    }
    @Override
    public void delete(int id) throws SQLException {
        String SQL = "Delete from public.reimbursement  WHERE reimbursement_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(SQL);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public ReimbursementModel read(ReimbursementModel model ) {
        return model;
    }


}
