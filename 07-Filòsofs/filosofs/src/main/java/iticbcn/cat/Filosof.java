package iticbcn.cat;

public class Filosof extends Thread {
    private final String nom;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof " + nom + " està pensant.");
        Thread.sleep((long) (Math.random() * 1000) + 1000);
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (esquerra.agafar()) {
                System.out.println("Filòsof " + nom + " agafa la forquilla esquerra " + esquerra.getNumero());
                if (dreta.agafar()) {
                    System.out.println("Filòsof " + nom + " agafa la forquilla dreta " + dreta.getNumero());
                    System.out.println("Filòsof " + nom + " està menjant.");
                    Thread.sleep((long) (Math.random() * 1000) + 1000);
                    dreta.deixar();
                    System.out.println("Filòsof " + nom + " deixa la forquilla dreta " + dreta.getNumero());
                    esquerra.deixar();
                    System.out.println("Filòsof " + nom + " deixa la forquilla esquerra " + esquerra.getNumero());
                    break;
                } else {
                    esquerra.deixar();
                    System.out.println("Filòsof " + nom + " deixa la forquilla esquerra " + esquerra.getNumero() + " i espera (dreta ocupada)");
                    gana++;
                    System.out.println("Filòsof " + nom + " gana=" + gana);
                    Thread.sleep((long) (Math.random() * 500) + 500);
                }
            } else {
                Thread.sleep((long) (Math.random() * 500) + 500);
            }
        }
    }
}