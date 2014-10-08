package cn.edu.xjtu.manage.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.License;
import cn.edu.xjtu.manage.dao.LicenseDao;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class LicenseAction  extends ActionSupport{
	
	String licensestr;
	Date expires;
	int isvalid;
	License license;
	List<License> dataList;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getLicensestr() {
		return licensestr;
	}
	public void setLicensestr(String licensestr) {
		this.licensestr = licensestr;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public int getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public List<License> getDataList() {
		return dataList;
	}
	public void setDataList(List<License> dataList) {
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
		LicenseDao dao=new LicenseDao();
		int res=dao.updateLicense(id, licensestr,expires,isvalid);
		try {
//			Process pid = Runtime.getRuntime().exec("/bin/sh /botwall/script/checkLicense.sh");
			Runtime.getRuntime().exec("java -jar E:\\CheckLicenseWin_Scan.jar");
			re="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re="failure";
		}
		return "SUCCESS"; 
	}
	public String getLicenseInfo(){
		LicenseDao dao=new LicenseDao();
		dataList=dao.getLicense();
		if(!dataList.isEmpty()){
			license= dataList.get(0);
		}
		return "SUCCESS";
	}
	
}
