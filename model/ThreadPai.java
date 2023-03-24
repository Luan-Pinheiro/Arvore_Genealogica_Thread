package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadPai extends Thread{
  ControllerThread cT;
  ThreadPrimeiroFilho primeiroFilho = new ThreadPrimeiroFilho();
  ThreadSegundoFilho segundoFilho = new ThreadSegundoFilho();
  ThreadTerceiroFilho terceiroFilho = new ThreadTerceiroFilho();
  private int idade = 0;

  public void linkaControle(ControllerThread cT){
    this.cT = cT;
  }

  public int getIdade() {
    return idade;
  }
  @Override
  public void run(){
    for(idade = 0; idade <=90; idade++){
      Platform.runLater(()-> cT.exibeIdadePai());
      if(idade < 5){
        if(idade == 0){
          cT.comecaPai();
          System.out.println("O pai nasceu!\n");
        }
      }
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaPai("./view/crianca.png");
      }
      if(idade>=16 && idade <=55){
        cT.trocaFazeVidaPai("./view/homem.png");
        if(idade == 22){
          System.out.println("O primeiro filho nasceu!\n");
          cT.comecaPrimeiroFilho();
        }
        if(idade == 25){
          System.out.println("O segundo filho nasceu!\n");
          cT.comecaSegundoFilho();
        } 
        if(idade == 32){
          System.out.println("O terceiro filho nasceu!\n");
          cT.comecaTerceiroFilho();
        } 
      }
      if(idade >= 56 && idade <= 89){
        cT.trocaFazeVidaPai("./view/idoso.png");
      }
      if(idade == 90){
        cT.trocaFazeVidaPai("./view/lapide.png");
        System.out.println("O pai morreu!" + " aos " + idade + " anos\n");
      }  
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
