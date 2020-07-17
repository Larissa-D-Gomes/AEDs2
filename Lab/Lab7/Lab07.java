/*
 Nome: Larissa Domingues Gomes
 Turno: Manha
 Numero de Matricula: 650525
 Professor: Felipe Cunha 
 Questao:Lab7
*/

class No{
    public char elemento;
    public No esq;
    public No dir;

    /*Construtor vazio da classe no */
    public No(){
        elemento = ' ';
        esq = null;
        dir = null;
    }
    /*Construtor que recebe um caracter da classe no */
    public No(char c){
        elemento = c;
        esq = null;
        dir = null;
    }
}

class Arvore{
    private No raiz;

    /*Construtor classe arvore */
    public Arvore(){
        raiz = null;
    }

	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}

	private boolean pesquisar(int x, No i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (x == i.elemento) {
         resp = true;

      } else if (x < i.elemento) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarCentral() {
		System.out.print("[ ");
		mostrarCentral(raiz);
		System.out.println("]");
	}

	private void mostrarCentral(No i) {
		if (i != null) {
			mostrarCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
			mostrarCentral(i.dir); // Elementos da direita.
		}
	}


	public void mostrarPre() {
		System.out.print("[ ");
		mostrarPre(raiz);
		System.out.println("]");
	}


	private void mostrarPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			mostrarPre(i.esq); // Elementos da esquerda.
			mostrarPre(i.dir); // Elementos da direita.
		}
	}


	public void mostrarPos() {
		mostrarPos(raiz);
		System.out.println("");
	}

	private void mostrarPos(No i) {
		if (i != null) {
			mostrarPos(i.esq); // Elementos da esquerda.
			mostrarPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento); // Conteudo do no.
		}
	}

   public void analiseString(String a, String b)throws Exception{
      if(a.length() <= 0)
         throw new Exception("ERRO!");
      int l = a.length();
      for(int x = 0; x < l; x++){
         raiz = analiseStringEsq(raiz, a.charAt(x), b, x);
      }
   }

   public No analiseStringEsq(No i, char novo, String b, int x)throws Exception{
      if(i == null){
         i = new No(novo);
      } else{
         char raiz = i.elemento;
         int pRaiz;
         int pNovo;
         for(pRaiz = 0; b.charAt(pRaiz) != raiz; pRaiz++);
         for(pNovo = 0; b.charAt(pNovo) != novo; pNovo++);
         if(pNovo < pRaiz){
            i.esq = analiseStringEsq( i.esq, novo, b, x);
         }else{
            if(pNovo > pRaiz){
               i.dir = analiseStringEsq( i.dir, novo, b, x);
            }else{
               throw new Exception("ERRO!");
            }
         }

      }
      return i;
   }

   public void inserirEsq(char x){
      if(raiz == null)
         raiz = new No(x);
      else{
         No c;
         for(c = raiz; c.esq != null; c = c.esq);
         c.esq = new No(x);
     }
   }

   public void inserirDir(char x){
      if(raiz == null)
         raiz = new No(x);
      else{
         No c;
         for(c = raiz; c.dir != null; c = c.dir);
         c.dir = new No(x);
     }
   }

	public void inserir(char x) throws Exception {
		raiz = inserir(x, raiz);
	}

	private No inserir(char x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

      } else if (x < i.elemento) {
         i.esq = inserir(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}

	public void remover(char x) throws Exception {
		raiz = remover(x, raiz);
	}

	private No remover(char x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x < i.elemento) {
         i.esq = remover(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = remover(x, i.dir);

      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

      // No a esquerda e no a direita.
      } else {
         i.esq = antecessor(i, i.esq);
		}

		return i;
	}

	private No antecessor(No i, No j) {

      // Existe no a direita.
		if (j.dir != null) {
         // Caminha para direita.
			j.dir = antecessor(i, j.dir);

      // Encontrou o maximo da subarvore esquerda.
		} else {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.
		}
		return j;
	}
}

class Lab07{
    public static void main(String[] args)throws Exception{
        int qnt = MyIO.readInt();
        int l;
        String leitura;
        String leitura2;
        for(int i = 0; i < qnt; i++){
            Arvore arv = new Arvore();
            l = MyIO.readInt();
            leitura = MyIO.readString();
            leitura2 = MyIO.readString();
            arv.analiseString(leitura, leitura2);
            arv.mostrarPos();

        }
    }
}