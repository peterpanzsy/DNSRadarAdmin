package cn.edu.xjtu.manage.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ControlAction  extends ActionSupport{


	String re;
	String pid;
	String exeResult;
	
	public void setExeResult(String exeResult) {
		this.exeResult = exeResult;
	}
	public String getExeResult() {
		return exeResult;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRe() {
		return re;
	}

	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	public String execute(){
	
		return "SUCCESS";
	}
	
	public String restartWindows(){
		try {

			Process p=Runtime.getRuntime().exec("shutdown -r -t 5");
			pid=p.toString();
			System.out.println("windows restart");
			re="success";	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exeResult=e.toString();
			re="failure";
		}
		return "SUCCESS"; 
	}
	
	public String restart(){
		try {
			Process p=Runtime.getRuntime().exec("net stop DNSScanService");
			p=Runtime.getRuntime().exec("net start DNSScanService");
			p=Runtime.getRuntime().exec("net stop DNSRadarService");
			p=Runtime.getRuntime().exec("net start DNSRadarService");
			p=Runtime.getRuntime().exec("java -jar E:\\CheckLicenseWin_Scan.jar");
			pid=p.toString();
			System.out.println("control restart");
			re="success";	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exeResult=e.toString();
			re="failure";
		}
		return "SUCCESS"; 
	}
	
}
