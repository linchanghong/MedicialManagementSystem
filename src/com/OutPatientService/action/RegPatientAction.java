package com.OutPatientService.action;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

//import org.apache.struts2.ServletActionContext;

//import com.BasicInfoManagement.dao.CipherPresDao;
import com.OutPatientService.dao.RegPatientDao;
import com.BasicInfoManagement.dao.CipherPresDao;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_RegisterPatient;
import com.opensymphony.xwork2.ActionSupport;
//import java.util.TreeSet;
import java.util.Scanner;
public class RegPatientAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private RegPatientDao dao=null;
	private MZ_RegisterPatient regPatient;
	private PageModel pageModel;
	private List<?> datalist;
	
	public List<?> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<?> datalist) {
		this.datalist = datalist;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public int regiserPatient_id;
	private String regiserPatient_caseNo;
	private String queryData;
	private Date regiserPatient_birthday;
	public Date getRegiserPatient_birthday() {
		return regiserPatient_birthday;
	}
	public void setRegiserPatient_birthday(Date regiserPatient_birthday) {
		this.regiserPatient_birthday = regiserPatient_birthday;
	}
	public String getQueryData() {
		return queryData;
	}
	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	private String queryType;
	public int getRegiserPatient_id() {
		return regiserPatient_id;
	}
	public void setRegiserPatient_id(int regiserPatient_id) {
		this.regiserPatient_id = regiserPatient_id;
	}
	public MZ_RegisterPatient getRegPatient() {
		return regPatient;
	}
	public void setRegPatient(MZ_RegisterPatient regPatient) {
		this.regPatient = regPatient;
	}
	public RegPatientAction()
	{
		//request=new ServletActionContext.getRequest();
		  request=ServletActionContext.getRequest();
	}
	public void fillData()
	{
		dao=new RegPatientDao();
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 10; // 每页显示5条记录
			
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
			
		   request.removeAttribute("pageModel");
		   pageModel=dao.findPaging(currPage, pageSize);
		   
		   
		   
		   
		   request.setAttribute("pageModel", pageModel);
		   setPageModel(pageModel);
		   request.setAttribute("datelist", dao.getDatelist());
	}
	public String queryAll()
	{
		fillData();
		
		return SUCCESS;
	}
	public String save()
	{
		dao=new RegPatientDao();
		Date d=null;
		if(regPatient==null)
    	

		
		dao.saveRegPatient(regPatient);
//		
    	fillData();
		
		return SUCCESS;
	}
	public String delete()
	{
		dao=new RegPatientDao();
		dao.removeRegPatient(regiserPatient_id);
		fillData();
		return SUCCESS;
	}
	public String getStringTime()
	{
//		String time="1256006105375";
//		Date date=new Date(Long.parseLong(time.trim()));
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String datestring=formatter.format(date);
		String datestring=formatter.format(new Date());
		
		char[] ch=datestring.toCharArray();
		//char[] str=new char[20];
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<ch.length;i++)
		{
			if((int)ch[i]>='0'&&(int)ch[i]<='9')
			{
		//		str[i]=(char)ch[i];
				sb.append((char)ch[i]);
		//		System.out.println("字符"+str[i]);
			}
		}
		//String string=new String(str);
		//System.out.println("cccccccccccccccc"+string.trim()+sb);
		request.setAttribute("regiserPatient_caseNo", sb);
		return SUCCESS;	
		
	}
	public String conditionQuery()
	{
       	   String type=request.getParameter("queryType");
	       String data=request.getParameter("queryData");
		   System.out.println("条件查询"+queryType+" "+queryData);
		   dao=new RegPatientDao();
		   if(queryType != null||queryData!=null){
				//删除留言信息
			  // System.out.print("wwwwwwww"+data);
			   List findRegPatientInfo=dao.findRegPatientInfo(type, data);
			   setDatalist(findRegPatientInfo);
			 
			   request.setAttribute("list", findRegPatientInfo);
			}
		   fillData();
		   return SUCCESS;
	}

}
