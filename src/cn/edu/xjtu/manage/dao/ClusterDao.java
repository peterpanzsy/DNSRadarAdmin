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

import cn.edu.xjtu.manage.business.Cluster;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.HoneyPot;

public class ClusterDao {
	
	public int updateParameter(int id, String interval) {
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_cluster(cluster_interval) values (?)");
			q.setParameter(0, interval);
			int result=q.executeUpdate();
			tx.commit();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_cluster t set t.cluster_interval=? where t.ID=?");
			q.setParameter(0, interval);
			q.setParameter(1, id);
			int re=q.executeUpdate();
			tx.commit();
			return re;
		}
	}
	
	public List<Cluster> getParameter() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.cluster_interval FROM t_cluster t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<Cluster> re=new ArrayList<Cluster>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String interval = (String)row[1];  					
			  Cluster cluster=new Cluster(id, interval);	 
			  re.add(cluster);
		}
		return re;
	}
	
	
	
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	

	public ClusterDao()
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
