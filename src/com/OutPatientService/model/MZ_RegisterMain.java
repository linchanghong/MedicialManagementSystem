package com.OutPatientService.model;

import java.util.Date;

public class MZ_RegisterMain {

	private int registerMain_id;
	private String registerMain_No;  //处方号
	private Date registerMain_date;  //挂号日期
	private String registerMain_caseNo;//病历号
	private String registerMain_name; //患者姓名
	private String registerMain_sex; //患者性别
	private Date registerMain_birthday;//患者出生日期
	private String registerMain_phoneNo;//患者联系电话
	private String registerMain_address;//患者地址
	private String registerMain_rlCode; //挂号级别编码
	private String registerMainr_rlName; //挂号级别名称
	private double registerMain_fee;       //挂号费
	private String registerMain_deptCode; //科室号
	private String registerMain_deptName; //科室名称
	private String registerMain_docName; //医生姓名
	private String registerMain_invoiceNo; //发票号
	private String registerMain_operName;  //操作人员
	private Date registerMain_operDate;//操作时间
	private String registerMain_status;  //挂号状态
	
	public double getRegisterMain_fee() {
		return registerMain_fee;
	}
	public void setRegisterMain_fee(double registerMain_fee) {
		this.registerMain_fee = registerMain_fee;
	}
	public int getRegisterMain_id() {
		return registerMain_id;
	}
	public void setRegisterMain_id(int registerMain_id) {
		this.registerMain_id = registerMain_id;
	}
	public String getRegisterMain_No() {
		return registerMain_No;
	}
	public void setRegisterMain_No(String registerMain_No) {
		this.registerMain_No = registerMain_No;
	}
	public Date getRegisterMain_date() {
		return registerMain_date;
	}
	public void setRegisterMain_date(Date registerMain_date) {
		this.registerMain_date = registerMain_date;
	}
	public String getRegisterMain_caseNo() {
		return registerMain_caseNo;
	}
	public void setRegisterMain_caseNo(String registerMain_caseNo) {
		this.registerMain_caseNo = registerMain_caseNo;
	}
	public String getRegisterMain_name() {
		return registerMain_name;
	}
	public void setRegisterMain_name(String registerMain_name) {
		this.registerMain_name = registerMain_name;
	}
	public String getRegisterMain_sex() {
		return registerMain_sex;
	}
	public void setRegisterMain_sex(String registerMain_sex) {
		this.registerMain_sex = registerMain_sex;
	}
	public Date getRegisterMain_birthday() {
		return registerMain_birthday;
	}
	public void setRegisterMain_birthday(Date registerMain_birthday) {
		this.registerMain_birthday = registerMain_birthday;
	}
	public String getRegisterMain_phoneNo() {
		return registerMain_phoneNo;
	}
	public void setRegisterMain_phoneNo(String registerMain_phoneNo) {
		this.registerMain_phoneNo = registerMain_phoneNo;
	}
	public String getRegisterMain_address() {
		return registerMain_address;
	}
	public void setRegisterMain_address(String registerMain_address) {
		this.registerMain_address = registerMain_address;
	}
	public String getRegisterMain_rlCode() {
		return registerMain_rlCode;
	}
	public void setRegisterMain_rlCode(String registerMain_rlCode) {
		this.registerMain_rlCode = registerMain_rlCode;
	}
	public String getRegisterMainr_rlName() {
		return registerMainr_rlName;
	}
	public void setRegisterMainr_rlName(String registerMainr_rlName) {
		this.registerMainr_rlName = registerMainr_rlName;
	}
	
	public String getRegisterMain_deptCode() {
		return registerMain_deptCode;
	}
	public void setRegisterMain_deptCode(String registerMain_deptCode) {
		this.registerMain_deptCode = registerMain_deptCode;
	}
	public String getRegisterMain_deptName() {
		return registerMain_deptName;
	}
	public void setRegisterMain_deptName(String registerMain_deptName) {
		this.registerMain_deptName = registerMain_deptName;
	}
	
	public String getRegisterMain_docName() {
		return registerMain_docName;
	}
	public void setRegisterMain_docName(String registerMain_docName) {
		this.registerMain_docName = registerMain_docName;
	}
	public String getRegisterMain_invoiceNo() {
		return registerMain_invoiceNo;
	}
	public void setRegisterMain_invoiceNo(String registerMain_invoiceNo) {
		this.registerMain_invoiceNo = registerMain_invoiceNo;
	}
	public String getRegisterMain_operName() {
		return registerMain_operName;
	}
	public void setRegisterMain_operName(String registerMain_operName) {
		this.registerMain_operName = registerMain_operName;
	}
	public Date getRegisterMain_operDate() {
		return registerMain_operDate;
	}
	public void setRegisterMain_operDate(Date registerMain_operDate) {
		this.registerMain_operDate = registerMain_operDate;
	}
	public String getRegisterMain_status() {
		return registerMain_status;
	}
	public void setRegisterMain_status(String registerMain_status) {
		this.registerMain_status = registerMain_status;
	}
	
	
	
}
