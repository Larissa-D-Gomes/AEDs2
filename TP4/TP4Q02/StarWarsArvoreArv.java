/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Arvore
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class StarWarsArvoreArv{
   public static void main(String[] args)throws Exception{
      long inicio = new Date().getTime();
      FileWriter arquivo = new FileWriter("matrıculaarvoreArvore.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      ArvoreArv arv = new ArvoreArv();
      arv.inserir(7);
      arv.inserir(3);
      arv.inserir(11);
      arv.inserir(1);
      arv.inserir(5);
      arv.inserir(9);
      arv.inserir(12);
      arv.inserir(0);
      arv.inserir(2);
      arv.inserir(4);
      arv.inserir(6);
      arv.inserir(8);
      arv.inserir(10);
      arv.inserir(13);
      arv.inserir(14);
   //arv.mostraCentral();
      String arq = MyIO.readLine();
      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         Personagem e = new Personagem(arq);
         arv.inserir(e);
         arq = MyIO.readLine();
      } 

      arq = MyIO.readLine();
      while(!arq.equals("FIM")) {
         MyIO.print(arq+" ");
         if(arv.pesqPre(arq))
            MyIO.print("SIM");
         else  
            MyIO.print("NÃO");
         MyIO.println("");
         arq = MyIO.readLine();
      }   
      long fim = new Date().getTime();
      gravar.println("650525\t"+(fim-inicio)/1000.0+"\t"+arv.getNumComp());
      //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
