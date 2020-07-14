/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe Celula Personagem
*/
class Celula{
   private Personagem elemento;
   public Celula prox;

   public Celula(){
      this.elemento = null;
      this.prox = null;
   }

   public Celula(String arq)throws Exception{
      this.elemento = new Personagem(arq);
      this.elemento.setPeso(0.0);//set do peso para 0.0, conforme o print
      this.prox = null;
   }

   public void setPersonagem(String arq)throws Exception{
      this.elemento = new Personagem(arq);
   }

   public Personagem getPersongem(){
      return this.elemento;
   }
}