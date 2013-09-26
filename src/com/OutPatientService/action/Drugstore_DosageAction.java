package com.OutPatientService.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.RequestAware;

import com.OutPatientService.dao.DrugstoreDao;
import com.OutPatientService.model.Drugstore_Dosage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Drugstore_DosageAction extends ActionSupport implements RequestAware {
	private String PreCreptNumber;//患者姓名跟随的处方号
	private String precreptNumber;//药品属于的处方号
	private Drugstore_Dosage drugstore_Dosage;
	private Map<String, Object> request;
	private HttpServletRequest request1;
	private HttpServletResponse response;

	public Drugstore_DosageAction()
	{
		request1 = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	public String getPrecreptNumber() {
		return precreptNumber;
	}

	public void setPrecreptNumber(String precreptNumber) {
		this.precreptNumber = precreptNumber;
	}



	public String getPreCreptNumber() {
		return PreCreptNumber;
	}

	public void setPreCreptNumber(String preCreptNumber) {
		PreCreptNumber = preCreptNumber;
	}
	public Drugstore_Dosage getDrugstore_Dosage() {
		return drugstore_Dosage;
	}

	public void setDrugstore_Dosage(Drugstore_Dosage drugstore_Dosage) {
		this.drugstore_Dosage = drugstore_Dosage;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	//配药管理
	//获取所有对象往JSP传
	public String ShowPatientNameDetail() {
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		List<Drugstore_Dosage> list=drugstoreDao.get("1");//获取数据库中状态为“1”标记的打印处方
		List<Drugstore_Dosage> l2 = new ArrayList<Drugstore_Dosage>();
		String number = null;
		for(Drugstore_Dosage dd:list){			
			if(null==number || (!number.equals(dd.getPreCriptionNumber()))){
				Drugstore_Dosage o = new Drugstore_Dosage();
				o.setPreCriptionNumber(dd.getPreCriptionNumber());
				o.setPatientName(dd.getPatientName());
				l2.add(o);
				number = dd.getPreCriptionNumber();
			}
		}
		request.put("list", l2);
		return SUCCESS;
	}
	//根据指定处方号往前台页面传挂号及处方收费信息
	public String ShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"1");
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//传对象	
		return SUCCESS;
	}
	
	
	public String CommitFaYao()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(precreptNumber,"2");//成功配药后将处方状态更新为“2”已配药
		return SUCCESS;
	}
	
	
	//发药处主要信息管理
	public String FaYaoShowPatientNameDetail() {
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		List<Drugstore_Dosage> list=drugstoreDao.get("2");//获取数据库中状态为“2”标记的配药处方
		List<Drugstore_Dosage> list2=drugstoreDao.get("3");//获取数据库中状态为“3”标记的已发药处方
		List<Drugstore_Dosage> l1 = new ArrayList<Drugstore_Dosage>();//存储未发药处方数据
		List<Drugstore_Dosage> l2 = new ArrayList<Drugstore_Dosage>();//存储已发药处方数据
		String number = null;
		//或许未发药处方信息
		for(Drugstore_Dosage dd:list){			
			if(null==number || (!number.equals(dd.getPreCriptionNumber()))){
				Drugstore_Dosage o = new Drugstore_Dosage();
				o.setPreCriptionNumber(dd.getPreCriptionNumber());
				o.setPatientName(dd.getPatientName());
				l1.add(o);
				number = dd.getPreCriptionNumber();
			}
		}
		//获取已发药处方信息
		for(Drugstore_Dosage dd:list2){			
			if(null==number || (!number.equals(dd.getPreCriptionNumber()))){
				Drugstore_Dosage o = new Drugstore_Dosage();
				o.setPreCriptionNumber(dd.getPreCriptionNumber());
				o.setPatientName(dd.getPatientName());
				l2.add(o);
				number = dd.getPreCriptionNumber();
			}
		}
		request.put("list", l1);
		request.put("list2", l2);
		return SUCCESS;
	}
	//未发药中根据指定处方号往前台页面传挂号及处方收费信息
	public String FaYaoShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"2");//获取处方未发药的处方药材
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//传对象	
		return SUCCESS;
	}
	
	//未发药中成功更改状态
	public String SuccessFaYao()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(PreCreptNumber,"3");//成功发药后将处方状态更新为“3”已成功发药
		return SUCCESS;
	}
	
	

	//已发药中根据指定处方号往前台页面传挂号及处方收费信息
	public String YiFaYaoShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"3");//获取处方已发药的处方药材
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//传对象	
		return SUCCESS;
	}
	
	//未发药中成功更改状态
	public String ReturnDrug()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(precreptNumber,"4");//成功发药后将处方状态更新为“3”已成功发药
		return SUCCESS;
	}
	
	
	
	
	//以下为药品退药方法
	
	//当输入正确的发票码时现行信息
	public String ShowDrugDetailByInvoiceNumber()throws IOException
	{
		String InvoicNumber=request1.getParameter("invoiceNum");//获取JSP页面值
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			String responseTextByNumber="";
			drugstore_Dosage = drugstoreDao.getByPrecreptBillNumber(InvoicNumber, "3");
			if(drugstore_Dosage.size()==0)
			{
				responseTextByNumber="该发票号不存在，或输入错误。";
				out.println(responseTextByNumber);

			}else{
				ActionContext ctx = ActionContext.getContext();
				Map session = ctx.getSession();
				session.put("drugstore_Dosage", drugstore_Dosage);
				JSONObject json = JSONObject.fromObject(session);
				out.println(json.toString());
			}
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
