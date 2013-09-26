package com.OutPatientService.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_Prescription;
import com.OutPatientService.model.MZ_RegisterMain;
import com.OutPatientService.model.MZ_RegisterPatient;

public class PrescriptionDao {
	
	
	//保存修改药品信息
	public void savePrescription(MZ_RegisterMain prescription){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(prescription);			//持久化login
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	public void savePrescription1(MZ_Prescription prescription){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(prescription);			//持久化login
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	//通过id获得药品信息
	public MZ_RegisterMain getPrescription(Integer id){
		Session session = null;					//Session对象
		MZ_RegisterMain message = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载Message
			message = (MZ_RegisterMain)session.get(MZ_RegisterMain.class, id);
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return message;
	}
	
	
	
	

	

	
	
	
	//删除用户 按id删除
	public void deletePrescription(int id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的用户
			MZ_Prescription prescription = (MZ_Prescription)session.get(MZ_Prescription.class, id);
			session.delete(prescription);			//删除留言
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
    /*
     * 通过病例号查找
     */
	public MZ_Prescription findPrescriptionByCaseNo(String caseNo){
		Session session = null;					//Session对象
		MZ_Prescription pres = null;					//Message对象
		List<MZ_Prescription> list;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载Message
			list = session.createQuery("from MZ_Prescription p where p.prescription_casenumber =:caseNo")
					.setString("caseNo", caseNo)
					.list();
			if(!list.isEmpty()){
				pres=list.get(0);
			}
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pres;
	}
	/**
	 * 分页查询留言信息
	 * @param currPage	当前页
	 * @param pageSize	每页记录数
	 * @return	PageModel 自定义分页组件
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		//System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句，按留言时间降序排序
			String hql = "from MZ_RegisterMain";
		//	@SuppressWarnings("unchecked")
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
			//System.out.print(list.size());
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pageModel;
	}
	public MZ_Prescription findPre(String number){
		Session session = null;					//Session对象
		MZ_Prescription pre = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from MZ_Prescription u where u.prescription_number='"+number+"' ";
			Query query = session.createQuery(hql);		//创建Query对象
						//动态赋值
			pre = (MZ_Prescription)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pre;
	}
	
	//按种类查找
//	public List<MZ_Prescription> findLogin(String type, String data){
//		Session session = null;					//Session对象
//		List<MZ_Prescription> list = null;				//List集合
//		try {
//			//获取Session
//			session = HibernateUtil.getSession();
//			session.beginTransaction();			//开启事物
//		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
//			String hql="from MZ_Prescription prescription where prescription."+type+"='"+data+"'";
//			list = session.createQuery(hql)		//创建Query对象
//				          .list();				//获取结果集
//			session.getTransaction().commit(); 	//提交事物
//		} catch (Exception e) {
//			e.printStackTrace();				//打印异常信息
//			session.getTransaction().rollback();//回滚事物
//		}finally{
//			HibernateUtil.closeSession();		//关闭Session
//		}
//		return list;
//	}
	
//	public boolean isUser(String username)
//	{		
//		Session session = null;					//Session对象
//		boolean b=false;			//boolean是否存在
//		try {
//			//获取Session
//			session = HibernateUtil.getSession();
//			session.beginTransaction();			//开启事物
//		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
//			String hql="from JC_RY_Login login where login.login_name="+username;
//			Query query = session.createQuery(hql)	;	//创建Query对象
//				     		//获取结果集
//			Object object=query.uniqueResult();//返回唯一对象
//			if(object!=null)
//			{
//				b=true;//存在
//			}
//						
//			session.getTransaction().commit(); 	//提交事物
//		} catch (Exception e) {
//			e.printStackTrace();				//打印异常信息
//			session.getTransaction().rollback();//回滚事物
//		}finally{
//			HibernateUtil.closeSession();		//关闭Session
//		}
//		return b;
//		
//	}
	
	
	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from MZ_Prescription";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
	
	

}
