/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Fila Flexivel Circular
*/

#include "Celula.h"

/*Struct para lista de personagens*/
struct FilaPersonagem
{
   int tamanho;
   Celula* ultimo;
   Celula* primeiro;
}typedef FilaPersonagem;

/*Construtor fila de elementos*/
void ConstrutorFila(FilaPersonagem* f){
    (*f).primeiro = construtorCelulaV();
    (*f).ultimo = (*f).primeiro;
    (*(*f).ultimo).prox = (*f).primeiro;//Conectar ultimo com primeiro, para estrutura circular
    (*f).tamanho = 0;
}

/*Funcao para calcular media de alturas*/
int mediaAltura(FilaPersonagem* f){
   double quantidade = 0.0;
   int media = 0;
   double soma = 0.0;
   for(Celula* i = (*(*f).primeiro).prox; i != (*f).primeiro; i = (*i).prox){
      soma += (*i).elemento.altura;
      quantidade = quantidade + 1.0;
   }
   media = round( soma/quantidade);//Aredondar valor para retorno de inteiro
   return media;
}

Personagem remover(FilaPersonagem* f){
    Personagem p;
    if((*f).ultimo == (*f).primeiro)
        printf("ERRO!Nao ha elementos para remover\n");
    else{
        Celula* tmp = (*f).primeiro;
        (*f).primeiro = (*(*f).primeiro).prox;
        p = (*(*f).primeiro).elemento;
        (*(*f).ultimo).prox = (*f).primeiro;//Concetar ultimo com novo primeiro, para estrutura circular
        (*tmp).prox = NULL;
        free(tmp);
        tmp = NULL;
        (*f).tamanho--;
    }
    return p;
}

void inserir(FilaPersonagem* f, char arq[]){
   //controle quantidade de elementos maximo = 5
   if((*f).tamanho >= 5){
      remover(f);
   }

   (*(*f).ultimo).prox = construtorCelula(arq);
   (*f).ultimo = (*(*f).ultimo).prox;
   (*(*f).ultimo).prox = (*f).primeiro;//Conectar novo ultimo com primeiro, para estrutura circular
   (*f).tamanho++;
   printf("%i\n",mediaAltura(f));
}

void printFila(FilaPersonagem* f){
   int x = 0;
   for(Celula* i = (*(*f).primeiro).prox; i != (*f).primeiro; i = (*i).prox, x++){
      (*i).elemento.peso = 0.0;//set peso 0.0 para print
      printf("[%i]",x);
      printdados((*i).elemento);
   }
}

/*Funcao para liberar espaco de memoria de elementos da lista quando 
 * a mesma nao for mais usada*/
void freeFila(FilaPersonagem* f){
   Celula* tmp = (*(*f).primeiro).prox;
   (*f).ultimo = NULL;
   for(Celula* i = tmp; i != (*f).primeiro; i = tmp){
      tmp = (*i).prox;//variavel para caminhar nas variaveis do array
      free(i);
      i = NULL;
   }
   free((*f).primeiro);
   (*f).primeiro = NULL;
   (*f).tamanho = 0;
}
