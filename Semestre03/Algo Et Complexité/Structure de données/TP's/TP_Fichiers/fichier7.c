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



    /** 2- Ecriture sur un fichier à partir d'un fichier caractere par caractere **/
        /** Ouvrir le Fichier existant Fichier_texte1.txt en mode Lecture (r) **/
        file1 = fopen("Fichier_texte1.txt","r");

        /** Créer et Ouvrir un nouveau fichier Fichier_texte1.txt en mode Ecriture (w)**/
        file2 = fopen("Fichier_texte2.txt","w");

        if((file1 == NULL)||(file2 == NULL)){
            printf("Erreur d'Ouverture Fichier");
            return 0;
        }

        printf("\nEcriture Caractère par caractère de Fichier_texte1 vers Fichier_texte2 \n");

        /** Copier le contenu de Fichier_texte1.txt vers Fichier_texte1.txt caractère par caractère  **/
        while ((c = fgetc(file1)) != EOF)
            fputc(c,file2);

        /** Fermer les  Fichiers :  Fichier_texte1.txt et Fichier_texte2.txt **/
        fclose(file1);
        fclose(file2);

    /** 3-A Ecriture sur un fichier à partir d'un fichier Ligne par Ligne   **/
        /** Ouvrir le Fichier existant Texte.txt en mode Lecture (r) **/
        file1 = fopen("Texte.txt","r");

        /** Créer et Ouvrir un nouveau fichier Texte2.txt en mode Ecriture (w)**/
        file2 = fopen("Texte2.txt","w");

        if((file1 == NULL)||(file2 == NULL)){
            printf("Erreur d'Ouverture Fichier");
            return 0;
        }

        printf("\nEcriture sur Fichier Ligne par Ligne fputs\n");

        /** Copier le contenu de Texte1.txt vers Texte2.txt Ligne par Ligne  **/
        while( fgets (ligne,50, file1)!=NULL )
            fputs(ligne,file2);

        /** Fermer les  Fichiers :  Texte1.txt et Texte2.txt **/
        fclose(file1);
        fclose(file2);
         return 0;
}

