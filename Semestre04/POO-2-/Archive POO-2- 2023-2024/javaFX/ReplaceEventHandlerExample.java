import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReplaceEventHandlerExample extends Application {

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
        primaryStage.setTitle("Replace Event Handler Example");
        primaryStage.show();

        // Premier gestionnaire d'événements
        EventHandler<MouseEvent> firstHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Premier gestionnaire d'événements : Clic de souris détecté");
            }
        };

        // Deuxième gestionnaire d'événements
        EventHandler<MouseEvent> secondHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Deuxième gestionnaire d'événements : Clic de souris détecté");
            }
        };

        // Ajout du premier gestionnaire d'événements au bouton
        button.setOnMouseClicked(firstHandler);

        // Remplacement du premier gestionnaire d'événements par le deuxième gestionnaire d'événements
        button.setOnMouseClicked(secondHandler);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
