/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Hash Indireta com Lista Simples
*/

#include "Lista.h"

struct Hash{
   Lista* tabela;
   int tamTab;
}typedef Hash;

/*Metodo construtor de lista*/
void construtorHash(Hash* h, int x){
   (*h).tamTab = x;
   (*h).tabela = (Lista*)malloc(sizeof(Lista)*x);//alocacao de memoria de tabela
   
   //Construir listas em todas posicoes da tabela
   for(int i = 0; i < x; i++)
      ConstrutorLista(&(*h).tabela[i]);
}

/*Metodo para inserir personagem em tabela hash*/
void inserirHash(Hash* h, Personagem p){
   int pos = p.altura % (*h).tamTab;
   inserirFim(&(*h).tabela[pos], p);
}

/*Metodo para pesquisar personagem conforme nome*/
bool pesquisarH(Hash* h, char n[], int* c){
   bool resp = 0;
   
   for(int i = 0; i < (*h).tamTab && !resp; i++ ){
      resp = pesquisar(&(*h).tabela[i], n, c);
   }
   return resp;
}

bool mostrarH(Hash* h){
   bool resp = 0;
   
   for(int i = 0; i < (*h).tamTab; i++ )
      mostrarLista(&(*h).tabela[i]);
   return resp;
}

/*Metodo para remover personagem conforme nom*/ 
Personagem removerH(Hash* h, char n[], int* c){
   bool r = 0;
   Personagem resp;
   for(int i = 0; i < (*h).tamTab && !r ; i++ ){
      resp = removerNum(&(*h).tabela[i], n, c);
      if(strcmp(resp.nome, n) == 0){
         r = 1;
         printf("Entrou\n %s",resp.nome);
      }
   }
   return resp;
}

bool pesquisarHash(Hash* h, Personagem p, int* c){
   int pos = p.altura % (*h).tamTab;
   return pesquisar(&(*h).tabela[pos], p.nome, c);;
}
