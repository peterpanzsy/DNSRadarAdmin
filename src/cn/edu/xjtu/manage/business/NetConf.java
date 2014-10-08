package cn.edu.xjtu.manage.business;

public class NetConf {
	public NetConf() {
		super();
	}
	int id;
	String netip;
	String maskip;
	String gateip;
	String dns1ip;
	String dns2ip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNetip() {
		return netip;
	}
	public void setNetip(String netip) {
		this.netip = netip;
	}
	public String getMaskip() {
		return maskip;
	}
	public void setMaskip(String maskip) {
		this.maskip = maskip;
	}
	public String getGateip() {
		return gateip;
	}
	public void setGateip(String gateip) {
		this.gateip = gateip;
	}
	public String getDns1ip() {
		return dns1ip;
	}
	public void setDns1ip(String dns1ip) {
		this.dns1ip = dns1ip;
	}
	public String getDns2ip() {
		return dns2ip;
	}
	public void setDns2ip(String dns2ip) {
		this.dns2ip = dns2ip;
	}
	
	public NetConf(int id,String netip, String maskip, String gateip,String dns1ip,String dns2ip) {
		super();
		this.id=id;
		this.netip=netip;
		this.maskip=maskip;
		this.gateip=gateip;
		this.dns1ip=dns1ip;
		this.dns2ip=dns2ip;
	}

}
