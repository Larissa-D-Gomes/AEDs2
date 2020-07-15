/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Tabela Hash com Reserva
*/

class Hash{
   private Personagem tabela[];
   private int tam, tamRes, tamTab, reserva, numComp;

   /*Contrutor vazio, encapsula a chamada com parametros 
    * tamTab = 21 4 tamRes = 9 */
   public Hash()throws Exception{
      this(21, 9);
   }

   /*Construtor Hash, parametro tamanho da tamabela e tamanho 
    * da reserva */
   public Hash(int tamTab, int tamRes)throws Exception{
      if(tamTab <= 0 || tamRes <= 0)//verificacao se valores sao validos
         throw new Exception("ERRO!");

      this.tamTab = tamTab;
      this.tamRes = tamRes;
      this.tam = tamTab + tamRes;//Tamanho total
      tabela = new Personagem [this.tam];
      this.reserva = 0;
      this.numComp = 0;
   }

   /*Metodo para inserir persongem no tabela */
   public boolean inserir(Personagem p){
    //  MyIO.println(p.getAltura() % tamTab);
      boolean resp;
      if(p == null){
         resp = false;
      }else if(tabela[p.getAltura() % tamTab] == null){
        // MyIO.println(p.getAltura() % tamTab]);
         tabela[p.getAltura() % tamTab] = p.Clone();
         resp = true;
      }else if(reserva < tamRes){
         tabela[tamTab + reserva++] = p.Clone();
         resp = true;
      }else{
         resp = false;
      }
      return resp;
   }

   /*Metodo para pesquisar personagem pelo atributo nome
    */
   public boolean pesquisar(String nome){
      boolean resp = false;
      for(int i = 0; i < tam && !resp; i++){
         numComp++;
         if(tabela[i] != null)
            resp = (tabela[i].getNome().equals(nome));
      }
      return resp; 
   }

   /*Metodo para pesquisar personagem*/
   public boolean pesquisar(Personagem p){
      boolean resp = false;
      int posicao = p.getAltura() % tamTab;

      if(tabela[posicao] != null){
         if(tabela[posicao].getNome().equals(p.getNome())){
            resp = true;
         }else{
            for(int i = 0; i < reserva && !resp; i++){//procurar elemento seuqeuncialmente na reserva
               if(tabela[i+tamTab] != null)
                  resp = (tabela[i+tamTab].getNome().equals(p.getNome()));
            }
         }
      }
      return resp;
   }

   /*Metodo para remover personagem conforme o nome */
   public boolean remover(String nome){
      boolean resp = false;
      for(int i = 0; i < tam && !resp; i++){
         if(tabela[i] != null && (tabela[i].getNome().equals(nome))){
            resp = true;
            tabela[i] = null;
            if(i >= tamTab){
               for(int j = i; j < reserva+tamTab; j++){//Shift de elementos
                  tabela[i] =  tabela[i+1];
               }
            }else{
               for(int j = 0; j < reserva; j++){//procurar elemento seuqeuncialmente na reserva
                  if(tabela[j+tamTab].getAltura()%tamTab == i){
                     tabela[i] = tabela[j+tamTab];
                     for(int k = j; k < reserva+tamTab; k++){//Shift de elementos
                        tabela[k] =  tabela[k+1];
                     }
                     j = reserva--;
                  }
               }
            }
         }
      }
      return resp; 
   }

   public int getNumComp(){
      return numComp;
   }
}