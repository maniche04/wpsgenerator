package smartsewa.wps;
	
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public Database sewaDB = new Database();
	
	@Override
	public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
		
		ResultSet rs = sewaDB.getResult("SELECT * FROM WPSDB.sewaUsers");
		System.out.println("Result fetched!");
		
		if (rs.next()) {
			System.out.println(rs.getString("Username"));
			System.out.println(rs.getString("Password"));
		}
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
