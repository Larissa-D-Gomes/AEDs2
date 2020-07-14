/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Pilha Flexivel
*/

#include "Pilha.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}


int main()
{
   char acao[2];
   char arq[_MAX_];
   int posicao; 
   int quantidadeAcoes;
   Pilha p;
   construtorPilha(&p);
   Personagem r;
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   scanf("%s", arq);
   
   while(!IsFim(arq)) {
      inserir(&p, arq);
      scanf("%s", arq);
   }                                                 
   scanf("%i", &quantidadeAcoes);
   //printf("%i\n",quantidadeAcoes);
   //printf("%s", acao);
   for(int aux = 0; aux < quantidadeAcoes; aux++)
   {
      scanf("%s", acao);
      //printf("%s\n",acao);
      if(acao[0] == 'I')
      {
         scanf("%s", arq);
         //printf("%s\n",arq);
         inserir(&p, arq);
      }
      else{
         r = remover(&p);
         printf("(R) %s\n",r.nome);//print do personagem removido
      }
   }
   print(&p);
   freePilha(&p);
}
