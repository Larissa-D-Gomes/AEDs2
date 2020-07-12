/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao: HTML JAVA
*/
import java.net.*;
import java.io.*;

public class HTML
{
   //Metodo pra verificar se string eh comando <table>
   public static boolean isTable(String x)
   {
      return(x.length() == 7 && x.charAt(0) == '<' && x.charAt(1) == 't' && x.charAt(2) == 'a' && x.charAt(3) == 'b' &&
             x.charAt(4) == 'l' && x.charAt(5) == 'e' && x.charAt(6) == '>');
   }  
   //Metodo pra verificar se string eh comando <br>
  public static boolean isBr(String x)
   {
      return(x.length() == 4 && x.charAt(0) == '<' && x.charAt(1) == 'b' && x.charAt(2) == 'r' && x.charAt(3) == '>');
   }
   public static void AnalisarHTML(String link, String nome) throws Exception
   {
      URL end = new URL(link); //Objeto endereco pagina web
      URLConnection con = end.openConnection();//Estabelecer coneccao
      BufferedReader leitor = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String palavra;
      int contador = 0;
      int consoantes = 0;
      int contadorA = 0;
      int contadorE = 0;
      int contadorI = 0;
      int contadorO = 0;
      int contadorU = 0;
      int contador¡ = 0;
      int contador… = 0;
      int contadorÕ = 0;
      int contador” = 0;
      int contador⁄ = 0;
      int contador¿ = 0;
      int contador» = 0;
      int contadorÃ = 0;
      int contador“ = 0;
      int contadorŸ = 0;
      int contador√ = 0;
      int contador’ = 0;
      int contador¬ = 0;
      int contador  = 0;
      int contadorŒ = 0;
      int contador‘ = 0;
      int contador€ = 0;
      int table= 0;
      int br = 0;
      while ((palavra = leitor.readLine()) != null)
      { 
         if(isTable(palavra))
         {
            table++;
         }
         else
         {
            if(isBr(palavra))
            {
               br++;
            }
            else
            {         
               while(contador < palavra.length())
               {
                  if('a' == palavra.charAt(contador))
                  {
                     contadorA++;
                  }
                  else
                  {
                     if('e' == palavra.charAt(contador))
                     {
                        contadorE++;
                     }
                     else
                     {
                        if('i' == palavra.charAt(contador))
                        {
                           contadorI++;
                        }
                        else
                        {
                           if('o' == palavra.charAt(contador))
                           {
                              contadorO++;
                           }
                           else
                           {
                              if('u' == palavra.charAt(contador))
                              {
                                 contadorU++;
                              }
                              else
                              {
                                 if('·' == palavra.charAt(contador))
                                 {
                                    contador¡++;
                                 }      
                                 else
                                 {
                                    if('È' == palavra.charAt(contador))
                                    {
                                       contador…++;
                                    }     
                                    else
                                    {
                                       if('Ì' == palavra.charAt(contador))
                                       {
                                          contadorÕ++;
                                       }   
                                       else
                                       {
                                          if('Û' == palavra.charAt(contador))
                                          {
                                             contador”++;
                                          }
                                          else
                                          {
                                             if('˙' == palavra.charAt(contador))
                                             {
                                                contador⁄++;
                                             }
                                             else
                                             {
                                                if('‡' == palavra.charAt(contador))
                                                {
                                                   contador¿++;
                                                }
                                                else
                                                {
                                                   if('Ë' == palavra.charAt(contador))
                                                   {
                                                      contador»++;
                                                   }           
                                                   else
                                                   {
                                                      if('Ï' == palavra.charAt(contador))
                                                      {
                                                         contadorÃ++;
                                                      }           
                                                      else
                                                      {
                                                         if('Ú' == palavra.charAt(contador))
                                                         {
                                                            contador“++;
                                                         }           
                                                         else
                                                         {
                                                            if('˘' == palavra.charAt(contador))
                                                            {
                                                               contadorŸ++;
                                                            }           
                                                            else
                                                            {
                                                               if('„' == palavra.charAt(contador))
                                                               {
                                                                  contador√++;
                                                               }
                                                               else
                                                               {
                                                                  if('ı' == palavra.charAt(contador))
                                                                  {
                                                                     contador’++;
                                                                  } 
                                                                  else
                                                                  {
                                                                     if('‚' == palavra.charAt(contador))
                                                                     {
                                                                        contador¬++;
                                                                     }   
                                                                     else
                                                                     {
                                                                        if('Í' == palavra.charAt(contador))
                                                                        {
                                                                           contador ++;
                                                                        } 
                                                                        else
                                                                        {
                                                                           if('Ó' == palavra.charAt(contador))
                                                                           {
                                                                              contadorŒ++;
                                                                           } 
                                                                           else
                                                                           {
                                                                              if('Ù' == palavra.charAt(contador))
                                                                              {
                                                                                 contador‘++;
                                                                              }   
                                                                              else
                                                                              {
                                                                                 if('˚' == palavra.charAt(contador))
                                                                                 {
                                                                                    contador€++;
                                                                                 }   
                                                                                 else
                                                                                 {
                                                                                    if('a' <= palavra.charAt(contador) && palavra.charAt(contador) <= 'z')//Todas as vogais foram testadas, caso seja uma letra automaticamente sera consoante
                                                                                       consoantes++;
                                                                                 }        
                                                                              }              
                                                                           }              
                                                                        }           
                                                                     }          
                                                                  }            
                                                               }           
                                                            } 
                                                         } 
                                                      }  
                                                   }  
                                                }               
                                             }            
                                          }            
                                       }          
                                    }        
                                 }           
                              }              
                           }                  
                        }
                     }
                  }
                  contador++;
               }
            }
            contador++;
         }
         contador = 0;
      }
      String tostring = ("a("+contadorA+") e("+contadorE+") i("+contadorI+") o("+contadorO+") u("+contadorU+") ·("+contador¡+
         ") È("+contador…+") Ì("+contadorÕ+") Û("+contador”+") ˙("+contador⁄+") ‡("+contador¿+") Ë("+contador»+
         ") Ï("+contadorÃ+") Ú("+contador“+") ˘("+contadorŸ+") „("+contador√+") ı("+contador’+") ‚("+contador¬+") Í("+
         contador +") Ó("+contadorŒ+") Ù("+contador‘+") ˚("+contador€+") consoante("+consoantes+") <br>("+br+") <table>("+table+") "+nome);//Transformar todas informacoes em uma string
     String print = new String(tostring.getBytes(), "ISO-8859-1");//Mudar string para encoding ISO, para letras serem printadas com acento
      MyIO.println(print);
      leitor.close();
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
   public static void main(String[] args)throws Exception
   {
      String nome = MyIO.readLine();
      while(!VerificadorFim(nome))
      {
         String endereco = MyIO.readLine();
         AnalisarHTML(endereco, nome);
         nome = MyIO.readLine();
      }
   }
}
