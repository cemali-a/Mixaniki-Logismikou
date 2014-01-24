import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class DatabaseTest {

	Database database = new Database();
	
	@Test
	public void testDbConnect() throws Exception {
		assertNotNull(database.dbConnect("localhost", "testdb", "root", ""));
	}

	@Test
	public void testDbRead() throws Exception {
		String statement = "Select * from ekthemata";
		assertNotNull(database.dbRead(database.dbConnect("localhost", "testdb", "root", ""), statement));
	}

	@Test
	public void testDbDelete() {
		//
	}

	@Test
	public void testDbSave() throws Exception {
		Random randomgen = new Random();
		int randomint = randomgen.nextInt(1000);
		String statement = "INSERT INTO ekthemata (id,onoma,aithousa,plirofories,image) values( "+randomint+",'Test', 1 ,'jJunit Testing','testimage.jpg' )";
		assertNotNull(database.dbSave(database.dbConnect("localhost", "testdb", "root", ""), statement));
	}

}
