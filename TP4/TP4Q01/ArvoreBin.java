/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe Personagens Star Wars Java Arvore Binaria
*/

class ArvoreBin{
   private No raiz;
   private int numComp;

   public ArvoreBin(){
      this.raiz = null;
      this.numComp = 0;
   }

   /*Metodo para inserir personagem na arvore */
   public void inserir(Personagem p)throws Exception{
      raiz = inserir(raiz, p);
   }

   public No inserir(No i, Personagem p)throws Exception{
      if(i == null)
         i = new No(p);//Criacao de novo elemento em no vazio
      else{
         if(p.getNome().compareTo(i.elemento.getNome()) < 0 ){
            numComp++;
            i.esq = inserir(i.esq, p);//Descer para esquerda caso elemento for menor que atual
         }else{
            if(p.getNome().compareTo(i.elemento.getNome()) > 0 ){
               numComp++;
               i.dir = inserir(i.dir, p);//Descer para direita caso elemento for maior que atual
            }
         }
      }
      return i;
   }

   /*Metodo para remover elemento da arvore, pesquisa conforme o nome */
   public void remover(String nome)throws Exception{
      raiz = remover(raiz, nome);
   }

   public No remover(No i, String nome)throws Exception{
      if(i == null)
         throw new Exception("ERRO!");
      else{
         if(nome.compareTo(i.elemento.getNome()) < 0){
            i.esq = remover(i.esq, nome);//Descer para esquerda caso elemento for menor que atual
            numComp++;
         }else{
            if(nome.compareTo(i.elemento.getNome()) > 0){
               i.dir = remover(i.dir, nome);//Descer para direita caso elemento for maior que atual
               numComp++;
            }else{
               if(i.dir == null){
                  i = i.esq;//Subtituir pelo filho vazio
               }else{
                  if(i.esq == null){
                     i = i.dir;
                  }else{
                     i.esq = anterior(i, i.esq);//Se nao houver trocar pelo maior elemento da esqueda
                  }
               }
            }
         }
      }
      return i;
   }

   //Metodo para trocar elemento removido pelo maior
   public No anterior(No i, No j){
      if(j.dir != null){
         j.dir = anterior(i, j.dir);//Descer ate enecontrar maior elemento
      }else{
         i.elemento = j.elemento;//i = maior elemento da subarvore
         j = j.esq;//mover subarvere de j
      }
      return j; 
   }

   public boolean pesquisar(String nome){
      MyIO.print("raiz ");
      return pesquisar(raiz, nome);
   }

   /*Metodo para pesquisar elementos */
   public boolean pesquisar(No i, String nome){
      boolean resp;
      if(i == null)
         resp = false;//Caso i = null, entao o elemento nao existe
      else{
         if(nome.compareTo(i.elemento.getNome()) < 0 ){
            numComp++;
            MyIO.print("esq ");
            resp = pesquisar(i.esq, nome);//descer para esquerda se for menor
         }else{
            if(nome.compareTo(i.elemento.getNome()) > 0 ){
               numComp++;
               MyIO.print("dir ");
               resp = pesquisar(i.dir, nome);//descer para direita se for menor
            }else{
               resp = true;//Se nao for null, maior ou menor, entao o elemento foi encontrado
            }
         }
      }
      return resp;
   }

   public void mostraCentral(){
      mostraCentral(raiz);
   }

   public void mostraCentral(No i){
      if(i != null){
         mostraCentral(i.esq);
         i.elemento.printDados();
         mostraCentral(i.dir);
      }
   }

   public void mostrarPre() {
		mostrarPre(raiz);
	}


	private void mostrarPre(No i) {
		if (i != null) {
			i.elemento.printDados(); 
			mostrarPre(i.esq); 
			mostrarPre(i.dir); 
		}
	}

   public int getNumComp(){
      return numComp;
   }
}

