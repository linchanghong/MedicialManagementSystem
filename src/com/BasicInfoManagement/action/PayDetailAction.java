/*
 *收费项目详情Action文件
 *对应数据表组合划价项目(JC_SF_PayDetail)
 *编辑者：林世鹏
 *时间：2013.8.8
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
	private JC_SF_PayDetail payDetail;//JSP页面中对象
	private int currentPage;//获取JSP页面中页码
	private Map<String,Object> request;//定义request接口
	private String QueryId;//获取JSP查询编号
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
		int currentPage=1;//当前页
		int pageSize = 6; // 每页显示10条记录
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
	//添加信息判断名称是否重复，使用request,response取值传值，ajax
		public String JudgePayDetailByName() throws Exception
		{
			PayDetailDao payDao=new PayDetailDao();//实例化dao
			String payDetail_name=new String(request1.getParameter("name").getBytes("ISO-8859-1"), "GB18030");//获取JSP页面值
			System.out.println(payDetail_name);
			try
			{
					String responseTextByName="";
					if(payDao.FindDetailByName(payDetail_name)==false)
					{
						responseTextByName="该详细收费项目名称已经存在。";
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
		//添加信息时判断编号是否重复，使用request,response取值传值，ajax
		public String JudgePayDetailByNumber()
		{
			PayDetailDao payDao=new PayDetailDao();//实例化dao
			String payDetail_number=request1.getParameter("number");//获取JSP页面值
			
			try
			{
					String responseTextByNumber="";
					if(payDao.FindDetailByNum(payDetail_number)==false)
					{
						responseTextByNumber="该详细收费项目编号已经存在。";
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
		//修改信息判断名称是否重复，使用request,response取值传值，ajax
		public String JudgePayDetailChangeByName() throws Exception
		{

			PayDetailDao payDao=new PayDetailDao();//实例化dao
			String payDetail_name=new String(request1.getParameter("ChangeName").getBytes("ISO-8859-1"), "GB18030");//获取JSP页面值
			System.out.println(payDetail_name);
			try
			{
					String responseTextByName="";
					if(payDao.FindDetailByName(payDetail_name)==false)
					{
						responseTextByName="该详细收费项目名称已经存在。";
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
		//修改信息时判断编号是否重复，使用request,response取值传值，ajax
		public String JudgePayDetailChangeByNumber()
		{
			PayDetailDao payDao=new PayDetailDao();//实例化dao
			String payDetail_number=request1.getParameter("ChangeNumber");//获取JSP页面值
			
			try
			{
					String responseTextByNumber="";
					if(payDao.FindDetailByNum(payDetail_number)==false)
					{
						responseTextByNumber="该详细收费项目编号已经存在。";
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
