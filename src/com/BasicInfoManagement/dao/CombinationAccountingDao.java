/*
 *��ϻ������ݴ���DAO�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_CombinationAccounting)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.10
 *
*/
package com.BasicInfoManagement.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.PageModel;

import java.util.List;

import com.BasicInfoManagement.model.JC_SF_CombinationAccounting;
import com.BasicInfoManagement.model.JC_SF_PayDetail;
import com.BasicInfoManagement.util.HibernateUtil;
public class CombinationAccountingDao {
	//��ӻ򱣴��޸��շ���Ŀ
	public void SavaCAccounting(JC_SF_CombinationAccounting combinationAccounting)
	{
		Session session=null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			session.saveOrUpdate(combinationAccounting); // �־û���ϻ�����Ϣ
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}

	}
	//�����շѱ�������ض���
	public JC_SF_CombinationAccounting ReturnCAccountingById(String num)
	{
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{
		
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_number=?";//����HQL��ѯ
			Query query=session.createQuery(hql).setParameter(0, num);
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();
			session.beginTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//�ع�����
		}
		finally
		{
			HibernateUtil.closeSession();//�ر�session
		}
		return combinationAccounting;//����ָ��ID�ŷ��ض���
	}
	//���ʱ�ж���ϻ��۱���Ƿ��Ѵ���
	public boolean FindCAccountingByNum(String num)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{//��ȡSession
			session=HibernateUtil.getSession();
			session.beginTransaction();//��������
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_number=?";//hql���
			Query query=session.createQuery(hql).setParameter(0, num);//����Query��ѯ
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();//���ؽ����
			if(combinationAccounting==null)
			{
				exist=true;
			}
				session.beginTransaction().commit();	//�ύ����
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//�ع�����
		}
		finally
		{
			HibernateUtil.closeSession();//�ر�session
		}
		return exist;//����bool����
	}
	
	//���ʱ�ж���ϻ��������Ƿ��Ѵ���
	public boolean FindCAccountingByName(String name)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{//��ȡSession
			session=HibernateUtil.getSession();
			session.beginTransaction();//��������
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_name=?";//hql���
			Query query=session.createQuery(hql).setParameter(0, name);//����Query��ѯ
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();//���ؽ����
			if(combinationAccounting==null)
			{
				exist=true;
			}
				session.beginTransaction().commit();	//�ύ����
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//�ع�����
		}
		finally
		{
			HibernateUtil.closeSession();//�ر�session
		}
		return exist;//����bool����
	}
	
	public void DeleteCAccountingById(int id)
	{
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id���շ���ϸ��Ŀ
			JC_SF_CombinationAccounting combinationAccounting = (JC_SF_CombinationAccounting)session.get(JC_SF_CombinationAccounting.class, id);
			session.delete(combinationAccounting);			//ɾ���շ���ϵ��Ŀ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	/**
	 * ��ѯ������ϻ�����Ŀ������Ϣ
	 * @return List����
	 */
	public List<JC_SF_CombinationAccounting> FindAllCAccounting(){
		Session session = null;					//Session����
		List<JC_SF_CombinationAccounting> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_SF_CombinationAccounting";		//HQL��ѯ���
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
	/**
	 * ��ҳ��ѯ��ϻ���������Ϣ
	 * @param currPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @return	PageModel �Զ����ҳ���
	 */
	public PageModel FindPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬��ID��������
			String hql = "from JC_SF_CombinationAccounting m order by m.combinationAccounting_id desc";
			List<JC_SF_CombinationAccounting> list = session.createQuery(hql)		//����Query����
		  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
		  					.setMaxResults(pageSize)	//���ü�¼��
		  					.list();					//���ؽ����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(currPage);	//���õ�ǰҳ
			pageModel.setList(list);			//���ý����
			pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
			//�����ܼ�¼��
			pageModel.setTotalRecords(GetTotalRecords(session));
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
	 * ��ѯ��ϻ���������ܼ�¼��
	 * 
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int GetTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_SF_CombinationAccounting";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}
	



