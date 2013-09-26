package com.OutPatientService.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.model.JC_RY_Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RegisterInterceptor extends AbstractInterceptor {
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	public RegisterInterceptor()
	{
		
	}

	public String intercept(ActionInvocation ai)throws Exception
	{
		String result;
		ActionContext ctx=ai.getInvocationContext();
	    Map session=ctx.getSession();
	    String user=(String)session.get("registerUserName");
	    if(user==null)
	    {
	    	result="error";
	    }
	    else
	    {
	    	result=ai.invoke();
	    }

		return result;
	}
}
