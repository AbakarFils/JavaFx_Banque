package ViewGestionCompte;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import Banque.Dao.AgenceDB;
import Banque.Dao.EmployeDB;
import Banque.Dao.IAgence;
import Banque.Dao.IEmploye;
import entities.Agence;
import entities.CompteEpargne;
import entities.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CompteEpargneController implements Initializable {
	private IAgence Iagence;
	private IEmploye Iemploye;

    @FXML
    private TextField solde_txt;

    @FXML
    private TextField numero_txt;

    @FXML
    private ComboBox<String> conseille_idCombo;

    @FXML
    private TableView<CompteEpargne> table_Comtpagne;

    @FXML
    private Label id_conseiller;

    @FXML
    private TableColumn<CompteEpargne, String> numCompt_coloumn;
    @FXML
    private TableColumn<CompteEpargne, String> etat_column;
    @FXML
    private TableColumn<CompteEpargne, Date> dateCreation_column;

    @FXML
    private TextField numPiece_txt;

    @FXML
    private TableColumn<CompteEpargne, Double> solde_column;

    @FXML
    private Button rechercher;

    @FXML
    private Button Valider;

    @FXML
    private ComboBox<String> agence_idCombo;

    @FXML
    void Rechercher(ActionEvent event) {

    }

    @FXML
    void Valider(ActionEvent event) {

    }
    private void chargeurDonnees(){
    	Iagence = new AgenceDB();
		ObservableList<String> liste_Agence= FXCollections.observableArrayList();
		Iagence.liste().stream().forEach(a->liste_Agence.add(a.getNumero()));
		agence_idCombo.setItems(liste_Agence);

		Iemploye =new EmployeDB();
		ObservableList<String> listEmploye =FXCollections.observableArrayList();
		Iemploye.liste().stream().forEach(e->listEmploye.add(e.getNom()));
		conseille_idCombo.setItems(listEmploye);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		numCompt_coloumn.setCellValueFactory(new PropertyValueFactory<>("code"));
		solde_column.setCellValueFactory(new PropertyValueFactory<>("solde"));
		etat_column.setCellValueFactory(new PropertyValueFactory<>("etat"));
		dateCreation_column.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
		chargeurDonnees();
	}

}
