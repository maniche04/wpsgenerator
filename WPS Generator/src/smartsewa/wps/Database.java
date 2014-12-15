package smartsewa.wps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Database {

	public Connection conn;
	
	public  String dbname = "wpsdb"; 
	public  String username = ("smartAdmin");
    public  String password = ("Almunia24");
    public  String url = ("jdbc:derby:" + dbname + ";create=true");

    public Connection getConnection(){
    	if (this.conn == null) {
    		try {
    			
    			this.conn = DriverManager.getConnection(this.url, this.username, this.password);
    			
    		} catch (SQLException ex) {
                ex.printStackTrace();
            }
    	}
    	
    	 if (this.conn != null) {
             System.out.println("Connected to the Database!");
         }
    	
    	
		return this.conn;
    }
    
    
    public ResultSet getResult(String query) throws SQLException, ClassNotFoundException {
        
    	return getConnection().createStatement().executeQuery(query);
    	
   	
    }
    
    
    
}
