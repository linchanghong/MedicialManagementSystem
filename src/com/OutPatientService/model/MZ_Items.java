package com.OutPatientService.model;

import java.util.Date;

public class MZ_Items {
	private int item_id;
	private String item_code; // ��Ŀ����
	private String item_name; // ��Ŀ����
	private String specs; // ���
	private String invoice_N0; // ��Ʊ��
	private Double unit_price; // ���� �ӷ�Ʊ���в���
	private int qty; // ����
	private String dept_code; // ���Һ�
	private String dept_name; // �������� �ӿ��Һ��в���
	private Date oper_date; // ����ʱ��
	private String oper_code; // ����Ա
	private String input_code; // �Զ�����
	private String drug_flag; // 1ҩƷ/0��ҩ

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String getInvoice_N0() {
		return invoice_N0;
	}

	public void setInvoice_N0(String invoice_N0) {
		this.invoice_N0 = invoice_N0;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Date getOper_date() {
		return oper_date;
	}

	public void setOper_date(Date oper_date) {
		this.oper_date = oper_date;
	}

	public String getOper_code() {
		return oper_code;
	}

	public void setOper_code(String oper_code) {
		this.oper_code = oper_code;
	}

	public String getInput_code() {
		return input_code;
	}

	public void setInput_code(String input_code) {
		this.input_code = input_code;
	}

	public String getDrug_flag() {
		return drug_flag;
	}

	public void setDrug_flag(String drug_flag) {
		this.drug_flag = drug_flag;
	}
}
