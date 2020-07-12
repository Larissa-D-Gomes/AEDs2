/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:Alteracao Aleatoria
*/
import java.util.Random;
public class AlteracaoAleatoria
{
	/* Metodo que recebe uma string
	 * e retorna modificada, confor-
	 * me os caracteres sorteados, 
	 * aleatoriamente para substituicao
	 * */
   public static String AlterarStr(String linha, Random gerador)
   {
      String retorno = "";
      char aleatorio1 = (char)(97+(Math.abs(gerador.nextInt())%26));//variavel para armazenar o caracter a ser substituido	
      char aleatorio2 = (char)(97+(Math.abs(gerador.nextInt())%26));//variavel para armazenar o caracter que ira substituir  +97 para ter o valor minimo sorteado 97 e %26 para o valor maximo ser 97+26	        
      for(int aux = 0; aux < linha.length(); aux++)//Repeticao para percorrer toda string recebida
      {
         if(linha.charAt(aux) != aleatorio1)//teste para verificar se o caracter precisa der substituido
            retorno+=linha.charAt(aux);//caso sim, sera substituido pela segunda letra sorteada
         else
            retorno+=aleatorio2;//caso nao, manter os caracteres da string
      }
      return retorno;
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
      String leitura = MyIO.readLine();
      Random gerador = new Random();
      gerador.setSeed(4);//seed gerado no main para evitar repeticao e gerar oss mesmo caracteres
      while(!VerificadorFim(leitura))
      {
         MyIO.println(AlterarStr(leitura,gerador));
         leitura = MyIO.readLine();
      }
   }
   
}

