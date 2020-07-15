/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Arvore AVL
*/

#include "No.h"

struct AVL{
   No* raiz;
}typedef AVL;

/*Metodo construtor de AVL*/
AVL* construtorAVL(){
   AVL* nova = (AVL*)malloc(sizeof(AVL));
   (*nova).raiz = NULL;
   return nova;
}

/*Metodo recursivo para pesquisa conforme o nome*/
bool pesquisarRec(No* i, char nome[], int* c){
   bool resp;
   if(i == NULL)
      resp = false;
   else if(strcmp(nome, i->elemento.nome) > 0){
         (*c)++;
         printf("dir ");
         resp = pesquisarRec(i->dir, nome, c);
   }
   else if(strcmp(nome, i->elemento.nome) < 0){
         (*c)++;
         printf("esq ");
         resp = pesquisarRec(i->esq, nome, c);
      }
   else
      resp = true;
   return resp; 
}

/*Metodo para pesquisar personagem por nome*/
bool pesquisar(AVL* arv, char nome[], int* c){
   printf("raiz ");
   return pesquisarRec(arv->raiz, nome,c);
}

/*Metodo para rotacionar para direita*/
void rotDir(No** i){
   No* esq = (*i)->esq;
   No* esqDir = esq->dir;

   esq->dir = (*i);
   (*i)->esq = esqDir;

   setNivel((*i));
   setNivel(esq);

   (*i) = esq;
}

/*Metodo para rotacionar para esquerda*/
void rotEsq(No** i){
   No* dir = (*i)->dir;
   No* dirEsq = dir->esq;

   dir->esq = (*i);
   (*i)->dir = dirEsq;
   
   setNivel((*i));
   setNivel(dir);

   (*i) = dir;

}

//Procedimento para balancear no recebido caso necessario
void balancear(No** i){
   if((*i) != NULL){
      int fator = getNivel((*i)->dir) - getNivel((*i)->esq);
      if(abs(fator) <= 1){
    //     printf("%i\n", (*i)->nivel);
         setNivel((*i));
     //    printf("%i\n", (*i)->nivel);
      }
      else if(fator == 2){
         int fatorFilho = getNivel((*i)->dir->dir) - getNivel((*i)->dir->esq);
         if(fatorFilho == -1)
            rotDir(&(*i)->dir);
         rotEsq(i);
      }
      else if(fator == -2){
         int fatorFilho = getNivel((*i)->esq->dir) - getNivel((*i)->esq->esq);
         if(fatorFilho == 1)
            rotEsq(&(*i)->esq);
         rotDir(i);
      }else{
         printf("ERRO!");
      }
   }
}

/*Metood recursivo para inserir elementos na arvore
 *Recebe ponteiro de ponteiro para fazer alteracoes
 *diretamaneto no espaco de memoria do ponteiro de no
 *recebido*/
void inserirRec(No** i, Personagem p, int* c){
   if(*i == NULL){
      //printf("Inseriu\n");
      (*i) = ConstrutorNo(p);
   }
   else{ 
      (*c)++;
      if(strcmp(p.nome, (*i)->elemento.nome) > 0){
         inserirRec(&((*i)->dir), p, c);
      }else {
         (*c)++;
         if(strcmp(p.nome, (*i)->elemento.nome) < 0){
            inserirRec(&((*i)->esq), p, c);
         }
      }
   }
   balancear(i);//Procedimento para balancear AVL*/
}

void antecessor(No** i, No** j) {
   if ((*j)->dir != NULL) {
      antecessor(i, &((*j)->dir));

   } else {
      No* del = *j;
      (*i)->elemento = (*j)->elemento;
      (*j) = (*j)->esq;
      free(del);
   }
}

/*Metodo para inserir elementos na arvore*/
void inserir(AVL* arv, Personagem p, int* c){
   inserirRec(&arv->raiz, p,  c);
}

/*Metodo recursivo para remover persogem conforme o nome*/
void removerRec(No** i, char nome[]){
  if(*i == NULL){
      printf("ERRO AO INSERIR\n");
   }
   else if(strcmp(nome, (*i)->elemento.nome) > 0){
         removerRec(&((*i)->dir), nome);
   }
   else if(strcmp(nome, (*i)->elemento.nome) < 0){
            removerRec(&((*i)->esq), nome);
   }
   else if((*i)->dir == NULL){
      No* removido = (*i);
      (*i) = (*i)->esq;
      free(removido);
   }
   else if((*i)->esq == NULL){
      No* removido = (*i);
      (*i) = (*i)->dir;
      free(removido);
   }else{
      antecessor(i, &((*i)->esq));
   }
   balancear(i);//Procedimento para balancear AVL*/
}

/*Metodo para remover persogem conforme o nome*/
void remover(AVL* arv, char nome[]){
   removerRec(&arv->raiz, nome);
}
