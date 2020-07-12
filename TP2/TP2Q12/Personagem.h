/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdbool.h>
#define _MAX_ 1000

/*Struct para armazenar dados de personagens*/
struct Personagem
{
   char nome[30];
   int altura;
   double peso;
   char corDoCabelo[20];
   char corDaPele[20];
   char corDosOlhos[20];
   char anoNascimento[10];
   char genero[10];
   char homeWorld[20];
}typedef Personagem;

/*Contrutor vazio personagem,Parametro Ponteiro da Struct Personagem*/
void ConstrutorPersonagemV(Personagem* P)
{
   (*P).altura = 0;//Iniciar variaveis numericas com valores nulos
   (*P).peso = 0.0;
}

/*Contrutor personagem,Parametro Ponteiro da Struct Personagem e
 * nome do arquivo txt contendo dados do personagem */
void ConstrutorPersonagem(Personagem* P, char nome[])
{
   void gravarDados(char dados[], Personagem* P);
   char leitor[10000];
   FILE* arq = fopen(nome, "rt");//Abertura do arquivo como leitura
   if(arq == NULL)//Verificacao se o arquivo foi aberto
   {
      printf("ERRO!\n");
   }
   else
   {
      fgets(leitor, 10000, arq);//Leitura da string que contem os dados 
      gravarDados(leitor, P);
   }
   fclose(arq);
}
/*Funcao para converter string para Double*/
double get_double(char n[])
{
   double decimais = 0.0;
   double num = 0.0;
   int aux = 0; 
   double dec = 0.0;
   while(n[aux] != '.' && aux < strlen(n))//Repeticao para concatenar de parte inteira
   {
      num = num*10.0 + ((double)n[aux]-48.0);
      aux++;
   }
   aux++;
   while(aux < strlen(n))//Repeticao para concatenar de parte fracionaria
   {
      dec = dec*10 + ((double)n[aux]-48.0);
      aux++;
      decimais++; //contador de numeros apos o .
   }
   num = num+(dec/pow(10,decimais));//Dividir pela quantidade de decimais para enviar a parte fracionaria 
                                  //para depois do '.'
   return num;
}

/*Metodo para verificar se informacao e desconhecida*/
bool isunknown(char p[])
{
   return (strlen(p) == 7 && p[0] == 'u' &&  p[1] == 'n' && p[2] == 'k' && p[3] == 'n'
            && p[4] == 'o' && p[5] == 'w' && p[6] == 'n');
}
 /*Metodo para gravar dados dos personagens
    *recebe como parametros uma string que 
    *contem os dados e o ponteiro da struct Personagem 
    */   
void gravarDados(char dados[], Personagem* P)
{
  // printf("%s\n",dados);
   int cursor = 10;//Pular caracteres "{'name': '"
   char c = dados[cursor];
   char aux[_MAX_];//String para fazer leitura para variaveis int
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).nome[i] = dados[cursor];
      (*P).nome[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
   //printf("%s\n",(*P).nome);
   
   cursor+=14; //Pular caracteres "', 'height': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      aux[i]=c;
      aux[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
   if(isunknown(aux))
      (*P).altura = 0;
   else
      (*P).altura = atoi(aux);//Converter String para inteiro
  // printf("%i\n", (*P).altura); 
   
   cursor+=12; //Pular caracteres "', 'mass': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)   
   {
      if( c == ',')//Evitar leitura do caracter ',' que representa milhar
      {
         cursor++;
         c = dados[cursor];
      }
      aux[i] = c;
      aux[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
  // printf("%s",aux);
   if(isunknown(aux))
      (*P).peso = 0.0;
   else
   {
      (*P).peso = get_double(aux);//Converter String para inteiro
   }
  // printf("%g\n",(*P).peso);
      
   cursor+=18; //Pular caracteres ', 'hair_color': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).corDoCabelo[i]=c;
      (*P).corDoCabelo[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
   //printf("%s\n",(*P).corDoCabelo);
      
   cursor+=18; //Pular caracteres "', 'skin_color': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).corDaPele[i]=c;
      (*P).corDaPele[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
  // printf("%s\n",(*P).corDaPele);
      
   cursor+=17; //Pular caracteres "', 'eye_color': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).corDosOlhos[i]=c;
      (*P).corDosOlhos[i+1]='\0';
      cursor++;
      c = dados[cursor];
   }
  // printf("%s\n",(*P).corDosOlhos);
      
   cursor+=18; //Pular caracteres "', 'birth_year': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).anoNascimento[i]=c;
      (*P).anoNascimento[i+1]='\0';;
      cursor++;
      c = dados[cursor];;
   }
   //printf("%s\n",(*P).anoNascimento);
      
   cursor+=14; //Pular caracteres "', 'gender': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).genero[i]=c;
      (*P).genero[i+1]='\0';;
      cursor++;
      c = dados[cursor];;
   }
  // printf("%s\n",(*P).genero);
      
   cursor+=17; //Pular caracteres "', 'homeworld': '"
   c = dados[cursor];
   for(int i = 0; (int)c != 39; i++)
   {
      (*P).homeWorld[i]=c;
      (*P).homeWorld[i+1]='\0';;
      cursor++;
      c = dados[cursor];;
   
   }
   //printf("%s\n",(*P).homeWorld);
}
/*Metodo para clonar Struct Personagem */
void Clone(Personagem* Clone, Personagem* Original )
{
   strcpy((*Clone).nome, (*Original).nome);
   (*Clone).altura = (*Original).altura;
   (*Clone).peso = (*Original).peso;
   strcpy((*Clone).corDoCabelo, (*Original).corDoCabelo);
   strcpy((*Clone).corDaPele, (*Original).corDaPele);
   strcpy((*Clone).corDosOlhos, (*Original).corDosOlhos);
   strcpy((*Clone).anoNascimento,(*Original).anoNascimento);
   strcpy((*Clone).genero, (*Original).genero);
   strcpy((*Clone).homeWorld, (*Original).homeWorld);
}

/*metodo para imprimir atributos da struct*/
void printdados(Personagem P)
{
   printf(" ## %s ## %i ## %g ## %s ## %s ## %s ## %s ## %s ## %s ## \n",P.nome, P.altura, P.peso, P.corDoCabelo,
          P.corDaPele, P.corDosOlhos, P.anoNascimento, P.genero,P.homeWorld);
}

