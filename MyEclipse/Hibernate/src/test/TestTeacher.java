package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.dolph.domain.Teacher;

public class TestTeacher {
	public static void main (String[] args){
		
		Teacher t=new Teacher();
		t.setId(3);
		t.setName("t3");
		t.setTitle("tt3");
		
		Configuration cfg=new AnnotationConfiguration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(t);
		ss.getTransaction().commit();
		ss.close();
		sf.close();
	}
}
