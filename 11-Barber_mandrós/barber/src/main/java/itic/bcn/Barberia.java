package itic.bcn;

import java.util.LinkedList;

public class Barberia extends Thread {
    private LinkedList<Client> espera;
    private int cadiresLliures;
    public final Object condBarber = new Object();
    private static Barberia instancia;

    public Barberia(int cadiresLliures) {
        this.cadiresLliures = cadiresLliures;
        this.espera = new LinkedList<>();
    }

    public static Barberia getInstancia(int cadiresLliures) {
        if (instancia == null) {
            instancia = new Barberia(cadiresLliures);
        }
        return instancia;
    }

    public synchronized Client seguentClient() {
        return espera.poll();
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (espera.size() < cadiresLliures) {
                espera.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            dormir(500);
        }
        dormir(10000);
        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            dormir(500);
        }
    }

    private void dormir(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
