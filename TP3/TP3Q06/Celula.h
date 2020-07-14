/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Celula Personagem
*/

#include "Personagem.h"

/*Struct celula*/
struct Celula{
    struct Celula* prox;
    Personagem elemento;
}typedef Celula;

/*Construtor struct celula vazio*/
Celula* construtorCelulaV(){
    Celula* c = (Celula*)malloc(sizeof(Celula));
    (*c).prox = NULL;
    return c;
}

/*Construtor struct celula*/
Celula* construtorCelula(char arq[]){
    Celula* c = (Celula*)malloc(sizeof(Celula));
    (*c).prox = NULL;
    ConstrutorPersonagem(&(*c).elemento, arq);
    return c;
}
