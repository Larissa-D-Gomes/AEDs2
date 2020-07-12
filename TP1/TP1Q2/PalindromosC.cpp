/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:PALINDROMOS C
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
		/*
		 * 	 *Classe que retorna valor logico, referente 
		 * 	 	 *se a string lida eh ou nao palindromo.
		 * 	 	 	 *Recebe como parametro a string a ser analisada.
		 * 	 	 	 	 */
bool VerificadorPalindromo(char* Linha)
{
   bool resp = true;
   int contador1 = 0;//Variaveis para marcar o caracter lido
   int contador2 = strlen(Linha)-1;
   while(contador1 <= contador2 && resp)//Repeticao com teste fisico e logico,para caso ache um caracter que comprove que nao eh palindromo
   {
      resp = (Linha[contador1] == Linha[contador2]);//comparador de caracteres
      contador1++;
      contador2--;
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
      if(VerificadorPalindromo(leitura))
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


