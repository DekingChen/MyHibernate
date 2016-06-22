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

import entity.Address;
import entity.User;

public class UserTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Test
	public void testsaveUser(){
		User user = new User();
		user.setUname("chenzhenquan");
		user.setSex("Boy");
		user.setBirthday(new Date());
		Address address = new Address("510520","13570490483","GDUT");
		user.setAddress(address);
		session.save(user);
	}
	
	@Test
	public void testUpdateUser(){
		User user = (User) session.get(User.class, 1);
		user.setUname("DekingChen");
		session.update(user);
	}
	
	@Test
	public void testDeleteUser(){
		User user = (User) session.get(User.class, 1);
		session.delete(user);
	}
	
	@Test
	public void testGetUser(){
		User user = (User) session.get(User.class, 1);
		System.out.print(user.getUname());
	}
	
	
	@Before
	public void init() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serverRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂
		sessionFactory = config.buildSessionFactory(serverRegistry);
		// 创建会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
