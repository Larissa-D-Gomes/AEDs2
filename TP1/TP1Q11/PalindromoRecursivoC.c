/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:PALINDROMOS RECURSIVO C
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
		/*
		 *Funcao que retorna valor logico, referente 
		 *se a string lida eh ou nao palindromo.
		 *Recebe como parametro a string a ser analisada, e um contador para leitura.
		 */
bool VerificadorPalindromo(char* Linha, int contador1)
{
   bool resp = true;
   if(contador1 < strlen(Linha)/2)//Repeticao com teste fisico
   {
      resp = (Linha[contador1] == Linha[strlen(Linha)-1-contador1]);//comparador de caracteres
      if(resp)//Teste logico para nao chamar novamente a funcao, caso seja constatado que nao eh palindormo
      {   
         contador1++;
         resp = (resp && VerificadorPalindromo(Linha,contador1));//caso exista algum retorno negativo, todas respostas retornarao negativas pelo teste and
      }  
   }			           
   return resp;  
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
   char leitura[1000];
   scanf(" %[^\n]s", leitura);//scanf com %[^\n] para ler espaco e nao ler \n
   while(!VerificadorFim(&(leitura[0])))//Repeticao que compara strings lidas ate algum ser FIM
   {
      if(VerificadorPalindromo(leitura,0))
      {
         printf("SIM\n");
      }
      else
      {
         printf("NAO\n");
      }
      scanf(" %[^\n]s", leitura);
   }
}