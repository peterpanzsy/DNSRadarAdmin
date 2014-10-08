package cn.edu.xjtu.manage.business;

public class WhiteDomain {
	public WhiteDomain() {
		super();
	}
	int id;
	int order;
	String domain;
	String remark;
//	int ifrunning;
//	public int getIfrunning() {
//		return ifrunning;
//	}
//	public void setIfrunning(int ifrunning) {
//		this.ifrunning = ifrunning;
//	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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
	
	public WhiteDomain(int order,int id, String domain,String remark) {
		super();
		this.order=order;
		this.id=id;
		this.domain=domain;
		this.remark=remark;
//		this.ifrunning=ifrunning;
	}

}
