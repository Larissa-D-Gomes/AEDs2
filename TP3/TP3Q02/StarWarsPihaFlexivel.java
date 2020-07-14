/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Pilhaa Flexivel
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class StarWarsPihaFlexivel{
   public static void main(String[] args)throws Exception
   {
      Pilha p = new Pilha();
      String arquivo = MyIO.readLine();
      while(!arquivo.equals("FIM"))
      {  
         p.inserir(arquivo);
         arquivo = MyIO.readLine();
      }
      int quantidadeAcoes = MyIO.readInt();
      String acao;    
      for(int i = 0; i < quantidadeAcoes; i++){
         acao = MyIO.readString();
         if(acao.equals("R")){
            MyIO.println("(R) "+p.remover().getNome());
         }else{
            arquivo = MyIO.readLine();
            p.inserir(arquivo);
         }
      }
      p.mostrar();
   }
}
