package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.BasicInfoManagement.util.*;
import com.BasicInfoManagement.model.*;


public class DeptInfoDao {
	public void saveDeptInfo(JC_LC_DeptInfo deptInfo){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(deptInfo);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	//��ѯ����������Ϣ
	/**
	 * ɾ��������Ϣ
	 * @param id ����id
	 */
	public void deleteDeptInfo(Integer id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			JC_LC_DeptInfo message = (JC_LC_DeptInfo)session.get(JC_LC_DeptInfo.class, id);
			session.delete(message);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ��ѯ����������Ϣ
	 * @return List����
	 */
	public List<JC_LC_DeptInfo> findQueryDeptInfo(String type, String data){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_DeptInfo cs where cs."+type+"='"+data+"'";		//HQL��ѯ���
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
	
	public List<JC_LC_DeptInfo> findAllDeptInfo(){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_DeptInfo";		//HQL��ѯ���
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
	//��֤�û�����������Ƿ��Ѿ�����
	public boolean deptNumberValidate(String number){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_number='"+number+"'";		//HQL��ѯ���
			list = session.createQuery(hql)		//����Query����
				          .list();				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	
	public boolean deptNameValidate(String number){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
//			System.out.println("1111111111111111111111111111111"+number);
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_name='"+number+"'";		//HQL��ѯ���
			list = session.createQuery(hql)		//����Query����
				          .list();				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	
	
	public boolean deptZjmValidate(String number){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_zjm='"+number+"'";		//HQL��ѯ���
			list = session.createQuery(hql)		//����Query����
				          .list();				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	/**
	 * ͨ��id����������Ϣ
	 * @param id ����id
	 * @return Message����
	 */
	public JC_LC_DeptInfo getDeptInfo(Integer id){
		Session session = null;					//Session����
		JC_LC_DeptInfo message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (JC_LC_DeptInfo)session.get(JC_LC_DeptInfo.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	public List<JC_LC_DeptInfo> queryByWhereParameterChain(String type, String data){
		//1����ȡSession
		Session session = HibernateUtil.getSession();
		
		List result = null;
		String queryStr = "from JC_LC_DeptInfo cs where cs.id>? and cs.name like ?";
		
		Query query = session.createQuery(queryStr)
			.setString(0, type)
			.setString(1, data);		
		result = query.list();
		
		return result;
	}
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param currPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @return	PageModel �Զ����ҳ���
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_LC_DeptInfo";
			List<JC_LC_DeptInfo> list = session.createQuery(hql)		//����Query����
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
	/**
	 * ��ѯ���Ե��ܼ�¼��
	 * 
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_LC_DeptInfo";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}
