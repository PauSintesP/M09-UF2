package itic.bcn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private final List<Tabac> tabacList = new ArrayList<>();
    private final List<Paper> paperList = new ArrayList<>();
    private final List<Llumi> llumiList = new ArrayList<>();
    private boolean obert = true;

    public synchronized void nouSubministrament() throws InterruptedException {
        Random random = new Random();
        while (obert) {
            int tipus = random.nextInt(3);
            switch (tipus) {
                case 0 -> addTabac();
                case 1 -> addPaper();
                case 2 -> addLlumi();
            }
            notifyAll(); 
            Thread.sleep(500 + random.nextInt(1000)); 
        }
    }

    public synchronized void addTabac() {
        tabacList.add(new Tabac());
        System.out.println("Afegint tabac");
    }

    public synchronized void addPaper() {
        paperList.add(new Paper());
        System.out.println("Afegint paper");
    }

    public synchronized void addLlumi() {
        llumiList.add(new Llumi());
        System.out.println("Afegint llumí");
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabacList.isEmpty()) wait();
        return tabacList.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while (paperList.isEmpty()) wait();
        return paperList.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llumiList.isEmpty()) wait();
        return llumiList.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
        System.out.println("Estanc tancat");
    }
}
