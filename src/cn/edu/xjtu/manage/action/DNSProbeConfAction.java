package cn.edu.xjtu.manage.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.xjtu.manage.business.DNSScanConf;
import cn.edu.xjtu.manage.business.DNSProbeConf;
import cn.edu.xjtu.manage.dao.DNSProbeConfDao;
import cn.edu.xjtu.manage.dao.DNSScanConfDao;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DNSProbeConfAction  extends ActionSupport{
	int id;
	String localIP;
	String gatewayIP;
	String localDNS;
	String pcapDir;
	String dns_result_db_ip;
	String dns_result_db_name;
	String dns_result_db_user;
	String dns_result_db_pass;
	String probe_record_db_ip;
	String probe_record_db_name;
	String probe_record_db_user;
	String probe_record_db_pass;
	String extractAveRateParameter_db_ip;
	String extractAveRateParameter_db_name;
	String extractAveRateParameter_db_user;
	String extractAveRateParameter_db_pass;
	
	List<DNSProbeConf> dnsProbeConfList;
	DNSProbeConf dnsProbeConfInfo;
//	String filePath="F:\\ScanDNSResolver\\DNSScanService\\bin\\Debug\\DNSManagerService.exe.config";
	String filePath0="D:\\EagleEye\\EagleEyeService\\EagleEyeService.exe.config";
	String filePath1="D:\\EagleEye\\UpdateRankingService\\UpdateRankingService.exe.config";
	String filePath2="D:\\EagleEye\\ScalePredic\\ScalePredict.exe.config";
	String re;

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
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
	

	public String updateDNSProbeConf(){
		DNSProbeConfDao dao=new DNSProbeConfDao();
		dao.updateParameter(id,localIP,gatewayIP,localDNS,
				dns_result_db_ip,dns_result_db_name,dns_result_db_user,dns_result_db_pass,
				probe_record_db_ip,probe_record_db_name,probe_record_db_user,probe_record_db_pass,
				extractAveRateParameter_db_ip,extractAveRateParameter_db_name,extractAveRateParameter_db_user,extractAveRateParameter_db_pass);
		
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath0));
			Pattern pattern0=Pattern.compile(".*LocalIP.*");
			Pattern pattern1=Pattern.compile(".*GatewayIP.*");
			Pattern pattern2=Pattern.compile(".*LocalDNS.*");
			Pattern pattern3=Pattern.compile(".*dns_result_form.*");
			Pattern pattern4=Pattern.compile(".*ProbeRecordConnectionString.*");
			Pattern pattern5=Pattern.compile(".*ExtractAveRateParameter.*");
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				Matcher matcher0 = pattern0.matcher(line);
				Matcher matcher1 = pattern1.matcher(line);
				Matcher matcher2 = pattern2.matcher(line);
				Matcher matcher3 = pattern3.matcher(line);
				Matcher matcher4 = pattern4.matcher(line);
				Matcher matcher5 = pattern5.matcher(line);
				if(matcher0.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add key =\"LocalIP\" value=\"").append(localIP).append("\"/>");
					buf.append(matcher0.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher1.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add key =\"GatewayIP\" value=\"").append(gatewayIP).append("\"/>");
					buf.append(matcher1.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher2.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add key =\"LocalDNS\" value=\"").append(localDNS).append("\"/>");
					buf.append(matcher2.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher3.matches()){
					StringBuffer btemp=new StringBuffer();
						btemp.append("<add name=\"dns_result_form\" connectionString=\"server=").append(dns_result_db_ip)
						.append(";database=").append(dns_result_db_name)
						.append(";userid=").append(dns_result_db_user)
						.append(";password=").append(dns_result_db_pass)
						.append(";\"/>");
						buf.append(matcher3.replaceAll(btemp.toString()));
						System.out.println(buf.toString());
				}else if(matcher4.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add name=\"ProbeRecordConnectionString\" connectionString=\"Data Source=").append(probe_record_db_ip)
					.append(";InitialCatalog=").append(probe_record_db_name)
					.append(";UserID=").append(probe_record_db_user)
					.append(";Password=").append(probe_record_db_pass)
					.append("\" providerName=\"System.Data.SqlClient\"/>");
					buf.append(matcher4.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
			    }else if(matcher5.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add name=\"ExtractAveRateParameter\" connectionString=\"Data Source=").append(extractAveRateParameter_db_ip)
					.append(";Initial Catalog=").append(extractAveRateParameter_db_name)
					.append(";UserID=").append(extractAveRateParameter_db_user)
					.append(";Password=").append(extractAveRateParameter_db_pass)
					.append("\" providerName=\"System.Data.SqlClient\"/>");
					buf.append(matcher5.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
			    }else{
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
			write(filePath0,buf.toString()); // 读取修改文件
			write(filePath1,buf.toString());
			write(filePath2,buf.toString());
			re="success";
		} catch (Exception e) {
			e.printStackTrace();
			re="failure";
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
		return "SUCCESS"; 
	}
	public static void main(String args[]){
		new DNSProbeConfAction().updateDNSProbeConf();
	}

	public String getDNSProbeConf(){
		DNSProbeConfDao dao=new DNSProbeConfDao();
		dnsProbeConfList=dao.getParameter();
		if(!dnsProbeConfList.isEmpty()){
			dnsProbeConfInfo= dnsProbeConfList.get(0);
		}	
		return "SUCCESS";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalIP() {
		return localIP;
	}

	public void setLocalIP(String localIP) {
		this.localIP = localIP;
	}

	public String getGatewayIP() {
		return gatewayIP;
	}

	public void setGatewayIP(String gatewayIP) {
		this.gatewayIP = gatewayIP;
	}

	public String getLocalDNS() {
		return localDNS;
	}

	public void setLocalDNS(String localDNS) {
		this.localDNS = localDNS;
	}

	public String getPcapDir() {
		return pcapDir;
	}

	public void setPcapDir(String pcapDir) {
		this.pcapDir = pcapDir;
	}

	public String getDns_result_db_ip() {
		return dns_result_db_ip;
	}

	public void setDns_result_db_ip(String dns_result_db_ip) {
		this.dns_result_db_ip = dns_result_db_ip;
	}

	public String getDns_result_db_name() {
		return dns_result_db_name;
	}

	public void setDns_result_db_name(String dns_result_db_name) {
		this.dns_result_db_name = dns_result_db_name;
	}

	public String getDns_result_db_user() {
		return dns_result_db_user;
	}

	public void setDns_result_db_user(String dns_result_db_user) {
		this.dns_result_db_user = dns_result_db_user;
	}

	public String getDns_result_db_pass() {
		return dns_result_db_pass;
	}

	public void setDns_result_db_pass(String dns_result_db_pass) {
		this.dns_result_db_pass = dns_result_db_pass;
	}

	public String getProbe_record_db_ip() {
		return probe_record_db_ip;
	}

	public void setProbe_record_db_ip(String probe_record_db_ip) {
		this.probe_record_db_ip = probe_record_db_ip;
	}

	public String getProbe_record_db_name() {
		return probe_record_db_name;
	}

	public void setProbe_record_db_name(String probe_record_db_name) {
		this.probe_record_db_name = probe_record_db_name;
	}

	public String getProbe_record_db_user() {
		return probe_record_db_user;
	}

	public void setProbe_record_db_user(String probe_record_db_user) {
		this.probe_record_db_user = probe_record_db_user;
	}

	public String getProbe_record_db_pass() {
		return probe_record_db_pass;
	}

	public void setProbe_record_db_pass(String probe_record_db_pass) {
		this.probe_record_db_pass = probe_record_db_pass;
	}

	public String getExtractAveRateParameter_db_ip() {
		return extractAveRateParameter_db_ip;
	}

	public void setExtractAveRateParameter_db_ip(
			String extractAveRateParameter_db_ip) {
		this.extractAveRateParameter_db_ip = extractAveRateParameter_db_ip;
	}

	public String getExtractAveRateParameter_db_name() {
		return extractAveRateParameter_db_name;
	}

	public void setExtractAveRateParameter_db_name(
			String extractAveRateParameter_db_name) {
		this.extractAveRateParameter_db_name = extractAveRateParameter_db_name;
	}

	public String getExtractAveRateParameter_db_user() {
		return extractAveRateParameter_db_user;
	}

	public void setExtractAveRateParameter_db_user(
			String extractAveRateParameter_db_user) {
		this.extractAveRateParameter_db_user = extractAveRateParameter_db_user;
	}

	public String getExtractAveRateParameter_db_pass() {
		return extractAveRateParameter_db_pass;
	}

	public void setExtractAveRateParameter_db_pass(
			String extractAveRateParameter_db_pass) {
		this.extractAveRateParameter_db_pass = extractAveRateParameter_db_pass;
	}

	public DNSProbeConf getDnsProbeConfInfo() {
		return dnsProbeConfInfo;
	}

	public void setDnsProbeConfInfo(DNSProbeConf dnsProbeConfInfo) {
		this.dnsProbeConfInfo = dnsProbeConfInfo;
	}
	
}
