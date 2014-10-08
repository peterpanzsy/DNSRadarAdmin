package cn.edu.xjtu.manage.business;

public class WhiteIp {
	public WhiteIp() {
		super();
	}
	int id;
	int order;
	String ip;
	String remark;
	int ifrunning;
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
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}

	public WhiteIp(int order,int id, String ip,String remark,int ifrunning) {
		super();
		this.order=order;
		this.id=id;
		this.ip=ip;
		this.remark=remark;
		this.ifrunning=ifrunning;
	}

}
