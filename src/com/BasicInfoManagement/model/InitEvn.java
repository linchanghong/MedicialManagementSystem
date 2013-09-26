package com.BasicInfoManagement.model;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InitEvn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化： 1、创建table
				Configuration cf = new Configuration().configure();
				SchemaExport se = new SchemaExport(cf);
				se.create(true, true);	
				
				System.out.println("------init ok.");
	}

}
