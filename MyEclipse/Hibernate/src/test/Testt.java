package test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Testt {
	
	@Test
	public void testSchema(){		
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
	
	
	public static void main(String[] args) {
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}
