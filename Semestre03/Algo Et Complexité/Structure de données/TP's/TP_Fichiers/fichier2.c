#include<stdio.h>

struct parm{ char nom[20]; char tel [20];  };

int main(){

struct parm p;

FILE *f;

char namefile[21];

int x,n,i;

printf("entrez le nom de fichier a lister :");

scanf("%21s",namefile);

f=fopen(namefile,"rb");

while ( ! feof(f) ) {

n= fread(&p, sizeof(p),1, f);

if ( n == 1 )

printf("nom : %s \t tel : %s\n",  p.nom, p.tel);

}

fclose(f);

return 0 ; }
