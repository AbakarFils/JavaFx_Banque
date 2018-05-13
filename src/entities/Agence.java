package entities;

import java.util.ArrayList;
import java.util.List;

public class Agence {
    private String numero;
    private String nom;
    private String tel;
    private String adress;
    private List<Compte> comptes =new ArrayList<>();
    private List<Employe> employes =new ArrayList<>();

    public Agence(String numero, String nom, String tel) {
        this.numero = numero;
        this.nom = nom;
        this.tel = tel;
    }

    public Agence() {
    }
     public void setAdress(String address){
    	 this.adress=address;
     }

     public String getAdress() {
    	 return adress;

	}
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
