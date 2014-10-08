package cn.edu.xjtu.manage.business;

public class AppConf {
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
	
	public AppConf(int id, String radarDBip, String proberip,
			String defaultGwip, String localDNSip, String radarDBport,
			String radarDBname, String radarDBuser, String radarDBpasswd,
			String fakePortBase, String processNumForDig, String digIteration,
			String maxSendRate, String maxTaskNum,
			String sendThreadNumByThousand, String enableLog,
			String extractThreadNum) {
		super();
		this.id = id;
		this.radarDBip = radarDBip;
		this.proberip = proberip;
		this.defaultGwip = defaultGwip;
		this.localDNSip = localDNSip;
		this.radarDBport = radarDBport;
		this.radarDBname = radarDBname;
		this.radarDBuser = radarDBuser;
		this.radarDBpasswd = radarDBpasswd;
		this.fakePortBase = fakePortBase;
		this.processNumForDig = processNumForDig;
		this.digIteration = digIteration;
		this.maxSendRate = maxSendRate;
		this.maxTaskNum = maxTaskNum;
		this.sendThreadNumByThousand = sendThreadNumByThousand;
		EnableLog = enableLog;
		this.extractThreadNum = extractThreadNum;
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
