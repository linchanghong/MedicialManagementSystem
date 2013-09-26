package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_YP_CipherPres;
import com.BasicInfoManagement.model.JC_YP_Incompatibility;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

public class CipherPresDao {
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
//		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_CipherPres";
			List<JC_YP_CipherPres> list = session.createQuery(hql)		//����Query����
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
	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_CipherPres";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
	public void removeCipherPres(Integer id)
	{
		Session session=null;
		//String[] names=null;
		
		//JC_YP_Incompatibility incompate=null;
		System.out.println("zzzzzzzzzzzzzz����ɾ�� "+id);
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			JC_YP_CipherPres message = (JC_YP_CipherPres)session.get(JC_YP_CipherPres.class, id);
			if(message!=null)
			session.delete(message);			//ɾ������
			session.getTransaction().commit(); 
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
	public List<JC_YP_CipherPres> findCipherPresInfo(String type, String data){
		//System.out.println("�����ѯ");
		Session session = null;					//Session����
		List<JC_YP_CipherPres> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_YP_CipherPres cs where cs."+type+"=?";		//HQL��ѯ���
			//list = session.createQuery(hql).setParameter(0, type).setParameter(1, data).list();	//��ȡ�����
			Query query=session.createQuery(hql);
			if(type=="cipherPres_id")
			{
				query.setInteger(0, Integer.valueOf(data));
			}
			else
				query.setString(0, data);
			list=query.list();
			System.out.println("�õ�list"+list.size());
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return list;
	}
	public void saveCipherPres(JC_YP_CipherPres cipherPres)
	{
		Session session=null;
		try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(cipherPres);
		session.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally
		{
			HibernateUtil.closeSession();
		}
		
	}
}
