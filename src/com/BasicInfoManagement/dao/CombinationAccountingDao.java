/*
 *组合划价数据处理DAO文件
 *对应数据表组合划价项目(JC_SF_CombinationAccounting)
 *编辑者：林世鹏
 *时间：2013.8.10
 *
*/
package com.BasicInfoManagement.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.PageModel;

import java.util.List;

import com.BasicInfoManagement.model.JC_SF_CombinationAccounting;
import com.BasicInfoManagement.model.JC_SF_PayDetail;
import com.BasicInfoManagement.util.HibernateUtil;
public class CombinationAccountingDao {
	//添加或保存修改收费项目
	public void SavaCAccounting(JC_SF_CombinationAccounting combinationAccounting)
	{
		Session session=null;
		try {
			// 获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction(); // 开启事物
			session.saveOrUpdate(combinationAccounting); // 持久化组合划价信息
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback();// 回滚事物
		} finally {
			HibernateUtil.closeSession(); // 关闭Session
		}

	}
	//根据收费编号来返回对象
	public JC_SF_CombinationAccounting ReturnCAccountingById(String num)
	{
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{
		
			session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_number=?";//创建HQL查询
			Query query=session.createQuery(hql).setParameter(0, num);
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();
			session.beginTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//回滚事务
		}
		finally
		{
			HibernateUtil.closeSession();//关闭session
		}
		return combinationAccounting;//根据指定ID号返回对象
	}
	//添加时判定组合划价编号是否已存在
	public boolean FindCAccountingByNum(String num)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{//获取Session
			session=HibernateUtil.getSession();
			session.beginTransaction();//开启事务
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_number=?";//hql语句
			Query query=session.createQuery(hql).setParameter(0, num);//创建Query查询
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();//返回结果集
			if(combinationAccounting==null)
			{
				exist=true;
			}
				session.beginTransaction().commit();	//提交事务
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//回滚事务
		}
		finally
		{
			HibernateUtil.closeSession();//关闭session
		}
		return exist;//返回bool类型
	}
	
	//添加时判定组合划价名称是否已存在
	public boolean FindCAccountingByName(String name)
	{
		boolean exist=false;
		Session session=null;
		JC_SF_CombinationAccounting combinationAccounting=null;
		try
		{//获取Session
			session=HibernateUtil.getSession();
			session.beginTransaction();//开启事务
			String hql="From JC_SF_CombinationAccounting e where e.combinationAccounting_name=?";//hql语句
			Query query=session.createQuery(hql).setParameter(0, name);//创建Query查询
			combinationAccounting=(JC_SF_CombinationAccounting)query.uniqueResult();//返回结果集
			if(combinationAccounting==null)
			{
				exist=true;
			}
				session.beginTransaction().commit();	//提交事务
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.beginTransaction().rollback();//回滚事务
		}
		finally
		{
			HibernateUtil.closeSession();//关闭session
		}
		return exist;//返回bool类型
	}
	
	public void DeleteCAccountingById(int id)
	{
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的收费详细项目
			JC_SF_CombinationAccounting combinationAccounting = (JC_SF_CombinationAccounting)session.get(JC_SF_CombinationAccounting.class, id);
			session.delete(combinationAccounting);			//删除收费星系项目
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	
	/**
	 * 查询所有组合划价项目详情信息
	 * @return List集合
	 */
	public List<JC_SF_CombinationAccounting> FindAllCAccounting(){
		Session session = null;					//Session对象
		List<JC_SF_CombinationAccounting> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from JC_SF_CombinationAccounting";		//HQL查询语句
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
	/**
	 * 分页查询组合划价详情信息
	 * @param currPage	当前页
	 * @param pageSize	每页记录数
	 * @return	PageModel 自定义分页组件
	 */
	public PageModel FindPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按ID降序排序
			String hql = "from JC_SF_CombinationAccounting m order by m.combinationAccounting_id desc";
			List<JC_SF_CombinationAccounting> list = session.createQuery(hql)		//创建Query对象
		  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
		  					.setMaxResults(pageSize)	//设置记录数
		  					.list();					//返回结果集
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(currPage);	//设置当前页
			pageModel.setList(list);			//设置结果集
			pageModel.setPageSize(pageSize);	//设置每页记录数
			//设置总记录数
			pageModel.setTotalRecords(GetTotalRecords(session));
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
	 * 查询组合划价详情的总记录数
	 * 
	 * @param session
	 *            Session对象
	 * @return 总记录数
	 */
	public int GetTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from JC_SF_CombinationAccounting";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
}
	



