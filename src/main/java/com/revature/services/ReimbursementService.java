package com.revature.services;

import com.revature.models.ReimbursementModel;
import com.revature.repositories.ReimbursementDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {

    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
     */
//    public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, Employee resolver) {
//        return null;
//    }

    private final ReimbursementDAO reimbDao;
    public ReimbursementService() {
        this.reimbDao = new ReimbursementDAO();
    }

    /**Retrieve all reimbursements.*/
    public List<ReimbursementModel> getAllReimbursements() throws SQLException {
        return reimbDao.getAll();
    }

    /**Retrieve and filter reimbursements based on status.*/
    public List<ReimbursementModel> getReimbursementsByStatus(String status) throws SQLException {
        return reimbDao.getAll(status);
    }

    /**Retrieve and filter reimbursements based on status and creator_id.*/
    public List<ReimbursementModel> getReimbursementsByStatusById(String status, int creatorId) throws SQLException{
        return reimbDao.getAll(status , creatorId);
    }

    public List<ReimbursementModel> getReimbursementsByCreatorById(int creatorId) throws SQLException{
        return reimbDao.getAll(creatorId);
    }


    /**Create a reimbursement request. */
    public ReimbursementModel createReimbursement(ReimbursementModel model) throws SQLException {
        return reimbDao.create(model);
    }

    /**Update a reimbursement request. */
    public ReimbursementModel updateReimbursement(ReimbursementModel model) throws SQLException {
        return reimbDao.update(model);
    }

    public void deleteReimbursements(int id) throws SQLException {
        reimbDao.delete(id);
    }

//    public ReimbursementModel create() {
//        ReimbursementDAO reimbursementDao = new ReimbursementDAO();
//        long currentTimeInMillis=System.currentTimeMillis();
//        int year = 1;
//        long resolutionTimeInMillis = System.currentTimeMillis() + (year*365*24*60*60*1000L);
//        Timestamp creationDateTime = new Timestamp(currentTimeInMillis);
//        Timestamp resolutionDateTime= new Timestamp(resolutionTimeInMillis);
//        BigDecimal amount = new BigDecimal(130);
//        ReimbursementModel createReimbursementModel = new ReimbursementModel(creationDateTime,resolutionDateTime,1,"description",amount,"new",1);
//        return reimbursementDao.create(createReimbursementModel);
//    }

//    /** Change a reimbursement request. */
//    public ReimbursementModel update() {
//        ReimbursementDAO reimbursementDao = new ReimbursementDAO();
//        long currentTimeInMillis=System.currentTimeMillis();
//        Timestamp resolutionDateTime= new Timestamp(currentTimeInMillis);
//        ReimbursementModel updateReimbursementModel = new ReimbursementModel(2,"Approved",resolutionDateTime);
//        return reimbursementDao.update(updateReimbursementModel);
//    }


    public ReimbursementModel read(ReimbursementModel model) throws SQLException {
        return reimbDao.read(model);
    }








}
