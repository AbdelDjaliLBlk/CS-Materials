import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;

public class FlowPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Crée un FlowPane avec un espacement de 10 pixels entre les éléments
        // 10 pour l'espacement horizontal et 20 pour l'espacement vertical
        FlowPane flowPane = new FlowPane(10, 20);
        
        // Définir l'orientation à verticale
        // flowPane.setOrientation(Orientation.VERTICAL);
        
        // Ajoute des boutons au FlowPane
        for (int i = 1; i <= 10; i++) {
            Button button = new Button("Button " + i);
            flowPane.getChildren().add(button);
        }

        // Crée une scène avec le FlowPane
        Scene scene = new Scene(flowPane, 300, 200);

        // Configure la fenêtre (stage)
        primaryStage.setTitle("FlowPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
