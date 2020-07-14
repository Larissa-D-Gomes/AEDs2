/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe Celula Personagem
*/

class Celula{
   public Celula prox;
   public Celula ant;
   public Personagem elemento;

   public Celula(){
      this.prox = null;
      this.ant = null;
      this.elemento = null;
   }

   public Celula(String arq)throws Exception{
      this.prox = null;
      this.ant = null;
      this.elemento = new Personagem(arq);
   }
}
