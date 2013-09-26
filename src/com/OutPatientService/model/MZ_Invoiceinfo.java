package com.OutPatientService.model;

import java.util.Date;

public class MZ_Invoiceinfo {
	private int invoiceinfo_id;
	private String invoice_No; // 发票号
	private String printinvoice_flag; // 记账发票是否打印标记 0 没有打印 1 已经打印
	private String card_no; // 病历卡号
	private String prg_date; // 挂号日期
	private String name; // 患者姓名
	private String paykind_code; // 结算类别代码
	private Double tot_cost; // 总额
	private String real_cost; // 实付金额
	private String oper_code; // 结算人
	private Date oper_date; // 结算日期
	private String cancel_flag; // 有效状态 “0” 退费 “1” 有效 “2” 重打 “3” 注销
	private String cancel_invoice; // 作废票据号
	private String cancel_code; // 作废操作人员
	private Date cancel_date; // 作废时间
	private String balance_code; // 日结人
	private Date balance_date; // 日结时间

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
