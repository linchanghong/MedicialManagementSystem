package com.BasicInfoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BasicInfoManagement.dao.DrugManufDao;
import com.BasicInfoManagement.model.JC_YP_DrugManuf;
import com.BasicInfoManagement.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class DrugManufAction extends ActionSupport {

	private Integer drugManuf_id; // Id���
	private String drugManuf_name; // ��Ӧ����
	private String drugManuf_number; // ��Ӧ�̱���
	private String drugManuf_zjm; // ������
	private String drugManuf_address; // ��Ӧ�̵�ַ
	private String drugManuf_postcode; // ��Ӧ���ʱ�
	private String drugManuf_telephone; // ��Ӧ�̵绰
	private String drugManuf_fax; // ��Ӧ�̴���
	private String drugManuf_linkman;
	private HttpServletRequest request;

	private JC_YP_DrugManuf jc_yp_drugManuf = new JC_YP_DrugManuf();
	DrugManufDao dao = new DrugManufDao();

	public Integer getDrugManuf_id() {
		return drugManuf_id;
	}

	public void setDrugManuf_id(Integer drugManuf_id) {
		this.drugManuf_id = drugManuf_id;
	}

	public String getDrugManuf_name() {
		return drugManuf_name;
	}

	public void setDrugManuf_name(String drugManuf_name) {
		this.drugManuf_name = drugManuf_name;
	}

	public String getDrugManuf_number() {
		return drugManuf_number;
	}

	public void setDrugManuf_number(String drugManuf_number) {
		this.drugManuf_number = drugManuf_number;
	}

	public String getDrugManuf_zjm() {
		return drugManuf_zjm;
	}

	public void setDrugManuf_zjm(String drugManuf_zjm) {
		this.drugManuf_zjm = drugManuf_zjm;
	}

	public String getDrugManuf_address() {
		return drugManuf_address;
	}

	public void setDrugManuf_address(String drugManuf_address) {
		this.drugManuf_address = drugManuf_address;
	}

	public String getDrugManuf_postcode() {
		return drugManuf_postcode;
	}

	public void setDrugManuf_postcode(String drugManuf_postcode) {
		this.drugManuf_postcode = drugManuf_postcode;
	}

	public String getDrugManuf_telephone() {
		return drugManuf_telephone;
	}

	public void setDrugManuf_telephone(String drugManuf_telephone) {
		this.drugManuf_telephone = drugManuf_telephone;
	}

	public String getDrugManuf_fax() {
		return drugManuf_fax;
	}

	public void setDrugManuf_fax(String drugManuf_fax) {
		this.drugManuf_fax = drugManuf_fax;
	}

	public String getDrugManuf_linkman() {
		return drugManuf_linkman;
	}

	public void setDrugManuf_linkman(String drugManuf_linkman) {
		this.drugManuf_linkman = drugManuf_linkman;
	}

	public DrugManufAction() {
		request = ServletActionContext.getRequest();

	}

	public String query() {
		String type = request.getParameter("queryType");
		String data = request.getParameter("queryData");
		if (type != null || data != null) {
			// ɾ��������Ϣ
			List jc_yp_drugManuf = dao.findQueryDrugManuf(type, data);
			request.setAttribute("list", jc_yp_drugManuf);
		}
		return SUCCESS;
	}

	public String add() // ���ڽ��½�����Ϣ���������ݿ⡣
	{
		jc_yp_drugManuf.setDrugManuf_id(drugManuf_id);
		jc_yp_drugManuf.setDrugManuf_name(drugManuf_name);
		jc_yp_drugManuf.setDrugManuf_number(drugManuf_number);
		jc_yp_drugManuf.setDrugManuf_zjm(drugManuf_zjm);
		jc_yp_drugManuf.setDrugManuf_address(drugManuf_address);
		jc_yp_drugManuf.setDrugManuf_postcode(drugManuf_postcode);
		jc_yp_drugManuf.setDrugManuf_telephone(drugManuf_telephone);
		jc_yp_drugManuf.setDrugManuf_fax(drugManuf_fax);
		jc_yp_drugManuf.setDrugManuf_linkman(drugManuf_linkman);
		dao.saveDrugManuf(jc_yp_drugManuf); // ���
		fillData();

		return SUCCESS;
	}

	public String delete() {
		String id = request.getParameter("drugManuf_id");
		if (id != null) {
			// ɾ��������Ϣ
			dao.deleteDrugManuf(Integer.valueOf(id));
			fillData();
		}
		return SUCCESS;
	}

	public String modify1() // ���Ҫ���µĿ��ң��������е�������ʾ��һ��jsp�ϡ�
	{
		String id = request.getParameter("drugManuf_id");
		if (id != null) {
			request.setAttribute("modifyInfo",
					dao.getDrugManuf(Integer.valueOf(id)));
		}
		return SUCCESS;
	}

	public String modify2() // ���£���⡣
	{
		String id = request.getParameter("drugManuf_id");
		System.out.println(id + "--------------");

		JC_YP_DrugManuf jc_yp_drugManuf = dao.getDrugManuf(drugManuf_id); // �ҵ���Ҫ�޸ĵĿ��ҡ�
		// jc_yp_drugManuf.setDrugManuf_id(drugManuf_id);
		jc_yp_drugManuf.setDrugManuf_name(drugManuf_name);
		jc_yp_drugManuf.setDrugManuf_number(drugManuf_number);
		jc_yp_drugManuf.setDrugManuf_zjm(drugManuf_zjm);
		jc_yp_drugManuf.setDrugManuf_address(drugManuf_address);
		jc_yp_drugManuf.setDrugManuf_postcode(drugManuf_postcode);
		jc_yp_drugManuf.setDrugManuf_telephone(drugManuf_telephone);
		jc_yp_drugManuf.setDrugManuf_fax(drugManuf_fax);
		jc_yp_drugManuf.setDrugManuf_linkman(drugManuf_linkman);
		dao.saveDrugManuf(jc_yp_drugManuf); // ���
		fillData();

		return SUCCESS;
	}

	public void fillData() // ������ÿ����ת�� DeptInfo_indexҳ��ʱ������������ʾ�����С�
	{
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 11; // ÿҳ��ʾ5����¼
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		request.removeAttribute("pageModel");
		PageModel pageModel = dao.findPaging(currPage, pageSize);
		// System.out.println(pageModel.getList().size()+"############");
		request.setAttribute("pageModel", pageModel);
	}

	public String queryAll() {
		fillData();
		return SUCCESS;
	}

	// ����ҳ����ʾ����
	public String findAll() {
		String page = request.getParameter("currPage");
		int currPage = 1; // ��ǰҳ
		int pageSize = 15; // ÿҳ��ʾ5����¼
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		request.removeAttribute("pageModel");
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
		PageModel pageModel = dao.findPagingQuery(currPage, pageSize, type,
				data);
		request.setAttribute("pageModel", pageModel);
		return "findsuccess";
	}
}
