package cn.edu.xjtu.manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xjtu.manage.business.User;
import cn.edu.xjtu.manage.dao.HoneyPotDao;
import cn.edu.xjtu.manage.dao.UserDao;

public class UserAction extends ActionSupport{
	String  username;
	String password;
	String type;
	UserDao userDAO;
	List<User> dataList;
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<User> getDataList() {
		return dataList;
	}
	public void setDataList(List<User> dataList) {
		this.dataList = dataList;
	}
	public UserDao getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDao userDAO) {
		this.userDAO = userDAO;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String list(){		
		UserDao dao=new UserDao();
		dataList=dao.getUserList();
		return "SUCCESS";
	}
	public String update(){
		UserDao dao=new UserDao();
		dao.updateUser(username, password);
		return "SUCCESS";
	}
	
	public String delete(){
		UserDao dao=new UserDao();
		if(!ids.isEmpty()){

			for(int id:ids){
				dao.deleteUser(id);
			}
		}
		dao.commit();
		return "SUCCESS";
	}
	
	
}
