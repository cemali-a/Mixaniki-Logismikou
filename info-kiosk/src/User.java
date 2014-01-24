import java.sql.ResultSet;


public class User {
	public ResultSet userBrowse(int id,int aithousa) throws Exception {   
		ResultSet info;
		MySystem sys=new MySystem();
		info=sys.systemShowEkthema(id, aithousa);
		return info;
	}
}
