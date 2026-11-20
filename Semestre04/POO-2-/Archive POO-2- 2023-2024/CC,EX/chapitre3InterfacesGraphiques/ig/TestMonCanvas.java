import java.awt.*;

public class TestMonCanvas {
    public static void main(String[] args) {
        // Création d'une fenêtre
        Frame frame = new Frame("Test MonCanvas");

        // Création d'une instance de MonCanvas
        MonCanvas monCanvas = new MonCanvas();

        // Ajout de MonCanvas à la fenêtre
        frame.add(monCanvas);

        // Configuration de la taille de la fenêtre
        frame.setSize(200, 200);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }
}
