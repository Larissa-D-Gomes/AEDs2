   /*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:Ciframento Cesar Java
*/

public class CiframentoCesar
{
	/*
	 * Funcao para receber um string e modifica-la, conforme o 
	 * ciframento ceasar, retornando uma outra string
	 */

  public static String CifraCesar(String palavra)
  {
      String crip = "";//string vazia para adicionar posteriormente os caracteres codificados
      for(int aux = 0; aux < palavra.length(); aux++)
      {
         crip+=(char)((int)palavra.charAt(aux)+3);// adiconar +3 aos caracteres, para que andem 3 casas conforme a tabela ascii
      }
     return crip;
  }
   /*
   * 	  Funcao para verificar se a string recebida = FIM
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
      while(!VerificadorFim(leitura))
      {
	        MyIO.println(CifraCesar(leitura));
	        leitura = MyIO.readLine();
      }
   }
}
