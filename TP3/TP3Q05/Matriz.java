/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Matriz flexivel em java
*/

class Matriz{
   public static void main(String[] args)throws Exception{
      int quantidade = MyIO.readInt();

      for(int x = 0; x < quantidade; x++){
         int linhas  = MyIO.readInt();
         int colunas = MyIO.readInt();
         Matrix m1 = new Matrix(linhas, colunas);
         m1.setElementosLeitura();//Set elementos m1
         m1.showDiagonalPrincipal();
         m1.showDiagonalSecundaria();

         linhas  = MyIO.readInt();//Ler linhas de m2
         colunas = MyIO.readInt();//Ler colunas de m2
         Matrix m2 = new Matrix(linhas, colunas);
         m2.setElementosLeitura();//Set elementos m2
         m1.soma(m2).mostrar();
         m1.multiplicacao(m2).mostrar();
      }
     
   }
}