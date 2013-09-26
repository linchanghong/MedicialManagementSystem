package com.OutPatientService.model;

import java.util.Date;

public class MZ_Invoicedetail {
	private int invoice_id;
	private String invoice_No; // ��Ʊ��
	private String invoice_code; // ��Ʊ��Ŀ����
	private String invoice_name; // ��Ʊ��Ŀ����
	private Double cost; // ���
	private String dept_code; // ִ�п���
	private String dept_name; // ִ�п�������
	private Date oper_date; // ����ʱ��
	private String oper_code; // ������Ա
	private String cancel_flag; // 1������0���ϣ�2�ش�3ע��

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getInvoice_No() {
		return invoice_No;
	}

	public void setInvoice_No(String invoice_No) {
		this.invoice_No = invoice_No;
	}

	public String getInvoice_code() {
		return invoice_code;
	}

	public void setInvoice_code(String invoice_code) {
		this.invoice_code = invoice_code;
	}

	public String getInvoice_name() {
		return invoice_name;
	}

	public void setInvoice_name(String invoice_name) {
		this.invoice_name = invoice_name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
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

	public String getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(String cancel_flag) {
		this.cancel_flag = cancel_flag;
	}
}
