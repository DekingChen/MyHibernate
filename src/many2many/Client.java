package many2many;

import hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Employee;
import entity.Project;

public class Client {

	public static void main(String[] args) {
		addEmployees();
		addProjects();
	}
	
	public static void addEmployees(){
	
		Project project01 = new Project(1001,"Project One");
		Project project02 = new Project(1002,"Project Two");
		
		Employee employee01 = new Employee(1,"DekingChen");
		Employee employee02 = new Employee(2,"chenzhenquan");
		
		project01.getEmployees().add(employee01);
		project01.getEmployees().add(employee02);
		
		project02.getEmployees().add(employee01);
		

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(project01);
		session.save(project02);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
	
	public static void delect(){
		
	}
	
	public static void addProjects(){
		Project project1=new Project(1001,"项目一");
		Project project2=new Project(1002,"项目二");
		Employee employee1=new Employee(1,"慕女神");
		Employee employee2=new Employee(2,"imooc");
		
		//参加项目1的员工有慕女神和imooc
		project1.getEmployees().add(employee1);
		project1.getEmployees().add(employee2);
		// 参加项目2的员工有慕女神
		project2.getEmployees().add(employee1);
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(project1);
		session.save(project2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

}
