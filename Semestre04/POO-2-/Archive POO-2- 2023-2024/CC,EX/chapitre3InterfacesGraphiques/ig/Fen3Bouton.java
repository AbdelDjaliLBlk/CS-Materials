import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fen3Bouton extends JFrame {
    private JButton monBouton;
    private JButton monBouton1, monBouton2;

    public Fen3Bouton() {
        setTitle("Premier bouton");
        setSize(300, 200);

        monBouton = new JButton("Essai");
        monBouton1 = new JButton("Bouton A");
        monBouton2 = new JButton("Bouton B");

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(monBouton);
        getContentPane().add(monBouton1);
        getContentPane().add(monBouton2);

        // Ajout d'écouteurs d'événements distincts pour chaque bouton
        // Utilisation de classes anonymes
        monBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Action sur bouton ESSAI");
            }
        });

        monBouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Action sur bouton numéro 1");
            }
        });

        monBouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Action sur bouton numéro 2");
            }
        });
    }

    public static void main(String[] args) {
        Fen2Bouton fenetre = new Fen2Bouton();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}
