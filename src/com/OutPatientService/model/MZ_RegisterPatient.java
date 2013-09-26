package com.OutPatientService.model;

import java.util.Date;

public class MZ_RegisterPatient {
	private int  regiserPatient_id;
	private String regiserPatient_caseNo;//²¡ÀýºÅ
	private String regiserPatient_name;
	private String regiserPatient_sex;
	private Date regiserPatient_birthday;
	private String regiserPatient_address;
	private String regiserPatient_phoneNo;
	public int getRegiserPatient_id() {
		return regiserPatient_id;
	}
	public void setRegiserPatient_id(int regiserPatient_id) {
		this.regiserPatient_id = regiserPatient_id;
	}
	public String getRegiserPatient_caseNo() {
		return regiserPatient_caseNo;
	}
	public void setRegiserPatient_caseNo(String regiserPatient_caseNo) {
		this.regiserPatient_caseNo = regiserPatient_caseNo;
	}
	public String getRegiserPatient_name() {
		return regiserPatient_name;
	}
	public void setRegiserPatient_name(String regiserPatient_name) {
		this.regiserPatient_name = regiserPatient_name;
	}
	public String getRegiserPatient_sex() {
		return regiserPatient_sex;
	}
	public void setRegiserPatient_sex(String regiserPatient_sex) {
		this.regiserPatient_sex = regiserPatient_sex;
	}
	public Date getRegiserPatient_birthday() {
		return regiserPatient_birthday;
	}
	public void setRegiserPatient_birthday(Date regiserPatient_birthday) {
		this.regiserPatient_birthday = regiserPatient_birthday;
	}
	public String getRegiserPatient_address() {
		return regiserPatient_address;
	}
	public void setRegiserPatient_address(String regiserPatient_address) {
		this.regiserPatient_address = regiserPatient_address;
	}
	public String getRegiserPatient_phoneNo() {
		return regiserPatient_phoneNo;
	}
	public void setRegiserPatient_phoneNo(String regiserPatient_phoneNo) {
		this.regiserPatient_phoneNo = regiserPatient_phoneNo;
	}
	

}
