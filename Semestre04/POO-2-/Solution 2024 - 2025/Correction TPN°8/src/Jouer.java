import java.util.*;
public class Jouer {
 public static void main(String [] args){
    Scanner scanner = new Scanner(System.in);

    int nombrejoueurs = 0;
    int cartesParjoueur = 0;

    do{
        System.out.println("Entrer le nombre de joueurs :");
        nombrejoueurs = scanner.nextInt();
        System.out.println("Entrer le nombre de carte : ");
        cartesParjoueur = scanner.nextInt();
    }while (nombrejoueurs <= 0 || cartesParjoueur <= 0);

    JeuDeCartes jeu1 = new JeuDeCartes();
    jeu1.initialiser();

     JeuDeCartes jeu2 = new JeuDeCartes();
     jeu2.initialiser();

     jeu1.melanger();
     jeu2.melanger();

        Joueur [] joueurs = new Joueur[nombrejoueurs];
     if(nombrejoueurs * cartesParjoueur <= jeu1.nombreDeCartes()){
      for(Joueur j : joueurs){
          j =new Joueur(jeu1.distribuerJoueur(cartesParjoueur));
        j.afficherCartes();
      }
     }
     scanner.close();
}
public static void melangereJeux(JeuDeCartes jeu1 , JeuDeCartes jeu2){
      jeu1.fusionner(jeu2);
        jeu1.melanger();
 }
}
