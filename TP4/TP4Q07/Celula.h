/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Celula Lista Simples em C
*/

#include "Personagem.h"

/*Struct para Celula*/
struct Celula{
   struct Celula* prox;
   struct Celula* ant;
   Personagem elemento;
}typedef Celula;

/*Construtor celula vazio*/
Celula* construtorCelulaV(){
   Celula* c = (Celula*)malloc(sizeof(Celula));
   (*c).prox = NULL;
   (*c).ant = NULL;
   return c;
}

/*Construtor celula*/
Celula* construtorCelula(Personagem p){
   Celula* c = (Celula*)malloc(sizeof(Celula));
   (*c).prox = NULL;
   (*c).ant = NULL;
   (*c).elemento = p;
   return c;
}
