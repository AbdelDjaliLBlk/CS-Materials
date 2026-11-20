#include <stdio.h> //fichier4.c

int main() {

struct Tenreg { char nom[20]; char tel[15]; } e;

FILE *f; // variable fichier

char nomf[30];

printf("\n Construction d'un fichier agenda telephonique\n\n");

printf("Donnez le nom du fichier à construire : ");

scanf(" %s", nomf);

f = fopen( nomf, "w" ); // creation du nouveau fichier en mode texte

if ( f == NULL ) {

printf("erreur lors de l'ouverture du fichier %s en mode w\n", nomf);

return 0;

}


//fichier4.c (la suite)

// insertion des enregistrements lus à la console

printf("donnez un nom et un tel (ou 0 0 pour terminer le programme) : ");

scanf(" %s %s", e.nom, e.tel);

while ( e.nom[0] != '0' ) {

// écriture formatée dans le fichier

fprintf(f, " %s , %s\n", e.nom, e.tel ); // un enregistrement par ligne

printf("donnez un nom et un tel (ou 0 0 pour terminer le programme) : ");

scanf(" %s %s", e.nom, e.tel);

}

fclose( f );

return 0;

}
