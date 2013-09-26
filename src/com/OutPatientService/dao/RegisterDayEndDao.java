package com.OutPatientService.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_BedInfo;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_DoctorInfo;
import com.BasicInfoManagement.model.JC_RY_Login;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_DayEnd;
import com.OutPatientService.model.MZ_RegisterMain;
import com.BasicInfoManagement.util.PageModel;

public class RegisterDayEndDao {

	
	public Double countFee(String begin,String end,String oper,String status){
		Session session = null;					//Session对象
		Double fee=null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "select sum(registerMain_fee) from MZ_RegisterMain a where a.registerMain_status='"+status+"' and a.registerMain_operName='"+oper+"' and a.registerMain_operDate between '"+begin+"' and '"+end+"'";
			Query query = session.createQuery(hql);		//创建Query对象
			fee = (Double)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		System.out.println("王义彬"+fee);
		return fee;
	}
	
	//统计正常单数
	public Long countDanShuZC(String begin,String end,String oper,String status){
		Session session = null;					//Session对象
		Long fee=null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "select count(*) from MZ_RegisterMain a where a.registerMain_status='"+status+"' and a.registerMain_operName='"+oper+"' and a.registerMain_operDate between '"+begin+"' and '"+end+"'";
			Query query = session.createQuery(hql);		//创建Query对象
			fee = (Long)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return fee;
	}
	
	public void saveDayEnd(MZ_DayEnd bedInfo){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(bedInfo);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	
	//找到日结表中的最大截止时间
		public Date findMaxDate(String oper){
			Session session = null;					//Session对象
			Date date = null;						//用户
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句
				String hql = "select max(dayEnd_endDate) from MZ_DayEnd a where a.dayEnd_oper='"+oper+"'";
				Query query = session.createQuery(hql);		//创建Query对象
				date = (Date)query.uniqueResult();			//返回User对象
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			
			return date;
		}
		
		public PageModel findPaging(int currPage, int pageSize){
			Session session = null;					//Session对象
			PageModel pageModel = null;
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句，按留言时间降序排序
				String hql = "from MZ_RegisterMain";
				List<MZ_RegisterMain> list = session.createQuery(hql)		//创建Query对象
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
		
		public PageModel findAllDayEnd(int currPage, int pageSize){
			Session session = null;					//Session对象
			PageModel pageModel = null;
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句，按留言时间降序排序
				String hql = "from MZ_DayEnd";
				List<MZ_DayEnd> list = session.createQuery(hql)		//创建Query对象
			  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
			  					.setMaxResults(pageSize)	//设置记录数
			  					.list();					//返回结果集
				pageModel = new PageModel();		//实例化pageModel
				pageModel.setCurrPage(currPage);	//设置当前页
				pageModel.setList(list);			//设置结果集
				pageModel.setPageSize(pageSize);	//设置每页记录数
				//设置总记录数
				pageModel.setTotalRecords(getTotalRecords1(session));
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			return pageModel;
		} 
		
		public int getTotalRecords1(Session session) {
			// HQL查询语句
			String hql = "select count(*) from MZ_DayEnd";
			// 创建Query对象
			Query query = session.createQuery(hql);
			// 单值检索
			Long totalRecords = (Long) query.uniqueResult();
			// 返回总记录数
			return totalRecords.intValue();
		}
		public int getTotalRecords(Session session) {
			// HQL查询语句
			String hql = "select count(*) from MZ_RegisterMain";
			// 创建Query对象
			Query query = session.createQuery(hql);
			// 单值检索
			Long totalRecords = (Long) query.uniqueResult();
			// 返回总记录数
			return totalRecords.intValue();
		}
		
		
		public PageModel findQueryRegister(int currPage, int pageSize,String type){
			Session session = null;					//Session对象
			PageModel pageModel = null;
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句，按留言时间降序排序
				String hql = "from MZ_RegisterMain cs where cs.registerMain_status='"+type+"'";
				List<MZ_RegisterMain> list = session.createQuery(hql)		//创建Query对象
			  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
			  					.setMaxResults(pageSize)	//设置记录数
			  					.list();					//返回结果集
				pageModel = new PageModel();		//实例化pageModel
				pageModel.setCurrPage(currPage);	//设置当前页
				pageModel.setList(list);			//设置结果集
				pageModel.setPageSize(pageSize);	//设置每页记录数
				//设置总记录数
				pageModel.setTotalRecords(getTotalRecords3(session,type));
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			return pageModel;
		} 
		public int getTotalRecords3(Session session,String type) {
			// HQL查询语句
			String hql = "select count(*) from MZ_RegisterMain a where a.registerMain_status='"+type+"'";
			// 创建Query对象
			Query query = session.createQuery(hql);
			// 单值检索
			Long totalRecords = (Long) query.uniqueResult();
			// 返回总记录数
			return totalRecords.intValue();
		}
		public PageModel findQueryDayEnd(int currPage, int pageSize,String type){
			Session session = null;					//Session对象
			PageModel pageModel = null;
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句，按留言时间降序排序
				String hql = "from MZ_DayEnd cs where cs.dayEnd_oper='"+type+"'";
				List<MZ_DayEnd> list = session.createQuery(hql)		//创建Query对象
			  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
			  					.setMaxResults(pageSize)	//设置记录数
			  					.list();					//返回结果集
				pageModel = new PageModel();		//实例化pageModel
				pageModel.setCurrPage(currPage);	//设置当前页
				pageModel.setList(list);			//设置结果集
				pageModel.setPageSize(pageSize);	//设置每页记录数
				//设置总记录数
				pageModel.setTotalRecords(getTotalRecords2(session,type));
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			return pageModel;
		} 
		public int getTotalRecords2(Session session,String type) {
			// HQL查询语句
			String hql = "select count(*) from MZ_DayEnd a where a.dayEnd_oper='"+type+"'";
			// 创建Query对象
			Query query = session.createQuery(hql);
			// 单值检索
			Long totalRecords = (Long) query.uniqueResult();
			// 返回总记录数
			return totalRecords.intValue();
		}
		
		public MZ_RegisterMain findMZ_RegisterMain(String no)
		{
			Session session = null;					//Session对象
			MZ_RegisterMain register = null;						//用户
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//HQL查询语句
				String hql = "from MZ_RegisterMain u where u.registerMain_No='"+no+"'";
				Query query = session.createQuery(hql);		//创建Query对象
							//动态赋值
				register = (MZ_RegisterMain)query.uniqueResult();			//返回User对象
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			return register;
		}
}
