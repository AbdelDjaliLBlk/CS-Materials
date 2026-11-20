import javax.swing.*; import java.awt.*;
public class TestFen2Bouton {
    public static void main(String[] args) {
        // Créer une instance de Fen1Bouton
        Fen2Bouton fenetre = new Fen2Bouton();
        

        // Définir l'opération à effectuer lorsque la fenêtre est fermée
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }
}
