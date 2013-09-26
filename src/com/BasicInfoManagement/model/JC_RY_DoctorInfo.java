package com.BasicInfoManagement.model;

public class JC_RY_DoctorInfo {
	private int doctorInfo_id;
	private String doctorInfo_name;
	private int doctorInfo_age;
	private String doctorInfo_sex;
	private JC_LC_DeptInfo deptInfo;
	public JC_LC_DeptInfo getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(JC_LC_DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}
	public int getDoctorInfo_id() {
		return doctorInfo_id;
	}
	public void setDoctorInfo_id(int doctorInfo_id) {
		this.doctorInfo_id = doctorInfo_id;
	}
	public String getDoctorInfo_name() {
		return doctorInfo_name;
	}
	public void setDoctorInfo_name(String doctorInfo_name) {
		this.doctorInfo_name = doctorInfo_name;
	}
	public int getDoctorInfo_age() {
		return doctorInfo_age;
	}
	public void setDoctorInfo_age(int doctorInfo_age) {
		this.doctorInfo_age = doctorInfo_age;
	}
	public String getDoctorInfo_sex() {
		return doctorInfo_sex;
	}
	public void setDoctorInfo_sex(String doctorInfo_sex) {
		this.doctorInfo_sex = doctorInfo_sex;
	}


}
