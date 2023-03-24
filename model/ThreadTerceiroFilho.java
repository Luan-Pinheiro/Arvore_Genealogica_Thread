//pacote da classe
package model;
//Importacao de bibliotecas
import controller.ControllerThread;
import javafx.application.Platform;

public class ThreadTerceiroFilho extends Thread{
  ControllerThread cT;
  private int idade = 0;

  /*Metodo para conectar o Controle a esta Thread, evitando um estouro de memoria.
  Fator decorrente de uma 'recursao' sem caso base, originada em uma 
  chamada reciproca entre a Thread e o ControllerThread
  */
  public void linkaControlador(ControllerThread cT){
    this.cT = cT;
  }

  //Obtencao do valor de um atributo encapsulado
  public int getIdade() {
    return idade;
  }
  //metodo run da Thread
  @Override
  public void run(){
    for(idade = 0; idade <=55; idade++){
      //Atualizando a idade em tempo real na tela pelo 'Platform.runlater' sobre a funcao de exibicao da idade do ente familiar
      Platform.runLater(() -> cT.exibeIdadeTerceiroFilho());
      if(idade >=4 && idade<=15){
        cT.trocaFazeVidaTFilho("./view/crianca.png");//
      }
      if(idade>=16 && idade <=55){
        if(idade == 55){
          cT.trocaFazeVidaTFilho("./view/lapide.png");
          System.out.println("O terceiro filho morreu!" + " aos " + idade + " anos\n");
        }   
      }
      try {
        //estabelecendo tempo de 1000 milisegundos ou 1 segundo por iteacao no for
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();//print padrao em caso de erro
      }

    }
  }
}
