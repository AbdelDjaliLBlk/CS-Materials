import javax.swing.*; import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.util.Scanner;

public class TestContainer1 {
    public static void main(String[] arg) { 
        JFrame cadre = new JFrame("Premiere fenetre"); 
        cadre.setSize(800,500);
        cadre.setVisible(true);
        System.out.println("Appuyez sur n'importe quelle touche pour continuer...");
        // Créer un objet Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        // Attendre jusqu'à ce qu'une touche soit pressée
        scanner.nextLine();

        JPanel panel = new JPanel(); // Un nouveau JPanel est créé explicitement.
        panel.setPreferredSize(new Dimension(250, 150));
        panel.setSize(250, 150);
        panel.setBackground(Color.RED);
        cadre.setContentPane(panel);
        scanner.nextLine();
        
        cadre.setLocation(400, 300);
        scanner.nextLine();
        
        cadre.pack();
        scanner.nextLine();
        
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
} 
