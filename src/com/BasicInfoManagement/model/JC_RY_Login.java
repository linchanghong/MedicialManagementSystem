package com.BasicInfoManagement.model;
/*
 * 用户登录维护
 */
public class JC_RY_Login {
	private int login_id;                 //主键
	private String login_password;        //密码
	private String login_name;            //用户名
	private String login_type;            //用户权限
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}


}
