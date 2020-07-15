/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe No Arvore Trie
*/

class No{
   public char elemento;
   public boolean isFim;
   public No array[];
   public int size = 255;//Numero de caracteres ASCII

   /*Construtor vazio*/
   public No(){
      this(' ');
   }

   /*Construtor classe no, recebe o caracter do no como parametro */
   public No(char c){
      this.elemento = c;
      array = new No[size];

      isFim = false;
   }

   public int hash (char c){
      return (int)c;
   }
}
