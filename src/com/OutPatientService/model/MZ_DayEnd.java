package com.OutPatientService.model;

import java.util.Date;

public class MZ_DayEnd {
	private int dayEnd_id;
	private Date dayEnd_beginDate;  //��ʼʱ��
	private Date dayEnd_endDate;    //��ֹ����
	private String dayEnd_oper;     //������Ա
	private double dayEnd_feeCount;  //�ܵĹҺŷ�
	private int dayEnd_danHaoZC;     //��������
	private int dayEnd_danHaoTH;     //�˺ŵ���
	private int dayEnd_danHaoCount;  //������ܵĵ���
	
	public Date getDayEnd_endDate() {
		return dayEnd_endDate;
	}
	public void setDayEnd_endDate(Date dayEnd_endDate) {
		this.dayEnd_endDate = dayEnd_endDate;
	}
	public int getDayEnd_id() {
		return dayEnd_id;
	}
	public void setDayEnd_id(int dayEnd_id) {
		this.dayEnd_id = dayEnd_id;
	}
	public Date getDayEnd_beginDate() {
		return dayEnd_beginDate;
	}
	public void setDayEnd_beginDate(Date dayEnd_beginDate) {
		this.dayEnd_beginDate = dayEnd_beginDate;
	}
	
	public String getDayEnd_oper() {
		return dayEnd_oper;
	}
	public void setDayEnd_oper(String dayEnd_oper) {
		this.dayEnd_oper = dayEnd_oper;
	}
	public double getDayEnd_feeCount() {
		return dayEnd_feeCount;
	}
	public void setDayEnd_feeCount(double dayEnd_feeCount) {
		this.dayEnd_feeCount = dayEnd_feeCount;
	}
	public int getDayEnd_danHaoZC() {
		return dayEnd_danHaoZC;
	}
	public void setDayEnd_danHaoZC(int dayEnd_danHaoZC) {
		this.dayEnd_danHaoZC = dayEnd_danHaoZC;
	}
	public int getDayEnd_danHaoTH() {
		return dayEnd_danHaoTH;
	}
	public void setDayEnd_danHaoTH(int dayEnd_danHaoTH) {
		this.dayEnd_danHaoTH = dayEnd_danHaoTH;
	}
	public int getDayEnd_danHaoCount() {
		return dayEnd_danHaoCount;
	}
	public void setDayEnd_danHaoCount(int dayEnd_danHaoCount) {
		this.dayEnd_danHaoCount = dayEnd_danHaoCount;
	}
	

}
