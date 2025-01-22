package iticbcn.cat;

public class Administracio {
    private static final int NUM_POBLACIO = 50;
    private Treballador[] poblacioActiva = new Treballador[NUM_POBLACIO];

    public Administracio() {
        for (int i = 0; i < NUM_POBLACIO; i++) {
            poblacioActiva[i] = new Treballador(25000, 20, 65, "Ciutada-" + i);
        }
    }

    public void iniciarSimulacio() {
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mostrarEstadistiques();
    }

    private void mostrarEstadistiques() {
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s - edat: %d = %.2f%n",
                    treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.iniciarSimulacio();
    }
}
