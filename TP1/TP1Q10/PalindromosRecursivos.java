/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:PALINDROMOS JAVA
*/
public class PalindromosRecursivos
{
	/*
	 *Metdodo recursivo que retorna valor logico, referente 
	 *se a string lida eh ou nao palindromo.
	 *Recebe como parametro a string a ser analisada e um contador para posicionamento de leitura.
	 */
   public static boolean VerificadorPalindromo(String Linha, int contador1)
   {
      boolean resp = true;
      if(contador1 < Linha.length()/2)//Controle da recursividade com teste fisico e logico
      {
         resp = (Linha.charAt(contador1) == Linha.charAt(Linha.length()-1-contador1));
         //comparador de caracteres
         if(resp)//Teste logico para nao chamar novamente a funcao, caso seja constatado que nao eh palindormo
         {
            contador1++;
            resp = (resp && VerificadorPalindromo(Linha,contador1));//caso exista algum retorno negativo, todas respostas retornarao negativas pelo teste and
         }
      }
      return resp;  
   }  
   /*
	  Funcao para verificar se a string recebida = FIM
	 */

   public static boolean VerificadorFim(String Linha)
   {
      boolean resp = (Linha.length()==3);
      if(resp)
      {
         resp = (Linha.charAt(0) == 'F');
         if(resp)
         {
            resp= (Linha.charAt(1) == 'I');
         }
         if(resp)
         {
            resp = (Linha.charAt(2) == 'M');
         }
      }
      return resp; 
   }
   public static void main(String[] args)
   {
      String leitura = MyIO.readLine();
      while(!VerificadorFim(leitura))//Repeticao que compara strings lidas ate algum ser FIM
      {
         if(VerificadorPalindromo(leitura,0))
         {
            MyIO.println("SIM");
         }
         else
         {
            MyIO.println("NAO");
         }
         leitura = MyIO.readLine();
      }
   }
}