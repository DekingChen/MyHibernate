package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serverRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂
		sessionFactory = config.buildSessionFactory(serverRegistry);
	}

	//获取SessionFactory对象
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//获取Session对象
	public static Session getSession() {
		// 创建会话对象
		if(session==null)
		session = sessionFactory.openSession();
		return session;
	}
	
	//关闭Session
	public static void closeSession(Session session){
		if(session!=null)
			session.close();
	}
}
