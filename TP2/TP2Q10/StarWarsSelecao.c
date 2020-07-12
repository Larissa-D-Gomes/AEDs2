/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Pesquisa binaria
*/

#include <time.h>
#include "ListaPersonagem.h"


bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}
 
int main()
{
   clock_t t1 = clock();
   int comp = 0;
   int sw = 0;
   FILE* arq = fopen("matrícula_selecaoRecursiva.txt", "wt");
   char leitura[_MAX_];
   ListaPersonagem l;
   ConstrutorLista(&l, 90);
   scanf("%s", leitura);
   getchar();//limpar buffer
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   while(!IsFim(leitura)) {
      inserirFim(leitura, &l);
      scanf("%s", leitura);
      getchar();//limpar buffer
   }           
   scanf(" %[^\n]s", leitura);
  //printf("%s\n",leitura);
   
   selecao(&l,0, 0,1,&comp,&sw);
   printLista(&l);                
   freeLista(&l);
   clock_t t2 = clock();
   fprintf(arq, "650525\t%i\t%i\t%lf",comp,sw, ((t2-t1)/1000.0));
   fclose(arq);
}
