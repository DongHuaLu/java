package test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Node;

public class Testt {
	static SessionFactory  sessionFactory=null;
	
	@BeforeClass
	public static void beforeClass(){
		 Configuration configuration = new Configuration();
		 configuration.configure();
		 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void printChild(Node rootNode,int level){
		String g="-";
		for(int i=0;i<level;i++){
			g=g+"-";
		}		
		Set<Node> s=rootNode.getChilds();
		for (Node n:s){
			System.out.println(g+n.getName());
			printChild(n,level+1);
		}		
	}
	
	@Test
	public void testLoad(){
		Session s=sessionFactory.getCurrentSession();
		s.beginTransaction();
		Node rootNode=(Node)s.get(Node.class, 10);
		s.getTransaction().commit();
		printChild(rootNode,0);
	}

	@Test
	public void testSave(){
		Node rootNode=new Node();
		rootNode.setName("root");
		Node node1=new Node();
		node1.setName("1");
		node1.setP(rootNode);
		Node node2=new Node();
		node2.setName("2");
		node2.setP(rootNode);
		Node node21=new Node();
		node21.setName("21");
		node21.setP(node2);
		Node node211=new Node();
		node211.setName("211");
		node211.setP(node21);
		
		Session s=sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(rootNode);
		s.save(node1);
		s.save(node2);
		s.save(node21);
		s.save(node211);
		s.getTransaction().commit();
		
		
	}
	@Test
	public void testSchema(){		
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
	
	@AfterClass
	public static void afterClass(){
		sessionFactory.close();
	}
}
