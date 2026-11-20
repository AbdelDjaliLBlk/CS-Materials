#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int i=0;
int main()
{
    /** Declaration variable de type FILE **/
    FILE *file1,*file2;
    char chaine[100]  = {0};
    char chaine1[100]  = {0};
    char chaine2[100]  = {0};
    char c;
    char ligne[100]  = {0};

    /** 1- Ecriture dans un ficher  **/
        /** Créer et Ouvrir un nouveau fichier Fichier_texte1.txt en mode Ecriture (w)**/
        file1 = fopen("Fichier_texte1.txt","w");

        if(file1 == NULL){
            printf("Erreur");
            return 0;
        }

        printf("Entrer une chaine: ");

        /** Lire la chaine à partir de l'écran **/
        fgets(chaine,100,stdin);

        /** Ecrire la chaine saisie dans le fichier Fichier_texte1.txt **/
        fprintf(file1,"%s",chaine);

        /** Afficher la chaine saisie sur l'écran aussi **/
        fprintf(stdout,"%s",chaine);

        /** Fermer le Fichier Fichier_texte1.txt **/
        fclose(file1);
         return 0;
}

