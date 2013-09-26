package com.BasicInfoManagement.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.BedInfoDao;
import com.BasicInfoManagement.dao.DeptInfoDao;
import com.opensymphony.xwork2.ActionSupport;

public class BedInfoValidateAction extends ActionSupport {

	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private BedInfoDao dao=new BedInfoDao();
	public BedInfoValidateAction()
	{
		request = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	public String numberValidate() throws UnsupportedEncodingException     //验证科室编码的唯一性
	{
		String bed_number=new String(request.getParameter("number").getBytes("ISO-8859-1"), "GB18030");
		
		try
		{
			String responseText="";
			if(bed_number.length()<1)
			{
				responseText="床位编号不能为空。";
			}
			else
			{
				if(dao.bedValidateNumber(bed_number))
				{
					responseText="该床位编号已经存在。";
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
}
