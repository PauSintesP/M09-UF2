package iticbcn.cat;

public class Organitzador {

    private String nom;

    private Esdeveniment esdeveniment;

    public void setEsdeveniment(Esdeveniment esdeveniment) {

        this.esdeveniment = esdeveniment;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Esdeveniment getEsdeveniment() {
        return esdeveniment;
    }  
    public String getNom() {
        return nom;
    } 

    
}
