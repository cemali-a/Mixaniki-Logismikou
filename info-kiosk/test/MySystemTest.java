import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.Random;

import org.junit.Test;


public class MySystemTest {

	MySystem system = new MySystem();
	
	@Test
	public void testSystemAdminPassword() throws Exception {
	assertTrue(system.systemAdminPassword("admin", "12345"));	
	}

	@Test
	public void testSystemDeleteEkthema() {
		
	}

	@Test
	public void testSystemSaveEkthema() throws Exception {
		Random randomgen = new Random();
		int randomint = randomgen.nextInt(1000);
		assertTrue(system.systemSaveEkthema( randomint ,"Test2" , 1 ,"jUnit test","testimage.jpg"));
	}

	@Test
	public void testSystemShowEkthema() throws Exception {
		ResultSet result=null;
		assertNotNull(system.systemShowEkthema(1, 1));
	}

}
