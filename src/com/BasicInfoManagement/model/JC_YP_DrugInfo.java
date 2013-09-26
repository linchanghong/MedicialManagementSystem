package com.BasicInfoManagement.model;

public class JC_YP_DrugInfo {
	private int drugInfo_id;
	private String drugInfo_name; // 药品名称
	private JC_YP_DrugCode drugCode; // 外键约束，药品编码
	private String drugInfo_standard; // 规格
	private JC_YP_DrugCategory drugCategory;// 外键约束，药品分类
	private JC_YP_DrugManuf drugManuf;// 外键约束，药品生产商
	private String drugInfo_approve; // 批准文字
	private String drugInfo_saleclassification;// 销售分类
	private String drugInfo_dosage; // 剂型
	private String drugInfo_zjm;// 助记码

	public int getDrugInfo_id() {
		return drugInfo_id;
	}

	public void setDrugInfo_id(int drugInfo_id) {
		this.drugInfo_id = drugInfo_id;
	}

	public String getDrugInfo_name() {
		return drugInfo_name;
	}

	public void setDrugInfo_name(String drugInfo_name) {
		this.drugInfo_name = drugInfo_name;
	}

	public JC_YP_DrugCode getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(JC_YP_DrugCode drugCode) {
		this.drugCode = drugCode;
	}

	public String getDrugInfo_standard() {
		return drugInfo_standard;
	}

	public void setDrugInfo_standard(String drugInfo_standard) {
		this.drugInfo_standard = drugInfo_standard;
	}

	public JC_YP_DrugCategory getDrugCategory() {
		return drugCategory;
	}

	public void setDrugCategory(JC_YP_DrugCategory drugCategory) {
		this.drugCategory = drugCategory;
	}

	public JC_YP_DrugManuf getDrugManuf() {
		return drugManuf;
	}

	public void setDrugManuf(JC_YP_DrugManuf drugManuf) {
		this.drugManuf = drugManuf;
	}

	public String getDrugInfo_approve() {
		return drugInfo_approve;
	}

	public void setDrugInfo_approve(String drugInfo_approve) {
		this.drugInfo_approve = drugInfo_approve;
	}

	public String getDrugInfo_saleclassification() {
		return drugInfo_saleclassification;
	}

	public void setDrugInfo_saleclassification(
			String drugInfo_saleclassification) {
		this.drugInfo_saleclassification = drugInfo_saleclassification;
	}

	public String getDrugInfo_dosage() {
		return drugInfo_dosage;
	}

	public void setDrugInfo_dosage(String drugInfo_dosage) {
		this.drugInfo_dosage = drugInfo_dosage;
	}

	public String getDrugInfo_zjm() {
		return drugInfo_zjm;
	}

	public void setDrugInfo_zjm(String drugInfo_zjm) {
		this.drugInfo_zjm = drugInfo_zjm;
	}
}
