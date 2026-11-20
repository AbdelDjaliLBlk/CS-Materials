import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.Group;

public class GroupTransformationWithButton extends Application {
    private Group group;
    private int transformationIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        // Crée un groupe
        group = new Group();

        // Crée des rectangles et les ajoute au groupe
        Rectangle rectangle1 = new Rectangle(50, 50, Color.RED);
        rectangle1.setX(100);
        rectangle1.setY(100);
        group.getChildren().add(rectangle1);

        Rectangle rectangle2 = new Rectangle(50, 50, Color.BLUE);
        rectangle2.setX(200);
        rectangle2.setY(100);
        group.getChildren().add(rectangle2);

        // Crée un bouton pour déclencher les transformations
        Button transformButton = new Button("Appliquer Transformation");
        transformButton.setOnAction(event -> applyNextTransformation());

        // Crée un layout VBox pour contenir le groupe et le bouton
        VBox root = new VBox(group, transformButton);

        // Crée une scène avec le layout
        Scene scene = new Scene(root, 400, 300);

        // Configure et affiche le stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Group Transformation With Button");
        primaryStage.show();
    }

    // Appliquer la prochaine transformation sur le groupe
    private void applyNextTransformation() {
        switch (transformationIndex) {
            case 0:
                // Transformation 1: Translation (déplacement)
                Translate translate = new Translate(50, 50);
                group.getTransforms().add(translate);
                break;
            case 1:
                // Transformation 2: Rotation
                Rotate rotate = new Rotate(30, 150, 150);
                group.getTransforms().add(rotate);
                break;
            case 2:
                // Transformation 3: Redimensionnement
                Scale scale = new Scale(1.5, 1.5, 150, 150);
                group.getTransforms().add(scale);
                break;
        }

        // Incrémenter l'index de transformation pour la prochaine transformation
        transformationIndex++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
