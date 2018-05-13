package entities;

import java.util.Date;

public class CompteEpargne extends Compte {
    private Double taux=0.07;
    @Override
    public void retirer(double mt) {
        if(mt>solde) throw new  RuntimeException("Vous ne pouvez pas effectuer cette operation");
        Retrait retrait =new Retrait(operations.size()+1, (java.sql.Date) new Date(),mt);
        operations.add(retrait);
        solde=solde-mt;
    }

    @Override
    public void updatSolde(double mt) {
        solde=solde+(taux*solde/100);

    }

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(int code, double solde,String etat) {
        super(code, solde, etat);

    }
}
