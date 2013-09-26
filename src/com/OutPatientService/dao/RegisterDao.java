package com.OutPatientService.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_LC_BedInfo;
import com.BasicInfoManagement.model.JC_LC_DeptInfo;
import com.BasicInfoManagement.model.JC_RY_Login;
import com.BasicInfoManagement.util.HibernateUtil;
import com.OutPatientService.model.MZ_RegisterLevel;
import com.OutPatientService.model.MZ_RegisterMain;
import com.OutPatientService.model.MZ_RegisterPatient;
import com.OutPatientService.model.SequenceGenerate;

public class RegisterDao {
	
	public MZ_RegisterMain getRegisterInfo(Integer id){
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
	public JC_RY_Login findUser(String username, String password){
		Session session = null;					//Session对象
		JC_RY_Login user = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from JC_RY_Login u where u.login_name='"+username+"' and u.login_password='"+password+"'";
			Query query = session.createQuery(hql);		//创建Query对象
						//动态赋值
			user = (JC_RY_Login)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return user;
	}
	//找到患者信息
	public MZ_RegisterPatient findpaitent(String number){
		Session session = null;					//Session对象
		MZ_RegisterPatient paitent = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from MZ_RegisterPatient u where u.regiserPatient_caseNo=?";
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, number);//动态赋值
								//动态赋值
			paitent = (MZ_RegisterPatient)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return paitent;
	}
	
	
	//找到挂号信息
	public MZ_RegisterMain findRegister(String number){
		Session session = null;					//Session对象
		MZ_RegisterMain register = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "from MZ_RegisterMain u where u.registerMain_No=?";
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, number);//动态赋值
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
	//找到所有的挂号级别
	public List<MZ_RegisterLevel> findAllRegisterLevel(){
		Session session = null;					//Session对象
		List<MZ_RegisterLevel> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from MZ_RegisterLevel";		//HQL查询语句
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
	
	public Long findSequenceCode(){
		Session session = null;					//Session对象
		Long code = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//HQL查询语句
			String hql = "select max(sequence_code) from SequenceGenerate";
			Query query = session.createQuery(hql);		//创建Query对象
			code = (Long)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return code;
	}
	
	
	public void saveCode(SequenceGenerate code){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(code);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	
	public void saveRegister(MZ_RegisterMain code){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			session.saveOrUpdate(code);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事物
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事物
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	
	public MZ_RegisterMain findNo(String name){//导入word时使用
		Session session = null;					//Session对象
		MZ_RegisterMain list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from MZ_RegisterMain a where a.registerMain_No='"+name+"'";		//HQL查询语句
			Query query = session.createQuery(hql);
			list = (MZ_RegisterMain)query.uniqueResult();//创建Query对象
				    				//获取结果集
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
