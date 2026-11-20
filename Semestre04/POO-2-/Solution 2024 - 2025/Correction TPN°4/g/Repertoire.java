package g;
import f.*;
import h.*;
import java.util.ArrayList;

public class Repertoire implements AbstractFile{
private ArrayList <AbstractFile> fichiers = new ArrayList<>();
private String nom;
private Retrait retrait = new Retrait();
    public Repertoire(String nom , Retrait retrait){
        this.nom = nom;
        this.retrait = retrait;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setRetrait(Retrait retrait) {
        this.retrait = retrait;
    }
    public Retrait getRetrait() {
        return retrait;
    }
    public String getNom() {
        return nom;
    }

    public void ajouter(AbstractFile f){
    fichiers.add(f);
    }
     @Override
     public void afficher(){
         System.out.println(retrait.getSbRetrait()+nom);
          retrait.augmenterRetrait();
        for(AbstractFile x : fichiers)
            x.afficher();
        retrait.diminuerRetrait();
    }

    public int getTaille(){
        int taille = 0;
        for(AbstractFile x : fichiers)
                taille += x.getTaille();
        return taille;
    }
}
