package com.BasicInfoManagement.model;

public class JC_YP_DrugCategory {
private int	drugCategory_id;//药品分类Id
public int getDrugCategory_id() {
	return drugCategory_id;
}
public void setDrugCategory_id(int drugCategory_id) {
	this.drugCategory_id = drugCategory_id;
}
public String getDrugCategory_name() {
	return drugCategory_name;
}
public void setDrugCategory_name(String drugCategory_name) {
	this.drugCategory_name = drugCategory_name;
}
public String getDrugCategory_number() {
	return drugCategory_number;
}
public void setDrugCategory_number(String drugCategory_number) {
	this.drugCategory_number = drugCategory_number;
}
public String getDrugCategory_zjm() {
	return drugCategory_zjm;
}
public void setDrugCategory_zjm(String drugCategory_zjm) {
	this.drugCategory_zjm = drugCategory_zjm;
}
private String drugCategory_name;//药品种类名称
private String drugCategory_number;//药品种类编号
private String drugCategory_zjm;//助记码
}
