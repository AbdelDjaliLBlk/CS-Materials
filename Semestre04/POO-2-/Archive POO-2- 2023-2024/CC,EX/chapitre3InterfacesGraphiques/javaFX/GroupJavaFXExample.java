import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GroupJavaFXExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création des formes
        Circle circle = new Circle(50, 50, 30);
        circle.setFill(Color.BLUE);

        Rectangle rectangle = new Rectangle(100, 50, 100, 80);
        rectangle.setFill(Color.RED);

        // Création d'un groupe et ajout des formes
        Group group = new Group();
        group.getChildren().addAll(circle, rectangle);

        // Création de la scène et ajout du groupe
        Scene scene = new Scene(group, 300, 200);

        // Configuration de la scène principale
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exemple d'utilisation de Group");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
