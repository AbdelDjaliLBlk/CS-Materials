import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
// C'est une Application
public class SceneJavaFX extends Application {
    
    // Point de départ
    @Override
    public void start(Stage primaryStage) throws Exception {
        Color c=Color.web("rgb(50%,25%,80%)"); // Color.web("#0000FF"); ou Color.rgb(50,25,180); 
        //Color c=Color.YELLOW;
        
        // Dimensions en double et une couleur.
        Scene scene= new Scene(new Group(),400.0, 200.0,c); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mon premier programme javaFX");
        primaryStage.initStyle(StageStyle.UNDECORATED); 
        primaryStage.show();    
    }

    // Méthode principale pour lancer l'application mais n'est plus obligatoire
    public static void main(String[] args) {
        launch(args);
    }
}
