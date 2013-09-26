package com.BasicInfoManagement.dao;
/*
 * dlq
 * 2013.8.9
 * 用户登录维护
 */

import java.util.List;
import org.hibernate.*;
import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;

import org.hibernate.Session;
import org.hibernate.Query;


public class LoginDao {
	
	//保存修改用户信息
	public void saveUser(JC_RY_Login jc_ry_login){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(jc_ry_login);			//持久化login
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	
	public JC_RY_Login getLogin(Integer id){
		Session session = null;					//Session对象
		JC_RY_Login message = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载Message
			message = (JC_RY_Login)session.get(JC_RY_Login.class, id);
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return message;
	}
	
	
	
	

	
	//查询所有用户
	public List<JC_RY_Login> findAllUser(){
		Session session = null;					//Session对象
		List<JC_RY_Login> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_RY_Login";		//HQL查询语句
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
	
	
	
	//删除用户 按id删除
	public void deleteUser(int id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的用户
			JC_RY_Login jc_ry_login = (JC_RY_Login)session.get(JC_RY_Login.class, id);
			session.delete(jc_ry_login);			//删除留言
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}

	/**
	 * 分页查询留言信息
	 * @param currPage	当前页
	 * @param pageSize	每页记录数
	 * @return	PageModel 自定义分页组件
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按留言时间降序排序
			String hql = "from JC_RY_Login";
		//	@SuppressWarnings("unchecked")
			List<JC_RY_Login> list = session.createQuery(hql)		//创建Query对象
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
	//按种类查找
	public List<JC_RY_Login> findLogin(String type, String data){
		Session session = null;					//Session对象
		List<JC_RY_Login> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
			String hql="from JC_RY_Login login where login."+type+"='"+data+"'";
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
	public boolean isUser(String username)
	{		
		Session session = null;					//Session对象
		boolean b=false;			//boolean是否存在
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
			String hql="from JC_RY_Login login where login.login_name="+username;
			Query query = session.createQuery(hql)	;	//创建Query对象
				     		//获取结果集
			Object object=query.uniqueResult();//返回唯一对象
			if(object!=null)
			{
				b=true;//存在
			}
						
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return b;
		
	}
	
	
	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from JC_RY_Login";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
}
