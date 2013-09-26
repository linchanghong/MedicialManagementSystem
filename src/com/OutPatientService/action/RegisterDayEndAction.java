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

	private Date dayEnd_beginDate;  //��ʼʱ��
	private Date dayEnd_endDate;    //��ֹ����
	private String dayEnd_oper;     //������Ա
	private double dayEnd_feeCount;  //�ܵĹҺŷ�
	private int dayEnd_danHaoZC;     //��������
	private int dayEnd_danHaoTH;     //�˺ŵ���
	private int dayEnd_danHaoCount;  //������ܵĵ���
	
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
	
	public String dayEnd() throws IOException    //ajax ���첽���ã����û������ս����󣬵����ѯ���ڹҺű����ҵ������Ϣ���Զ�������Ϣ
	{
		String dayEnd_oper=new String(request.getParameter("dayEnd_oper").getBytes("ISO-8859-1"), "GB18030");
		String dayEnd_beginDate=request.getParameter("dayEnd_beginDate");
		
		String dayEnd_endDate=request.getParameter("dayEnd_endDate");
		Double fee=dao.countFee(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper,"����");
		System.out.println("qq"+fee);
		Long danHaoZC=dao.countDanShuZC(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper, "����");
		
		Long danHaoTH=dao.countDanShuZC(dayEnd_beginDate, dayEnd_endDate, dayEnd_oper, "�˺�");
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
	
	public String saveDayEnd()      //�����ս���Ϣ
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
	
	public String queryAll()          //��ʾ���йҺ���Ϣ
	{
		fillData();
		return SUCCESS;
	}
	
	public String queryAllDayEnd()       //��ʾ���� �ս���Ϣ
	{
		   String page = request.getParameter("currPage");
		   int currPage = 1; // ��ǰҳ
			int pageSize = 18; // ÿҳ��ʾ5����¼
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findAllDayEnd(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	
	public String queryAllDayEnd_q() throws UnsupportedEncodingException       //���ڴ���   ��ѯ�ս���Ϣ 
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
		   int currPage = 1; // ��ǰҳ
			int pageSize = 20; // ÿҳ��ʾ5����¼
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findQueryDayEnd(currPage, pageSize, temp);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	
	public String query() throws UnsupportedEncodingException      //���ڴ���   ��ѯ�Һ���Ϣ
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
		   int currPage = 1; // ��ǰҳ
			int pageSize = 10; // ÿҳ��ʾ5����¼
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findQueryRegister(currPage, pageSize, temp);
		   request.setAttribute("pageModel", pageModel);
		return SUCCESS;
	}
	public void fillData()  //������ÿ����ת�� ҳ��ʱ������������ʾ�����С�
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // ��ǰҳ
			int pageSize = 9; // ÿҳ��ʾ5����¼
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	
	public String registerBuDa()                //��Ʊ����
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
		System.out.println("�����"+case_No);
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
		System.out.println("�����   777777777777777");
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
