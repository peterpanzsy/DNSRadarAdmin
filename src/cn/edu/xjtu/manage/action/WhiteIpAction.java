package cn.edu.xjtu.manage.action;

import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.WhiteIp;
import cn.edu.xjtu.manage.dao.WhiteIpDao;

import com.opensymphony.xwork2.ActionSupport;

public class WhiteIpAction  extends ActionSupport{
	String ip;
	String remark;
	int ifrunning;
	List<WhiteIp> dataList;
	private int page;
	private int records;
	private int rows;
	private int rowNum;
	private int total;
	private String sidx;
	private String sord;
	private int id;
	private List<Integer> ids;
	
	public int getIfrunning() {
		return ifrunning;
	}
	public void setIfrunning(int ifrunning) {
		this.ifrunning = ifrunning;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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

	public List<WhiteIp> getDataList() {
		return dataList;
	}

	public int getRecords() {
		return records;
	}


	public String execute(){
		
		return "SUCCESS";
	}


	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	public String list(){		

		WhiteIpDao dao=new WhiteIpDao();
		
		dataList=dao.getWhiteIpList();
	
		records=dao.getCountWhiteIp();

		if(records!=0&&rows!=0){
		total=records/rows;
			if(records%rows!=0){
				total++;
			}
		}
		return "SUCCESS";
	}
	
	public String add(){

		WhiteIpDao dao=new WhiteIpDao();
		
		int result=dao.addWhiteIp(ip,remark,ifrunning);

		return "SUCCESS";
	}
	
	public String delete(){
		WhiteIpDao dao=new WhiteIpDao();
		if(!ids.isEmpty()){
			for(int id:ids){
				dao.deleteWhiteIp(id);
			}
		}
		dao.commit();
		return "SUCCESS";
	}
	
}
