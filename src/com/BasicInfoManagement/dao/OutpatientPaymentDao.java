/*
 * dlq
 * 2013.8.9
 * 门诊收费种类
 */

package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.JC_RY_Login;
import com.BasicInfoManagement.model.JC_SF_OutpatientPayment;
import com.BasicInfoManagement.model.JC_SF_OutpatientRegistration;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

public class OutpatientPaymentDao {
	
	//保存修改收费种类信息
		public void savePayment(JC_SF_OutpatientPayment jc_sf_outpaintientPayment){
			Session session = null;					//Session对象	
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				session.saveOrUpdate(jc_sf_outpaintientPayment);		//持久化Payment
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
		}
		
		
//		//添加药品种类
//		public JC_SF_OutpatientPayment addPayment(String outpatientPayment_name, String outpatientPayment_number, String outpatientPayment_property,String outpatientPayment_object,String outpatientPayment_remark,String outpatientPayment_zjm){
//			Session session = null;					//Session对象
//			JC_SF_OutpatientPayment jc_sf_outpatientPayment = null;			//用户
//			try {
//				//获取Session
//				session = HibernateUtil.getSession();
//				session.beginTransaction();			//开启事物
//				//HQL查询语句
//				String hql = "from jc_sf_outpatientPayment payment where payment.outpatientPayment_name=? and " +
//						"payment.outpatientPayment_number=? and " +"payment.outpatientPayment_property=? and " +
//						"payment.outpatientPayment_object=? and payment.outpatientPayment_remark=? and payment.outpatientPayment_zjm=?";
//				Query query = session.createQuery(hql)		//创建Query对象
//									.setParameter(0, outpatientPayment_name)//动态赋值
//									.setParameter(1, outpatientPayment_number)
//									.setParameter(2, outpatientPayment_property)
//									.setParameter(3, outpatientPayment_object)
//									.setParameter(4, outpatientPayment_remark)
//									.setParameter(5, outpatientPayment_zjm);    //动态赋值
//				jc_sf_outpatientPayment = (JC_SF_OutpatientPayment)query.uniqueResult();	 //返回User对象
//				session.getTransaction().commit(); 	//提交事物
//			} catch (Exception e) {
//				e.printStackTrace();				//打印异常信息
//				session.getTransaction().rollback();//回滚事物
//			}finally{
//				HibernateUtil.closeSession();		//关闭Session
//			}
//			return jc_sf_outpatientPayment;
//		}
//		
	//通过id查找门诊收费种类的信息	
		public JC_SF_OutpatientPayment getPayment(Integer id){
			Session session = null;					//Session对象
			JC_SF_OutpatientPayment message = null;					//Message对象
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//加载Message
				message = (JC_SF_OutpatientPayment)session.get(JC_SF_OutpatientPayment.class, id);
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
			return message;
		}
		
		//按种类查找
		public List<JC_SF_OutpatientPayment> findPayment(String type, String data){
			Session session = null;					//Session对象
			List<JC_SF_OutpatientPayment> list = null;				//List集合
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
			//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
				String hql="from JC_SF_OutpatientPayment payment where payment."+type+"='"+data+"'";
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
		
		
		
		//删除  按主键删除
		public void deletePayment(int id){
			Session session = null;					//Session对象	
			try {
				//获取Session
				session = HibernateUtil.getSession();
				session.beginTransaction();			//开启事物
				//加载指定id的用户
				JC_SF_OutpatientPayment jc_sf_outpientPayment = (JC_SF_OutpatientPayment)session.get(JC_SF_OutpatientPayment.class, id);
				session.delete(jc_sf_outpientPayment);			//删除收费
				session.getTransaction().commit(); 	//提交事物
			} catch (Exception e) {
				e.printStackTrace();				//打印异常信息
				session.getTransaction().rollback();//回滚事物
			}finally{
				HibernateUtil.closeSession();		//关闭Session
			}
		}
		
		
		
		//查询所有门诊收费
			public List<JC_SF_OutpatientPayment> findAllPayment(){
					Session session = null;					//Session对象
					List<JC_SF_OutpatientPayment> list = null;				//List集合
					try {
						//获取Session
						session = HibernateUtil.getSession();
						session.beginTransaction();			//开启事物
						String hql = "from JC_SF_OutpatientPayment";		//HQL查询语句
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
			 * 分页查询留言信息
			 * @param currPage	当前页
			 * @param pageSize	每页记录数
			 * @return	PageModel 自定义分页组件
			 */
			public PageModel findPaging(int currPage, int pageSize){
				Session session = null;					//Session对象
			//	System.out.println("11111111111111111111111111");
				PageModel pageModel = null;
				try {
					//获取Session
					session = HibernateUtil.getSession();
					session.beginTransaction();			//开启事物
					//HQL查询语句，按留言时间降序排序
					String hql = "from JC_SF_OutpatientPayment";
				//	@SuppressWarnings("unchecked")
					List<JC_SF_OutpatientPayment> list = session.createQuery(hql)		//创建Query对象
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
			public int getTotalRecords(Session session) {
				// HQL查询语句
				String hql = "select count(*) from JC_SF_OutpatientPayment";
				// 创建Query对象
				Query query = session.createQuery(hql);
				// 单值检索
				Long totalRecords = (Long) query.uniqueResult();
				// 返回总记录数
				return totalRecords.intValue();
			}
			
			
			public boolean isPayment(String number)
			{		
				Session session = null;					//Session对象
				boolean b=false;			//boolean是否存在
				try {
					//获取Session
					session = HibernateUtil.getSession();
					session.beginTransaction();			//开启事物
				//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL查询语句
					String hql="from JC_SF_OutpatientPayment payment where payment.outpatientPayment_number="+number;
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

}
