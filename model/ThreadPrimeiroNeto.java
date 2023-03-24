package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadPrimeiroNeto extends Thread{
  ControllerThread cT;
  ThreadBisneto primeiroBisneto = new ThreadBisneto();
  private int idade = 0;

  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }
  public int getIdade(){
    return idade;
  }
  @Override
  public void run(){
    for(idade = 0; idade<=35; idade++){
      Platform.runLater(() -> cT.exibeIdadePrimeiroNeto());
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaPNeto("./view/crianca.png");
      }
      if(idade>=16 && idade <=55){
        cT.trocaFazeVidaPNeto("./view/homem.png");
        if(idade == 3){
          System.out.println("O primeiro bisneto nasceu (Primeiro filho)!" + " aos" + idade + "anos\n");
          cT.comecaPrimeiroBisneto();
        }
        if(idade == 35){
          cT.trocaFazeVidaPNeto("./view/lapide.png");
          System.out.println("O primeiro neto morreu!" + " aos " + idade + " anos\n");
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
