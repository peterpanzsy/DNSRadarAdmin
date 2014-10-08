package cn.edu.xjtu.manage.dao;

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

import cn.edu.xjtu.manage.business.DNSScanConf;

public class DNSScanConfDao {
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	public DNSScanConfDao() {
		Configuration cfg = new Configuration();  
        cfg.configure();          
        ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();           
        SessionFactory sessionFactory = cfg.buildSessionFactory(sr);  
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

	public int updateParameter(int id, String dNSScanDBip, String scannerIP,
			String scanDefaultGwip, String testDomainIp, String dNSScanDBname,
			String dNSScanDBuser, String dNSScanDBpasswd, String testDomain,
			String packetRate, String packetNum, String outputDir,
			String probeNum, String extractNum, String fakePort, String ttl,
			String maxIteration,String resolverUpdate, String resolverInterval) {
		Query q;
		// TODO Auto-generated method stub
		if(id>0){
//			Query q = session.createSQLQuery("delete from t_DNSScanConf");
			q = session.createSQLQuery("update t_dns_scan_conf set DNSScanDBip=?,scannerIP=?,scanDefaultGwip=?,testDomainIp=?,DNSScanDBname=?,DNSScanDBuser=?,DNSScanDBpasswd=?,testDomain=?,packetRate=?,packetNum=?,outputDir=?,probeNum=?,extractNum=?,fakePort=?,ttl=?,maxIteration=?,resolverUpdate=?,resolverInterval=? where id=?");
			q.setParameter(0, dNSScanDBip);
			q.setParameter(1, scannerIP);
			q.setParameter(2, scanDefaultGwip);
			q.setParameter(3, testDomainIp);
			q.setParameter(4, dNSScanDBname);
			q.setParameter(5, dNSScanDBuser);
			q.setParameter(6, dNSScanDBpasswd);
			q.setParameter(7, testDomain);
			q.setParameter(8, packetRate);
			q.setParameter(9, packetNum);
			q.setParameter(10, outputDir);
			q.setParameter(11, probeNum);
			q.setParameter(12, extractNum);
			q.setParameter(13, fakePort);
			q.setParameter(14, ttl);
			q.setParameter(15, maxIteration);
			q.setParameter(16, resolverUpdate);
			q.setParameter(17, resolverInterval);
			q.setParameter(18, id);					
		}else{
			q = session.createSQLQuery("insert into t_dns_scan_conf(DNSScanDBip,scannerIP,scanDefaultGwip,testDomainIp,DNSScanDBname,DNSScanDBuser,DNSScanDBpasswd,testDomain,packetRate,packetNum,outputDir,probeNum,extractNum,fakePort,ttl,maxIteration,resolverUpdate,resolverInterval) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			q.setParameter(0, dNSScanDBip);
			q.setParameter(1, scannerIP);
			q.setParameter(2, scanDefaultGwip);
			q.setParameter(3, testDomainIp);
			q.setParameter(4, dNSScanDBname);
			q.setParameter(5, dNSScanDBuser);
			q.setParameter(6, dNSScanDBpasswd);
			q.setParameter(7, testDomain);
			q.setParameter(8, packetRate);
			q.setParameter(9, packetNum);
			q.setParameter(10, outputDir);
			q.setParameter(11, probeNum);
			q.setParameter(12, extractNum);
			q.setParameter(13, fakePort);
			q.setParameter(14, ttl);
			q.setParameter(15, maxIteration);
			q.setParameter(16, resolverUpdate);
			q.setParameter(17, resolverInterval);
			
			}
		int result=q.executeUpdate();
		tx.commit();
		return result;
	
	}
	
	public List<DNSScanConf> getParameter() {
		SQLQuery q = session.createSQLQuery("select t.id,t.DNSScanDBip,t.scannerIP,t.scanDefaultGwip,t.testDomainIp,t.DNSScanDBname,t.DNSScanDBuser,t.DNSScanDBpasswd,t.testDomain,t.packetRate,t.packetNum,t.outputDir,t.probeNum,t.extractNum,t.fakePort,t.ttl,t.maxIteration,t.resolverUpdate,t.resolverInterval from t_dns_scan_conf t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<DNSScanConf> re=new ArrayList<DNSScanConf>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String DNSScanDBip = (String)row[1];  
			  String scannerIP = (String)row[2];
			  String scanDefaultGwip = (String)row[3];
			  String testDomainIp = (String)row[4];
			  String DNSScanDBname=(String)row[5];
			  String DNSScanDBuser = (String)row[6];
			  String DNSScanDBpasswd = (String)row[7];
			  String testDomain = (String)row[8];
			  String packetRate = (String)row[9];
			  String packetNum = (String)row[10];
			  String outputDir = (String)row[11];
			  String probeNum = (String)row[12];
			  String extractNum=(String)row[13];
			  String fakePort = (String)row[14];
			  String ttl = (String)row[15];
			  String maxIteration = (String)row[16];
			  String resolverUpdate=(String)row[17];
			  String resolverInterval=(String)row[18];
			  DNSScanConf DNSScanConf=new DNSScanConf(id, DNSScanDBip, scannerIP, scanDefaultGwip, testDomainIp, DNSScanDBname, DNSScanDBuser, DNSScanDBpasswd, testDomain, packetRate, packetNum, outputDir, probeNum, extractNum, fakePort, ttl, maxIteration, resolverUpdate, resolverInterval);	 
			  re.add(DNSScanConf);
		}
		return re;
	}
	
}
