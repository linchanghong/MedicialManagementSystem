package com.OutPatientService.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_BedInfo;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_Login;
import com.BasicInfoManagement.util.HibernateUtil;
import com.OutPatientService.model.MZ_RegisterLevel;
import com.OutPatientService.model.MZ_RegisterMain;
import com.OutPatientService.model.MZ_RegisterPatient;
import com.OutPatientService.model.SequenceGenerate;

public class RegisterDao {
	
	public MZ_RegisterMain getRegisterInfo(Integer id){
		Session session = null;					//Session����
		MZ_RegisterMain message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (MZ_RegisterMain)session.get(MZ_RegisterMain.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	public JC_RY_Login findUser(String username, String password){
		Session session = null;					//Session����
		JC_RY_Login user = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from JC_RY_Login u where u.login_name='"+username+"' and u.login_password='"+password+"'";
			Query query = session.createQuery(hql);		//����Query����
						//��̬��ֵ
			user = (JC_RY_Login)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return user;
	}
	//�ҵ�������Ϣ
	public MZ_RegisterPatient findpaitent(String number){
		Session session = null;					//Session����
		MZ_RegisterPatient paitent = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from MZ_RegisterPatient u where u.regiserPatient_caseNo=?";
			Query query = session.createQuery(hql)		//����Query����
								.setParameter(0, number);//��̬��ֵ
								//��̬��ֵ
			paitent = (MZ_RegisterPatient)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return paitent;
	}
	
	
	//�ҵ��Һ���Ϣ
	public MZ_RegisterMain findRegister(String number){
		Session session = null;					//Session����
		MZ_RegisterMain register = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from MZ_RegisterMain u where u.registerMain_No=?";
			Query query = session.createQuery(hql)		//����Query����
								.setParameter(0, number);//��̬��ֵ
								//��̬��ֵ
			register = (MZ_RegisterMain)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return register;
	}
	//�ҵ����еĹҺż���
	public List<MZ_RegisterLevel> findAllRegisterLevel(){
		Session session = null;					//Session����
		List<MZ_RegisterLevel> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from MZ_RegisterLevel";		//HQL��ѯ���
			list = session.createQuery(hql)		//����Query����
				          .list();				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return list;
	}
	
	public Long findSequenceCode(){
		Session session = null;					//Session����
		Long code = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "select max(sequence_code) from SequenceGenerate";
			Query query = session.createQuery(hql);		//����Query����
			code = (Long)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return code;
	}
	
	
	public void saveCode(SequenceGenerate code){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(code);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	public void saveRegister(MZ_RegisterMain code){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(code);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	public MZ_RegisterMain findNo(String name){//����wordʱʹ��
		Session session = null;					//Session����
		MZ_RegisterMain list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from MZ_RegisterMain a where a.registerMain_No='"+name+"'";		//HQL��ѯ���
			Query query = session.createQuery(hql);
			list = (MZ_RegisterMain)query.uniqueResult();//����Query����
				    				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return list;
	} 
}
