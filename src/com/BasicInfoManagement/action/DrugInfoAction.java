package com.BasicInfoManagement.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DrugCategoryDao;
import com.BasicInfoManagement.dao.DrugCodeDao;
import com.BasicInfoManagement.dao.DrugInfoDao;
import com.BasicInfoManagement.dao.DrugManufDao;
import com.BasicInfoManagement.model.JC_YP_DrugCategory;
import com.BasicInfoManagement.model.JC_YP_DrugCode;
import com.BasicInfoManagement.model.JC_YP_DrugInfo;
import com.BasicInfoManagement.model.JC_YP_DrugManuf;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class DrugInfoAction extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();

	private JC_YP_DrugInfo druginfo;

	public JC_YP_DrugInfo getDruginfo() {
		return druginfo;
	}

	public void setDruginfo(JC_YP_DrugInfo druginfo) {
		this.druginfo = druginfo;
	}

	// 显示全部
	public String queryAll() {
		// 获取页码
		String page = request.getParameter("currPage");
		int currPage = 1; // 当前页
		int pageSize = 15; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugInfoDao dao = new DrugInfoDao();
		DrugCategoryDao categorydao = new DrugCategoryDao();
		List categoryname = categorydao.findAllCategoryName();
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		request.setAttribute("pageModel", pageModel);
		request.setAttribute("categoryname", categoryname);
		return "queryAll";
	}

	// 删除
	public String Delete() {
		DrugInfoDao dao = new DrugInfoDao();
		int id = Integer.parseInt(request.getParameter("drugInfo_id"));
		dao.deleteDrugInfo(id);
		queryAll();
		return "deletesuccess";
	}

	// 添加
	public String Add() throws UnsupportedEncodingException {
		JC_YP_DrugCode Drugcode = null;
		JC_YP_DrugCategory Drugcategory = null;
		JC_YP_DrugManuf DrugManuf = null;

		DrugCodeDao codedao = new DrugCodeDao();
		DrugCategoryDao categorydao = new DrugCategoryDao();
		DrugManufDao drugManufdao = new DrugManufDao();

		String drugcode = new String(request.getParameter("drugCode").trim()
				.getBytes("iso8859-1"), "gb2312");
		String drugcategory = new String(request.getParameter("categoryName")
				.trim().getBytes("iso8859-1"), "gb2312");
		String drugManuf = new String(request.getParameter("supplier").trim()
				.getBytes("iso8859-1"), "gb2312");

		
		Drugcode = codedao.getDrugCode(drugcode);
		Drugcategory = categorydao.getDrugCategory(drugcategory);
		DrugManuf = drugManufdao.getdrugManuf(drugManuf);

		DrugInfoDao dao = new DrugInfoDao();

		druginfo.setDrugInfo_name(new String(druginfo.getDrugInfo_name()
				.getBytes("iso8859-1"), "gb2312"));
		druginfo.setDrugCode(Drugcode);
		druginfo.setDrugInfo_standard(new String(druginfo
				.getDrugInfo_standard().getBytes("iso8859-1"), "gb2312"));
		druginfo.setDrugCategory(Drugcategory);
		druginfo.setDrugManuf(DrugManuf);
		druginfo.setDrugInfo_approve(new String(druginfo.getDrugInfo_approve()
				.getBytes("iso8859-1"), "gb2312"));
		druginfo.setDrugInfo_saleclassification(new String(druginfo
				.getDrugInfo_saleclassification().getBytes("iso8859-1"),
				"gb2312"));
		druginfo.setDrugInfo_dosage(new String(druginfo.getDrugInfo_dosage()
				.getBytes("iso8859-1"), "gb2312"));
		druginfo.setDrugInfo_zjm(new String(druginfo.getDrugInfo_zjm()
				.getBytes("iso8859-1"), "gb2312"));
		dao.saveDrugInfo(druginfo);

		queryAll();
		return "addsuccess";
	}

	// 查询
	public String Query() {
		String type = request.getParameter("queryType");
		String data = request.getParameter("queryData");
		String page = request.getParameter("currPage");
		int currPage = 1; // 当前页
		int pageSize = 5; // 每页显示5条记录
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		DrugInfoDao dao = new DrugInfoDao();
		PageModel pageModel = dao.findPagingQuery(currPage, pageSize, type,
				data);
		request.setAttribute("pageModel", pageModel);
		return "qurysuccess";
	}

	public String Exists() throws Exception {
		String drugcode = new String(request.getParameter("drugCode").trim()
				.getBytes("iso8859-1"), "gb2312");
		DrugCodeDao dao = new DrugCodeDao();
		boolean boo = dao.findDrugCodeByNumber(drugcode);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (!boo) {
			out.println("*药品编码无效");
			out.flush();
			out.close();
		}
		return null;
	}

	public String BeforeModify() {
		DrugInfoDao dao = new DrugInfoDao();
		String id = request.getParameter("drugInfo_id");
		if (id != null) {
			request.setAttribute("modifyDrugInfo",
					dao.getDrugInfo(Integer.valueOf(id)));
		}
		return "beforemodify";
	}

	public String Modify() throws UnsupportedEncodingException {

		JC_YP_DrugCode Drugcode = null;
		JC_YP_DrugCategory Drugcategory = null;
		JC_YP_DrugManuf DrugManuf = null;

		DrugCodeDao codedao = new DrugCodeDao();
		DrugCategoryDao categorydao = new DrugCategoryDao();
		DrugManufDao drugManufdao = new DrugManufDao();

		String drugcode = request.getParameter("drugCode").trim();

		String drugcategory = request.getParameter("categoryName").trim();

		String drugManuf = request.getParameter("supplier").trim();

		

		Drugcode = codedao.getDrugCode(drugcode);
		Drugcategory = categorydao.getDrugCategory(drugcategory);
		DrugManuf = drugManufdao.getdrugManuf(drugManuf);

		DrugInfoDao dao = new DrugInfoDao();
		String id = request.getParameter("modifyid");
		JC_YP_DrugInfo info = dao.getDrugInfo(Integer.valueOf(id));

		info.setDrugInfo_name(druginfo.getDrugInfo_name());
		info.setDrugCode(Drugcode);
		info.setDrugInfo_standard(druginfo.getDrugInfo_standard());
		info.setDrugCategory(Drugcategory);
		info.setDrugManuf(DrugManuf);
		info.setDrugInfo_approve(druginfo.getDrugInfo_approve());
		info.setDrugInfo_saleclassification(druginfo
				.getDrugInfo_saleclassification());
		info.setDrugInfo_dosage(druginfo.getDrugInfo_dosage());
		info.setDrugInfo_zjm(druginfo.getDrugInfo_zjm());

		dao.saveDrugInfo(info);

		queryAll();
		return "modifysuccess";
	}
}
