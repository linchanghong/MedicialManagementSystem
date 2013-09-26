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
	private String doctorInfo_name;    //医生名
	private int doctorInfo_age;        //医生年龄
	private String doctorInfo_sex;    //医生性别
	private JC_LC_DeptInfo deptInfo;  //医生所属科室。
	
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
				//删除留言信息
			   List jc_lc_doctorInfo2=dao.findQueryDoctorInfo(type,data);
			   request.setAttribute("list", jc_lc_doctorInfo2);
			}
		   return SUCCESS;
	   }
	   public String add()    //用于将新建的科室信息保存至数据库。
	   {
		   JC_LC_DeptInfo listDept=dao.findDept(deptInfoName); //通过科室名找到科室
		   JC_RY_DoctorInfo jc_ry_doctorInfo=new JC_RY_DoctorInfo();
		   jc_ry_doctorInfo.setDoctorInfo_name(doctorInfo_name);
		   jc_ry_doctorInfo.setDoctorInfo_age(doctorInfo_age);
		   jc_ry_doctorInfo.setDoctorInfo_sex(doctorInfo_sex);
		   jc_ry_doctorInfo.setDeptInfo(listDept);
		   dao.saveDoctorInfo(jc_ry_doctorInfo);  //入库
		   fillData();
		   findDeptName();
		   
		   return SUCCESS;
	   }
	   
	   public String delete()
	   {
		   String id=request.getParameter("doctorInfo_id");
		   if(id != null){
				//删除留言信息
				dao.deleteDoctorInfo(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	   
	   public String modify1()     //获得要更新的科室，将其现有的数据显示在一个jsp上。
	   {
		   String id=request.getParameter("doctorInfo_id");
		   if(id != null)
		   {
			   request.setAttribute("modifyInfo", dao.getDoctorInfo(Integer.valueOf(id)));
		   }
		   return SUCCESS;
	   }
	   public String modify2()    //更新，入库。
	   {
		   String id=request.getParameter("id");
		   
		   JC_RY_DoctorInfo jc_ry_doctorInfo1=dao.getDoctorInfo(Integer.valueOf(id)); //找到需要修改的科室。
		   jc_ry_doctorInfo1.setDoctorInfo_name(doctorInfo_name);
		   jc_ry_doctorInfo1.setDoctorInfo_age(doctorInfo_age);
		   jc_ry_doctorInfo1.setDoctorInfo_sex(doctorInfo_sex);
//		   jc_ry_doctorInfo1.setDeptInfo(DeptInfo);
		   dao.saveDoctorInfo(jc_ry_doctorInfo1);  //入库
		   fillData();
		   
		   
		   return SUCCESS;
	   }
	   
	   public void fillData()  //用于在每次跳转到 DeptInfo_index页面时将所有数据显示在其中。
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 11; // 每页显示5条记录
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
