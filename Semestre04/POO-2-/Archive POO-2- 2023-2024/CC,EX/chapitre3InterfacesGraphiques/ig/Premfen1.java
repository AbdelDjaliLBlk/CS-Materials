import javax.swing.JFrame;

import java.util.*;
public class Premfen1{ 
    public static void main (String args[]){ 
        JFrame fen = new MaFenetre() ;
        fen.setVisible (true) ;
        Scanner sc = new Scanner(System.in);
        while (true) {// fin sur longueur titre nulle
            System.out.print ("nouvelle largeur : ") ; int larg=sc.nextInt() ;
            System.out.print ("nouvelle hauteur : "); int haut=sc.nextInt();
            System.out.print ("nouveau titre : (vide pour finir) ");
            sc.nextLine();   String tit = sc.nextLine() ;
             if (tit.length() == 0) break ;
            fen.setSize (larg, haut) ;    fen.setTitle(tit) ;
        }

    }
}
