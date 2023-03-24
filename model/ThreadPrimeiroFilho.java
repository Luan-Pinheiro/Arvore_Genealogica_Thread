package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadPrimeiroFilho extends Thread{
  ControllerThread cT;
  ThreadPrimeiroNeto primeiroNeto = new ThreadPrimeiroNeto();
  private int idade = 0;

  public void setIdade(int idade) {
    this.idade = idade;
  }
  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }
  public int getIdade() {
    return idade;
  }

  @Override
  public void run(){
    for(idade = 0; idade <=61; idade++){
      Platform.runLater(() -> cT.exibeIdadePrimeiroFilho());
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaPFilho("./view/crianca.png");
      }
      if(idade>=16 && idade <=55){
        cT.trocaFazeVidaPFilho("./view/homem.png");
        if(idade == 16){
          System.out.println("O primeiro neto nasceu!(Primeiro Neto)\n");
          cT.comecaPrimeiroNeto();
        }
      }
      if(idade >= 56 && idade <= 89){
        cT.trocaFazeVidaPFilho("./view/idoso.png");
      }
      if(idade == 61){
        System.out.println("O primeiro filho morreu!" + " aos " + idade + " anos\n");
        cT.trocaFazeVidaPFilho("./view/lapide.png");
      }  
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
