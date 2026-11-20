import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessGame1 extends Application {

    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        // Création du menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newGameMenuItem = new MenuItem("New Game");
        MenuItem exitMenuItem = new MenuItem("Exit");
        // Ajout d'un gestionnaire d'événements pour l'option "Exit"
        exitMenuItem.setOnAction(event -> Platform.exit());
        fileMenu.getItems().addAll(newGameMenuItem, exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        
        // Ajout du menu à la partie supérieure du BorderPane
        root.setTop(menuBar);
        
        // Création de la grille d'échecs
        GridPane chessBoard = createChessBoard();
        root.setCenter(chessBoard);

        Scene scene = new Scene(root, TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess Game");
        primaryStage.show();
    }

    private GridPane createChessBoard() {
        GridPane board = new GridPane();
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                Rectangle square = new Rectangle(TILE_SIZE, TILE_SIZE);
                square.setFill((x + y) % 2 == 0 ? Color.WHITE : Color.LIGHTGRAY);
                board.add(square, x, y);
            }
        }
        return board;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
