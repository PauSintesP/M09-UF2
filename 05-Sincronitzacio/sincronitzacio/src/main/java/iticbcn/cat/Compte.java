package iticbcn.cat;

public class Compte {

    private float saldo;
    private static Compte instance = null;

    private Compte() {
        this.saldo = 0;
    }

    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public synchronized void retirar(float quantitat) {
        saldo -= quantitat;
    }
}
