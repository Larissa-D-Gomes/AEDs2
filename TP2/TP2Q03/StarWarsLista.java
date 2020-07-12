/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java Lista
*/



public class StarWarsLista{
   public static void main(String[] args)throws Exception
   {
      ListaPersonagem p = new ListaPersonagem(90); 
      
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
            p.remover(posicao);
         }else{
            if(acao.equals("RF")){
               p.removerFim();
            }
            else{
               if(acao.equals("RI")){
                  p.removerInicio();
               }
               else{
                  if(acao.equals("I*")){                
                     posicao = MyIO.readInt();//Leitura da posicao da insercao
                     arq = MyIO.readString();//Leitura do nome do arquivo do personagem
                     p.inserir(arq, posicao);
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
