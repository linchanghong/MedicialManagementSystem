package com.BasicInfoManagement.model;
/*
 * 门诊挂号种类
 */
public class JC_SF_OutpatientRegistration {
	private int outpatientRegistration_id;            //主键
	private String outpatientRegistration_name;       //门诊挂号名称
	private String outpatientRegistration_number;     //门诊挂号编号
	private double outpatientRegistration_price;      //门诊挂号价格
	private String outpatientRegistration_zjm;        //注记码
	public int getOutpatientRegistration_id() {
		return outpatientRegistration_id;
	}
	public void setOutpatientRegistration_id(int outpatientRegistration_id) {
		this.outpatientRegistration_id = outpatientRegistration_id;
	}
	public String getOutpatientRegistration_name() {
		return outpatientRegistration_name;
	}
	public void setOutpatientRegistration_name(String outpatientRegistration_name) {
		this.outpatientRegistration_name = outpatientRegistration_name;
	}
	public String getOutpatientRegistration_number() {
		return outpatientRegistration_number;
	}
	public void setOutpatientRegistration_number(
			String outpatientRegistration_number) {
		this.outpatientRegistration_number = outpatientRegistration_number;
	}
	public double getOutpatientRegistration_price() {
		return outpatientRegistration_price;
	}
	public void setOutpatientRegistration_price(double outpatientRegistration_price) {
		this.outpatientRegistration_price = outpatientRegistration_price;
	}
	public String getOutpatientRegistration_zjm() {
		return outpatientRegistration_zjm;
	}
	public void setOutpatientRegistration_zjm(String outpatientRegistration_zjm) {
		this.outpatientRegistration_zjm = outpatientRegistration_zjm;
	}


}
