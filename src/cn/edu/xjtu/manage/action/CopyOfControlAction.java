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

public class CopyOfControlAction  extends ActionSupport{


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
	
	public String restart(){
		try {
//			int res=JavaShellUtil.executeShell("/botwall/script/control restart");
		/*	String[] cmd1 = new String[]{"/bin/sh","-c","cd","/botwall/script/"};
			Process p1=Runtime.getRuntime().exec(cmd1);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			*/
//			String[] cmd = new String[]{"/bin/sh","-c","/botwall/script/controlRight.sh"};
			Process p=Runtime.getRuntime().exec("sh /botwall/script/controlRight.sh");
			/*BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String line;
		
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			exeResult = sb.toString();
			System.out.println(exeResult);	*/		
			pid=p.toString();
			System.out.println("control restart");
	/*		try{
	            if(p.waitFor() == 0){  //其中p.waitFor()语句用来等待子进程结束，其返回值为进程结束退出码。
	                System.out.println("controlRestart result is OK!");
	            }else{
	                System.out.println("controlRestart result is fail......");
	            }
	        }catch(InterruptedException e){
	            System.err.println("processes was interrupted");
	        }
	        int ret =p.exitValue();
	        System.out.println(ret);*/
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
