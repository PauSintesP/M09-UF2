package itic.bcn;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;
    
    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    public static final int CAPACITAT_MAX = 3;
    
    private Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private ReentrantLock lockEstat = new ReentrantLock(true);
    
    public void entraHome(String nom) {
        boolean entered = false;
        while (!entered) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        estatActual = BANY_AMB_HOMES;
                        ocupants++;
                        System.out.println(nom + " entra al bany. Ocupants: " + ocupants);
                        entered = true;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
            if (!entered) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public void entraDona(String nom) {
        boolean entered = false;
        while (!entered) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        estatActual = BANY_AMB_DONES;
                        ocupants++;
                        System.out.println(nom + " entra al bany. Ocupants: " + ocupants);
                        entered = true;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
            if (!entered) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public void surtHome(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
        capacitat.release();
    }
    
    public void surtDona(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
        capacitat.release();
    }
    
    public static void main(String[] args) {
        BanyUnisex lavabo = new BanyUnisex();
        
        for (int i = 0; i < 5; i++) {
            new Home("Home-" + i, lavabo).start();
            new Dona("Dona-" + i, lavabo).start();
        }
    }
}
