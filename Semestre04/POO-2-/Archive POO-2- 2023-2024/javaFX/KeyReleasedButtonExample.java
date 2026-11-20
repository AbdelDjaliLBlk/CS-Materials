// Import necessary packages
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class KeyReleasedButtonExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Button node
        Button button = new Button("Press a key");
        Button button2 = new Button("autre bouton");

        // Create a handler for the KEY_RELEASED event
        EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // Code to execute when a key is released
                button.setText("Touche libérée : " + event.getText());
            }
        };

        // Add the KEY_RELEASED event handler to the button
        button.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

        // Create a layout (e.g., StackPane) and add the button
         FlowPane root = new FlowPane(10, 20);
        root.getChildren().add(button);
        root.getChildren().add(button2);

        // Create a scene and set the root node
        Scene scene = new Scene(root, 300, 200);
        //scene.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
        // Set the scene on the primary stage and display it
        primaryStage.setScene(scene);
        primaryStage.setTitle("Key Released Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
