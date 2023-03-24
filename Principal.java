/* ***************************************************************
* Autor............: Luan Pinheiro Azevedo
* Matricula........: 202110904
* Inicio...........: 21/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: Arvore genealógica em Java
* Funcao...........: Simulação de uma arvore hereditaria utilizando divizao de processos com thread na linguagem java,
com GUI.
*************************************************************** */

//Importacao de bibliotecas necessarias na classe principal
import controller.ControllerThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application{
  private static Scene startTreeScene;
  ControllerThread cT = new ControllerThread();

  //classe principal 
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {
    try {
      //definicao de icone e localizando no diretorio
      primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("./view/treeIcon.png")));
      //setando o nome da aplicacao
      primaryStage.setTitle("Árvore das Gerações");
      //impedindo a mudanca na resolucao das janelas, travando redimencionamento
      primaryStage.resizableProperty().setValue(false);

      //carregando os arquivos da tela e gerando novas cenas
      Parent treeScene = FXMLLoader.load(getClass().getResource("./view/arvoreGen.fxml"));
      startTreeScene = new Scene(treeScene);

      //atribuindo o aquivo xml da cena inicial e exibindo a cena na janela
      primaryStage.setScene(startTreeScene);
      primaryStage.show();

    } catch (Exception e) {
      e.printStackTrace();// mensagem padrão do java em caso de erro 
    }
  }
}

