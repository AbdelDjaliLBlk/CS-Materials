package i ;
import h.*;
import f.*;
public class Fichier implements AbstractFile{
private String nom;
private Retrait retrait = new Retrait();
private int taille ;

    public Fichier(String nom , Retrait retrait){
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
    @Override
    public void afficher(){
        System.out.println(retrait.getSbRetrait()+nom);
    }
    @Override
    public int getTaille(){
        return 1;
    }
}
