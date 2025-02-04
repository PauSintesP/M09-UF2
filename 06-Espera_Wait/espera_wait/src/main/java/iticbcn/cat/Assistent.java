package iticbcn.cat;

import java.util.Random;

public class Assistent implements Runnable {
    private String nom;
    private Esdeveniment esdeveniment;
    private Random random = new Random();

    public Assistent(Esdeveniment esdeveniment, String nom) {
        this.esdeveniment = esdeveniment;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
