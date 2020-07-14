/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Lista
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class StarWarsListaFlexivel{
   public static void main(String[] args)throws Exception
   {
      Lista p = new Lista(); 
      
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         p.inserirFim(arq);
         arq = MyIO.readLine();
      }  
      int quantidadeAcoes = MyIO.readInt();//leitura de quantidade de acoes a serem executadas
      String acao;
      int posicao;//Variavel de leitura para posicao de acoes
      for(int aux = 0; aux < quantidadeAcoes; aux++)
      {
         acao = MyIO.readString();// leitura acao

         if(acao.equals("R*"))
         {
            posicao = MyIO.readInt();//leitura da posicao do personagem a ser removido 
            MyIO.println("(R) "+p.remover(posicao).getNome());
         }else{
            if(acao.equals("RF")){
               MyIO.println("(R) "+p.removerFim().getNome());
            }
            else{
               if(acao.equals("RI")){
                  MyIO.println("(R) "+p.removerInicio().getNome());
               }
               else{
                  if(acao.equals("I*")){                
                     posicao = MyIO.readInt();//Leitura da posicao da insercao
                     arq = MyIO.readString();//Leitura do nome do arquivo do personagem
                     p.inserir(posicao, arq);
                  }
                  else{
                     if(acao.equals("II")){
                        arq = MyIO.readString();//Leitura do nome do arquivo do personagem
                        p.inserirInicio(arq);
                     }
                     else{
                           arq = MyIO.readString();//Leitura do nome do arquivo do personagem
                           p.inserirFim(arq);
                     }
                  }
               }
            }
         }
      }
     p.printLista();
   }
}
