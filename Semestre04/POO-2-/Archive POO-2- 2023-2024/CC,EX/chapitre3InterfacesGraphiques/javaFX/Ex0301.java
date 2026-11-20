import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Ex0301 extends Application {
    private BorderPane racine = new BorderPane();
    private HBox btnPanel = new HBox(10);
    private Label labelA = new Label("Choisissez votre direction");
    private Button btng = new Button("Aller à gauche");
    private Button btnd = new Button("Aller à droite");
    private Button btnQuit = new Button("Quitter");
    private Scene scene;
    private Circle cercle;
    private boolean cercleVisible = false; // Variable de contrôle pour suivre la visibilité du cercle

    public Ex0301() {
        labelA.setFont(Font.font("Arial", 20));
        labelA.setTextFill(Color.DARKGRAY);
        BorderPane.setAlignment(labelA, Pos.CENTER);
        racine.setTop(labelA);

        btnPanel.getChildren().addAll(btng, btnd, btnQuit);
        btnPanel.setAlignment(Pos.CENTER);
        racine.setBottom(btnPanel);

        scene = new Scene(racine, 600, 300);
        scene.setFill(Color.OLDLACE);

        // Initialisez le cercle
        cercle = new Circle(300, 150, 100);
        cercle.setFill(Color.RED);

        // Gestionnaire d'événements pour le bouton "Quitter"
        EventHandler<MouseEvent> quitEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // Basculer la visibilité du cercle
                if (cercleVisible) {
                    // Cacher le cercle
                    racine.setCenter(null);
                } else {
                    // Afficher le cercle
                    racine.setCenter(cercle);
                }
                // Inverser l'état de visibilité du cercle
                cercleVisible = !cercleVisible;
            }
        };
        btnQuit.addEventHandler(MouseEvent.MOUSE_CLICKED, quitEventHandler);

        // Gestionnaire d'événements pour le bouton "Aller à gauche"
        btng.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Déplace le cercle vers la gauche
                cercle.setCenterX(cercle.getCenterX() - 10);
            }
        });

        // Gestionnaire d'événements pour le bouton "Aller à droite"
        btnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Déplace le cercle vers la droite
                cercle.setCenterX(cercle.getCenterX() + 10);
            }
        });
    }

    public static void main(String[] args) {
        Ex0301 ex = new Ex0301();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ex0301 - ING1");
        stage.setScene(scene);
        stage.show();
    }
}
