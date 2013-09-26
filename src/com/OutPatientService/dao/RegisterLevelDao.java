package com.OutPatientService.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_RegisterLevel;

/**
 * 留言信息数据库操作类
 */
public class RegisterLevelDao {
	/**
	 * 保存或修改留言信息
	 * @param mz_registerLevel对象
	 */
	public void saveRegisterLevel(MZ_RegisterLevel mz_registerLevel){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(mz_registerLevel);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 删除留言信息
	 * @param id 留言id
	 */
	public void deleteRegisterLevel(Integer id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的留言信息
			MZ_RegisterLevel RegisterLevel = (MZ_RegisterLevel)session.get(MZ_RegisterLevel.class, id);
			session.delete(RegisterLevel);			//删除留言
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 查询所有信息
	 * @return List集合
	 */
	public PageModel findQueryRegisterLevel(String type, String data){
		Session session = null;					//Session对象
		List<MZ_RegisterLevel> list = null;				//List集合
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = null;
			if(type.equals("all")){
				hql = "from MZ_RegisterLevel";
			}else{
				hql = "from MZ_RegisterLevel cs where cs."+type+"="+data;		//HQL查询语句
			}
			list = session.createQuery(hql)		//创建Query对象
					.setFirstResult(0)	//设置起始位置
  					.setMaxResults(7)	//设置记录数
				          .list();				//获取结果集
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(1);	//设置当前页
			pageModel.setList(list);			//设置结果集
			pageModel.setPageSize(7);	//设置每页记录数
			//设置总记录数
			pageModel.setTotalRecords(getTotalRegisterLevel(session));
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pageModel;
	}
	
	
	public List<MZ_RegisterLevel> queryByWhereParameterChain(String type, String data){
		//1、获取Session
		Session session = HibernateUtil.getSession();
		
		List result = null;
		String queryStr = "from MZ_RegisterLevel cs where cs.id>? and cs.name like ?";
		
		Query query = session.createQuery(queryStr)
			.setString(0, type)
			.setString(1, data);		
		result = query.list();
		
		return result;
	}
	
	
	
	/**
	 * 通过id加载留言信息
	 * @param id 留言id
	 */
	public MZ_RegisterLevel getRegisterLevel(Integer id){
		Session session = null;					//Session对象
		MZ_RegisterLevel message = null;					//对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载JC_YP_DrugManuf
			message = (MZ_RegisterLevel)session.get(MZ_RegisterLevel.class, id);
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return message;
	}

	/**
	 * 查询留言的总记录数
	 * @param session
	 *            Session对象
	 * @return 总记录数
	 */
	public int getTotalRegisterLevel(Session session ) {
	
		// HQL查询语句
		String hql = "select count(*) from MZ_RegisterLevel";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}

	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		//System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按留言时间降序排序
			String hql = "from MZ_RegisterLevel";
			List<MZ_RegisterLevel> list = session.createQuery(hql)		//创建Query对象
		  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
		  					.setMaxResults(pageSize)	//设置记录数
		  					.list();					//返回结果集
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(currPage);	//设置当前页
			pageModel.setList(list);			//设置结果集
			pageModel.setPageSize(pageSize);	//设置每页记录数
			//设置总记录数
			pageModel.setTotalRecords(getTotalRegisterLevel(session));
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pageModel;
	} 

}










