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
		// 获取页码
		String page = request.getParameter("currPage");
		int currPage = 1; // 当前页
		int pageSize = 15; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		request.setAttribute("pageModel", pageModel);
		return "queryAll";
	}

	// 弹出页面的显示所有
	public String findAll() {
		// 获取页码
		String page = request.getParameter("currPage");
		int currPage = 1; // 当前页
		int pageSize = 15; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugCodeDao dao = new DrugCodeDao();
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		request.setAttribute("pageModel", pageModel);
		return "findAll";
	}

	// 弹出页面的查找
	public String Find() {
		String type = request.getParameter("queryType");
		String data = request.getParameter("queryData");
		String page = request.getParameter("currPage");
		int currPage = 1; // 当前页
		int pageSize = 15; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
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
		int currPage = 1; // 当前页
		int pageSize = 15; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
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
			out.println("*药品编码已存在");
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

	public String BeforeModify() { // 从点击修改的界面接收参数，传到修改页面
		DrugCodeDao dao = new DrugCodeDao();
		String drugcodeid = request.getParameter("drugCode_id");
		if (drugcodeid != null) {
			request.setAttribute("modifyDrugCodeInfo",
					dao.getDrugCodeInfo(Integer.valueOf(drugcodeid)));
		}
		return "beforemodify";
	}

	public String Modify() { // 从修改页面接收参数，入库操作
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
