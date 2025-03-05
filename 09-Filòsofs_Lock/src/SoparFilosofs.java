class Taula {
    private final Filosof[] filosofts;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofts = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        
        for (int i = 0; i < numFilosofs; i++) {
            filosofts[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofts.length; i++) {
            System.out.println("Comensal:Fil" + i + " esq:" + i + " dret:" + (i + 1) % filosofts.length);
        }
        System.out.println("-----------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofts) {
            f.start();
        }
    }
}

public class SoparFilosofs {
    public static void main(String[] args) {
        int numFilosofs = 4;
        Taula taula = new Taula(numFilosofs);
        taula.showTaula();
        taula.cridarATaula();
    }
}