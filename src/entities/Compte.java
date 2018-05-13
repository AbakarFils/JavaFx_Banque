package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    private int code;
    private String etat;
    protected double solde;
    protected List<Operation> operations= new ArrayList<>(); // on peut faire +sieur operation sur un compte

    public Compte( ) {
    }

    public Compte(int code, double solde,String etat) {
        this.code = code;
        this.solde = solde;
        this.etat=etat;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void verser(double mt){
        //on sauvegarde cette operation
        Versement versement =new Versement(this.operations.size()+1,(java.sql.Date) new java.util.Date(),mt);
        operations.add(versement);
        solde+=mt;
    }
    public abstract void retirer(double mt);

    public void virement(double mt,Compte cp2){
        retirer(mt);//je retire du conmpte qui donne
        cp2.verser(mt);// je verse dans le compte bénéficière
    }

    public abstract void updatSolde(double mt);
}
