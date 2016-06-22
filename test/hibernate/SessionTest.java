package hibernate;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import entity.Students;

public class SessionTest {
	

	@Ignore
	public void testOpenSession() {
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
			Session session = sessionFactory.openSession();
			Session session01 = sessionFactory.openSession();
			System.out.println(session==session01);
			if(session!=null){
				System.out.print("Session 创建成功！");
			}else{
				System.out.print("Session 创建失败！");
			}
	
	}
	
	@Ignore
	public void testGetCurrentSession() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		Session session01 = sessionFactory.getCurrentSession();
		System.out.println(session==session01);
		if(session!=null){
			System.out.print("Session 创建成功！");
		}else{
			System.out.print("Session 创建失败！");
		}
	}
	
	@Test
	public void testSaveStudentWithOpenSession(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Students s = new Students(1,"chenzhenquan","Boy","GDUT",new Date());
		session.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.print("Hash Code:"+conn.hashCode());
			}
			
		});
		session.save(s);
		transaction.commit();
		session.close();
		
		Session session01= sessionFactory.openSession();
		transaction = session01.beginTransaction();
		session01.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.print("Hash Code:"+conn.hashCode());
			}
			
		});
		s = new Students(2,"DekingChen","Boy","GDUT",new Date());
		session01.save(s);
		transaction.commit();
		session01.close();

		
		
	}
	
	@Test
	public void testSaveStudentWithGetCurrentSession(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Students s = new Students(1,"chenzhenquan","Boy","GDUT",new Date());
		session.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.print("Hash Code:"+conn.hashCode());
			}
			
		});
		session.save(s);
		transaction.commit();
		
		Session session01= sessionFactory.getCurrentSession();
		transaction = session01.beginTransaction();
		session01.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.print("Hash Code:"+conn.hashCode());
			}
			
		});
		s = new Students(2,"DekingChen","Boy","GDUT",new Date());
		session01.save(s);
		transaction.commit();
	}
}
