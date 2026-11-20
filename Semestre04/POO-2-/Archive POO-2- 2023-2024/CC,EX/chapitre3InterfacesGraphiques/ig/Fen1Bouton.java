import javax.swing.* ; import java.awt.*;
class Fen1Bouton extends JFrame{ 
    private JButton monBouton ;    
    public Fen1Bouton (){
        setTitle ("Ajouter un bouton") ;
        setSize (300, 200) ;
        monBouton =new JButton ("Premier bouton");
        getContentPane().add(monBouton);
        getContentPane().setLayout(new FlowLayout());
    }
}
