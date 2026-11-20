import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainJavaFX extends Application {
    private Button button;
    private StackPane root;
    private Scene scene;
    public MainJavaFX() {
        System.out.print(Thread.currentThread().getName());
        System.out.println(" appelle le constructeur de la Classe MainJavaFX");
        button = new Button("Salut le monde !");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {            System.out.println("Hello World!");        }
        } );
        // Nœud racine.
        root = new StackPane();
        root.getChildren().setAll(button);
        // Configuration de la scène.
        scene = new Scene(root);
    }
    @Override
public void init() throws Exception {
    super.init();
    // Faire des initialisations ici.
    System.out.print(Thread.currentThread().getName());
    System.out.println("execute la méthode init de la classe MainJavaFX");
}
 @Override
public void start(Stage primaryStage) {
    System.out.print(Thread.currentThread().getName());
    System.out.println(" execute la méthode start de la classe MainJavaFX");
    // Configuration de la fenêtre.
    primaryStage.setScene(scene);
    primaryStage.setTitle("Ma première application");
    primaryStage.setWidth(350);
    primaryStage.setHeight(300);
    primaryStage.show();
}
public static void main(String[] args) { launch(args); }
}