#include <stdio.h>

struct parm {
    char nom[20];
    char tel[20];
};

int main() {
    struct parm p;
    FILE *output;
    char namefile[21];
    char rep = '\0';

    printf("Entrez le nom de fichier a creer: ");
    scanf("%21s", namefile);
    output = fopen(namefile, "wb");

    printf("Saisie des articles\n");

    do {
        printf("Entrez le nom: ");
        scanf("%s", p.nom);

        printf("Entrez le tel : ");
        scanf("%s", p.tel);

        fwrite(&p, 1, sizeof(p), output);

        printf("Voulez-vous saisir un autre article (O/N) ? ");

        // Read the newline character left in the input buffer
       while (getchar() != '\n');

        rep = getchar(); //   wait for new input
        printf("\n");

    } while (rep == 'O' || rep == 'o');

    fclose(output);
    return 0;
}
