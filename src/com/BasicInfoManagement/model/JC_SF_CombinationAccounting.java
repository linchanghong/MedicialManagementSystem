package com.BasicInfoManagement.model;
/*
 *组合划价主体类
 *对应数据表组合划价项目(jc_sf_combinationAccounting)
 *编辑者：林世鹏
 *时间：2013.8.8
 *
*/
public class JC_SF_CombinationAccounting {

	private int combinationAccounting_id;//主键ID
	private	String combinationAccounting_name;//组合划价名称
	private String	combinationAccounting_number;//组合划价编号
	private	double combinationAccounting_price;//组合划价价格
	private String combinationAccounting_zjm;//助记码
	public int getCombinationAccounting_id() {
		return combinationAccounting_id;
	}
	public void setCombinationAccounting_id(int combinationAccounting_id) {
		this.combinationAccounting_id = combinationAccounting_id;
	}
	public String getCombinationAccounting_name() {
		return combinationAccounting_name;
	}
	public void setCombinationAccounting_name(String combinationAccounting_name) {
		this.combinationAccounting_name = combinationAccounting_name;
	}
	public String getCombinationAccounting_number() {
		return combinationAccounting_number;
	}
	public void setCombinationAccounting_number(String combinationAccounting_number) {
		this.combinationAccounting_number = combinationAccounting_number;
	}
	public double getCombinationAccounting_price() {
		return combinationAccounting_price;
	}
	public void setCombinationAccounting_price(double combinationAccounting_price) {
		this.combinationAccounting_price = combinationAccounting_price;
	}
	public String getCombinationAccounting_zjm() {
		return combinationAccounting_zjm;
	}
	public void setCombinationAccounting_zjm(String combinationAccounting_zjm) {
		this.combinationAccounting_zjm = combinationAccounting_zjm;
	}

}
