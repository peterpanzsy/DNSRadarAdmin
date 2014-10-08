package cn.edu.xjtu.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import cn.edu.xjtu.manage.business.Cluster;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.manage.business.License;

public class LicenseDao {
	
	public int updateLicense(int id, String license,Date expires,int isvalid) {
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_license(license,expires,isvalid) values (?,?,?)");
			q.setParameter(0, license);
			q.setParameter(1, expires);
			q.setParameter(2, isvalid);
			int result=q.executeUpdate();
			tx.commit();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_license t set t.license=?,t.expires=?,t.isvalid=? where t.ID=?");
			q.setParameter(0, license);
			q.setParameter(1, expires);
			q.setParameter(2, isvalid);
			q.setParameter(3, id);
			int re=q.executeUpdate();
			tx.commit();
			return re;
		}
	}
	
	public List<License> getLicense() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.license,t.expires,t.isvalid FROM t_license t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<License> re=new ArrayList<License>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String licensestr = (String)row[1];  	
			  Date expires=(Date) row[2];
			  int isvalid=(Integer)row[3];
			  License license=new License(id,licensestr,expires,isvalid);	 
			  re.add(license);
		}
		return re;
	}
	
	
	
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	

	public LicenseDao()
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
