import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import java.util.Random;
import javafx.scene.layout.VBox;

public class TestHBox extends Application {
 @Override
 public void start(Stage primaryStage) throws Exception {
     // création du gestionnaire HBox
      //HBox hbox = new HBox(20); // crée une HBox avec un espacement horizontal de 20 pixels entre chaque élément enfant.
     
     VBox hbox = new VBox(20); // Le gestionnaire VBox se comporte comme le gestionnaire HBox 	
     // à la différence que les objets sont positionnés verticalement.
    
     // Génération de nombres aléatoires : L'instance rand de la classe Random peut être utilisée pour générer
    // des nombres aléatoires de différents types
     Random rand = new Random();
    
     //Création de la Scene en lui passant le noeud racine
     //ainsi que la largeur et la hauteur
     Scene scene = new Scene(hbox ,800, 600);
     
     
    
    // Ainsi, les positions sont initialisées à 0
     Rectangle r1 = new Rectangle(50,50);
     Rectangle r2 = new Rectangle(20,20);
     Rectangle r3 = new Rectangle(100,100);
     Rectangle r4 = new Rectangle(80,80);
     
     Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
     r1.setFill(c);
     c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
     r2.setFill(c);
     c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
     r3.setFill(c);
     c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
     r4.setFill(c);
     Text t = new Text("Test HBox");
     t.setFont(new Font(24));
    
     hbox.getChildren().addAll(r1,r2,r3,r4,t);
    
     //On remplit la Scene d'une couleur
     //scene.setFill(lg);
    
     //Ajout d'un titre à la fenêtre --> Stage
     primaryStage.setTitle("Gestionnaire HBox");
    
     //On ajoute la Scene au stage --> Stage
     primaryStage.setScene(scene);
    
     //On affiche le stage
     primaryStage.show();
 }
 public static void main(String args[]){
     launch(args);
 }
} 