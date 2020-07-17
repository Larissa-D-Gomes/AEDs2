/*
    Nome: Larissa Domingues Gomes
    Turno: Manha
    Numero de Matricula: 650525
    Professor:
    Questao:Arvore de lista
*/
class Contato{
    public String nome;
    public String telefone;
    public String email;
    public int cpf;

    /*Construtor classe contato */
    public Contato(String nome, String telefone, String email, int cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;

    }
}

class Celula{
    public Contato contato;
    public Celula prox;

    /*Construtor classe celula */
    public Celula(Contato x){
        contato = x;
        prox = null;
    }

    public Celula(){
        contato = null;
        prox = null;
    }

}

class No{
    public Celula primeiro;
    public Celula ultimo;
    public char elemento;
    public No esq; 
    public No dir;

    /*Construtor classe no */
    public No(char c){
        primeiro = ultimo = new Celula();
        esq = dir = null;
        elemento = c;
    }

    /*Metodo para remover elemento da lista */
    public void remover(String nome)throws Exception{
        if(primeiro.prox == null)
            throw new Exception("ERRO!");
        if(primeiro.prox.contato.nome.equals(nome)){
	    	primeiro = primeiro.prox;
        } else if(ultimo.contato.nome.equals(nome)){
            Celula i;
            for(i = primeiro; i.prox != ultimo; i = i.prox);
            ultimo = i; 
            i = ultimo.prox = null;
        } else{
            Celula i;
            for(i = primeiro.prox; i.prox != null && !i.prox.contato.nome.equals(nome); i = i.prox);
            if(i.prox == null )
                throw new Exception("ERRO!");
            i.prox = i.prox.prox;
            i = null; 
        }

    }
}

class Agenda{
    private No raiz;
    /*Construtor agenda, insere todas as letras do alfabeto de maneira balanceada */
    public Agenda() {
	    raiz = new No ('M');
        raiz.esq = new No ('F');
        raiz.dir = new No ('T');
        raiz.esq.esq = new No ('C');
        raiz.esq.dir = new No ('I');
        raiz.dir.esq = new No ('Q');
        raiz.dir.dir = new No ('W');
        raiz.esq.esq.esq = new No ('B');
        raiz.esq.esq.dir = new No ('E');
        raiz.esq.dir.esq = new No ('G');
        raiz.esq.dir.dir = new No ('K');
        raiz.dir.esq.esq = new No ('O');
        raiz.dir.esq.dir = new No ('S');
        raiz.dir.dir.esq = new No ('U');
        raiz.dir.dir.dir = new No ('Y');
        raiz.esq.esq.esq.esq = new No ('A');
        raiz.esq.esq.dir.esq = new No ('D');
        raiz.esq.dir.esq.dir = new No ('H');
        raiz.esq.dir.dir.esq = new No ('J');
        raiz.esq.dir.dir.dir = new No ('L');
        raiz.dir.esq.esq.esq = new No ('N');
        raiz.dir.esq.esq.dir = new No ('P');
        raiz.dir.esq.dir.esq = new No ('R');
        raiz.dir.dir.esq.dir = new No ('V');
        raiz.dir.dir.dir.esq = new No ('X');
        raiz.dir.dir.dir.dir = new No ('Z');
	}
    /*Metodo para inserir caracter na arvore */
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

    /*Metodo para inserir Contato na arvore, conforme o no que contem 
      sua primeira letra */
    public void inserir(Contato contato) throws Exception {
		inserir(contato, raiz);
	}

    public void inserir(Contato contato, No i)throws Exception{
        if(i == null)
            throw new Exception("ERRO");
        else if(Character.toUpperCase(contato.nome.charAt(0)) == i.elemento){//Se caracter for encontrado 
            i.ultimo.prox = new Celula(contato);                             //inserir no fim
            i.ultimo = i.ultimo.prox;
        }
        else if(Character.toUpperCase(contato.nome.charAt(0)) > i.elemento){
             inserir(contato, i.dir);
        }else{
            inserir(contato, i.esq);
        }
    }

    /*Metodo para pesquisar conforme o nome do contato */
    public boolean pesquisar(String nome)throws Exception{
        return pesquisar(nome, raiz);   
    }

    public boolean pesquisar(String nome, No i)throws Exception{
        boolean resp = false; 
        if(i == null)    
            throw new Exception("ERRO");
        else if(Character.toUpperCase(nome.charAt(0)) == i.elemento){
            for(Celula c = i.primeiro.prox; c != null && !resp; c = c.prox){//Respeticao para buscar nome
                resp = (c.contato.nome.equals(nome));                       //quando o caracter for encontrado
            }
        }
        else if(Character.toUpperCase(nome.charAt(0)) > i.elemento){
            resp = pesquisar(nome, i.dir);
        }else{
            resp = pesquisar(nome, i.esq);
        }
        return resp;
    }

    /*Metodo para remover conforme o nome */
    public void remover(String nome)throws Exception {
        remover(nome, raiz);
    }

    public void remover(String nome, No i)throws Exception{
        if(i == null)
            throw new Exception("ERRO");
        else if(Character.toUpperCase(nome.charAt(0)) == i.elemento){//Quando o caracter for encontrado
            i.remover(nome);                                         //Chamar o metodo remover da lista
                                                                     //do no corrente
        }
        else if(Character.toUpperCase(nome.charAt(0)) > i.elemento){
            remover(nome, i.dir);
        }else{
            remover(nome, i.esq);
        }
    }
    /*Metodo para pesquisar conforme o cpf */
    public boolean pesquisar(int cpf) {
		return pesquisar(raiz, cpf);
	}

    /*Buscar conforme o metodo mostrar, para varrer todos nos e todas listas */
	private boolean pesquisar(No i, int cpf) {
      boolean resp = false;
		if (i != null) {
			for(Celula c = i.primeiro.prox; c != null && !resp; c = c.prox){
                resp = (c.contato.cpf == cpf);
            }
         if(!resp){
			   resp = pesquisar(i.esq, cpf); 
         }
         if(!resp){
            resp = pesquisar(i.dir, cpf); 
         }
      }
      return resp;
	}

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
}
