/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha
Questao:BALANCO PARENTESES JAVA
*/
public class BalancoParenteses
{
   /*Funcao para remover caracteres que nao seja parenteses de uma string
    *Parametro:String expressao e tamanho da String
    *Retorno:String contendo apenas parenteses*/
   public static String setString(String express, int t)
   {
      String remover = "";
      char c;
      for(int aux = 0; aux < t; aux++)
      {
         c = express.charAt(aux);
         if(c == ')' || c == '(')
           remover+=c; 
      }
      return remover;
   }

   /*Funcao que retorna posicao do primeiro ')' encontrado
    *Parametros:String e tamanho da string
    *Retorno:Posicao do parenteses
    */
   public static int procurarFechamento(String express, int t)
   {
         int posicao = 0;
         while( express.charAt(posicao) != ')' && posicao < t)
         {
            posicao++;
         }
         return posicao;
   }

   /*Funcao que remove parenteses ja analisados
    *Parametros:String e tamanho da string
    *Retorno:Posicao do parenteses
    */
   public static String removerParenteses(String express, int t, int posicao)
   {
      String retorno= "";
      for(int aux = 0 ; aux < posicao - 1; aux++)//Copiar caracteres antes da posiciao delimitada
      {
            retorno+= express.charAt(aux);
      }
     for(int aux = posicao+1 ; aux < t; aux++)//Copiar caracteres depois da posiciao delimitada
      {
            retorno+= express.charAt(aux);
      }
      return retorno;
   }

   public static boolean verificadorParenteses(String express)
   {
      boolean resposta = true;
      express = setString(express, express.length());//Remover caracteres diferentes de parenteses
      int t = express.length();
      int pFechamento = 0;
      resposta = (t % 2 == 0 && express.charAt(0) != ')' && express.charAt(t-1) != '(' );//Verficar se existem 
      //pares de parenteses e se a expressao nao eh aberta com ')' ou fechada '('
      if(resposta)
      {
            while(resposta && t > 0 )
            {
               pFechamento = procurarFechamento(express, t);
               resposta = ( express.charAt(pFechamento-1) == '(' );//Verificar se caracter antecessor de ')' eh '('
               express = removerParenteses(express, t, pFechamento);
               t = express.length();
            }
      }
      return resposta;
   }
   public static void main(String[] args)
   {
      String leitura = MyIO.readLine();
      while(!leitura.equals("FIM"))
      {
         if(verificadorParenteses(leitura))
            MyIO.println("correto");
         else
            MyIO.println("incorreto");
         leitura = MyIO.readLine();
      }
   }
}