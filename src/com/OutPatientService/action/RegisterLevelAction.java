package com.OutPatientService.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.dao.RegisterLevelDao;
import com.OutPatientService.model.MZ_RegisterLevel;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterLevelAction extends ActionSupport{

	    private Integer registerLevel_id;	
		private String registerLevel_name;	
		private String registerLevel_zjm;
		private Double registerLevel_fee;	
		private String registerLevel_py;
		private String registerLevel_code;
		private HttpServletRequest request;
		private String queryData;
		
		public String getQueryData() {
			return queryData;
		}

		public void setQueryData(String queryData) {
			this.queryData = queryData;
		}

		public Double getRegisterLevel_fee() {
			return registerLevel_fee;
		}

		public void setRegisterLevel_fee(Double registerLevel_fee) {
			this.registerLevel_fee = registerLevel_fee;
		}

		public Integer getRegisterLevel_id() {
			return registerLevel_id;
		}

		public void setRegisterLevel_id(Integer registerLevel_id) {
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

	private MZ_RegisterLevel mz_registerLevel=new MZ_RegisterLevel();
	RegisterLevelDao dao=new RegisterLevelDao();

	
	

	public RegisterLevelAction()
	{
	 request = ServletActionContext.getRequest();

	}
	
   public String query()
   {
	   String type=request.getParameter("queryType");
	   String data=this.queryData;//request.getParameter("queryData");
	   System.out.println(type+"###"+data);
	   if(type != null||data!=null){
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findQueryRegisterLevel(type,data);
		   request.setAttribute("pageModel", pageModel);
		}
	   return SUCCESS;
   }
   public String add()    //用于将新建的信息保存至数据库。
   {
	   System.out.println(registerLevel_name+"-----------");
	   if(registerLevel_id != null)
	   {
		   System.out.println(registerLevel_id);
		   MZ_RegisterLevel mz_registerLevel=dao.getRegisterLevel(registerLevel_id); //找到需要修改的科室。
		   mz_registerLevel.setRegisterLevel_name(registerLevel_name);
		   mz_registerLevel.setRegisterLevel_zjm(registerLevel_zjm);
		   mz_registerLevel.setRegisterLevel_fee(registerLevel_fee.doubleValue());
		   mz_registerLevel.setRegisterLevel_py(registerLevel_py);
		   mz_registerLevel.setRegisterLevel_code(registerLevel_code);
		   dao.saveRegisterLevel(mz_registerLevel);
		   fillData();
		   return SUCCESS;
	   }
	   
	   //mz_registerLevel.setRegisterLevel_id(registerLevel_id);
	   mz_registerLevel.setRegisterLevel_name(registerLevel_name);
	   mz_registerLevel.setRegisterLevel_zjm(registerLevel_zjm);
	   mz_registerLevel.setRegisterLevel_fee(registerLevel_fee.doubleValue());
	   mz_registerLevel.setRegisterLevel_py(registerLevel_py);
	   mz_registerLevel.setRegisterLevel_code(registerLevel_code);
	   dao.saveRegisterLevel(mz_registerLevel);  //入库
	   fillData();	   
	   return SUCCESS;
   }
   
   public String delete()
   {
	   String id=request.getParameter("registerLevel_id");
	   if(id != null){
			//删除留言信息
			dao.deleteRegisterLevel(Integer.valueOf(id));
			fillData();
		}
	   return SUCCESS;
   }
   

   
   public void fillData()  //用于在每次跳转到 DeptInfo_index页面时将所有数据显示在其中。
   {
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
