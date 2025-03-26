package itic.bcn;

public class Dona extends Thread {
    private String nom;
    private BanyUnisex lavabo;
    
    public Dona(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }
    
    @Override
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        lavabo.entraDona(nom);
        try {
            Thread.sleep((int) (Math.random() * 1000) + 2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        lavabo.surtDona(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}
