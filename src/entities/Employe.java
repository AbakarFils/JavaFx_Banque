package entities;

import java.util.Date;

public class Employe extends Personne {
    private int idProfile;
    private int idAgence;//agence à laquelle il W

    public Employe(){

    }

    public Employe(String nom, String prenom, String tel, String adresse, String numPiece, Date dateNaiss, String photo,int idProfile, int idAgence) {
        super(nom, prenom, tel, adresse, numPiece, dateNaiss, photo);
        this.idProfile = idProfile;
        this.idAgence = idAgence;
    }

    public Employe(int idProfile, int idAgence) {

        this.idProfile = idProfile;
        this.idAgence = idAgence;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }
}
