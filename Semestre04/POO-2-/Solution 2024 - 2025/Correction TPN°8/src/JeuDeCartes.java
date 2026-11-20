import java.util.*;
public class JeuDeCartes {
    private LinkedList<String> jeuDeCartes;
    public void initialiser() {
        jeuDeCartes = new LinkedList<>();
        String[] couleurs = new String[]{"pique", "cœur", "carreau", "trèfle"};
        String[] valeurs = new String[]{"as", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "valet", "dame", "roi"};
         for(String couleur : couleurs ){
             for(String valeur : valeurs){
                 jeuDeCartes.add(valeur+" de "+couleur);
             }
         }
    }

    public void melanger() {
        Collections.shuffle(jeuDeCartes);
    }

    public List<String> distribuerJoueur(int n) {
        List <String> joueur = new LinkedList<>();
        if(jeuDeCartes != null)
        for (int i = 0; i < n ; i++) {
            joueur.add(jeuDeCartes.removeFirst());
        }
        return joueur;
    }
    public void fusionner(JeuDeCartes autreJeu) {
        jeuDeCartes.addAll(autreJeu.jeuDeCartes);
        autreJeu.jeuDeCartes.clear();
    }
    public int nombreDeCartes(){
        return jeuDeCartes.size();
    }
}
