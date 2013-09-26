package com.BasicInfoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.CipherPresDao;
import com.BasicInfoManagement.dao.IncompatibilityDao;
//import com.BasicInfoManagement.dao.IncompatibilityDao;
import com.BasicInfoManagement.model.JC_YP_CipherPres;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class CipherPresAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CipherPresDao dao=null;
	private HttpServletRequest request;
	private JC_YP_CipherPres cipherPres;
	private Integer cipherPres_id;
	public Integer getCipherPres_id() {
		return cipherPres_id;
	}
	public void setCipherPres_id(Integer cipherPres_id) {
		this.cipherPres_id = cipherPres_id;
	}
	public JC_YP_CipherPres getCipherPres() {
		return cipherPres;
	}
	public void setCipherPres(JC_YP_CipherPres cipherPres) {
		this.cipherPres = cipherPres;
	}

	public CipherPresAction()
	{
		request=ServletActionContext.getRequest();
	}
	public void fillData()  //������ÿ����ת�� DeptInfo_indexҳ��ʱ������������ʾ�����С�
	   {
		   dao=new CipherPresDao();
		   String page = request.getParameter("currPage");
		   int currPage = 1; // ��ǰҳ
			int pageSize = 7; // ÿҳ��ʾ5����¼
			
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
			
		   request.removeAttribute("pageModel");
		   PageModel pageModel=dao.findPaging(currPage, pageSize);
		   
		   request.setAttribute("pageModel", pageModel);
	   }
	   
	   public String queryAll()
	   {
		   fillData();
		   
		   return SUCCESS;
	   }
	   public String deleteCipherPres()
	   {
		   dao=new CipherPresDao();
		   dao.removeCipherPres(cipherPres_id);
		   fillData();
		   return SUCCESS;
		}
	   public String conditionQuery()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   dao=new CipherPresDao();
		   if(type != null||data!=null){
				//ɾ��������Ϣ
			  // System.out.print("wwwwwwww"+data);
			   List findCipherPresInfo=dao.findCipherPresInfo(type,data);
			 
			   request.setAttribute("list", findCipherPresInfo);
			}
		   fillData();
		   return SUCCESS;
	   }
	   public String saveCipherPres()
	   {
		   dao=new CipherPresDao();
		  
		   dao.saveCipherPres(cipherPres);
		   fillData();
		   return SUCCESS;
	   }
	   
}
