/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Tabela Hash com Rehash
*/


class Hash{
   private Personagem tabela[];
   private int tamTab, numComp;

   /*Contrutor vazio, encapsula a chamada com parametros 
    * tamTab = 25*/
   public Hash()throws Exception{
      this(25);
   }

   public Hash(int x)throws Exception{
      if(x < 0)
         throw new Exception("ERRO!");
      tamTab = x;
      tabela = new Personagem[tamTab];
      numComp = 0;
   }

   /*Metodo para calcular rehash*/
   private int rehash(int x){
      return (x+1)%tamTab;
   }

   /*Metodo para inserir personagem em tabela hash, retorna um boolean
    * para sinalizar se elemento foi inserido ou nao*/
   public boolean inserir(Personagem p){
      boolean resp = false;

      if(p != null){
         int h = p.getAltura() % tamTab;
         //MyIO.print(h+" "+p.getNome()+" ");
         if(tabela[h] == null){
            tabela[h] = p;
            resp = true;
         }
         else{
            h = rehash(h);
            if(tabela[h] == null){
               tabela[h] = p;
               resp = true;
            }
         }
      }
      return resp;
   }

   /*Metodo para pesquisar personagem por nome*/
   public boolean pesquisar(String nome){
      boolean resp = false;
      for(int i = 0; i < tamTab && !resp; i++){
         if(tabela[i] != null){
            numComp++;
            resp = (nome.equals(tabela[i].getNome()));
         }
      }
      return resp;
   }

   public int getNumComp(){
      return numComp;
   }

   void mostrar(){
      for(int i = 0; i < tamTab; i++){
         if(tabela[i] != null)
            System.out.println("["+i+"] "+tabela[i].getNome()+" "+tabela[i].getAltura()%tamTab);
      }
   }

   /*Metodo para remover personagem, recebe como parametro o nome */
   public Personagem remover(String nome){
      Personagem resp = null;
      boolean r = false;
      int i = 0;
      
      for(i = 0; i < tamTab && !r; i++){
         if(tabela[i] != null)
            r = (nome.equals(tabela[i].getNome()));
      }
      if(r){
         i--;
         resp = tabela[i];
         for( ; i < tamTab && r; i++){
            if(tabela[rehash(i)] != null && tabela[rehash(i)].getAltura() % tamTab == i)
               tabela[i] = tabela[rehash(i)];
            else{
               tabela[i] = null;
               r = false;
            }
         }
         tabela[i] = null;
      }


      return resp;
   }
}