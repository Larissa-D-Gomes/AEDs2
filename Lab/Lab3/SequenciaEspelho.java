/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:
Questao:PALINDROMOS JAVA
*/
import java.util.Scanner;
public class SequenciaEspelho
{
	public static void sequenciador(String num)
	{
		Scanner separador = new Scanner(num);//Objeto scanner para string num
		int inferior = separador.nextInt();//Inferior = primeiro inteiro lido na string num
		int superior = separador.nextInt();//Superior = segundo inteiro lido na string num
		String crescente = "";
		for(int aux = inferior; aux <= superior; aux++)//Repeticao para concatenar valor no intervalo entre inferior e superior
			crescente += aux;
		
		MyIO.print(crescente);
		//Repeticao para imprimir na tela string crescente espelhada
		for(int aux = crescente.length()-1; aux >= 0; aux--)                                                                                                                          	MyIO.print(crescente.charAt(aux));
		MyIO.println("");//Quebra de linha 
	}
	public static boolean verificadorFim(String palavra)
	{
		return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
	}
	public static void main(String[] args)
	{
		String numeros = MyIO.readLine();
		while(!verificadorFim(numeros))
		{
			sequenciador(numeros);
			numeros = MyIO.readLine();
		}
	}
}
