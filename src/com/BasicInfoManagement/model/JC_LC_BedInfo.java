package com.BasicInfoManagement.model;

public class JC_LC_BedInfo {
	private int bed_id;
	
	private String bed_number;
	private JC_LC_DeptInfo deptInfo;
	
	public int getBed_id() {
		return bed_id;
	}
	public void setBed_id(int bed_id) {
		this.bed_id = bed_id;
	}
	
	public String getBed_number() {
		return bed_number;
	}
	public void setBed_number(String bed_number) {
		this.bed_number = bed_number;
	}
	public JC_LC_DeptInfo getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(JC_LC_DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}
	

}
