import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crée un GridPane
        GridPane gridPane = new GridPane();

               
        
        // Dans JavaFX, la méthode setPadding est une méthode de la classe Region, qui est une superclasse
        // de nombreux composants de l'interface utilisateur, y compris des conteneurs comme 
        // VBox, HBox, GridPane, et d'autres.

        // La méthode setPadding est utilisée pour définir les marges internes (également appelées padding) 
        // d'un conteneur ou d'un composant. Le padding est l'espace entre le bord intérieur d'un composant
        // et son contenu.
        
        
        // Ici La méthode setPadding utilise un objet "new Insets(10, 10, 10, 10)"
        // qui spécifie les marges internes à appliquer. Un objet Insets prend quatre arguments représentant 
        // les espaces en pixels entre les bords intérieurs du conteneur ou composant et son contenu : 
        // top (haut), right (droite), bottom (bas) et left (gauche).
        
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        // Dans JavaFX, la méthode setHgap est utilisée pour définir l'espacement horizontal (horizontal gap) 
        // entre les colonnes d'un GridPane. En d'autres termes, elle spécifie la distance 
        // entre les colonnes adjacentes.
        gridPane.setHgap(20);
        // entre les lignes adjacentes pour setVgap()
        gridPane.setVgap(10);

        // Crée des composants pour le GridPane
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Button submitButton = new Button("Submit");

        // Ajoute les composants au GridPane avec leurs positions
        gridPane.add(nameLabel, 0, 0);  // Colonne 0, Ligne 0
        gridPane.add(nameField, 1, 0);  // Colonne 1, Ligne 0
        gridPane.add(ageLabel, 0, 1);   // Colonne 0, Ligne 1
        gridPane.add(ageField, 1, 1);   // Colonne 1, Ligne 1
        gridPane.add(submitButton, 1, 2); // Colonne 1, Ligne 2

        // Crée une scène avec le GridPane et la définit sur le Stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
