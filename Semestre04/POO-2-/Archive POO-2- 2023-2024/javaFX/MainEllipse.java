import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;

public class MainEllipse extends Application {
private Ellipse ellipse;
public static void main(String[] args) { launch(args); }
public void FenetreVide(Stage stage,String titre, int hauteur, int largeur)
{ stage.setWidth(largeur); stage.setHeight(hauteur);
stage.setTitle(titre); }
public HBox creerLigneBoutton() {
HBox hbox = new HBox(10);
hbox.setStyle("-fx-background-color: BEIGE;");
hbox.setAlignment(Pos.CENTER);
Button buttonPlus = new Button("BLUE");
buttonPlus.setPrefSize(50, 10);
buttonPlus.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event) {
ellipse.setFill(Color.BLUE); }});
Button buttonMoins = new Button("RED");
buttonMoins.setPrefSize(50, 10);
buttonMoins.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event) {
ellipse.setFill(Color.RED);
}});
hbox.getChildren().addAll(buttonPlus, buttonMoins);
return hbox;
}
public BorderPane creerContenu (){
BorderPane border = new BorderPane();
border.setTop(creerLigneBoutton());
ellipse = new Ellipse( 50,50, 10, 40);
ellipse.setFill(Color.GREY);
border.setCenter(ellipse);
return border;
}

public void layout(Stage stage) {
FenetreVide(stage, "Ellipse - Johnen",100,270);
BorderPane border = creerContenu();
Scene scene = new Scene(border);
stage.setScene(scene);
stage.show(); }
@Override
public void start(Stage stage){ layout(stage); }
}