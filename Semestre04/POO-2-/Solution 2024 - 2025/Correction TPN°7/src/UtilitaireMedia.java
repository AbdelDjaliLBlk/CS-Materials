import java.util.List;
public class UtilitaireMedia {
     public static void afficher(List<? extends Media> medias){
         System.out.println("\n--> Utilitaire Media : ");
         for(Media x : medias){
             x.afficher();
         }
    }
}
