package model;

import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadSegundoFilho extends Thread{
  ControllerThread cT;
  ThreadSegundoNeto segundoNeto = new ThreadSegundoNeto();
  private int idade = 0;

  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }

  public int getIdade() {
    return idade;
  } 
  @Override
  public void run(){
    for(idade = 0; idade <=55; idade++){
      Platform.runLater(() -> cT.exibeIdadeSegundoFilho());
      try {
        if(idade >=4 && idade<=15){
          cT.trocaFazeVidaSFilho("./view/crianca.png");
        }
        if(idade>=16 && idade <=55){
          cT.trocaFazeVidaSFilho("./view/homem.png");
          if(idade == 20){
            System.out.println("O segundo neto nasceu (Segundo filho)" + " aos" + idade + "anos\n");
            cT.comecaSegundoNeto();
          }
          if(idade == 55){
            cT.trocaFazeVidaSFilho("./view/lapide.png");
            System.out.println("O segundo filho morreu!" + " aos " + idade + " anos\n");
          } 
        } 
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
