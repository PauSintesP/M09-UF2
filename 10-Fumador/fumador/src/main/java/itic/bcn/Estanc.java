package itic.bcn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {

  private static Random rnd = new Random();

  private List<Tabac> tabacs;
  private List<Llumi> llumins;
  private List<Paper> papers;
  private boolean obert = false;

  public Estanc() {

    tabacs = new ArrayList<>();

    llumins = new ArrayList<>();

    papers = new ArrayList<>();
    
  }

  synchronized public void nouSubministrament() {

    int valor = rnd.nextInt(3);

    switch (valor) {

      case 0 -> afegirTabac();
      case 1 -> afegirLlumi();
      case 2 -> afegirPaper();
    }

    notifyAll();

  }

  public void afegirTabac() { 

    System.out.println("Afegint Tabac");

    tabacs.add(new Tabac()); 
  }
  
  public void afegirLlumi() { 

    System.out.println("Afegint Llumi");

    llumins.add(new Llumi()); 
  }
  
  public void afegirPaper() { 

    System.out.println("Afegint Paper");

    papers.add(new Paper()); 
  }

  public Tabac vendreTabac() { 

    if (!tabacs.isEmpty()) {

      return tabacs.remove(tabacs.size() - 1);
    }
    else return null;
  }

  public Llumi vendreLlumi() { 

    if (!llumins.isEmpty()) return llumins.remove(llumins.size() - 1);
    
    else return null;
  }

  public Paper vendrePaper() { 

    if (!papers.isEmpty()) return papers.remove(papers.size() - 1);

    else return null;
  }

  @Override
  public void run() {

    obert = true;
    System.out.println("Estanc obert");

    while (obert) {
      nouSubministrament();
      
      try {
        Thread.sleep(rnd.nextInt(1000) + 500);
      } catch (InterruptedException e) {
        obert = false;
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("Estanc Tancat");

  }

  public void tancarEstanc() { obert = false; }

}