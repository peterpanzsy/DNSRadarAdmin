package cn.edu.xjtu.manage.action;

import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.dao.HoneyPotDao;
import com.opensymphony.xwork2.ActionSupport;

public class HoneyPotAction  extends ActionSupport{
	String ip;
	String CName;
	String EName;
	String Description;
	String ISOBasicUnit;
	List<HoneyPot> dataList;
	private int page;
	private int records;
	private int rows;
	private int rowNum;
	private int total;
	private String sidx;
	private String sord;
	private int id;
	private List<Integer> ids;
	
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

	public List<HoneyPot> getDataList() {
		return dataList;
	}

	public int getRecords() {
		return records;
	}


	public String execute(){
		
		return "SUCCESS";
	}
	
	public String list(){		

		HoneyPotDao dao=new HoneyPotDao();
		
		dataList=dao.getHoneyPotList();
	
		records=dao.getCountPot();

		if(records!=0&&rows!=0){
		total=records/rows;
			if(records%rows!=0){
				total++;
			}
		}
		return "SUCCESS";
	}
	
	public String add(){

		HoneyPotDao dao=new HoneyPotDao();
		
		int result=dao.addPot(ip);

		return "SUCCESS";
	}
	
	public String delete(){
		HoneyPotDao dao=new HoneyPotDao();
		if(!ids.isEmpty()){

			for(int id:ids){
				dao.deletePot(id);
			}
		}
		dao.commit();
		return "SUCCESS";
	}
	
	
	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getEName() {
		return EName;
	}

	public void setEName(String eName) {
		EName = eName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getISOBasicUnit() {
		return ISOBasicUnit;
	}

	public void setISOBasicUnit(String iSOBasicUnit) {
		ISOBasicUnit = iSOBasicUnit;
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
