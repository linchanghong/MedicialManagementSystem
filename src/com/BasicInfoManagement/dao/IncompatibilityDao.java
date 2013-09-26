package com.BasicInfoManagement.dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_YP_Incompatibility;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
//import com.lyq.model.Message;

public class IncompatibilityDao {
	private HttpServletRequest request;
	public IncompatibilityDao()
	{
		request=ServletActionContext.getRequest();
	}
	public void saveIncompatibility(JC_YP_Incompatibility incompate)
	{
		Session session=null;
		try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(incompate);
		session.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally
		{
			HibernateUtil.closeSession();
		}
		
	}
	public void updateIncompate(Integer id,String data,String type)
	{
		Session session = null;					//Session对象
		//boolean exist = false;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "update jc_yp_incompatibility i set i.?=? where i.incompatibility_id=?";
			Query query = session.createQuery(hql)		//创建Query对象
								 .setParameter(0, id);//动态赋值
			Object user = query.uniqueResult();			//返回User对象
			//如果用户存在exist为true
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	public List<JC_YP_Incompatibility> findAllIncompatibility()
	{
		Session session=null;
		List<JC_YP_Incompatibility> list=null;
		try
		{
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="from jc_yp_incompatibility";
			list=session.createQuery(hql).list();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return list;
	}
	public JC_YP_Incompatibility findIncompatibilityById(Integer id)
	{
		Session session=null;
		JC_YP_Incompatibility incompate=null;
//		try{
//			session=HibernateUtil.getSession();
//			session.beginTransaction();
//			System.out.println("dao方法开始执行"+id);
//			String hql="from jc_yp_incompatibility  as i where i.incompatibility_id=?";
//			Query query=session.createQuery(hql).setParameter(0, id);
//			incompate=(JC_YP_Incompatibility)query.uniqueResult();
//			session.getTransaction().commit();
//		}
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载Message
			incompate = (JC_YP_Incompatibility)session.get(JC_YP_Incompatibility.class, id);
			session.getTransaction().commit();
		}
 	//提交事物
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return incompate;
	}
	public void removeIncompatibilityByName(Integer id)
	{
		Session session=null;
		//String[] names=null;
		
		//JC_YP_Incompatibility incompate=null;
		System.out.println("zzzzzzzzzzzzzz进行删除 ");
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的留言信息
			JC_YP_Incompatibility message = (JC_YP_Incompatibility)session.get(JC_YP_Incompatibility.class, id);
			session.delete(message);			//删除留言
			session.getTransaction().commit(); 
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
//		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按留言时间降序排序
			String hql = "from JC_YP_Incompatibility";
			List<JC_YP_Incompatibility> list = session.createQuery(hql)		//创建Query对象
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
		String hql = "select count(*) from JC_YP_Incompatibility";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
	public List<JC_YP_Incompatibility> findIncompatibilityInfo(String type, String data){
		//System.out.println("进入查询");
		Session session = null;					//Session对象
		List<JC_YP_Incompatibility> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_YP_Incompatibility cs where cs."+type+"=?";		//HQL查询语句
			//list = session.createQuery(hql).setParameter(0, type).setParameter(1, data).list();	//获取结果集
			Query query=session.createQuery(hql);
			if(type=="incompatibility_id")
			{
				query.setInteger(0, Integer.valueOf(data));
			}
			else
				query.setString(0, data);
			list=query.list();
			//System.out.println("得到list");
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


