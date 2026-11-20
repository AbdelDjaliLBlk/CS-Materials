import javax.swing.* ;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class MaFenetre extends JFrame implements MouseListener { 
    public MaFenetre () { 
        setTitle ("Ma premiere fenetre") ;
        setSize (300, 150) ;
        addMouseListener (this) ; // la fenêtre sera son propre
									// écouteur d’évenements souris
    }
    public void mouseClicked(MouseEvent ev) { 
		System.out.println ("clic dans fenêtre") ;
    }
    public void mousePressed (MouseEvent ev) {System.out.println ("pressed dans fenêtre") ;}
	// autres méthodes de la classe MaFenetre
    
    public void mouseReleased(MouseEvent ev) { System.out.println ("released dans fenêtre") ; }
    public void mouseEntered (MouseEvent ev) { System.out.println ("Entered dans fenêtre") ; }
    public void mouseExited (MouseEvent ev) { System.out.println ("Exited dans fenêtre") ;}

    
}
