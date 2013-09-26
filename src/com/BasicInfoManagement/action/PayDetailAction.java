/*
 *�շ���Ŀ����Action�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_PayDetail)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.8
 *
*/
package com.BasicInfoManagement.action;
import java.util.Map;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.RequestAware;

import com.BasicInfoManagement.util.PageModel;

import com.BasicInfoManagement.model.JC_SF_PayDetail;
import com.BasicInfoManagement.dao.CombinationAccountingDao;
import com.BasicInfoManagement.dao.PayDetailDao;
import com.opensymphony.xwork2.ActionSupport;
public class PayDetailAction extends ActionSupport implements RequestAware{
	private JC_SF_PayDetail payDetail;//JSPҳ���ж���
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

	public JC_SF_PayDetail getPayDetail() {
		return payDetail;
	}

	public void setPayDetail(JC_SF_PayDetail payDetail) {
		this.payDetail = payDetail;
	}
	public PayDetailAction()
	{
		request1 = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	public String AddPayDetail()
	{
		PayDetailDao payDao=new PayDetailDao();
		payDao.SavaPayDetail(payDetail);	
		return SUCCESS;
	}	
	public String ShowPage()
	{
		int currentPage=1;//��ǰҳ
		int pageSize = 6; // ÿҳ��ʾ10����¼
		PayDetailDao payDao=new PayDetailDao();
		if (getCurrentPage() != 0) {
			currentPage = getCurrentPage();
		}
		PageModel pageModel = payDao.FindPaging(currentPage, pageSize);
		System.out.println(pageModel.getList().size());
		request.put("pageModel", pageModel);
		return SUCCESS;
		
	}
	public String DeletePayDetail()
	{
		for(Integer i: checkId){
			PayDetailDao payDao=new PayDetailDao();
			payDao.DeleteDetailById(i.intValue());
		}
		return SUCCESS;
		
	}
	public String UpdatePayDetail()
	{
		PayDetailDao payDao=new PayDetailDao();
		payDao.SavaPayDetail(payDetail);	
		return SUCCESS;
	}
	public String QueryPayDetail()
 {
		PayDetailDao payDao = new PayDetailDao();
		JC_SF_PayDetail QueryPayDetail = payDao.ReturnDetailById(getQueryId());
		request.put("list", QueryPayDetail);
		return SUCCESS;
	}
	//�����Ϣ�ж������Ƿ��ظ���ʹ��request,responseȡֵ��ֵ��ajax
		public String JudgePayDetailByName() throws Exception
		{
			PayDetailDao payDao=new PayDetailDao();//ʵ����dao
			String payDetail_name=new String(request1.getParameter("name").getBytes("ISO-8859-1"), "GB18030");//��ȡJSPҳ��ֵ
			System.out.println(payDetail_name);
			try
			{
					String responseTextByName="";
					if(payDao.FindDetailByName(payDetail_name)==false)
					{
						responseTextByName="����ϸ�շ���Ŀ�����Ѿ����ڡ�";
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
		public String JudgePayDetailByNumber()
		{
			PayDetailDao payDao=new PayDetailDao();//ʵ����dao
			String payDetail_number=request1.getParameter("number");//��ȡJSPҳ��ֵ
			
			try
			{
					String responseTextByNumber="";
					if(payDao.FindDetailByNum(payDetail_number)==false)
					{
						responseTextByNumber="����ϸ�շ���Ŀ����Ѿ����ڡ�";
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
		public String JudgePayDetailChangeByName() throws Exception
		{

			PayDetailDao payDao=new PayDetailDao();//ʵ����dao
			String payDetail_name=new String(request1.getParameter("ChangeName").getBytes("ISO-8859-1"), "GB18030");//��ȡJSPҳ��ֵ
			System.out.println(payDetail_name);
			try
			{
					String responseTextByName="";
					if(payDao.FindDetailByName(payDetail_name)==false)
					{
						responseTextByName="����ϸ�շ���Ŀ�����Ѿ����ڡ�";
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
		public String JudgePayDetailChangeByNumber()
		{
			PayDetailDao payDao=new PayDetailDao();//ʵ����dao
			String payDetail_number=request1.getParameter("ChangeNumber");//��ȡJSPҳ��ֵ
			
			try
			{
					String responseTextByNumber="";
					if(payDao.FindDetailByNum(payDetail_number)==false)
					{
						responseTextByNumber="����ϸ�շ���Ŀ����Ѿ����ڡ�";
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
