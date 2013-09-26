package com.OutPatientService.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.HibernateUtil;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.OutPatientService.model.MZ_RegisterPatient;

public class OutpatientChargeDao {

	
	public MZ_Prescription findprescription(String number){
		Session session = null;					//Session对象
		MZ_Prescription prescription = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from MZ_Prescription u where u.prescription_number='"+number+"'";
			Query query = session.createQuery(hql);		//创建Query对象
								//动态赋值
								//动态赋值
			prescription = (MZ_Prescription)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return prescription;
	}
	
	public MZ_PrescriptionDetails findPrescriptionDetails(String number){
		Session session = null;					//Session对象
		MZ_PrescriptionDetails prescription = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from MZ_PrescriptionDetails u where u.prescriptionDetails_number='"+number+"'";
			Query query = session.createQuery(hql);		//创建Query对象
								//动态赋值
								//动态赋值
			prescription = (MZ_PrescriptionDetails)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return prescription;
	}
}
