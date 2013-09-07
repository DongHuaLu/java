package test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dolph.model.Company;
import com.dolph.model.Department;
import com.dolph.model.Party;
import com.dolph.model.Person;
import com.dolph.service.InitService;
import com.dolph.service.PartyService;

public class Testt extends TestCase {

	public void test01() {
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		PartyService ps = (PartyService) bf.getBean("partyService");
		Party company = new Company();
		company.setName("有限公司");
		company.setDescription("公司");

		ps.saveorUpdateCompany((Company) company);
		// 创建一系列部门
		for (int i = 0; i < 10; i++) {
			Department d = new Department();
			d.setName("部门" + i);
			d.setParent(company);
			ps.addParty(d);

			for (int j = 0; j < 5; j++) {
				Person p = new Person();
				p.setName(d.getName() + "下的人员" + j);
				p.setParent(d);
				ps.addParty(p);
			}
		}
	}

	public void test02() {
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("123");
		PartyService ps = (PartyService) bf.getBean("partyService");
		Company c = ps.findRootCompany();
		for (int i = 0; i < 100; i++) {
			Person p = new Person();
			p.setParent(c);
			p.setName(i + "号");
			p.setSex("人妖");
			p.setTel(i + "");
			ps.addParty(p);
		}

	}

	public void test03() {
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		InitService is = (InitService) bf.getBean("initService");
		is.addIntiData();
	}

	public int test04() {

		try {
			return 1;
		} catch (Exception e) {

		} finally {
			return 2;
		}
	}
	
	public void test05(){
		int x=test04();
		System.out.println(x);
	}

}
