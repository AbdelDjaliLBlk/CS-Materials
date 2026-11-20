import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneExampleWithAlignment extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un BorderPane
        BorderPane borderPane = new BorderPane();

        // Création des éléments pour les différentes régions

        // Région Top
        HBox topHBox = new HBox(10); // Espacement de 10 entre les éléments
        topHBox.getChildren().addAll(new Button("Top Button 1"), new Button("Top Button 2"));
        topHBox.setAlignment(Pos.CENTER); // Centrage de HBox dans la région Top
        borderPane.setTop(topHBox);

        // Région Center
        Label centerLabel = new Label("This is the center region");
        borderPane.setCenter(centerLabel); // Ajout d'un label à la région Center
        // borderPane.setAlignment(centerLabel, Pos.CENTER); // Centrage du label dans la région Center

        // Région Bottom
        HBox bottomHBox = new HBox(10); // Espacement de 10 entre les éléments
        bottomHBox.getChildren().addAll(new Button("Bottom Button 1"), new Button("Bottom Button 2"));
        bottomHBox.setAlignment(Pos.CENTER); // Centrage de HBox dans la région Bottom
        borderPane.setBottom(bottomHBox);

        // Région Left
        VBox leftVBox = new VBox(10); // Espacement de 10 entre les éléments
        leftVBox.getChildren().addAll(new Button("Left Button 1"), new Button("Left Button 2"));
        leftVBox.setAlignment(Pos.CENTER); // Centrage de VBox dans la région Left
        borderPane.setLeft(leftVBox);

        // Région Right
        VBox rightVBox = new VBox(10); // Espacement de 10 entre les éléments
        rightVBox.getChildren().addAll(new Button("Right Button 1"), new Button("Right Button 2"));
        rightVBox.setAlignment(Pos.CENTER); // Centrage de VBox dans la région Right
        borderPane.setRight(rightVBox);

        // Création de la scène
        Scene scene = new Scene(borderPane, 400, 300);

        // Configuration de la scène et affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane Example with Alignment");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
