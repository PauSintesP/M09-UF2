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

    // Each fumador already disposes of one ingredient.
    // They only need to purchase the two missing ingredients.
    private void compra() throws InterruptedException {
        switch (id) {
            // Fumador 0 already has Tabac, so buys Paper and Llumí
            case 0:
                System.out.println("Fumador " + id + " comprant Paper");
                estanc.venPaper();
                System.out.println("Fumador " + id + " comprant Llumí");
                estanc.venLlumi();
                break;
            // Fumador 1 already has Paper, so buys Tabac and Llumí
            case 1:
                System.out.println("Fumador " + id + " comprant Tabac");
                estanc.venTabac();
                System.out.println("Fumador " + id + " comprant Llumí");
                estanc.venLlumi();
                break;
            // Fumador 2 already has Llumí, so buys Tabac and Paper
            case 2:
                System.out.println("Fumador " + id + " comprant Tabac");
                estanc.venTabac();
                System.out.println("Fumador " + id + " comprant Paper");
                estanc.venPaper();
                break;
            default:
                throw new IllegalArgumentException("Identificador de fumador desconegut: " + id);
        }
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