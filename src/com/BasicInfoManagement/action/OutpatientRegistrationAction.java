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
	private String outpatientRegistration_name ;//�����շ�����
	private String outpatientRegistration_number;//����Һű��
	private double outpatientRegistration_price;//�����շѼ۸�
	private String outpatientRegistration_zjm;//����Һ�������
	private JC_SF_OutpatientRegistration jc_sf_outpaintientRegistration =new JC_SF_OutpatientRegistration();//ʵ��������Һ�����
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
				//ɾ��������Ϣ
			   registrationdao.deleteRegistration(Integer.valueOf(id));
			   fillData();
			}
		   return SUCCESS;
	   }
	
	  public String modify1()     //���Ҫ�����û����������е�������ʾ��һ��jsp�ϡ�
	   {
		   String id=request.getParameter("outpatientPayment_id");
		   if(id != null)
		   {
			   request.setAttribute("RegistrationmodifyInfo", registrationdao.getRegistration(Integer.valueOf(id)));
		   }
		//   System.out.print(id);
		   return SUCCESS;
	   }
	   public String modify2()    //���£���⡣
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   JC_SF_OutpatientRegistration jc_sf_outpatientRegistration=new JC_SF_OutpatientRegistration();
		   jc_sf_outpatientRegistration=registrationdao.getRegistration(Integer.valueOf(id)); //�ҵ���Ҫ�޸ĵ��û�
		   System.out.println(jc_sf_outpatientRegistration.getOutpatientRegistration_id()+"qqqqqqqqqqq");
		   jc_sf_outpatientRegistration.setOutpatientRegistration_name(  outpatientRegistration_name);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_number(outpatientRegistration_number);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_price(outpatientRegistration_price);
		   jc_sf_outpatientRegistration.setOutpatientRegistration_zjm(outpatientRegistration_zjm);
		   
		   registrationdao.saveRegistration(jc_sf_outpatientRegistration);  //���	
		  // fillData();	

		   queryAll();
		   return SUCCESS;
	   }
	
	
	  public void fillData()  //������ÿ����ת�� ҳ��ʱ������������ʾ�����С�
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // ��ǰҳ
			int pageSize = 11; // ÿҳ��ʾ5����¼
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
