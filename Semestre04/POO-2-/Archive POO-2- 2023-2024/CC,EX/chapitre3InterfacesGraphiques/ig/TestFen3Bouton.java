import javax.swing.*; import java.awt.*;
public class TestFen3Bouton {
    public static void main(String[] args) {
        // Créer une instance de Fen3Bouton
        Fen3Bouton fenetre = new Fen3Bouton();
        

        // Définir l'opération à effectuer lorsque la fenêtre est fermée
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }
}
