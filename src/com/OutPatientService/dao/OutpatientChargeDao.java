package com.OutPatientService.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.HibernateUtil;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.OutPatientService.model.MZ_RegisterPatient;

public class OutpatientChargeDao {

	
	public MZ_Prescription findprescription(String number){
		Session session = null;					//Session����
		MZ_Prescription prescription = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from MZ_Prescription u where u.prescription_number='"+number+"'";
			Query query = session.createQuery(hql);		//����Query����
								//��̬��ֵ
								//��̬��ֵ
			prescription = (MZ_Prescription)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return prescription;
	}
	
	public MZ_PrescriptionDetails findPrescriptionDetails(String number){
		Session session = null;					//Session����
		MZ_PrescriptionDetails prescription = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from MZ_PrescriptionDetails u where u.prescriptionDetails_number='"+number+"'";
			Query query = session.createQuery(hql);		//����Query����
								//��̬��ֵ
								//��̬��ֵ
			prescription = (MZ_PrescriptionDetails)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return prescription;
	}
}
