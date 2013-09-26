package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_BedInfo;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_DoctorInfo;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

public class BedInfoDao {
	public List<JC_LC_DeptInfo> findDeptName(){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "select deptInfo_name from JC_LC_DeptInfo";		//HQL��ѯ���
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
	
	public JC_LC_DeptInfo findDept(String name){
		Session session = null;					//Session����
		JC_LC_DeptInfo list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_DeptInfo a where a.deptInfo_name='"+name+"'";		//HQL��ѯ���
			Query query = session.createQuery(hql);
			list = (JC_LC_DeptInfo)query.uniqueResult();//����Query����
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
	public void saveBedInfo(JC_LC_BedInfo bedInfo){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(bedInfo);		//�־û�������Ϣ
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
	public void deleteBedInfo(Integer id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			JC_LC_BedInfo message = (JC_LC_BedInfo)session.get(JC_LC_BedInfo.class, id);
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
	public List<JC_LC_BedInfo> findQueryBedInfo(String type, String data){
		Session session = null;					//Session����
		List<JC_LC_BedInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			if(type.equalsIgnoreCase("deptInfo_number")||type.equalsIgnoreCase("deptInfo_name"))
			{
			String hql = "from JC_LC_BedInfo cs where cs.deptInfo."+type+"='"+data+"'";
			list = session.createQuery(hql)		//����Query����
			          .list();
			}//HQL��ѯ���
							//��ȡ�����
			else
			{
				String hql = "from JC_LC_BedInfo cs where cs."+type+"='"+data+"'";
				list = session.createQuery(hql)		//����Query����
				          .list();
			}
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
	public boolean bedValidateNumber(String number){
		Session session = null;					//Session����
		List<JC_LC_DeptInfo> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_LC_BedInfo cs where cs.bed_number='"+number+"'";		//HQL��ѯ���
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
	public JC_LC_BedInfo getBedInfo(Integer id){
		Session session = null;					//Session����
		JC_LC_BedInfo message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (JC_LC_BedInfo)session.get(JC_LC_BedInfo.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	public List<JC_LC_BedInfo> queryByWhereParameterChain(String type, String data){
		//1����ȡSession
		Session session = HibernateUtil.getSession();
		
		List result = null;
		String queryStr = "from JC_LC_BedInfo cs where cs.id>? and cs.name like ?";
		
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
//		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_LC_BedInfo";
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
		String hql = "select count(*) from JC_LC_BedInfo";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}