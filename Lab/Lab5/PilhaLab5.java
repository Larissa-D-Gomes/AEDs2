/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
 
 /*
   Nome: Larissa Domingues Gomes
   Turno: Manha
   Numero de Matricula: 650525
   Professor: Felipe Cunha 
   Questao:Lab5
  */


public class PilhaLab5 {
   private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
   public Pilha() {
      topo = null;
   }


	/**
	 * Insere elemento na pilha (politica FILO).
	 * @param x int elemento a inserir.
	 */
   public void inserir(int x) {
      Celula tmp = new Celula(x);
      tmp.prox = topo;
      topo = tmp;
      tmp = null;
   }


	/**
	 * Remove elemento da pilha (politica FILO).
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
   public int remover() throws Exception {
      if (topo == null) {
         throw new Exception("Erro ao remover!");
      }
   
      int resp = topo.elemento;
      Celula tmp = topo;
      topo = topo.prox;
      tmp.prox = null;
      tmp = null;
      return resp;
   }


	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
   public void mostrar() {
      System.out.print("[ ");
      for(Celula i = topo; i != null; i = i.prox){
         System.out.print(i.elemento + " ");
      }
      System.out.println("] ");
   }
	
	//Q01-Somar elementos recursivamente
   public void Soma(){
      System.out.println("A soma eh: "+somaRec(topo));
   }

   public int somaRec(Celula i) {
      int soma = 0;
      if(i != null){
         soma += i.elemento + somaRec(i.prox);
      }
      return soma;
   }

	//Q02-Encontrar maior elementos
   public int maiorIt(){
      int maior = topo.elemento;
      for(Celula i = topo.prox; i != null; i = i.prox){
         if(i.elemento > maior)
            maior = i.elemento;
      }
      return maior;
   }

	//Q03-Encontrar maior elemento recursivamente
   public int maiorRec(Celula i){
      int maior = i.elemento;
      if(i.prox != null){
         int retorno = maiorRec(i.prox);
         if(retorno > maior){
            maior = retorno;
         }
      }
      return maior;
   }

   public void getMaiorRec(){
      System.out.println("O maior elemento eh: "+maiorRec(topo));
   }

	//Q04-Mostrar elementos recursivamente conforme serao removidos
   public void mostrarRecRem(){
      mostrarRem(topo);
      System.out.println("");
   }

   public void mostrarRem(Celula i){
      if(i != null){
         System.out.print(i.elemento+" ");
         mostrarRem(i.prox);
      }
   }

	//Q05-Mostrar elementos recursivamente conforme foram inseridos
   public void mostrarRecIns(){
      mostrarIns(topo);
      System.out.println("");
   }

   public void mostrarIns(Celula i){
      if(i != null){
         mostrarIns(i.prox);
         System.out.print(i.elemento+" ");
      }
   }

	//Q06-Mostrar elementos recursivamente conforme foram inseridos
   public void mostrarIns(){
      int elementos = 0;
      for(Celula i = topo; i != null; i = i.prox){//Encotrar quantidade de elementos
         elementos++;
      }
      for(int aux = elementos; aux > 0; aux--){//Ordem de insercao = quantidade--
         Celula i = topo;
         for(int j = aux-1; j > 0; j--){//Percorrer pilha ate encontrar o primeiro, segundo, terceiro,
          							   //elemento gradativamente 
            i = i.prox;
         }
         System.out.print(i.elemento+" ");
      }
      System.out.println("");
   }
	
}
