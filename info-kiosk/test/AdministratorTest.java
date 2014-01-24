import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.Random;

import org.junit.Test;


public class AdministratorTest {
	
	Administrator admin = new Administrator();


	@Test
	public void testAdminBrowse() throws Exception {
		ResultSet result=null;
		assertNotNull(admin.adminBrowse(1, 1));
	}

	@Test
	public void testAdminInsert() throws Exception {
		Random randomgen = new Random();
		int randomint = randomgen.nextInt(1000);
		assertTrue(admin.adminInsert( randomint ,"Test3" , 1 ,"jUnit test","testimage.jpg"));
	}


}
