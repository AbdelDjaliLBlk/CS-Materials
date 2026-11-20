package e;
import f.*;
import g.*;
import h.*;
import i.*;

public class Program {
    public static void main(String args[]){
        Retrait retrait = new Retrait();

        Fichier fichier1 = new Fichier("fichier1",retrait);
        Fichier fichier2 = new Fichier("fichier2",retrait);
        Fichier fichier3= new Fichier("fichier3",retrait);
        Fichier fichier4 = new Fichier("fichier4",retrait);
        Fichier fichier5= new Fichier("fichier5",retrait);

        Repertoire repertoire1 = new Repertoire("repertoire1",retrait);
        Repertoire repertoire2 = new Repertoire("repertoire2",retrait);
        Repertoire repertoire3 =new Repertoire("repertoire3",retrait);

        //Remplire Rep1.
        repertoire1.ajouter(fichier1);
        repertoire1.ajouter(new Fichier("fichier6",retrait));

        //Remplire Rep2.
        repertoire2.ajouter(fichier2);
        repertoire2.ajouter(fichier3);
        repertoire2.ajouter(repertoire1);

        //Remplire Rep3.
        repertoire3.ajouter(fichier4);
        repertoire3.ajouter(repertoire2);
        repertoire3.ajouter(fichier5);

        //Afficher Rep3;
        repertoire3.afficher();
        System.out.println("Taille des fichiers du Rep3 : "+repertoire3.getTaille());
    }
}
