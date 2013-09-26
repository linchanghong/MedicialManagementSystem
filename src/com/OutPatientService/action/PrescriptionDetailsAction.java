package com.OutPatientService.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DoctorInfoDao;
import com.BasicInfoManagement.dao.DrugInfoDao;
import com.BasicInfoManagement.model.JC_YP_DrugInfo;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.dao.PrescriptionDao;
import com.OutPatientService.dao.PrescriptionDetailsDao;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;

public class PrescriptionDetailsAction extends ActionSupport{
	
	private int prescriptionDetails_id;
	private String prescriptionDetails_number;//处方号
	private String prescriptionDetails_deptcode;//申请部门编码
	private String prescriptionDetails_drugcode;//药品编码
	private String prescriptionDetails_drugname;//药品名称
	private String prescriptionDetails_batch;//批号
	private String prescriptionDetails_drugtype;//药品类别
	private String prescriptionDetails_drugquality;//药品性质
	private String prescriptionDetails_drugspecs;//药品规格
	private String prescriptionDetails_showunit;//显示单位
	private Date prescriptionDetails_applydate;//申请日期
	private String prescriptionDetails_applystate;//申请状态
	private int prescriptionDetails_applynumber;//申请数量
	private String prescriptionDetails_modifyflag;//退药状态
	private String prescriptionDetails_chargeflag;//收费状态
	private double prescriptionDetails_doseonce;//每次剂量
	private String prescriptionDetails_doseunit;//剂量单位
	private String prescriptionDetails_usecode;//用法代码
	private String prescriptionDetails_usename;//用法名称
	private String prescriptionDetails_frecode;//频次代码
	private double prescriptionDetails_money;//药品金额
	private double prescriptionDetails_totalmoney;//总价
	
	
	private String pName;
	private String pSex;
	private Date pAge;
	private String pCaseNo;
	private String pDept;
	private String pDoc;
	
	
	
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSex() {
		return pSex;
	}

	public void setpSex(String pSex) {
		this.pSex = pSex;
	}

	public Date getpAge() {
		return pAge;
	}

	public void setpAge(Date pAge) {
		this.pAge = pAge;
	}

	public String getpCaseNo() {
		return pCaseNo;
	}

	public void setpCaseNo(String pCaseNo) {
		this.pCaseNo = pCaseNo;
	}

	public String getpDept() {
		return pDept;
	}

	public void setpDept(String pDept) {
		this.pDept = pDept;
	}

	public String getpDoc() {
		return pDoc;
	}

	public void setpDoc(String pDoc) {
		this.pDoc = pDoc;
	}

	public double getPrescriptionDetails_money() {
		return prescriptionDetails_money;
	}

	public void setPrescriptionDetails_money(double prescriptionDetails_money) {
		this.prescriptionDetails_money = prescriptionDetails_money;
	}

	public double getPrescriptionDetails_totalmoney() {
		return prescriptionDetails_totalmoney;
	}

	public void setPrescriptionDetails_totalmoney(
			double prescriptionDetails_totalmoney) {
		this.prescriptionDetails_totalmoney = prescriptionDetails_totalmoney;
	}

	public int getPrescriptionDetails_id() {
		return prescriptionDetails_id;
	}

	public void setPrescriptionDetails_id(int prescriptionDetails_id) {
		this.prescriptionDetails_id = prescriptionDetails_id;
	}

	public String getPrescriptionDetails_number() {
		return prescriptionDetails_number;
	}

	public void setPrescriptionDetails_number(String prescriptionDetails_number) {
		this.prescriptionDetails_number = prescriptionDetails_number;
	}

	public String getPrescriptionDetails_deptcode() {
		return prescriptionDetails_deptcode;
	}

	public void setPrescriptionDetails_deptcode(String prescriptionDetails_deptcode) {
		this.prescriptionDetails_deptcode = prescriptionDetails_deptcode;
	}

	public String getPrescriptionDetails_drugcode() {
		return prescriptionDetails_drugcode;
	}

	public void setPrescriptionDetails_drugcode(String prescriptionDetails_drugcode) {
		this.prescriptionDetails_drugcode = prescriptionDetails_drugcode;
	}

	public String getPrescriptionDetails_drugname() {
		return prescriptionDetails_drugname;
	}

	public void setPrescriptionDetails_drugname(String prescriptionDetails_drugname) {
		this.prescriptionDetails_drugname = prescriptionDetails_drugname;
	}

	public String getPrescriptionDetails_batch() {
		return prescriptionDetails_batch;
	}

	public void setPrescriptionDetails_batch(String prescriptionDetails_batch) {
		this.prescriptionDetails_batch = prescriptionDetails_batch;
	}

	public String getPrescriptionDetails_drugtype() {
		return prescriptionDetails_drugtype;
	}

	public void setPrescriptionDetails_drugtype(String prescriptionDetails_drugtype) {
		this.prescriptionDetails_drugtype = prescriptionDetails_drugtype;
	}

	public String getPrescriptionDetails_drugquality() {
		return prescriptionDetails_drugquality;
	}

	public void setPrescriptionDetails_drugquality(
			String prescriptionDetails_drugquality) {
		this.prescriptionDetails_drugquality = prescriptionDetails_drugquality;
	}

	public String getPrescriptionDetails_drugspecs() {
		return prescriptionDetails_drugspecs;
	}

	public void setPrescriptionDetails_drugspecs(
			String prescriptionDetails_drugspecs) {
		this.prescriptionDetails_drugspecs = prescriptionDetails_drugspecs;
	}

	public String getPrescriptionDetails_showunit() {
		return prescriptionDetails_showunit;
	}

	public void setPrescriptionDetails_showunit(String prescriptionDetails_showunit) {
		this.prescriptionDetails_showunit = prescriptionDetails_showunit;
	}

	public Date getPrescriptionDetails_applydate() {
		return prescriptionDetails_applydate;
	}

	public void setPrescriptionDetails_applydate(Date prescriptionDetails_applydate) {
		this.prescriptionDetails_applydate = prescriptionDetails_applydate;
	}

	public String getPrescriptionDetails_applystate() {
		return prescriptionDetails_applystate;
	}

	public void setPrescriptionDetails_applystate(
			String prescriptionDetails_applystate) {
		this.prescriptionDetails_applystate = prescriptionDetails_applystate;
	}

	public int getPrescriptionDetails_applynumber() {
		return prescriptionDetails_applynumber;
	}

	public void setPrescriptionDetails_applynumber(
			int prescriptionDetails_applynumber) {
		this.prescriptionDetails_applynumber = prescriptionDetails_applynumber;
	}

	public String getPrescriptionDetails_modifyflag() {
		return prescriptionDetails_modifyflag;
	}

	public void setPrescriptionDetails_modifyflag(
			String prescriptionDetails_modifyflag) {
		this.prescriptionDetails_modifyflag = prescriptionDetails_modifyflag;
	}

	public String getPrescriptionDetails_chargeflag() {
		return prescriptionDetails_chargeflag;
	}

	public void setPrescriptionDetails_chargeflag(
			String prescriptionDetails_chargeflag) {
		this.prescriptionDetails_chargeflag = prescriptionDetails_chargeflag;
	}

	public double getPrescriptionDetails_doseonce() {
		return prescriptionDetails_doseonce;
	}

	public void setPrescriptionDetails_doseonce(double prescriptionDetails_doseonce) {
		this.prescriptionDetails_doseonce = prescriptionDetails_doseonce;
	}

	public String getPrescriptionDetails_doseunit() {
		return prescriptionDetails_doseunit;
	}

	public void setPrescriptionDetails_doseunit(String prescriptionDetails_doseunit) {
		this.prescriptionDetails_doseunit = prescriptionDetails_doseunit;
	}

	public String getPrescriptionDetails_usecode() {
		return prescriptionDetails_usecode;
	}

	public void setPrescriptionDetails_usecode(String prescriptionDetails_usecode) {
		this.prescriptionDetails_usecode = prescriptionDetails_usecode;
	}

	public String getPrescriptionDetails_usename() {
		return prescriptionDetails_usename;
	}

	public void setPrescriptionDetails_usename(String prescriptionDetails_usename) {
		this.prescriptionDetails_usename = prescriptionDetails_usename;
	}

	public String getPrescriptionDetails_frecode() {
		return prescriptionDetails_frecode;
	}

	public void setPrescriptionDetails_frecode(String prescriptionDetails_frecode) {
		this.prescriptionDetails_frecode = prescriptionDetails_frecode;
	}

	
	
	private MZ_PrescriptionDetails predetails =new MZ_PrescriptionDetails();//实例化登录用户维护类
	PrescriptionDetailsDao predetailsdao=new PrescriptionDetailsDao();
	private HttpServletRequest request=ServletActionContext.getRequest();
    private DrugInfoDao drugdao=new DrugInfoDao();
    private JC_YP_DrugInfo druginfo=new JC_YP_DrugInfo();
    private PrescriptionDao pre=new PrescriptionDao();
    
	public String add() throws UnsupportedEncodingException, ParseException{ 
		predetails.setPrescriptionDetails_number(prescriptionDetails_number);//处方号
		//需要输入的内容
		String a=request.getParameter("pCaseNo");
		System.out.println("王义彬   你好 嘛ddd "+a);
		
		String name=java.net.URLDecoder.decode(prescriptionDetails_drugname,"UTF-8");
		System.out.println(name);
		predetails.setPrescriptionDetails_drugname(name);
//		System.out.println(name + "******");
		predetails.setPrescriptionDetails_applynumber(prescriptionDetails_applynumber);
		predetails.setPrescriptionDetails_money(prescriptionDetails_money);//单价
		predetails.setPrescriptionDetails_usename(prescriptionDetails_usename);//用法
		//System.out.println(prescriptionDetails_usename);
		predetails.setPrescriptionDetails_frecode(prescriptionDetails_frecode);
		predetails.setPrescriptionDetails_doseonce(prescriptionDetails_doseonce);//每次剂量
		//自己传值
		predetails.setPrescriptionDetails_applystate("0");//申请状态
		predetails.setPrescriptionDetails_chargeflag("0");//目前显示为为收费
		predetails.setPrescriptionDetails_modifyflag("0");//是否退药
		
		//通过money和数量，获得totalmoney
		total(prescriptionDetails_applynumber,prescriptionDetails_money);
		//System.out.print(total(prescriptionDetails_applynumber,prescriptionDetails_money));
		predetails.setPrescriptionDetails_totalmoney(total(prescriptionDetails_applynumber,prescriptionDetails_money));
		
		//通过上述药品名称找到药品编码,性质
		druginfo= drugdao.findDrugInfoByName(name);
		
		
		//System.out.println(druginfo.getDrugInfo_name());
		
		predetails.setPrescriptionDetails_drugspecs(druginfo.getDrugInfo_standard());//规格
		predetails.setPrescriptionDetails_batch(druginfo.getDrugInfo_approve());//批号
		predetails.setPrescriptionDetails_drugcode((String)druginfo.getDrugCode().getDrugCode_number());//药品编码
		predetails.setPrescriptionDetails_drugquality(druginfo.getDrugInfo_dosage());//药品性质		
		predetails.setPrescriptionDetails_doseunit("1");//剂量单位		
		predetails.setPrescriptionDetails_drugtype(druginfo.getDrugCategory().getDrugCategory_name());//药品类型
        predetails.setPrescriptionDetails_showunit("1");//单位
        predetails.setPrescriptionDetails_usecode("1");//用法代码
        predetails.setPrescriptionDetails_applydate(Calendar.getInstance().getTime());
        

		
		predetails.setPrescriptionDetails_deptcode(prescriptionDetails_deptcode);//医生部门，别地方传值
		
		//System.out.print(prescriptionDetails_drugname+"---------------------------");
		predetailsdao.savePrescriptionDetails(predetails);
		
		//存入处方表中
		MZ_Prescription ption=new MZ_Prescription();
		ption.setPrescription_number(prescriptionDetails_number);
		String pName1=java.net.URLDecoder.decode(request.getParameter("pName"),"UTF-8");
		String pSex1=java.net.URLDecoder.decode(request.getParameter("pSex"),"UTF-8");
		String pDept1=java.net.URLDecoder.decode(request.getParameter("pDept"),"UTF-8");
		String pDoc1=java.net.URLDecoder.decode(request.getParameter("pDoc"),"UTF-8");
		
		ption.setPrescription_name(pName1);
		ption.setPrescription_sex(pSex1);
		ption.setPrescription_doctordept(pDept1);
		ption.setPrescription_doctor(pDoc1);
		ption.setPrescription_age(request.getParameter("pAge"));
		ption.setPrescription_casenumber(request.getParameter("pCaseNo"));
		ption.setPrescription_billsnumber(request.getParameter("pFapiao"));
		ption.setPrescription_number(prescriptionDetails_number);
		double count=prescriptionDetails_money*prescriptionDetails_applynumber;
		ption.setPrescription_cost(count);
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String prescription_date=sDateFormat.format(new Date());
		Date date1=sDateFormat.parse(prescription_date);
		ption.setPrescription_date(date1);
		ption.setPrescription_feedate(date1);
		PrescriptionDao dao2=new PrescriptionDao();
		dao2.savePrescription1(ption);
		
		
		filldata(prescriptionDetails_number);
		return SUCCESS;
	}
    public double total(int number,double money)
    {
    	return money*number;
    }
	
	
	public String submit(){
	//	predetails.setPrescriptionDetails_number(prescriptionDetails_number);//处方号
		String str="1";
	    double all=0;
	    System.out.println(all+"iiiiiiiiiiiii");
	//	 System.out.println(prescriptionDetails_number+"###111111111111111111111");
		for(int i=0;i<predetailsdao.findDetailsByNumber(prescriptionDetails_number).size();i++){
			predetailsdao.findDetailsByNumber(prescriptionDetails_number).get(i).setPrescriptionDetails_applystate(str);
			all+=predetailsdao.findDetailsByNumber(prescriptionDetails_number).get(i).getPrescriptionDetails_totalmoney();
//		    System.out.println(all+"iiiiiiiiiiiii");
//			if(i==predetailsdao.findDetailsByNumber(prescriptionDetails_number).size()-1)
//			{
//		    pre.findPre(prescriptionDetails_number).setPrescription_cost(all);
//			System.out.println(all+"iiiiiiiiiiiii");
			//}
		} 
		return SUCCESS;
	}
//	public String query()
//	   {
//		   String type=request.getParameter("queryType");
//		   String data=request.getParameter("queryData");
//		   if(type != null||data!=null){
//
//			   List jc_ry_login2=predao.findRrescription(type, data);
//			   request.setAttribute("list", jc_ry_login2);
//			}
//		   return SUCCESS;
//	   }
	
	
	 public String delete()
	   {
		   String id=request.getParameter("prescriptiondetails_id");
		   System.out.println(id+"--------------------");
		   if(id != null){
				//删除留言信息
				predetailsdao.deletePrescriptionDetails(Integer.valueOf(id));
				filldata(prescriptionDetails_number);
			}
		   return SUCCESS;
	   }
	
//	  public String modify1()     //获得要更新用户，将其现有的数据显示在一个jsp上。
//	   {
//		   String id=request.getParameter("prescription_id");
//		   if(id != null)
//		   {
//			   request.setAttribute("loginmodifyInfo", predao.getPrescription(Integer.valueOf(id)));
//		   }
//		   return SUCCESS;
//	   }
	   public String modify2() throws UnsupportedEncodingException    //更新，入库。
	   {
		   String id=request.getParameter("prescriptionDetails_id");
		   String name=java.net.URLDecoder.decode(prescriptionDetails_drugname,"UTF-8");
		//   System.out.println(id);
		   MZ_PrescriptionDetails pre=new MZ_PrescriptionDetails();
		   pre=predetailsdao.getPrescriptionDetails(Integer.valueOf(id)); //找到需要修改的用户
		   pre.setPrescriptionDetails_drugname(name);
		   pre.setPrescriptionDetails_applynumber(prescriptionDetails_applynumber);
		   pre.setPrescriptionDetails_money(prescriptionDetails_money);
		   //设置金额
		   total(prescriptionDetails_applynumber,prescriptionDetails_money);
			//System.out.print(total(prescriptionDetails_applynumber,prescriptionDetails_money));
		   pre.setPrescriptionDetails_totalmoney(total(prescriptionDetails_applynumber,prescriptionDetails_money));
		   
		   pre.setPrescriptionDetails_usename(prescriptionDetails_usename);
		   pre.setPrescriptionDetails_frecode(prescriptionDetails_frecode);
		   pre.setPrescriptionDetails_doseonce(prescriptionDetails_doseonce);
		   predetailsdao.savePrescriptionDetails(pre);  //入库	
		   filldata(prescriptionDetails_number);	
		   //queryAll();
//		   System.out.print(prescriptionDetails_number+"---------------");
		   return SUCCESS;
	   }
	
	
	  public void fillData()  //用于在每次跳转到 页面时将所有数据显示在其中。
	   {
		   String page = request.getParameter("currPage");
		   int currPage = 1; // 当前页
			int pageSize = 20; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=predetailsdao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModel", pageModel);
	   }
	   
	  public void filldata(String number)  
	   {
		   String page = request.getParameter("currPage");
		   
		   int currPage = 1; // 当前页
			int pageSize = 7; // 每页显示5条记录
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModel");
		   PageModel pageModel=predetailsdao.findpaging(currPage, pageSize,number);
		   request.setAttribute("pageModel", pageModel);
	   }
	   public String queryAll()
	   {
		   fillData();
		   return SUCCESS;
	   }
//	public String isInput() throws IOException{
//		HttpServletResponse response=ServletActionContext.getResponse();
//		PrintWriter p=response.getWriter();
//		String username=request.getParameter("login_name");
//		if( predao.isPrescription(username)==true)
//		{
//			p.print("true");
//			System.out.print("true");
//		}
//		else
//			p.print("flase");
//		System.out.print("false");
//		return null;
//	}

	

}
