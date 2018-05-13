package entities;
import java.util.Date;
public class CompteCourant extends Compte {
    private double decouvert;
    @Override
    public void retirer(double mt) {
        // on peut retirer jusqu'a atteindre le decouvert mais pas plus
        if(mt>solde+decouvert) throw new  RuntimeException("Vous ne pouvez pas effectuer cette operation");
        Retrait retrait =new Retrait(operations.size()+1, (java.sql.Date) new Date(),mt);
        operations.add(retrait);
        solde=solde-mt;

    }

    @Override
    public void updatSolde(double mt) {

    }

    public CompteCourant(double decouvert) {
        super();
        this.decouvert = decouvert;
    }

    public CompteCourant(int code, double solde, double decouvert,String etat) {
        super(code, solde, etat);
        this.decouvert = decouvert;
    }
}
