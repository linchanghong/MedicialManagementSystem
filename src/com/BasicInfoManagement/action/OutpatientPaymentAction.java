package com.BasicInfoManagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.BasicInfoManagement.util.PageModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.BasicInfoManagement.dao.OutpatientPaymentDao;
import com.BasicInfoManagement.model.JC_SF_OutpatientPayment;
import com.opensymphony.xwork2.ActionSupport;

public class OutpatientPaymentAction extends ActionSupport{
	private String outpatientPayment_name;//门诊收费名称
	private String outpatientPayment_number;//门诊收费编码
	private String outpatientPayment_property;//门诊收费性质
	private String outpatientPayment_object;//门诊收费对象
	private String outpatientPayment_remark;//备注
	private String outpatientPayment_zjm;//助记码
	private JC_SF_OutpatientPayment jc_sf_outpatientpayment =new JC_SF_OutpatientPayment();//实例化门诊收费种类
	OutpatientPaymentDao paymentdao=new OutpatientPaymentDao();
	private HttpServletRequest request=ServletActionContext.getRequest();
	

	public String add(){
//		System.out.print(login_name);
//		System.out.print(login_password);
//		System.out.print(login_type);
		jc_sf_outpatientpayment.setOutpatientPayment_name(outpatientPayment_name);
		jc_sf_outpatientpayment.setOutpatientPayment_number(outpatientPayment_number);
		jc_sf_outpatientpayment.setOutpatientPayment_object(outpatientPayment_object);
		jc_sf_outpatientpayment.setOutpatientPayment_property(outpatientPayment_property);
		jc_sf_outpatientpayment.setOutpatientPayment_remark(outpatientPayment_remark);
		jc_sf_outpatientpayment.setOutpatientPayment_zjm(outpatientPayment_zjm);
		paymentdao.savePayment(jc_sf_outpatientpayment);
		queryAll();
		return SUCCESS;
	}
	
	public String getOutpatientPayment_name() {
		return outpatientPayment_name;
	}

	public void setOutpatientPayment_name(String outpatientPayment_name) {
		this.outpatientPayment_name = outpatientPayment_name;
	}

	public String getOutpatientPayment_number() {
		return outpatientPayment_number;
	}

	public void setOutpatientPayment_number(String outpatientPayment_number) {
		this.outpatientPayment_number = outpatientPayment_number;
	}

	public String getOutpatientPayment_property() {
		return outpatientPayment_property;
	}

	public void setOutpatientPayment_property(String outpatientPayment_property) {
		this.outpatientPayment_property = outpatientPayment_property;
	}

	public String getOutpatientPayment_object() {
		return outpatientPayment_object;
	}

	public void setOutpatientPayment_object(String outpatientPayment_object) {
		this.outpatientPayment_object = outpatientPayment_object;
	}

	public String getOutpatientPayment_remark() {
		return outpatientPayment_remark;
	}

	public void setOutpatientPayment_remark(String outpatientPayment_remark) {
		this.outpatientPayment_remark = outpatientPayment_remark;
	}

	public String getOutpatientPayment_zjm() {
		return outpatientPayment_zjm;
	}

	public void setOutpatientPayment_zjm(String outpatientPayment_zjm) {
		this.outpatientPayment_zjm = outpatientPayment_zjm;
	}

	public String query()
	   {
		   String type=request.getParameter("queryType");
		   String data=request.getParameter("queryData");
		   if(type != null||data!=null){

			   List jc_ry_login2=paymentdao.findPayment(type, data);
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
			   paymentdao.deletePayment(Integer.valueOf(id));
			   fillData();
			}
		   return SUCCESS;
	   }
	
	  public String modify1()     //获得要更新用户，将其现有的数据显示在一个jsp上。
	   {
		   String id=request.getParameter("outpatientPayment_id");
		   if(id != null)
		   {
			   request.setAttribute("paymentmodifyInfo", paymentdao.getPayment(Integer.valueOf(id)));
		   }
		//   System.out.print(id);
		   return SUCCESS;
	   }
	   public String modify2()    //更新，入库。
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   JC_SF_OutpatientPayment jc_sf_outpatientpayment=new JC_SF_OutpatientPayment();
		   jc_sf_outpatientpayment=paymentdao.getPayment(Integer.valueOf(id)); //找到需要修改的用户
		   System.out.println(jc_sf_outpatientpayment.getOutpatientPayment_id()+"qqqqqqqqqqq");
		   jc_sf_outpatientpayment.setOutpatientPayment_name(  outpatientPayment_name);
		   jc_sf_outpatientpayment.setOutpatientPayment_number(outpatientPayment_number);
		   jc_sf_outpatientpayment.setOutpatientPayment_object(outpatientPayment_object);
		   jc_sf_outpatientpayment.setOutpatientPayment_property(outpatientPayment_property);
		   jc_sf_outpatientpayment.setOutpatientPayment_remark(outpatientPayment_remark);
		   jc_sf_outpatientpayment.setOutpatientPayment_zjm(outpatientPayment_zjm);
		   paymentdao.savePayment(jc_sf_outpatientpayment);  //入库	
		 
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
		   PageModel pageModel=paymentdao.findPaging(currPage, pageSize);
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
		if( paymentdao.isPayment(number)==true)
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
