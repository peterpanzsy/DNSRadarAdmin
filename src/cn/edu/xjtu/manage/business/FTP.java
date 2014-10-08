package cn.edu.xjtu.manage.business;

public class FTP {
	public FTP() {
		super();
	}
	int id;
	String ip;
	String port;
	String user;
	String passwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public FTP(int id,String ip, String dbport,String dbuser,String dbpasswd) {
		super();
		this.id=id;
		this.ip=ip;
		this.port=dbport;
		this.user=dbuser;
		this.passwd=dbpasswd;
	}

}
