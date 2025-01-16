package iticbcn.cat;


public class Coet {
    private Motor[] motors;
    private Thread[] fils;

    public Coet() {
        motors = new Motor[4];
        fils = new Thread[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor();
            fils[i] = new Thread(motors[i]);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: Potència fora del rang permès (0-10)");
            return;
        }
        System.out.printf("Passant a potència %d%n", p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {


        System.out.print("Introdueix la potència objectiu (0 per apagar): ");
        int potencia = Integer.parseInt(Entrada.readLine());
        for (Thread fil : fils) {
            fil.start();
        }

        while (potencia != 0) {
            passaAPotencia(potencia);
            System.out.print("Introdueix la potència objectiu (0 per apagar): ");
            potencia = Integer.parseInt(Entrada.readLine());
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
    }
}
