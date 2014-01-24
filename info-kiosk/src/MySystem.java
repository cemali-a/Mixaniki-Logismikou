import java.sql.*;

public class MySystem {
	public boolean systemAdminPassword(String username,String password) throws Exception {
		Database db=new Database(); 
		String table="admin";
		String rslt=null;
		ResultSet info;
		boolean result;
		Connection newcon=db.dbConnect("localhost", "testdb", "root", ""); 
		info=db.dbRead(newcon, "SELECT * from "+table+" where username='"+username+"' and password='"+password+"' ");
		if(info != null)
		{
			while (info.next())
			{
				rslt=info.getObject(1).toString();
			}
		}
		System.out.println(info);
		if (rslt==null)
			result=false;
		else
			result=true;
		return result;
		
	}
	
	public boolean systemDeleteEkthema(int id) throws Exception {
		boolean bool=false;
		Database db=new Database(); 
		Connection newcon=db.dbConnect("localhost", "testdb", "root", ""); 
		String table="ekthemata";
		bool=db.dbDelete(newcon, "DELETE FROM "+table+" WHERE id="+id);
		return bool;
	}
	
	public boolean systemSaveEkthema(int id ,String onoma, int aithousa, String plirofories, String image) throws Exception {
		boolean bool=false;
		Database db=new Database(); 
		String table="ekthemata";
		Connection newcon=db.dbConnect("localhost", "testdb", "root", ""); 
		bool=db.dbSave(newcon, "INSERT INTO "+table+" (id,onoma,aithousa,plirofories,image) values("+id+",'"+onoma+"', "+aithousa+", '"+plirofories+"', '"+image+"')"); 
		return bool;
	}
	
    public ResultSet systemShowEkthema(Integer id , Integer aithousa) throws Exception {
		Database db=new Database(); 
		String table="ekthemata";
		ResultSet title=null;
		Connection newcon=db.dbConnect("localhost", "testdb", "root", ""); 
		title=db.dbRead(newcon, "SELECT * from "+table+" where id="+id+" and aithousa="+aithousa); 
		return title;
	}

    
}
