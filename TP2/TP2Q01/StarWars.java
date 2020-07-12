/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java
*/




public class StarWars{
   public static void main(String[] args)throws Exception
   {
      String arquivo = MyIO.readLine();
      while(!arquivo.equals("FIM"))
      {
         Personagem p = new Personagem(arquivo);
         p.printDados();
         arquivo = MyIO.readLine();
      }      
   }
}
