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
	String nonrecursive;
	List<DNSScanConf> dnsScanConfList;
	DNSScanConf dnsScanConfInfo;
//	String filePath="F:\\ScanDNSResolver\\DNSScanService\\bin\\Debug\\DNSManagerService.exe.config";
//	String filePath="D:\\dns_scan_app.config";
	String filePath1="C:\\ScanDNSResolver\\DNSScanService\\bin\\Debug\\DNSManagerService.exe.config";
	String filePath2="C:\\ControllerMonitor\\ControllerService\\bin\\Debug\\ControllerService.exe.config";
	String filePath3="C:\\ExtractFrequencyService\\ExtractFrequencyService.exe.config";
	String re;
	
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
		dao.updateParameter(id,DNSScanDBip,scannerIP,scanDefaultGwip,testDomainIp,DNSScanDBname,DNSScanDBuser,DNSScanDBpasswd,testDomain,packetRate,packetNum,outputDir,probeNum,extractNum,fakePort,ttl,maxIteration,resolverUpdate,resolverInterval,nonrecursive);
		
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath1));
			Pattern pattern0=Pattern.compile(".*ScanConnection.*");
			Pattern pattern1=Pattern.compile(".*<scannerConfig.*");
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中  
			while ((line = br.readLine()) != null) {
				Matcher matcher0 = pattern0.matcher(line);
				Matcher matcher1 = pattern1.matcher(line);
				if(matcher0.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<add name=\"ScanConnection\" connectionString=\"Data Source=").append(DNSScanDBip)
					.append(";Initial Catalog=").append(DNSScanDBname)
					.append(";User ID=").append(DNSScanDBuser)
					.append(";Password=").append(DNSScanDBpasswd)
					.append("\" providerName=\"System.Data.SqlClient\" />");
					buf.append(matcher0.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher1.matches()){
					StringBuffer btemp=new StringBuffer();
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
						.append("\"  nonrecursive=\"").append(nonrecursive)
						.append("\"/>");
						buf.append(matcher1.replaceAll(btemp.toString()));
						System.out.println(buf.toString());
				}else{
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
			write(filePath1,buf.toString()); 
			write(filePath2,buf.toString()); 
			write(filePath3,buf.toString()); 
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

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
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
	
	public String getNonrecursive() {
		return nonrecursive;
	}

	public void setNonrecursive(String nonrecursive) {
		this.nonrecursive = nonrecursive;
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




}
