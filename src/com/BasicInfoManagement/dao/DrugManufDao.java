package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_YP_DrugManuf;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

/**
 * ������Ϣ���ݿ������
 */
public class DrugManufDao {
	/**
	 * ������޸�������Ϣ
	 * 
	 * @param jc_yp_drugManuf����
	 */
	public void saveDrugManuf(JC_YP_DrugManuf yp_drugManuf) {
		Session session = null; // Session����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			session.saveOrUpdate(yp_drugManuf); // �־û�������Ϣ
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param id
	 *            ����id
	 */
	public void deleteDrugManuf(Integer id) {
		Session session = null; // Session����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// ����ָ��id��������Ϣ
			JC_YP_DrugManuf drugManuf = (JC_YP_DrugManuf) session.get(
					JC_YP_DrugManuf.class, id);
			session.delete(drugManuf); // ɾ������
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
	}

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return List����
	 */
	public List<JC_YP_DrugManuf> findQueryDrugManuf(String type, String data) {
		Session session = null; // Session����
		List<JC_YP_DrugManuf> list = null; // List����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			String hql = "from JC_YP_DrugManuf cs where cs." + type + "="
					+ data; // HQL��ѯ���
			list = session.createQuery(hql) // ����Query����
					.list(); // ��ȡ�����
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return list;
	}

	public List<JC_YP_DrugManuf> queryByWhereParameterChain(String type,
			String data) {
		// 1����ȡSession
		Session session = HibernateUtil.getSession();

		List result = null;
		String queryStr = "from JC_YP_DrugManuf cs where cs.id>? and cs.name like ?";

		Query query = session.createQuery(queryStr).setString(0, type)
				.setString(1, data);
		result = query.list();

		return result;
	}

	/**
	 * ͨ��id����������Ϣ
	 * 
	 * @param id
	 *            ����id
	 */
	public JC_YP_DrugManuf getDrugManuf(Integer id) {
		Session session = null; // Session����
		JC_YP_DrugManuf message = null; // ����
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// ����JC_YP_DrugManuf
			message = (JC_YP_DrugManuf) session.get(JC_YP_DrugManuf.class, id);
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return message;
	}

	/**
	 * ��ѯ���Ե��ܼ�¼��
	 * 
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int getTotalDrugManuf(Session session) {

		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugManuf";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}

	public PageModel findPaging(int currPage, int pageSize) {
		Session session = null; // Session����
		// System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_DrugManuf";
			List<JC_YP_DrugManuf> list = session.createQuery(hql) // ����Query����
					.setFirstResult((currPage - 1) * pageSize) // ������ʼλ��
					.setMaxResults(pageSize) // ���ü�¼��
					.list(); // ���ؽ����
			pageModel = new PageModel(); // ʵ����pageModel
			pageModel.setCurrPage(currPage); // ���õ�ǰҳ
			pageModel.setList(list); // ���ý����
			pageModel.setPageSize(pageSize); // ����ÿҳ��¼��
			// �����ܼ�¼��
			pageModel.setTotalRecords(getTotalDrugManuf(session));
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return pageModel;
	}

	public int getTotalDrugManufQuery(Session session, String type, String data) {

		// HQL��ѯ���
		String hql = "select count(*) from JC_YP_DrugManuf f where f." + type
				+ "='" + data + "'";
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
		// System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ��䣬������ʱ�併������
			String hql = "from JC_YP_DrugManuf f where f." + type + "='" + data
					+ "'";
			List<JC_YP_DrugManuf> list = session.createQuery(hql) // ����Query����
					.setFirstResult((currPage - 1) * pageSize) // ������ʼλ��
					.setMaxResults(pageSize) // ���ü�¼��
					.list(); // ���ؽ����
			pageModel = new PageModel(); // ʵ����pageModel
			pageModel.setCurrPage(currPage); // ���õ�ǰҳ
			pageModel.setList(list); // ���ý����
			pageModel.setPageSize(pageSize); // ����ÿҳ��¼��
			// �����ܼ�¼��
			pageModel.setTotalRecords(getTotalDrugManufQuery(session, type,
					data));
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}
		return pageModel;
	}

	public JC_YP_DrugManuf getdrugManuf(String name) {
		Session session = null;
		JC_YP_DrugManuf drugManuf = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ���
			String hql = "from JC_YP_DrugManuf drugManuf where drugManuf.drugManuf_name=?";
			Query query = session.createQuery(hql) // ����Query����
					.setParameter(0, name);// ��̬��ֵ
			drugManuf = (JC_YP_DrugManuf) query.uniqueResult(); // ����codenumber����
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}

		return drugManuf;
	}

}
