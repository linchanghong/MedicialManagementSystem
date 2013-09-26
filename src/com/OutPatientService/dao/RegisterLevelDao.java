package com.OutPatientService.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.BasicInfoManagement.util.HibernateUtil;
import com.BasicInfoManagement.util.PageModel;
import com.OutPatientService.model.MZ_RegisterLevel;

/**
 * ������Ϣ���ݿ������
 */
public class RegisterLevelDao {
	/**
	 * ������޸�������Ϣ
	 * @param mz_registerLevel����
	 */
	public void saveRegisterLevel(MZ_RegisterLevel mz_registerLevel){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(mz_registerLevel);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ɾ��������Ϣ
	 * @param id ����id
	 */
	public void deleteRegisterLevel(Integer id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			MZ_RegisterLevel RegisterLevel = (MZ_RegisterLevel)session.get(MZ_RegisterLevel.class, id);
			session.delete(RegisterLevel);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ��ѯ������Ϣ
	 * @return List����
	 */
	public PageModel findQueryRegisterLevel(String type, String data){
		Session session = null;					//Session����
		List<MZ_RegisterLevel> list = null;				//List����
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = null;
			if(type.equals("all")){
				hql = "from MZ_RegisterLevel";
			}else{
				hql = "from MZ_RegisterLevel cs where cs."+type+"="+data;		//HQL��ѯ���
			}
			list = session.createQuery(hql)		//����Query����
					.setFirstResult(0)	//������ʼλ��
  					.setMaxResults(7)	//���ü�¼��
				          .list();				//��ȡ�����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(1);	//���õ�ǰҳ
			pageModel.setList(list);			//���ý����
			pageModel.setPageSize(7);	//����ÿҳ��¼��
			//�����ܼ�¼��
			pageModel.setTotalRecords(getTotalRegisterLevel(session));
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pageModel;
	}
	
	
	public List<MZ_RegisterLevel> queryByWhereParameterChain(String type, String data){
		//1����ȡSession
		Session session = HibernateUtil.getSession();
		
		List result = null;
		String queryStr = "from MZ_RegisterLevel cs where cs.id>? and cs.name like ?";
		
		Query query = session.createQuery(queryStr)
			.setString(0, type)
			.setString(1, data);		
		result = query.list();
		
		return result;
	}
	
	
	
	/**
	 * ͨ��id����������Ϣ
	 * @param id ����id
	 */
	public MZ_RegisterLevel getRegisterLevel(Integer id){
		Session session = null;					//Session����
		MZ_RegisterLevel message = null;					//����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����JC_YP_DrugManuf
			message = (MZ_RegisterLevel)session.get(MZ_RegisterLevel.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}

	/**
	 * ��ѯ���Ե��ܼ�¼��
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int getTotalRegisterLevel(Session session ) {
	
		// HQL��ѯ���
		String hql = "select count(*) from MZ_RegisterLevel";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}

	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		//System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from MZ_RegisterLevel";
			List<MZ_RegisterLevel> list = session.createQuery(hql)		//����Query����
		  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
		  					.setMaxResults(pageSize)	//���ü�¼��
		  					.list();					//���ؽ����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(currPage);	//���õ�ǰҳ
			pageModel.setList(list);			//���ý����
			pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
			//�����ܼ�¼��
			pageModel.setTotalRecords(getTotalRegisterLevel(session));
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pageModel;
	} 

}










