package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;
public class SupplierDao {
/*
 * ��ӹ�Ӧ����Ϣ
*/
	public JC_YP_Supplier getSupplier(String name) {
		Session session = null;
		JC_YP_Supplier supplier = null;
		try {
			// ��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction(); // ��������
			// HQL��ѯ���
			String hql = "from JC_YP_Supplier supplier where supplier.supplier_name=?";
			Query query = session.createQuery(hql) // ����Query����
					.setParameter(0, name);// ��̬��ֵ
			supplier = (JC_YP_Supplier) query.uniqueResult(); // ����codenumber����
			session.getTransaction().commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
			session.getTransaction().rollback();// �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Session
		}

		return supplier;
	}

	public void saveSupplier(JC_YP_Supplier sup){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(sup);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/*
	 * ɾ����Ӧ����Ϣ
	 */
	public void deleteSupplier(int id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			JC_YP_Supplier sup = (JC_YP_Supplier)session.get(JC_YP_Supplier.class, id);
			session.delete(sup);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/*
	 * ��ѯ���й�Ӧ����Ϣ
	 */
	public List<JC_YP_Supplier> findAllSupplier(){
		Session session = null;					//Session����
		List<JC_YP_Supplier> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from JC_YP_Supplier";		//HQL��ѯ��䣬���ñ���������
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
	/*
	 * ͨ����Ӧ���������ͣ���ȷ���͹�Ӧ�����ƣ�ģ������ѯ��Ӧ����Ϣ
	 */
	public List<JC_YP_Supplier> findSupplier(String supName,String supType){
		Session session = null;					//Session����
		List<JC_YP_Supplier> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			if(supType.equals("none")){
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname ")		//����Query����
						.setString("supname", supName+"%")
					          .list();				//��ȡ�����
			}else if(supName.trim().equals("")){
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_type=:suptype")		//����Query����
						.setString("suptype", supType)
					          .list();
			}else{
				list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype")		//����Query����
					.setString("supname", supName+"%")
					.setString("suptype", supType)
				          .list();				//��ȡ�����
			}
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return list;
	}
	/*
	 * ͨ����Ӧ�����ƣ�ģ������ѯ��Ӧ����Ϣ
	 */
	public List<JC_YP_Supplier> findSupplierByName(String supName){
		Session session = null;					//Session����
		List<JC_YP_Supplier> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			//String hql = "from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype";		
			list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_name like:supname ")		//����Query����
					.setString("supname", supName)
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
	/*
	 * ͨ����Ӧ�����ƣ�ģ������ѯ��Ӧ����Ϣ
	 */
	public List<JC_YP_Supplier> findSupplierById(int id){
		Session session = null;					//Session����
		List<JC_YP_Supplier> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			//String hql = "from JC_YP_Supplier as sup where sup.supplier_name like:supname and sup.supplier_type=:suptype";		
			list = session.createQuery("from JC_YP_Supplier as sup where sup.supplier_id =:supId ")		//����Query����
					.setInteger("supId", id)
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
}
