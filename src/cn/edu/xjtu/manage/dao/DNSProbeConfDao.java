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
import cn.edu.xjtu.manage.business.DNSProbeConf;

public class DNSProbeConfDao {
	 SessionFactory sessionFactory;
	 Session session ;
	 Transaction tx ;
	public DNSProbeConfDao() {
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
	}
	public void commit(){
		tx.commit();
		session.close();
	}

	public int updateParameter(int id,String localIP,String gatewayIP,String localDNS,
			String dns_result_db_ip,String dns_result_db_name,String dns_result_db_user,String dns_result_db_pass,
			String probe_record_db_ip,String probe_record_db_name,String probe_record_db_user,String probe_record_db_pass,
			String extractAveRateParameter_db_ip,String extractAveRateParameter_db_name,String extractAveRateParameter_db_user,String extractAveRateParameter_db_pass) {
		Query q;
		// TODO Auto-generated method stu
		if(id>0){
			q = session.createSQLQuery("update t_dns_probe_conf set localIP=?,gatewayIP=?,localDNS=?,"
					+ "dns_result_db_ip=?,dns_result_db_name=?,dns_result_db_user=?,dns_result_db_pass=?,"
					+ "probe_record_db_ip=?,probe_record_db_name=?,probe_record_db_user=?,probe_record_db_pass=?,"
					+ "extractAveRateParameter_db_ip=?,extractAveRateParameter_db_name=?,extractAveRateParameter_db_user=?,extractAveRateParameter_db_pass=? where ID=?");
			q.setParameter(0, localIP);
			q.setParameter(1, gatewayIP);
			q.setParameter(2, localDNS);
			q.setParameter(3, dns_result_db_ip);
			q.setParameter(4, dns_result_db_name);
			q.setParameter(5, dns_result_db_user);
			q.setParameter(6, dns_result_db_pass);
			q.setParameter(7, probe_record_db_ip);
			q.setParameter(8, probe_record_db_name);
			q.setParameter(9, probe_record_db_user);
			q.setParameter(10, probe_record_db_pass);
			q.setParameter(11, extractAveRateParameter_db_ip);
			q.setParameter(12, extractAveRateParameter_db_name);
			q.setParameter(13, extractAveRateParameter_db_user);
			q.setParameter(14, extractAveRateParameter_db_pass);
			q.setParameter(15, id);			
		}else{
			q = session.createSQLQuery("insert into t_dns_probe_conf(localIP,gatewayIP,localDNS,dns_result_db_ip,dns_result_db_name,dns_result_db_user,dns_result_db_pass,"
					+ "probe_record_db_ip,probe_record_db_name,probe_record_db_user,probe_record_db_pass,"
					+ "extractAveRateParameter_db_ip,extractAveRateParameter_db_name,extractAveRateParameter_db_user,extractAveRateParameter_db_pass) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			q.setParameter(0, localIP);
			q.setParameter(1, gatewayIP);
			q.setParameter(2, localDNS);
			q.setParameter(3, dns_result_db_ip);
			q.setParameter(4, dns_result_db_name);
			q.setParameter(5, dns_result_db_user);
			q.setParameter(6, dns_result_db_pass);
			q.setParameter(7, probe_record_db_ip);
			q.setParameter(8, probe_record_db_name);
			q.setParameter(9, probe_record_db_user);
			q.setParameter(10, probe_record_db_pass);
			q.setParameter(11, extractAveRateParameter_db_ip);
			q.setParameter(12, extractAveRateParameter_db_name);
			q.setParameter(13, extractAveRateParameter_db_user);
			q.setParameter(14, extractAveRateParameter_db_pass);
//			q.setParameter(15, id);			
			}
		int result=q.executeUpdate();
		tx.commit();
		return result;
	}
	
	public List<DNSProbeConf> getParameter() {
		SQLQuery q = session.createSQLQuery("select ID,localIP,gatewayIP,localDNS,dns_result_db_ip,dns_result_db_name,dns_result_db_user,dns_result_db_pass,"
					+ "probe_record_db_ip,probe_record_db_name,probe_record_db_user,probe_record_db_pass,"
					+ "extractAveRateParameter_db_ip,extractAveRateParameter_db_name,extractAveRateParameter_db_user,extractAveRateParameter_db_pass from t_dns_probe_conf ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<DNSProbeConf> re=new ArrayList<DNSProbeConf>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String localIP = (String)row[1];  
			  String gatewayIP = (String)row[2];
			  String localDNS = (String)row[3];
			  String dns_result_db_ip = (String)row[4];
			  String dns_result_db_name=(String)row[5];
			  String dns_result_db_user = (String)row[6];
			  String dns_result_db_pass = (String)row[7];
			  String probe_record_db_ip = (String)row[8];
			  String probe_record_db_name = (String)row[9];
			  String probe_record_db_user = (String)row[10];
			  String probe_record_db_pass = (String)row[11];
			  String extractAveRateParameter_db_ip = (String)row[12];
			  String extractAveRateParameter_db_name=(String)row[13];
			  String extractAveRateParameter_db_user = (String)row[14];
			  String extractAveRateParameter_db_pass = (String)row[15];
			  DNSProbeConf DNSScanConfAll=new DNSProbeConf(id, localIP, gatewayIP, localDNS, "",dns_result_db_ip, dns_result_db_name, dns_result_db_user, dns_result_db_pass,
					  probe_record_db_ip, probe_record_db_name, probe_record_db_user, probe_record_db_pass, 
					  extractAveRateParameter_db_ip, extractAveRateParameter_db_name, extractAveRateParameter_db_user, extractAveRateParameter_db_pass);	 
			  re.add(DNSScanConfAll);
		}
		return re;
	}
	
}
