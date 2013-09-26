package com.OutPatientService.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.BasicInfoManagement.model.JC_RY_Login;
import com.OutPatientService.dao.RegisterDao;
import com.OutPatientService.model.MZ_RegisterMain;
import com.OutPatientService.model.MZ_RegisterPatient;
import com.OutPatientService.model.SequenceGenerate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements ServletResponseAware {
	private String registerMain_No;  //������
	private Date registerMain_date;  //�Һ�����
	private String registerMain_caseNo;//������
	private String registerMain_name; //��������
	private String registerMain_sex; //�����Ա�
	private Date registerMain_birthday;//���߳�������
	private String registerMain_phoneNo;//������ϵ�绰
	private String registerMain_address;//���ߵ�ַ
	private String registerMain_rlCode; //�Һż������
	private String registerMainr_rlName; //�Һż�������
	private double registerMain_fee;       //�Һŷ�
	private String registerMain_deptCode; //���Һ�
	private String registerMain_deptName; //��������
	private String registerMain_docName; //ҽ������
	private String registerMain_invoiceNo; //��Ʊ��
	private String registerMain_operName;  //������Ա
	private Date registerMain_operDate;//����ʱ��
	private String registerMain_status;  //�Һ�״̬
	
	public String getRegisterMain_No() {
		return registerMain_No;
	}

	public void setRegisterMain_No(String registerMain_No) {
		this.registerMain_No = registerMain_No;
	}

	public Date getRegisterMain_date() {
		return registerMain_date;
	}

	public void setRegisterMain_date(Date registerMain_date) {
		this.registerMain_date = registerMain_date;
	}

	public String getRegisterMain_caseNo() {
		return registerMain_caseNo;
	}

	public void setRegisterMain_caseNo(String registerMain_caseNo) {
		this.registerMain_caseNo = registerMain_caseNo;
	}

	public String getRegisterMain_name() {
		return registerMain_name;
	}

	public void setRegisterMain_name(String registerMain_name) {
		this.registerMain_name = registerMain_name;
	}

	public String getRegisterMain_sex() {
		return registerMain_sex;
	}

	public void setRegisterMain_sex(String registerMain_sex) {
		this.registerMain_sex = registerMain_sex;
	}

	public Date getRegisterMain_birthday() {
		return registerMain_birthday;
	}

	public void setRegisterMain_birthday(Date registerMain_birthday) {
		this.registerMain_birthday = registerMain_birthday;
	}

	public String getRegisterMain_phoneNo() {
		return registerMain_phoneNo;
	}

	public void setRegisterMain_phoneNo(String registerMain_phoneNo) {
		this.registerMain_phoneNo = registerMain_phoneNo;
	}

	public String getRegisterMain_address() {
		return registerMain_address;
	}

	public void setRegisterMain_address(String registerMain_address) {
		this.registerMain_address = registerMain_address;
	}

	public String getRegisterMain_rlCode() {
		return registerMain_rlCode;
	}

	public void setRegisterMain_rlCode(String registerMain_rlCode) {
		this.registerMain_rlCode = registerMain_rlCode;
	}

	public String getRegisterMainr_rlName() {
		return registerMainr_rlName;
	}

	public void setRegisterMainr_rlName(String registerMainr_rlName) {
		this.registerMainr_rlName = registerMainr_rlName;
	}

	

	public double getRegisterMain_fee() {
		return registerMain_fee;
	}

	public void setRegisterMain_fee(double registerMain_fee) {
		this.registerMain_fee = registerMain_fee;
	}

	public String getRegisterMain_deptCode() {
		return registerMain_deptCode;
	}

	public void setRegisterMain_deptCode(String registerMain_deptCode) {
		this.registerMain_deptCode = registerMain_deptCode;
	}

	public String getRegisterMain_deptName() {
		return registerMain_deptName;
	}

	public void setRegisterMain_deptName(String registerMain_deptName) {
		this.registerMain_deptName = registerMain_deptName;
	}



	public String getRegisterMain_docName() {
		return registerMain_docName;
	}

	public void setRegisterMain_docName(String registerMain_docName) {
		this.registerMain_docName = registerMain_docName;
	}

	public String getRegisterMain_invoiceNo() {
		return registerMain_invoiceNo;
	}

	public void setRegisterMain_invoiceNo(String registerMain_invoiceNo) {
		this.registerMain_invoiceNo = registerMain_invoiceNo;
	}

	public String getRegisterMain_operName() {
		return registerMain_operName;
	}

	public void setRegisterMain_operName(String registerMain_operName) {
		this.registerMain_operName = registerMain_operName;
	}

	public Date getRegisterMain_operDate() {
		return registerMain_operDate;
	}

	public void setRegisterMain_operDate(Date registerMain_operDate) {
		this.registerMain_operDate = registerMain_operDate;
	}

	public String getRegisterMain_status() {
		return registerMain_status;
	}

	public void setRegisterMain_status(String registerMain_status) {
		this.registerMain_status = registerMain_status;
	}

	private HttpServletRequest request;
	private HttpServletResponse response;
	RegisterDao dao=new RegisterDao();
	
	
	
	
	public RegisterAction()
	{
		request = ServletActionContext.getRequest();
		
	}
	
	public String login()
	{
		return SUCCESS;
	}
	
	public String sequenceCode()    //���ɴ�����
	{
		
		Long code=dao.findSequenceCode();
		if(code==null)
		{
			SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMdd");
			String date=sDateFormat.format(new Date())+"00";
			Long temp=Long.parseLong(date);
			Long code1=temp+1;
			request.setAttribute("code", code1);
		}
		else
		{
			SimpleDateFormat sDateFormat1=new SimpleDateFormat("yyyyMMdd");
			String date1=sDateFormat1.format(new Date())+"00";
			Long temp1=Long.parseLong(date1);
			if(temp1>code)
			{
				Long code2=temp1+1;
			    request.setAttribute("code", code2);
			}
			else
			{
				Long code3=code+1;
				request.setAttribute("code", code3);
			}
		}
		return SUCCESS;
	}
	
	
	public String processLogin() throws IOException  //�����¼
	{
		
		String result;
		String username=new String(request.getParameter("userName").getBytes("ISO-8859-1"), "GB18030");
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
	
	public String findPaitent() throws IOException   //  �ڹҺ�ʱ�������û����벡���ź��Զ���仼��������Ϣ
	{
		JsonConfig jsonConfig = new JsonConfig();  /////////
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());/////////
		String case_No=request.getParameter("registerMain_caseNo");
		MZ_RegisterPatient paitent=dao.findpaitent(case_No);
		JSONObject json = JSONObject.fromObject(paitent,jsonConfig);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		
		return SUCCESS;
	}
	public String findRegister() throws IOException //�����˺�ʱ����ˢ��ҳ�棬���û����봦���ź��Զ���������Һ���Ϣ
	{
		JsonConfig jsonConfig = new JsonConfig();  /////////
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());/////////
		String chuFangNo=request.getParameter("chuFangNo");
		
		MZ_RegisterMain register=dao.findRegister(chuFangNo);
		JSONObject json = JSONObject.fromObject(register,jsonConfig);
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.println(json.toString());
		  out.flush();
		  out.close();
		
		return SUCCESS;
	}
	
	public String quitRegister()     //����˺�
	{
		String no=request.getParameter("registerMain_No");
		MZ_RegisterMain register=dao.getRegisterInfo(Integer.valueOf(no));
		register.setRegisterMain_status("�˺�");
		dao.saveRegister(register);
		return SUCCESS;
	}
	public String save()                             //���滼�߹Һ���Ϣ��
	{
		MZ_RegisterMain register=new MZ_RegisterMain();
		register.setRegisterMain_No(registerMain_No);
		register.setRegisterMain_date(registerMain_date);
		register.setRegisterMain_caseNo(registerMain_caseNo);
		register.setRegisterMain_name(registerMain_name);
		register.setRegisterMain_sex(registerMain_sex);
		register.setRegisterMain_birthday(registerMain_birthday);
		register.setRegisterMain_phoneNo(registerMain_phoneNo);
		register.setRegisterMain_address(registerMain_address);
		register.setRegisterMain_rlCode(registerMain_rlCode);
		register.setRegisterMainr_rlName(registerMainr_rlName);
		register.setRegisterMain_fee(registerMain_fee);
		register.setRegisterMain_deptCode(registerMain_deptCode);
		register.setRegisterMain_deptName(registerMain_deptName);
		register.setRegisterMain_docName(registerMain_docName);
		register.setRegisterMain_invoiceNo(registerMain_invoiceNo);
		register.setRegisterMain_operName(registerMain_operName);
		register.setRegisterMain_operDate(registerMain_operDate);
		register.setRegisterMain_status("����");
		
		SequenceGenerate code=new SequenceGenerate();
		code.setSequence_code(Long.parseLong(registerMain_No));
		
		dao.saveCode(code);
		dao.saveRegister(register);
		request.setAttribute("registerDetails", register);
		
		
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.put("registerMain_No", registerMain_No);
		
		
		return SUCCESS;
	}
	
	public void downloadWorDoc(OutputStream out)     //������word
	{
		try
		{
			ActionContext ctx=ActionContext.getContext();
		    Map session=ctx.getSession();
		    String no=(String)session.get("registerMain_No");
		
		MZ_RegisterMain findedregister=dao.findNo(no);
		StringBuilder sb=new StringBuilder();
		sb.append("");
		sb.append("---------------------------------------"+"\n");
		sb.append("                   "+"---------------------------------------"+"\n");
		sb.append("                               "+"�����ţ�");
		sb.append(findedregister.getRegisterMain_No()+"\n");
		
	    sb.append("                               "+"�Һ�ʱ�䣺");
	    sb.append(findedregister.getRegisterMain_date()+"\n");
	    sb.append("                               "+"�����ţ�");
	    sb.append(findedregister.getRegisterMain_caseNo()+"\n");
	    sb.append("                               "+"����������");
	    sb.append(findedregister.getRegisterMain_name()+"\n");
	    sb.append("                               "+"�����Ա�");
	    sb.append(findedregister.getRegisterMain_sex()+"\n");
	    sb.append("                               "+"���߳����գ�");
	    sb.append(findedregister.getRegisterMain_birthday()+"\n");
	    sb.append("                               "+"��ϵ�绰��");
	    sb.append(findedregister.getRegisterMain_phoneNo()+"\n");
	    sb.append("                               "+"���ߵ�ַ��");
	    sb.append(findedregister.getRegisterMain_address()+"\n");
	    sb.append("                               "+"�Һż���");
	    sb.append(findedregister.getRegisterMainr_rlName()+"\n");
	    sb.append("                               "+"�Һŷѣ�");
	    sb.append(findedregister.getRegisterMain_fee()+"\n");
	    sb.append("                               "+"�Һż�����룺");
	    sb.append(findedregister.getRegisterMain_rlCode()+"\n");
	    sb.append("                               "+"�������ƣ�");
	    sb.append(findedregister.getRegisterMain_deptName()+"\n");
	    sb.append("                               "+"���ұ��룺");
	    sb.append(findedregister.getRegisterMain_deptCode()+"\n");
	    sb.append("                               "+"ҽ������");
	    sb.append(findedregister.getRegisterMain_docName()+"\n");
	    sb.append("                               "+"��Ʊ�ţ�");
	    sb.append(findedregister.getRegisterMain_invoiceNo()+"\n");
	    
		writeWordDoc(sb.toString(),out);
	    }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void writeWordDoc(String content,OutputStream ostream)   //������word
	{
		ByteArrayInputStream bais=null;
		try
		{
			byte[] b=content.getBytes();
			bais=new ByteArrayInputStream(b);
			POIFSFileSystem fs=new POIFSFileSystem();
			DirectoryEntry directory=fs.getRoot();
			
			DocumentEntry de=directory.createDocument("WordDocument", bais);
			fs.writeFilesystem(ostream);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(bais!=null)
				{
					bais.close();
				}
				if(ostream!=null)
				{
					ostream.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public String down()    //Ϊ����ת�� down.jsp
	{
		return SUCCESS;
	}
	
	public String quit()
	{
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		session.remove("registerUserName");
		return SUCCESS;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		   this.response = response;
	}
	 
}
