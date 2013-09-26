package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_YP_DrugCode;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

public class DrugCodeDao {
	public void saveDrugCode(JC_YP_DrugCode drugcode) {
		Session session = null; // Session����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			session.saveOrUpdate(drugcode); // �־û�drugcode
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
	}

	public boolean findDrugCodeByNumber(String drugcodenumber) {
		Session session = null; // Session����
		boolean exist = false;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ���
			String hql = "from JC_YP_DrugCode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // ����Query����
					.setParameter(0, drugcodenumber);// ��̬��ֵ
			Object codenumber = query.uniqueResult(); // ����codenumber����
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

	public void deleteDrugCode(Integer id) {
		Session session = null; // Session����
		try {
			session = HibernateUtil.getSession(); // ��ȡSession
			session.beginTransaction(); // ��������
			JC_YP_DrugCode drugcode = (JC_YP_DrugCode) session.get(
					JC_YP_DrugCode.class, id);
			session.delete(drugcode); // ɾ��ҩƷ����
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�session
		}
	}

	public JC_YP_DrugCode getDrugCode(String drugcodenumber) {
		Session session = null; // Session����
		JC_YP_DrugCode drugcode = null; // JC_YP_DrugCode����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ���
			String hql = "from JC_YP_DrugCode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // ����Query����
					.setParameter(0, drugcodenumber);// ��̬��ֵ
			drugcode = (JC_YP_DrugCode) query.uniqueResult(); // ����codenumber����
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return drugcode;
	}

	public JC_YP_DrugCode getDrugCodeInfo(Integer id) {
		Session session = null; // Session����
		JC_YP_DrugCode drugcode = null; // JC_YP_DrugCode����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// ����Message
			drugcode = (JC_YP_DrugCode) session.get(JC_YP_DrugCode.class, id);
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return drugcode;
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
			String hql = "from JC_YP_DrugCode";
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

	public PageModel findPagingQuery(int currPage, int pageSize, String type,
			String data) {
		Session session = null; // Session����
		PageModel pageModel = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_DrugCode code where code." + type + "='"
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

	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugCode";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}

	public int getTotalRecordsQuery(Session session, String type, String data) {
		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugCode code where code."
				+ type + "='" + data + "'";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}
