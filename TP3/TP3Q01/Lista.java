/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Lista Flexivel
*/

class Lista{
   private Celula primeiro;
   private Celula ultimo;

   Lista(){
      primeiro = new Celula();
		ultimo = primeiro;
   }

   //Metodo para inserir no inicio da Lista
   public void inserirInicio(String arq)throws Exception{
      Celula tmp =  new Celula(arq);
      tmp.prox = primeiro.prox;
      primeiro.prox = tmp;
      tmp = null;
      if(primeiro == ultimo)//Teste para mover ultimo, caso lista esteja vazia
         ultimo = primeiro.prox;
   }

   //Metodo para inserir no final da lista
   public void inserirFim(String arq)throws Exception{
      ultimo.prox = new Celula(arq);
		ultimo = ultimo.prox;
   }

   //Metodo para inserir em qualquer posicao valida da lista
   public void inserir(int p, String arq)throws Exception{
      int t = tamanho();
      if(p < 0 || p > tamanho())
         throw new Exception ("ERRO!");
      if(p == t){
         inserirFim(arq);
      }else{
         if(p == 0){
            inserirInicio(arq);
         }else{
            Celula i = primeiro;
            for(int j = 0; j < p; j++){
               i = i.prox;
            }
            Celula tmp = new Celula(arq);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
         }
      }
   }

   /*Metodo para remover personagem do fim da lista*/
   public Personagem removerFim()throws Exception{
      if(primeiro == ultimo)//Verificar se ha elementos para remover
         throw new Exception("ERRO!");

      Personagem removido;
      Celula i;
      for( i = primeiro.prox; i.prox != ultimo; i = i.prox);//Procurar penultimo elemento

      removido = ultimo.elemento;
      ultimo = i;//ultimo = penultimo
      i.prox = ultimo.prox = null;

      return removido;      
   }

   /*Metodo para remover personagem do fim da lista*/
   public Personagem removerInicio()throws Exception{
      if(primeiro == ultimo)//Verificar se ha elementos para remover
         throw new Exception("ERRO!");
      
      Personagem removido;
      Celula tmp = primeiro;
      primeiro = primeiro.prox;
      removido = primeiro.elemento;
      tmp.prox = null;//Desconectar primeiro
      tmp = null;
      return removido;
   }

   /*Metodo para remover personagem de qualquer posicao valida*/
   public Personagem remover(int p)throws Exception{
      int t = tamanho();
      if(p < 0 || p > tamanho() || primeiro == ultimo)
         throw new Exception ("ERRO!");
      
      Personagem removido;
      if(p == t){
         removido = removerFim();
      }else{
         if(p == 0){
            removido = removerInicio();
         }else{
            Celula i = primeiro;
            for(int j = 0; j < p; j++, i = i.prox);

            Celula tmp = i.prox;
            removido = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = null;
         }
      }
      return removido;
   }

   //Metodo para calcular tamanho da lista
   public int tamanho(){
      int retorno = 0;
      for(Celula i = primeiro; i != ultimo; i = i.prox, retorno++);
      return retorno;
   }

   public void printLista(){
      int contador = 0;
      for(Celula i = primeiro.prox; i != null; i = i.prox){
         MyIO.print("["+contador+++"] ");
         i.elemento.printDados();
      }
   }
}
