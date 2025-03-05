import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int iniciGana;
    private int fiGana;
    private int gana;
    private final Random random = new Random();

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " pensant");
        iniciGana = (int) System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000) + 1000); // Pensar entre 1s i 2s
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " menja amb gana " + gana);
        Thread.sleep(random.nextInt(1000) + 1000); // Menjar entre 1s i 2s
        fiGana = (int) System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
        System.out.println("Filòsof: fil" + id + " ha acabat de menjar");
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            if (esquerra.agafar()) {
                System.out.println("Filòsof: fil" + id + " agafa la forquilla esquerra " + esquerra.getId());
                if (dreta.agafar()) {
                    System.out.println("Filòsof: fil" + id + " agafa la forquilla dreta " + dreta.getId());
                    break;
                } else {
                    esquerra.deixar();
                    System.out.println("Filòsof: fil" + id + " deixa la forquilla esquerra " + esquerra.getId() + " i espera");
                    gana += 1;
                    System.out.println("Filòsof: fil" + id + " gana=" + gana);
                    Thread.sleep(random.nextInt(500) + 500); // Esperar entre 0.5s i 1s
                }
            } else {
                System.out.println("Filòsof: fil" + id + " espera forquilla esquerra " + esquerra.getId());
                Thread.sleep(random.nextInt(500) + 500); // Esperar entre 0.5s i 1s
            }
        }
    }

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println("Filòsof: fil" + id + " deixa les forquilles");
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}