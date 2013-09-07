package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.dolph.domain.Student;
import com.dolph.domain.Teacher;

public class TestStudent {
	public static void main (String[] args){
		
		Student s=new Student();
		s.setId(1);
		s.setName("s2");
		s.setAge(1);
		
		Configuration cfg=new AnnotationConfiguration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(s);
		ss.getTransaction().commit();
		ss.close();
		sf.close();
	}

}
