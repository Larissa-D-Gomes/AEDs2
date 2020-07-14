/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:PALINDROMOS JAVA
*/
public class PalindromosJava
{
	/*
	 *Classe que retorna valor logico, referente 
	 *se a string lida eh ou nao palindromo.
	 *Recebe como parametro a string a ser analisada.
	 */
   public static boolean VerificadorPalindromo(String Linha)
   {
      boolean resp = true;
      int contador1 = 0;//Variaveis para marcar o caracter lido
      int contador2 = Linha.length()-1;
      while(contador1 <= contador2 && resp)//Repeticao com teste fisico e logico
      {
         resp = (Linha.charAt(contador1) == Linha.charAt(contador2));//comparador de caracteres
         contador1++;
         contador2--;
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
         if(VerificadorPalindromo(leitura))
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
