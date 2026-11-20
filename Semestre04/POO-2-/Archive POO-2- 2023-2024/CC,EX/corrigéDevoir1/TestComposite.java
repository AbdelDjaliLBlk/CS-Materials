
public class TestComposite
{
    public static void main (String args[]){
        
        AbstractFile r1,r2,r3,f1,f2,f3,f4,f5;
        Retrait r = new Retrait();
        r1 = new Repertoire("rep1",r);
        r2 = new Repertoire("rep2",r);        
        r3 = new Repertoire("rep3",r);        
        
        f1 = new Fichier("a",r,5);
        f2 = new Fichier("b",r,10);
        f3 = new Fichier("c",r,22);
        f4 = new Fichier("d",r,4);
        f5 = new Fichier("e",r,8);        
        
        ((Repertoire)r1).ajouter(f1);
        ((Repertoire)r2).ajouter(f2);
        ((Repertoire)r2).ajouter(f3);
        ((Repertoire)r2).ajouter(r1);
        ((Repertoire)r3).ajouter(f4);
        ((Repertoire)r3).ajouter(f5);
        ((Repertoire)r3).ajouter(r2);
        
        r3.afficher();
        System.out.println(((Repertoire)r3).getTaille());
    }
}
                