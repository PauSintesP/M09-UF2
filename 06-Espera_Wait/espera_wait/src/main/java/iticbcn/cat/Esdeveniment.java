package iticbcn.cat;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

    private int aforament;

    private List<Assistent> asistents = new ArrayList<Asistent>();

    public Esdeveniment(int aforament) {
        if  (aforament > 10) {
            throw new IllegalArgumentException("L'aforament no pot ser mes gran que 10");
        }
        else{
            this.aforament = aforament;
        }

        
    }
    
    public void ferReserva(Assistent asistent) {

        if (asistents.size() < ASISTENTS_MAXIMS) {
            asistents.add(asistent);
        } else {
            throw new IllegalStateException("No queden places disponibles");
        }
    }
    
    public void cancelaReserva(Assistent asistent) {
        if (asistents.remove(asistent)) {

        } else {
            throw new IllegalArgumentException("L'assistent no està a la llista");
        }
    }
}
