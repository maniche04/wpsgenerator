package smartsewa.wps;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	
	public Database sewaDB = new Database();
	@FXML public Label thisuser;
	public String username;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
     */
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
    	ResultSet rs = sewaDB.getResult("SELECT * FROM WPSDB.sewaUsers");
		
		if (rs.next()) {
			
			username = rs.getString("Username");
			thisuser.setText(username);
			
		}
    }

}
