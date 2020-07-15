/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Trie
*/

class Trie{
   private No raiz;
   private int numComp;

   /*Contrutor class Trie*/
   public Trie(){
      raiz = new No();
      numComp = 0;
   }

   /*Metodo para inserir String em Trie */
   public void inserir(String p)throws Exception{
      inserir(p, raiz, 0);
   }

   /*Metodo recursivo para inserir String em Trie*/
   private void inserir(String p, No i, int pos)throws Exception{
      numComp++;
      if(i.array[p.charAt(pos)] == null){
         i.array[p.charAt(pos)] = new No(p.charAt(pos));//Inserir novo char em no vazio
         numComp++;
         if(p.length()-1 == pos){//Teste para verificar se eh ultimo caracter da string
            i.array[p.charAt(pos)].isFim = true;//Sinalizar fim da palavra   
         }else{//Se nao for fim, chamar recursiva para inserir mais caracteres
            inserir(p, i.array[p.charAt(pos)], pos+1);
         }
      }else{
         numComp++;
         if(i.array[p.charAt(pos)].isFim == false && p.length()-1 != pos){
            //Se char ja estiver presente, apenas chamar recursiva, caso palavra nao for prefixa de outra
            inserir(p, i.array[p.charAt(pos)], pos+1);
         }else
            throw new Exception("ERRO AO INSERIR");
      }
   }

   /*Metodo para pesquisar string em arvore Trie*/
   public boolean pesquisar(String p)throws Exception{
      return pesquisar(p, raiz, 0);
   }

   /*Metodo recursivo para pesquisar em Trie */
   public boolean pesquisar(String p, No i, int pos)throws Exception{
      boolean resp;
      numComp++;
      if(i.array[p.charAt(pos)] == null){//Se no vazio encontrado no caminho
                                         //Enta palavra nao existe
         resp = false;
      }else{
            numComp++;
            if(p.length()-1 == pos){
               resp = (i.array[p.charAt(pos)].isFim == true);
            }else{
               numComp++;
               if(pos < p.length()-1){
               resp = pesquisar(p, i.array[p.charAt(pos)], pos+1);
               }else
                  throw new Exception("ERRO AO PESQUISAR");
            }
         }   
      return resp;
   }

   /*Metodo para mostrar na tela elementos da Trie */
   public void mostrar(){
      mostrar("", raiz);
   }

   private void mostrar(String p, No i){
      if(i.isFim == true){//Fim da palavra
         MyIO.println(p);
      }else{
         for(int j = 0; j < 255; j++){
            if(i.array[j] != null){//Se caminho existir
               mostrar( p+i.array[j].elemento, i.array[j]);
            }
         }
      }
   }

   /*Metodo para fazer merge de duas arvores na tela elementos da Trie */
   public Trie merge(Trie t2)throws Exception{
      Trie t3 = new Trie();
      t3.merge("", this.raiz);
      t3.merge("", t2.raiz);
      return t3;
   }

   private void merge( String p, No i)throws Exception{
      numComp++;
      if(i.isFim == true){//Fim da palavra
         this.inserir(p);
      }else{
         for(int j = 0; j < 255; j++){
            numComp++;
            if(i.array[j] != null){//Se caminho existir
               merge( p+i.array[j].elemento, i.array[j]);
            }
         }
      }
   }

   public int getNumComp(){
      return numComp;
   }
}

