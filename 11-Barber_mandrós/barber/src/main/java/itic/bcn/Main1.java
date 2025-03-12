package itic.bcn;

public class Main1 {
    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstancia(3);
        Barber barber = new Barber("Juanca", barberia);

        barber.start();
        barberia.start();
    }
}
