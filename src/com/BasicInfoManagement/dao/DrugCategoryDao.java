package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;
/*
 * 药品分类维护
 */
public class DrugCategoryDao {
	/*
	 * 保存药品分类
	 */
public void saveDrugCategory(JC_YP_DrugCategory drugCategory){
	Session session=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(drugCategory);
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
}
/*
 * 删除药品分类
 */
public void deleteDrugCategory(int id){
	Session session=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		JC_YP_DrugCategory drugCategory=(JC_YP_DrugCategory)session.get(JC_YP_DrugCategory.class,id);
		session.delete(drugCategory);
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
}
/*
 * 所有药品分类信息
 */
public List<JC_YP_DrugCategory> findAllDrugCategory(){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		String hql="from JC_YP_DrugCategory";
		list=session.createQuery(hql).list();
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
	return list;
}
/*
 * 通过药品分类名称找到药品分类
 */
public List<JC_YP_DrugCategory> findDrugCategoryByName(String name){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		list=session.createQuery("from JC_YP_DrugCategory dc where dc.drugCategory_name like:dcName")
				.setString("dcName", name+"%").list();	//%很重要
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
	return list;
}
/*
 * 通过药品分类id找到药品分类
 */
public List<JC_YP_DrugCategory> findDrugCategoryById(int id){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		//String hql="from JC_YP_DrugCategory dc where dc.drugCategory_name like:dcName";		
		list=session.createQuery("from JC_YP_DrugCategory dc where dc.drugCategory_id =:dcId")
				.setInteger("dcId", id).list();
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
	return list;
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
		String hql = "from Message m order by m.createTime desc";
		List<JC_YP_DrugCategory> list = session.createQuery(hql)		//创建Query对象
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
	String hql = "select count(*) from JC_YP_DrugCategory";
	// 创建Query对象
	Query query = session.createQuery(hql);
	// 单值检索
	Long totalRecords = (Long) query.uniqueResult();
	// 返回总记录数
	return totalRecords.intValue();
}
public List<JC_YP_DrugCategory> findAllCategoryName() {
	Session session = null;
	List<JC_YP_DrugCategory> list = null;
	try {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql = "select drugCategory_name from JC_YP_DrugCategory";
		list = session.createQuery(hql).list();
		session.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
	} finally {
		HibernateUtil.closeSession();
	}
	return list;
}

public JC_YP_DrugCategory getDrugCategory(String name) {
	Session session = null; // Session对象
	JC_YP_DrugCategory drugcategory = null;
	try {
		// 获取Session
		session = HibernateUtil.getSession();
		session.beginTransaction(); // 开启事物
		// HQL查询语句
		String hql = "from JC_YP_DrugCategory drugcate where drugcate.drugCategory_name='"
				+ name + "'";
		Query query = session.createQuery(hql); // 创建Query对象
		drugcategory = (JC_YP_DrugCategory) query.uniqueResult(); // 返回codenumber对象
		session.getTransaction().commit(); // 提交事物
	} catch (Exception e) {
		e.printStackTrace(); // 打印异常信息
		session.getTransaction().rollback();// 回滚事物
	} finally {
		HibernateUtil.closeSession(); // 关闭Session
	}

	return drugcategory;
}

}
