import java.util.*;
public class Joueur {
     List<String> cartes;
 public Joueur(List <String> cartes){
     this.cartes = cartes;
 }
 public void afficherCartes(){
     System.out.println("--> "+cartes.toString());
 }
}
