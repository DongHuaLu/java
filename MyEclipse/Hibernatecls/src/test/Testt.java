package test;

import oracle.net.aso.s;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Course;
import domain.Grade;
import domain.Student;

public class Testt {
	static SessionFactory  sessionFactory=null;
	
	@BeforeClass
	public static void beforeClass(){
		 Configuration configuration = new Configuration();
		 configuration.configure();
		 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@Test
	public void testSchema(){		
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
	
	@Test
	public void testSave(){
		
		Session ss=sessionFactory.getCurrentSession();
		ss.beginTransaction();
		Student s=new Student();
		Grade g=new Grade();
		Course c=new Course();
		s.setName("s2");
		//s.getCourses().add(c);
		c.setName("c2");
		//c.getStudents().add(s);
		g.setStudent(s);
		g.setCourse(c);
		g.setGrade(22);
		ss.save(s);
		ss.save(c);
		ss.save(g);
		ss.getTransaction().commit();
	}
	
	
	@Test
	public void testget(){
		Session ss=sessionFactory.getCurrentSession();
		ss.beginTransaction();
		Student s=(Student) ss.get(Student.class, 1);

		ss.getTransaction().commit();
		for(Course c:s.getCourses()){
			for(Grade g:c.getGrades())
			System.out.println(s.getName()+"学习了"+c.getName()+"的分:"+g.getGrade());
		}
	
	}
	
	@AfterClass
	public static void afterClass(){
		sessionFactory.close();
	}
}
