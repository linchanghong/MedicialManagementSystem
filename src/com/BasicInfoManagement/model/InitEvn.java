package com.BasicInfoManagement.model;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InitEvn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʼ���� 1������table
				Configuration cf = new Configuration().configure();
				SchemaExport se = new SchemaExport(cf);
				se.create(true, true);	
				
				System.out.println("------init ok.");
	}

}
