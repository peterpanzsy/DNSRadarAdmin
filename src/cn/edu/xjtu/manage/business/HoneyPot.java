package cn.edu.xjtu.manage.business;

public class HoneyPot {
	public HoneyPot() {
		super();
	}
	int id;
	int order;
	String ip;
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

	public HoneyPot(int order,int id, String ip) {
		super();
		this.order=order;
		this.id=id;
		this.ip=ip;
	}

}
