package com.BasicInfoManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.BasicInfoManagement.model.*;
import com.BasicInfoManagement.util.*;
/*
 * ҩƷ����ά��
 */
public class DrugCategoryDao {
	/*
	 * ����ҩƷ����
	 */
public void saveDrugCategory(JC_YP_DrugCategory drugCategory){
	Session session=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(drugCategory);
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
}
/*
 * ɾ��ҩƷ����
 */
public void deleteDrugCategory(int id){
	Session session=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		JC_YP_DrugCategory drugCategory=(JC_YP_DrugCategory)session.get(JC_YP_DrugCategory.class,id);
		session.delete(drugCategory);
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
}
/*
 * ����ҩƷ������Ϣ
 */
public List<JC_YP_DrugCategory> findAllDrugCategory(){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		String hql="from JC_YP_DrugCategory";
		list=session.createQuery(hql).list();
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
	return list;
}
/*
 * ͨ��ҩƷ���������ҵ�ҩƷ����
 */
public List<JC_YP_DrugCategory> findDrugCategoryByName(String name){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		list=session.createQuery("from JC_YP_DrugCategory dc where dc.drugCategory_name like:dcName")
				.setString("dcName", name+"%").list();	//%����Ҫ
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
	}
	return list;
}
/*
 * ͨ��ҩƷ����id�ҵ�ҩƷ����
 */
public List<JC_YP_DrugCategory> findDrugCategoryById(int id){
	Session session=null;
	List<JC_YP_DrugCategory> list=null;
	try{
		session=HibernateUtil.getSession();
		session.beginTransaction();
		//String hql="from JC_YP_DrugCategory dc where dc.drugCategory_name like:dcName";		
		list=session.createQuery("from JC_YP_DrugCategory dc where dc.drugCategory_id =:dcId")
				.setInteger("dcId", id).list();
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}finally{
		HibernateUtil.closeSession();
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
	PageModel pageModel = null;
	try {
		//��ȡSession
		session = HibernateUtil.getSession();
		session.beginTransaction();			//��������
		//HQL��ѯ��䣬������ʱ�併������
		String hql = "from Message m order by m.createTime desc";
		List<JC_YP_DrugCategory> list = session.createQuery(hql)		//����Query����
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
/**
 * ��ѯ���Ե��ܼ�¼��
 * 
 * @param session
 *            Session����
 * @return �ܼ�¼��
 */
public int getTotalRecords(Session session) {
	// HQL��ѯ���
	String hql = "select count(*) from JC_YP_DrugCategory";
	// ����Query����
	Query query = session.createQuery(hql);
	// ��ֵ����
	Long totalRecords = (Long) query.uniqueResult();
	// �����ܼ�¼��
	return totalRecords.intValue();
}
public List<JC_YP_DrugCategory> findAllCategoryName() {
	Session session = null;
	List<JC_YP_DrugCategory> list = null;
	try {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql = "select drugCategory_name from JC_YP_DrugCategory";
		list = session.createQuery(hql).list();
		session.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
	} finally {
		HibernateUtil.closeSession();
	}
	return list;
}

public JC_YP_DrugCategory getDrugCategory(String name) {
	Session session = null; // Session����
	JC_YP_DrugCategory drugcategory = null;
	try {
		// ��ȡSession
		session = HibernateUtil.getSession();
		session.beginTransaction(); // ��������
		// HQL��ѯ���
		String hql = "from JC_YP_DrugCategory drugcate where drugcate.drugCategory_name='"
				+ name + "'";
		Query query = session.createQuery(hql); // ����Query����
		drugcategory = (JC_YP_DrugCategory) query.uniqueResult(); // ����codenumber����
		session.getTransaction().commit(); // �ύ����
	} catch (Exception e) {
		e.printStackTrace(); // ��ӡ�쳣��Ϣ
		session.getTransaction().rollback();// �ع�����
	} finally {
		HibernateUtil.closeSession(); // �ر�Session
	}

	return drugcategory;
}

}
