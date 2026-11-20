import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddAndOnExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un bouton
        Button button = new Button("Cliquez ici");

        // Création d'un conteneur StackPane
        StackPane root = new StackPane();
        root.getChildren().add(button);

        // Création de la scène
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Event Handling Example");
        primaryStage.show();

        // Gestionnaire d'événements pour le bouton en utilisant addEventHandler
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Gestionnaire d'événements 1 - addEventHandler : Clic de souris détecté");
            }
        });

        // Gestionnaire d'événements pour le bouton en utilisant setOn
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Gestionnaire d'événements 2 - setOn : Clic de souris détecté");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
