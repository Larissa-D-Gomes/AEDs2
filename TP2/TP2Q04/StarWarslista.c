/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Lista
*/

#include "Lista.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}
 
int main()
{
   char acao[3];
   char arq[_MAX_];
   int posicao; 
   int quantidadeAcoes;
   ListaPersonagem l;
   ConstrutorLista(&l, 90);
   scanf("%s", arq);
   
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   while(!IsFim(arq)) {
      inserirFim(arq, &l);
      scanf("%s", arq);
   }                                                 
   scanf("%i", &quantidadeAcoes);
   //printf("%s", acao);
   for(int aux = 0; aux < quantidadeAcoes; aux++)
   {
      scanf("%s", acao);
      if(strlen(acao) == 2 && acao[0] == 'R' && acao[1] == 'I')
      {
         removerInicio(&l);
      }
      else{
         if(strlen(acao) == 2 && acao[0] == 'R' && acao[1] == '*')
         {
            scanf("%i", &posicao);
            remover(&l, posicao);
         }
         else{
            if(strlen(acao) == 2 && acao[0] == 'R' && acao[1] == 'F')
            {
               removerFim(&l);
            }
            else{
               if(strlen(acao) == 2 && acao[0] == 'I' && acao[1] == 'I')
               {
                  scanf("%s", arq);
                  inserirInicio(arq, &l);
               }
               else{
                  if(strlen(acao) == 2 && acao[0] == 'I' && acao[1] == '*')
                  {
                      scanf("%i", &posicao);
                      scanf("%s", arq);
                      inserir(arq,posicao ,&l);
                  }
                  else{
                         scanf("%s", arq);
                         inserirFim(arq, &l);
                  }
               }
            }
         }
      }
   }
   printLista(&l);
   freeLista(&l);
}
