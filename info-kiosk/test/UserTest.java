import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Test;


public class UserTest {

	User user = new User();
	
	@Test
	public void testUserBrowse() throws Exception {
		ResultSet result=null;
		assertNotNull(user.userBrowse(1, 1));
	}

}
