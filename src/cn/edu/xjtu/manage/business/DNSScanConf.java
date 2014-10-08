package cn.edu.xjtu.manage.business;

public class DNSScanConf {
	int id;
	String DNSScanDBip;
	String scannerIP;
	String scanDefaultGwip;
	String testDomainIp;	
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
	
	
	public DNSScanConf(int id, String dNSScanDBip, String scannerIP,
			String scanDefaultGwip, String testDomainIp, String dNSScanDBname,
			String dNSScanDBuser, String dNSScanDBpasswd, String testDomain,
			String packetRate, String packetNum, String outputDir,
			String probeNum, String extractNum, String fakePort, String ttl,
			String maxIteration, String resolverUpdate, String resolverInterval) {
		super();
		this.id = id;
		DNSScanDBip = dNSScanDBip;
		this.scannerIP = scannerIP;
		this.scanDefaultGwip = scanDefaultGwip;
		this.testDomainIp = testDomainIp;
		DNSScanDBname = dNSScanDBname;
		DNSScanDBuser = dNSScanDBuser;
		DNSScanDBpasswd = dNSScanDBpasswd;
		this.testDomain = testDomain;
		this.packetRate = packetRate;
		this.packetNum = packetNum;
		this.outputDir = outputDir;
		this.probeNum = probeNum;
		this.extractNum = extractNum;
		this.fakePort = fakePort;
		this.ttl = ttl;
		this.maxIteration = maxIteration;
		this.resolverUpdate = resolverUpdate;
		this.resolverInterval = resolverInterval;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
