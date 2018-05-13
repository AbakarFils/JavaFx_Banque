package entities;

import java.util.Date;

public class Client extends Personne {
    private double salaire;
    private String domaine;

    public Client(String nom, String prenom, String tel, String adresse, String numPiece, Date dateNaiss,String photo, double salaire, String domaine) {
        super(nom, prenom, tel, adresse, numPiece, dateNaiss, photo);
        this.salaire = salaire;
        this.domaine = domaine;
    }

    public Client(double salaire) {
        this.salaire = salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}
