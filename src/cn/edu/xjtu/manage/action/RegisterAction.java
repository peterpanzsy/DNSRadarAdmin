package cn.edu.xjtu.manage.action;

import java.util.List;

import cn.edu.xjtu.manage.business.User;
import cn.edu.xjtu.manage.dao.UserDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 用户注册
 *
 */
public class RegisterAction extends ActionSupport
{
	//static Logger log = Logger.getLogger(RegisterAction.class);
	
	private static final long serialVersionUID = 1364459201887429244L;
	private UserDao userDAO=new UserDao();
	private String errorMessage;
	private String username;
	private String regpassword;
	private String conpassword;
	private String email;
	private String info;
	private boolean userExists = false;//用户名是否存在
	private boolean login = false;//是否登录成功
	private boolean success;
	
	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String execute() throws Exception
	{
		//用户名存在
		Boolean flag = userDAO.findByUsername(username);
		//System.out.println(list.isEmpty());
		if (flag) 
		{
			errorMessage = "用户名" + username + "已经存在！请重新注册。";
			System.out.println(errorMessage);
			success = false;
			return SUCCESS;
		}
		
		if (username != null && !username.equals("")
				&& regpassword != null && !regpassword.equals(""))
		{
			if (regpassword.equals(conpassword))			
			{
				User user = new User(0,username,regpassword);
//				System.out.println("save()");
//				userDAO.save(user);
				userDAO.addUser(username, regpassword);
				ActionContext.getContext().getSession().put("user", user);
				login = true;
				success = true;
			}
			else 
			{
				errorMessage = "第一次输入的密码与第二次的不同。";
				System.out.println(errorMessage);
				success = false;
			}
		}
		else
		{
			errorMessage = "用户名或者密码不能为空。";
			success = false;
		}
		return SUCCESS;
	}

	public String isUserExist()
	{
		if (username == null || username.equals(""))
		{
			errorMessage = "用户名为空。";
			success = true;
			userExists = true;
			return SUCCESS;
		}
		Boolean flag = userDAO.findByUsername(username);
		if (flag) 
		{
			errorMessage = "用户名" + username + "已经存在！请重新填写用户名。";
			userExists = true;
			success = true;
			System.out.println(errorMessage);
			return SUCCESS;
		}
		userExists = false;;//可以注册
		success = true;
		login = false;
		return SUCCESS;
	}
	


	public void setUserDAO(UserDao userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getRegpassword()
	{
		return regpassword;
	}

	public void setRegpassword(String regpassword)
	{
		this.regpassword = regpassword;
	}

	public String getConpassword()
	{
		return conpassword;
	}

	public void setConpassword(String conpassword)
	{
		this.conpassword = conpassword;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isUserExists()
	{
		return userExists;
	}

	public void setUserExists(boolean userExists)
	{
		this.userExists = userExists;
	}

	public boolean isLogin()
	{
		return login;
	}

	public void setLogin(boolean login)
	{
		this.login = login;
	}
	
	

	
	
}
