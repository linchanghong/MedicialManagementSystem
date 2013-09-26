package com.BasicInfoManagement.action;

import java.awt.Menu;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DoctorInfoDao;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_DoctorInfo;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class DoctorInfoAction extends ActionSupport {

	//private int doctorInfo_id; 
	private String doctorInfo_name;    //ҽ����
	private int doctorInfo_age;        //ҽ������
	private String doctorInfo_sex;    //ҽ���Ա�
	private JC_LC_DeptInfo deptInfo;  //ҽ���������ҡ�
	
    private String deptInfoName;
	
	private HttpServletRequest request;
	DoctorInfoDao dao=new DoctorInfoDao();
	
	public JC_LC_DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(JC_LC_DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	

	public String getDeptInfoName() {
		return deptInfoName;
	}

	public void setDeptInfoName(String deptInfoName) {
		this.deptInfoName = deptInfoName;
	}

	
	public String getDoctorInfo_name() {
		return doctorInfo_name;
	}

	public void setDoctorInfo_name(String doctorInfo_name) {
		this.doctorInfo_name = doctorInfo_name;
	}

	public int getDoctorInfo_age() {
		return doctorInfo_age;
	}

	public void setDoctorInfo_age(int doctorInfo_age) {
		this.doctorInfo_age = doctorInfo_age;
	}

	public String getDoctorInfo_sex() {
		return doctorInfo_sex;
	}

	public void setDoctorInfo_sex(String doctorInfo_sex) {
		this.doctorInfo_sex = doctorInfo_sex;
	}

	public DoctorInfoAction()
	{
		request = ServletActionContext.getRequest();
	}
	
	public String query()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   if(type != null||data!=null){
				//ɾ��������Ϣ
			   List jc_lc_doctorInfo2=dao.findQueryDoctorInfo(type,data);
			   request.setAttribute("list", jc_lc_doctorInfo2);
			}
		   return SUCCESS;
	   }
	   public String add()    //���ڽ��½��Ŀ�����Ϣ���������ݿ⡣
	   {
		   JC_LC_DeptInfo listDept=dao.findDept(deptInfoName); //ͨ���������ҵ�����
		   JC_RY_DoctorInfo jc_ry_doctorInfo=new JC_RY_DoctorInfo();
		   jc_ry_doctorInfo.setDoctorInfo_name(doctorInfo_name);
		   jc_ry_doctorInfo.setDoctorInfo_age(doctorInfo_age);
		   jc_ry_doctorInfo.setDoctorInfo_sex(doctorInfo_sex);
		   jc_ry_doctorInfo.setDeptInfo(listDept);
		   dao.saveDoctorInfo(jc_ry_doctorInfo);  //���
		   fillData();
		   findDeptName();
		   
		   return SUCCESS;
	   }
	   
	   public String delete()
	   {
		   String id=request.getParameter("doctorInfo_id");
		   if(id != null){
				//ɾ��������Ϣ
				dao.deleteDoctorInfo(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	   
	   public String modify1()     //���Ҫ���µĿ��ң��������е�������ʾ��һ��jsp�ϡ�
	   {
		   String id=request.getParameter("doctorInfo_id");
		   if(id != null)
		   {
			   request.setAttribute("modifyInfo", dao.getDoctorInfo(Integer.valueOf(id)));
		   }
		   return SUCCESS;
	   }
	   public String modify2()    //���£���⡣
	   {
		   String id=request.getParameter("id");
		   
		   JC_RY_DoctorInfo jc_ry_doctorInfo1=dao.getDoctorInfo(Integer.valueOf(id)); //�ҵ���Ҫ�޸ĵĿ��ҡ�
		   jc_ry_doctorInfo1.setDoctorInfo_name(doctorInfo_name);
		   jc_ry_doctorInfo1.setDoctorInfo_age(doctorInfo_age);
		   jc_ry_doctorInfo1.setDoctorInfo_sex(doctorInfo_sex);
//		   jc_ry_doctorInfo1.setDeptInfo(DeptInfo);
		   dao.saveDoctorInfo(jc_ry_doctorInfo1);  //���
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
