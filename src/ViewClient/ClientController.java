package ViewClient;

import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.image.BufferedImage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

import com.sun.glass.ui.Window.Level;

import javafx.scene.image.Image;
import java.io.IOException;
public class ClientController {

    @FXML

    private ImageView image_view;

    @FXML
    private TextField email_txt;

    @FXML
    private Button image_btn;

    @FXML
    private TextField nom_txt;

    @FXML
    private Button sauvegarder_btn;

    @FXML
    private Button creerCompte_btn;

    @FXML
    private TextField adress_txt;

    @FXML
    private TextField prenom_txt;

    @FXML
    void choisirImage(ActionEvent event) {
    	 FileChooser fileChooser = new FileChooser();

       //Set extension filter
       FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
       FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
       fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

       //Show open file dialog
       File file = fileChooser.showOpenDialog(null);

       try {
           BufferedImage bufferedImage = ImageIO.read(file);
           Image image = SwingFXUtils.toFXImage(bufferedImage, null);
           image_view.setImage(image);
       } catch (IOException ex) {
          // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    @FXML
    void Creer_Compte(ActionEvent event) {

    }

    @FXML
    void sauvegarder(ActionEvent event) {

    }

}
