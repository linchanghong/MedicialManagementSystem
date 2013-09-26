package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;
public class SupplierDao {
/*
 * 添加供应商信息
*/
	public JC_YP_Supplier getSupplier(String name) {
		Session session = null;
		JC_YP_Supplier supplier = null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from JC_YP_Supplier supplier where supplier.supplier_name=?";
			Query query = session.createQuery(hql) // 创建Query对象
					.setParameter(0, name);// 动态赋值
			supplier = (JC_YP_Supplier) query.uniqueResult(); // 返回codenumber对象
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}

		return supplier;
	}

	public void saveSupplier(JC_YP_Supplier sup){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(sup);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/*
	 * 删除供应商信息
	 */
	public void deleteSupplier(int id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的留言信息
			JC_YP_Supplier sup = (JC_YP_Supplier)session.get(JC_YP_Supplier.class, id);
			session.delete(sup);			//删除留言
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/*
	 * 查询所有供应商信息
	 */
	public List<JC_YP_Supplier> findAllSupplier(){
		Session session = null;					//Session对象
		List<JC_YP_Supplier> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_YP_Supplier";		//HQL查询语句，不用表名用类名
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
	/*
	 * 通过供应商类型类型（精确）和供应商名称（模糊）查询供应商信息
	 */
	public List<JC_YP_Supplier> findSupplier(String supName,String supType){
		Session session = null;					//Session对象
		List<JC_YP_Supplier> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			if(supType.equals("none")){
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname ")		//创建Query对象
						.setString("supname", supName+"%")
					          .list();				//获取结果集
			}else if(supName.trim().equals("")){
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_type=:suptype")		//创建Query对象
						.setString("suptype", supType)
					          .list();
			}else{
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype")		//创建Query对象
					.setString("supname", supName+"%")
					.setString("suptype", supType)
				          .list();				//获取结果集
			}
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return list;
	}
	/*
	 * 通过供应商名称（模糊）查询供应商信息
	 */
	public List<JC_YP_Supplier> findSupplierByName(String supName){
		Session session = null;					//Session对象
		List<JC_YP_Supplier> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			//String hql = "from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype";		
			list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname ")		//创建Query对象
					.setString("supname", supName)
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
	/*
	 * 通过供应商名称（模糊）查询供应商信息
	 */
	public List<JC_YP_Supplier> findSupplierById(int id){
		Session session = null;					//Session对象
		List<JC_YP_Supplier> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			//String hql = "from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype";		
			list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_id =:supId ")		//创建Query对象
					.setInteger("supId", id)
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
}
