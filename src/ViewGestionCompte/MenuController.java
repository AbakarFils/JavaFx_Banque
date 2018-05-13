package ViewGestionCompte;

import java.io.IOException;

import BanqueMessage.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button courant;

    @FXML
    private Button compteEpargne;

    @FXML
    private Button btn_gest_emp;

    @FXML
    private Button Client;

    @FXML
    void Creer_CompteCpourant(ActionEvent event) throws IOException {
    	Outils.load(event, "/ViewgestionCompte/CompteCourant.fxml", "client");

    }

    @FXML
    void Creer_CompteEpargne(ActionEvent event) throws IOException {
    	Outils.load(event, "/ViewgestionCompte/CompteEpargne.fxml", "client");

    }

    @FXML
    void gest_Client(ActionEvent event) throws IOException {
    	Outils.load(event, "/ViewClient/Client.fxml", "client");

    }

    @FXML
    void Gestion_Emp(ActionEvent event) throws IOException {
    	Outils.load(event, "/ViewEmploye/Employe.fxml", "client");

    }

}
