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
		Session session = null; // Session对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			session.saveOrUpdate(druginfo); // 持久化druginfo
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
	}

	public boolean findDrugInfoByNumber(String druginfonumber) {
		Session session = null; // Session对象
		boolean exist = false;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from jc_yp_drugcode drugcode where drugcode.drugCode_number=?";
			Query query = session.createQuery(hql) // 创建Query对象
					.setParameter(0, druginfonumber);// 动态赋值
			Object codenumber = query.uniqueResult(); // 返回druginfonumber对象
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
			String hql = "from JC_YP_DrugInfo";
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

	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugInfo";
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
		PageModel pageModel = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_DrugInfo Info where Info." + type + "='"
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

	public int getTotalRecordsQuery(Session session, String type, String data) {
		// HQL查询语句
		String hql = "select count(*) from JC_YP_DrugInfo info where info."
				+ type + "='" + data + "'";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}

	public void deleteDrugInfo(Integer id) {
		Session session = null; // Session对象
		try {
			session = HibernateUtil.getSession(); // 获取Session
			session.beginTransaction(); // 开启事物
			JC_YP_DrugInfo druginfo = (JC_YP_DrugInfo) session.get(
					JC_YP_DrugInfo.class, id);
			session.delete(druginfo); // 删除药品
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭session
		}
	}

	public JC_YP_DrugInfo getDrugInfo(Integer id) {
		Session session = null; // Session对象
		JC_YP_DrugInfo druginfo = null; // JC_YP_DrugCode对象
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// 加载Message
			druginfo = (JC_YP_DrugInfo) session.get(JC_YP_DrugInfo.class, id);
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}
		return druginfo;
	}
	
	
	//通过药品名查询药品信息--dlq--
	public JC_YP_DrugInfo findDrugInfoByName(String druginfoname) {
		Session session = null;					//Session对象
		JC_YP_DrugInfo druginfo = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from JC_YP_DrugInfo u where u.drugInfo_name='"+druginfoname+"'";
			Query query = session.createQuery(hql);		//创建Query对象
								//动态赋值
								//动态赋值
			druginfo = (JC_YP_DrugInfo)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return druginfo;
	}
	
	
}
