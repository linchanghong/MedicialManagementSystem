package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_YP_DrugInfo;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_RegisterPatient;

public class DrugInfoDao {
	public void saveDrugInfo(JC_YP_DrugInfo druginfo) {
		Session session = null; // Session����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			session.saveOrUpdate(druginfo); // �־û�druginfo
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
	}

	public boolean findDrugInfoByNumber(String druginfonumber) {
		Session session = null; // Session����
		boolean exist = false;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ���
			String hql = "from jc_yp_drugcode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // ����Query����
					.setParameter(0, druginfonumber);// ��̬��ֵ
			Object codenumber = query.uniqueResult(); // ����druginfonumber����
			// ���ҩƷ�������existΪtrue
			if (codenumber != null) {
				exist = true;
			}
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return exist;
	}
	

	/**
	 * ��ҳ��ѯ������Ϣ
	 * 
	 * @param currPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @return PageModel �Զ����ҳ���
	 */
	public PageModel findPaging(int currPage, int pageSize) {
		Session session = null; // Session����
		PageModel pageModel = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_DrugInfo";
			List<JC_LC_DeptInfo> list = session.createQuery(hql) // ����Query����
					.setFirstResult((currPage - 1) * pageSize) // ������ʼλ��
					.setMaxResults(pageSize) // ���ü�¼��
					.list(); // ���ؽ����
			pageModel = new PageModel(); // ʵ����pageModel
			pageModel.setCurrPage(currPage); // ���õ�ǰҳ
			pageModel.setList(list); // ���ý����
			pageModel.setPageSize(pageSize); // ����ÿҳ��¼��
			// �����ܼ�¼��
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return pageModel;
	}

	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugInfo";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}

	public PageModel findPagingQuery(int currPage, int pageSize, String type,
			String data) {
		Session session = null; // Session����
		PageModel pageModel = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_DrugInfo Info where Info." + type + "='"
					+ data + "'";
			List<JC_LC_DeptInfo> list = session.createQuery(hql) // ����Query����
					.setFirstResult((currPage - 1) * pageSize) // ������ʼλ��
					.setMaxResults(pageSize) // ���ü�¼��
					.list(); // ���ؽ����
			pageModel = new PageModel(); // ʵ����pageModel
			pageModel.setCurrPage(currPage); // ���õ�ǰҳ
			pageModel.setList(list); // ���ý����
			pageModel.setPageSize(pageSize); // ����ÿҳ��¼��
			// �����ܼ�¼��
			pageModel
					.setTotalRecords(getTotalRecordsQuery(session, type, data));
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return pageModel;
	}

	public int getTotalRecordsQuery(Session session, String type, String data) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugInfo info where info."
				+ type + "='" + data + "'";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}

	public void deleteDrugInfo(Integer id) {
		Session session = null; // Session����
		try {
			session = HibernateUtil.getSession(); // ��ȡSession
			session.beginTransaction(); // ��������
			JC_YP_DrugInfo druginfo = (JC_YP_DrugInfo) session.get(
					JC_YP_DrugInfo.class, id);
			session.delete(druginfo); // ɾ��ҩƷ
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�session
		}
	}

	public JC_YP_DrugInfo getDrugInfo(Integer id) {
		Session session = null; // Session����
		JC_YP_DrugInfo druginfo = null; // JC_YP_DrugCode����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// ����Message
			druginfo = (JC_YP_DrugInfo) session.get(JC_YP_DrugInfo.class, id);
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return druginfo;
	}
	
	
	//ͨ��ҩƷ����ѯҩƷ��Ϣ--dlq--
	public JC_YP_DrugInfo findDrugInfoByName(String druginfoname) {
		Session session = null;					//Session����
		JC_YP_DrugInfo druginfo = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from JC_YP_DrugInfo u where u.drugInfo_name='"+druginfoname+"'";
			Query query = session.createQuery(hql);		//����Query����
								//��̬��ֵ
								//��̬��ֵ
			druginfo = (JC_YP_DrugInfo)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return druginfo;
	}
	
	
}
