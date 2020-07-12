/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Ordenacao por Selecao
*/

class ListaPersonagem{
   private Personagem[] personagensArray;
   private int tamanho;
   private int fim;
   private int numComparacoes;
   private int numMovimentacoes;

   /*Metodo para trocar elementos do array, recebe com parametro as posicoes */
   private void swap(int p1, int p2)
   {
      Personagem aux = this.personagensArray[p1].Clone();
      this.personagensArray[p1] = this.personagensArray[p2].Clone();
      this.personagensArray[p2] = aux;
   }

   /*Construtor vazio*/
   public ListaPersonagem(){
      this.tamanho = 0;
   }

   /*Construtor que recebe como parametro o tamanho da lista de Personagem*/ 
   public ListaPersonagem(int tamanho)throws Exception{
      this.tamanho = tamanho+1;
      this.personagensArray = new Personagem[this.tamanho];//Alocacao de memoria para quantidade
                                                          //recebida de personagens
      this.fim = 0;//Valor inicial fim                                             
   }
   
   /*Metodo para imprimir na tela elementos da lista*/
   public void printLista()throws Exception{
      if(this.fim <= 0)
         throw new Exception("Erro");
      for(int aux = 0; aux < this.fim; aux++)
      {
         this.personagensArray[aux].printDados();
      }
   }
   /*Funcao para remover personagem no inicio da fila*/
   public Personagem removerInicio()throws Exception{
      Personagem removido;
      if(this.fim <= 0)
         throw new Exception("Erro");
   
      removido = this.personagensArray[0];
      MyIO.println("(R) "+this.personagensArray[0].getNome());
      this.fim--;
     //Repeticao para fazer o shift dos elementos da lista
      for(int aux = 0; aux < this.fim; aux++)
      {
         this.personagensArray[aux] = this.personagensArray[aux+1].Clone();
         //this.personagensArray[aux].printDados();
      }
      return removido;
   }

   /*Funcao para remover personagem da lista Parametro: posicao da remocao*/
   public Personagem remover(int posicao)throws Exception{
      Personagem removido;
      if(posicao < 0 && posicao > this.fim)
         throw new Exception("Erro: posicao invalida.");
     
      removido = this.personagensArray[posicao];
      MyIO.println("(R) "+this.personagensArray[posicao].getNome());

      this.fim--;
      //Repeticao para fazer o shift dos elementos da lista
      for(int aux = posicao; aux < this.fim; aux++)
      {
         this.personagensArray[aux] = this.personagensArray[aux+1].Clone();
      }
      return removido;
   }
   /*Funcao para remover personagem do fim da lista*/
   public Personagem removerFim()throws Exception{
      Personagem removido;
      if(this.fim <= 0)
         throw new Exception("Erro");
   
      removido = this.personagensArray[this.fim-1];
      MyIO.println("(R) "+removido.getNome());
      this.fim--;
   
      return removido;
   }

   /*Metodo para inserir personagem na lista, Parametro:String contendo arquivo do personagem
    *e a posicao a ser inseriada*/
   public void inserir(String arquivo, int posicao)throws Exception{
      if(posicao > this.fim || posicao < 0 || posicao >= this.tamanho || this.fim == this.tamanho)
         throw new Exception("ERRO: Posicao invalida.");
   
   	//Shift dos elementos do arquivo
      for(int aux  = this.fim; aux > posicao; aux--)
      { 
         this.personagensArray[aux] = this.personagensArray[aux-1].Clone();
      }
      this.personagensArray[posicao] = new Personagem(arquivo);//Inserir personagem na posicao recebida
      this.fim++;
   }

   /*Metodo para inserir personagem no inicio da lista, Parametro:String contendo arquivo do personagem*/
   public void inserirInicio(String arquivo)throws Exception{
      if( this.fim == this.tamanho)
         throw new Exception("ERRO");
   
      //Shift dos elementos do arquivo
      for(int aux  = this.fim; aux > 0; aux--)
      {   
         this.personagensArray[aux] = this.personagensArray[aux-1].Clone();
      }
      this.personagensArray[0] = new Personagem(arquivo);//Inserir personagem na posicao recebida
      this.fim++;
   }
   /*Metodo para inserir personagem no fim da lista, Parametro:String contendo arquivo do personagem*/
   public void inserirFim(String arquivo)throws Exception{
      if( this.fim == this.tamanho)
         throw new Exception("ERRO");
   
      this.personagensArray[this.fim] = new Personagem(arquivo);//Inserir personagem na posicao recebida
      this.fim++;
   }

   /*Metodo para ordenar elementos na lista por meio de insercao, chave:ano de nascimento*/
   public void insercao(){
       for(int i = 1; i < this.fim; i++){
	      Personagem tmp = this.personagensArray[i].Clone();
       	int j = i - 1;
	      while(j >= 0 && this.personagensArray[j].getAnoNascimento().compareTo(tmp.getAnoNascimento()) > 0 ){
            this.personagensArray[j+1] = this.personagensArray[j].Clone();
	         this.numMovimentacoes++;
	         this.numComparacoes++;
	         j--;
         }
	      this.personagensArray[j+1] = tmp;
	      this.numMovimentacoes++;
       }
   }

   public int getNumComparacoes(){
      return numComparacoes;
   }
      public int getNumMovimentacoes(){
      return numMovimentacoes;
   }
}