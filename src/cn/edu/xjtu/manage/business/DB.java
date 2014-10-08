package cn.edu.xjtu.manage.business;

public class DB {
	public DB() {
		super();
	}
	int id;
	String ip;
	String dbport;
	String dbname;
	String dbuser;
	String dbpasswd;
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
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDbpasswd() {
		return dbpasswd;
	}
	public void setDbpasswd(String dbpasswd) {
		this.dbpasswd = dbpasswd;
	}
	public String getDbport() {
		return dbport;
	}
	public void setDbport(String dbport) {
		this.dbport = dbport;
	}
	public String getDbuser() {
		return dbuser;
	}
	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}
	
	public DB(int id,String ip, String dbport,String dbname,String dbuser,String dbpasswd) {
		super();
		this.id=id;
		this.ip=ip;
		this.dbport=dbport;
		this.dbname=dbname;
		this.dbuser=dbuser;
		this.dbuser=dbuser;
		this.dbpasswd=dbpasswd;
	}

}
