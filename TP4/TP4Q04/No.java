/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe No 
*/

class No{
   public No esq;
   public No dir;
   public Personagem elemento;
   public boolean cor;

   public No(Personagem elemento){
      this(elemento, null, null, false);
   }

   public No(Personagem elemento, boolean cor){
      this(elemento, null, null, cor);
   }

   public No(Personagem elemento, No esq, No dir, boolean cor){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
      this.cor = cor;
	}
}
