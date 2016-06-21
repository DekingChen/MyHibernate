package hibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
	
	@Test
	public void testSaveStudents(){
		Students s = new Students(1,"DekingChen","boy","DK",new Date());
		session.save(s);
	}
	
	@Before
	public void init(){
		//�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serverRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//�����Ự����
		sessionFactory = config.buildSessionFactory(serverRegistry);
		//�����Ự����
		session = sessionFactory.openSession();
		//��������
		transaction = session.beginTransaction();
	}
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
