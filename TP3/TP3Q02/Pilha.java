/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Pilhaa Flexivel
*/

class Pilha{
   private Celula topo;

   public Pilha()throws Exception{
      this.topo = null;
   }

   public void inserir(String arq)throws Exception{
      Celula tmp = new Celula(arq);
      tmp.prox = this.topo;//conectar variavel inserida a pilha
      this.topo = tmp;//colocar variavel inserida no topo
      tmp = null;
   }

   public Personagem remover()throws Exception{
      if(this.topo == null)
         throw new Exception("ERRO! PILHA VAZIA");

      Celula tmp = this.topo;//Variavel temporaria para armazenar topo removido
      topo = tmp.prox;
      tmp.prox = null;//desconectar removido da pilha
      Personagem removido = tmp.getPersongem();
      tmp = null;
      return removido;
   }

   public void mostrar(){
      mostrarIns(topo);
   }

   //Funcao recursiva para printar elementos na ordem que foram inseridos
   //Retorna o valor numerico da posicao no print
   public int mostrarIns(Celula i){
      int posicao = 0;
      if(i != null){
         posicao += mostrarIns(i.prox);
         System.out.print("["+(posicao-1)+"] ");
         i.getPersongem().printDados();
      }
      return (posicao+1);
   }

}
