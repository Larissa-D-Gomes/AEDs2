/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Fila Circular
*/

#include "FilaPersonagem.h"

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
   FilaPersonagem f;
   ConstrutorFila(&f, 5);
   Personagem p;
   //Repeticao para fazer o set de dados do array de personagens ate o fim
   scanf("%s", arq);
   //printf("%s\n",arq);
   while(!IsFim(arq)) {
      inserir(&f, arq);
      scanf("%s", arq);
      //printf("%s\n",arq);
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
         inserir(&f, arq);
      }
      else{
         p = remover(&f);
         printf("(R) %s\n",p.nome);//print do personagem removido
      }
   }
   printFila(&f);
   freeFila(&f);
}
