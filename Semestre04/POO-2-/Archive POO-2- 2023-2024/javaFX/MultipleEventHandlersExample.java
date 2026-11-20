import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MultipleEventHandlersExample extends Application {

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
        primaryStage.setTitle("Multiple Event Handlers Example");
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

        // Ajout des deux gestionnaires d'événements au bouton en utilisant addEventHandler
       // button.addEventHandler(MouseEvent.MOUSE_CLICKED, firstHandler);
        //button.addEventHandler(MouseEvent.MOUSE_CLICKED, secondHandler);
        button.setOnMouseClicked(firstHandler);
        button.setOnMouseClicked(secondHandler);
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
