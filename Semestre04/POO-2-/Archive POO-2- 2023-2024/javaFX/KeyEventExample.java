import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class KeyEventExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer un Label pour afficher les événements de touche
        Label label = new Label("Appuyez sur une touche...");

        // Créer un gestionnaire d'événements pour KeyEvent.ANY
        // EventHandler<KeyEvent> keyEventHandler = event -> {
            // // Afficher les détails de l'événement de touche
            // label.setText("Touche appuyée : " + event.getText());
        // };

        EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // Afficher les détails de l'événement de touche
               
                    label.setText("Touche appuyée : " + event.getText()+ "  " + event.getEventType());
            }
        };

        // Attacher le gestionnaire d'événements à la scène
        Scene scene = new Scene(new StackPane(label), 300, 200);
        
        // pour KeyEvent.ANY
        scene.addEventHandler(KeyEvent.ANY, keyEventHandler);
        
        // pour KeyEvent.KEY_PRESSED
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEventHandler);
        
        // pour KeyEvent.KEY_RELEASED
        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEventHandler);
        
        // pour KeyEvent.KEY_TYPED
        scene.addEventHandler(KeyEvent.KEY_TYPED, keyEventHandler);
        
        
        

        // Configurer la scène et afficher la fenêtre
        primaryStage.setTitle("Exemple d'événements de touches");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
