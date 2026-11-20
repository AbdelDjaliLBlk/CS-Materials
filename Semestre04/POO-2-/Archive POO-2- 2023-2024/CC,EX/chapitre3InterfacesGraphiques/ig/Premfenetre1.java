import javax.swing.* ;
import java.util.concurrent.TimeUnit;
public class Premfenetre1{ 
    public static void main (String args[]){ 
        System.out.println ("debut main") ;
        JFrame fen = new JFrame() ;
        fen.setBounds (200, 200, 450, 350);
        //fen.setSize (300, 150) ;
        fen.setTitle ("Ma premiere fenetre") ;
        System.out.println("avant affichage fenetre") ;
        
        // Faire une pause pendant 2 secondes 
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        fen.setVisible (true) ;
        
        // Faire une pause pendant 4 secondes (4000 millisecondes)
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 4000) {
            // Attendre
        }
        
        System.out.println ("fin main") ;
    }
}
