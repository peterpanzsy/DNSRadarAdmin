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
import cn.edu.xjtu.manage.dao.DNSScanConfDao;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DNSScanConfAction  extends ActionSupport{
	int id;
	String DNSScanDBip;
	String scannerIP;
	String scanDefaultGwip;
	String testDomainIp;
	String radarDBport;
	String DNSScanDBname;	
	String DNSScanDBuser;
	String DNSScanDBpasswd;
	String testDomain;
	String packetRate;
	String packetNum;
	String outputDir;
	String probeNum;
	String extractNum;
	String fakePort;
	String ttl;
	String maxIteration;
	String resolverUpdate;
	String resolverInterval;
	List<DNSScanConf> dnsScanConfList;
	DNSScanConf dnsScanConfInfo;
	String filePath="F:\\ScanDNSResolver\\DNSScanService\\bin\\Debug\\DNSManagerService.exe.config";
//	String filePath="D:\\dns_scan_app.config";

	String re;
	

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDNSScanDBip() {
		return DNSScanDBip;
	}

	public void setDNSScanDBip(String dNSScanDBip) {
		DNSScanDBip = dNSScanDBip;
	}

	public String getScannerIP() {
		return scannerIP;
	}

	public void setScannerIP(String scannerIP) {
		this.scannerIP = scannerIP;
	}

	public String getScanDefaultGwip() {
		return scanDefaultGwip;
	}

	public void setScanDefaultGwip(String scanDefaultGwip) {
		this.scanDefaultGwip = scanDefaultGwip;
	}

	public String getTestDomainIp() {
		return testDomainIp;
	}

	public void setTestDomainIp(String testDomainIp) {
		this.testDomainIp = testDomainIp;
	}

	public String getRadarDBport() {
		return radarDBport;
	}

	public void setRadarDBport(String radarDBport) {
		this.radarDBport = radarDBport;
	}

	public String getDNSScanDBname() {
		return DNSScanDBname;
	}

	public void setDNSScanDBname(String dNSScanDBname) {
		DNSScanDBname = dNSScanDBname;
	}

	public String getDNSScanDBuser() {
		return DNSScanDBuser;
	}

	public void setDNSScanDBuser(String dNSScanDBuser) {
		DNSScanDBuser = dNSScanDBuser;
	}

	public String getDNSScanDBpasswd() {
		return DNSScanDBpasswd;
	}

	public void setDNSScanDBpasswd(String dNSScanDBpasswd) {
		DNSScanDBpasswd = dNSScanDBpasswd;
	}

	public String getTestDomain() {
		return testDomain;
	}

	public void setTestDomain(String testDomain) {
		this.testDomain = testDomain;
	}

	public String getPacketRate() {
		return packetRate;
	}

	public void setPacketRate(String packetRate) {
		this.packetRate = packetRate;
	}

	public String getPacketNum() {
		return packetNum;
	}

	public void setPacketNum(String packetNum) {
		this.packetNum = packetNum;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public String getProbeNum() {
		return probeNum;
	}

	public void setProbeNum(String probeNum) {
		this.probeNum = probeNum;
	}

	public String getExtractNum() {
		return extractNum;
	}

	public void setExtractNum(String extractNum) {
		this.extractNum = extractNum;
	}

	public String getFakePort() {
		return fakePort;
	}

	public void setFakePort(String fakePort) {
		this.fakePort = fakePort;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getMaxIteration() {
		return maxIteration;
	}

	public void setMaxIteration(String maxIteration) {
		this.maxIteration = maxIteration;
	}
	
	public String getResolverUpdate() {
		return resolverUpdate;
	}

	public void setResolverUpdate(String resolverUpdate) {
		this.resolverUpdate = resolverUpdate;
	}

	public String getResolverInterval() {
		return resolverInterval;
	}

	public void setResolverInterval(String resolverInterval) {
		this.resolverInterval = resolverInterval;
	}

	public List<DNSScanConf> getDnsScanConfList() {
		return dnsScanConfList;
	}

	public void setDnsScanConfList(List<DNSScanConf> dnsScanConfList) {
		this.dnsScanConfList = dnsScanConfList;
	}

	public DNSScanConf getDnsScanConfInfo() {
		return dnsScanConfInfo;
	}

	public void setDnsScanConfInfo(DNSScanConf dnsScanConfInfo) {
		this.dnsScanConfInfo = dnsScanConfInfo;
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
	

	public String updateDNSScanConf(){
		DNSScanConfDao dao=new DNSScanConfDao();
		dao.updateParameter(id,DNSScanDBip,scannerIP,scanDefaultGwip,testDomainIp,DNSScanDBname,DNSScanDBuser,DNSScanDBpasswd,testDomain,packetRate,packetNum,outputDir,probeNum,extractNum,fakePort,ttl,maxIteration,resolverUpdate,resolverInterval);
		
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));
			Pattern pattern0=Pattern.compile(".*ScanConnection.*");
			Pattern pattern1=Pattern.compile(".*<scannerConfig.*");
//			Pattern pattern0 = Pattern.compile(".*ScanInputConnection.*");
//			Pattern pattern1 = Pattern.compile(".*scannerIP.*");
//			Pattern pattern2 = Pattern.compile(".*defaultGw.*");
//			Pattern pattern3 = Pattern.compile(".*testDomain=.*");
//			Pattern pattern4 = Pattern.compile(".*testDomainIp.*");
//			Pattern pattern5 = Pattern.compile(".*packetRate.*");
//			Pattern pattern6 = Pattern.compile(".*packetNum.*");
//			Pattern pattern7 = Pattern.compile(".*outputDir.*");
//			Pattern pattern8 = Pattern.compile(".*probeNum.*");
//			Pattern pattern9 = Pattern.compile(".*extractNum.*");
//			Pattern pattern10 = Pattern.compile(".*fakePort.*");
//			Pattern pattern11 = Pattern.compile(".*ttl.*");
//			Pattern pattern12 = Pattern.compile(".*maxIteration.*");
//			Pattern pattern13 = Pattern.compile(".*ScanResultConnection.*");
			
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				Matcher matcher0 = pattern0.matcher(line);
				Matcher matcher1 = pattern1.matcher(line);
//				Matcher matcher2 = pattern2.matcher(line);
//				Matcher matcher3 = pattern3.matcher(line);
//				Matcher matcher4 = pattern4.matcher(line);
//				Matcher matcher5 = pattern5.matcher(line);
//				Matcher matcher6 = pattern6.matcher(line);
//				Matcher matcher7 = pattern7.matcher(line);
//				Matcher matcher8 = pattern8.matcher(line);
//				Matcher matcher9 = pattern9.matcher(line);
//				Matcher matcher10 = pattern10.matcher(line);
//				Matcher matcher11 = pattern11.matcher(line);
//				Matcher matcher12 = pattern12.matcher(line);
//				Matcher matcher13 = pattern13.matcher(line);
				
				if(matcher0.matches()){
					StringBuffer btemp=new StringBuffer();
				/*	btemp.append("<add name=\"DNSProbe.Properties.Settings.ConnectionString\" connectionString=\"data source=(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=")
					.append(radarDBip).append(")(PORT=").append(radarDBport).append("))(CONNECT_DATA=(SERVICE_NAME=")
					.append(DNSScanDBname).append(")));User ID=").append(DNSScanDBuser).append(";password=&quot;").append(DNSScanDBpasswd)
					.append("&quot;\" providerName=\"System.Data.OracleClient\" />");*/
					btemp.append("<add name=\"ScanInputConnection\" connectionString=\"Data Source=").append(DNSScanDBip)
					.append(";Initial Catalog=").append(DNSScanDBname)
					.append(";User ID=").append(DNSScanDBuser)
					.append(";Password=").append(DNSScanDBpasswd)
					.append("\" providerName=\"System.Data.SqlClient\" />");
					buf.append(matcher0.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher1.matches()){
					StringBuffer btemp=new StringBuffer();
					/*	btemp.append("<add name=\"DNSProbe.Properties.Settings.ConnectionString\" connectionString=\"data source=(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=")
						.append(radarDBip).append(")(PORT=").append(radarDBport).append("))(CONNECT_DATA=(SERVICE_NAME=")
						.append(DNSScanDBname).append(")));User ID=").append(DNSScanDBuser).append(";password=&quot;").append(DNSScanDBpasswd)
						.append("&quot;\" providerName=\"System.Data.OracleClient\" />");*/
						btemp.append("<scannerConfig  scannerIP=\"").append(scannerIP)
						.append("\"  defaultGw=\"").append(scanDefaultGwip)
						.append("\" testDomain=\"").append(testDomain)
						.append("\" testDomainIp=\"").append(testDomainIp)
						.append("\"  packetRate=\"").append(packetRate)
						.append("\"  packetNum=\"").append(packetNum)
						.append("\" outputDir=\"").append(outputDir)
						.append("\" probeNum=\"").append(probeNum)
						.append("\"  extractNum=\"").append(extractNum)
						.append("\"  fakePort=\"").append(fakePort)
						.append("\" ttl=\"").append(ttl)
						.append("\"  maxIteration=\"").append(maxIteration)
						.append("\"  resolverUpdate=\"").append(resolverUpdate)
						.append("\"  resolverInterval=\"").append(resolverInterval)
						.append("\"/>");
						buf.append(matcher1.replaceAll(btemp.toString()));
						System.out.println(buf.toString());
				}else{
					buf.append(line);
				}
//				}else if(matcher13.matches()){
//					StringBuffer btemp=new StringBuffer();					
//					btemp.append("<add name=\"ScanResultConnection\" connectionString=\"Data Source=").append(DNSScanDBip)
//					.append(";Initial Catalog=").append(DNSScanDBname)
//					.append(";User ID=").append(DNSScanDBuser)
//					.append(";Password=").append(DNSScanDBpasswd)
//					.append("\" providerName=\"System.Data.SqlClient\" />");
//					buf.append(matcher13.replaceAll(btemp.toString()));
//					System.out.println(buf.toString());
//				}else if(matcher1.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("scannerIP=\"").append(scannerIP).append("\"");
//					buf.append(matcher1.replaceAll(btemp.toString()));
//				}else if(matcher2.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("defaultGw=\"").append(scanDefaultGwip).append("\"");
//					buf.append(matcher2.replaceAll(btemp.toString()));
//				}else if(matcher3.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("testDomain=\"").append(testDomain).append("\"");
//					buf.append(matcher3.replaceAll(btemp.toString()));
//				}else if(matcher4.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("testDomainIp=\"").append(testDomainIp).append("\"");
//					buf.append(matcher4.replaceAll(btemp.toString()));
//				}else if(matcher5.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("packetRate=\"").append(packetRate).append("\"");
//					buf.append(matcher5.replaceAll(btemp.toString()));
//				}else if(matcher6.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("packetNum=\"").append(packetNum).append("\"");
//					buf.append(matcher6.replaceAll(btemp.toString()));
//				}else if(matcher7.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("outputDir=\"").append(outputDir).append("\"");
//					buf.append(matcher7.replaceAll(btemp.toString()));
//				}else if(matcher8.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("probeNum=\"").append(probeNum).append("\"");
//					buf.append(matcher8.replaceAll(btemp.toString()));
//				}else if(matcher9.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("extractNum=\"").append(extractNum).append("\"");
//					buf.append(matcher9.replaceAll(btemp.toString()));
//				}else if(matcher10.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("fakePort=\"").append(fakePort).append("\"");
//					buf.append(matcher10.replaceAll(btemp.toString()));
//				}else if(matcher11.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("ttl=\"").append(ttl).append("\"");
//					buf.append(matcher11.replaceAll(btemp.toString()));
//				}else if(matcher12.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("maxIteration=\"").append(maxIteration).append("\"");
//					buf.append(matcher12.replaceAll(btemp.toString()));
				
				buf.append(System.getProperty("line.separator"));
			}
			write(filePath,buf.toString()); // 读取修改文件	
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
		new DNSScanConfAction().updateDNSScanConf();
	}

	public String getDNSScanConf(){
		DNSScanConfDao dao=new DNSScanConfDao();
		dnsScanConfList=dao.getParameter();
		if(!dnsScanConfList.isEmpty()){
			dnsScanConfInfo= dnsScanConfList.get(0);
		}	
		return "SUCCESS";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}





}
