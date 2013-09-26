package com.BasicInfoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.IncompatibilityDao;
import com.BasicInfoManagement.model.JC_YP_Incompatibility;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class IncompatibilityAction extends ActionSupport {
	private HttpServletRequest request;
	private IncompatibilityDao dao=null;
	private JC_YP_Incompatibility incom;
	private Integer incompatibility_id;
	private String incompatibility_drugA;
	public String getIncompatibility_drugA() {
		return incompatibility_drugA;
	}
	public void setIncompatibility_drugA(String incompatibility_drugA) {
		this.incompatibility_drugA = incompatibility_drugA;
	}
	public String getIncompatibility_drugB() {
		return incompatibility_drugB;
	}
	public void setIncompatibility_drugB(String incompatibility_drugB) {
		this.incompatibility_drugB = incompatibility_drugB;
	}
	public String getIncompatibility_result() {
		return incompatibility_result;
	}
	public void setIncompatibility_result(String incompatibility_result) {
		this.incompatibility_result = incompatibility_result;
	}

	private String incompatibility_drugB;
	private String incompatibility_result;
	
	public Integer getIncompatibility_id() {
		return incompatibility_id;
	}
	public void setIncompatibility_id(Integer incompatibility_id) {
		this.incompatibility_id = incompatibility_id;
	}
	//private static String flag="success";
	//private JC_YP_Incompatibility incompate;
	public String saveIncompate()
	{
		String drugA;
		String drugB;
		String result;
		JC_YP_Incompatibility incompate=new JC_YP_Incompatibility();
		IncompatibilityDao dao=new IncompatibilityDao();
		drugA=request.getParameter("a");
		drugB=request.getParameter("b");
		result=request.getParameter("result");
		incompate.setIncompatibility_drugA(drugA);
		incompate.setIncompatibility_drugB(drugB);
		incompate.setIncompatibility_result(result);
		dao.saveIncompatibility(incompate);
		fillData();
		return SUCCESS;
	}
	public String updateIncompate()
	{
		
		Integer id;
		//String showid;
		incom=new JC_YP_Incompatibility();
		id=Integer.valueOf( request.getParameter("incompatibility_id"));
		
		dao=new IncompatibilityDao();
		incom=dao.findIncompatibilityById(id);
		
		incom.setIncompatibility_drugA(incompatibility_drugA);
		incom.setIncompatibility_drugB(incompatibility_drugB);
		incom.setIncompatibility_result(incompatibility_result);
		
		dao.saveIncompatibility(incom);
		
		fillData();
		return SUCCESS;
		
	}
	public String getIncomNumb()
	{
		JC_YP_Incompatibility incom=new JC_YP_Incompatibility();
		dao=new IncompatibilityDao();
		
		incom=dao.findIncompatibilityById(incompatibility_id);
		request.setAttribute("incom", incom);
		
		return SUCCESS;
	}
	public String deleteIncompate()
	{
		
		dao=new IncompatibilityDao();
		dao.removeIncompatibilityByName(incompatibility_id);
		fillData();
		return SUCCESS;
	}
	public IncompatibilityAction()
	{
		request=ServletActionContext.getRequest();
	}
	 public String query()
	   {
		
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   dao=new IncompatibilityDao();
		   if(type != null||data!=null){
				//删除留言信息
			  // System.out.print("wwwwwwww"+data);
			   List findIncompateInfo=dao.findIncompatibilityInfo(type,data);
			  // System.out.print("zzzzzzzzzzzzzzzz"+findIncompateInfo);
			   request.setAttribute("list", findIncompateInfo);
			}
		   fillData();
		   return SUCCESS;
	   }
	public void fillData()  //用于在每次跳转到 DeptInfo_index页面时将所有数据显示在其中。
	   {
		   dao=new IncompatibilityDao();
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 7; // 每页显示5条记录
			
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
			
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	   
	   public String queryAll()
	   {
		   fillData();
		   
		   return SUCCESS;
	   }
}
