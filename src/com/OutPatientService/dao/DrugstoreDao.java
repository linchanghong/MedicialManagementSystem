package com.OutPatientService.dao;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_SF_PayDetail;
import com.BasicInfoManagement.util.HibernateUtil;
import com.OutPatientService.model.Drugstore_Dosage;
public class DrugstoreDao {
	//两个条件，处方收费情况。   处方状态 获取配药信息
	@SuppressWarnings("unchecked")
	public List<Drugstore_Dosage> get(String State)	{
		Session session = null;					//Session对象
		List<Drugstore_Dosage> list = new ArrayList<Drugstore_Dosage>();
		SimpleDateFormat dateformat=new SimpleDateFormat();
		List<Object> l = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			String sql = "select m.prescription_number,m.prescription_name,"
					+ "m.prescription_sex,m.prescription_age,m.prescription_date,"
					+ "m.prescription_doctor,m.prescription_doctordept,m.prescription_feedate,"
					+ "m.prescription_cost, "+"p.prescriptionDetails_drugname,p.prescriptionDetails_drugspecs,"
					+ "p.prescriptionDetails_showunit,"
					+ "p.prescriptionDetails_doseonce,p.prescriptionDetails_doseunit,"
					+ "p.prescriptionDetails_usename,p.prescriptionDetails_frecode,p.prescriptionDetails_applynumber," 
					+ "m.prescription_state,m.prescription_billsnumber,m.prescription_casenumber"
					+ " from MZ_Prescription  as m inner join MZ_PrescriptionDetails as p " +
					"on m.prescription_number=p.prescriptionDetails_number where m.prescription_state =? " +
					"and p.prescriptionDetails_chargeflag=1";
				Query q=session.createSQLQuery(sql);
				q.setString(0, State);
				l=q.list();
			for(Object obj:l){
				Drugstore_Dosage dd = new Drugstore_Dosage();
				Object[] o = (Object[])obj;
				dd.setPreCriptionNumber(o[0].toString());
				dd.setPatientName(o[1].toString());
				dd.setPatientSex(o[2].toString());
				dd.setPatientAge(o[3].toString());
				dd.setRegisterDate((Date)(o[4]));
				dd.setPrescription_doctor(o[5].toString());
				dd.setPrescription_doctordept(o[6].toString());
				dd.setChargeDate((Date)o[7]);
				dd.setPrescription_drugTotalprice(Double.parseDouble(o[8].toString()));
				dd.setPrescription_drugName(o[9].toString());
				dd.setPrescription_drugStandard(o[10].toString());
				dd.setPrescription_drugUnit(o[11].toString());
				dd.setPrescription_drugDoseonce(Double.parseDouble(o[12].toString()));
				dd.setPrescription_drugdoseunit(o[13].toString());
				dd.setPrescription_drugUsename(o[14].toString());
				dd.setPrescription_drugRate(o[15].toString());	
				dd.setPrescription_drugNumber(Integer.parseInt(o[16].toString()));
				dd.setPrescription_condition(o[17].toString());	
				dd.setPreCriptionBillNumber(o[18].toString());
				dd.setPatientCaseNumber(o[19].toString());
				list.add(dd);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		
		return list;
	}
	
	private Date dateConvert(Object object) throws Exception{
		String str = object.toString();
		str = str.substring(0,str.length()-2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(str);
	}

	//根据处方号返回对象
	public List <Drugstore_Dosage> getByPrecreptNumber(String number, String state)
	{
		
		Drugstore_Dosage drugstore_Dosage=null;
		List<Drugstore_Dosage> list=get(state);
		List<Drugstore_Dosage> drugstore=new ArrayList<Drugstore_Dosage>();
		Iterator it=list.iterator();//使用迭代器返回对象

		while(it.hasNext())
		{
			drugstore_Dosage=(Drugstore_Dosage)it.next();
			if(drugstore_Dosage.getPreCriptionNumber().equals(number)){
				drugstore.add(drugstore_Dosage);
			}
		}
		return drugstore;//根据指定处方号号返回对象集合
	}
	
	//根据发票号返回对象信息
	public List <Drugstore_Dosage> getByPrecreptBillNumber(String number, String state)
	{
		Drugstore_Dosage drugstore_Dosage=null;
		List<Drugstore_Dosage> list=get(state);
		List<Drugstore_Dosage> drugstore=new ArrayList<Drugstore_Dosage>();
		Iterator it=list.iterator();//使用迭代器返回对象

		while(it.hasNext())
		{
			drugstore_Dosage=(Drugstore_Dosage)it.next();
			if(drugstore_Dosage.getPreCriptionBillNumber().equals(number)){
				drugstore.add(drugstore_Dosage);
			}
		}
		return drugstore;//根据指定处方号号返回对象集合
	}
		//根据药材更随的处方号更新处方状态
	public void UpdatePrecreptCondition(String preCreptNumber,String state)
	{
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String sql="update  MZ_Prescription mz set mz.prescription_state=? where mz.prescription_number=?";
			Query q = session.createQuery(sql);
			q.setString(0, state);
			q.setString(1,preCreptNumber);
			q.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
	}
	
	
	
	
	
	
	
}
