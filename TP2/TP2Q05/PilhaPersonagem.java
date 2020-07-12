/*
   Nome: Larissa Domingues Gomes
   Turno: Manha
   Numero de Matricula: 650525
   Professor: Felipe Cunha 
   Questao:Classe Personagens Star Wars Pilha
*/

class PilhaPersonagem{

	private int tamanho;
	private Personagem[] personagemArray;
        private int fim;

	/*Construtor vazio*/
	public PilhaPersonagem(){
		this.tamanho = 0;
		this.fim = 0; 
	}	
	/*Construtor que recebe como parametro tamanho da fila*/
	public PilhaPersonagem(int tamanho)throws Exception{
		this.tamanho = tamanho;
		this.fim = 0;
		personagemArray = new Personagem[tamanho];//criacao objetos personagens

	}
	
   /*Metodo para imprimir na tela elementos da pilha*/
   public void printPilha()throws Exception{
      if(this.fim <= 0)
         throw new Exception("Erro");
      for(int aux = 0; aux < this.fim; aux++)
      {
         this.personagemArray[aux].setPeso(0.0);//SetPeso = 0, para printar = 0
         MyIO.print("["+aux+"] ");
         this.personagemArray[aux].printDados();
      }
   }

   /*Metodo para remover personagem da lista */
   public Personagem remover()throws Exception{
      if(this.fim == 0)
			throw new Exception("ERRO! Nao ha personagem para remover");

      this.fim--;//Modificar fim
      MyIO.println("(R) "+personagemArray[this.fim].getNome());
      return personagemArray[this.fim].Clone();
	}

   /*Metodo para inserir personagem na lista, recebe como parametro
    * uma string contendo o */
   public void inserir(String arq)throws Exception{
      if(this.fim >= this.tamanho)
         throw new Exception("ERRO! Nao ha espaco para inserir personagem");
      
     // MyIO.println(arq);
      personagemArray[this.fim] = new Personagem(arq);//Criacao de novo objeto na fila
      this.fim++;
   }
}
