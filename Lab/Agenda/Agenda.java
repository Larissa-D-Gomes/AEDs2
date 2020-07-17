
class Contato{
    public String nome;
    public String telefone;
    public String email;
    public int cpf;

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

    public No(char c){
        primeiro = ultimo = new Celula();
        esq = dir = null;
        elemento = c;
    }

    public void remover(String nome)throws Exception{
        if(primeiro.prox == null)
            throw new Exception("ERRO!");

    }
}

class Agenda{
    private No raiz;

    
    public Agenda()throws Exception{
	  for(char c = 'A'; c <= 'Z'; c++){
          inserir(c);
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


    public void inserir(Contato contato) throws Exception {
		inserir(contato, raiz);
	}

    public void inserir(Contato contato, No i)throws Exception{
        if(i == null)
            throw new Exception("ERRO");
        else if(Character.toUpperCase(contato.nome.charAt(0)) == i.elemento){
            i.ultimo.prox = new Celula(contato);
            i.ultimo = i.ultimo.prox;
        }
        else if(Character.toUpperCase(contato.nome.charAt(0)) > i.elemento){
             inserir(contato, i.dir);
        }else{
            inserir(contato, i.esq);
        }
    }

   /* public void remover(String nome)throws Exception {
        remover(nome, raiz);
    }*/

 /*   public void remover(String nome, No i)throws Exception{
        if(i == null)
            throw new Exception("ERRO");
        else if(Character.toUpperCase(contato.nome.charAt(0)) == i.elemento){
            i.remover(nome);
        }
        else if(Character.toUpperCase(contato.nome.charAt(0)) > i.elemento){
            remover(contato, i.dir);
        }else{
            remover(contato, i.esq);
        }
    }*/
}

public Class ArvAgenda{
        
}