import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Formes extends Application {
 @Override
 public void start(Stage primaryStage){
 primaryStage.setTitle("Deux Formes");
 Group groupe = new Group();
 Scene scene = new Scene(groupe,600,300, Color.LIGHTGRAY);
 Rectangle rect1 = new Rectangle(350,75,200,100);
 rect1.setFill(Color.RED);
 
 Circle cerc1 = new Circle(200,100,100);
 cerc1.setFill(Color.BLUE);
 
 groupe.getChildren().add(rect1);
 groupe.getChildren().add(cerc1);

 
 primaryStage.setScene(scene);
 primaryStage.show();


 }
 public static void main(String [] args){
 launch(args);
 }
}