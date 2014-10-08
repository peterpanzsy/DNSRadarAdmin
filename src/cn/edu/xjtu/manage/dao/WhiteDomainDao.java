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

import cn.edu.xjtu.manage.business.WhiteDomain;

public class WhiteDomainDao {
	
	public List<WhiteDomain> getWhiteDomainList() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.domain,t.remark FROM t_whitedomain t");
		List l = q.list();
		List<WhiteDomain> re=new ArrayList<WhiteDomain>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String domain = (String)row[1];  
			  String remark=(String)row[2];
	
			  int order=i+1;
			  WhiteDomain whitedomain=new WhiteDomain(order,id,domain,remark);	 
			  re.add(whitedomain);
		}
		return re;
	}
	
	public int getCountWhiteDomain(){

		String sql="select count(*) from t_whitedomain t ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count=((BigInteger)q.uniqueResult()).intValue();
		return count;
	}
	
	public int addWhiteDomain(String domain,String remark){
		
		Query q = session.createSQLQuery("insert into t_whitedomain (domain,remark) values (?,?)");
		q.setParameter(0, domain);
		q.setParameter(1, remark);
		int result=q.executeUpdate();
		tx.commit();
		return result;
	}
	
	public int deleteWhiteDomain(int id) {
		SQLQuery q = session.createSQLQuery("delete from t_whitedomain where ID=?");
		q.setParameter(0, id);
		int re=q.executeUpdate();
		return re;
		
	}

	
	//遍历
	public  void all()
	{
		Query q = session.createSQLQuery("select id,name from Test");
		
		List l = q.list();
		for(int i=0;i<l.size();i++)
		{
			//TestDb user = (TestDb)l.get(i);
			//System.out.println(user.getUsername());

			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String name = (String)row[1];  
			  System.out.println(id+" "+name);
		}
	}
	
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	

	public WhiteDomainDao()
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
