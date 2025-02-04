package iticbcn.cat;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private int aforament;
    private List<Assistent> asistents = new ArrayList<>();

    public Esdeveniment(int aforament) {
        if (aforament > 10) {
            throw new IllegalArgumentException("L'aforament no pot ser més gran que 10");
        }
        this.aforament = aforament;
    }

    public synchronized void ferReserva(Assistent asistent) throws InterruptedException {
        while (asistents.size() >= aforament) {
            wait();  // Espera si no hay plazas disponibles
        }
        asistents.add(asistent);
        System.out.println("L'assistent " + asistent.getNom() + " ha fet una reserva. Places disponibles: " + (aforament - asistents.size()));
        notifyAll();  // Notifica a los asistentes esperando
    }

    public synchronized void cancelaReserva(Assistent asistent) {
        if (asistents.remove(asistent)) {
            System.out.println("L'assistent " + asistent.getNom() + " ha cancel·lat la reserva. Places disponibles: " + (aforament - asistents.size()));
            notifyAll();  // Notifica que hay una plaza libre
        } else {
            System.out.println("L'assistent " + asistent.getNom() + " no ha pogut cancel·lar una reserva inexistent.");
        }
    }
}
