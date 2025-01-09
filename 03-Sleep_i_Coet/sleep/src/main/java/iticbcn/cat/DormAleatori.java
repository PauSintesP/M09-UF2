
package iticbcn.cat;

import java.util.Random;
/**
 *
 * @author pau
 */
public class DormAleatori extends Thread {

    private long momentCreat;

    public DormAleatori(String name) {
        super(name);
        this.momentCreat = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int interval = random.nextInt(1000) + 1;

            long finalTems = System.currentTimeMillis() - momentCreat;
            System.out.println(getName() + "(" + (i - 1) + ") a dormir " + interval + "ms total " + finalTems);
            
             try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        try {
            joan.join();
            pep.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------- Fi de main -----------");
    }
}

