/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: No
*/

#include "Personagem.h"

struct No{
   Personagem elemento;
   struct No* esq;
   struct No* dir;
   int nivel;
}typedef No;

/*Metodo contrutor de No*/
No* ConstrutorNo(Personagem p){
   No* novo = (No*)malloc(sizeof(No));
   (*novo).dir = NULL;
   (*novo).esq = NULL;
   (*novo).elemento = p;
   (*novo).nivel = 1;//Nivel no = 1, pois quando criado eh uma folha 
   return novo;
}

/*Metodo para recuperar nivel de algum no*/
int getNivel(No* n){
   return (n == NULL)? 0 : n->nivel;//Se no = null, retornar nivel = 0
}

/*Metodo para setar nivel de no*/
void setNivel(No* n){
   int esq = getNivel(n->esq);
   int dir = getNivel(n->dir);
   if(esq > dir)//Teste para igualar nivel de ao maior nivel dos filhos
      n->nivel = 1 + esq;
   else  
      n->nivel = 1 + dir;     
} 
