/*
 *组合划价Action文件
 *对应数据表组合划价项目(jc_sf_combinationAccounting)
 *编辑者：林世鹏
 *时间：2013.8.10
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
	private JC_SF_CombinationAccounting combinationAccounting;//JSP页面中对象
	public JC_SF_CombinationAccounting getCombinationAccounting() {
		return combinationAccounting;
	}
	public void setCombinationAccounting(
			JC_SF_CombinationAccounting combinationAccounting) {
		this.combinationAccounting = combinationAccounting;
	}
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
	//构造器，为request1 与 response初始化
	public CombinationAccountingAction()
	{
		request1 = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
	}
	
	//添加数据
	public String AddCAccounting()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		
			cAccountingDao.SavaCAccounting(combinationAccounting);	//将数据持久化
		return SUCCESS;
	}	
	//返回首页打印信息
	public String ShowPage()
	{
		int currentPage=1;//当前页
		int pageSize = 7; // 每页显示10条记录
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		if (getCurrentPage() != 0) {
			currentPage = getCurrentPage();
		}
		PageModel pageModel = cAccountingDao.FindPaging(currentPage, pageSize);
		request.put("pageModel", pageModel);
		return SUCCESS;
		
	}
	//使用选中CHECKBOX选中ID循环删除
	public String DeleteCAccounting()
	{
		//循环删除
		for(Integer i: checkId){
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
			cAccountingDao.DeleteCAccountingById(i.intValue());//删除
		}
		return SUCCESS;
		
	}
	//更新
	public String UpdateCAccounting()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();
		cAccountingDao.SavaCAccounting(combinationAccounting);	//更新数据
		return SUCCESS;
	}
	//根据编码查询对象
	public String QueryCAccountingDetail()
 {
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//实例化dao
		JC_SF_CombinationAccounting QueryCAccountingDetail = cAccountingDao.ReturnCAccountingById(getQueryId());//获取对象
		request.put("list", QueryCAccountingDetail);//将使用request获取到的对象传给JSP
		return SUCCESS;
	}
	//添加信息判断名称是否重复，使用request,response取值传值，ajax
	public String JudgeCAccountingByName() throws Exception
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//实例化dao
		String combinationAccounting_name=new String(request1.getParameter("name").getBytes("ISO-8859-1"), "GB18030");//获取JSP页面值	
		try
		{
				String responseTextByName="";
				if(cAccountingDao.FindCAccountingByName(combinationAccounting_name)==false)
				{
					responseTextByName="该组合划价名称已经存在。";
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
	public String JudgeCAccountingByNumber()
	{
		CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//实例化dao
		String combinationAccounting_number=request1.getParameter("number");//获取JSP页面值
		
		try
		{
				String responseTextByNumber="";
				if(cAccountingDao.FindCAccountingByNum(combinationAccounting_number)==false)
				{
					responseTextByNumber="该组合划价编号已经存在。";
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
		public String JudgeCAccountingChangeByName() throws Exception
		{
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//实例化dao
			String combinationAccounting_name=new String(request1.getParameter("ChangeName").getBytes("ISO-8859-1"), "GB18030");//获取JSP页面值	
			try
			{
					String responseTextByName="";
					if(cAccountingDao.FindCAccountingByName(combinationAccounting_name)==false)
					{
						responseTextByName="该组合划价名称已经存在。";
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
		public String JudgeCAccountingChangeByNumber()
		{
			CombinationAccountingDao cAccountingDao=new CombinationAccountingDao();//实例化dao
			String combinationAccounting_number=request1.getParameter("ChangeNumber");//获取JSP页面值
			
			try
			{
					String responseTextByNumber="";
					if(cAccountingDao.FindCAccountingByNum(combinationAccounting_number)==false)
					{
						responseTextByNumber="该组合划价编号已经存在。";
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
