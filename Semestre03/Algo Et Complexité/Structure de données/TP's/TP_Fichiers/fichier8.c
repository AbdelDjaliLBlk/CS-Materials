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




    /** 4- Lecture d'un fichier Ligne par Ligne et Affichage sur Ecran **/
       /** Ouvrir le Fichier existant Texte.txt en mode Lecture (r) **/
       file1 = fopen("Texte.txt","r");

        if(file1 == NULL){
            printf("Erreur");
            return 0;
        }

        printf("\nLecture Ligne par Ligne et Affichage sur Ecran \n \n");

        /** Copier le contenu de chaque ligne du fichier Texte.txt dans la variable ligne (50 caractères Max)   **/
        while( fgets (ligne,50, file1)!=NULL ) {
            /**  Affichage sur Ecran d'une seul ligne: 3 méthodes **/
            puts(ligne);
            /** ou bien **/
            //fprintf(stdout,"%s",ligne);
            /** ou bien **/
            //printf("%s",ligne);
        }

        /** Fermer le Fchier Texte.txt**/
        fclose(file1);



        /** 5- Lecture d'un fichier Carectere par Caractere et Affichage sur Ecran **/
       /** Ouvrir le Fichier existant Texte.txt en mode Lecture (r) **/
       file1 = fopen("Texte.txt","r");

        if(file1 == NULL){
            printf("Erreur");
            return 0;
        }

         printf("\nLecture Caractere par Caractere et Affichage sur Ecran \n \n");

    while ((c = fgetc(file1)) != EOF) {
        putchar(c);  // Affichage du caractère sur l'écran
    }

    // Fermer le Fichier Texte.txt
    fclose(file1);


}
