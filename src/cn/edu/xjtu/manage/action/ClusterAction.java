package cn.edu.xjtu.manage.action;

import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.Cluster;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.dao.ClusterDao;
import cn.edu.xjtu.manage.dao.DBDao;
import cn.edu.xjtu.manage.dao.HoneyPotDao;
import com.opensymphony.xwork2.ActionSupport;

public class ClusterAction  extends ActionSupport{
	String interval;

	Cluster clusterParameter;
	List<Cluster> dataList;
	
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public Cluster getClusterParameter() {
		return clusterParameter;
	}
	public void setClusterParameter(Cluster clusterParameter) {
		this.clusterParameter = clusterParameter;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public List<Cluster> getDataList() {
		return dataList;
	}
	public void setDataList(List<Cluster> dataList) {
		this.dataList = dataList;
	}
	String re;
	
	public String getRe() {
		return re;
	}

	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	private String ID;

	public String execute(){
		
		return "SUCCESS";
	}
	
	public String update(){
		ClusterDao dao=new ClusterDao();
		int re=dao.updateParameter(id, interval);
		return "SUCCESS"; 
	}
	public String getCluster(){
		ClusterDao dao=new ClusterDao();
		dataList=dao.getParameter();
		if(!dataList.isEmpty()){
			clusterParameter= dataList.get(0);
		}
		return "SUCCESS";
	}
	
}
