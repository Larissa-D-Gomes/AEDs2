/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Arvore AVL
*/

#include <time.h>
#include "AVL.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}

int main(){
   clock_t t1 = clock();
   int comp = 0;
   int sw = 0;
   Personagem p;
   AVL* arv = construtorAVL(); 
   FILE* arq = fopen("matrícula_avl.txt", "wt");
   char leitura[_MAX_];

   scanf(" %[^\n]s", leitura);
   
   while(!IsFim(leitura)) {
      ConstrutorPersonagem(&p, leitura);
      inserir(arv, p, &comp);
      scanf(" %[^\n]s", leitura);
   }
   scanf(" %[^\n]s", leitura);
   while(!IsFim(leitura)) {
      printf("%s ", leitura);
      if(pesquisar(arv, leitura, &comp))
         printf("SIM\n");
      else
         printf("NÃO\n");
      scanf(" %[^\n]s", leitura);
   }
   clock_t t2 = clock();
   fprintf(arq, "650525\t%lf\t%i", (float)(t2-t1)/CLOCKS_PER_SEC, comp);
   fclose(arq);
}
