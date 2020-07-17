/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:LAB01Q02
*/

public class LAB01Q02
{ 
   /*
    *Funcao recursiva para contar letras maiusculas
    * Recebe string e posicao de leitura
    */
   public static int ContadorLetrasMaiusculas(String palavra, int posicao)
   {
       int aux = palavra.length();//Auxiliar para armazenar o tamanho da palavra
       int contador = 0;//contador de letras maiusculas
       if( posicao < aux )
       {
          if('A' <= palavra.charAt(posicao) && palavra.charAt(posicao) <= 'Z' )
	  {
             contador++;
          }
          contador+=ContadorLetrasMaiusculas(palavra, posicao+1);
       }
       return contador;
   }
   public static void main(String[] args)
   {
       String s = MyIO.readLine();
       int total = 0;
       while(!s.equals("FIM"))
       {       
          total+=ContadorLetrasMaiusculas(s,0);
          s = MyIO.readLine();
          MyIO.println(total);
	  total = 0;
       }
    }

}
