/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Pesquisa binaria
*/

#include "Personagem.h"

/*Struct para lista de personagens*/
struct ListaPersonagem
{
   Personagem* personagensArray;
   int tamanho;
   int fim;
}typedef ListaPersonagem;

/*Construtor de lista vazio*/
void ConstrutorListaV(ListaPersonagem* l)
{
   (*l).tamanho = 0;
   (*l).fim = 0;
}

   /*Construtor que recebe como parametro o tamanho da lista de Personagem*/ 
void ConstrutorLista(ListaPersonagem* l, int tamanho)
{
   (*l).tamanho = tamanho;
   (*l).personagensArray = (Personagem*)malloc((*l).tamanho*sizeof(Personagem));//Alocacao de memoria para quantidade
                                                                                  //recebida de personagens
   (*l).fim = 0;//Valor inicial fim
}

/*Metodo para imprimir na tela elementos da lista*/
void printLista(ListaPersonagem* l){
   if((*l).fim <= 0)
      printf("Erro\n");
   else
   {
      for(int aux = 0; aux < (*l).fim; aux++)
      {
         printdados((*l).personagensArray[aux]);
      }
   }
}

/*Funcao para remover personagem no inicio da fila*/
Personagem removerInicio(ListaPersonagem* l){
   Personagem removido;
   if((*l).fim <= 0)
      printf("Erro\n");
   else
   {
      removido = (*l).personagensArray[0];
      printf("(R) %s\n",(*l).personagensArray[0].nome);
     
      (*l).fim--;
      //Repeticao para fazer o shift dos elementos da lista
      for(int aux = 0; aux < (*l).fim; aux++)
      {
         (*l).personagensArray[aux] = (*l).personagensArray[aux+1];
      }
   }
   return removido;
}

/*Funcao para remover personagem da lista Parametro: posicao da remocao*/
Personagem remover(ListaPersonagem* l, int posicao){
   Personagem removido;
   if(posicao < 0 && posicao > (*l).fim)
      printf("Erro: posicao invalida.\n");
   else{     
      removido = (*l).personagensArray[posicao];
      printf("(R) %s\n",(*l).personagensArray[posicao].nome);
      (*l).fim--;
      //Repeticao para fazer o shift dos elementos da lista
      for(int aux = posicao; aux < (*l).fim; aux++)
      {
         (*l).personagensArray[aux] = (*l).personagensArray[aux+1];
      }
   }
   return removido;
}

/*Funcao para remover personagem do fim da lista*/
Personagem removerFim(ListaPersonagem* l){
   Personagem removido;
   if((*l).fim <= 0)
      printf("Erro\n");
   else{
      removido = (*l).personagensArray[(*l).fim-1];
      printf("(R) %s\n",(*l).personagensArray[(*l).fim-1].nome);
      (*l).fim--;
   }
   return removido;
}
/*Metodo para inserir personagem no inicio da lista, Parametro:String contendo arquivo do personagem*/
void inserirInicio(char arquivo[], ListaPersonagem* l){
   if( (*l).fim == (*l).tamanho)
      printf("ERRO\n");
   else{
   //Shift dos elementos do arquivo
   for(int aux  = (*l).fim; aux > 0; aux--)
   {   
      (*l).personagensArray[aux] = (*l).personagensArray[aux-1];
   }
   ConstrutorPersonagem(&(*l).personagensArray[0], arquivo );//Inserir personagem na posicao recebida
   (*l).fim++;
   }
}
/*Metodo para inserir personagem na lista, Parametro:String contendo arquivo do personagem
 *e a posicao a ser inseriada*/
void inserir(char arquivo[], int posicao, ListaPersonagem* l){
   if(posicao > (*l).fim || posicao < 0 || posicao >= (*l).tamanho || (*l).fim == (*l).tamanho)
	   printf("ERRO: Posicao invalida.\n");
   else{
      //Shift dos elementos do arquivo
      for(int aux  = (*l).fim; aux > posicao; aux--)
      { 
	      (*l).personagensArray[aux] = (*l).personagensArray[aux-1];
      }
      ConstrutorPersonagem(&(*l).personagensArray[posicao], arquivo );//Inserir personagem na posicao recebida
      (*l).fim++;
   }
}

/*Metodo para inserir personagem no fim da lista, Parametro:String contendo arquivo do personagem*/
void inserirFim(char arquivo[], ListaPersonagem* l ){
   if( (*l).fim == (*l).tamanho)
	   printf("ERRO\n");
   else{		
	   ConstrutorPersonagem(&(*l).personagensArray[(*l).fim], arquivo );//Inserir personagem na posicao recebida
	   (*l).fim++;
   }
}
/*Metodo para liberar espaco do array da lista*/
void freeLista(ListaPersonagem* l){
   free((*l).personagensArray);
}

/*metodo para fazer swap de elemntos da lista, recebe as posicoes como parametro*/
void swap(int p1, int p2, ListaPersonagem* l){
   Personagem aux = (*l).personagensArray[p1];
   (*l).personagensArray[p1] = (*l).personagensArray[p2];
   (*l).personagensArray[p2] = aux;

}

/*Funcao recursiva de ordenacao por selecao, recebe uma lista como parametro*/
void selecao(ListaPersonagem* l,int menor, int i,int j, int* c, int* s){
   if(i < ((*l).fim-1))
   {
      if(j >= (*l).fim){
         swap(menor, i, l);
         (*s)+=3;
         selecao(l,i+1, i+1, i+2, c, s);
      }else{
         (*c)++;
         if(strcmp((*l).personagensArray[j].nome,(*l).personagensArray[menor].nome) < 0){
            menor = j;
         }
         selecao(l, menor, i, j+1, c, s);
      }
   }
}
