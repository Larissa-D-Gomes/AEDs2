/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe No
*/

class No{
   public No esq;
   public No dir;
   public Personagem elemento;

   public No(Personagem elemento)throws Exception{
      this.esq = null;
      this.dir = null;
      this.elemento = elemento.Clone();
   }

   public No(Personagem elemento, No esq, No dir)throws Exception{
		this.elemento = elemento.Clone();
		this.esq = esq;
		this.dir = dir;
	}
}

