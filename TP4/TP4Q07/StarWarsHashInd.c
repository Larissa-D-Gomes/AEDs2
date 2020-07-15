/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Hash Indireta com Lista Simples
*/

#include <time.h>
#include "Hash.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}
 
int main(){
   clock_t t1 = clock();
   int comp = 0;
   int sw = 0;
   FILE* arq = fopen("matrícula_hashIndireta.txt", "wt");
   char arquivo[_MAX_];
   Hash h;
   construtorHash(&h, 25);
   scanf("%s", arquivo);
   Personagem p;
   
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   while(!IsFim(arquivo)) {
      ConstrutorPersonagem(&p, arquivo);
      inserirHash(&h, p);
      scanf("%s", arquivo);
   }    
   
   scanf(" %[^\n]s", arquivo);    
   while(!IsFim(arquivo)) {
      printf("%s ", arquivo);
      if(pesquisarH(&h, arquivo,&comp))
         printf("SIM\n");
      else
         printf("NÃO\n");
      scanf(" %[^\n]s", arquivo);
   }

   clock_t t2 = clock();
   fprintf(arq, "650525\t%i\t%i\t%lf",comp,sw, ((float)(t2-t1)/CLOCKS_PER_SEC));
   fclose(arq);
}
