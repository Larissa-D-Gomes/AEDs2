/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Lista Simples em C
*/

#include "Celula.h"

/*Struct para lista de personagens*/
struct Lista{
   Celula* primeiro;
   Celula* ultimo;
}typedef Lista;

/*Construtor lista*/
void ConstrutorLista(Lista* l){
   (*l).primeiro = construtorCelulaV();
   (*l).ultimo = (*l).primeiro;  
}

/*Metodo para inserir no inicio*/
void inserirInicio(Lista* l, Personagem p){
   Celula* tmp = construtorCelula(p);
   (*tmp).ant = (*l).primeiro;
   (*tmp).prox = (*(*l).primeiro).prox;

   if((*l).primeiro == (*l).ultimo){//Teste para verificar se sera ultimo elemento
      (*l).ultimo = tmp;
   }else{
      (*(*tmp).prox).ant = tmp;//Se nao for o ultimo, conectar o anterior do prox
   }
   tmp = NULL;
}

/*Metodo para inserir no fim*/
void inserirFim(Lista* l, Personagem p){
   (*(*l).ultimo).prox = construtorCelula(p);//Inserir nova celula no fim
   (*(*(*l).ultimo).prox).ant = (*l).ultimo;//Conectar anterior com fila
   (*l).ultimo = (*(*l).ultimo).prox;
}

/*Metodo para remover no inicio*/
Personagem removerInicio(Lista* l){
   Personagem removido;

   if((*l).primeiro == (*l).ultimo){
      printf("ERRO!\n");
   }else{
      (*l).primeiro = (*(*l).primeiro).prox;//Celula removida = celula cabeca
      removido = (*(*l).primeiro).elemento;
      (*(*(*l).primeiro).ant).prox = NULL;//Desconectar primeiro anterior
      free((*(*l).primeiro).ant);
   }
   return removido;
}

/*Metodo para remover do fim*/
Personagem removerFim(Lista* l){
   Personagem removido;

   if((*l).primeiro == (*l).ultimo){
      printf("ERRO!\n");
   }else{
      removido = (*(*l).ultimo).elemento;
      (*l).ultimo = (*(*l).ultimo).ant;//Ultimo = penultimo
      (*(*(*l).ultimo).prox).ant = NULL;//desconectar removido
      free((*(*l).ultimo).prox);
   }
   return removido;
}

/*Metodo que retorna tamanho da lista duplamente encadeada*/
int tamanho(Lista* l){
   int resp = 0;
   for(Celula* i = (*l).primeiro; i != (*l).ultimo; i = (*i).prox, resp++);

   return resp;
}

/*Metodo para inserir elemento de posicao valida*/
void inserir(Personagem p, int posicao, Lista* l){
   int t = tamanho(l);
   if(posicao > t || posicao < 0){//Teste para verificar se posicao eh valida 
      printf("ERRO!\n");
   }else{
      if(posicao == t){
         inserirFim(l, p);
      }else{
         if(posicao == 0){
            inserirInicio(l, p);
         }else{
            Celula* i = (*l).primeiro;

            for(int x = 0; x < posicao; x++, i = (*i).prox);//Encontar posicao de insercao
            Celula* tmp = construtorCelula(p);//Criar nova celula
            (*tmp).ant = i;//conectar nova celula na lista
            (*tmp).prox = (*i).prox;
            (*i).prox = tmp;//conectar elementos da lista na nova celula
            (*(*tmp).prox).ant = tmp;
            i = NULL;//liberar ponteiros
            tmp = NULL;
         }
      }
   }
}

/*Metodo para remover elemento de posicao valida*/
Personagem remover(int posicao, Lista* l){
   int t = tamanho(l);
   Personagem removido;
   if(posicao > t || posicao < 0 || (*l).primeiro == (*l).ultimo){//Teste para verificar se posicao eh valida 
      printf("ERRO!\n");
   }else{
      if(posicao == t){
         removerFim(l);
      }else{
         if(posicao == 0){
            removerInicio(l);
         }else{
            Celula* i = (*(*l).primeiro).prox;

            for(int x = 0; x < posicao; x++, i = (*i).prox);//Encontar posicao de remocao

            removido = (*i).elemento;
            (*(*i).prox).ant = (*i).ant;
            (*(*i).ant).prox = (*i).prox;
            (*i).prox = (*i).ant = NULL;
            free(i);
            i = NULL;
         }
      }
   }
   return removido;
}

/*Funcao para mostrar lista*/
void mostrarLista(Lista* l){
   for(Celula* i = (*(*l).primeiro).prox; i != NULL; i = (*i).prox){
      printdados((*i).elemento);
   }
}

/*Funcao para encontrar pivo (elemento do meio) para funcao quicksort*/
Personagem acharPivo(Celula* esq, Celula* dir){
   for( ; (esq != (*dir).ant) && (esq != dir); esq = (*esq).prox, dir = (*dir).ant );
   return (*esq).elemento;
}

void swap(Celula* esq, Celula* dir){
   Personagem aux = (*esq).elemento;
   (*esq).elemento = (*dir).elemento;
   (*dir).elemento = aux;
}

/*Verificar se uma posicao eh menor que outra*/
bool isMenor(Celula* esq, Celula* dir, Lista* l){
   bool resp = 0;
   Celula* aux = (*dir).ant;//Comecar em dir para verificar se eh menor 
   while(!resp && aux != (*l).primeiro && aux != NULL){//Parar quando chegar na extremidade da lista ou se 
                                        //esq for encontrado
      resp = (aux == esq);//Se esq esta em posicoes anteriores a dir, retornar 1
      aux = (*aux).ant;//movimentar variavel de procura
   }
   return resp;
}

/*Verificar se uma posicao eh menor igual que outra*/
bool isMenorIgual(Celula* esq, Celula* dir, Lista* l){
   bool resp = 0;
   Celula* aux = dir;//Comecar em dir para verificar se eh menor ou igual
   while(!resp && aux != (*l).primeiro){//Parar quando chegar na extremidade da lista ou se 
                                        //esq for encontrado
      resp = (aux == esq);//Se esq esta em posicoes anteriores a dir, retornar 1
      aux = (*aux).ant;//movimentar variavel de procura
   }
   return resp;
}


/*Metodo ordenacao quicksort*/
void quicksortO(Celula* esq, Celula* dir, Lista* l, int* c, int* s){
   Celula* i = esq;
   Celula* j = dir;
   Personagem pivo = acharPivo(i, j);

   while( isMenorIgual(i, j, l) ){
      while((strcmp((*i).elemento.corDoCabelo, pivo.corDoCabelo) < 0) || 
             strcmp((*i).elemento.corDoCabelo, pivo.corDoCabelo) == 0 &&
             strcmp((*i).elemento.nome, pivo.nome) < 0){
         i = (*i).prox;
         (*c)++;
      }

      while((strcmp((*j).elemento.corDoCabelo, pivo.corDoCabelo)) > 0 ||
             strcmp((*j).elemento.corDoCabelo, pivo.corDoCabelo) == 0 &&
             strcmp((*j).elemento.nome, pivo.nome) > 0) {
         j = (*j).ant;
         (*c)++;
      }

      if(isMenorIgual(i, j, l)){
         swap(i, j);
         i = (*i).prox;
         j = (*j).ant;
         (*s)+=3;
      }
      
   }
   
   if(isMenor(esq, j, l)){
      quicksortO(esq, j, l, c, s);
   }
   if(isMenor(i, dir, l)){
      quicksortO(i, dir, l,c, s);
   }
}

/*Chamada quicksort*/
void quicksort(Lista* l, int* c, int* s){
   //printf("%s",(*(*(*l).primeiro).prox).elemento.nome);
   quicksortO((*(*l).primeiro).prox, (*l).ultimo, l, c, s);
}

/*Funcao para liberar espaco de memoria de elementos da lista quando 
 * a mesma nao for mais usada*/
void freeLista(Lista* l){
   Celula* tmp = (*(*l).primeiro).prox;
   free((*l).primeiro);
   (*l).ultimo = NULL;
   
   for(Celula* i = tmp; i != NULL; i = tmp){
      tmp = (*i).prox;//variavel para caminhar nas variaveis do array
      free(i);
   }
}

bool pesquisar(Lista* l, char nome[], int* c){
   bool resp = 0;
   for(Celula* i = l->primeiro->prox; i != NULL && !resp; i = i->prox ){
      (*c)++;
      resp = (strcmp(i->elemento.nome, nome) == 0);
   }
   return resp;
}


Personagem removerNum(Lista* l, char n[], int* c){
   Personagem resp;

	if(pesquisar(l, n, c)){
      int i;
		Celula* j = (*(*l).primeiro).prox; 
		for(i = 0; strcmp(j->elemento.nome, n) != 0; i++, j = (*j).prox );
		resp = remover(i, l);
	}
	return resp;
}

