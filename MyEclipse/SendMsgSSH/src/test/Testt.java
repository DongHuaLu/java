package test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dolph.DAO.UserDAO;
import com.dolph.model.Group;
import com.dolph.model.User;
import com.dolph.service.GroupService;
import com.dolph.service.MessageService;
import com.dolph.service.UserService;

public class Testt  extends TestCase{
	BeanFactory bf=new ClassPathXmlApplicationContext("beans.xml");
	UserService us=(UserService) bf.getBean("userService");
	MessageService ms=(MessageService) bf.getBean("messageService");
	GroupService gs=(GroupService) bf.getBean("groupService");
	UserDAO ud=(UserDAO) bf.getBean("userDAO");
	
	
	public void test1(){
		Group g1=new Group();
		Group g2=new Group();
		Group g3=new Group();
		Group g4=new Group();
		g1.setName("一组");
		g2.setName("二组");
		g3.setName("三组");
		g4.setName("四组");
		gs.add(g1);
		gs.add(g2);
		gs.add(g3);
		gs.add(g4);	
		
		
		for (int i =0;i<10;i++){
			User u=new User();
			u.setUsername("username"+i);
			u.setPassword("password");
			u.setGroup(g1);
			us.add(u);
		}
		for (int i =10;i<20;i++){
			User u=new User();
			u.setUsername("username"+i);
			u.setPassword("password");
			u.setGroup(g4);
			us.add(u);
		}
		for (int i =20;i<30;i++){
			User u=new User();
			u.setUsername("username"+i);
			u.setPassword("password");
			u.setGroup(g2);
			us.add(u);
		}
		for (int i =30;i<40;i++){
			User u=new User();
			u.setUsername("username"+i);
			u.setPassword("password");
			u.setGroup(g3);
			us.add(u);
		}
	}
	

	public void test2(){
		int[] i={89,88,87,86,85};
		ms.sendMessage("title", "content",70,i,51);
	}
	
	
	public void test3(){
		
		User u=us.login("1", "1");
		System.out.println(u.getId());
	}
}
