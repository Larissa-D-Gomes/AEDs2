/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars C Fila Circular
*/

#include "Personagem.h"


/*Struct para lista de personagens*/
struct FilaPersonagem
{
   Personagem* personagensArray;
   int tamanho;
   int fim;
   int inicio;
}typedef FilaPersonagem;

/*Metodo construtor da fila, recebe o tamanho como parametro*/
void ConstrutorFila(FilaPersonagem* f, int tamanho){
   (*f).tamanho = tamanho + 1;
   (*f).personagensArray = (Personagem*)malloc(((*f).tamanho+1)*sizeof(Personagem));;
   (*f).inicio = 0;
   (*f).fim = 0;
}

/*Funcao para calcular media de alturaa dos personagens na fila*/
int mediaAltura(FilaPersonagem* f){
   double media = 0;
   double soma = 0;
   double quantidade = 0;
   for(int aux = (*f).inicio; aux != (*f).fim; aux = (aux+1) % (*f).tamanho){
      soma+=(*f).personagensArray[aux].altura;
      quantidade+=1;
   }
   media = soma/quantidade;
   if(media - (int)media >= 0.5)//Arredondar media para cima
      media+=0.5;
   return (int)media;//retorno do valor arredondado da media
}

/*Metodo para remover personagem do array*/
Personagem remover(FilaPersonagem* f){
   Personagem removido;
   if((*f).fim == (*f).inicio)//Teste para verificar se fila nao esta vazia
      printf("ERRO! Nao ha personagem par ser removido.\n");
   else{
      removido = (*f).personagensArray[(*f).inicio];
      (*f).inicio = ((*f).inicio + 1 ) % (*f).tamanho;
   }
   return removido;
}

/*Metodo para inserir personagem no array, recebe o nome do arquivo como parametro*/
void inserir(FilaPersonagem* f, char arq[]){
   if((((*f).fim+1))%(*f).tamanho == (*f).inicio)//Teste para verificar se o array esta cheio
      remover(f);//Caso estaja remover personagem antes de outro

   //printf("%s\n",arq);
   ConstrutorPersonagem(&(*f).personagensArray[(*f).fim], arq);
   (*f).fim= ((*f).fim + 1) % (*f).tamanho;
   printf("%i\n", mediaAltura(f));//print do arredondamento da media de alturas de elementos
                                  //do array
}

/*Metodo para printar atributos da fila*/
void printFila(FilaPersonagem* f){
   for(int aux = (*f).inicio; aux != (*f).fim; aux = (aux+1) % (*f).tamanho){
      printdados((*f).personagensArray[aux]);
   }
}

/*Metodo para liberar espaco do array da lista*/
void freeFila(FilaPersonagem* f){
   free((*f).personagensArray);
}
