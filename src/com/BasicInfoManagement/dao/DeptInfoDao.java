package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.BasicInfoManagement.util.*;
import com.BasicInfoManagement.model.*;


public class DeptInfoDao {
	public void saveDeptInfo(JC_LC_DeptInfo deptInfo){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(deptInfo);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	//查询单个科室信息
	/**
	 * 删除留言信息
	 * @param id 留言id
	 */
	public void deleteDeptInfo(Integer id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的留言信息
			JC_LC_DeptInfo message = (JC_LC_DeptInfo)session.get(JC_LC_DeptInfo.class, id);
			session.delete(message);			//删除留言
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 查询所有留言信息
	 * @return List集合
	 */
	public List<JC_LC_DeptInfo> findQueryDeptInfo(String type, String data){
		Session session = null;					//Session对象
		List<JC_LC_DeptInfo> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_LC_DeptInfo cs where cs."+type+"='"+data+"'";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return list;
	}
	
	public List<JC_LC_DeptInfo> findAllDeptInfo(){
		Session session = null;					//Session对象
		List<JC_LC_DeptInfo> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_LC_DeptInfo";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return list;
	}
	//验证用户输入的数据是否已经存在
	public boolean deptNumberValidate(String number){
		Session session = null;					//Session对象
		List<JC_LC_DeptInfo> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_number='"+number+"'";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	
	public boolean deptNameValidate(String number){
		Session session = null;					//Session对象
		List<JC_LC_DeptInfo> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
//			System.out.println("1111111111111111111111111111111"+number);
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_name='"+number+"'";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	
	
	public boolean deptZjmValidate(String number){
		Session session = null;					//Session对象
		List<JC_LC_DeptInfo> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_LC_DeptInfo cs where cs.deptInfo_zjm='"+number+"'";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		if(list.isEmpty())
		{return false;}
		else
			return true;
	}
	/**
	 * 通过id加载留言信息
	 * @param id 留言id
	 * @return Message对象
	 */
	public JC_LC_DeptInfo getDeptInfo(Integer id){
		Session session = null;					//Session对象
		JC_LC_DeptInfo message = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载Message
			message = (JC_LC_DeptInfo)session.get(JC_LC_DeptInfo.class, id);
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return message;
	}
	public List<JC_LC_DeptInfo> queryByWhereParameterChain(String type, String data){
		//1、获取Session
		Session session = HibernateUtil.getSession();
		
		List result = null;
		String queryStr = "from JC_LC_DeptInfo cs where cs.id>? and cs.name like ?";
		
		Query query = session.createQuery(queryStr)
			.setString(0, type)
			.setString(1, data);		
		result = query.list();
		
		return result;
	}
	/**
	 * 分页查询留言信息
	 * @param currPage	当前页
	 * @param pageSize	每页记录数
	 * @return	PageModel 自定义分页组件
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按留言时间降序排序
			String hql = "from JC_LC_DeptInfo";
			List<JC_LC_DeptInfo> list = session.createQuery(hql)		//创建Query对象
		  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
		  					.setMaxResults(pageSize)	//设置记录数
		  					.list();					//返回结果集
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(currPage);	//设置当前页
			pageModel.setList(list);			//设置结果集
			pageModel.setPageSize(pageSize);	//设置每页记录数
			//设置总记录数
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pageModel;
	} 
	/**
	 * 查询留言的总记录数
	 * 
	 * @param session
	 *            Session对象
	 * @return 总记录数
	 */
	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from JC_LC_DeptInfo";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
}
