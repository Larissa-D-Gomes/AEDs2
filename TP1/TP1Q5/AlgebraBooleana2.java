/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:Arquivo Java
*/

public class AlgebraBooleana2
{
   /*Metodo para para interpretar and e or*/
   public static String Interpretador(String Express, int posicaoParenteses)
   {
      String retorno = "";
      int aux = posicaoParenteses;
      boolean testeLogico = true;
      while(Express.charAt(aux) != '(' )
      {
         aux--;//encontrar a posicao do incio do parentese
         //MyIO.println(aux);
      }
      int aux2 = 0;//Variavel leitura
      while(aux2 < aux-1)
      {
         retorno+=Express.charAt(aux2);
         aux2++;
      }
      aux2+=2;//Variavel leitura
      if(Express.charAt(aux2-2) == '!')//Teste para ver se a expressao analisada esta sendo negada
      {
         if(Express.charAt(aux2) == '1')
            retorno+=0;
         else
            retorno+=1;
      }
      else
      {
         boolean valorLogico = true;//Variavel para auxiliar testes logicos "and" e "or"
         if(Express.charAt(aux2-2) == '|')//Teste para ver se a expressao analisada eh do tipo "or"
         {
            while(valorLogico && aux2 < posicaoParenteses)
            {
               valorLogico = (Express.charAt(aux2) != '1');//Teste para verificar se existe algum '1', caso sim a expressao sera verdadeira por se tratar de "or"
               aux2++;
            }
            if(valorLogico)//O valorLogico so sera falso caso exista '1'
            {
               retorno+=0;
            }
            else
               retorno+=1;
         }
         else
         {
            if(Express.charAt(aux2-2) == '&')//Teste para ver se a expressao analisada eh do tipo "and"
            {
               while(valorLogico && aux2 < posicaoParenteses)
               {
                  valorLogico = (Express.charAt(aux2) == '1');//Teste para verificar se existe algum '0', caso sim a expressao sera falsa por se tratar de "and"
                  aux2++;
               }
               if(valorLogico)//O valorLogico so sera falso caso exista '0'
                  retorno+=1;
               else
                  retorno+=0;
            }
         
         }
      }
      aux2=posicaoParenteses+1;
      while(aux2 < Express.length())
      {
         retorno+=Express.charAt(aux2);
         aux2++;
      }
      return retorno;
   }
   /*Metodo para substituir valores da string por valores logicos*/
   public static void setString(String Express)
   {
      String retorno = "";
      int quantidadeValores= (int)Express.charAt(0)-48;
      boolean[] ValoresLogicos = new boolean[quantidadeValores];//Array para armazenar valores logicos
      int leitura = 2;//Variavel de leitura da string, comeca em 2 para pular a quantidade de valores e o espaco
      String aux = "";
      while(leitura < quantidadeValores*2+1)//Repeticao para setar valores logicos, 2* quantidade para pular espacos
      {
         if(Express.charAt(leitura) == ' ')//pular espacos em branco
         {
            leitura++;         
         }
         else
         {
            if((int)Express.charAt(leitura)-48 ==1)//Se o numero lido = 1, a posicao sera verdadeira
               ValoresLogicos[(leitura/2)-1] = true;
            else
               ValoresLogicos[(leitura/2)-1] = false;//Se nao falsa
            leitura++;
         }
      }
      while(leitura < Express.length())//mudar valores logicos das expressoes 
      {
         if('A' <= Express.charAt(leitura) && Express.charAt(leitura) <= 'Z')
         {
         
            if(ValoresLogicos[(int)Express.charAt(leitura)-65])
               aux+=1;
            else
               aux+=0;
         }else{ 
            if('a' == Express.charAt(leitura))
            {
               aux+='&';
               leitura+=2;
            }else{
               if('o' == Express.charAt(leitura))
               {
                  aux+='|';
                  leitura+=1;
               }else{
                  if('n' == Express.charAt(leitura))
                  {
                     aux+='!';
                     leitura+=1;
                  }else{
                     if('(' == Express.charAt(leitura) ||')' == Express.charAt(leitura) )
                     {
                        aux+=Express.charAt(leitura);
                     }
                  }
               }
            }
         }
         leitura++;
      }
      Express = aux;
      aux = "";
      leitura = 0;
      while(leitura < Express.length())
      {
         if(Express.charAt(leitura) == ')')
         {
            Express = Interpretador(Express, leitura);//Procurar o primeiro parenteses que fecha para definir prioridade
            leitura = 0;
         }
         leitura++;
      }
      MyIO.println(Express);
   }
   public static void main(String[] args)
   {
      String Express = MyIO.readLine();
      while(Express.charAt(0) != '0')
      {
         setString(Express);
         Express = MyIO.readLine();
      }   
   }
}