package com.secl.svca.bean;

import java.util.Date;

@SuppressWarnings("serial")
public class SubscribersBean extends AbstractBean {
	
	private String srID;
	private String nameEN;
	private String nameBN;
	private String nID;
	private Date dateofBirth;
	private String mSISDN;
	private String retailerMSISDN;
	private String retailerCode;
	private String thumbPrintPath;
	private String status;
	private String cause;
	private String message;
	private int liveMatchingScore;
	private int inkMatchingScore;
	private String matchingScorePct;
	private Date validationDate;
	private Date verificationDate;
	private Date verificationCode;
	private Date verificationCodeExpDate;
	private Date createdOn;
	private String createdBy;
	private Date editedOn;
	private Date editedBy;
	
	
	
	
	public SubscribersBean() {}
	
	

	public String getSrID() {
		return srID;
	}



	public void setSrID(String srID) {
		this.srID = srID;
	}



	public String getNameEN() {
		return nameEN;
	}



	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}



	public String getNameBN() {
		return nameBN;
	}



	public void setNameBN(String nameBN) {
		this.nameBN = nameBN;
	}



	public String getnID() {
		return nID;
	}



	public void setnID(String nID) {
		this.nID = nID;
	}



	public Date getDateofBirth() {
		return dateofBirth;
	}



	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}



	public String getmSISDN() {
		return mSISDN;
	}



	public void setmSISDN(String mSISDN) {
		this.mSISDN = mSISDN;
	}



	public String getRetailerMSISDN() {
		return retailerMSISDN;
	}



	public void setRetailerMSISDN(String retailerMSISDN) {
		this.retailerMSISDN = retailerMSISDN;
	}



	public String getRetailerCode() {
		return retailerCode;
	}



	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}



	public String getThumbPrintPath() {
		return thumbPrintPath;
	}



	public void setThumbPrintPath(String thumbPrintPath) {
		this.thumbPrintPath = thumbPrintPath;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCause() {
		return cause;
	}



	public void setCause(String cause) {
		this.cause = cause;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getLiveMatchingScore() {
		return liveMatchingScore;
	}



	public void setLiveMatchingScore(int liveMatchingScore) {
		this.liveMatchingScore = liveMatchingScore;
	}



	public int getInkMatchingScore() {
		return inkMatchingScore;
	}



	public void setInkMatchingScore(int inkMatchingScore) {
		this.inkMatchingScore = inkMatchingScore;
	}



	public String getMatchingScorePct() {
		return matchingScorePct;
	}



	public void setMatchingScorePct(String matchingScorePct) {
		this.matchingScorePct = matchingScorePct;
	}



	public Date getValidationDate() {
		return validationDate;
	}



	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}



	public Date getVerificationDate() {
		return verificationDate;
	}



	public void setVerificationDate(Date verificationDate) {
		this.verificationDate = verificationDate;
	}



	public Date getVerificationCode() {
		return verificationCode;
	}



	public void setVerificationCode(Date verificationCode) {
		this.verificationCode = verificationCode;
	}



	public Date getVerificationCodeExpDate() {
		return verificationCodeExpDate;
	}



	public void setVerificationCodeExpDate(Date verificationCodeExpDate) {
		this.verificationCodeExpDate = verificationCodeExpDate;
	}



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Date getEditedOn() {
		return editedOn;
	}



	public void setEditedOn(Date editedOn) {
		this.editedOn = editedOn;
	}



	public Date getEditedBy() {
		return editedBy;
	}



	public void setEditedBy(Date editedBy) {
		this.editedBy = editedBy;
	}



	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid = oid;
	}

	

}
