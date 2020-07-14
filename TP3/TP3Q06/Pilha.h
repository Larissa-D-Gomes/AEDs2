/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Pilha Flexivel
*/

#include "Celula.h"

/*Struct para lista de personagens*/
struct Pilha{
   Celula* topo;
}typedef Pilha;

void construtorPilha(Pilha* p){
   (*p).topo = NULL;
}

void inserir(Pilha* p, char arq[]){
   Celula* tmp = construtorCelula(arq);
   (*tmp).prox = (*p).topo;//conectar inserido
   (*p).topo = tmp;//mover topo
   tmp = NULL;
}

Personagem remover(Pilha* p){
   Personagem removido;
   if((*p).topo == NULL){
      printf("ERRO!\n");
   }else{
      Celula* tmp = (*p).topo;
      removido = (*tmp).elemento;
      (*p).topo = (*tmp).prox;//mover topo
      (*tmp).prox = NULL;//desconectar removido
      free(tmp);
      tmp = NULL;
   }
   return removido;
}

int printPilha(Celula* i){
   int contador = 0;
   if(i != NULL){
      contador += printPilha((*i).prox);
      printf("[%i] ", contador-1);
      (*i).elemento.peso = 0.0;
      printdados((*i).elemento);
   }
   return contador+1;
}

void print(Pilha* p){
   printPilha((*p).topo);
}

void freePilha(Pilha* p){
   Celula* tmp = (*(*p).topo).prox;
   free((*p).topo);
   (*p).topo = NULL;
   for(Celula* i = tmp; i != NULL; i = tmp){
      tmp = (*i).prox;//variavel para caminhar nas variaveis do array
      free(i);
      i = NULL;
   }
}
