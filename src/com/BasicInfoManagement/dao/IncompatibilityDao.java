package com.BasicInfoManagement.dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_YP_Incompatibility;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
//import com.lyq.model.Message;

public class IncompatibilityDao {
	private HttpServletRequest request;
	public IncompatibilityDao()
	{
		request=ServletActionContext.getRequest();
	}
	public void saveIncompatibility(JC_YP_Incompatibility incompate)
	{
		Session session=null;
		try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(incompate);
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
	public void updateIncompate(Integer id,String data,String type)
	{
		Session session = null;					//Session����
		//boolean exist = false;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "update jc_yp_incompatibility i set i.?=? where i.incompatibility_id=?";
			Query query = session.createQuery(hql)		//����Query����
								 .setParameter(0, id);//��̬��ֵ
			Object user = query.uniqueResult();			//����User����
			//����û�����existΪtrue
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	public List<JC_YP_Incompatibility> findAllIncompatibility()
	{
		Session session=null;
		List<JC_YP_Incompatibility> list=null;
		try
		{
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="from jc_yp_incompatibility";
			list=session.createQuery(hql).list();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return list;
	}
	public JC_YP_Incompatibility findIncompatibilityById(Integer id)
	{
		Session session=null;
		JC_YP_Incompatibility incompate=null;
//		try{
//			session=HibernateUtil.getSession();
//			session.beginTransaction();
//			System.out.println("dao������ʼִ��"+id);
//			String hql="from jc_yp_incompatibility  as i where i.incompatibility_id=?";
//			Query query=session.createQuery(hql).setParameter(0, id);
//			incompate=(JC_YP_Incompatibility)query.uniqueResult();
//			session.getTransaction().commit();
//		}
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			incompate = (JC_YP_Incompatibility)session.get(JC_YP_Incompatibility.class, id);
			session.getTransaction().commit();
		}
 	//�ύ����
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return incompate;
	}
	public void removeIncompatibilityByName(Integer id)
	{
		Session session=null;
		//String[] names=null;
		
		//JC_YP_Incompatibility incompate=null;
		System.out.println("zzzzzzzzzzzzzz����ɾ�� ");
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			JC_YP_Incompatibility message = (JC_YP_Incompatibility)session.get(JC_YP_Incompatibility.class, id);
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
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
//		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_Incompatibility";
			List<JC_YP_Incompatibility> list = session.createQuery(hql)		//����Query����
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
		String hql = "select count(*) from JC_YP_Incompatibility";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
	public List<JC_YP_Incompatibility> findIncompatibilityInfo(String type, String data){
		//System.out.println("�����ѯ");
		Session session = null;					//Session����
		List<JC_YP_Incompatibility> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_YP_Incompatibility cs where cs."+type+"=?";		//HQL��ѯ���
			//list = session.createQuery(hql).setParameter(0, type).setParameter(1, data).list();	//��ȡ�����
			Query query=session.createQuery(hql);
			if(type=="incompatibility_id")
			{
				query.setInteger(0, Integer.valueOf(data));
			}
			else
				query.setString(0, data);
			list=query.list();
			//System.out.println("�õ�list");
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


