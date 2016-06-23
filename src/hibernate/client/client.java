package hibernate.client;

import java.util.Set;

import hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Class;
import entity.Student;

public class client {

	public static void add() {
		Class c = new Class("Java Class One", "Java开发一班");

		Student student01 = new Student("DekingChen", "Boy");
		Student student02 = new Student("chenzhenquan", "Boy");

		c.getStudents().add(student01);
		c.getStudents().add(student02);

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		// 设置学生的关联关系，在学生表中添加对应的班级编号
		student01.setClasses(c);
		student02.setClasses(c);
		session.save(c);
		// session.save(student01);
		// session.save(student02);
		transaction.commit();
		HibernateUtil.closeSession(session);

	}

	public static void getStudentsByClass() {
		Session session = HibernateUtil.getSession();
		Class c = (Class) session.get(Class.class, 1);
		System.out.print(c.getCname() + ":" + c.getCdesc());
		Set<Student> students = c.getStudents();
		for (Student s : students) {
			System.out.println(s.toString());
		}
		HibernateUtil.closeSession(session);
	}

	public static void updateStudents() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Class c = new Class("Java Class Two", "Java开发二班");
		Student stu = (Student) session.get(Student.class, 1);
		c.getStudents().add(stu);
		session.save(c);
		transaction.commit();
		HibernateUtil.closeSession(session);
	}

	public static void deleteStudents() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student stu = (Student) session.get(Student.class, 2);
		session.delete(stu);
		transaction.commit();
		session.close();

	}

	public static void findClassByStudents() {
		Session session = HibernateUtil.getSession();
		Student stu = (Student) session.get(Student.class, 1);
		System.out.print(stu.toString());
		Class c = stu.getClasses();
		System.out.print(c.toString());
	}

	public static void main(String args[]) {
		// add();
		// getStudentsByClass();
		// updateStudents();
		// deleteStudents();
		findClassByStudents();
	}
}
