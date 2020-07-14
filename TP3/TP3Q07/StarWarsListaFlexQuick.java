/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Lista Flexivel Quicksort
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;


public class StarWarsListaFlexQuick{
   public static void main(String[] args)throws Exception
   {
      long inicio = new Date().getTime();
      Lista p = new Lista(); 
      FileWriter arquivo = new FileWriter("matrícula_quicksort2.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         p.inserirFim(arq);
         arq = MyIO.readLine();
      }  
      p.quicksort();
      //p.insercao();
      //p.selecao();
      p.printLista();
      long fim = new Date().getTime();
      gravar.println("650525\t"+p.getComp()+"\t"+p.getMv()+"\t"+(fim-inicio)/1000.0);
      //gravar no arquivo numero de comparacoes e tempo de execucao
      arquivo.close();
   }
}
