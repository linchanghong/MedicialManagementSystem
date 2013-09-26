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

	private String bed_number;  //床位号
	private JC_LC_DeptInfo deptInfo;  //所属科室
	
	private String deptInfoName;     //所属科室名
	
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
				//删除留言信息
			   List jc_lc_doctorInfo2=dao.findQueryBedInfo(type,data);
			   request.setAttribute("list", jc_lc_doctorInfo2);
			}
		   return SUCCESS;
	   }
	   public String add()    //用于将新建的科室信息保存至数据库。
	   {
		   JC_LC_DeptInfo listDept=dao.findDept(deptInfoName); //通过科室名找到科室
		   
		   System.out.println(listDept+"123456789");
		   JC_LC_BedInfo jc_ry_bedInfo=new JC_LC_BedInfo();
		   jc_ry_bedInfo.setBed_number(bed_number);
		   
		   jc_ry_bedInfo.setDeptInfo(listDept);
		   dao.saveBedInfo(jc_ry_bedInfo);  //入库
		   fillData();
		   findDeptName();
		   
		   return SUCCESS;
	   }
	   
	   public String delete()
	   {
		   String id=request.getParameter("bedInfo_id");
		   if(id != null){
				//删除留言信息
				dao.deleteBedInfo(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	   
	   public String modify1()     //获得要更新的科室，将其现有的数据显示在一个jsp上。
	   {
		   String id=request.getParameter("bedInfo_id");
		   if(id != null)
		   {
			   request.setAttribute("modifyInfo", dao.getBedInfo(Integer.valueOf(id)));
		   }
		   return SUCCESS;
	   }
	   public String modify2()    //更新，入库。
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   JC_LC_BedInfo jc_ry_bedInfo1=dao.getBedInfo(Integer.valueOf(id)); //找到需要修改的科室。
		   jc_ry_bedInfo1.setBed_number(bed_number);
		   
//		   jc_ry_doctorInfo1.setDeptInfo(DeptInfo);
		   dao.saveBedInfo(jc_ry_bedInfo1);  //入库
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
