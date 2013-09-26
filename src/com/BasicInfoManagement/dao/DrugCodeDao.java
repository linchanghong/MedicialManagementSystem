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
		Session session = null; // Session对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			session.saveOrUpdate(drugcode); // 持久化drugcode
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
	}

	public boolean findDrugCodeByNumber(String drugcodenumber) {
		Session session = null; // Session对象
		boolean exist = false;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from JC_YP_DrugCode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // 创建Query对象
					.setParameter(0, drugcodenumber);// 动态赋值
			Object codenumber = query.uniqueResult(); // 返回codenumber对象
			// 如果药品编码存在exist为true
			if (codenumber != null) {
				exist = true;
			}
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return exist;
	}

	public void deleteDrugCode(Integer id) {
		Session session = null; // Session对象
		try {
			session = HibernateUtil.getSession(); // 获取Session
			session.beginTransaction(); // 开启事物
			JC_YP_DrugCode drugcode = (JC_YP_DrugCode) session.get(
					JC_YP_DrugCode.class, id);
			session.delete(drugcode); // 删除药品编码
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭session
		}
	}

	public JC_YP_DrugCode getDrugCode(String drugcodenumber) {
		Session session = null; // Session对象
		JC_YP_DrugCode drugcode = null; // JC_YP_DrugCode对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from JC_YP_DrugCode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // 创建Query对象
					.setParameter(0, drugcodenumber);// 动态赋值
			drugcode = (JC_YP_DrugCode) query.uniqueResult(); // 返回codenumber对象
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return drugcode;
	}

	public JC_YP_DrugCode getDrugCodeInfo(Integer id) {
		Session session = null; // Session对象
		JC_YP_DrugCode drugcode = null; // JC_YP_DrugCode对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// 加载Message
			drugcode = (JC_YP_DrugCode) session.get(JC_YP_DrugCode.class, id);
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return drugcode;
	}

	/**
	 * 分页查询留言信息
	 * 
	 * @param currPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return PageModel 自定义分页组件
	 */
	public PageModel findPaging(int currPage, int pageSize) {
		Session session = null; // Session对象
		PageModel pageModel = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_DrugCode";
			List<JC_LC_DeptInfo> list = session.createQuery(hql) // 创建Query对象
					.setFirstResult((currPage - 1) * pageSize) // 设置起始位置
					.setMaxResults(pageSize) // 设置记录数
					.list(); // 返回结果集
			pageModel = new PageModel(); // 实例化pageModel
			pageModel.setCurrPage(currPage); // 设置当前页
			pageModel.setList(list); // 设置结果集
			pageModel.setPageSize(pageSize); // 设置每页记录数
			// 设置总记录数
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return pageModel;
	}

	public PageModel findPagingQuery(int currPage, int pageSize, String type,
			String data) {
		Session session = null; // Session对象
		PageModel pageModel = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_DrugCode code where code." + type + "='"
					+ data + "'";
			List<JC_LC_DeptInfo> list = session.createQuery(hql) // 创建Query对象
					.setFirstResult((currPage - 1) * pageSize) // 设置起始位置
					.setMaxResults(pageSize) // 设置记录数
					.list(); // 返回结果集
			pageModel = new PageModel(); // 实例化pageModel
			pageModel.setCurrPage(currPage); // 设置当前页
			pageModel.setList(list); // 设置结果集
			pageModel.setPageSize(pageSize); // 设置每页记录数
			// 设置总记录数
			pageModel
					.setTotalRecords(getTotalRecordsQuery(session, type, data));
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return pageModel;
	}

	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugCode";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}

	public int getTotalRecordsQuery(Session session, String type, String data) {
		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugCode code where code."
				+ type + "='" + data + "'";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
}
