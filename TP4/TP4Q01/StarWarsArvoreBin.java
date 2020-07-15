/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Arvore Binaria
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class StarWarsArvoreBin{
   public static void main(String[] args)throws Exception{
      long inicio = new Date().getTime();
      FileWriter arquivo = new FileWriter("matrıculaarvoreBinaria.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      ArvoreBin arv = new ArvoreBin();
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         Personagem p = new Personagem(arq);
         arv.inserir(p);
         arq = MyIO.readLine();
      } 

      arq = MyIO.readLine();
      while(!arq.equals("FIM")) {
         MyIO.print(arq+" ");
         if(arv.pesquisar(arq))
            MyIO.print("SIM");
         else  
            MyIO.print("N"+(char)195+"O");
         MyIO.println("");
         arq = MyIO.readLine();
      }   
      long fim = new Date().getTime();
      gravar.println("650525\t"+(fim-inicio)/1000.0+"\t"+arv.getNumComp());
      //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
