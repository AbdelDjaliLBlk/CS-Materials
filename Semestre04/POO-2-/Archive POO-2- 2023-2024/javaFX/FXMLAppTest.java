import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLAppTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Chargement du fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("test1.fxml"));
        Parent root = loader.load();

        // Configuration de la scène
        Scene scene = new Scene(root);

        // Configuration du contrôleur
        //ModuleLayer.Controller controller = loader.getController();

        // Configuration de la scène principale
        primaryStage.setTitle("Exemple FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
