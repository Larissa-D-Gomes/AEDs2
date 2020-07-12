/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:IS JAVA Recursivo
*/

public class IsRecursivo
{ 
   /*
    *Funcao recursiva para verificar se sao apenas letras vogais
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsVogal(String palavra, int contador)
   {
      boolean resp = true; 
      if(contador < palavra.length())//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         resp = (('a' == palavra.charAt(contador) || 'A' == palavra.charAt(contador)) ||
            ('e' == palavra.charAt(contador) || 'e' == palavra.charAt(contador))||
            ('i' == palavra.charAt(contador) || 'I' == palavra.charAt(contador))||
            ('o' == palavra.charAt(contador) || 'O' == palavra.charAt(contador))||
            ('u' == palavra.charAt(contador) || 'U' == palavra.charAt(contador)));//resposta = a verificacao de caracter consoante minusculo maiusculo
         if(resp)//Controle para chamar recursiva, apenas quando os testes continuarem verdadeiro
         {
            resp = IsVogal(palavra, contador+1);// Resposta = retono da recursiva
         }
      }
      return resp;
   }
      /*
    *Funcao recursiva para verificar se sao apenas letras consoantes
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsConsoante(String palavra, int contador)
   {
      boolean resp = true; 
      if(contador < palavra.length())//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
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
         if(resp)//Controle para chamar recursiva, apenas quando os testes continuarem verdadeiro
         {
            resp = IsConsoante(palavra, contador+1);// Resposta = retono da recursiva
         }
      }
      return resp;
   }
    /*
    *Funcao recursiva para verificar se sao apenas numeros inteiros
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsInteiro(String palavra, int contador)
   {
      boolean resp = true; 
      if(contador < palavra.length())//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         resp = ('0' <= palavra.charAt(contador) && palavra.charAt(contador) <= '9' );//resposta = a verificacao de caracter numeral
         if(resp)//Controle para chamar recursiva, apenas quando os testes continuarem verdadeiro
         {
           resp = IsInteiro(palavra, contador+1);// Resposta = retono da recursiva
         }
      }
      return resp;
   }
   /*
    *Funcao recursiva para verificar se sao apenas numeros Reais
    * Recebe string como parametro e retorna um boolean
    */
   public static boolean IsReal(String palavra, int contador, int contadorvirgula)
   {
      boolean resp = true; 
      if(contador < palavra.length())//repeticao com teste logico e fisico, para evitar repeticoes a mais caso algum caracter != de maiusculo seja encontrado
      {
         if(',' == palavra.charAt(contador) || '.' == palavra.charAt(contador))//teste para ver se o caracter e ponto ou virgula
         {
            contadorvirgula++;
            resp = (contadorvirgula == 1);//caso sim so sera numero real se obtiver apenas um ponto ou virgula
         }
         else
            resp = ('0' <= palavra.charAt(contador) && palavra.charAt(contador) <= '9');//resposta = a verificacao de caracter numeral
         if(resp)//Controle para chamar recursiva, apenas quando os testes continuarem verdadeiro
         {
            resp = IsReal(palavra, contador+1, contadorvirgula);// Resposta = retono da recursiva
         }
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
         if(IsVogal(leitura,0))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO ");  
         if(IsConsoante(leitura,0))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO "); 
         if(IsInteiro(leitura,0))
            MyIO.print("SIM ");
         else
            MyIO.print("NAO ");  
         if(IsReal(leitura,0,0))
            MyIO.println("SIM");
         else
            MyIO.println("NAO"); 
         leitura = MyIO.readLine();
      }
   }

}
