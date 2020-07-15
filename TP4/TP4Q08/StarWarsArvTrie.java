/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Trie
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class StarWarsArvTrie{
   public static void main(String[] args)throws Exception{
      Trie arvT1 = new Trie();
      Trie arvT2 = new Trie();
      long inicio = new Date().getTime();
      FileWriter arquivo = new FileWriter("matricula_arvoreTrie.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         Personagem e = new Personagem(arq);
         arvT1.inserir(e.getNome());
         arq = MyIO.readLine();
      } 

      arq = MyIO.readLine();

      while(!arq.equals("FIM")) {
         Personagem e = new Personagem(arq);
         arvT2.inserir(e.getNome());
         arq = MyIO.readLine();
      } 

      Trie arvT3 = arvT1.merge(arvT2);

      arq = MyIO.readLine();
      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         MyIO.print(arq);
         if(arvT3.pesquisar(arq))
            MyIO.println(" SIM");
         else  
            MyIO.println(" NÃO");

         arq = MyIO.readLine();
      } 
      
      long fim = new Date().getTime();
      gravar.println("650525\t"+(fim-inicio)/1000.0+"\t"+arvT1.getNumComp()+arvT2.getNumComp()+arvT3.getNumComp());
     //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
