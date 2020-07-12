/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Pesquisa Sequncial
*/

import java.util.Date;
import java.io.FileWriter;
import java.io.PrintWriter;

public class StarWarsPesquisa{
   public static void main(String[] args)throws Exception
   {
      long inicio = new Date().getTime();
      ListaPersonagem p = new ListaPersonagem(90); 
      FileWriter arquivo = new FileWriter("matrícula_sequencial.txt");
      PrintWriter gravar = new PrintWriter(arquivo);
      String arq = MyIO.readLine();

      //Repeticao para fazer o set de dados do array de personagens ate arq = fim
      while(!arq.equals("FIM")) {
         p.inserirFim(arq);
         arq = MyIO.readLine();
      }  

      String nome = MyIO.readLine();
      //Repeticao para fazer pesquisa de personagens
      while(!nome.equals("FIM")) {
         if(p.pesquisa(nome)){
            MyIO.println("SIM");
         }else{
            MyIO.println("NAO");
         }
         nome = MyIO.readLine();
      }  
      long fim = new Date().getTime();
      gravar.println("650525\t"+p.getNumComparacoes()+"\t"+(fim-inicio)/1000.0);//gravar no arquivo numero de
                                                                                //comparacoes e tempo de execucao
      arquivo.close();
   }
}
