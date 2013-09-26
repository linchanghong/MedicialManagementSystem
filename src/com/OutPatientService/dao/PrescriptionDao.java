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
	
	
	//�����޸�ҩƷ��Ϣ
	public void savePrescription(MZ_RegisterMain prescription){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(prescription);			//�־û�login
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	public void savePrescription1(MZ_Prescription prescription){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(prescription);			//�־û�login
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	//ͨ��id���ҩƷ��Ϣ
	public MZ_RegisterMain getPrescription(Integer id){
		Session session = null;					//Session����
		MZ_RegisterMain message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (MZ_RegisterMain)session.get(MZ_RegisterMain.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	
	
	
	

	

	
	
	
	//ɾ���û� ��idɾ��
	public void deletePrescription(int id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id���û�
			MZ_Prescription prescription = (MZ_Prescription)session.get(MZ_Prescription.class, id);
			session.delete(prescription);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
    /*
     * ͨ�������Ų���
     */
	public MZ_Prescription findPrescriptionByCaseNo(String caseNo){
		Session session = null;					//Session����
		MZ_Prescription pres = null;					//Message����
		List<MZ_Prescription> list;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			list = session.createQuery("from MZ_Prescription p where p.prescription_casenumber =:caseNo")
					.setString("caseNo", caseNo)
					.list();
			if(!list.isEmpty()){
				pres=list.get(0);
			}
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pres;
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
			String hql = "from MZ_RegisterMain";
		//	@SuppressWarnings("unchecked")
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
			//System.out.print(list.size());
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pageModel;
	}
	public MZ_Prescription findPre(String number){
		Session session = null;					//Session����
		MZ_Prescription pre = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from MZ_Prescription u where u.prescription_number='"+number+"' ";
			Query query = session.createQuery(hql);		//����Query����
						//��̬��ֵ
			pre = (MZ_Prescription)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pre;
	}
	
	//���������
//	public List<MZ_Prescription> findLogin(String type, String data){
//		Session session = null;					//Session����
//		List<MZ_Prescription> list = null;				//List����
//		try {
//			//��ȡSession
//			session = HibernateUtil.getSession();
//			session.beginTransaction();			//��������
//		//	String hql = "from JC_RY_Login login where login."+type+"="+data;		//HQL��ѯ���
//			String hql="from MZ_Prescription prescription where prescription."+type+"='"+data+"'";
//			list = session.createQuery(hql)		//����Query����
//				          .list();				//��ȡ�����
//			session.getTransaction().commit(); 	//�ύ����
//		} catch (Exception e) {
//			e.printStackTrace();				//��ӡ�쳣��Ϣ
//			session.getTransaction().rollback();//�ع�����
//		}finally{
//			HibernateUtil.closeSession();		//�ر�Session
//		}
//		return list;
//	}
	
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
		String hql = "select count(*) from MZ_Prescription";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
	
	

}
