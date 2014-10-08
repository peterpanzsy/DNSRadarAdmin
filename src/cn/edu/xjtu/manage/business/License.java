package cn.edu.xjtu.manage.business;

import java.util.Date;


public class License {

	int id;
	String license;
	Date expires;
	int isvalid;

	public License() {
		super();
	}
	public License(int id, String license, Date expires, int isvalid) {
		super();
		this.id = id;
		this.license = license;
		this.expires = expires;
		this.isvalid = isvalid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
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


}
