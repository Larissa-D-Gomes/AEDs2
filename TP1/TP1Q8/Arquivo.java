/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor:Felipe Cunha
Questao:Arquivo Java
*/
import java.io.RandomAccessFile;

public class Arquivo
{
   /*Metodo para leitura do arquivo de tras para frente*/
   public static void LerArquivo(int quantidadeNum)throws Exception
   {
      RandomAccessFile arq = new RandomAccessFile("Dados.dat", "r");//abrir arquivo para leitura de binario
      double num = 0.0;
      for(int aux = 0; aux < quantidadeNum; aux++)//repeticao para ler no arquivo conforme a quantidade de vezes lida
      {
         arq.seek((quantidadeNum*8) - (aux*8)-8);//Ajustar cursor para ler o arquivo de tras para frente
         num = arq.readDouble();
	 if(num-(int)num == 0)//Teste para conferir se o numero double eh intera
	 	MyIO.println((int)num);//se for, imprimir somente a parte intera
	 else
		   MyIO.println(num);
      }	 
      arq.close();
   }
   public static void main(String[] args)throws Exception
   {
      int quantidadeNum = MyIO.readInt();
      RandomAccessFile arquivo = new RandomAccessFile("Dados.dat", "rw");//abrir arquivo para escrita de binario
      double num = 0.0;
      for(int aux = 0; aux < quantidadeNum; aux++)//repeticao para escrever no arquivo conforme a quantidade de vezes lida
      {
         num = MyIO.readDouble();
         arquivo.writeDouble(num);//escrever double no arquivo
      }
      arquivo.close();
      LerArquivo(quantidadeNum);     
   }  
}
