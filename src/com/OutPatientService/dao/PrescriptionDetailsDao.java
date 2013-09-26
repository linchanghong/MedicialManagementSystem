package com.OutPatientService.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_PrescriptionDetails;
import com.OutPatientService.model.MZ_RegisterPatient;


public class PrescriptionDetailsDao {
	
	

	//�����޸�ҩƷ��Ϣ
	public void savePrescriptionDetails(MZ_PrescriptionDetails predetails){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(predetails);			//�־û�login
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	//ͨ��id���ҩƷ��Ϣ
	public MZ_PrescriptionDetails getPrescriptionDetails(Integer id){
		Session session = null;					//Session����
		MZ_PrescriptionDetails message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (MZ_PrescriptionDetails)session.get(MZ_PrescriptionDetails.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	
	//ͨ�������ŵõ�������ϸ��Ϣ
		public List<MZ_PrescriptionDetails> findPrescriptionDetailsByNum(String number){
			Session session = null;					//Session����
			List<MZ_PrescriptionDetails> list = null;					//Message����
			try {
				//��ȡSession
				session = HibernateUtil.getSession();
				session.beginTransaction();			//��������
				//����Message
				list = session.createQuery("from MZ_PrescriptionDetails pd where pd.prescriptionDetails_number=:num")
						.setString("num", number).list();
				session.getTransaction().commit(); 	//�ύ����
			} catch (Exception e) {
				e.printStackTrace();				//��ӡ�쳣��Ϣ
				session.getTransaction().rollback();//�ع�����
			}finally{
				HibernateUtil.closeSession();		//�ر�Session
			}
			return list;
		}
	
	

	

	
	
	
	//ɾ���û� ��idɾ��
	public void deletePrescriptionDetails(int id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id���û�
			MZ_PrescriptionDetails prescription = (MZ_PrescriptionDetails)session.get(MZ_PrescriptionDetails.class, id);
			session.delete(prescription);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}

	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param currPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @return	PageModel �Զ����ҳ���
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		//System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������

			String hql = "from MZ_PrescriptionDetails  ";
		//	@SuppressWarnings("unchecked")
			List<MZ_PrescriptionDetails> list = session.createQuery(hql)		//����Query����
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
	
	public PageModel findpaging(int currPage, int pageSize,String number ){
		Session session = null;					//Session����
		//System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from MZ_PrescriptionDetails where prescriptionDetails_number="+number;
		//	@SuppressWarnings("unchecked")
			List<MZ_RegisterPatient> list = session.createQuery(hql)		//����Query����
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
	//�������Ų���
	public List<MZ_PrescriptionDetails> findDetailsByNumber(String number){
		Session session = null;					//Session����
		List<MZ_PrescriptionDetails> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
			String hql="from MZ_PrescriptionDetails predetails where predetails.prescriptionDetails_number="+number+"";
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
//	public boolean isUser(String username)
//	{		
//		Session session = null;					//Session����
//		boolean b=false;			//boolean�Ƿ����
//		try {
//			//��ȡSession
//			session = HibernateUtil.getSession();
//			session.beginTransaction();			//��������
//		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
//			String hql="from JC_RY_Login login where login.login_name="+username;
//			Query query = session.createQuery(hql)	;	//����Query����
//				     		//��ȡ�����
//			Object object=query.uniqueResult();//����Ψһ����
//			if(object!=null)
//			{
//				b=true;//����
//			}
//						
//			session.getTransaction().commit(); 	//�ύ����
//		} catch (Exception e) {
//			e.printStackTrace();				//��ӡ�쳣��Ϣ
//			session.getTransaction().rollback();//�ع�����
//		}finally{
//			HibernateUtil.closeSession();		//�ر�Session
//		}
//		return b;
//		
//	}
	
	
	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from MZ_PrescriptionDetails";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
	
	
	
	

}
