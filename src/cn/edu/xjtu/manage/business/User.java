package cn.edu.xjtu.manage.business;

import javax.persistence.Column;
import javax.persistence.Entity;

// default package



@Entity
public class User  implements java.io.Serializable {


    // Fields    

     private int userid;
     private String username;
     private String password;
//     private int usergroupid;
//     private String email;
//     private int state;
//     private String info;


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(int userid) {
        this.userid = userid;
    }
    
    /** full constructor */
    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
//        this.usergroupid = usergroupid;
//        this.email = email;
//        this.state = state;
//        this.info = info;
    }

   
    // Property accessors
    @Column
    public int getUserid() {
        return this.userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    @Column
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
//    @Column
//    public int getUsergroupid() {
//        return this.usergroupid;
//    }
//    
//    public void setUsergroupid(int usergroupid) {
//        this.usergroupid = usergroupid;
//    }
//    
//    @Column
//    public String getEmail() {
//        return this.email;
//    }
//    
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    
//    @Column
//    public int getState() {
//        return this.state;
//    }
//    
//    public void setState(int state) {
//        this.state = state;
//    }
//    
//    @Column
//    public String getInfo() {
//        return this.info;
//    }
//    
//    public void setInfo(String info) {
//        this.info = info;
//    }
   








}