package entities;

import java.sql.Date;

public class Retrait extends Operation {
    public Retrait() {
        super();
    }

    public Retrait(int numero, Date dateOperation, double montant) {
        super(numero, dateOperation, montant);
    }
}
