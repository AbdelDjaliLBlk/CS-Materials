import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
// C'est une Application
public class StyleJavaFX extends Application {
    
    // Point de départ
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.DECORATED); // Il y a aussi UNDECORATED et TRANSPARENT
        
        // // Exemple de méthodes à appeler dans start
        if (primaryStage.isAlwaysOnTop()) {
            System.out.println("La fenêtre est toujours au-dessus des autres fenêtres.");
        } else {
            System.out.println("La fenêtre n'est pas configurée pour être toujours au-dessus des autres fenêtres.");
        }
        primaryStage.show();    
    }

    // Méthode principale pour lancer l'application mais n'est plus obligatoire
    // public static void main(String[] args) {
        
        // launch(args);
    // }
}
