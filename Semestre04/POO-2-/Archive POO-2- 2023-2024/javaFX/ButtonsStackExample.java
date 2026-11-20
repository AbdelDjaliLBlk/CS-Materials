import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonsStackExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Création des boutons
        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");
        button1.setPrefSize(300, 200);
        button2.setPrefSize(200, 100);
        // Création d'un conteneur StackPane
        StackPane stackPane = new StackPane();

        // Ajout des boutons au StackPane
        stackPane.getChildren().addAll(button1, button2, button3);

        // Gestionnaire d'événements pour le bouton 3
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(button3); // Supprime le bouton 3 du StackPane
            }
        });

        // Gestionnaire d'événements pour le bouton 2
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(button2); // Supprime le bouton 2 du StackPane
            }
        });

        // Gestionnaire d'événements pour le bouton 1
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(button1); // Supprime le bouton 1 du StackPane
            }
        });

        // Création de la scène et ajout du StackPane à la scène
        Scene scene = new Scene(stackPane, 300, 200);

        // Définition du titre de la fenêtre
        primaryStage.setTitle("Destroy Buttons Example");

        // Ajout de la scène à la fenêtre
        primaryStage.setScene(scene);

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
