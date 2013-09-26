package com.OutPatientService.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.dao.PrescriptionDao;
import com.OutPatientService.dao.PrescriptionDetailsDao;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.OutPatientService.model.MZ_RegisterMain;
import com.OutPatientService.model.MZ_RegisterPatient;

public class PrescriptionAction extends ActionSupport{
	
	
	private MZ_Prescription prescription =new MZ_Prescription();//ʵ������¼�û�ά����
	private PrescriptionDetailsAction prescriptionDetails =new PrescriptionDetailsAction();
	PrescriptionDao predao=new PrescriptionDao();
	PrescriptionDetailsDao predetailsdao=new PrescriptionDetailsDao();
	private HttpServletRequest request=ServletActionContext.getRequest();

	
	private String prescription_number;//������
	private String prescription_state;//����״̬
	private String prescription_casenumber;//������
	private String prescription_name;//��������
	private String prescription_sex;//�����Ա�
	private String prescription_age;//��������
	

	public String getPrescription_age() {
		return prescription_age;
	}

	public void setPrescription_age(String prescription_age) {
		this.prescription_age = prescription_age;
	}

	private String prescription_paykind;//�������
	private String prescription_patientdeptcode;//���߿��ұ���
	private Date prescription_date;//�Һ�����
	private String prescription_doctor;//����ҽ��
	private String prescription_doctordept;//����ҽ������
	private String prescription_feecode;//�շ��˱���
	private Date prescription_feedate;//�շ�ʱ��
	private String prescription_billsnumber;//Ʊ�ݺ�
	private double prescription_cost;//�������
	private String prescription_dispenser;//��ҩ��
	private String prescription_dispensedept;//��ҩ����
	private Date prescription_dispensedate;//��ҩ����
	private String prescription_sender;//��ҩ��
	private Date prescription_senddate;//��ҩ����
	private String prescription_senddept;//��ҩ����
	private String prescription_validstate;//��Ч״̬
	private String prescription_backer;//��ҩ��
	private Date prescription_backdate;//��ҩ����
	private String prescription_canceler;//ȡ������Ա
	private Date prescription_canceldate;//ȡ������
	
	
	

	public String getPrescription_number() {
		return prescription_number;
	}

	public void setPrescription_number(String prescription_number) {
		this.prescription_number = prescription_number;
	}

	public String getPrescription_state() {
		return prescription_state;
	}

	public void setPrescription_state(String prescription_state) {
		this.prescription_state = prescription_state;
	}

	public String getPrescription_casenumber() {
		return prescription_casenumber;
	}

	public void setPrescription_casenumber(String prescription_casenumber) {
		this.prescription_casenumber = prescription_casenumber;
	}

	public String getPrescription_name() {
		return prescription_name;
	}

	public void setPrescription_name(String prescription_name) {
		this.prescription_name = prescription_name;
	}

	public String getPrescription_sex() {
		return prescription_sex;
	}

	public void setPrescription_sex(String prescription_sex) {
		this.prescription_sex = prescription_sex;
	}

	

	public String getPrescription_paykind() {
		return prescription_paykind;
	}

	public void setPrescription_paykind(String prescription_paykind) {
		this.prescription_paykind = prescription_paykind;
	}

	public String getPrescription_patientdeptcode() {
		return prescription_patientdeptcode;
	}

	public void setPrescription_patientdeptcode(String prescription_patientdeptcode) {
		this.prescription_patientdeptcode = prescription_patientdeptcode;
	}

	public Date getPrescription_date() {
		return prescription_date;
	}

	public void setPrescription_date(Date prescription_date) {
		this.prescription_date = prescription_date;
	}

	public String getPrescription_doctor() {
		return prescription_doctor;
	}

	public void setPrescription_doctor(String prescription_doctor) {
		this.prescription_doctor = prescription_doctor;
	}

	public String getPrescription_doctordept() {
		return prescription_doctordept;
	}

	public void setPrescription_doctordept(String prescription_doctordept) {
		this.prescription_doctordept = prescription_doctordept;
	}

	public String getPrescription_feecode() {
		return prescription_feecode;
	}

	public void setPrescription_feecode(String prescription_feecode) {
		this.prescription_feecode = prescription_feecode;
	}

	public Date getPrescription_feedate() {
		return prescription_feedate;
	}

	public void setPrescription_feedate(Date prescription_feedate) {
		this.prescription_feedate = prescription_feedate;
	}

	public String getPrescription_billsnumber() {
		return prescription_billsnumber;
	}

	public void setPrescription_billsnumber(String prescription_billsnumber) {
		this.prescription_billsnumber = prescription_billsnumber;
	}

	public double getPrescription_cost() {
		return prescription_cost;
	}

	public void setPrescription_cost(double prescription_cost) {
		this.prescription_cost = prescription_cost;
	}

	public String getPrescription_dispenser() {
		return prescription_dispenser;
	}

	public void setPrescription_dispenser(String prescription_dispenser) {
		this.prescription_dispenser = prescription_dispenser;
	}

	public String getPrescription_dispensedept() {
		return prescription_dispensedept;
	}

	public void setPrescription_dispensedept(String prescription_dispensedept) {
		this.prescription_dispensedept = prescription_dispensedept;
	}

	public Date getPrescription_dispensedate() {
		return prescription_dispensedate;
	}

	public void setPrescription_dispensedate(Date prescription_dispensedate) {
		this.prescription_dispensedate = prescription_dispensedate;
	}

	public String getPrescription_sender() {
		return prescription_sender;
	}

	public void setPrescription_sender(String prescription_sender) {
		this.prescription_sender = prescription_sender;
	}

	public Date getPrescription_senddate() {
		return prescription_senddate;
	}

	public void setPrescription_senddate(Date prescription_senddate) {
		this.prescription_senddate = prescription_senddate;
	}

	public String getPrescription_senddept() {
		return prescription_senddept;
	}

	public void setPrescription_senddept(String prescription_senddept) {
		this.prescription_senddept = prescription_senddept;
	}

	public String getPrescription_validstate() {
		return prescription_validstate;
	}

	public void setPrescription_validstate(String prescription_validstate) {
		this.prescription_validstate = prescription_validstate;
	}

	public String getPrescription_backer() {
		return prescription_backer;
	}

	public void setPrescription_backer(String prescription_backer) {
		this.prescription_backer = prescription_backer;
	}

	public Date getPrescription_backdate() {
		return prescription_backdate;
	}

	public void setPrescription_backdate(Date prescription_backdate) {
		this.prescription_backdate = prescription_backdate;
	}

	public String getPrescription_canceler() {
		return prescription_canceler;
	}

	public void setPrescription_canceler(String prescription_canceler) {
		this.prescription_canceler = prescription_canceler;
	}

	public Date getPrescription_canceldate() {
		return prescription_canceldate;
	}

	public void setPrescription_canceldate(Date prescription_canceldate) {
		this.prescription_canceldate = prescription_canceldate;
	}

//	public String add(){
//		prescription.getPrescription_casenumber();
//		
//	}
	
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
		   String id=request.getParameter("prescription_id");
		   if(id != null){
				//ɾ��������Ϣ
				predao.deletePrescription(Integer.valueOf(id));
				fillData();
			}
		   return SUCCESS;
	   }
	
//	  public String modify1()     //���Ҫ�����û����������е�������ʾ��һ��jsp�ϡ�
//	   {
//		   String id=request.getParameter("prescription_id");
//		   if(id != null)
//		   {
//			   request.setAttribute("loginmodifyInfo", predao.getPrescription(Integer.valueOf(id)));
//		   }
//		   return SUCCESS;
//	   }
	   public String modify2()    //���£���⡣
	   {
		   String id=request.getParameter("id");
		   System.out.println(id);
		   MZ_RegisterMain pre=new MZ_RegisterMain();
		   pre=predao.getPrescription(Integer.valueOf(id)); //�ҵ���Ҫ�޸ĵ��û�
//		   pre.setLogin_name(login_name);
//		   pre.setLogin_password(login_password);
//		   pre.setLogin_type(login_type);
		   predao.savePrescription(pre);  //���	
		  // fillData();	
		   queryAll();
		   return SUCCESS;
	   }
	   public String findPatient(){
		   String id=request.getParameter("registerMain_id");
		   String casenumber=request.getParameter("registerMain_No");//������
	   
//		   System.out.println(id);
//		   System.out.println(casenumber);
		   if(id!=null)
		   {
			   request.setAttribute("patientDetails", predao.getPrescription(Integer.valueOf(id)));
			 //  prescription.setPrescription_casenumber(casenumber);
			   prescriptionDetails.filldata(casenumber);
		   }
		   return SUCCESS;
	   }
	
	
	  public String fillData()  //������ÿ����ת�� ҳ��ʱ������������ʾ�����С�
	   {
		   String page = request.getParameter("currPagePatient");
		   int currPage = 1; // ��ǰҳ
	       int pageSize = 20; // ÿҳ��ʾ5����¼
			if (page != null) {
				currPage = Integer.parseInt(page);
			}
		   request.removeAttribute("pageModelPatient");
		   PageModel pageModelPatient=predao.findPaging(currPage, pageSize);
		   request.setAttribute("pageModelPatient", pageModelPatient);
	//	   System.out.print(pageModelPatient.getList().isEmpty());
//		   
//		   prescriptionDetails.fillData();
		   return SUCCESS;
	   }
	   
	   public String queryAll()
	   {
		   //fillData();
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
