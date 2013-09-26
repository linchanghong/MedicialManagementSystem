/*
 * dlq
 * 2013.8.9
 * �����շ�����
 */

package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.BasicInfoManagement.model.JC_SF_OutpatientRegistration;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;

public class OutpatientRegistrationDao {
	
	//�����޸��շ�������Ϣ
		public void saveRegistration(JC_SF_OutpatientRegistration jc_sf_outpaintientRegistration){
			Session session = null;					//Session����	
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				session.saveOrUpdate(jc_sf_outpaintientRegistration);		//�־û�Payment
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
		}
		
		
//		//���ҩƷ����
//		public JC_SF_OutpatientPayment addPayment(String outpatientPayment_name, String outpatientPayment_number, String outpatientPayment_property,String outpatientPayment_object,String outpatientPayment_remark,String outpatientPayment_zjm){
//			Session session = null;					//Session����
//			JC_SF_OutpatientPayment jc_sf_outpatientPayment = null;			//�û�
//			try {
//				//��ȡSession
//				session = HibernateUtil.getSession();
//				session.beginTransaction();			//��������
//				//HQL��ѯ���
//				String hql = "from jc_sf_outpatientPayment payment where payment.outpatientPayment_name=? and " +
//						"payment.outpatientPayment_number=? and " +"payment.outpatientPayment_property=? and " +
//						"payment.outpatientPayment_object=? and payment.outpatientPayment_remark=? and payment.outpatientPayment_zjm=?";
//				Query query = session.createQuery(hql)		//����Query����
//									.setParameter(0, outpatientPayment_name)//��̬��ֵ
//									.setParameter(1, outpatientPayment_number)
//									.setParameter(2, outpatientPayment_property)
//									.setParameter(3, outpatientPayment_object)
//									.setParameter(4, outpatientPayment_remark)
//									.setParameter(5, outpatientPayment_zjm);    //��̬��ֵ
//				jc_sf_outpatientPayment = (JC_SF_OutpatientPayment)query.uniqueResult();	 //����User����
//				session.getTransaction().commit(); 	//�ύ����
//			} catch (Exception e) {
//				e.printStackTrace();				//��ӡ�쳣��Ϣ
//				session.getTransaction().rollback();//�ع�����
//			}finally{
//				HibernateUtil.closeSession();		//�ر�Session
//			}
//			return jc_sf_outpatientPayment;
//		}
//		
	//ͨ��id���������շ��������Ϣ	
		public JC_SF_OutpatientRegistration getRegistration(Integer id){
			Session session = null;					//Session����
			JC_SF_OutpatientRegistration message = null;					//Message����
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//����Message
				message = (JC_SF_OutpatientRegistration)session.get(JC_SF_OutpatientRegistration.class, id);
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return message;
		}
		
		//���������
		public List<JC_SF_OutpatientRegistration> findRegistration(String type, String data){
			Session session = null;					//Session����
			List<JC_SF_OutpatientRegistration> list = null;				//List����
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
			//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
				String hql="from JC_SF_OutpatientRegistration regist where regist."+type+"='"+data+"'";
				list = session.createQuery(hql)		//����Query����
					          .list();				//��ȡ�����
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return list;
		}
		
		
		
		//ɾ��  ������ɾ��
		public void deleteRegistration(int id){
			Session session = null;					//Session����	
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//����ָ��id���û�
				JC_SF_OutpatientRegistration jc_sf_outpientPayment = (JC_SF_OutpatientRegistration)session.get(JC_SF_OutpatientRegistration.class, id);
				session.delete(jc_sf_outpientPayment);			//ɾ���շ�
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
		}
		
		
		
		//��ѯ���������շ�
			public List<JC_SF_OutpatientRegistration> findAllRegistration(){
					Session session = null;					//Session����
					List<JC_SF_OutpatientRegistration> list = null;				//List����
					try {
						//��ȡSession
						session = HibernateUtil.getSession();
						session.beginTransaction();			//��������
						String hql = "from JC_SF_OutpatientRegistration";		//HQL��ѯ���
						list = session.createQuery(hql)		//����Query����
							          .list();				//��ȡ�����
						session.getTransaction().commit(); 	//�ύ����
					} catch (Exception e) {
						e.printStackTrace();				//��ӡ�쳣��Ϣ
						session.getTransaction().rollback();//�ع�����
					}finally{
						HibernateUtil.closeSession();		//�ر�Session
					}
					return list;
				}
			
			
			/**
			 * ��ҳ��ѯ������Ϣ
			 * @param currPage	��ǰҳ
			 * @param pageSize	ÿҳ��¼��
			 * @return	PageModel �Զ����ҳ���
			 */
			public PageModel findPaging(int currPage, int pageSize){
				Session session = null;					//Session����
			//	System.out.println("11111111111111111111111111");
				PageModel pageModel = null;
				try {
					//��ȡSession
					session = HibernateUtil.getSession();
					session.beginTransaction();			//��������
					//HQL��ѯ��䣬������ʱ�併������
					String hql = "from JC_SF_OutpatientRegistration";
				//	@SuppressWarnings("unchecked")
					List<JC_SF_OutpatientRegistration> list = session.createQuery(hql)		//����Query����
				  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
				  					.setMaxResults(pageSize)	//���ü�¼��
				  					.list();					//���ؽ����
					pageModel = new PageModel();		//ʵ����pageModel
					pageModel.setCurrPage(currPage);	//���õ�ǰҳ
					pageModel.setList(list);			//���ý����
					pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
					//�����ܼ�¼��
					pageModel.setTotalRecords(getTotalRecords(session));
					session.getTransaction().commit(); 	//�ύ����
				} catch (Exception e) {
					e.printStackTrace();				//��ӡ�쳣��Ϣ
					session.getTransaction().rollback();//�ع�����
				}finally{
					HibernateUtil.closeSession();		//�ر�Session
				}
				return pageModel;
			}
			public int getTotalRecords(Session session) {
				// HQL��ѯ���
				String hql = "select count(*) from JC_SF_OutpatientRegistration";
				// ����Query����
				Query query = session.createQuery(hql);
				// ��ֵ����
				Long totalRecords = (Long) query.uniqueResult();
				// �����ܼ�¼��
				return totalRecords.intValue();
			}
			
			
			public boolean isRegistration(String number)
			{		
				Session session = null;					//Session����
				boolean b=false;			//boolean�Ƿ����
				try {
					//��ȡSession
					session = HibernateUtil.getSession();
					session.beginTransaction();			//��������
				//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
					String hql="from JC_SF_OutpatientRegistration regist where regist.outpatientRegistration_number="+number;
					Query query = session.createQuery(hql)	;	//����Query����
						     		//��ȡ�����
					Object object=query.uniqueResult();//����Ψһ����
					if(object!=null)
					{
						b=true;//����
					}
								
					session.getTransaction().commit(); 	//�ύ����
				} catch (Exception e) {
					e.printStackTrace();				//��ӡ�쳣��Ϣ
					session.getTransaction().rollback();//�ع�����
				}finally{
					HibernateUtil.closeSession();		//�ر�Session
				}
				return b;
				
			}

}
