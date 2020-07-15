/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao: Classe NoString
*/

class NoString{
   public NoString esq;
   public NoString dir;
   public String elemento;

   public NoString(String elemento)throws Exception{
      this.esq = null;
      this.dir = null;
      this.elemento = elemento;
   }

   public NoString(String elemento, NoString esq, NoString dir)throws Exception{
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}
