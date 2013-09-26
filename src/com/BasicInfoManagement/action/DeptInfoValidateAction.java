package com.BasicInfoManagement.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DeptInfoDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeptInfoValidateAction extends ActionSupport {
	
	private String deptInfo_number;
	private String tip;
	private DeptInfoDao dao=new DeptInfoDao();
	

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String getDeptInfo_number() {
		return deptInfo_number;
	}
	public void setDeptInfo_number(String deptInfo_number) {
		this.deptInfo_number = deptInfo_number;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public DeptInfoValidateAction()
	{
		request = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	public String numberValidate() throws UnsupportedEncodingException     //��֤���ұ����Ψһ��
	{
		String deptInfo_number=new String(request.getParameter("number").getBytes("ISO-8859-1"), "GB18030");
		
		try
		{
			String responseText="";
			if(deptInfo_number.length()<1)
			{
				responseText="���ұ��벻��Ϊ�ա�";
			}
			else
			{
				if(dao.deptNumberValidate(deptInfo_number))
				{
					responseText="�ÿ��ұ���Ѿ����ڡ�";
				}
				else
				{
					responseText="";
				}
			}
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/plain");
		  PrintWriter out=response.getWriter();
		  out.println(responseText);
		  out.flush();
		  out.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public String nameValidate() throws UnsupportedEncodingException    //��֤�������Ƶ�Ψһ��
	{
		
		String deptInfo_name=new String(request.getParameter("name").getBytes("ISO-8859-1"), "GB18030");//��ȡJSPҳ��ֵ
		try
		{
			String responseText1="";
			if(deptInfo_name.length()<1)
			{
				responseText1="�������Ʋ���Ϊ�ա�";
			}
			else
			{
				if(dao.deptNameValidate(deptInfo_name))
				{
					responseText1="�ÿ��������Ѿ����ڡ�";
				}
				else
				{
					responseText1="";
				}
			}
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/plain");
		  PrintWriter out=response.getWriter();
		  out.println(responseText1);
		  out.flush();
		  out.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String zjmValidate() throws UnsupportedEncodingException    //��֤�����������Ψһ��
	{
		String deptInfo_zjm=new String(request.getParameter("zjm").getBytes("ISO-8859-1"), "GB18030");
		
		try
		{
			String responseText2="";
			if(deptInfo_zjm.length()<1)
			{
				responseText2="���������벻��Ϊ�ա�";
			}
			else
			{
				if(dao.deptZjmValidate(deptInfo_zjm))
				{
					responseText2="�ÿ��ұ��������Ѿ����ڡ�";
				}
				else
				{
					responseText2="";
				}
			}
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/plain");
		  PrintWriter out=response.getWriter();
		  out.println(responseText2);
		  out.flush();
		  out.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}


}
