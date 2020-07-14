/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao: Aleatorio C
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*Funcao recursiva, com retorno para replace dos caracteres sorteados
 *Recebe os caracteres e string como parametro
 */
char* AlteracaoAleatoria(char* leitura, char substituir, char substituto, int posicao)
{
   char* retorno;
   if(posicao == strlen(leitura))
   {
      retorno = (char*)malloc(1000*sizeof(char));//Fazer malloc na ultima vez que o metodo eh chamado para poder dar free no final da funcao
      retorno[posicao] = '\0';//igualar ultimo caracter ao \0
   }
   if(posicao < strlen(leitura))
   {
      retorno = AlteracaoAleatoria( leitura,  substituir, substituto, posicao+1);//Ponteiros  
      if(leitura[posicao] == substituir)
         retorno[posicao] = substituto;
      else
         retorno[posicao] = leitura[posicao];   
   }
   return retorno;
}
bool VerificadorFim(char* Linha)
{
   bool resp = (strlen(Linha)==3 || strlen(Linha) == 4);
   if(resp)
   {
      resp = (Linha[0] == 'F');
      if(resp)
      {
         resp= (Linha[1] == 'I');
      }
      if(resp)
      {
         resp = (Linha[2] == 'M');
      }
      if(resp && strlen(Linha) == 4)
      {
         printf("%s",Linha);
      
      }
   }
   return resp; 
}
int main()
{ 
   srand(4);
   char substituir = (char)(97 + (rand()%26));
   char substituto = (char)(97 + (rand()%26));
   char* leitura = (char*)malloc(1000*sizeof(char));
   char* aux;
   scanf(" %[^\n]s",leitura);//leitura string com espaco
   while(!VerificadorFim(leitura))
   {
      aux = AlteracaoAleatoria( leitura, substituir, substituto, 0);
      printf("%s\n",aux);
      substituir = (char)(97 + (rand()%26));
      substituto = (char)(97 + (rand()%26));
      scanf(" %[^\n]s",leitura);//leitura string com espaco
   }
   free(aux);
   free(leitura);
   return 0;
}