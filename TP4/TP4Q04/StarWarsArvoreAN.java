/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Alvinegra
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;


public class StarWarsArvoreAN{
   public static void main(String[] args)throws Exception{
      long inicio = new Date().getTime();
      FileWriter arquivo = new FileWriter("matrıcula_alvinegra.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      ArvoreAlvinegra an = new ArvoreAlvinegra();
      String arq = MyIO.readLine();

      while(!arq.equals("FIM")) {
         Personagem e = new Personagem(arq);
         an.inserir(e);
         arq = MyIO.readLine();
      } 
      
      arq = MyIO.readLine();
      while(!arq.equals("FIM")) {
         MyIO.print(arq+" ");
         if(an.pesquisar(arq))
            MyIO.print("SIM");
         else  
            MyIO.print("NÃO");
         MyIO.println("");
         arq = MyIO.readLine();
      }   
      long fim = new Date().getTime();
      gravar.println("650525\t"+(fim-inicio)/1000.0+"\t"+an.getNumComp());
      //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
