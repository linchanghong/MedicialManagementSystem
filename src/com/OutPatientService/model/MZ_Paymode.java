package com.OutPatientService.model;

public class MZ_Paymode {
	private int paymode_id;
	private String invoice_N0; // ��Ʊ��
	private String mode_code; // ֧����ʽ
	private double tot_cost; // Ӧ����� ͨ����Ʊ�����ҵ�
	private double real_cost; // ʵ�����
	private String bank_name; // ������������
	private String account; // �ʺ�
	private String pos_no; // pos����
	private String check_no; // ֧Ʊ��
	private String cancel_falg; // 0������1���ϣ�2�ش�3ע��

	public int getPaymode_id() {
		return paymode_id;
	}

	public void setPaymode_id(int paymode_id) {
		this.paymode_id = paymode_id;
	}

	public String getInvoice_N0() {
		return invoice_N0;
	}

	public void setInvoice_N0(String invoice_N0) {
		this.invoice_N0 = invoice_N0;
	}

	public String getMode_code() {
		return mode_code;
	}

	public void setMode_code(String mode_code) {
		this.mode_code = mode_code;
	}

	public double getTot_cost() {
		return tot_cost;
	}

	public void setTot_cost(double tot_cost) {
		this.tot_cost = tot_cost;
	}

	public double getReal_cost() {
		return real_cost;
	}

	public void setReal_cost(double real_cost) {
		this.real_cost = real_cost;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPos_no() {
		return pos_no;
	}

	public void setPos_no(String pos_no) {
		this.pos_no = pos_no;
	}

	public String getCheck_no() {
		return check_no;
	}

	public void setCheck_no(String check_no) {
		this.check_no = check_no;
	}

	public String getCancel_falg() {
		return cancel_falg;
	}

	public void setCancel_falg(String cancel_falg) {
		this.cancel_falg = cancel_falg;
	}

}
