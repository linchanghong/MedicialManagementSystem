package com.BasicInfoManagement.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DrugCodeDao;
import com.BasicInfoManagement.model.JC_YP_DrugCode;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class DrugCodeAction extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();

	private JC_YP_DrugCode drugcode;

	public JC_YP_DrugCode getDrugcode() {
		return drugcode;
	}

	public void setDrugcode(JC_YP_DrugCode drugcode) {
		this.drugcode = drugcode;
	}

	public String queryAll() {
		// ��ȡҳ��
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 15; // ÿҳ��ʾ5����¼
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		request.setAttribute("pageModel", pageModel);
		return "queryAll";
	}

	// ����ҳ�����ʾ����
	public String findAll() {
		// ��ȡҳ��
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 15; // ÿҳ��ʾ5����¼
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		request.setAttribute("pageModel", pageModel);
		return "findAll";
	}

	// ����ҳ��Ĳ���
	public String Find() {
		String type = request.getParameter("queryType");
		String data = request.getParameter("queryData");
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 15; // ÿҳ��ʾ5����¼
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPagingQuery(currPage, pageSize, type,
				data);
		request.setAttribute("pageModel", pageModel);
		return "findsuccess";
	}

	public String Query() {
		String type = request.getParameter("queryType");
		String data = request.getParameter("queryData");
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 15; // ÿҳ��ʾ5����¼
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPagingQuery(currPage, pageSize, type,
				data);
		request.setAttribute("pageModel", pageModel);
		return "qurysuccess";
	}

	public String Add() {
		DrugCodeDao dao = new DrugCodeDao();
		drugcode.setDrugCode_number(drugcode.getDrugCode_number());
		drugcode.setDrugCode_zjm(drugcode.getDrugCode_zjm());
		dao.saveDrugCode(drugcode);
		queryAll();
		return "addsuccess";
	}

	public String Exists() throws Exception {
		
		DrugCodeDao dao = new DrugCodeDao();
		boolean boo = dao.findDrugCodeByNumber(drugcode.getDrugCode_number());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (boo) {
			out.println("*ҩƷ�����Ѵ���");
			out.flush();
			out.close();
		}
		return null;
	}

	public String Delete() {
		DrugCodeDao dao = new DrugCodeDao();
		String drugcodeid = request.getParameter("drugCode_id");
		int id = Integer.parseInt(drugcodeid);
		dao.deleteDrugCode(id);
		queryAll();
		return "deletesuccess";
	}

	public String BeforeModify() { // �ӵ���޸ĵĽ�����ղ����������޸�ҳ��
		DrugCodeDao dao = new DrugCodeDao();
		String drugcodeid = request.getParameter("drugCode_id");
		if (drugcodeid != null) {
			request.setAttribute("modifyDrugCodeInfo",
					dao.getDrugCodeInfo(Integer.valueOf(drugcodeid)));
		}
		return "beforemodify";
	}

	public String Modify() { // ���޸�ҳ����ղ�����������
		DrugCodeDao dao = new DrugCodeDao();
		String id = request.getParameter("modifyid");
		JC_YP_DrugCode drugcodemodify = dao
				.getDrugCodeInfo(Integer.valueOf(id));
		drugcodemodify.setDrugCode_number(drugcode.getDrugCode_number());
		drugcodemodify.setDrugCode_zjm(drugcode.getDrugCode_zjm());
		dao.saveDrugCode(drugcodemodify);
		queryAll();
		return "modifysuccess";
	}
}
