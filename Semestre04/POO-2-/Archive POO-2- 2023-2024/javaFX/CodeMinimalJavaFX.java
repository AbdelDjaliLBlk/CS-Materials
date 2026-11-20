import javafx.application.Application;
import javafx.stage.Stage;

// C'est une Application
public class CodeMinimalJavaFX extends Application {
    
    // Point de départ
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();    
    }

    //Méthode principale pour lancer l'application mais n'est plus obligatoire
    public static void main(String[] args) {
        launch(args);
    }
}
