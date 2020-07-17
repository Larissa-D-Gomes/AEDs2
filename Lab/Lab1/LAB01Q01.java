/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:LAB01Q01
*/

public class LAB01Q01
{ 
   /*
    *Funcao para contar letras maiusculas
    * Recebe string como parametro
    */
   public static void ContadorLetrasMaiusculas(String palavra)
   {
       int aux = palavra.length();//Auxiliar para armazenar o tamanho da palavra
       int contador = 0;//contador de letras maiusculas
       for(int aux2 = 0; aux2 < palavra.length(); aux2++)
       {
          if('A' <= palavra.charAt(aux2) && palavra.charAt(aux2) <= 'Z' )
	  {
	     contador++;
	  }
       }
       MyIO.println(contador);
   }
   public static void main(String[] args)
   {
       String s = MyIO.readLine();
       while(!s.equals("FIM"))
       {       
          ContadorLetrasMaiusculas(s);
          s = MyIO.readLine();
       }
   }

}
