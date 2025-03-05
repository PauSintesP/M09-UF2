package itic.bcn;

public class Barri {
    public static void main(String[] args) throws InterruptedException {
        Estanc estanc = new Estanc();
        Thread[] fumadors = new Thread[3];

        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Thread(new Fumador(estanc, i));
            fumadors[i].start();
        }

        Thread estancThread = new Thread(() -> {
            try {
                estanc.nouSubministrament();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        estancThread.start();

        for (Thread fumador : fumadors) {
            fumador.join();
        }

        estanc.tancarEstanc();
        estancThread.join();
    }
}
