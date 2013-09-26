package com.OutPatientService.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.model.JC_RY_Login;
import com.OutPatientService.dao.PrescriptionDao;
import com.OutPatientService.dao.PrescriptionDetailsDao;
import com.OutPatientService.dao.RegisterDao;
import com.OutPatientService.model.MZ_Invoicedetail;
import com.OutPatientService.model.MZ_Invoiceinfo;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OutpatientChargeAction extends ActionSupport{
	
	private MZ_Invoiceinfo invoiceInfo;//门诊发票表（结算表）
	public MZ_Invoicedetail getInvoiceDetail() {
		return invoiceDetail;
	}
	public void setInvoiceDetail(MZ_Invoicedetail invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	private MZ_Invoicedetail invoiceDetail ;
	public MZ_Invoiceinfo getInvoiceInfo() {
		return invoiceInfo;
	}
	public void setInvoiceInfo(MZ_Invoiceinfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RegisterDao dao=new RegisterDao();
	public OutpatientChargeAction(){
		request = ServletActionContext.getRequest();
	}
	public String login()
	{
		return SUCCESS;
	}
	public String processLogin() throws IOException  //处理登录
	{
		String result;
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		JC_RY_Login user=dao.findUser(username, password);
		if(user!=null)
		{
			ActionContext ctx=ActionContext.getContext();
			Map session=ctx.getSession();
			session.put("registerUserName", username);
		    result=SUCCESS;
		}
		else
		{
			result="error";
		}
		
		return result;
	}
	public String a(){
		return SUCCESS;
	}
	//根据病例号返回处方信息和处方明细信息
	public String findPrescription() throws IOException {
		System.out.println("++++++++");
		PrescriptionDao dao=new PrescriptionDao();
		PrescriptionDetailsDao pdDao=new PrescriptionDetailsDao();
		MZ_Prescription pres=null;
		String caseNo=request.getParameter("caseNo");
		System.out.println("++++++++"+caseNo);
		pres=dao.findPrescriptionByCaseNo(caseNo);
		System.out.println("++++2222++++"+pres);
		System.out.println("---------"+pres.getPrescription_doctor());
		String num=pres.getPrescription_number();//处方号
		List<MZ_PrescriptionDetails> list=pdDao.findPrescriptionDetailsByNum(num);
		System.out.println("---------====="+list.size());
//		Map<String, Object> res=new HashMap<String, Object>() ;
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.put("fee", pres);
//		res.put("pres", pres);
//		res.put("presDetails", list);
		JSONObject json = JSONObject.fromObject(session);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		  return SUCCESS;
	}
}
