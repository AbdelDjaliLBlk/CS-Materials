#include <stdio.h>

struct parm {
    char nom[20];
    char tel[20];
};

int main() {
    struct parm p;
    FILE *f;
    char namefile[21];
    int x, n, i;

    printf("Entrez le nom de fichier a manipuler : ");
    scanf("%21s", namefile);
    f = fopen(namefile, "rb");

    printf("Donnez le numéro de l'enregistrement a lire : ");
    scanf("%d", &i);
    fseek(f, (i - 1) * sizeof(p), SEEK_SET);  

    n = fread(&p, sizeof(p), 1, f);

    if (n == 1)
        printf("Enreg num: %3d \t Nom : %s \t Tel : %s\n", i, p.nom, p.tel);
    else
        printf("Erreur lors de la lecture de l'enregistrement.\n");

    fclose(f);

    return 0;
}

