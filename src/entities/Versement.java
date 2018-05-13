package entities;

import java.sql.Date;

public class Versement extends Operation {


    public Versement(int size, java.util.Date date, double mt) {
        super();
    }

    public Versement(int numero, Date dateOperation, double montant) {
        super(numero, dateOperation, montant);
    }
}
