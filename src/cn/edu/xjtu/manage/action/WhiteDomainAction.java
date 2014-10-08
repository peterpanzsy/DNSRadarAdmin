package cn.edu.xjtu.manage.action;

import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.WhiteDomain;
import cn.edu.xjtu.manage.dao.WhiteDomainDao;

import com.opensymphony.xwork2.ActionSupport;

public class WhiteDomainAction  extends ActionSupport{
	String domain;
	String remark;
	List<WhiteDomain> dataList;
	private int page;
	private int records;
	private int rows;
	private int rowNum;
	private int total;
	private String sidx;
	private String sord;
	private int id;
	private List<Integer> ids;
	
	public void setDataList(List<WhiteDomain> dataList) {
		this.dataList = dataList;
	}
	public List<WhiteDomain> getDataList() {
		return dataList;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	String re;
	
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSidx() {
		return sidx;
	}

	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	public String getRe() {
		return re;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getRowNum() {
		return rowNum;

	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getPage(){
		return page;
	}
	
	
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}


	public String execute(){
		
		return "SUCCESS";
	}
	
	public String list(){		

		WhiteDomainDao dao=new WhiteDomainDao();
		
		dataList=dao.getWhiteDomainList();
	
		records=dao.getCountWhiteDomain();

		if(records!=0&&rows!=0){
		total=records/rows;
			if(records%rows!=0){
				total++;
			}
		}
		return "SUCCESS";
	}
	
	public String add(){

		WhiteDomainDao dao=new WhiteDomainDao();
		
		int result=dao.addWhiteDomain(domain,remark);

		return "SUCCESS";
	}
	
	public String delete(){
		WhiteDomainDao dao=new WhiteDomainDao();
		if(!ids.isEmpty()){
			for(int id:ids){
				dao.deleteWhiteDomain(id);
			}
		}
		dao.commit();
		return "SUCCESS";
	}


	
	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	private String ID;

	
}
