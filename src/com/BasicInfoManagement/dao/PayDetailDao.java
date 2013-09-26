/*
 *�շ���Ŀ�������ݴ���DAO�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_PayDetail)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.8
 *
*/
package com.BasicInfoManagement.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.PageModel;

import java.util.List;
import com.BasicInfoManagement.model.JC_SF_PayDetail;
import com.BasicInfoManagement.util.HibernateUtil;
public class PayDetailDao {
	//��ӻ򱣴��޸��շ���Ŀ
	public void SavaPayDetail(JC_SF_PayDetail payDetail)
	{
		Session session=null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			session.saveOrUpdate(payDetail); // �־û��շ�������Ϣ
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}

	}
	//�����շѱ�������ض���
	public JC_SF_PayDetail ReturnDetailById(String num)
	{
		Session session=null;
		JC_SF_PayDetail payDetail=null;
		try
		{
		
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="From JC_SF_PayDetail e where e.payDetail_number=?";//����HQL��ѯ
			Query query=session.createQuery(hql).setParameter(0, num);
			payDetail=(JC_SF_PayDetail)query.uniqueResult();
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
		return payDetail;//����ָ��ID�ŷ��ض���
	}
	
	//���ʱ�ж��շѱ���Ƿ��Ѵ���
	public boolean FindDetailByNum(String num)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_PayDetail payDetail=null;
		try
		{//��ȡSession
			session=HibernateUtil.getSession();
			session.beginTransaction();//��������
			String hql="From JC_SF_PayDetail e where e.payDetail_number=?";//hql���
			Query query=session.createQuery(hql).setParameter(0, num);//����Query��ѯ
			payDetail=(JC_SF_PayDetail)query.uniqueResult();//���ؽ����
			if(payDetail==null)
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
	
	//���ʱ�ж��շ������Ƿ��Ѵ���
	public boolean FindDetailByName(String name)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_PayDetail payDetail=null;
		try
		{//��ȡSession
			session=HibernateUtil.getSession();
			session.beginTransaction();//��������
			String hql="From JC_SF_PayDetail e where e.payDetail_name=?";//hql���
			Query query=session.createQuery(hql).setParameter(0, name);//����Query��ѯ
			payDetail=(JC_SF_PayDetail)query.uniqueResult();//���ؽ����
			if(payDetail==null)
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
	
	public void DeleteDetailById(int id)
	{
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id���շ���ϸ��Ŀ
			JC_SF_PayDetail payDetail = (JC_SF_PayDetail)session.get(JC_SF_PayDetail.class, id);
			session.delete(payDetail);			//ɾ���շ���ϵ��Ŀ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	/**
	 * ��ѯ�����շ���Ŀ������Ϣ
	 * @return List����
	 */
	public List<JC_SF_PayDetail> FindAllPayDetail(){
		Session session = null;					//Session����
		List<JC_SF_PayDetail> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_SF_PayDetail";		//HQL��ѯ���
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
	 * ��ҳ��ѯ�շ���Ŀ������Ϣ
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
			String hql = "from JC_SF_PayDetail m order by m.payDetail_id desc";
			List<JC_SF_PayDetail> list = session.createQuery(hql)		//����Query����
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
	 * ��ѯ�շ�������ܼ�¼��
	 * 
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int GetTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_SF_PayDetail";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}
	



