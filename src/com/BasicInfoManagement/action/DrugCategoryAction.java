package com.BasicInfoManagement.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.*;
import com.BasicInfoManagement.model.JC_YP_DrugCategory;
import com.opensymphony.xwork2.ActionSupport;

public class DrugCategoryAction extends ActionSupport {
	private JC_YP_DrugCategory drugCategory;
	private List<JC_YP_DrugCategory> list;
	public List<JC_YP_DrugCategory> getList() {
		return list;
	}
	public void setList(List<JC_YP_DrugCategory> list) {
		this.list = list;
	}
//	private HttpServletRequest request;
//	public DrugCategoryAction(){
//		System.out.print(ServletActionContext.getRequest().getContextPath()+"***");
//		this.request = ServletActionContext.getRequest();
//	}
	public JC_YP_DrugCategory getDrugCategory() {
		return drugCategory;
	}
	public void setDrugCategory(JC_YP_DrugCategory drugCategory) {
		this.drugCategory = drugCategory;
	}
	public String update(){	
		DrugCategoryDao dao=new DrugCategoryDao();
		drugCategory=dao.findDrugCategoryById(drugCategory.getDrugCategory_id()).get(0);
		return SUCCESS;
	}
	public String saveUpdate() throws UnsupportedEncodingException{
		validateAdd();
		DrugCategoryDao dao=new DrugCategoryDao();
		String DrugCategory_name=new String(drugCategory.getDrugCategory_name().getBytes("ISO-8859-1"), "GB18030");
		String DrugCategory_number=new String(drugCategory.getDrugCategory_number().getBytes("ISO-8859-1"), "GB18030");
		String DrugCategory_zjm=new String(drugCategory.getDrugCategory_zjm().getBytes("ISO-8859-1"), "GB18030");
		drugCategory.setDrugCategory_id(drugCategory.getDrugCategory_id());
		drugCategory.setDrugCategory_name(DrugCategory_name);
		drugCategory.setDrugCategory_number(DrugCategory_number);
		drugCategory.setDrugCategory_zjm(DrugCategory_zjm);
		dao.saveDrugCategory(drugCategory);
		return SUCCESS;
	}
	public String delete(){
		    
			DrugCategoryDao dao=new DrugCategoryDao();
			dao.deleteDrugCategory(drugCategory.getDrugCategory_id());
			return SUCCESS;
		
	}
	public String add() throws UnsupportedEncodingException{
		validateAdd();
		String DrugCategory_name=new String(drugCategory.getDrugCategory_name().getBytes("ISO-8859-1"), "GB18030");
		String DrugCategory_number=new String(drugCategory.getDrugCategory_number().getBytes("ISO-8859-1"), "GB18030");
		String DrugCategory_zjm=new String(drugCategory.getDrugCategory_zjm().getBytes("ISO-8859-1"), "GB18030");
		
		DrugCategoryDao dao=new DrugCategoryDao();
		JC_YP_DrugCategory obj=new JC_YP_DrugCategory();
		obj.setDrugCategory_name(DrugCategory_name);
		obj.setDrugCategory_number(DrugCategory_number);
		obj.setDrugCategory_zjm(DrugCategory_zjm);
		dao.saveDrugCategory(obj);
		return SUCCESS;
	}
	public String query(){				
		if(drugCategory.getDrugCategory_name().trim().equals("")){
			drugCategory.setDrugCategory_name("");
			return "queryAll";
		}else{
			drugCategory.setDrugCategory_name(drugCategory.getDrugCategory_name());
			DrugCategoryDao dao=new DrugCategoryDao();
			list=dao.findDrugCategoryByName(drugCategory.getDrugCategory_name());
			
			this.setList(list);
			
			return SUCCESS;
		}
	}
	public String returnIndex(){
		return SUCCESS;
	}
    public void validateAdd()
    {
        if(null == this.drugCategory.getDrugCategory_name() || "".equals(this.drugCategory.getDrugCategory_name().trim()))
        {
            //第一个参数表示表单中的textfield的name,第二参数是提示信息
            this.addFieldError("drugCategory.drugCategory_name", "请输入药品分类名称!");
        }
        if(null == this.getDrugCategory().getDrugCategory_number() || "".equals(this.getDrugCategory().getDrugCategory_number().trim()))
        {
            this.addFieldError("drugCategory.drugCategory_number", "请输入药品分类编号");
        }
    }
    
}
