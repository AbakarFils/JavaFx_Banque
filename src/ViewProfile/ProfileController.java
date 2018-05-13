package ViewProfile;

import java.net.URL;
import java.util.ResourceBundle;

import Banque.Dao.Iprofile;
import Banque.Dao.ProfileDB;
import BanqueMessage.Outils;
import entities.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfileController implements Initializable {
	private Iprofile iprofile;
    @FXML
    private Button valider_btn;

    @FXML
    private Button actualiser_btn;

    @FXML
    private Label params_txt;

    @FXML
    private TableView<Profile> profile_table;

    @FXML
    private Button modifier_btn;

    @FXML
    private TextField libelle_txt;

    @FXML
    private TableColumn<Profile, String> libelle_column;

    @FXML
    private Button supprimer_btn;

    @FXML
    private TableColumn<Profile, Integer> id_column;

    @FXML
    void tableClick(ActionEvent event) {

    }

    @FXML
    void valider(ActionEvent event) {
    	String libelle= libelle_txt.getText();
    	if(libelle.isEmpty()){
    		//Outils.showErrorMessage("ERRor","");
    		Outils.showErrorMessage("Error", "veilez saisir un libelle svp");
    	}else{
    		iprofile =new ProfileDB();
    		Profile p=new Profile();
    		p.setLibelle(libelle);
    		if(iprofile.add(p)!=0){
    			Outils.showConfirmationMessage("Succès", "Donnée inserer avec succes");
    			libelle_txt.setText("");
    			loadTable();
    			libelle_txt.setText("");
    		}else{
    			Outils.showErrorMessage("Error", "Une erreur est produit quelque part veillez consulter admin");
    		}

    	}

    }

    @FXML
    void actualiser(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		libelle_column.setCellValueFactory(new PropertyValueFactory<>("libelle"));
		loadTable();
	}
	private void loadTable(){
		iprofile =new ProfileDB();
		ObservableList<Profile> list_profile= FXCollections.observableArrayList();
		iprofile.liste().stream().forEach(p->list_profile.add(p));

		//charge tous les profile depuis la Bd
		profile_table.setItems(list_profile);
	}
}
