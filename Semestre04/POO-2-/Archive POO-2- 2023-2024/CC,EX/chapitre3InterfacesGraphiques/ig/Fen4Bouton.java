import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fen4Bouton extends JFrame {
    private JButton monBouton;
     JButton monBouton1, monBouton2;

    public Fen4Bouton() {
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

       monBouton1.addActionListener(new EcouteBouton(this) );

        monBouton2.addActionListener(new EcouteBouton(this) );
    }

    public static void main(String[] args) {
        Fen4Bouton fenetre = new Fen4Bouton();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}

class EcouteBouton implements ActionListener {
    Fen4Bouton f;

    public EcouteBouton(Fen4Bouton f) {
        this.f = f;
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == f.monBouton1)
            System.out.println("action sur bouton numéro 1");
        if (ev.getSource() == f.monBouton2)
            System.out.println("action sur bouton numéro 2");
    }
}
