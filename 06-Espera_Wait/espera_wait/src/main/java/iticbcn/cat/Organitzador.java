package iticbcn.cat;

public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);

        for (int i = 0; i < 10; i++) {
            Assistent assistent = new Assistent(esdeveniment, "Assistent-" + i);
            new Thread(assistent).start();
        }
    }
}
