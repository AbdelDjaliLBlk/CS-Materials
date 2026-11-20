import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création de la fenêtre principale
        primaryStage.setTitle("Ma première application JavaFX");
        
        // Initialisation du style de la fenêtre (initStyle)
        primaryStage.initStyle(StageStyle.DECORATED); // Vous pouvez remplacer "DECORATED" par d'autres styles comme "UNDECORATED", "TRANSPARENT", etc.
        
        
        Color c=Color.YELLOW;
        // Création d'un layout simple
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250,c);
        
        // Assignation de la scène à la fenêtre principale
        primaryStage.setScene(scene);
        
        // Affichage de la fenêtre principale
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lancement de l'application
        launch(args);
    }
}
