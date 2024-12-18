public class Fil extends Thread {

    private final String nom;
    private final int mode;

    public Fil(String nom, int mode) {
        if (mode < 1 || mode > 3) {
            throw new IllegalArgumentException("Mode no vàlid");
        }
        this.nom = nom;
        this.mode = mode;
    }

    @Override
    public void run() {
        switch (mode) {
            case 1:
                comportament1();
                break;
            case 2:
                comportament2();
                break;
            case 3:
                comportament3();
                break;
        }
        System.out.println("Termina el fil " + nom);
    }

    private void comportament1() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nom + " " + i);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void comportament2() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nom + " " + i);
            try {
                if ("Pepe".equals(nom)) {
                    Thread.sleep(50);
                } else {
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void comportament3() {
        synchronized (Fil.class) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(nom + " " + i);
                try {
                    Fil.class.notify();
                    Fil.class.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            Fil.class.notifyAll();
        }
    }
}
