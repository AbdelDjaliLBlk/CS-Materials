import javax.swing.* ; import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Fen2Bouton extends JFrame implements ActionListener { 
    private JButton monBouton ;   
    private JButton monBouton1, monBouton2;
    public Fen2Bouton (){
        setTitle ("Premier bouton") ;
        setSize (300, 200) ;
        monBouton =new JButton ("Essai");
        getContentPane().add(monBouton);
        
        monBouton1 =new JButton ("Bouton A");
        monBouton2 =new JButton ("Bouton B");
        //monBouton2.setEnabled (false) ;
        
        getContentPane().add(monBouton1);
        getContentPane().add(monBouton2);

        
        monBouton.addActionListener(this);
        getContentPane().setLayout(new FlowLayout());
        
        // la fenêtre écoute monBouton1 
        monBouton1.addActionListener(this); 
        // la fenêtre écoute monBouton2 
        monBouton2.addActionListener(this);
    }
    
    // gestion commune de tous les boutons 
    public void actionPerformed (ActionEvent ev){
        System.out.println ("action sur un bouton") ; 
        if (ev.getSource() == monBouton)
                System.out.println ("action sur bouton ESSAI") ;
        
        if (ev.getSource() == monBouton1)
       
        System.out.println ("action sur bouton numéro 1") ;
                
        if (ev.getSource() == monBouton2)
                System.out.println ("action sur bouton numéro 2") ;

    }

}
