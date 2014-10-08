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

import cn.edu.xjtu.manage.business.AppConf;

public class AppConfDao {
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	public AppConfDao() {
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

	public int updateParameter(int id, String radarDBip, String proberip,
			String defaultGwip, String localDNSip, String radarDBport,
			String radarDBname, String radarDBuser, String radarDBpasswd,
			String fakePortBase, String processNumForDig, String digIteration,
			String maxSendRate, String maxTaskNum,
			String sendThreadNumByThousand, String enableLog,
			String extractThreadNum) {
		Query q;
		// TODO Auto-generated method stub
		if(id>0){
//			Query q = session.createSQLQuery("delete from t_appConf");
			q = session.createSQLQuery("update t_appConf set radarDBip=?, proberip=?, defaultGwip=?, localDNSip=?, radarDBport=?, radarDBname=?, radarDBuser=?, radarDBpasswd=?, fakePortBase=?, processNumForDig=?, digIteration=?, maxSendRate=?, maxTaskNum=?, sendThreadNumByThousand=?, EnableLog=?, extractThreadNum=? where id=?");
			q.setParameter(0, radarDBip);
			q.setParameter(1, proberip);
			q.setParameter(2, defaultGwip);
			q.setParameter(3, localDNSip);
			q.setParameter(4, radarDBport);
			q.setParameter(5, radarDBname);
			q.setParameter(6, radarDBuser);
			q.setParameter(7, radarDBpasswd);
			q.setParameter(8, fakePortBase);
			q.setParameter(9, processNumForDig);
			q.setParameter(10, digIteration);
			q.setParameter(11, maxSendRate);
			q.setParameter(12, maxTaskNum);
			q.setParameter(13, sendThreadNumByThousand);
			q.setParameter(14, enableLog);
			q.setParameter(15, extractThreadNum);
			q.setParameter(16, id);					
		}else{
			q = session.createSQLQuery("insert into t_appConf(radarDBip, proberip, defaultGwip, localDNSip, radarDBport, radarDBname, radarDBuser, radarDBpasswd, fakePortBase, processNumForDig, digIteration, maxSendRate, maxTaskNum, sendThreadNumByThousand, EnableLog, extractThreadNum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			q.setParameter(0, radarDBip);
			q.setParameter(1, proberip);
			q.setParameter(2, defaultGwip);
			q.setParameter(3, localDNSip);
			q.setParameter(4, radarDBport);
			q.setParameter(5, radarDBname);
			q.setParameter(6, radarDBuser);
			q.setParameter(7, radarDBpasswd);
			q.setParameter(8, fakePortBase);
			q.setParameter(9, processNumForDig);
			q.setParameter(10, digIteration);
			q.setParameter(11, maxSendRate);
			q.setParameter(12, maxTaskNum);
			q.setParameter(13, sendThreadNumByThousand);
			q.setParameter(14, enableLog);
			q.setParameter(15, extractThreadNum);
			
			
			}
		int result=q.executeUpdate();
		tx.commit();
		return result;
	
	}
	
	public List<AppConf> getParameter() {
		SQLQuery q = session.createSQLQuery("select t.id,t.radarDBip,t.proberip,t.defaultGwip,t.localDNSip,t.radarDBport,t.radarDBname,t.radarDBuser,t.radarDBpasswd,t.fakePortBase,t.processNumForDig,t.digIteration,t.maxSendRate,t.maxTaskNum,t.sendThreadNumByThousand,t.EnableLog,t.extractThreadNum from t_appconf t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<AppConf> re=new ArrayList<AppConf>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String radarDBip = (String)row[1];  
			  String proberip = (String)row[2];
			  String defaultGwip = (String)row[3];
			  String localDNSip = (String)row[4];
			  String radarDBport=(String)row[5];
			  String radarDBname = (String)row[6];
			  String radarDBuser = (String)row[7];
			  String radarDBpasswd = (String)row[8];
			  String fakePortBase = (String)row[9];
			  String processNumForDig = (String)row[10];
			  String digIteration = (String)row[11];
			  String maxSendRate = (String)row[12];
			  String maxTaskNum=(String)row[13];
			  String sendThreadNumByThousand = (String)row[14];
			  String EnableLog = (String)row[15];
			  String extractThreadNum = (String)row[16];
			  
			  AppConf appconf=new AppConf(id, radarDBip, proberip, defaultGwip, localDNSip, radarDBport, radarDBname, radarDBuser, radarDBpasswd, fakePortBase, processNumForDig, digIteration, maxSendRate, maxTaskNum, sendThreadNumByThousand, EnableLog, extractThreadNum);	 
			  re.add(appconf);
		}
		return re;
	}
	
}
