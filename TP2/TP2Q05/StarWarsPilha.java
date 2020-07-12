/*
   Nome: Larissa Domingues Gomes
   Turno: Manha
   Numero de Matricula: 650525
   Professor: Felipe Cunha 
   Questao:Classe Personagens Star Wars Pilha
*/

public class StarWarsPilha{
   public static void main(String[] args)throws Exception{
      PilhaPersonagem p = new PilhaPersonagem(90);
      String acao;
      String arq = MyIO.readLine();
     // MyIO.println(acao);
     /*Repeticao para criar objetos Personagens ate a leitura = "FIM"*/
		while(!arq.equals("FIM")){
			p.inserir(arq);
			arq = MyIO.readLine();
		}
      int quantidadeAcao = MyIO.readInt();
      for(int aux = 0; aux < quantidadeAcao; aux++){
         acao = MyIO.readString();
         if(acao.equals("I"))
         {
            arq = MyIO.readLine();
          //  MyIO.println(arq);
            p.inserir(arq);
         }else{
            p.remover();
         }
      }
      p.printPilha();
   }
}
