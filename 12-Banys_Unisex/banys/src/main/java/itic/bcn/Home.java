package itic.bcn;

public class Home extends Thread {
    private String nom;
    private BanyUnisex lavabo;
    
    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }
    
    @Override
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        lavabo.entraHome(nom);
        try {
            Thread.sleep((int) (Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        lavabo.surtHome(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}
 