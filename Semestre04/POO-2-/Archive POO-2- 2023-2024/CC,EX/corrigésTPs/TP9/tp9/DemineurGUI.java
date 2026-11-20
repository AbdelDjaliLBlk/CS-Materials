import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DemineurGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Création de la barre de menu
        MenuBar menuBar = createMenuBar();
        root.setTop(menuBar);

        // Création de la scène
        Scene scene = new Scene(root, 300, 200);

        // Configuration de la scène et affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Démineur");
        primaryStage.show();
    }

    // Crée une barre de menu avec les options "Nouvelle partie" et "Quitter"
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        // Crée le menu "Partie"
        Menu menuPartie = new Menu("Partie");

        // Crée l'option "Nouvelle partie" et définit son action
        MenuItem nouvellePartieItem = new MenuItem("Nouvelle partie");
        nouvellePartieItem.setOnAction(event -> nouvellePartie());

        // Crée l'option "Quitter" et définit son action
        MenuItem quitterItem = new MenuItem("Quitter");
        quitterItem.setOnAction(event -> System.exit(0));

        // Ajoute les options au menu "Partie"
        menuPartie.getItems().addAll(nouvellePartieItem, quitterItem);

        // Ajoute le menu "Partie" à la barre de menu
        menuBar.getMenus().add(menuPartie);

        return menuBar;
    }

    // Méthode appelée lorsqu'on clique sur "Nouvelle partie"
    private void nouvellePartie() {
        // Insérer ici le code pour démarrer une nouvelle partie
        System.out.println("Nouvelle partie !");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
