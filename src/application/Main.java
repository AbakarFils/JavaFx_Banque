package application;

import java.io.IOException;

import Banque.Dao.DB;
import BanqueMessage.Outils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.application.*;

public class Main extends Application {
	  @FXML
	    private Button connection_btn;

	    @FXML
	    private TextField username_txt;

	    @FXML
	    private PasswordField password_txt;

	    @FXML
	    void connection(ActionEvent event) throws IOException {
	    	Outils.load(event, "/ViewGestionCompte/Menu.fxml", "Menu");
	    }

	    @FXML
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root =FXMLLoader.load(getClass().getResource("Banque.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
		 DB db =new DB();

	}
}
