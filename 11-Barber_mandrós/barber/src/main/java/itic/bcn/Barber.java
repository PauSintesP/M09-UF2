package itic.bcn;


public class Barber extends Thread {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client == null) {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + nom + " dormint");
                synchronized (barberia.condBarber) {
                    try {
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
            }
        }
    }
}
