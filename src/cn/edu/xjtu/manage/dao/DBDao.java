package cn.edu.xjtu.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.FTP;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.business.NetConf;


public class DBDao {

	public int updateDB(int id, String ip, String dbport,String dbname, String dbuser,String dbpasswd) {
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_dbinfo (db_ip,db_port,db_name,db_user,db_passwd) values (?,?,?,?,?)");
			q.setParameter(0, ip);
			q.setParameter(1, dbport);
			q.setParameter(2, dbname);
			q.setParameter(3, dbuser);
			q.setParameter(4, dbpasswd);
			int result=q.executeUpdate();
			tx.commit();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_dbinfo t set db_ip=?,db_port=?,db_name=?,db_user=?,db_passwd=? where t.ID=?");
			q.setParameter(0, ip);
			q.setParameter(1, dbport);
			q.setParameter(2, dbname);
			q.setParameter(3, dbuser);
			q.setParameter(4, dbpasswd);
			q.setParameter(5, id);
			int re=q.executeUpdate();
			tx.commit();
			return re;
		}
	}
	
	public List<DB> getDB() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.db_ip,t.db_port,t.db_name,t.db_user,t.db_passwd FROM t_dbinfo t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<DB> re=new ArrayList<DB>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  String dbport=(String)row[2];
			  String dbname=(String)row[3];
			  String dbuser=(String)row[4];
			  String dbpasswd=(String)row[5];			
			  DB pot=new DB(id, ip,dbport,dbname,dbuser,dbpasswd);	 
			  re.add(pot);
		}
		return re;
	}
	
	public int updateFTP(int id, String ip, String dbport, String dbuser,String dbpasswd) {
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_ftpinfo (ip,port,user,passwd) values (?,?,?,?)");
			q.setParameter(0, ip);
			q.setParameter(1, dbport);
			q.setParameter(2, dbuser);
			q.setParameter(3, dbpasswd);
			int result=q.executeUpdate();
			tx.commit();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_ftpinfo t set ip=?,port=?,user=?,passwd=? where t.ID=?");
			q.setParameter(0, ip);
			q.setParameter(1, dbport);
			q.setParameter(2, dbuser);
			q.setParameter(3, dbpasswd);
			q.setParameter(4, id);
			int re=q.executeUpdate();
			tx.commit();
			return re;
		}
	}
	
	public List<FTP> getFTP() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.ip,t.port,t.user,t.passwd FROM t_ftpinfo t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<FTP> re=new ArrayList<FTP>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  String port=(String)row[2];
			  String user=(String)row[3];
			  String passwd=(String)row[4];			
			  FTP ftp=new FTP(id, ip,port,user,passwd);	 
			  re.add(ftp);
		}
		return re;
	}
	
	public int updateNetConf(int id, String netip, String maskip, String gateip,String dns1ip,String dns2ip) {
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_netconfinfo (netip,maskip,gateip,dns1ip,dns2ip) values (?,?,?,?,?)");
			q.setParameter(0, netip);
			q.setParameter(1, maskip);
			q.setParameter(2, gateip);
			q.setParameter(3, dns1ip);
			q.setParameter(4,dns2ip);
			int result=q.executeUpdate();
			tx.commit();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_netconfinfo t set netip=?,maskip=?,gateip=?,dns1ip=?,dns2ip=? where t.ID=?");
			q.setParameter(0, netip);
			q.setParameter(1, maskip);
			q.setParameter(2, gateip);
			q.setParameter(3, dns1ip);
			q.setParameter(4,dns2ip);
			q.setParameter(5, id);
			int re=q.executeUpdate();
			tx.commit();
			return re;
		}
	}
	
	public List<NetConf> getNetConf() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.netip,t.maskip,t.gateip,t.dns1ip,t.dns2ip FROM t_netconfinfo t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<NetConf> re=new ArrayList<NetConf>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String netip = (String)row[1];  
			  String maskip=(String)row[2];
			  String gateip=(String)row[3];
			  String dns1ip=(String)row[4];	
			  String dns2ip=(String)row[5];	
			  NetConf netconfinfo=new NetConf(id,netip,maskip,gateip,dns1ip,dns2ip);	 
			  re.add(netconfinfo);
		}
		return re;
	}
	
	public List<HoneyPot> getHoneyPotList() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.ip FROM t_pot t");
		List l = q.list();
		List<HoneyPot> re=new ArrayList<HoneyPot>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  int order=i+1;
			  HoneyPot pot=new HoneyPot(order,id, ip);	 
			  re.add(pot);
		}
		return re;
	}
	
	public int getCountPot(){

		String sql="select count(*) from t_pot t ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count=((BigInteger)q.uniqueResult()).intValue();
		return count;
	}
	
	public int addPot(String ip){
		
		Query q = session.createSQLQuery("insert into t_pot (ip) values (?)");
		q.setParameter(0, ip);
		int result=q.executeUpdate();
		tx.commit();
		return result;
	}
	
	public int deletePot(int id) {
		SQLQuery q = session.createSQLQuery("delete from t_pot where ID=?");
		q.setParameter(0, id);
		int re=q.executeUpdate();
		return re;
		
	}


	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	

	public DBDao()
	{	
		Configuration cfg = new Configuration();  
        cfg.configure();          
        ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();           
        SessionFactory sessionFactory = cfg.buildSessionFactory(sr);  
                  
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	
	}
	
	private  void close()
	{
		tx.commit();
		session.close();
		//sessionFactory.close();
	}
	public void commit(){
		tx.commit();
		session.close();
	}

	
}
