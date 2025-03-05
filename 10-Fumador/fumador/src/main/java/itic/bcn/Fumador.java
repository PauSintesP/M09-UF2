package itic.bcn;

import java.util.Random;

public class Fumador implements Runnable {
    private final Estanc estanc;
    private final int id;
    private int fumades = 0;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    private void fuma() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant");
        Thread.sleep(500 + new Random().nextInt(500));
        fumades++;
        System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
    }

    private void compra() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Tabac");
        estanc.venTabac();
        System.out.println("Fumador " + id + " comprant Paper");
        estanc.venPaper();
        System.out.println("Fumador " + id + " comprant Llumí");
        estanc.venLlumi();
    }

    @Override
    public void run() {
        try {
            while (fumades < 3) {
                compra();
                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
