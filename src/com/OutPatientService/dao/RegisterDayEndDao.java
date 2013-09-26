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
		Session session = null;					//Session����
		Double fee=null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "select sum(registerMain_fee) from MZ_RegisterMain a where a.registerMain_status='"+status+"' and a.registerMain_operName='"+oper+"' and a.registerMain_operDate between '"+begin+"' and '"+end+"'";
			Query query = session.createQuery(hql);		//����Query����
			fee = (Double)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		System.out.println("�����"+fee);
		return fee;
	}
	
	//ͳ����������
	public Long countDanShuZC(String begin,String end,String oper,String status){
		Session session = null;					//Session����
		Long fee=null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "select count(*) from MZ_RegisterMain a where a.registerMain_status='"+status+"' and a.registerMain_operName='"+oper+"' and a.registerMain_operDate between '"+begin+"' and '"+end+"'";
			Query query = session.createQuery(hql);		//����Query����
			fee = (Long)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return fee;
	}
	
	public void saveDayEnd(MZ_DayEnd bedInfo){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(bedInfo);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	
	//�ҵ��ս���е�����ֹʱ��
		public Date findMaxDate(String oper){
			Session session = null;					//Session����
			Date date = null;						//�û�
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ���
				String hql = "select max(dayEnd_endDate) from MZ_DayEnd a where a.dayEnd_oper='"+oper+"'";
				Query query = session.createQuery(hql);		//����Query����
				date = (Date)query.uniqueResult();			//����User����
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			
			return date;
		}
		
		public PageModel findPaging(int currPage, int pageSize){
			Session session = null;					//Session����
			PageModel pageModel = null;
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ��䣬������ʱ�併������
				String hql = "from MZ_RegisterMain";
				List<MZ_RegisterMain> list = session.createQuery(hql)		//����Query����
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
		
		public PageModel findAllDayEnd(int currPage, int pageSize){
			Session session = null;					//Session����
			PageModel pageModel = null;
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ��䣬������ʱ�併������
				String hql = "from MZ_DayEnd";
				List<MZ_DayEnd> list = session.createQuery(hql)		//����Query����
			  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
			  					.setMaxResults(pageSize)	//���ü�¼��
			  					.list();					//���ؽ����
				pageModel = new PageModel();		//ʵ����pageModel
				pageModel.setCurrPage(currPage);	//���õ�ǰҳ
				pageModel.setList(list);			//���ý����
				pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
				//�����ܼ�¼��
				pageModel.setTotalRecords(getTotalRecords1(session));
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return pageModel;
		} 
		
		public int getTotalRecords1(Session session) {
			// HQL��ѯ���
			String hql = "select count(*) from MZ_DayEnd";
			// ����Query����
			Query query = session.createQuery(hql);
			// ��ֵ����
			Long totalRecords = (Long) query.uniqueResult();
			// �����ܼ�¼��
			return totalRecords.intValue();
		}
		public int getTotalRecords(Session session) {
			// HQL��ѯ���
			String hql = "select count(*) from MZ_RegisterMain";
			// ����Query����
			Query query = session.createQuery(hql);
			// ��ֵ����
			Long totalRecords = (Long) query.uniqueResult();
			// �����ܼ�¼��
			return totalRecords.intValue();
		}
		
		
		public PageModel findQueryRegister(int currPage, int pageSize,String type){
			Session session = null;					//Session����
			PageModel pageModel = null;
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ��䣬������ʱ�併������
				String hql = "from MZ_RegisterMain cs where cs.registerMain_status='"+type+"'";
				List<MZ_RegisterMain> list = session.createQuery(hql)		//����Query����
			  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
			  					.setMaxResults(pageSize)	//���ü�¼��
			  					.list();					//���ؽ����
				pageModel = new PageModel();		//ʵ����pageModel
				pageModel.setCurrPage(currPage);	//���õ�ǰҳ
				pageModel.setList(list);			//���ý����
				pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
				//�����ܼ�¼��
				pageModel.setTotalRecords(getTotalRecords3(session,type));
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return pageModel;
		} 
		public int getTotalRecords3(Session session,String type) {
			// HQL��ѯ���
			String hql = "select count(*) from MZ_RegisterMain a where a.registerMain_status='"+type+"'";
			// ����Query����
			Query query = session.createQuery(hql);
			// ��ֵ����
			Long totalRecords = (Long) query.uniqueResult();
			// �����ܼ�¼��
			return totalRecords.intValue();
		}
		public PageModel findQueryDayEnd(int currPage, int pageSize,String type){
			Session session = null;					//Session����
			PageModel pageModel = null;
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ��䣬������ʱ�併������
				String hql = "from MZ_DayEnd cs where cs.dayEnd_oper='"+type+"'";
				List<MZ_DayEnd> list = session.createQuery(hql)		//����Query����
			  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
			  					.setMaxResults(pageSize)	//���ü�¼��
			  					.list();					//���ؽ����
				pageModel = new PageModel();		//ʵ����pageModel
				pageModel.setCurrPage(currPage);	//���õ�ǰҳ
				pageModel.setList(list);			//���ý����
				pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
				//�����ܼ�¼��
				pageModel.setTotalRecords(getTotalRecords2(session,type));
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return pageModel;
		} 
		public int getTotalRecords2(Session session,String type) {
			// HQL��ѯ���
			String hql = "select count(*) from MZ_DayEnd a where a.dayEnd_oper='"+type+"'";
			// ����Query����
			Query query = session.createQuery(hql);
			// ��ֵ����
			Long totalRecords = (Long) query.uniqueResult();
			// �����ܼ�¼��
			return totalRecords.intValue();
		}
		
		public MZ_RegisterMain findMZ_RegisterMain(String no)
		{
			Session session = null;					//Session����
			MZ_RegisterMain register = null;						//�û�
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//HQL��ѯ���
				String hql = "from MZ_RegisterMain u where u.registerMain_No='"+no+"'";
				Query query = session.createQuery(hql);		//����Query����
							//��̬��ֵ
				register = (MZ_RegisterMain)query.uniqueResult();			//����User����
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return register;
		}
}
