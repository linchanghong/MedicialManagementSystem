package com.OutPatientService.model;

public class MZ_RegisterLevel {
    private int registerLevel_id;	          //挂号级别id
	private String registerLevel_name;	      //挂号级别名称
	private String registerLevel_zjm;         //挂号级别助记码
	private double registerLevel_fee;	      //挂号费
	private String registerLevel_py;          //拼音码
	private String registerLevel_code;        //挂号级别编码(要做唯一性验证)
	
	public int getRegisterLevel_id() {
		return registerLevel_id;
	}
	public void setRegisterLevel_id(int registerLevel_id) {
		this.registerLevel_id = registerLevel_id;
	}
	public String getRegisterLevel_name() {
		return registerLevel_name;
	}
	public void setRegisterLevel_name(String registerLevel_name) {
		this.registerLevel_name = registerLevel_name;
	}
	public String getRegisterLevel_zjm() {
		return registerLevel_zjm;
	}
	public void setRegisterLevel_zjm(String registerLevel_zjm) {
		this.registerLevel_zjm = registerLevel_zjm;
	}
	public double getRegisterLevel_fee() {
		return registerLevel_fee;
	}
	public void setRegisterLevel_fee(double registerLevel_fee) {
		this.registerLevel_fee = registerLevel_fee;
	}
	public String getRegisterLevel_py() {
		return registerLevel_py;
	}
	public void setRegisterLevel_py(String registerLevel_py) {
		this.registerLevel_py = registerLevel_py;
	}
	public String getRegisterLevel_code() {
		return registerLevel_code;
	}
	public void setRegisterLevel_code(String registerLevel_code) {
		this.registerLevel_code = registerLevel_code;
	}
			
	
	
}
