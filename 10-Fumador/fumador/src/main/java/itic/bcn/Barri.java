package itic.bcn;

public class Barri {

    static private Estanc estanc;
    private static final Fumador[] fumadors = new Fumador[3];
  
    public static void main(String[] args) {
  
      estanc = new Estanc();
  
      for (int i = 0; i < 3; i++) {
        fumadors[i] = new Fumador(estanc, i);
      }
      
      for (Fumador fumador: fumadors) {
        fumador.start();
      }
  
      estanc.start();
  
      for (Fumador fumador: fumadors) {
        try {
          fumador.join();
          
        } catch (InterruptedException e) {
        }
      }
  
      estanc.tancarEstanc();
  
    }
  }