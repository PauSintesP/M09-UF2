package iticbcn.cat;

public class Taula {
    
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("fil" + i, esquerra, dreta);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: " + filosofs[i].getName() + " esq: " + forquilles[i].getNumero() + " dret: " + forquilles[(i + 1) % filosofs.length].getNumero());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarATaula();
    }
}