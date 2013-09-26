/*
 *��ϻ���Action�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(jc_sf_combinationAccounting)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.10
 *
*/
package com.BasicInfoManagement.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import com.BasicInfoManagement.util.PageModel;

import com.BasicInfoManagement.model.JC_SF_CombinationAccounting;
import com.BasicInfoManagement.dao.CombinationAccountingDao;
import com.opensymphony.xwork2.ActionSupport;

public class CombinationAccountingAction extends ActionSupport implements RequestAware{
	private JC_SF_CombinationAccounting combinationAccounting;//JSPҳ���ж���
	public JC_SF_CombinationAccounting getCombinationAccounting() {
		return combinationAccounting;
	}
	public void setCombinationAccounting(
			JC_SF_CombinationAccounting combinationAccounting) {
		this.combinationAccounting = combinationAccounting;
	}
	private int currentPage;//��ȡJSPҳ����ҳ��
	private Map<String,Object> request;//����request�ӿ�
	private String QueryId;//��ȡJSP��ѯ���
	private Integer[] checkId;
	
	private HttpServletRequest request1;
	private HttpServletResponse response;
	
	
	public String getQueryId() {
		return QueryId;
	}
	public void setQueryId(String queryId) {
		QueryId = queryId;
	}
	public Integer[] getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer[] checkId) {
		this.checkId = checkId;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//��������Ϊrequest1 �� response��ʼ��
	public CombinationAccountingAction()
	{
		request1 = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	//�������
	public String AddCAccounting()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		
			cAccountingDao.SavaCAccounting(combinationAccounting);	//�����ݳ־û�
		return SUCCESS;
	}	
	//������ҳ��ӡ��Ϣ
	public String ShowPage()
	{
		int currentPage=1;//��ǰҳ
		int pageSize = 7; // ÿҳ��ʾ10����¼
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		if (getCurrentPage() != 0) {
			currentPage = getCurrentPage();
		}
		PageModel pageModel = cAccountingDao.FindPaging(currentPage, pageSize);
		request.put("pageModel", pageModel);
		return SUCCESS;
		
	}
	//ʹ��ѡ��CHECKBOXѡ��IDѭ��ɾ��
	public String DeleteCAccounting()
	{
		//ѭ��ɾ��
		for(Integer i: checkId){
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
			cAccountingDao.DeleteCAccountingById(i.intValue());//ɾ��
		}
		return SUCCESS;
		
	}
	//����
	public String UpdateCAccounting()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		cAccountingDao.SavaCAccounting(combinationAccounting);	//��������
		return SUCCESS;
	}
	//���ݱ����ѯ����
	public String QueryCAccountingDetail()
 {
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//ʵ����dao
		JC_SF_CombinationAccounting QueryCAccountingDetail = cAccountingDao.ReturnCAccountingById(getQueryId());//��ȡ����
		request.put("list", QueryCAccountingDetail);//��ʹ��request��ȡ���Ķ��󴫸�JSP
		return SUCCESS;
	}
	//�����Ϣ�ж������Ƿ��ظ���ʹ��request,responseȡֵ��ֵ��ajax
	public String JudgeCAccountingByName() throws Exception
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//ʵ����dao
		String combinationAccounting_name=new String(request1.getParameter("name").getBytes("ISO-8859-1"), "GB18030");//��ȡJSPҳ��ֵ	
		try
		{
				String responseTextByName="";
				if(cAccountingDao.FindCAccountingByName(combinationAccounting_name)==false)
				{
					responseTextByName="����ϻ��������Ѿ����ڡ�";
				}
				else
				{
					responseTextByName=""; 
				}
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/plain");
		  PrintWriter out=response.getWriter();
		  out.println(responseTextByName);
		  out.flush();
		  out.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	
	}
	//�����Ϣʱ�жϱ���Ƿ��ظ���ʹ��request,responseȡֵ��ֵ��ajax
	public String JudgeCAccountingByNumber()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//ʵ����dao
		String combinationAccounting_number=request1.getParameter("number");//��ȡJSPҳ��ֵ
		
		try
		{
				String responseTextByNumber="";
				if(cAccountingDao.FindCAccountingByNum(combinationAccounting_number)==false)
				{
					responseTextByNumber="����ϻ��۱���Ѿ����ڡ�";
				}
				else
				{
					responseTextByNumber="";
				}
		  response.setCharacterEncoding("gbk");
		  response.setContentType("text/plain");
		  PrintWriter out=response.getWriter();
		  out.println(responseTextByNumber);
		  out.flush();
		  out.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	
	}
	
	
	//�޸���Ϣ�ж������Ƿ��ظ���ʹ��request,responseȡֵ��ֵ��ajax
		public String JudgeCAccountingChangeByName() throws Exception
		{
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//ʵ����dao
			String combinationAccounting_name=new String(request1.getParameter("ChangeName").getBytes("ISO-8859-1"), "GB18030");//��ȡJSPҳ��ֵ	
			try
			{
					String responseTextByName="";
					if(cAccountingDao.FindCAccountingByName(combinationAccounting_name)==false)
					{
						responseTextByName="����ϻ��������Ѿ����ڡ�";
					}
					else
					{
						responseTextByName=""; 
					}
			  response.setCharacterEncoding("gbk");
			  response.setContentType("text/plain");
			  PrintWriter out=response.getWriter();
			  out.println(responseTextByName);
			  out.flush();
			  out.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return null;
		
		}
		//�޸���Ϣʱ�жϱ���Ƿ��ظ���ʹ��request,responseȡֵ��ֵ��ajax
		public String JudgeCAccountingChangeByNumber()
		{
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//ʵ����dao
			String combinationAccounting_number=request1.getParameter("ChangeNumber");//��ȡJSPҳ��ֵ
			
			try
			{
					String responseTextByNumber="";
					if(cAccountingDao.FindCAccountingByNum(combinationAccounting_number)==false)
					{
						responseTextByNumber="����ϻ��۱���Ѿ����ڡ�";
					}
					else
					{
						responseTextByNumber="";
					}
			  response.setCharacterEncoding("gbk");
			  response.setContentType("text/plain");
			  PrintWriter out=response.getWriter();
			  out.println(responseTextByNumber);
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
