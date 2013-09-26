package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_YP_DrugManuf;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

/**
 * 留言信息数据库操作类
 */
public class DrugManufDao {
	/**
	 * 保存或修改留言信息
	 * 
	 * @param jc_yp_drugManuf对象
	 */
	public void saveDrugManuf(JC_YP_DrugManuf yp_drugManuf) {
		Session session = null; // Session对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			session.saveOrUpdate(yp_drugManuf); // 持久化留言信息
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
	}

	/**
	 * 删除留言信息
	 * 
	 * @param id
	 *            留言id
	 */
	public void deleteDrugManuf(Integer id) {
		Session session = null; // Session对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// 加载指定id的留言信息
			JC_YP_DrugManuf drugManuf = (JC_YP_DrugManuf) session.get(
					JC_YP_DrugManuf.class, id);
			session.delete(drugManuf); // 删除留言
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
	}

	/**
	 * 查询所有信息
	 * 
	 * @return List集合
	 */
	public List<JC_YP_DrugManuf> findQueryDrugManuf(String type, String data) {
		Session session = null; // Session对象
		List<JC_YP_DrugManuf> list = null; // List集合
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			String hql = "from JC_YP_DrugManuf cs where cs." + type + "="
					+ data; // HQL查询语句
			list = session.createQuery(hql) // 创建Query对象
					.list(); // 获取结果集
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return list;
	}

	public List<JC_YP_DrugManuf> queryByWhereParameterChain(String type,
			String data) {
		// 1、获取Session
		Session session = HibernateUtil.getSession();

		List result = null;
		String queryStr = "from JC_YP_DrugManuf cs where cs.id>? and cs.name like ?";

		Query query = session.createQuery(queryStr).setString(0, type)
				.setString(1, data);
		result = query.list();

		return result;
	}

	/**
	 * 通过id加载留言信息
	 * 
	 * @param id
	 *            留言id
	 */
	public JC_YP_DrugManuf getDrugManuf(Integer id) {
		Session session = null; // Session对象
		JC_YP_DrugManuf message = null; // 对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// 加载JC_YP_DrugManuf
			message = (JC_YP_DrugManuf) session.get(JC_YP_DrugManuf.class, id);
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return message;
	}

	/**
	 * 查询留言的总记录数
	 * 
	 * @param session
	 *            Session对象
	 * @return 总记录数
	 */
	public int getTotalDrugManuf(Session session) {

		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugManuf";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}

	public PageModel findPaging(int currPage, int pageSize) {
		Session session = null; // Session对象
		// System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_DrugManuf";
			List<JC_YP_DrugManuf> list = session.createQuery(hql) // 创建Query对象
					.setFirstResult((currPage - 1) * pageSize) // 设置起始位置
					.setMaxResults(pageSize) // 设置记录数
					.list(); // 返回结果集
			pageModel = new PageModel(); // 实例化pageModel
			pageModel.setCurrPage(currPage); // 设置当前页
			pageModel.setList(list); // 设置结果集
			pageModel.setPageSize(pageSize); // 设置每页记录数
			// 设置总记录数
			pageModel.setTotalRecords(getTotalDrugManuf(session));
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return pageModel;
	}

	public int getTotalDrugManufQuery(Session session, String type, String data) {

		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugManuf f where f." + type
				+ "='" + data + "'";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}

	public PageModel findPagingQuery(int currPage, int pageSize, String type,
			String data) {
		Session session = null; // Session对象
		// System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_DrugManuf f where f." + type + "='" + data
					+ "'";
			List<JC_YP_DrugManuf> list = session.createQuery(hql) // 创建Query对象
					.setFirstResult((currPage - 1) * pageSize) // 设置起始位置
					.setMaxResults(pageSize) // 设置记录数
					.list(); // 返回结果集
			pageModel = new PageModel(); // 实例化pageModel
			pageModel.setCurrPage(currPage); // 设置当前页
			pageModel.setList(list); // 设置结果集
			pageModel.setPageSize(pageSize); // 设置每页记录数
			// 设置总记录数
			pageModel.setTotalRecords(getTotalDrugManufQuery(session, type,
					data));
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return pageModel;
	}

	public JC_YP_DrugManuf getdrugManuf(String name) {
		Session session = null;
		JC_YP_DrugManuf drugManuf = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from JC_YP_DrugManuf drugManuf where drugManuf.drugManuf_name=?";
			Query query = session.createQuery(hql) // 创建Query对象
					.setParameter(0, name);// 动态赋值
			drugManuf = (JC_YP_DrugManuf) query.uniqueResult(); // 返回codenumber对象
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}

		return drugManuf;
	}

}
