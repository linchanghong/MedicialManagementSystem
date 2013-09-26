package com.BasicInfoManagement.model;
/*
 * 门诊收费种类
 */
public class JC_SF_OutpatientPayment {
	private int    outpatientPayment_id;             //主键
	private String outpatientPayment_name;        //门诊收费名称
	private String outpatientPayment_number;      //门诊收费编号
	private String outpatientPayment_property;    //门诊收费性质
	private String outpatientPayment_object;      //门诊收费对象
	private String outpatientPayment_remark;      //备注
	private String outpatientPayment_zjm;         //注记码
	public int getOutpatientPayment_id() {
		return outpatientPayment_id;
	}
	public void setOutpatientPayment_id(int outpatientPayment_id) {
		this.outpatientPayment_id = outpatientPayment_id;
	}
	public String getOutpatientPayment_name() {
		return outpatientPayment_name;
	}
	public void setOutpatientPayment_name(String outpatientPayment_name) {
		this.outpatientPayment_name = outpatientPayment_name;
	}
	public String getOutpatientPayment_number() {
		return outpatientPayment_number;
	}
	public void setOutpatientPayment_number(String outpatientPayment_number) {
		this.outpatientPayment_number = outpatientPayment_number;
	}
	public String getOutpatientPayment_property() {
		return outpatientPayment_property;
	}
	public void setOutpatientPayment_property(String outpatientPayment_property) {
		this.outpatientPayment_property = outpatientPayment_property;
	}
	public String getOutpatientPayment_object() {
		return outpatientPayment_object;
	}
	public void setOutpatientPayment_object(String outpatientPayment_object) {
		this.outpatientPayment_object = outpatientPayment_object;
	}
	public String getOutpatientPayment_remark() {
		return outpatientPayment_remark;
	}
	public void setOutpatientPayment_remark(String outpatientPayment_remark) {
		this.outpatientPayment_remark = outpatientPayment_remark;
	}
	public String getOutpatientPayment_zjm() {
		return outpatientPayment_zjm;
	}
	public void setOutpatientPayment_zjm(String outpatientPayment_zjm) {
		this.outpatientPayment_zjm = outpatientPayment_zjm;
	}

}
