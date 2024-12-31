package iticbcn.cat;

public class Main {
    public static void main(String[] args) {
        Futbolista[] jugadors = new Futbolista[Futbolista.NUM_JUGADORS];
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        System.out.println("Inici dels xuts --------------------");

        // Crear y empezar los hilos
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
            jugadors[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Futbolista jugador : jugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        // Mostrar estadísticas
        for (Futbolista jugador : jugadors) {
            System.out.printf("%-10s -> %2d gols%n", jugador.getName(), jugador.getNgols());
        }
    }
}
