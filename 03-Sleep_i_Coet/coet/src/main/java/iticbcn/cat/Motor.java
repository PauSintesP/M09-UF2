package iticbcn.cat;

import java.util.Random;

public class Motor implements Runnable {
    private int potenciaActual;
    private int potenciaObjectiu;
    private boolean apagat;

    public Motor() {
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.apagat = false;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        if (p == 0) {
            this.apagat = true;
        } else {
            this.apagat = false;
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            while (true) {
                while (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("Motor %s: Incre. Objectiu: %d Actual: %d%n",
                            Thread.currentThread().getId(), potenciaObjectiu, potenciaActual);
                    Thread.sleep(rand.nextInt(2000 - 1000 + 1) + 1000);
                }

                while (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.printf("Motor %s: Decreix. Objectiu: %d Actual: %d%n",
                            Thread.currentThread().getId(), potenciaObjectiu, potenciaActual);
                    Thread.sleep(rand.nextInt(2000 - 1000 + 1) + 1000);
                }

                if (apagat && potenciaActual == 0) {
                    System.out.printf("Motor %s: No Fa res Objectiu: %d Actual: %d%n",
                            Thread.currentThread().getId(), potenciaObjectiu, potenciaActual);
                    break;
                }

                if (potenciaActual == potenciaObjectiu) {
                    System.out.printf("Motor %s: No Fa res Objectiu: %d Actual: %d%n",
                            Thread.currentThread().getId(), potenciaObjectiu, potenciaActual);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
