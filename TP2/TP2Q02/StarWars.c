/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C
*/
#include "Personagem.h"

bool IsFim(char p[])
{
   return (strlen(p) == 3 && p[0] == 'F' && p[1] == 'I' && p[2] == 'M');
}
 
int main()
{
   char leitura[_MAX_];
   scanf("%s",leitura);
   while(!IsFim(leitura))
   {
      Personagem P;
      ConstrutorPersonagem(&P, leitura);
      printdados(P);
      scanf("%s",leitura);
   }
}