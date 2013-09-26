package com.BasicInfoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.BasicInfoManagement.dao.DeptInfoDao;
import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.PageModel;

public class DeptInfoAction extends ActionSupport {
//	private int deptInfo_id;
	private String deptInfo_name;  //��������
	private String deptInfo_number;//���ұ���
	private String deptInfo_zjm;   //����������
	
	private HttpServletRequest request;

	
	private JC_LC_DeptInfo jc_lc_deptInfo=new JC_LC_DeptInfo();
	DeptInfoDao dao=new DeptInfoDao();
//	public int getDeptInfo_id() {
//		return deptInfo_id;
//	}
//	public void setDeptInfo_id(int deptInfo_id) {
//		this.deptInfo_id = deptInfo_id;
//	}
	public String getDeptInfo_name() {
		return deptInfo_name;
	}
	public void setDeptInfo_name(String deptInfo_name) {
		this.deptInfo_name = deptInfo_name;
	}
	public String getDeptInfo_number() {
		return deptInfo_number;
	}
	public void setDeptInfo_number(String deptInfo_number) {
		this.deptInfo_number = deptInfo_number;
	}
	public String getDeptInfo_zjm() {
		return deptInfo_zjm;
	}
	public void setDeptInfo_zjm(String deptInfo_zjm) {
		this.deptInfo_zjm = deptInfo_zjm;
	}
	public DeptInfoAction()
	{
		request = ServletActionContext.getRequest();

	}
	
   public String query()
   {
	   String type=request.getParameter("queryType");
	   String data=request.getParameter("queryData");
	   if(type != null||data!=null){

		   List jc_lc_deptInfo2=dao.findQueryDeptInfo(type,data);
		   request.setAttribute("list", jc_lc_deptInfo2);
		}
	   return SUCCESS;
   }
   public String add()    //���ڽ��½��Ŀ�����Ϣ���������ݿ⡣
   { 
	   jc_lc_deptInfo.setDeptInfo_name(deptInfo_name);
	   jc_lc_deptInfo.setDeptInfo_number(deptInfo_number);
	   jc_lc_deptInfo.setDeptInfo_zjm(deptInfo_zjm);
	   dao.saveDeptInfo(jc_lc_deptInfo);  //���
	   fillData();
	   
	   return SUCCESS;
   }
   
   public String delete()
   {
	   String id=request.getParameter("deptInfo_id");
	   if(id != null){
			//ɾ��������Ϣ
			dao.deleteDeptInfo(Integer.valueOf(id));
			fillData();
		}
	   return SUCCESS;
   }
   
   public String modify1()     //���Ҫ���µĿ��ң��������е�������ʾ��һ��jsp�ϡ�
   {
	   String id=request.getParameter("deptInfo_id");
	   if(id != null)
	   {
		   request.setAttribute("modifyInfo", dao.getDeptInfo(Integer.valueOf(id)));
	   }
	   return SUCCESS;
   }
   public String modify2()    //���£���⡣
   {
	   String id=request.getParameter("id");
	   
	   JC_LC_DeptInfo jc_lc_deptInfo1=dao.getDeptInfo(Integer.valueOf(id)); //�ҵ���Ҫ�޸ĵĿ��ҡ�
	   jc_lc_deptInfo1.setDeptInfo_name(deptInfo_name);
	   jc_lc_deptInfo1.setDeptInfo_number(deptInfo_number);
	   jc_lc_deptInfo1.setDeptInfo_zjm(deptInfo_zjm);
	   dao.saveDeptInfo(jc_lc_deptInfo1);  //���
	   fillData();
	   
	   
	   return SUCCESS;
   }
   
   public void fillData()  //������ÿ����ת�� DeptInfo_indexҳ��ʱ������������ʾ�����С�
   {
	   String page = request.getParameter("currPage");
	   int currPage = 1; // ��ǰҳ
		int pageSize = 11; // ÿҳ��ʾ5����¼
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
}
