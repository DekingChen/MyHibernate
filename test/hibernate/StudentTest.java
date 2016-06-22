package hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Students;

public class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Test
	public void testSaveStudents() throws IOException {
		Students s = new Students();
		// s.setSid(1);
		s.setSname("chenzhenquan");
		s.setSex("Boy");
		s.setAddress("GDUT");
		s.setBirthday(new Date());
		File file = new File("F:" + File.separator + "chenzhenquan_kepler"
				+ File.separator + "MyHibernate" + File.separator + "Data"
				+ File.separator + "image" + File.separator + "boy.jpg");
		FileInputStream in = new FileInputStream(file);
		Blob image = Hibernate.getLobCreator(session).createBlob(in,
				in.available());
		s.setPicture(image);
		session.save(s);
	}
	
	@Test
	public void testreadBlob() throws SQLException, IOException{
		Students s = (Students) session.get(Students.class, 1);
		Blob image = s.getPicture();
		InputStream input = image.getBinaryStream();
		File file = new File("F:" + File.separator + "chenzhenquan_kepler"
				+ File.separator + "MyHibernate" + File.separator + "Data"
				+ File.separator + "image" + File.separator + "girl.jpg");
		OutputStream out = new FileOutputStream(file);
		byte b[] = new byte[input.available()];
		input.read(b);
		out.write(b);
		input.close();
		out.close();
		
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
