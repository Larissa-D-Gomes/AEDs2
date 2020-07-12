   /*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:Ciframento Cesar Java Recursivo
*/

public class CiframentoCesarRecursivo
{
	/*
	 * Metodo para receber um string e modifica-la, conforme o 
	 * ciframento ceasar, retornando uma outra string
    *Parametros string e contador aux, que e igual ao tamanho da string-1
	 */

  public static String CifraCesar(String palavra,int aux)
  {
      String crip = "";//string vazia para adicionar posteriormente os caracteres codificados
      if(aux >= 0)//Teste para terminar a recursividade quando modificar toda string
      {
         crip+=CifraCesar(palavra,aux-1)+(char)((int)palavra.charAt(aux)+3);//concatenar a string com o inicio modificado durante a recursividade+caracter modificado
         // adiconar +3 aos caracteres, para que andem 3 casas conforme a tabela ascii
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
	        MyIO.println(CifraCesar(leitura,leitura.length()-1));
	        leitura = MyIO.readLine();
      }
   }
}
