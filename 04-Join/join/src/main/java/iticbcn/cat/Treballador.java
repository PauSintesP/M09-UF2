package iticbcn.cat;

import java.util.Random;

public class Treballador extends Thread {
    private float nouAnualBrut;

    private int edatIniciTreball;

    private int edatFiTreball;

    private int edatActual = 0;

    private float cobrat = 0.0f;
    
    private Random rnd = new Random();

    public Treballador(float nouAnualBrut, int edatIniciTreball, int edatFiTreball, String nom) {

        super(nom);

        this.nouAnualBrut = nouAnualBrut;

        this.edatIniciTreball = edatIniciTreball;

        this.edatFiTreball = edatFiTreball;

    }

    private void cobra() {

        cobrat += nouAnualBrut / 12;

    }

    private void pagaImpostos() {

        cobrat -= (nouAnualBrut / 12) * 0.24;

    }

    public float getCobrat() {

        return cobrat;

    }

    public int getEdat() {

        return edatActual;

    }

    @Override
    public void run() {

        while (edatActual < edatFiTreball) {
            if (edatActual >= edatIniciTreball) {
                cobra();
                pagaImpostos();
            }
            edatActual++;
            try {
                Thread.sleep(rnd.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
