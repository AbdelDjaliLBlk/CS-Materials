import javax.swing.*;
import java.awt.*;

public class ThreePanel {
    public static void main(String[] args) {
        // Création d'une JFrame
        JFrame frame = new JFrame("Exemple de placement de plusieurs JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800, 500);

        // Création des JPanels
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setPreferredSize(new Dimension(150, 100));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setPreferredSize(new Dimension(150, 100));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setPreferredSize(new Dimension(150, 100));// Ajout des JPanels à la JFrame
        frame.setLayout(new FlowLayout()); // Les 03 panels seront disposés sur une ligne cote à cote
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.pack();
        // Affichage de la JFrame
        frame.setVisible(true);
    }
}
