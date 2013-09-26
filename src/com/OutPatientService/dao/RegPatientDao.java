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
		Session session = null;					//Session����
//		System.out.println("11111111111111111111111111");
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from MZ_RegisterPatient";
			List<MZ_RegisterPatient> list = session.createQuery(hql)		//����Query����
		  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
		  					.setMaxResults(pageSize)	//���ü�¼��
		  					.list();					//���ؽ����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(currPage);//���õ�ǰҳ
			List<String> ls=new ArrayList<String>();
			//����
 			for(int i=0;i<list.size();i++)
			{
				Date date=list.get(i).getRegiserPatient_birthday();
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
 			    String s=df.format(date).substring(0, 9);
 			    //datelist.add(s);
 			    ls.add(s);
 			    
 			    
			}//����
 			setDatelist(ls);
 			
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
		String hql = "select count(*) from MZ_RegisterPatient";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
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
		System.out.println("zzzzzzzzzzzzzz����ɾ�� "+id);
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			MZ_RegisterPatient message = (MZ_RegisterPatient)session.get(MZ_RegisterPatient.class, id);
			if(message!=null)
			session.delete(message);			//ɾ������
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
		//System.out.println("�����ѯ");
		Session session = null;					//Session����
		List<MZ_RegisterPatient> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from MZ_RegisterPatient cs where cs."+type+"=?";		//HQL��ѯ���
			//list = session.createQuery(hql).setParameter(0, type).setParameter(1, data).list();	//��ȡ�����
			Query query=session.createQuery(hql);
			if(type=="regiserPatient_id")
			{
				query.setInteger(0, Integer.valueOf(data));
			}
			else
				query.setString(0, data);
			list=query.list();
			//System.out.println("�õ�list");
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
