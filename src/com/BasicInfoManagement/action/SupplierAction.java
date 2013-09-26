package com.BasicInfoManagement.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.BasicInfoManagement.dao.SupplierDao;
import com.BasicInfoManagement.model.JC_YP_Supplier;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport  {
	
	private JC_YP_Supplier supplier;
    private List<JC_YP_Supplier> list;
	public List<JC_YP_Supplier> getList() {
		return list;
	}

	public void setList(List<JC_YP_Supplier> list) {
		this.list = list;
	}

	public JC_YP_Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(JC_YP_Supplier supplier) {
		this.supplier = supplier;
	}

	public String add() throws UnsupportedEncodingException{
		validateAdd();
		SupplierDao dao=new SupplierDao();
		String Supplier_name=new String(supplier.getSupplier_name().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_type=new String(supplier.getSupplier_type().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_number=new String(supplier.getSupplier_number().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_address=new String(supplier.getSupplier_address().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_postcode=new String(supplier.getSupplier_postcode().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_telephone=new String(supplier.getSupplier_telephone().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_fax=new String(supplier.getSupplier_fax().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_linkman=new String(supplier.getSupplier_linkman().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_zjm=new String(supplier.getSupplier_zjm().getBytes("ISO-8859-1"), "GB18030");
		JC_YP_Supplier obj=new JC_YP_Supplier();
		obj.setSupplier_name(Supplier_name);
		obj.setSupplier_type(Supplier_type);
		obj.setSupplier_number(Supplier_number);
		obj.setSupplier_address(Supplier_address);
		obj.setSupplier_postcode(Supplier_postcode);
		obj.setSupplier_telephone(Supplier_telephone);
		obj.setSupplier_fax(Supplier_fax);
		obj.setSupplier_linkman(Supplier_linkman);
		obj.setSupplier_zjm(Supplier_zjm);
		dao.saveSupplier(obj);
		return SUCCESS;
	}
	public String delete(){
		SupplierDao dao=new SupplierDao();
		dao.deleteSupplier(supplier.getSupplier_id());
		return SUCCESS;
	}
	public String update(){
		SupplierDao dao=new SupplierDao();
		supplier=dao.findSupplierById(supplier.getSupplier_id()).get(0);
		return SUCCESS;
	}
	public String saveUpdate() throws UnsupportedEncodingException{
		validateAdd();
		SupplierDao dao=new SupplierDao();
		supplier.setSupplier_id(supplier.getSupplier_id());
		String Supplier_name=new String(supplier.getSupplier_name().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_type=new String(supplier.getSupplier_type().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_number=new String(supplier.getSupplier_number().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_address=new String(supplier.getSupplier_address().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_postcode=new String(supplier.getSupplier_postcode().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_telephone=new String(supplier.getSupplier_telephone().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_fax=new String(supplier.getSupplier_fax().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_linkman=new String(supplier.getSupplier_linkman().getBytes("ISO-8859-1"), "GB18030");
		String Supplier_zjm=new String(supplier.getSupplier_zjm().getBytes("ISO-8859-1"), "GB18030");
		supplier.setSupplier_name(Supplier_name);
		supplier.setSupplier_type(Supplier_type);
		supplier.setSupplier_number(Supplier_number);
		supplier.setSupplier_zjm(supplier.getSupplier_zjm());
		supplier.setSupplier_address(Supplier_address);
		supplier.setSupplier_postcode(Supplier_postcode);
		supplier.setSupplier_telephone(Supplier_telephone);
		supplier.setSupplier_fax(Supplier_fax);
		supplier.setSupplier_linkman(Supplier_linkman);	
		supplier.setSupplier_zjm(Supplier_zjm);
		dao.saveSupplier(supplier);
		return SUCCESS;
	}
	public String query(){
		if(supplier.getSupplier_name().trim().equals("")&&supplier.getSupplier_type().equals("none")){
			return "queryAll";
		}else{
			supplier.setSupplier_name(supplier.getSupplier_name());
			supplier.setSupplier_type(supplier.getSupplier_type());
			SupplierDao dao=new SupplierDao();
			list=dao.findSupplier(supplier.getSupplier_name(), supplier.getSupplier_type());
			this.setList(list);
		return SUCCESS;
		}
	}
	public String returnIndex(){
		return SUCCESS;
	}
    public void validateAdd(){
    	if(null==supplier.getSupplier_name()||"".equals(supplier.getSupplier_name().trim())){
    		this.addFieldError("supplier.supplier_name", "请输入供应商名称！");
    	}
    	if("none".equals(supplier.getSupplier_type())){
    		this.addFieldError("supplier.supplier_type", "请选择供应商类型！");
    	}
    	if(null==supplier.getSupplier_number()||"".equals(supplier.getSupplier_number().trim())){
    		this.addFieldError("supplier.supplier_number", "请输入供应商编号！");
    	}
    }
}
