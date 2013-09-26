package com.BasicInfoManagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.BasicInfoManagement.dao.OutpatientRegistrationDao;
import com.BasicInfoManagement.model.JC_SF_OutpatientRegistration;
import com.BasicInfoManagement.util.PageModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OutpatientRegistrationAction extends ActionSupport{
	private String outpatientRegistration_name ;//门诊收费名称
	private String outpatientRegistration_number;//门诊挂号编号
	private double outpatientRegistration_price;//门诊收费价格
	private String outpatientRegistration_zjm;//门诊挂号助记码
	private JC_SF_OutpatientRegistration jc_sf_outpaintientRegistration =new JC_SF_OutpatientRegistration();//实例化门诊挂号种类
	OutpatientRegistrationDao registrationdao=new OutpatientRegistrationDao();
	private HttpServletRequest request=ServletActionContext.getRequest();
	

	public String getOutpatientRegistration_name() {
		return outpatientRegistration_name;
	}


	public void setOutpatientRegistration_name(String outpatientRegistration_name) {
		this.outpatientRegistration_name = outpatientRegistration_name;
	}


	public String getOutpatientRegistration_number() {
		return outpatientRegistration_number;
	}


	public void setOutpatientRegistration_number(
			String outpatientRegistration_number) {
		this.outpatientRegistration_number = outpatientRegistration_number;
	}


	public double getOutpatientRegistration_price() {
		return outpatientRegistration_price;
	}


	public void setOutpatientRegistration_price(double outpatientRegistration_price) {
		this.outpatientRegistration_price = outpatientRegistration_price;
	}


	public String getOutpatientRegistration_zjm() {
		return outpatientRegistration_zjm;
	}


	public void setOutpatientRegistration_zjm(String outpatientRegistration_zjm) {
		this.outpatientRegistration_zjm = outpatientRegistration_zjm;
	}


	public String add(){
//		System.out.print(login_name);
//		System.out.print(login_password);
//		System.out.print(login_type);
		jc_sf_outpaintientRegistration.setOutpatientRegistration_name(outpatientRegistration_name);
		jc_sf_outpaintientRegistration.setOutpatientRegistration_number(outpatientRegistration_number);
		jc_sf_outpaintientRegistration.setOutpatientRegistration_price(outpatientRegistration_price);
		jc_sf_outpaintientRegistration.setOutpatientRegistration_zjm(outpatientRegistration_zjm);
		registrationdao.saveRegistration(jc_sf_outpaintientRegistration);
		queryAll();
		return SUCCESS;
	}
	
	
	public String query()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   if(type != null||data!=null){

			   List jc_ry_login2=registrationdao.findRegistration(type, data);
			   request.setAttribute("list", jc_ry_login2);
			}
		   return SUCCESS;
	   }
	
	
	 public String delete()
	   {
		   String id=request.getParameter("outpatientPayment_id");
		  // System.out.print(id);
		   if(id != null){
				//删除留言信息
			   registrationdao.deleteRegistration(Integer.valueOf(id));
			   fillData();
			}
		   return SUCCESS;
	   }
	
	  public String modify1()     //获得要更新用户，将其现有的数据显示在一个jsp上。
	   {
		   String id=request.getParameter("outpatientPayment_id");
		   if(id != null)
		   {
			   request.setAttribute("RegistrationmodifyInfo", registrationdao.getRegistration(Integer.valueOf(id)));
		   }
		//   System.out.print(id);
		   return SUCCESS;
	   }
	   public String modify2()    //更新，入库。
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   JC_SF_OutpatientRegistration jc_sf_outpatientRegistration=new JC_SF_OutpatientRegistration();
		   jc_sf_outpatientRegistration=registrationdao.getRegistration(Integer.valueOf(id)); //找到需要修改的用户
		   System.out.println(jc_sf_outpatientRegistration.getOutpatientRegistration_id()+"qqqqqqqqqqq");
		   jc_sf_outpatientRegistration.setOutpatientRegistration_name(  outpatientRegistration_name);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_number(outpatientRegistration_number);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_price(outpatientRegistration_price);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_zjm(outpatientRegistration_zjm);
		   
		   registrationdao.saveRegistration(jc_sf_outpatientRegistration);  //入库	
		  // fillData();	

		   queryAll();
		   return SUCCESS;
	   }
	
	
	  public void fillData()  //用于在每次跳转到 页面时将所有数据显示在其中。
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 11; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=registrationdao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	   
	   public String queryAll()
	   {
		   fillData();
		   return SUCCESS;
	   }
	public String isInput() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter p=response.getWriter();
		String number=request.getParameter("outpatientPayment_number");
		if(registrationdao.isRegistration(number)==true)
		{
			p.print("true");
			System.out.print("true");
		}
		else
			p.print("flase");
		System.out.print("false");
		return null;
	}


}
