#include <stdio.h>

int main() {
    struct Tenreg {
        char nom[20];
        char tel[15];
    } e;

    FILE *f;
    char nomf[30];
    int n, i;

    printf("\nAffichage du contenu d'un fichier agenda telephonique\n\n");

    printf("Donnez le nom du fichier à lister : ");
    scanf(" %s", nomf);

    f = fopen(nomf, "r"); // ouverture du fichier texte en mode lecture

    if (f == NULL) {
        printf("Erreur lors de l'ouverture du fichier %s en mode r\n", nomf);
        return 0;
    }

    // lecture des enregistrements depuis le fichier
// premiere version
while ( ! feof(f) ) {
fscanf(f, "%s , %s", e.nom, e.tel);

printf("\t nom : %s \t tel : %s\n", e.nom, e.tel);  }

    // deuxième version
   // while (fscanf(f, "%s , %s", e.nom, e.tel) == 2) {
    //    printf("\t Nom : %s \t Tel : %s\n", e.nom, e.tel);   }

    // fermeture du fichier
    fclose(f);

    return 0;
}

