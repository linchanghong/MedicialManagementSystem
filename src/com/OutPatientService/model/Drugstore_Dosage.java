package com.OutPatientService.model;

import java.util.Date;

public class Drugstore_Dosage {
	
	
private String preCriptionNumber;//������
	 							 //�����
private String preCriptionBillNumber;//��Ʊ��
private String PatientName;		 //��������
private String PatientAge;		 //��������
public String getPatientAge() {
	return PatientAge;
}

public void setPatientAge(String patientAge) {
	PatientAge = patientAge;
}

private String PatientSex;		 //�����Ա�
private Date RegisterDate;	 //�Һ�����
	 							 //�շ���
	 							 //�շ��˱���
private Date ChargeDate;		 //�շ�����
private String Prescription_doctor;	//ҽ��
private String Prescription_doctordept;	//ҽ������

private String Prescription_condition;	//����״̬
private String PatientCaseNumber;		//���˲�����
//private String Prescription_chargeflag;	//�շ�״̬


//����ҩ����Ϣ
private String Prescription_drugName;    //ҩ����
private String Prescription_drugStandard;//ҩƷ���
private int Prescription_drugNumber;  //ҩƷ����
private String Prescription_drugUnit;    //ҩƷ��λ
private double Prescription_drugDoseonce;//ÿ�μ���
private String Prescription_drugdoseunit;//ÿ�μ�����λ
private String Prescription_drugRate;	 //ʹ��Ƶ��
private String Prescription_drugUsename; //�÷�����



//private double Prescription_drugUnitprice;//ҩƷ����

//private double Prescription_drugprice;    //����ҩƷ�ܼ�

private double Prescription_drugTotalprice;//����ҩƷ�۸�


	
	
	
	public String getPreCriptionNumber() {
		return preCriptionNumber;
	}

	public void setPreCriptionNumber(String preCriptionNumber) {
		this.preCriptionNumber = preCriptionNumber;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	

	public String getPatientSex() {
		return PatientSex;
	}

	public void setPatientSex(String patientSex) {
		PatientSex = patientSex;
	}

	public Date getRegisterDate() {
		return RegisterDate;
	}

	public void setRegisterDate(Date registerDate) {
		RegisterDate = registerDate;
	}

	public Date getChargeDate() {
		return ChargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		ChargeDate = chargeDate;
	}

	public String getPrescription_doctor() {
		return Prescription_doctor;
	}

	public void setPrescription_doctor(String prescription_doctor) {
		Prescription_doctor = prescription_doctor;
	}

	public String getPrescription_doctordept() {
		return Prescription_doctordept;
	}

	public void setPrescription_doctordept(String prescription_doctordept) {
		Prescription_doctordept = prescription_doctordept;
	}

	public String getPrescription_condition() {
		return Prescription_condition;
	}

	public void setPrescription_condition(String prescription_condition) {
		Prescription_condition = prescription_condition;
	}

/*	public String getPrescription_chargeflag() {
		return Prescription_chargeflag;
	}

	public void setPrescription_chargeflag(String prescription_chargeflag) {
		Prescription_chargeflag = prescription_chargeflag;
	}*/

	public String getPrescription_drugName() {
		return Prescription_drugName;
	}

	public void setPrescription_drugName(String prescription_drugName) {
		Prescription_drugName = prescription_drugName;
	}

	public String getPrescription_drugStandard() {
		return Prescription_drugStandard;
	}

	public void setPrescription_drugStandard(String prescription_drugStandard) {
		Prescription_drugStandard = prescription_drugStandard;
	}

	public int getPrescription_drugNumber() {
		return Prescription_drugNumber;
	}

	public void setPrescription_drugNumber(int prescription_drugNumber) {
		Prescription_drugNumber = prescription_drugNumber;
	}

	public String getPrescription_drugUnit() {
		return Prescription_drugUnit;
	}

	public void setPrescription_drugUnit(String prescription_drugUnit) {
		Prescription_drugUnit = prescription_drugUnit;
	}

	public double getPrescription_drugDoseonce() {
		return Prescription_drugDoseonce;
	}

	public void setPrescription_drugDoseonce(double prescription_drugDoseonce) {
		Prescription_drugDoseonce = prescription_drugDoseonce;
	}

	public String getPrescription_drugdoseunit() {
		return Prescription_drugdoseunit;
	}

	public void setPrescription_drugdoseunit(String prescription_drugdoseunit) {
		Prescription_drugdoseunit = prescription_drugdoseunit;
	}

	public String getPrescription_drugRate() {
		return Prescription_drugRate;
	}

	public void setPrescription_drugRate(String prescription_drugRate) {
		Prescription_drugRate = prescription_drugRate;
	}

	public String getPrescription_drugUsename() {
		return Prescription_drugUsename;
	}

	public void setPrescription_drugUsename(String prescription_drugUsename) {
		Prescription_drugUsename = prescription_drugUsename;
	}

/*	public double getPrescription_drugUnitprice() {
		return Prescription_drugUnitprice;
	}

	public void setPrescription_drugUnitprice(double prescription_drugUnitprice) {
		Prescription_drugUnitprice = prescription_drugUnitprice;
	}

	public double getPrescription_drugprice() {
		return Prescription_drugprice;
	}

	public void setPrescription_drugprice(double prescription_drugprice) {
		Prescription_drugprice = prescription_drugprice;
	}*/

	public double getPrescription_drugTotalprice() {
		return Prescription_drugTotalprice;
	}

	public void setPrescription_drugTotalprice(double prescription_drugTotalprice) {
		Prescription_drugTotalprice = prescription_drugTotalprice;
	}

	public String getPreCriptionBillNumber() {
		return preCriptionBillNumber;
	}

	public void setPreCriptionBillNumber(String preCriptionBillNumber) {
		this.preCriptionBillNumber = preCriptionBillNumber;
	}

	public String getPatientCaseNumber() {
		return PatientCaseNumber;
	}

	public void setPatientCaseNumber(String patientCaseNumber) {
		PatientCaseNumber = patientCaseNumber;
	}
	
	
	
	

}
