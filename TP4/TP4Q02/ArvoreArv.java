/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe ArvoreArv
*/

class ArvoreArv{
   private NoInt raiz;
   private int numComp;

   public ArvoreArv(){
      this.raiz = null;
      this.numComp = 0;
   }

   /*Metodo para inserir int na arvore */
   public void inserir(int p)throws Exception{
      raiz = inserir(raiz, p);
   }

   public NoInt inserir(NoInt i, int p)throws Exception{
      if(i == null)
         i = new NoInt(p);//Criacao de novo elemento em no vazio
      else{
         if(p < i.elemento ){
            numComp++;
            i.esq = inserir(i.esq, p);//Descer para esquerda caso elemento for menor que atual
         }else{
            if(p > i.elemento ){
               numComp++;
               i.dir = inserir(i.dir, p);//Descer para direita caso elemento for maior que atual
            }
         }
      }
      return i;
   }

   /*Metodo para fazer insercao em arvore do espaco */
   public void inserir(Personagem p)throws Exception{
      inserir(raiz, p.getNome(), (p.getAltura()%15));
   } 

   public void inserir(NoInt i, String nome, int num )throws Exception{
      if(num < i.elemento ){
         numComp++;
         inserir(i.esq, nome, num);//descer para esquerda se for menor
      }else{
         if(num > i.elemento ){
            numComp++;
            inserir(i.dir, nome, num);//descer para direita se for menor
         }else{
            i.inserir(nome);
         }
      }
   }


   /*Metodo para remover elemento da arvore, pesquisa conforme o int */
   public void remover(int p)throws Exception{
      raiz = remover(raiz, p);
   }

   public NoInt remover(NoInt i, int p)throws Exception{
      if(i == null)
         throw new Exception("ERRO!");
      else{
         if(p < i.elemento){
            i.esq = remover(i.esq, p);//Descer para esquerda caso elemento for menor que atual
            numComp++;
         }else{
            if(p > i.elemento){
               i.dir = remover(i.dir, p);//Descer para direita caso elemento for maior que atual
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
   public NoInt anterior(NoInt i, NoInt j){
      if(j.dir != null){
         j.dir = anterior(i, j.dir);//Descer ate enecontrar maior elemento
      }else{
         i.elemento = j.elemento;//i = maior elemento da subarvore
         j = j.esq;//mover subarvere de j
      }
      return j; 
   }

   public boolean pesquisar(int p){
      MyIO.print("raiz ");
      return pesquisar(raiz, p);
   }

   /*Metodo para pesquisar elementos */
   public boolean pesquisar(NoInt i, int p){
      boolean resp;
      if(i == null)
         resp = false;//Caso i = null, entao o elemento nao existe
      else{
         if(p < i.elemento ){
            numComp++;
            MyIO.print("esq ");
            resp = pesquisar(i.esq, p);//descer para esquerda se for menor
         }else{
            if(p > i.elemento ){
               numComp++;
               MyIO.print("dir ");
               resp = pesquisar(i.dir, p);//descer para direita se for menor
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

   public void mostraCentral(NoInt i){
      if(i != null){
         mostraCentral(i.esq);
         MyIO.println(i.elemento);
         mostraCentral(i.dir);
      }
   }

   public boolean pesqPre(String nome) {
      MyIO.print("raiz ");
		return pesqPre(raiz, nome);
	}


	private boolean pesqPre(NoInt i, String nome) {
      boolean resp = false;
		if (i != null) {
			resp = i.pesqPre(nome);
         if(!resp){
            numComp++;
            MyIO.print("esq ");
			   resp = pesqPre(i.esq, nome); 
         }
         if(!resp){
            numComp++;
            MyIO.print("dir ");
			   resp = pesqPre(i.dir, nome); 
         }
      }
      return resp;
	}

   public int getNumComp(NoInt i){
      int x = 0;
      if(i != null){
         x += getNumComp(i.esq);
         x += i.getNumComp();
         x += getNumComp(i.esq);
      }
      return x;
   }

   public int getNumComp(){
      return getNumComp(raiz)+numComp;
   }
}
