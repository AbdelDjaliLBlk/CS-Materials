import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleJavaFXApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Création d'un libellé
        Label label = new Label("Hello, JavaFX!");

        // Création d'une mise en page (layout) StackPane
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Création de la scène avec une largeur et une hauteur spécifiques
        Scene scene = new Scene(root, 300, 200);

        // Définition de la scène sur la scène principale (primaryStage)
        primaryStage.setScene(scene);

        // Définition du titre de la fenêtre
        primaryStage.setTitle("Simple JavaFX Application");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        launch(args);
    }
}
