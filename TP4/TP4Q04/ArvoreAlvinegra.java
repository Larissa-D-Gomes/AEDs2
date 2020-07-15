/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Alvinegra
*/

class ArvoreAlvinegra{
   public No raiz;
   private int numComp;

   /*Metodo construtor arvore alvinegra*/
   public ArvoreAlvinegra(){
      raiz = null;
      numComp = 0;
   }

   /*Metodo para pesquisar elemento em arvore alvinegra, pelo atributo nome*/
   public boolean pesquisar(String nome){
      MyIO.print("raiz ");
      return pesquisar(raiz, nome);
   }

   /*Metodo recursivo para pesquisar elemento na arvore conforme atributo nome*/
   public boolean pesquisar(No i, String nome){
      boolean resp;

      //Se chegar a no vazio, o elemento nao existe
      if(i == null){
         resp = false;
      }else{ 
         numComp++;
         if(i.elemento.getNome().compareTo(nome) == 0){
            resp = true;//elemento encontrado
         }else{ 
            numComp++;
            if(i.elemento.getNome().compareTo(nome) > 0){
               MyIO.print("esq ");
               resp = pesquisar(i.esq, nome);//Se elemento procurador for menor que atual,
                                    //procurar na subarvore da esquerda
            }else{
               MyIO.print("dir ");
               resp = pesquisar(i.dir, nome);//Se elemento procurador for maior que atual,
                                    //procurar na subarvore da direita 
            }
         }
      }
      return resp;
   }

	public void mostrarCentral() {
		mostrarCentral(raiz);
	}

	private void mostrarCentral(No i) {
		if (i != null) {
			mostrarCentral(i.esq); // Elementos da esquerda.
         System.out.println(i.elemento.getNome() + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
			mostrarCentral(i.dir); // Elementos da direita.
		}
	}

   /*Metodo para inserir personagem na arvore*/
   public void inserir(Personagem p)throws Exception{
      if(p == null)
         throw new Exception("ERRO!");
      
      String n = p.getNome();

      //Inserir se raiz estiver vazia
      if(raiz == null){
         raiz = new No(p, false);

         }else{ 
            if(raiz.esq == null && raiz.dir == null){//Se arvore ja possuir um elemento
               numComp++;
               if(n.compareTo(raiz.elemento.getNome()) > 0){
                  raiz.dir = new No(p, true);
               }else{ 
                  numComp++;
                  if(n.compareTo(raiz.elemento.getNome()) < 0){
                     raiz.esq = new No(p, true);
                  }else{
                     System.out.println("1: ELEMENTO NAO INSERIDO");
                  }
               }
            }
            else if(raiz.esq == null){//Se arvore ja tiver dois elementos, um na direita
               numComp++;
               if(n.compareTo(raiz.elemento.getNome()) < 0){//Se elemento for menor que raiz, basta inserir
                  raiz.esq = new No(p);

               }else{
                  numComp++;
                  if(n.compareTo(raiz.dir.elemento.getNome()) < 0){

                     raiz.esq = new No(raiz.elemento);//Cololar raiz como menor elemento da arvore
                     raiz.elemento = p;//Colocar novo elemento como central
            
                  }else{
                     raiz.esq = new No(raiz.elemento);//Cololar raiz como menor elemento da arvore
                     raiz.elemento = raiz.dir.elemento;//Colocar elemento na dir atual como central 
                     raiz.dir.elemento = p;//Colocar novo elemento como maior da arvore
                  }
               }     
            raiz.dir.cor = raiz.esq.cor = false;
         
         }else if(raiz.dir == null){//Se arvore ja tiver dois elementos, um na esquerda
            numComp++;
            if(n.compareTo(raiz.elemento.getNome()) > 0){
               
               raiz.dir = new No(p);//Se elemento for maior que raiz, basta inserir
            }else{
               numComp++;
               if(n.compareTo(raiz.esq.elemento.getNome()) > 0){
                  raiz.dir = new No(raiz.elemento);
                  raiz.elemento = p;
               }else{
                  raiz.dir = new No(raiz.elemento);
                  raiz.elemento = raiz.esq.elemento;
                  raiz.esq.elemento = p;
               }
               raiz.esq.cor = raiz.dir.cor = false;
         
            }
         }else{
               inserir(p, null, null, null, raiz);
         }
      }
      raiz.cor = false;
   }

   /*Metodo para balancear AN*/
   private void balancear( No bisavo, No avo, No pai, No i){

      if(pai.cor){
         numComp++;
         if(pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0){
            numComp++;
            if(i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0){//Rotacao esq
               avo = rotacaoEsq(avo);
            } else {//Rotacao dir-esq
               avo = rotacaoDirEsq(avo);
            }
         }else{
            numComp++;
            if(i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0){//Rotacao dir
               avo = rotacaoDir(avo);
            } else {
               avo = rotacaoEsqDir(avo);//rotacao esq-dir
            }
         }
         if(bisavo == null)
            raiz = avo;
         else{
            numComp++;
            if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0)
               bisavo.esq = avo;
            else
               bisavo.dir = avo;
         }  

         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;
      }
   }    

   /*Metodo recursivo para inseirir elementos*/
   private void inserir(Personagem p, No bisavo, No avo, No pai, No i)throws Exception{
      String n = p.getNome();
      if(i == null){//Se no i for null, inserir novo elemento
         numComp++;
         if(n.compareTo(pai.elemento.getNome()) < 0){
            i = pai.esq = new No(p, true);
         } else{
            numComp++; 
            if (n.compareTo(pai.elemento.getNome()) > 0){
               i = pai.dir = new No(p, true);  
            }
            else{
               MyIO.println("Elemento nao inserido.");
            }
         }
         if(pai.cor)
            balancear(bisavo, avo, pai, i);
      }else{ 
         if(i.esq != null && i.dir != null && i.esq.cor && i.dir.cor){
            //balancear no tipo 4 caso dor encontrado
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
             
            if(i == raiz)
               i.cor = false;
            else if(pai.cor)
               balancear(bisavo, avo, pai, i);
         }
           
         numComp++;
         if(n.compareTo(i.elemento.getNome()) < 0){
            inserir(p, avo, pai, i, i.esq);
         }else{ 
            numComp++;
            if(n.compareTo(i.elemento.getNome()) > 0){
               inserir(p, avo, pai, i, i.dir);
            }else{
               MyIO.println("Elemento nao inserido");
            }
         }
      }
   }

   private No rotacaoDir(No no) {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }

   private No rotacaoEsq(No no) {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }

   private No rotacaoDirEsq(No no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private No rotacaoEsqDir(No no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }

   public int getNumComp(){
      return numComp;
   }
}
