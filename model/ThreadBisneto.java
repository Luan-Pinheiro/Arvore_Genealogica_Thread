package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadBisneto extends Thread{
  ControllerThread cT;
  private int idade = 0;

  public int getIdade() {
    return idade;
  }

  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }
  public void run(){
    for(idade = 0; idade <=12; idade++){
      Platform.runLater(() -> cT.exibeIdadeBisneto());
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaPBisneto("./view/crianca.png");
        if(idade == 12){
          cT.trocaFazeVidaPBisneto("./view/lapide.png");
          System.out.println("O primeiro bisneto morreu!" + " aos " + idade + " anos\n");
        }  
      }  
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
