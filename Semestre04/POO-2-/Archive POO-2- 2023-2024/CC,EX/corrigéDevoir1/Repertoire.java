import java.util.*;
public class Repertoire implements AbstractFile
{
    private String nom;
    private Retrait retrait;
    AbstractFile [] l = new AbstractFile[10];
    int n;
    //ArrayList<AbstractFile> l=new ArrayList<AbstractFile>();
    //LinkedList<AbstractFile> l=new LinkedList<AbstractFile>();
  
  Repertoire (String n, Retrait r){
      nom=n; 
      retrait=r;
  }
      
  public void afficher(){
      System.out.println(retrait.getRetrait() + nom);
      retrait.augmenterRetrait();
      for (int i=0; i<n;i++)
        l[i].afficher();
      retrait.diminuerRetrait();
  }
  
  void ajouter(AbstractFile a){
      l[n]=a;n++;
      //l.add(a);
  }
  
  public double getTaille(){
      double t=0;
      for (int i=0;i<n;i++){
          //if (o instanceof Fichier)
            t+=l[i].getTaille();
          //else ((Repertoire)o).getTaille();
      }
      return t;
    }
     
  
}
