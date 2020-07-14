/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Celula Personagem
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
Celula* construtorCelula(char arq[]){
   Celula* c = (Celula*)malloc(sizeof(Celula));
   (*c).prox = NULL;
   (*c).ant = NULL;
   ConstrutorPersonagem(&(*c).elemento, arq);
   return c;
}
