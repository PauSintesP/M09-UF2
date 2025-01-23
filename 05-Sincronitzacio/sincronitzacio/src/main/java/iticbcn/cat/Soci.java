package iticbcn.cat;

import java.util.Random;

public class Soci extends Thread {

    Compte compte;

    private final float aportacio = 10f;

    private final int esperaMax = 100;

    private final int maxAnys = 10;

    Random rand = new Random();

    public Soci() {

        this.compte = Compte.getInstance();
    }

    public Compte getCompte() {

        return compte;
    }

    @Override
    public void run() {

        for (int any = 0; any < maxAnys; any++) {
            for (int mes = 1; mes <= 12; mes++) {
                try {
                    Thread.sleep(rand.nextInt(esperaMax));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (mes % 2 == 0) {
                    compte.setSaldo(compte.getSaldo() + aportacio);
                } else {
                    compte.setSaldo(compte.getSaldo() - aportacio);
                }
            }
        }
    }
}
