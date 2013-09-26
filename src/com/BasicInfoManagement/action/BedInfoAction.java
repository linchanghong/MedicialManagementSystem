package com.BasicInfoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.BedInfoDao;
import com.BasicInfoManagement.model.JC_LC_BedInfo;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class BedInfoAction extends ActionSupport {

	private String bed_number;  //��λ��
	private JC_LC_DeptInfo deptInfo;  //��������
	
	private String deptInfoName;     //����������
	
	private HttpServletRequest request;
	BedInfoDao dao=new BedInfoDao();
	
	
	
	public String getDeptInfoName() {
		return deptInfoName;
	}


	public void setDeptInfoName(String deptInfoName) {
		this.deptInfoName = deptInfoName;
	}


	public String getBed_number() {
		return bed_number;
	}


	public void setBed_number(String bed_number) {
		this.bed_number = bed_number;
	}


	public JC_LC_DeptInfo getDeptInfo() {
		return deptInfo;
	}


	public void setDeptInfo(JC_LC_DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}


	public BedInfoAction()
	{
		request = ServletActionContext.getRequest();
	}
	
	public String query()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   if(type != null||data!=null){
				//ɾ��������Ϣ
			   List jc_lc_doctorInfo2=dao.findQueryBedInfo(type,data);
			   request.setAttribute("list", jc_lc_doctorInfo2);
			}
		   return SUCCESS;
	   }
	   public String add()    //���ڽ��½��Ŀ�����Ϣ���������ݿ⡣
	   {
		   JC_LC_DeptInfo listDept=dao.findDept(deptInfoName); //ͨ���������ҵ�����
		   
		   System.out.println(listDept+"123456789");
		   JC_LC_BedInfo jc_ry_bedInfo=new JC_LC_BedInfo();
		   jc_ry_bedInfo.setBed_number(bed_number);
		   
		   jc_ry_bedInfo.setDeptInfo(listDept);
		   dao.saveBedInfo(jc_ry_bedInfo);  //���
		   fillData();
		   findDeptName();
		   
		   return SUCCESS;
	   }
	   
	   public String delete()
	   {
		   String id=request.getParameter("bedInfo_id");
		   if(id != null){
				//ɾ��������Ϣ
				dao.deleteBedInfo(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	   
	   public String modify1()     //���Ҫ���µĿ��ң��������е�������ʾ��һ��jsp�ϡ�
	   {
		   String id=request.getParameter("bedInfo_id");
		   if(id != null)
		   {
			   request.setAttribute("modifyInfo", dao.getBedInfo(Integer.valueOf(id)));
		   }
		   return SUCCESS;
	   }
	   public String modify2()    //���£���⡣
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   JC_LC_BedInfo jc_ry_bedInfo1=dao.getBedInfo(Integer.valueOf(id)); //�ҵ���Ҫ�޸ĵĿ��ҡ�
		   jc_ry_bedInfo1.setBed_number(bed_number);
		   
//		   jc_ry_doctorInfo1.setDeptInfo(DeptInfo);
		   dao.saveBedInfo(jc_ry_bedInfo1);  //���
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
	   
	   public void findDeptName()
	   {
		   request.setAttribute("DeptName", dao.findDeptName());
	   }
	   
	   public String queryAll()
	   {
		   findDeptName();
		   fillData();
		   return SUCCESS;
	   }
}
