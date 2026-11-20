import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class GroupTransformationExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Crée un groupe
        Group group = new Group();

        // Crée des rectangles et les ajoute au groupe
        Rectangle rectangle1 = new Rectangle(50, 50, Color.RED);
        rectangle1.setX(100);
        rectangle1.setY(100);
        group.getChildren().add(rectangle1);
        
        Rectangle rectangle2 = new Rectangle(50, 50, Color.BLUE);
        rectangle2.setX(200);
        rectangle2.setY(100);
        group.getChildren().add(rectangle2);

        // Crée une scène avec le groupe
        Scene scene = new Scene(group, 400, 300);

        // Applique des transformations au groupe
        
        // Translation (déplacement) de tout le groupe
        Translate translate = new Translate(50, 50);
        group.getTransforms().add(translate);
        
        
        
        // Rotation de tout le groupe
        Rotate rotate = new Rotate(30, 150, 150); // angle de rotation et pivot
        group.getTransforms().add(rotate);
        
        // Redimensionnement de tout le groupe
        Scale scale = new Scale(1.5, 1.5, 150, 150); // facteurs de redimensionnement et pivot
        group.getTransforms().add(scale);

        // Configure la scène pour le stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Group Transformation Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
