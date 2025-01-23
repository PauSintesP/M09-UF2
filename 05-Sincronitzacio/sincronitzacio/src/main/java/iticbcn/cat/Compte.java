package iticbcn.cat;

public class Compte {

    private float saldo;
    private static Compte instance = null;

    private Compte() {
        this.saldo = 0;
    }

    public static Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}