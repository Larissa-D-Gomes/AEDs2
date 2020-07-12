/*
 * Nome: Larissa Domingues Gomes
 * Turno: Manha
 * Numero de Matricula: 650525
 * Professor:Felipe Cunha
 * Questao:Algebra Booleana Recursiva Java
  */
/*Classe para tratar expressao logica*/
class Expressao
{
   private String Express;
   private boolean[] valoresLogicos;
   private int leitura;
   private char c;
	/*Funcao recursiva para pular caracteres que nao acrescentarao na resolucao recursiva do problema */
   private void pularCaracter()
   {
      if(leitura < this.Express.length())
      {
         if(this.Express.charAt(this.leitura) == ' ' || this.Express.charAt(this.leitura) == ',')
         {
            this.leitura++;//mover cursor
            pularCaracter();
         }
      }
   }
   public Expressao()
   {
   }
   public Expressao(String Express)
   {
      this.Express = Express; 
      valoresLogicos = new boolean[(int)(this.Express.charAt(0)-'0')];//Criacao array de boolean, com a 
                                                                      //quantidade de valores logicos recebida
      this.leitura = 2;       
      
   	/* while para o set dos valores logicos do array de boolean*/
      while(this.leitura < ((int)(this.Express.charAt(0)-'0')*2+1))//Repeticao para fazer o set valores 
                                                                   //logicos, 2* quantidade para pular espacos
      {
         pularCaracter();
         if(this.Express.charAt(leitura) == '1')//Se o caracter lido = 1, a posicao sera verdadeira
            this.valoresLogicos[(leitura/2)-1] = true;
         else
            this.valoresLogicos[(leitura/2)-1] = false;//Se nao falsa
         this.leitura++;
      }
   }
   
	/*Funcao recursiva para interpretar a funcao logica, retorna um boolean */
   public boolean Interpretador()
   {
      boolean retorno = true;
      pularCaracter();
      this.c = this.Express.charAt(this.leitura);
      if('A' <= this.c && this.c <= 'Z')//Teste para ver se o carcter lido eh um valor boolean
      {
      
         retorno = valoresLogicos[(int)this.c-65];//Retorno = valor logico, conforme a posicao 
                                                  //do caracter no array de bool
      }
      else
      {
         if('a' == this.c)
         {
            this.leitura+=4;//pular caracteres "nd("
            retorno = Interpretador();
            while( this.Express.charAt(this.leitura) != ')')//ler ate o final da expressao and, sinalizado pelo ')'
            {
               retorno = Interpretador() && retorno;
            }
         }
         else
         {
            if('n' == this.c)//ler ate o final da expressao not, sinalizadp pelo ')'
            {
               this.leitura+=4;//pular caracteres "ot("
               retorno = !Interpretador();//negacao do retorno na expressao
            }
            else
            {
               if('o' == this.c)
               {         
                  this.leitura+=3;//pular caracteres "r("
                  retorno = Interpretador();
                  while(this.Express.charAt(this.leitura) != ')')//ler ate o final da expressao or, sinalizado pelo ')'
                     retorno = Interpretador() || retorno;
               }
            }
         }
      }
      this.leitura++;//mover cursor
      return retorno;
   }
}
public class AlgebraBooleanaRecursiva
{
   public static void main(String[] args)
   {
      String leitura = MyIO.readLine();
      while(leitura.charAt(0) != '0' )
      {
         Expressao x = new Expressao(leitura);
         if(x.Interpretador())
            MyIO.println(1);
         else
            MyIO.println(0);
         leitura = MyIO.readLine();
      }
   }
}	
