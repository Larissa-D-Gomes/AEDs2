/*
 Nome: Larissa Domingues Gomes
 Turno: Manha
 Numero de Matricula: 650525
 Professor: Felipe Cunha 
 Questao:Lab6
*/

import java.io.*;

class CelulaDupla {
	public String elemento;
	public CelulaDupla ant;
	public CelulaDupla prox;

	public CelulaDupla() {
		this("");
	}

	public CelulaDupla(String elemento) {
		this.elemento = elemento;
		this.ant = this.prox = null;
	}
}

class ListaDupla {
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;

	public ListaDupla() {
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}

	public void inserirInicio(String x) {
		CelulaDupla tmp = new CelulaDupla(x);

		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo){
			ultimo = tmp;
		}else{
			tmp.prox.ant = tmp;
		}
		tmp = null;
	}

	public void inserirFim(String x) {
		ultimo.prox = new CelulaDupla(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	public String removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		String resp = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		tmp = null;
		return resp;
	}

	public String removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 
		String resp = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
		return resp;
	}

	public void inserir(String x, int pos) throws Exception {

		int tamanho = tamanho();

		if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
		} else if (pos == 0){
			inserirInicio(x);
		} else if (pos == tamanho){
			inserirFim(x);
		} else {
			// Caminhar ate a posicao anterior a insercao
			CelulaDupla i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);

			CelulaDupla tmp = new CelulaDupla(x);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}
	}

	public String remover(int pos) throws Exception {
		String resp;
		int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

		} else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
		} else if (pos == 0){
			resp = removerInicio();
		} else if (pos == tamanho - 1){
			resp = removerFim();
		} else {
			// Caminhar ate a posicao anterior a insercao
			CelulaDupla i = primeiro.prox;
			for(int j = 0; j < pos; j++, i = i.prox);

			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			resp = i.elemento;
			i.prox = i.ant = null;
			i = null;
		}

		return resp;
	}


	public int tamanho() {
		int tamanho = 0; 
		for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
		return tamanho;
	}

    public void mostrar(){
        for(CelulaDupla i = primeiro.prox; i != null ; i = i.prox){
            System.out.println(i.elemento);
        }
    }


	public void ordenar() {
		for (CelulaDupla i = primeiro.prox.prox; i != null; i = i.prox) {
			String tmp = i.elemento;
         CelulaDupla j = i.ant;

         while ((j != primeiro) && (j.elemento.compareTo(tmp) > 0)) {
            j.prox.elemento = j.elemento;
            j = j.ant;
         }
         j.prox.elemento = tmp;
      }
	}


    public int numIguais(){
        int contador = 0;
        for(CelulaDupla i = primeiro.prox; i != ultimo; i = i.prox){
          int t =  i.elemento.length();
          for(int j = 0; j < t; j++){
            if(i.elemento.charAt(j) == i.prox.elemento.charAt(j)){
                contador++;
            }else
                j = t;
          }
        }
        return contador;
    }
}

class ListaTelefonica{

    public static void main(String[] args) throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        String leitura;
        String num;

        while ((leitura = leitor.readLine()) != null) {//Primeira leitura, quantidade de numeros
            ListaDupla lista = new ListaDupla();
            for(int quantidade = Integer.parseInt(leitura); quantidade > 0; quantidade--){
                num = leitor.readLine();         
                lista.inserirFim(num);
            }
            lista.ordenar();
            System.out.println(lista.numIguais());
        }
    }
}
