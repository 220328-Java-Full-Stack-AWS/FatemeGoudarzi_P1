package com.revature.models;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class ReimbursementModel extends Model{
    private int reimbursementId;
    private Timestamp creationDate;
    private Timestamp resolutionDate;
    private int reimbursementTypeId;
    private String reimbursementDescription;
    private BigDecimal reimbursementAmount;
    private int reimbursementStatus;
    private int reimbursementCreator;
    private int reimbursementResolver;

    public ReimbursementModel() {
    }

    public ReimbursementModel(int id , int status , Timestamp resolutionDate, int resolver) {
        this.reimbursementId = id;
        this.reimbursementStatus = status;
        this.resolutionDate = resolutionDate;
        this.reimbursementResolver=resolver;
    }

    public ReimbursementModel(int id, Timestamp creationDate, Timestamp resolutionDate, int typeId,String description, BigDecimal amount, int status, int creator, int resolver) {
        this.reimbursementId=id;
        this.creationDate = creationDate;
        this.resolutionDate = resolutionDate;
        this.reimbursementTypeId = typeId;
        this.reimbursementDescription = description;
        this.reimbursementAmount= amount;
        this.reimbursementStatus = status;
        this.reimbursementCreator = creator;
        this.reimbursementResolver=resolver;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getResolutionDate() {
        return resolutionDate;
    }

    public int getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public BigDecimal getReimbursementAmount() {
        return reimbursementAmount;
    }

    public int getReimbursementStatus() {
        return reimbursementStatus;
    }

    public int getReimbursementCreator() {
        return reimbursementCreator;
    }

    public int getReimbursementResolver() {
        return reimbursementResolver;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public void setResolutionDate(Timestamp resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public void setReimbursementTypeId(int reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
    }

    public void setReimbursementAmount(java.math.BigDecimal reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public void setReimbursementStatus(int reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public void setReimbursementCreator(int reimbursementCreator) {
        this.reimbursementCreator = reimbursementCreator;
    }

    public void setReimbursementResolver(int reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    @Override
    public String toString() {
        return "["+
                "reimbursementId:" + reimbursementId+
                " ,creationDate:"+ creationDate+
                " ,resolutionDate:"+ resolutionDate+
                " ,reimbursementId:"+reimbursementId+
                " ,reimbursementDescription:"+reimbursementDescription+
                " ,reimbursementAmount:"+reimbursementAmount+
                " ,reimbursementStatus:"+reimbursementStatus+
                " ,creator: "+reimbursementCreator +
                " ,resolver: "+reimbursementResolver +
                "]"+System.lineSeparator() ;
    }

}


