/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Quicksort lista flexivel
*/

#include <time.h>
#include "Lista.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}

int main(){
   clock_t t1 = clock();
   int comp = 0;
   int sw = 0;
   FILE* arq = fopen("matrícula_quicksort2.txt", "wt");
   char arquivo[_MAX_];
   Lista l;
   ConstrutorLista(&l);
   scanf("%s", arquivo);
   
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   while(!IsFim(arquivo)) {
      inserirFim(&l, arquivo);
      scanf("%s", arquivo);
   }          
   quicksort(&l, &comp, &sw);                                       
   mostrarLista(&l);
   freeLista(&l);
   clock_t t2 = clock();
   fprintf(arq, "650525\t%i\t%i\t%lf",comp,sw, ((float)(t2-t1)/CLOCKS_PER_SEC));
   fclose(arq);
}
