package iticbcn.cat;

public class Associacio {

    private static final int NUM_SOCIS = 1000;
    private final Soci[] socis = new Soci[NUM_SOCIS];

    public Associacio() {
        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciarCompteTempsSocis() {

        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i].start();
        }
        
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < NUM_SOCIS; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void mostraBalancComptes() {
            System.out.println("Saldo: " + socis[0].getCompte().getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciarCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}
