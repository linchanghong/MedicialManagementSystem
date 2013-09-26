package com.OutPatientService.model;

import java.util.Date;

public class MZ_Invoiceinfo {
	private int invoiceinfo_id;
	private String invoice_No; // ��Ʊ��
	private String printinvoice_flag; // ���˷�Ʊ�Ƿ��ӡ��� 0 û�д�ӡ 1 �Ѿ���ӡ
	private String card_no; // ��������
	private String prg_date; // �Һ�����
	private String name; // ��������
	private String paykind_code; // ����������
	private Double tot_cost; // �ܶ�
	private String real_cost; // ʵ�����
	private String oper_code; // ������
	private Date oper_date; // ��������
	private String cancel_flag; // ��Ч״̬ ��0�� �˷� ��1�� ��Ч ��2�� �ش� ��3�� ע��
	private String cancel_invoice; // ����Ʊ�ݺ�
	private String cancel_code; // ���ϲ�����Ա
	private Date cancel_date; // ����ʱ��
	private String balance_code; // �ս���
	private Date balance_date; // �ս�ʱ��

	public int getInvoiceinfo_id() {
		return invoiceinfo_id;
	}

	public void setInvoiceinfo_id(int invoiceinfo_id) {
		this.invoiceinfo_id = invoiceinfo_id;
	}

	public String getInvoice_No() {
		return invoice_No;
	}

	public void setInvoice_No(String invoice_No) {
		this.invoice_No = invoice_No;
	}

	public String getPrintinvoice_flag() {
		return printinvoice_flag;
	}

	public void setPrintinvoice_flag(String printinvoice_flag) {
		this.printinvoice_flag = printinvoice_flag;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getPrg_date() {
		return prg_date;
	}

	public void setPrg_date(String prg_date) {
		this.prg_date = prg_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaykind_code() {
		return paykind_code;
	}

	public void setPaykind_code(String paykind_code) {
		this.paykind_code = paykind_code;
	}

	public Double getTot_cost() {
		return tot_cost;
	}

	public void setTot_cost(Double tot_cost) {
		this.tot_cost = tot_cost;
	}

	public String getReal_cost() {
		return real_cost;
	}

	public void setReal_cost(String real_cost) {
		this.real_cost = real_cost;
	}

	public String getOper_code() {
		return oper_code;
	}

	public void setOper_code(String oper_code) {
		this.oper_code = oper_code;
	}

	public Date getOper_date() {
		return oper_date;
	}

	public void setOper_date(Date oper_date) {
		this.oper_date = oper_date;
	}

	public String getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(String cancel_flag) {
		this.cancel_flag = cancel_flag;
	}

	public String getCancel_invoice() {
		return cancel_invoice;
	}

	public void setCancel_invoice(String cancel_invoice) {
		this.cancel_invoice = cancel_invoice;
	}

	public String getCancel_code() {
		return cancel_code;
	}

	public void setCancel_code(String cancel_code) {
		this.cancel_code = cancel_code;
	}

	public Date getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}

	public String getBalance_code() {
		return balance_code;
	}

	public void setBalance_code(String balance_code) {
		this.balance_code = balance_code;
	}

	public Date getBalance_date() {
		return balance_date;
	}

	public void setBalance_date(Date balance_date) {
		this.balance_date = balance_date;
	}

}
