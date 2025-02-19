package itic.bcn;

class Taula {
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        int idx = 0;
        while (idx < numFilosofs) {
            forquilles[idx] = new Forquilla(idx);
            idx++;
        }
        for (int j = 0; j < numFilosofs; j++) {
            filosofs[j] = new Filosof(j, forquilles[j], forquilles[(j + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        int i = 0;
        for (; i < filosofs.length; i++) {
            System.out.println("Comensal: fil" + i + " esq:" + i + " dret:" + ((i + 1) % filosofs.length));
        }
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }
}