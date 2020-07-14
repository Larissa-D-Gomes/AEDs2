/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:IS JAVA
*/

public class Is
{ 
   /*
    *Funcao para verificar se sao apenas letras vogais
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsVogal(String palavra)
   {
      boolean resp = true; 
      int contador = 0;//variavel de controle repeticao
      while(contador < palavra.length()  && resp)//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         resp = (('a' == palavra.charAt(contador) || 'A' == palavra.charAt(contador)) ||
            ('e' == palavra.charAt(contador) || 'e' == palavra.charAt(contador))||
            ('i' == palavra.charAt(contador) || 'I' == palavra.charAt(contador))||
            ('o' == palavra.charAt(contador) || 'O' == palavra.charAt(contador))||
            ('u' == palavra.charAt(contador) || 'U' == palavra.charAt(contador)));//resposta = a verificacao de caracter consoante minusculo maiusculo
         contador++;
      }
      return resp;
   }
      /*
    *Funcao para verificar se sao apenas letras consoantes
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsConsoante(String palavra)
   {
      boolean resp = true; 
      int contador = 0;//variavel de controle repeticao
      while(contador < palavra.length()  && resp)//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         resp = (('a' <= palavra.charAt(contador) && 'z' <= palavra.charAt(contador)) ||
                 ('A' <= palavra.charAt(contador) && 'Z' <= palavra.charAt(contador)));//teste para verifica se sao apenas letras
         if(resp)
         {
            resp = (('a' != palavra.charAt(contador) && 'A' != palavra.charAt(contador)) &&
               ('e' != palavra.charAt(contador) && 'e' != palavra.charAt(contador))&&
               ('i' != palavra.charAt(contador) && 'I' != palavra.charAt(contador))&&
               ('o' != palavra.charAt(contador) && 'O' != palavra.charAt(contador))&&
               ('u' != palavra.charAt(contador) && 'U' != palavra.charAt(contador)));// verificacao se a letra != vogal
         } 
         contador++;
      }
      return resp;
   }
    /*
    *Funcao para verificar se sao apenas numeros inteiros
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsInteiro(String palavra)
   {
      boolean resp = true; 
      int contador = 0;//variavel de controle repeticao
      while(contador < palavra.length()  && resp)//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         resp = ('0' <= palavra.charAt(contador) && palavra.charAt(contador) <= '9' );//resposta = a verificacao de caracter numeral
         contador++;
      }
      return resp;
   }
   /*
    *Funcao para verificar se sao apenas numeros Reais
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsReal(String palavra)
   {
      boolean resp = true; 
      int contador = 0;//variavel de controle repeticao
      int contadorvirgula = 0;//contador para contabilizar apenas 1 virgula ou ponto, possivel em numeros reais
      while(contador < palavra.length()  && resp)//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         if(',' == palavra.charAt(contador) || '.' == palavra.charAt(contador))//teste para ver se o caracter e ponto ou virgula
         {
            contadorvirgula++;
            resp = (contadorvirgula == 1);//caso sim so sera numero real se obtiver apenas um ponto ou virgula
         }
         else
            resp = ('0' <= palavra.charAt(contador) && palavra.charAt(contador) <= '9');//resposta = a verificacao de caracter numeral
         contador++;
      }
      return resp;
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
         if(IsVogal(leitura))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO ");  
         if(IsConsoante(leitura))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO "); 
         if(IsInteiro(leitura))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO ");  
         if(IsReal(leitura))
            MyIO.println("SIM");
         else
            MyIO.println("NAO"); 
         leitura = MyIO.readLine();
      }
   }

}
