import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;

import java.util.Random;

public class DemineurJavaFX extends Application {

    // Taille de la grille (lignes et colonnes)
    private static final int ROWS = 10;
    private static final int COLS = 10;
    
    // Nombre de mines à placer sur le plateau
    private static final int NUM_MINES = 10;
    
    // Tableau de boutons représentant le plateau de jeu
    private Button[][] buttons = new Button[ROWS][COLS];
    
    // Tableau pour indiquer si une case contient une mine
    private boolean[][] mines = new boolean[ROWS][COLS];
    
    // Tableau pour suivre les cases révélées par le joueur
    private boolean[][] revealed = new boolean[ROWS][COLS];
    
    // Indicateur de fin de partie
    private boolean gameOver = false;

    @Override
    public void start(Stage primaryStage) {
        // Utilisez un BorderPane pour organiser la barre de menu et la grille
        BorderPane root = new BorderPane();

        // Crée une barre de menu avec le menu "Partie"
        MenuBar menuBar = createMenuBar();
        root.setTop(menuBar);

        // Crée la grille de jeu
        GridPane grid = new GridPane();
        root.setCenter(grid);

        // Initialise la grille de boutons et les mines
        initializeGrid(grid);
        placeMines();

        // Crée la scène avec le BorderPane et l'ajoute à la fenêtre
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Démineur");
        primaryStage.show();
    }

    // Crée une barre de menu avec le menu "Partie" contenant les options "Nouvelle partie" et "Quitter"
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

        // Ajoute les options au menu
        menuPartie.getItems().addAll(nouvellePartieItem, quitterItem);

        // Ajoute le menu à la barre de menu
        menuBar.getMenus().add(menuPartie);

        return menuBar;
    }

    // Initialise la grille de boutons
    private void initializeGrid(GridPane grid) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // Crée un bouton pour chaque case de la grille
                Button button = new Button();
                button.setMinSize(30, 30);
                
                // Associe un gestionnaire d'événements au bouton
                final int r = row;
                final int c = col;
                button.setOnAction(event -> handleButtonClick(r, c));
                
                // Ajoute le bouton à la grille
                grid.add(button, col, row);
                buttons[row][col] = button;
            }
        }
    }

    // Place aléatoirement des mines sur le plateau
    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < NUM_MINES) {
            // Génère des positions aléatoires pour placer les mines
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLS);

            // Place une mine si la case ne contient pas déjà une mine
            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }
    }

    // Gère les clics sur les boutons
private void handleButtonClick(int row, int col) {
    // Si la partie est terminée ou la case est déjà révélée, ne rien faire
    if (gameOver || revealed[row][col]) {
        return;
    }

    // Si le joueur clique sur une mine, il perd
    if (mines[row][col]) {
        buttons[row][col].setText("M");
        gameOver = true;
        showAlert("Perdu !", "Vous avez déclenché une mine. Fin de partie !");
        revealAll();
    } else {
        // Compte le nombre de mines adjacentes à la case cliquée
        int adjacentMines = countAdjacentMines(row, col);
        
        // Affiche le nombre de mines adjacentes sur le bouton
        buttons[row][col].setText(String.valueOf(adjacentMines));
        
        // Marque la case comme révélée et change la couleur de fond
        revealed[row][col] = true;
        buttons[row][col].setStyle("-fx-background-color: lightgray;");

        // Si aucune mine adjacente, révèle les cases voisines
        if (adjacentMines == 0) {
            revealAdjacentCells(row, col);
        }

        // Vérifie si le joueur a gagné
        if (checkWin()) {
            showAlert("Gagné !", "Vous avez trouvé toutes les mines !");
            gameOver = true;
        }
    }
}

    // Compte les mines adjacentes à une case donnée
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                // Calcule les coordonnées de la case adjacente
                int newRow = row + r;
                int newCol = col + c;

                // Si la case adjacente est dans les limites et contient une mine, incrémente le compteur
                if (isInBounds(newRow, newCol) && mines[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Révèle les cases adjacentes à une case donnée
    private void revealAdjacentCells(int row, int col) {
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                // Calcule les coordonnées de la case adjacente
                int newRow = row + r;
                int newCol = col + c;

                // Si la case adjacente est dans les limites et n'est pas révélée, clique dessus
                if (isInBounds(newRow, newCol) && !revealed[newRow][newCol]) {
                    handleButtonClick(newRow, newCol);
                }
            }
        }
    }

    // Vérifie si les coordonnées sont dans les limites de la grille
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    // Révèle toutes les cases lorsque le joueur perd
    private void revealAll() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // Affiche une mine sur le bouton si la case contient une mine
                if (mines[row][col]) {
                    buttons[row][col].setText("M");
                    
                     // Création d'un remplissage de couleur pour la couleur de fond du bouton
        BackgroundFill backgroundFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);

        // Création de l'arrière-plan avec le remplissage de couleur
        Background background = new Background(backgroundFill);

        // Définition de l'arrière-plan du bouton
        buttons[row][col].setBackground(background);
                

                    
                } else {
                    // Affiche le nombre de mines adjacentes sur le bouton
                    int adjacentMines = countAdjacentMines(row, col);
                    buttons[row][col].setText(String.valueOf(adjacentMines));
                }
            }
        }
    }

    // Vérifie si le joueur a gagné en ayant trouvé toutes les mines
    private boolean checkWin() {
        int cellsRevealed = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // Compte les cases non minées révélées
                if (revealed[row][col] && !mines[row][col]) {
                    cellsRevealed++;
                }
            }
        }
        // Le joueur a gagné s'il a révélé toutes les cases non minées
        return cellsRevealed == (ROWS * COLS - NUM_MINES);
    }

    // Affiche une alerte avec un titre et un contenu
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

 
        // Lance une nouvelle partie en réinitialisant le jeu
    private void nouvellePartie() {
        // Réinitialise les boutons, les mines et les cases révélées
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                buttons[row][col].setText("");
                revealed[row][col] = false;
                mines[row][col] = false;
            }
        }

        // Remet le jeu en cours de partie
        gameOver = false;

        // Place de nouvelles mines sur le plateau
        placeMines();
    }

    // Le point d'entrée de l'application
    public static void main(String[] args) {
        launch(args);
    }
}