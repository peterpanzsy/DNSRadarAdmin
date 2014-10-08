package cn.edu.xjtu.manage.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.FTP;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.business.NetConf;
import cn.edu.xjtu.manage.dao.DBDao;
import cn.edu.xjtu.manage.dao.HoneyPotDao;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DBAction  extends ActionSupport{
//	String netconfshell="/botwall/netconf.sh";
//	String dbconfpath="/botwall/attackEventDetect/findAttack.conf";
	String dbconfpath="/botwall/java_proc/findBotnet/bin/findBotnet.conf";
	String interfacePath="d:\\interfaces";
	String resolvPath="d:/resolv.conf";
	String netip;
	String maskip;
	String gateip;
	String dns1ip;
	String dns2ip;
	String networkip;
	String broadcastip;
	NetConf netConfInfo;
	List<NetConf> netConfList;

	String ip;
	String dbport;
	String dbname;
	String dbuser;
	String dbpasswd;
	DB dbinfo;
	List<DB> dataList;
	
	String ftpip;
	String ftpport;
	String ftpname;
	String ftpuser;
	String ftppasswd;
	FTP ftpinfo;
	List<FTP> ftpList;

	private int id;
	
	public String getNetworkip() {
		return networkip;
	}
	public void setNetworkip(String networkip) {
		this.networkip = networkip;
	}
	public String getBroadcastip() {
		return broadcastip;
	}
	public void setBroadcastip(String broadcastip) {
		this.broadcastip = broadcastip;
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
	public NetConf getNetConfInfo() {
		return netConfInfo;
	}
	public void setNetConfInfo(NetConf netConfInfo) {
		this.netConfInfo = netConfInfo;
	}
	public List<NetConf> getNetConfList() {
		return netConfList;
	}
	public void setNetConfList(List<NetConf> netConfList) {
		this.netConfList = netConfList;
	}
	
	public String getFtpip() {
		return ftpip;
	}
	public void setFtpip(String ftpip) {
		this.ftpip = ftpip;
	}
	public FTP getFtpinfo() {
		return ftpinfo;
	}
	public void setFtpinfo(FTP ftpinfo) {
		this.ftpinfo = ftpinfo;
	}
	public List<FTP> getFtpList() {
		return ftpList;
	}
	public void setFtpList(List<FTP> ftpList) {
		this.ftpList = ftpList;
	}
	public String getFtpname() {
		return ftpname;
	}
	public void setFtpname(String ftpname) {
		this.ftpname = ftpname;
	}
	public String getFtppasswd() {
		return ftppasswd;
	}
	public void setFtppasswd(String ftppasswd) {
		this.ftppasswd = ftppasswd;
	}
	public String getFtpport() {
		return ftpport;
	}
	public void setFtpport(String ftpport) {
		this.ftpport = ftpport;
	}
	public String getFtpuser() {
		return ftpuser;
	}
	public void setFtpuser(String ftpuser) {
		this.ftpuser = ftpuser;
	}
	
	public DB getDbinfo() {
		return dbinfo;
	}
	public void setDbinfo(DB dbinfo) {
		this.dbinfo = dbinfo;
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
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	String re;
	

	public String getRe() {
		return re;
	}

	public List<DB> getDataList() {
		return dataList;
	}

	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	private String ID;
	
	public String modifyNetconf(String filePath) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));
			
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				// 此处根据实际需要修改某些行的内容
				if (line.startsWith("dbAddress")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(ip).append(":").append(dbport);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbName")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbname);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbUser")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbuser);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbPW")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbpasswd);
					line=sb.toString();
					buf.append(line);
				}
				// 如果不用修改, 则按原来的内容回写
				else {
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}
		
		return buf.toString();
	}
	
	public String modifyDBconf(String filePath) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));
			
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				// 此处根据实际需要修改某些行的内容
				if (line.startsWith("dbAddress")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(ip).append(":").append(dbport);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbName")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbname);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbUser")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbuser);
					line=sb.toString();
					buf.append(line);
				}
				else if (line.startsWith("dbPW")) {
					StringBuilder sb=new StringBuilder(line.split("=")[0]);
					sb.append("=").append(dbpasswd);
					line=sb.toString();
					buf.append(line);
				}
				// 如果不用修改, 则按原来的内容回写
				else {
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}
		
		return buf.toString();
	}
	
	/**
	 * 将内容回写到文件中
	 * 
	 * @param filePath
	 * @param content
	 */
	public void write(String filePath, String content) {
		BufferedWriter bw = null;
		
		try {
			// 根据文件路径创建缓冲输出流
			bw = new BufferedWriter(new FileWriter(filePath));
			// 将内容写入文件中
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					bw = null;
				}
			}
		}
	}
	
	public String execute(){
		
		return "SUCCESS";
	}
	
	public String update(){
		DBDao dao=new DBDao();
		int re=dao.updateDB(id, ip, dbport,dbname, dbuser,dbpasswd);
		write(dbconfpath,modifyDBconf(dbconfpath)); // 读取修改文件
			
		return "SUCCESS"; 
	}
	public String getDB(){
		DBDao dao=new DBDao();
		dataList=dao.getDB();
		if(!dataList.isEmpty()){
			dbinfo= dataList.get(0);
		}	
		return "SUCCESS";
	}
	
	public String updateFTP(){
		DBDao dao=new DBDao();
		int re=dao.updateFTP(id, ftpip, ftpport, ftpuser,ftppasswd);
		return "SUCCESS"; 
	}
	public String getFTP(){
		DBDao dao=new DBDao();
		ftpList=dao.getFTP();
		if(!ftpList.isEmpty()){
			ftpinfo= ftpList.get(0);
		}	
		return "SUCCESS";
	}
	
	public String updateNetConf(){
		DBDao dao=new DBDao();
		int res=dao.updateNetConf(id, netip, maskip,gateip,dns1ip,dns2ip);	
		
/*		String content=new StringBuilder("auto lo\niface lo inet loopback\nauto eth2\niface eth2 inet static\naddress ").append(netip).append("\nnetmask ").append(maskip).append("\nnetwork ").append(networkip).append("\nbroadcast ").append(broadcastip).append("\ngateway ").append(gateip).append("\n\nauto eth2:0\niface eth2:0 inet static\naddress 192.168.2.252\nnetmask 255.255.255.0\nnetwork 192.168.2.0\nbroadcast 192.168.2.255").toString();				
		write(interfacePath,content); // 读取修改文件		
		String dnscontent=new StringBuilder("nameserver ").append(dns1ip).append("\nnameserver ").append(dns2ip).toString();		
		write(resolvPath,dnscontent); // 读取修改文件
			
		try {		
			Process pid= Runtime.getRuntime().exec("/etc/init.d/networking restart");
			re="success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			re="failure";
			e.printStackTrace();
		} 
		*/
		
		try {
			String cmd1=new StringBuilder("netsh interface ip set address \"本地连接\" static  ").append(netip).append(" ").append(maskip).append(" ").append(gateip).toString();		
			Process pid1=null; 
			pid1= Runtime.getRuntime().exec(cmd1);
			
			String cmd2=new StringBuilder("netsh interface ip set dns \"本地连接\" static ").append(dns1ip).toString();				
			Process pid2=null; 
			pid2= Runtime.getRuntime().exec(cmd2);
			
			String cmd3=new StringBuilder("netsh interface ip add dns \"本地连接\" ").append(dns2ip).toString();		
			Process pid3=null; 
			pid3= Runtime.getRuntime().exec(cmd3);
			re="success";
		} catch (IOException e) {
			re="failure";
			e.printStackTrace();
		}
		return "SUCCESS"; 
	}
	public String getNetConf(){
		DBDao dao=new DBDao();
		netConfList=dao.getNetConf();
		if(!netConfList.isEmpty()){
			netConfInfo= netConfList.get(0);
		}	
		return "SUCCESS";
	}
	
}
