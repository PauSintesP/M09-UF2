package iticbcn.cat;

public class Forquilla {
    private final int numero;
    private boolean enUs;

    public Forquilla(int numero) {
        this.numero = numero;
        this.enUs = false;
    }

    public boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    public void deixar() {
        enUs = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEnUs() {
        return enUs;
    }
}