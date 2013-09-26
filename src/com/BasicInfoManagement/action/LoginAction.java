package com.BasicInfoManagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.BasicInfoManagement.util.PageModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.LoginDao;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_Login;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String login_name;//用户名
	private String login_password;//密码
	private String login_type;//类型
	private JC_RY_Login jc_ry_login =new JC_RY_Login();//实例化登录用户维护类
	LoginDao logindao=new LoginDao();
	private HttpServletRequest request=ServletActionContext.getRequest();
	
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String add(){
//		System.out.print(login_name);
//		System.out.print(login_password);
//		System.out.print(login_type);
		jc_ry_login.setLogin_name(login_name);
		jc_ry_login.setLogin_password(login_password);
		jc_ry_login.setLogin_type(login_type);		
		logindao.saveUser(jc_ry_login);
		queryAll();
		return SUCCESS;
	}
	
	public String query()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   if(type != null||data!=null){

			   List jc_ry_login2=logindao.findLogin(type, data);
			   request.setAttribute("list", jc_ry_login2);
			}
		   return SUCCESS;
	   }
	
	
	 public String delete()
	   {
		   String id=request.getParameter("login_id");
		   if(id != null){
				//删除留言信息
				logindao.deleteUser(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	
	  public String modify1()     //获得要更新用户，将其现有的数据显示在一个jsp上。
	   {
		   String id=request.getParameter("login_id");
		   if(id != null)
		   {
			   request.setAttribute("loginmodifyInfo", logindao.getLogin(Integer.valueOf(id)));
		   }
		   return SUCCESS;
	   }
	   public String modify2()    //更新，入库。
	   {
		   String id=request.getParameter("id");
		  
		   JC_RY_Login jc_ry_login1=new JC_RY_Login();
		   jc_ry_login1=logindao.getLogin(Integer.valueOf(id)); //找到需要修改的用户
		   jc_ry_login1.setLogin_name(login_name);
		   jc_ry_login1.setLogin_password(login_password);
		   jc_ry_login1.setLogin_type(login_type);
		   logindao.saveUser(jc_ry_login1);  //入库	
		  
		   queryAll();
		   return SUCCESS;
	   }
	
	
	  public void fillData()  //用于在每次跳转到 页面时将所有数据显示在其中。
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 11; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=logindao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	   
	   public String queryAll()
	   {
		   fillData();
		   return SUCCESS;
	   }
	public String isInput() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter p=response.getWriter();
		String username=request.getParameter("login_name");
		if( logindao.isUser(username)==true)
		{
			p.print("true");
			System.out.print("true");
		}
		else
			p.print("flase");
		System.out.print("false");
		return null;
	}


}
