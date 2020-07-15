/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe NoInt
*/

class NoInt{
   public NoInt esq;
   public NoInt dir;
   public int elemento;
   public int numComp;
   public NoString raiz;

   public NoInt(int elemento)throws Exception{
      this.esq = null;
      this.dir = null;
      this.elemento = elemento;
      this.raiz = null;
   }
   
   public NoInt(int elemento, NoInt esq, NoInt dir)throws Exception{
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
      this.raiz = null;
	}

   /*Metodo para inserir nome na arvore */
   public void inserir(String p)throws Exception{
      raiz = inserir(raiz, p);
   }

   public NoString inserir(NoString i, String p)throws Exception{
      if(i == null)
         i = new NoString(p);//Criacao de novo elemento em no vazio
      else{
         if(p.compareTo(i.elemento) < 0 ){
            numComp++;
            i.esq = inserir(i.esq, p);//Descer para esquerda caso elemento for menor que atual
         }else{
            if(p.compareTo(i.elemento) > 0 ){
               numComp++;
               i.dir = inserir(i.dir, p);//Descer para direita caso elemento for maior que atual
            }
         }
      }
      return i;
   }

   public boolean pesqPre(String nome) {
      
   	return pesqPre(raiz, nome);
	}

	private boolean pesqPre(NoString i, String nome) {
      boolean resp = false;
		if (i != null) {
			resp = (i.elemento.compareTo(nome) == 0);
         if(!resp){
            numComp++;
            MyIO.print("ESQ ");
			   resp = pesqPre(i.esq, nome); 
         }
         if(!resp){
            numComp++;
            MyIO.print("DIR ");
			   resp = pesqPre(i.dir, nome); 
         }
      }
      return resp;
	}
   public int getNumComp(){
      return numComp;
   }
}
