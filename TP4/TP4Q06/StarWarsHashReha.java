/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Tabela Hash com Rehash
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;


public class StarWarsHashReha{
   public static void main(String[] args)throws Exception{
      Hash h = new Hash();
      long inicio = new Date().getTime();
      FileWriter arquivo = new FileWriter("matricula_hashRehash.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         Personagem e = new Personagem(arq);
         h.inserir(e);
         arq = MyIO.readLine();
      } 

      arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         MyIO.print(arq);
         if(h.pesquisar(arq))
            MyIO.println(" SIM");
         else  
            MyIO.println(" NÃO");

         arq = MyIO.readLine();
      }
      
      long fim = new Date().getTime();
      gravar.println("650525\t"+(fim-inicio)/1000.0+"\t"+h.getNumComp());
      //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
