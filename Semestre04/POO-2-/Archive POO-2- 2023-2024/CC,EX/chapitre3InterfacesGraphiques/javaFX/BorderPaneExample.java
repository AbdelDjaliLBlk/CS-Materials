import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un BorderPane
        BorderPane borderPane = new BorderPane();

        // Création de boutons pour chaque région du BorderPane
        Button topButton = new Button("Top");
        Button leftButton = new Button("Left");
        Button centerButton = new Button("Center");
        Button rightButton = new Button("Right");
        Button bottomButton = new Button("Bottom");

        // Placement des boutons dans les différentes régions du BorderPane
        borderPane.setTop(topButton);
        borderPane.setLeft(leftButton);
        borderPane.setCenter(centerButton);
        borderPane.setRight(rightButton);
        borderPane.setBottom(bottomButton);

        // Création d'une scène
        Scene scene = new Scene(borderPane, 400, 300);

        // Configuration de la scène et affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
