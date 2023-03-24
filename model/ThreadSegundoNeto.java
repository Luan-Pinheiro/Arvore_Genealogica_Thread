package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadSegundoNeto extends Thread{
  ControllerThread cT;
  private int idade = 0;

  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }

  public int getIdade() {
    return idade;
  }

  @Override
  public void run(){
    for(idade = 0; idade <=33; idade++){
      Platform.runLater(() -> cT.exibeIdadeSegundoNeto());
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaSNeto("./view/crianca.png");
      }
      if(idade>=16 && idade <=55){
        if(idade == 33){
          cT.trocaFazeVidaSNeto("./view/lapide.png");
          System.out.println("O segundo neto morreu!" + " aos " + idade + " anos\n");
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
