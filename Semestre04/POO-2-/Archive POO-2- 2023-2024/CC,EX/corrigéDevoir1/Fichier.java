
public class Fichier implements AbstractFile
{
  private String nom;
  private Retrait retrait;
  private double taille;
  
  public double getTaille(){
      return taille;
  }
  
  Fichier (String n, Retrait r, double t){
      nom=n; 
      retrait=r;
      taille=t;
  }
      
  public void afficher(){
      System.out.println(retrait.getRetrait() + nom);
  }
    
}
