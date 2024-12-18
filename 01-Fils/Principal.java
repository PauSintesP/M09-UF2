public class Principal {
    public static void main(String[] args) {
        Fil filJuan = new Fil("Juan", 3);
        Fil filPepe = new Fil("Pepe", 3);

        filJuan.start();

        filPepe.start();
    }
}
