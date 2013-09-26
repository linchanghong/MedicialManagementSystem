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
	private String PreCreptNumber;//������������Ĵ�����
	private String precreptNumber;//ҩƷ���ڵĴ�����
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
	//��ҩ����
	//��ȡ���ж�����JSP��
	public String ShowPatientNameDetail() {
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		List<Drugstore_Dosage> list=drugstoreDao.get("1");//��ȡ���ݿ���״̬Ϊ��1����ǵĴ�ӡ����
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
	//����ָ����������ǰ̨ҳ�洫�Һż������շ���Ϣ
	public String ShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"1");
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//������	
		return SUCCESS;
	}
	
	
	public String CommitFaYao()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(precreptNumber,"2");//�ɹ���ҩ�󽫴���״̬����Ϊ��2������ҩ
		return SUCCESS;
	}
	
	
	//��ҩ����Ҫ��Ϣ����
	public String FaYaoShowPatientNameDetail() {
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		List<Drugstore_Dosage> list=drugstoreDao.get("2");//��ȡ���ݿ���״̬Ϊ��2����ǵ���ҩ����
		List<Drugstore_Dosage> list2=drugstoreDao.get("3");//��ȡ���ݿ���״̬Ϊ��3����ǵ��ѷ�ҩ����
		List<Drugstore_Dosage> l1 = new ArrayList<Drugstore_Dosage>();//�洢δ��ҩ��������
		List<Drugstore_Dosage> l2 = new ArrayList<Drugstore_Dosage>();//�洢�ѷ�ҩ��������
		String number = null;
		//����δ��ҩ������Ϣ
		for(Drugstore_Dosage dd:list){			
			if(null==number || (!number.equals(dd.getPreCriptionNumber()))){
				Drugstore_Dosage o = new Drugstore_Dosage();
				o.setPreCriptionNumber(dd.getPreCriptionNumber());
				o.setPatientName(dd.getPatientName());
				l1.add(o);
				number = dd.getPreCriptionNumber();
			}
		}
		//��ȡ�ѷ�ҩ������Ϣ
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
	//δ��ҩ�и���ָ����������ǰ̨ҳ�洫�Һż������շ���Ϣ
	public String FaYaoShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"2");//��ȡ����δ��ҩ�Ĵ���ҩ��
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//������	
		return SUCCESS;
	}
	
	//δ��ҩ�гɹ�����״̬
	public String SuccessFaYao()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(PreCreptNumber,"3");//�ɹ���ҩ�󽫴���״̬����Ϊ��3���ѳɹ���ҩ
		return SUCCESS;
	}
	
	

	//�ѷ�ҩ�и���ָ����������ǰ̨ҳ�洫�Һż������շ���Ϣ
	public String YiFaYaoShowDrugDetailByPatientName()
	{
		List<Drugstore_Dosage> drugstore_Dosage=null;
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstore_Dosage=drugstoreDao.getByPrecreptNumber(PreCreptNumber,"3");//��ȡ�����ѷ�ҩ�Ĵ���ҩ��
		request.put("Patient", drugstore_Dosage.get(0));
		request.put("PatientDruginfo", drugstore_Dosage);//������	
		return SUCCESS;
	}
	
	//δ��ҩ�гɹ�����״̬
	public String ReturnDrug()
	{
		DrugstoreDao drugstoreDao = new DrugstoreDao();
		drugstoreDao.UpdatePrecreptCondition(precreptNumber,"4");//�ɹ���ҩ�󽫴���״̬����Ϊ��3���ѳɹ���ҩ
		return SUCCESS;
	}
	
	
	
	
	//����ΪҩƷ��ҩ����
	
	//��������ȷ�ķ�Ʊ��ʱ������Ϣ
	public String ShowDrugDetailByInvoiceNumber()throws IOException
	{
		String InvoicNumber=request1.getParameter("invoiceNum");//��ȡJSPҳ��ֵ
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
				responseTextByNumber="�÷�Ʊ�Ų����ڣ����������";
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
