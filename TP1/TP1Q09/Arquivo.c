/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:Arquivo C
*/
#include <stdio.h>
#include <stdlib.h>
 /*Metodo para leitura do arquivo de tras para frente*/
void LerArquivo(int quantidadeNum)
{
   FILE* arq = fopen("Dados.dat", "rb");//abrir arquivo para leitura de binario
   double num = 0.0;
   for(int aux = 0; aux < quantidadeNum; aux++)//repeticao para ler no arquivo conforme a quantidade de vezes lida
   {
      fseek(arq, -8-aux*8, SEEK_END);
      fread(&num, sizeof(double), 1, arq);
      printf("%g\n",num);//Print sem casa decimal
   }	 
   fclose(arq);
}
int main()
{
   int quantidadeNum = 0;
   scanf("%i", &quantidadeNum);
   FILE* arquivo = fopen("Dados.dat", "wb");//abrir arquivo para escrita de binario
   double num = 0.0;
   for(int aux = 0; aux < quantidadeNum; aux++)//repeticao para escrever no arquivo conforme a quantidade de vezes lida
   {
      scanf("%lf", &num);
      //fseek(arquivo, sizeof(double)*aux, SEEK_SET);
      fwrite(&num, sizeof(double), 1, arquivo);//escrever double no arquivo
   }
   fclose(arquivo);
   LerArquivo(quantidadeNum);     
}  

