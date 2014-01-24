import java.sql.*;



public class Database {
	public Connection dbConnect(String host, String database, String user, String password) throws Exception { 
		String url="";
		try
		{
			url="jdbc:mysql://"+host+":3306/"+database;
			Connection con=DriverManager.getConnection(url,user,password);
			return con;
		}
		catch (SQLException e)
		{
			throw e;
		}
	}
		
	public ResultSet dbRead(Connection con, String sqlStatement) throws Exception { 
		try {
			  Statement cs = con.createStatement();
              String cutstr =sqlStatement.substring(14);     
			  String sqlStCount="SELECT count(*) from "+cutstr; 
			  ResultSet sqlrs = cs.executeQuery(sqlStCount);  
              sqlrs.next(); 
              String countstr =sqlrs.getObject(1).toString();
              int countint = Integer.parseInt(countstr);
              ResultSet sqls = null;
              if (countint!=0)  {
            	  sqls = cs.executeQuery(sqlStatement);                  
              }
              return sqls;  
      } catch (SQLException e) { 
              System.out.println ("Error executing sql statement "+e); 
              throw e; 
      }
		
	}
	
	public boolean dbDelete(Connection con, String sqlStatement) throws Exception {
		  try { 
			  boolean bool=false;
			  Statement cs = con.createStatement(); 
              cs.executeUpdate(sqlStatement);  
              bool=true;
              cs.close();
              return bool;
      } catch (SQLException e) { 
              System.out.println ("Error executing sql statement"); 
              throw e; 
      } 
	}
	
	public boolean dbSave(Connection con, String sqlStatement) throws Exception {
		  try { 
			  boolean bool=false;
			  Statement cs = con.createStatement(); 
              cs.executeUpdate(sqlStatement); 
              bool=true;
              cs.close();
              return bool;    
		  	  } 
		  catch (SQLException e) 
		  { 
			  System.out.println ("Error executing sql statement "+e); 
              throw e; 
		  } 
	}
}
