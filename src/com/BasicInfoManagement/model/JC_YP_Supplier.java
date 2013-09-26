package com.BasicInfoManagement.model;
/*
 * 供应商信息
 */
public class JC_YP_Supplier {
public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_type() {
		return supplier_type;
	}
	public void setSupplier_type(String supplier_type) {
		this.supplier_type = supplier_type;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_number() {
		return supplier_number;
	}
	public void setSupplier_number(String supplier_number) {
		this.supplier_number = supplier_number;
	}
	public String getSupplier_zjm() {
		return supplier_zjm;
	}
	public void setSupplier_zjm(String supplier_zjm) {
		this.supplier_zjm = supplier_zjm;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public String getSupplier_postcode() {
		return supplier_postcode;
	}
	public void setSupplier_postcode(String supplier_postcode) {
		this.supplier_postcode = supplier_postcode;
	}
	public String getSupplier_telephone() {
		return supplier_telephone;
	}
	public void setSupplier_telephone(String supplier_telephone) {
		this.supplier_telephone = supplier_telephone;
	}
	public String getSupplier_fax() {
		return supplier_fax;
	}
	public void setSupplier_fax(String supplier_fax) {
		this.supplier_fax = supplier_fax;
	}
	public String getSupplier_linkman() {
		return supplier_linkman;
	}
	public void setSupplier_linkman(String supplier_linkman) {
		this.supplier_linkman = supplier_linkman;
	}
private int supplier_id;//供应商id
private String supplier_type;//供应商类型，取值为：设备供应商、卫材供应商、物质供应商、药品供应商
private String supplier_name;//供应商名称
private String supplier_number;//供应商编码
private String supplier_zjm;//助记码
private String supplier_address;//供应商地址
private String supplier_postcode;//供应商邮编
private String supplier_telephone;//供应商电话
private String supplier_fax;//供应商传真
private String supplier_linkman;//供应商联系人

}
