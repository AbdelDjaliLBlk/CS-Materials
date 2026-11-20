import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InfosEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Cliquez ici");

        // Création d'un gestionnaire d'événements pour le clic de souris sur le bouton
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Source de l'événement
                Object source = event.getSource();

                // Type d'événement
                String eventType = event.getEventType().toString();

                // Données de l'événement
                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();

                System.out.println("Événement " + eventType + " généré depuis " + source + " aux coordonnées (" + mouseX + ", " + mouseY + ")");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Exemple d'événement JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
