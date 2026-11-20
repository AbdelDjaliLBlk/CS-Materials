import javax.swing.*; import java.awt.*;
public class TestFen1Bouton {
    public static void main(String[] args) {
        // Créer une instance de Fen1Bouton
        Fen1Bouton fenetre = new Fen1Bouton();
        fenetre.add(new JButton("ajouté"));

        // Définir l'opération à effectuer lorsque la fenêtre est fermée
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }
}