/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Lista Flexivel Quicksort
*/


class Lista{
   private Celula primeiro;
   private Celula ultimo;
   private int comp;
   private int mv;

   Lista(){
      primeiro = new Celula();
		ultimo = primeiro;
      comp = 0;
      mv = 0;
   }

   //Metodo para inserir no inicio da Lista
   public void inserirInicio(String arq)throws Exception{
      Celula tmp =  new Celula(arq);
      tmp.prox = primeiro.prox;
      primeiro.prox = tmp;
      tmp.ant = primeiro;
      
      if(primeiro == ultimo)//Teste para mover ultimo, caso lista esteja vazia
         ultimo = primeiro.prox;
      else//se fila nao estiver vazia conectar prox da celula nova
         tmp.prox.ant = primeiro.prox;
      tmp = null;
   }

   //Metodo para inserir no final da lista
   public void inserirFim(String arq)throws Exception{
      ultimo.prox = new Celula(arq);
		ultimo.prox.ant = ultimo;
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
            tmp.ant = i;
            tmp.prox.ant = tmp.ant.prox = tmp;
            tmp = null;
            i = null;
         }
      }
   }

   /*Metodo para remover personagem do fim da lista*/
   public Personagem removerFim()throws Exception{
      if(primeiro == ultimo)//Verificar se ha elementos para remover
         throw new Exception("ERRO!");

      Personagem removido;

      removido = ultimo.elemento;
      ultimo = ultimo.ant;
      ultimo.prox.ant = ultimo.prox = null;

      return removido;      
   }

   /*Metodo para remover personagem do fim da lista*/
   public Personagem removerInicio()throws Exception{
      if(primeiro == ultimo)//Verificar se ha elementos para remover
         throw new Exception("ERRO!");
      
      Personagem removido;
      primeiro = primeiro.prox;
      removido = primeiro.elemento;
      primeiro.ant.prox = null;//Desconectar primeiro
      primeiro.ant = null;
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
            Celula i = primeiro.prox;
            for(int j = 0; j < p; j++, i = i.prox);

            i.prox.ant = i.ant;
            i.ant.prox = i.prox;
            removido = i.elemento;
            i.prox = i.ant = null;
            i = null;
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

   /*Metodo para encontrar pivo para metodo quicksort */
   private Personagem acharPivo(Celula esq, Celula dir){
      for( ; esq != dir && esq.prox != dir ; esq = esq.prox, dir = dir.ant);
      return esq.elemento;
   }

   /*Metodo para verificar se posicao de um elemento eh menor ou igual a de outro,
    retorna true se o elemento esq for encontrado antes de dir*/
   private boolean isMenorIgual(Celula esq, Celula dir){
      boolean resp = false;

      while(!resp && dir != this.primeiro){//repeticao ate elemento ser encontrado ou chegar a extremidade da lista
         resp = (dir == esq);
         dir = dir.ant;//mover dir  
      }
      return resp;
   }

   /*Metodo para verificar se posicao de um elemento eh menor a de outro,
   retorna true se o elemento esq for encontrado antes de dir*/
   private boolean isMenor(Celula esq, Celula dir){
      boolean resp = false;
      dir = dir.ant;//mover dir 
      while(!resp && dir != this.primeiro && dir != null){//repeticao ate elemento ser encontrado ou chegar a extremidade da lista
         resp = (dir == esq);
         dir = dir.ant;//mover dir  
      }
      return resp;
   }

   private void swap(Celula i, Celula j){
      Personagem aux = i.elemento.Clone();
      i.elemento = j.elemento.Clone();
      j.elemento = aux;
   }
   
   /*Ordenarcao da lista por meio de quicksort*/
   private void quicksort(Celula esq, Celula dir){
      Celula i = esq;
      Celula j = dir;
      Personagem pivo = acharPivo( i, j);

      while(isMenorIgual( i, j)){
         while((i.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) < 0) ||
               i.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) == 0 &&
               i.elemento.getNome().compareTo(pivo.getNome()) < 0){
            i = i.prox;
            comp++;
         }

         while((j.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) > 0) ||
               j.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) == 0 &&
               j.elemento.getNome().compareTo(pivo.getNome()) > 0){
            j = j.ant;
            comp++;
         }
         if(isMenorIgual( i, j)){
            mv+=3;
            swap(i, j);
            i = i.prox;
            j = j.ant;
         }
      }

      if(isMenor(esq, j))
         quicksort(esq, j);

      if(isMenor(i, dir))
         quicksort(i,dir);
   }

   public void quicksort(){
      quicksort(primeiro.prox, ultimo);
   }

   public void insercao(){
      for(Celula i = primeiro.prox.prox; i != null; i = i.prox){
         Celula j = i.ant;
         Personagem tmp = i.elemento;
         while(j != primeiro && j.elemento.getCorDoCabelo().compareTo(tmp.getCorDoCabelo()) > 0 ){
            j.prox.elemento = j.elemento.Clone();
            j = j.ant;
         }
         j.prox.elemento = tmp.Clone();
      }
   }

   public void selecao(){
      for(Celula i = primeiro.prox; i != ultimo; i = i.prox){
         Celula menor = i;
         for(Celula j = i.prox; j != null; j = j.prox){
            if(menor.elemento.getCorDoCabelo().compareTo(j.elemento.getCorDoCabelo()) > 0 ){
               menor = j;
            }
         }
         swap(menor, i);
      }
   }

   public void printLista(){
      for(Celula i = primeiro.prox; i != null; i = i.prox){
         i.elemento.printDados();
      }
   }

   public int getComp(){
      return comp;
   }

   public int getMv(){
      return mv;
   }
}
