package cn.edu.xjtu.manage.business;

public class DNSProbeConf {
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
	public DNSProbeConf(int id, String localIP, String gatewayIP,
			String localDNS, String pcapDir, String dns_result_db_ip,
			String dns_result_db_name, String dns_result_db_user,
			String dns_result_db_pass, String probe_record_db_ip,
			String probe_record_db_name, String probe_record_db_user,
			String probe_record_db_pass, String extractAveRateParameter_db_ip,
			String extractAveRateParameter_db_name,
			String extractAveRateParameter_db_user,
			String extractAveRateParameter_db_pass) {
		super();
		this.id = id;
		this.localIP = localIP;
		this.gatewayIP = gatewayIP;
		this.localDNS = localDNS;
		this.pcapDir = pcapDir;
		this.dns_result_db_ip = dns_result_db_ip;
		this.dns_result_db_name = dns_result_db_name;
		this.dns_result_db_user = dns_result_db_user;
		this.dns_result_db_pass = dns_result_db_pass;
		this.probe_record_db_ip = probe_record_db_ip;
		this.probe_record_db_name = probe_record_db_name;
		this.probe_record_db_user = probe_record_db_user;
		this.probe_record_db_pass = probe_record_db_pass;
		this.extractAveRateParameter_db_ip = extractAveRateParameter_db_ip;
		this.extractAveRateParameter_db_name = extractAveRateParameter_db_name;
		this.extractAveRateParameter_db_user = extractAveRateParameter_db_user;
		this.extractAveRateParameter_db_pass = extractAveRateParameter_db_pass;
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
	
	
}
