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

import cn.edu.xjtu.manage.business.AppConf;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.FTP;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.business.NetConf;
import cn.edu.xjtu.manage.dao.AppConfDao;
import cn.edu.xjtu.manage.dao.DBDao;
import cn.edu.xjtu.manage.dao.HoneyPotDao;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class AppConfAction  extends ActionSupport{
	int id;
	String radarDBip;
	String proberip;
	String defaultGwip;
	String localDNSip;
	String radarDBport;
	String radarDBname;	
	String radarDBuser;
	String radarDBpasswd;
	String fakePortBase;
	String processNumForDig;
	String digIteration;
	String maxSendRate;
	String maxTaskNum;
	String sendThreadNumByThousand;
	String EnableLog;
	String extractThreadNum;
	
	List<AppConf> appConfList;
	AppConf appConfInfo;
	String filePath="E:\\DNSRadarService\\DNSRadarService.exe.config";
//	String filePath="d:\\dns_prober_app.config";
	String re;
	

	public String getRe() {
		return re;
	}

	
	
/*	public String modifyNetconf(String filePath) {
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
	}*/
	
	public List<AppConf> getAppConfList() {
		return appConfList;
	}



	public void setAppConfList(List<AppConf> appConfList) {
		this.appConfList = appConfList;
	}



	public AppConf getAppConfInfo() {
		return appConfInfo;
	}



	public void setAppConfInfo(AppConf appConfInfo) {
		this.appConfInfo = appConfInfo;
	}



	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	

	public String updateAppConf(){
		AppConfDao dao=new AppConfDao();
		dao.updateParameter(id, radarDBip, proberip, defaultGwip, localDNSip, radarDBport, radarDBname, radarDBuser, radarDBpasswd, fakePortBase, processNumForDig, digIteration, maxSendRate, maxTaskNum, sendThreadNumByThousand, EnableLog, extractThreadNum);
		
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));
			Pattern pattern0 = Pattern.compile(".*connectionString=.*");
			Pattern pattern1 = Pattern.compile(".*<proberConfig.*");
//			Pattern pattern1 = Pattern.compile(".*proberIP=.*");
//			Pattern pattern2 = Pattern.compile(".*defaultGw=.*");
//			Pattern pattern3 = Pattern.compile(".*fakePortBase=.*");
//			Pattern pattern4 = Pattern.compile(".*localDNS=.*");
//			Pattern pattern5 = Pattern.compile(".*processNumForDig=.*");
//			Pattern pattern6 = Pattern.compile(".*digIteration=.*");
//			Pattern pattern7 = Pattern.compile(".*maxSendRate=.*");
//			Pattern pattern8 = Pattern.compile(".*maxTaskNum=.*");
//			Pattern pattern9 = Pattern.compile(".*sendThreadNumByThousand=.*");
//			Pattern pattern10 = Pattern.compile(".*EnableLog=.*");
//			Pattern pattern11 = Pattern.compile(".*extractThreadNum=.*");

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
			
				if(matcher0.matches()){
					StringBuffer btemp=new StringBuffer();
				/*	btemp.append("<add name=\"DNSProbe.Properties.Settings.ConnectionString\" connectionString=\"data source=(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=")
					.append(radarDBip).append(")(PORT=").append(radarDBport).append("))(CONNECT_DATA=(SERVICE_NAME=")
					.append(radarDBname).append(")));User ID=").append(radarDBuser).append(";password=&quot;").append(radarDBpasswd)
					.append("&quot;\" providerName=\"System.Data.OracleClient\" />");*/
					btemp.append("<add name=\"dns_result_form\" connectionString=\"server=").append(radarDBip)
					.append(";database=").append(radarDBname)
					.append(";user id=").append(radarDBuser)
					.append(";password=").append(radarDBpasswd)
					.append(";\" />");
					buf.append(matcher0.replaceAll(btemp.toString()));
					System.out.println(buf.toString());
				}else if(matcher1.matches()){
					StringBuffer btemp=new StringBuffer();
					btemp.append("<proberConfig proberIP=\"").append(proberip)
					.append("\" defaultGw=\"").append(defaultGwip)
					.append("\" fakePortBase=\"").append(fakePortBase)
					.append("\" localDNS=\"").append(localDNSip)
					.append("\" processNumForDig=\"").append(processNumForDig)
					.append("\" digIteration=\"").append(digIteration)
					.append("\" maxSendRate=\"").append(maxSendRate)
					.append("\" maxTaskNum=\"").append(maxTaskNum)
					.append("\" sendThreadNumByThousand=\"").append(sendThreadNumByThousand)
					.append("\" EnableLog=\"").append(EnableLog)
					.append("\" extractThreadNum=\"").append(extractThreadNum)
					.append("\"/>");
					buf.append(matcher1.replaceAll(btemp.toString()));
				}else{
					buf.append(line);
				}
//				}else if(matcher1.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("proberIP=\"").append(proberip).append("\"");
//					buf.append(matcher1.replaceAll(btemp.toString()));
//				}else if(matcher2.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("defaultGw=\"").append(defaultGwip).append("\"");
//					buf.append(matcher2.replaceAll(btemp.toString()));
//				}else if(matcher3.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("fakePortBase=\"").append(fakePortBase).append("\"");
//					buf.append(matcher3.replaceAll(btemp.toString()));
//				}else if(matcher4.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("localDNS=\"").append(localDNSip).append("\"");
//					buf.append(matcher4.replaceAll(btemp.toString()));
//				}else if(matcher5.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("processNumForDig=\"").append(processNumForDig).append("\"");
//					buf.append(matcher5.replaceAll(btemp.toString()));
//				}else if(matcher6.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("digIteration=\"").append(digIteration).append("\"");
//					buf.append(matcher6.replaceAll(btemp.toString()));
//				}else if(matcher7.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("maxSendRate=\"").append(maxSendRate).append("\"");
//					buf.append(matcher7.replaceAll(btemp.toString()));
//				}else if(matcher8.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("maxTaskNum=\"").append(maxTaskNum).append("\"");
//					buf.append(matcher8.replaceAll(btemp.toString()));
//				}else if(matcher9.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("sendThreadNumByThousand=\"").append(sendThreadNumByThousand).append("\"");
//					buf.append(matcher9.replaceAll(btemp.toString()));
//				}else if(matcher10.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("EnableLog=\"").append(EnableLog).append("\"");
//					buf.append(matcher10.replaceAll(btemp.toString()));
//				}else if(matcher11.matches()){
//					StringBuffer btemp=new StringBuffer();
//					btemp.append("extractThreadNum=\"").append(extractThreadNum).append("\"");
//					buf.append(matcher11.replaceAll(btemp.toString()));
				
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
		new AppConfAction().updateAppConf();
	}

	public String getAppConf(){
		AppConfDao dao=new AppConfDao();
		appConfList=dao.getParameter();
		if(!appConfList.isEmpty()){
			appConfInfo= appConfList.get(0);
		}	
		return "SUCCESS";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getRadarDBip() {
		return radarDBip;
	}



	public void setRadarDBip(String radarDBip) {
		this.radarDBip = radarDBip;
	}



	public String getProberip() {
		return proberip;
	}



	public void setProberip(String proberip) {
		this.proberip = proberip;
	}



	public String getDefaultGwip() {
		return defaultGwip;
	}



	public void setDefaultGwip(String defaultGwip) {
		this.defaultGwip = defaultGwip;
	}



	public String getLocalDNSip() {
		return localDNSip;
	}



	public void setLocalDNSip(String localDNSip) {
		this.localDNSip = localDNSip;
	}



	public String getRadarDBport() {
		return radarDBport;
	}



	public void setRadarDBport(String radarDBport) {
		this.radarDBport = radarDBport;
	}



	public String getRadarDBname() {
		return radarDBname;
	}



	public void setRadarDBname(String radarDBname) {
		this.radarDBname = radarDBname;
	}



	public String getRadarDBuser() {
		return radarDBuser;
	}



	public void setRadarDBuser(String radarDBuser) {
		this.radarDBuser = radarDBuser;
	}



	public String getRadarDBpasswd() {
		return radarDBpasswd;
	}



	public void setRadarDBpasswd(String radarDBpasswd) {
		this.radarDBpasswd = radarDBpasswd;
	}



	public String getFakePortBase() {
		return fakePortBase;
	}



	public void setFakePortBase(String fakePortBase) {
		this.fakePortBase = fakePortBase;
	}



	public String getProcessNumForDig() {
		return processNumForDig;
	}



	public void setProcessNumForDig(String processNumForDig) {
		this.processNumForDig = processNumForDig;
	}



	public String getDigIteration() {
		return digIteration;
	}



	public void setDigIteration(String digIteration) {
		this.digIteration = digIteration;
	}



	public String getMaxSendRate() {
		return maxSendRate;
	}



	public void setMaxSendRate(String maxSendRate) {
		this.maxSendRate = maxSendRate;
	}



	public String getMaxTaskNum() {
		return maxTaskNum;
	}



	public void setMaxTaskNum(String maxTaskNum) {
		this.maxTaskNum = maxTaskNum;
	}



	public String getSendThreadNumByThousand() {
		return sendThreadNumByThousand;
	}



	public void setSendThreadNumByThousand(String sendThreadNumByThousand) {
		this.sendThreadNumByThousand = sendThreadNumByThousand;
	}



	public String getEnableLog() {
		return EnableLog;
	}



	public void setEnableLog(String enableLog) {
		EnableLog = enableLog;
	}



	public String getExtractThreadNum() {
		return extractThreadNum;
	}



	public void setExtractThreadNum(String extractThreadNum) {
		this.extractThreadNum = extractThreadNum;
	}
	
}
