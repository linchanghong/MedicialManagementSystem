package com.BasicInfoManagement.dao;
/*
 * dlq
 * 2013.8.9
 * �û���¼ά��
 */

import java.util.List;
import org.hibernate.*;
import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;

import org.hibernate.Session;
import org.hibernate.Query;


public class LoginDao {
	
	//�����޸��û���Ϣ
	public void saveUser(JC_RY_Login jc_ry_login){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(jc_ry_login);			//�־û�login
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	public JC_RY_Login getLogin(Integer id){
		Session session = null;					//Session����
		JC_RY_Login message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (JC_RY_Login)session.get(JC_RY_Login.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	
	
	
	

	
	//��ѯ�����û�
	public List<JC_RY_Login> findAllUser(){
		Session session = null;					//Session����
		List<JC_RY_Login> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_RY_Login";		//HQL��ѯ���
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
	
	
	
	//ɾ���û� ��idɾ��
	public void deleteUser(int id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id���û�
			JC_RY_Login jc_ry_login = (JC_RY_Login)session.get(JC_RY_Login.class, id);
			session.delete(jc_ry_login);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}

	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param currPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @return	PageModel �Զ����ҳ���
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_RY_Login";
		//	@SuppressWarnings("unchecked")
			List<JC_RY_Login> list = session.createQuery(hql)		//����Query����
		  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
		  					.setMaxResults(pageSize)	//���ü�¼��
		  					.list();					//���ؽ����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(currPage);	//���õ�ǰҳ
			pageModel.setList(list);			//���ý����
			pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
			//�����ܼ�¼��
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pageModel;
	}
	//���������
	public List<JC_RY_Login> findLogin(String type, String data){
		Session session = null;					//Session����
		List<JC_RY_Login> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
			String hql="from JC_RY_Login login where login."+type+"='"+data+"'";
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
	public boolean isUser(String username)
	{		
		Session session = null;					//Session����
		boolean b=false;			//boolean�Ƿ����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
			String hql="from JC_RY_Login login where login.login_name="+username;
			Query query = session.createQuery(hql)	;	//����Query����
				     		//��ȡ�����
			Object object=query.uniqueResult();//����Ψһ����
			if(object!=null)
			{
				b=true;//����
			}
						
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return b;
		
	}
	
	
	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_RY_Login";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}
