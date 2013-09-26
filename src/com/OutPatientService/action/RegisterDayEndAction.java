package com.OutPatientService.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.dao.OutpatientChargeDao;
import com.OutPatientService.dao.PrescriptionDao;
import com.OutPatientService.dao.PrescriptionDetailsDao;
import com.OutPatientService.dao.RegisterDayEndDao;
import com.OutPatientService.model.MZ_DayEnd;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.OutPatientService.model.MZ_RegisterMain;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterDayEndAction extends ActionSupport {

	private Date dayEnd_beginDate;  //开始时间
	private Date dayEnd_endDate;    //截止日期
	private String dayEnd_oper;     //操作人员
	private double dayEnd_feeCount;  //总的挂号费
	private int dayEnd_danHaoZC;     //正常单数
	private int dayEnd_danHaoTH;     //退号单数
	private int dayEnd_danHaoCount;  //处理的总的单数
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	RegisterDayEndDao dao=new RegisterDayEndDao();
	
	public Date getDayEnd_beginDate() {
		return dayEnd_beginDate;
	}
	public void setDayEnd_beginDate(Date dayEnd_beginDate) {
		this.dayEnd_beginDate = dayEnd_beginDate;
	}
	public Date getDayEnd_endDate() {
		return dayEnd_endDate;
	}
	public void setDayEnd_endDate(Date dayEnd_endDate) {
		this.dayEnd_endDate = dayEnd_endDate;
	}
	public String getDayEnd_oper() {
		return dayEnd_oper;
	}
	public void setDayEnd_oper(String dayEnd_oper) {
		this.dayEnd_oper = dayEnd_oper;
	}
	public double getDayEnd_feeCount() {
		return dayEnd_feeCount;
	}
	public void setDayEnd_feeCount(double dayEnd_feeCount) {
		this.dayEnd_feeCount = dayEnd_feeCount;
	}
	public int getDayEnd_danHaoZC() {
		return dayEnd_danHaoZC;
	}
	public void setDayEnd_danHaoZC(int dayEnd_danHaoZC) {
		this.dayEnd_danHaoZC = dayEnd_danHaoZC;
	}
	public int getDayEnd_danHaoTH() {
		return dayEnd_danHaoTH;
	}
	public void setDayEnd_danHaoTH(int dayEnd_danHaoTH) {
		this.dayEnd_danHaoTH = dayEnd_danHaoTH;
	}
	public int getDayEnd_danHaoCount() {
		return dayEnd_danHaoCount;
	}
	public void setDayEnd_danHaoCount(int dayEnd_danHaoCount) {
		this.dayEnd_danHaoCount = dayEnd_danHaoCount;
	}
	
	public RegisterDayEndAction()
	{
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
	}
	public String findMaxBeginDate() throws IOException
	{
		String dayEnd_oper=new String(request.getParameter("dayEnd_oper").getBytes("ISO-8859-1"), "GB18030");	
		String temp1=null;
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=dao.findMaxDate(dayEnd_oper);
		if(date==null)
		{
			Calendar c=Calendar.getInstance(); 
			c.add(Calendar.DAY_OF_MONTH, -1);
			temp1=sDateFormat.format(c.getTime());
		}
		else
		{
			
			temp1=sDateFormat.format(date);
			
		}
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.put("temp1", temp1);
		JSONObject json = JSONObject.fromObject(session);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		return SUCCESS;
	}
	
	public String dayEnd() throws IOException    //ajax 中异步调用，单用户输入日结对象后，点击查询，在挂号表中找到相关信息，自动返回信息
	{
		String dayEnd_oper=new String(request.getParameter("dayEnd_oper").getBytes("ISO-8859-1"), "GB18030");
		String dayEnd_beginDate=request.getParameter("dayEnd_beginDate");
		
		String dayEnd_endDate=request.getParameter("dayEnd_endDate");
		Double fee=dao.countFee(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper,"正常");
		System.out.println("qq"+fee);
		Long danHaoZC=dao.countDanShuZC(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper, "正常");
		
		Long danHaoTH=dao.countDanShuZC(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper, "退号");
		Long temp=danHaoZC+danHaoTH*2;
		Double danHaoCount=temp.doubleValue();
		
		
		
		
		
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.put("fee", fee);
		session.put("danHaoZC", danHaoZC);
		session.put("danHaoTH", danHaoTH);
		session.put("danHaoCount", danHaoCount);
		
		
		  JSONObject json = JSONObject.fromObject(session);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		
		return SUCCESS;
	}
	
	public String saveDayEnd()      //保存日结信息
	{
		MZ_DayEnd DayEnd=new MZ_DayEnd();
		DayEnd.setDayEnd_beginDate(dayEnd_beginDate);
		DayEnd.setDayEnd_endDate(dayEnd_endDate);
		DayEnd.setDayEnd_feeCount(dayEnd_feeCount);
		DayEnd.setDayEnd_danHaoCount(dayEnd_danHaoCount);
		DayEnd.setDayEnd_danHaoZC(dayEnd_danHaoZC);
		DayEnd.setDayEnd_danHaoTH(dayEnd_danHaoTH);
		DayEnd.setDayEnd_oper(dayEnd_oper);
		
		dao.saveDayEnd(DayEnd);
		return SUCCESS;
	}
	
	public String queryAll()          //显示所有挂号信息
	{
		fillData();
		return SUCCESS;
	}
	
	public String queryAllDayEnd()       //显示所有 日结信息
	{
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 18; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findAllDayEnd(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	
	public String queryAllDayEnd_q() throws UnsupportedEncodingException       //用于处理   查询日结信息 
	{
		
		
		String temp=null;
		String a=request.getParameter("next1");
		if(a!=null)
		{
			String oper=request.getParameter("oper");
			temp=oper;
			request.setAttribute("oper", oper);
		}
		else
		{
			String oper=new String(request.getParameter("oper").getBytes("ISO-8859-1"), "GB18030");
			temp=oper;
			request.setAttribute("oper", oper);
		}
		
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 20; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findQueryDayEnd(currPage, pageSize, temp);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	
	public String query() throws UnsupportedEncodingException      //用于处理   查询挂号信息
	{
		String temp=null; 
		String a=request.getParameter("next1");
		if(a!=null)
		{
			String status=request.getParameter("queryType");
			temp=status;
			request.setAttribute("queryType", status);
		}
		else
		{
			String status=new String(request.getParameter("queryType").getBytes("ISO-8859-1"), "GB18030");
			temp=status;
			request.setAttribute("queryType", status);
		}
		
		
		String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 10; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findQueryRegister(currPage, pageSize, temp);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	public void fillData()  //用于在每次跳转到 页面时将所有数据显示在其中。
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 9; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	
	public String registerBuDa()                //发票补打
	{
		String chuFangHao=request.getParameter("chuFangHao");
		MZ_RegisterMain register=dao.findMZ_RegisterMain(chuFangHao);
		request.setAttribute("registerDetails", register);
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.put("registerMain_No", chuFangHao);
		return SUCCESS;
	}
	
	public String findPrescription() throws IOException
	{
		OutpatientChargeDao dao=new OutpatientChargeDao();
		JsonConfig jsonConfig = new JsonConfig();  /////////
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());/////////
		String case_No=request.getParameter("registerMain_caseNo");
		System.out.println("王义彬"+case_No);
		MZ_Prescription prescription=dao.findprescription(case_No);
		JSONObject json = JSONObject.fromObject(prescription,jsonConfig);
		System.out.println(prescription);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		return SUCCESS;
	}
	
	public String changePrescription()
	{
		System.out.println("王义彬   777777777777777");
		String no=request.getParameter("number");
		OutpatientChargeDao dao=new OutpatientChargeDao();
		MZ_Prescription prescription=dao.findprescription(no);
		MZ_PrescriptionDetails pre=dao.findPrescriptionDetails(no);
		pre.setPrescriptionDetails_chargeflag("1");
		prescription.setPrescription_state("1");
		PrescriptionDao dao1=new PrescriptionDao();
		PrescriptionDetailsDao dao2=new PrescriptionDetailsDao();
		dao1.savePrescription1(prescription);
		dao2.savePrescriptionDetails(pre);
		
		return SUCCESS;
	}
}
