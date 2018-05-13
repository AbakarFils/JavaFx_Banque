package ViewEmploye;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.omg.CORBA.OMGVMCID;

import Banque.Dao.AgenceDB;
import Banque.Dao.EmployeDB;
import Banque.Dao.IAgence;
import Banque.Dao.IEmploye;
import Banque.Dao.Iprofile;
import Banque.Dao.ProfileDB;
import BanqueMessage.Outils;
import entities.Agence;
import entities.Employe;
import entities.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class EmployeController implements Initializable{
	private IEmploye Iemploye;
	private Iprofile iProfile;
	private IAgence Iagence;
    @FXML
    private TextField numeropiece_txt;

    @FXML
    private TextField tel_txt;

    @FXML
    private TableColumn<Employe, String> dateNaiss_column;

    @FXML
    private Button modifier;
    @FXML
    private DatePicker dateNaiss_dt;

    @FXML
    private ImageView image_view;

    @FXML
    private TableColumn<Employe, String> adresse_column;

    @FXML
    private Button ajouter_btn;

    @FXML
    private ComboBox<String> id_agence;

    @FXML
    private TextField adresse_txt;

    @FXML
    private TableColumn<Employe, String> tel_column;

    @FXML
    private TableColumn<Employe, Integer> id_column;

    @FXML
    private TextField prenom_txt;

    @FXML
    private Button actualiser;

    @FXML
    private Button image_btn;

    @FXML
    private TextField nom_txt;

    @FXML
    private Button supprimer_btn;

    @FXML
    private TableColumn<Employe, String> numeroPiece_column;

    @FXML
    private ComboBox<String> id_profile;

    @FXML
    private TableColumn<Employe, String> nomComplet_column;

    @FXML
    private TableColumn<Employe, String> prenom_column;
    @FXML
    private TableView<Employe> table_employes;


    @FXML
    void choisirImage(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();

        //
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //
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
    void sauvegarder(ActionEvent event) {
    	String nom=nom_txt.getText();
    	String prenom=prenom_txt.getText();
    	String adresse=adresse_txt.getText();
    	String tel=tel_txt.getText();
    	String NumPiece=numeropiece_txt.getText();
    	//int  idAgence =id_agence.getTypeSel;
    	//int idProfile=id_profile.getTypeSelector();
    	LocalDate dateNais=dateNaiss_dt.getValue();
    	Image photo =image_view.getImage();
    	//String pho=photo.toString();
    	if(nom.isEmpty() && prenom.isEmpty() && adresse.isEmpty() && tel.isEmpty()
    			){
    		Outils.showErrorMessage("Error", "veilez remplir tous les champs svp");
    	}else{
    		Iemploye= new EmployeDB();
    		Employe e =new Employe();
    		e.setAdresse(adresse);
    		e.setDateNaiss( new java.util.Date());
    		e.setNumPiece(NumPiece);
    		e.setTel(tel);
    		//e.setPhoto(pho);
    		e.setIdAgence(1);
    		e.setIdProfile(2);
    		if(Iemploye.add(e)!=0)
    		{
    			Outils.showConfirmationMessage("Succes", "Donnée sauvegardée");
    		}else{
    			Outils.showErrorMessage("Error", "Veillez coonsulter l'administration");
    		}
    	}
    }
    private void AgenceCharge(){
    	//charge les Agences dans combobox
    			Iagence = new AgenceDB();
    			ObservableList<String> liste_Agence= FXCollections.observableArrayList();
    			Iagence.liste().stream().forEach(a->liste_Agence.add(a.getNumero()));
    			id_agence.setItems(liste_Agence);
    }
    private void profileChage(){
		//charge les profiles dans combobox
		iProfile=new ProfileDB();
		ObservableList<String> list_profile= FXCollections.observableArrayList();
		iProfile.liste().stream().forEach(p->list_profile.add(p.getLibelle()));
		id_profile.setItems(list_profile);
    }
    private void loadTable(){

    	//charge les employes dans tableView
		Iemploye=new EmployeDB();
		ObservableList<Employe> liste_Employe= FXCollections.observableArrayList();
		//Iemploye.liste().stream().forEach(e->liste_Employe.add(e));
		table_employes.setItems(liste_Employe);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		adresse_column.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		numeroPiece_column.setCellValueFactory(new PropertyValueFactory<>("numPiece"));
		prenom_column.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		nomComplet_column.setCellValueFactory(new PropertyValueFactory<>("nom"));
		tel_column.setCellValueFactory(new PropertyValueFactory<>("tel"));
		dateNaiss_column.setCellValueFactory(new PropertyValueFactory<>("dateNaiss"));
		loadTable();
		AgenceCharge();
		profileChage();



	}
}
