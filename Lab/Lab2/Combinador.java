/*Nome: Larissa Domingues Gomes
  Turno: Manha
  Numero de Matricula: 650525
  Professor:Felipe Cunha
  Questao:COMBINADOS
*/

public class Combinador
{
  /*Fucao para retornar as palavras de maneira combinada*/
   public static String TrocarLetras(String palavra, String palavra2)
   {
      String retorno = "";
      int contador = 0;
      while(contador < palavra.length() && contador < palavra2.length())//repeticao para adicionar a string de retorno o caracter de cada string
      {
         retorno+=palavra.charAt(contador);
         retorno+=palavra2.charAt(contador);
         contador++;
      }
      while(contador < palavra.length())//repeticao para caso a string 2 seja menor que a 1, completar a string de retorno com a 1
      {
         retorno+=palavra.charAt(contador);
         contador++;
      }
      while(contador < palavra2.length())//repeticao para caso a string 1 seja menor que a 2, completar a string de retorno com a 2
      {
         retorno+=palavra2.charAt(contador);
         contador++;
      }
      
      return retorno;
   }
	   /*
	    * Funcao para verificar se a string recebida = FIM
	    */
   public static boolean VerificadorFim(String Linha)
   {
      boolean resp = (Linha.length()==3);
      if(resp)
      {
         resp = (Linha.charAt(0) == 'F');
      }
      if(resp)
      {
         resp= (Linha.charAt(1) == 'I');
      }
      if(resp)
      {
         resp = (Linha.charAt(2) == 'M');
      }
      return resp;
   }
   public static void main(String[] args)
   {
      String leitura = MyIO.readString();
      while(!VerificadorFim(leitura))
      {
         String leitura2 = MyIO.readString();
         MyIO.println(TrocarLetras(leitura, leitura2));
         leitura = MyIO.readString();
      }
   }

}
