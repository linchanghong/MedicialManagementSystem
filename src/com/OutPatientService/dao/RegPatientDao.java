package com.OutPatientService.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//import com.BasicInfoManagement.model.JC_YP_CipherPres;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_RegisterPatient;

public class RegPatientDao {
	private List<String> datelist;
	
	
	public List<String> getDatelist() {
		return datelist;
	}
	public void setDatelist(List<String> datelist) {
		this.datelist = datelist;
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
			String hql = "from MZ_RegisterPatient";
			List<MZ_RegisterPatient> list = session.createQuery(hql)		//创建Query对象
		  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
		  					.setMaxResults(pageSize)	//设置记录数
		  					.list();					//返回结果集
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(currPage);//设置当前页
			List<String> ls=new ArrayList<String>();
			//增加
 			for(int i=0;i<list.size();i++)
			{
				Date date=list.get(i).getRegiserPatient_birthday();
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
 			    String s=df.format(date).substring(0, 9);
 			    //datelist.add(s);
 			    ls.add(s);
 			    
 			    
			}//增加
 			setDatelist(ls);
 			
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
	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from MZ_RegisterPatient";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
	public void saveRegPatient(MZ_RegisterPatient regPatient)
	{
		Session session=null;
		try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(regPatient);
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
	public void removeRegPatient(int id)
	{
		Session session=null;
		//String[] names=null;
		
		//JC_YP_Incompatibility incompate=null;
		System.out.println("zzzzzzzzzzzzzz进行删除 "+id);
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			//加载指定id的留言信息
			MZ_RegisterPatient message = (MZ_RegisterPatient)session.get(MZ_RegisterPatient.class, id);
			if(message!=null)
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
	public List<MZ_RegisterPatient> findRegPatientInfo(String type, String data){
		//System.out.println("进入查询");
		Session session = null;					//Session对象
		List<MZ_RegisterPatient> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事物
			String hql = "from MZ_RegisterPatient cs where cs."+type+"=?";		//HQL查询语句
			//list = session.createQuery(hql).setParameter(0, type).setParameter(1, data).list();	//获取结果集
			Query query=session.createQuery(hql);
			if(type=="regiserPatient_id")
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
