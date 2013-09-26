package com.BasicInfoManagement.model;
/*
 *收费明细主体类
 *对应数据表收费明细项目(jc_sf_ payDetail)
 *编辑者：林世鹏
 *时间：2013.8.8
 *
*/
public class JC_SF_PayDetail {

	//类属性
	private int payDetail_id;//主键序号
	private String payDetail_name;//收费名称
	private String payDetail_number;//收费编号
	private String payDetail_property;//收费性质
	private String payDetail_object;//收费对象
	private String payDetail_standard;//收费标准
	private double payDetail_price;//收费价格
	private String payDetail_remark;//备注信息
	private String payDetail_zjm;//助记码
	
	
	//封装字段方法
	public int getPayDetail_id() {
		return payDetail_id;
	}
	public void setPayDetail_id(int payDetail_id) {
		this.payDetail_id = payDetail_id;
	}
	public String getPayDetail_name() {
		return payDetail_name;
	}
	public void setPayDetail_name(String payDetail_name) {
		this.payDetail_name = payDetail_name;
	}
	public String getPayDetail_number() {
		return payDetail_number;
	}
	public void setPayDetail_number(String payDetail_number) {
		this.payDetail_number = payDetail_number;
	}
	public String getPayDetail_property() {
		return payDetail_property;
	}
	public void setPayDetail_property(String payDetail_property) {
		this.payDetail_property = payDetail_property;
	}
	public String getPayDetail_object() {
		return payDetail_object;
	}
	public void setPayDetail_object(String payDetail_object) {
		this.payDetail_object = payDetail_object;
	}
	public String getPayDetail_standard() {
		return payDetail_standard;
	}
	public void setPayDetail_standard(String payDetail_standard) {
		this.payDetail_standard = payDetail_standard;
	}
	public double getPayDetail_price() {
		return payDetail_price;
	}
	public void setPayDetail_price(double payDetail_price) {
		this.payDetail_price = payDetail_price;
	}
	public String getPayDetail_remark() {
		return payDetail_remark;
	}
	public void setPayDetail_remark(String payDetail_remark) {
		this.payDetail_remark = payDetail_remark;
	}
	public String getPayDetail_zjm() {
		return payDetail_zjm;
	}
	public void setPayDetail_zjm(String payDetail_zjm) {
		this.payDetail_zjm = payDetail_zjm;
	}

}
