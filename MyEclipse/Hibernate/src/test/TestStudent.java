package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dolph.domain.Student;
import com.dolph.domain.Teacher;

public class TestStudent {
	public static void main (String[] args){
		
		Student s=new Student();
		s.setId(1);
		s.setName("s2");
		s.setAge(1);
		
		 Configuration configuration = new Configuration();
		 configuration.configure();
		 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 

		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//Session ss=sf.openSession();
		Session ss=sessionFactory.getCurrentSession();
		ss.beginTransaction();
		ss.save(s);
		ss.getTransaction().commit();
		//ss.close();
		sessionFactory.close();
	}

}
