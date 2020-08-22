/*
Nome: Larissa Domingues Gomes
Turno: Manha
Numero de Matricula: 650525
Professor: Felipe Cunha 
Questao:Classe Personagens Star Wars Java
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class Personagem
{
   private String nome;
   private int altura;
   private double peso;
   private String corDoCabelo;
   private String corDaPele;
   private String corDosOlhos;
   private String anoNascimento;
   private String genero;
   private String homeWorld;
   
   /*Metodo para remover valor de NULL das 
    *Strings caso o arquivo seja aberto
    */
   private void iniciarStrings()
   {
      this.nome = "";
      this.corDoCabelo = "";
      this.corDaPele = "";
      this.corDosOlhos = "";
      this.anoNascimento = "";
      this.genero = "";
      this.homeWorld = "";
   }

   public static String ISO88591toUTF8(String strISO) throws Exception {
		byte[] isoBytes = strISO.getBytes("ISO-8859-1");
		return new String(isoBytes, "UTF-8");
	}
   
   /*Funcao para gravar dados dos personagens
    *recebe como parametros uma string que 
    *contem os dados 
    */   
   void gravarDados(String dados)throws Exception
   {
      dados = new String(dados.getBytes(), "ISO-8859-1");
      //MyIO.println(dados);
      
      String aux = dados.substring(dados.indexOf("name") + 8);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.nome = aux;
      //MyIO.println(this.nome);
      
      aux = dados.substring(dados.indexOf("height") + 10);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      if(aux.equals("unknown"))
         this.altura = 0;
      else
         this.altura = Integer.parseInt(aux);//Converter String para inteiro
      //MyIO.println(this.altura);
      
      aux = dados.substring(dados.indexOf("mass") + 8);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));

      if(aux.equals("unknown"))
         this.peso = 0;
      else{
         this.peso = Double.parseDouble(aux.replace(",",""));//Converter String para inteiro
      }
      //MyIO.println(this.peso);

      aux = dados.substring(dados.indexOf("hair_color") + 14);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.corDoCabelo = aux;
      //MyIO.println(this.corDoCabelo);
      
      aux = dados.substring(dados.indexOf("eye_color") + 13);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.corDosOlhos = aux;
      //MyIO.println(this.corDosOlhos);

      aux = dados.substring(dados.indexOf("birth_year") + 14);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.anoNascimento = aux;
      //MyIO.println(this.anoNascimento);
      

      aux = dados.substring(dados.indexOf("gender") + 10);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.genero = aux;
      //MyIO.println(this.genero);
      
      aux = dados.substring(dados.indexOf("homeworld") + 13);//String para fazer leitura para variaveis int
      aux = aux.substring(0, aux.indexOf("'"));
      this.homeWorld = aux;
      //MyIO.println(this.homeWorld);  
   }
   
    /*Construtor vazio*/
   public Personagem(){
   }
   
    /*Construtor que recebe como parametro String
     *contendo o nome do arquivo a ser lido
     */
   public Personagem(String leitura)throws Exception
   {
      try
      {
         String nome = ISO88591toUTF8(leitura);//Mudar string para encoding UTF-8, 
                                               //para abrir arquivo com acento
         // MyIO.println(nome);
         FileReader arq = new FileReader(nome);
         BufferedReader leitor = new BufferedReader(arq);
         String dados = leitor.readLine();//Leitura da unica linha dos dados
                                          //presente no arquivo
         this.iniciarStrings();
         this.gravarDados(dados);//chamada da funcao para gravar dados dos personagens
         arq.close();
      }
      catch(IOException e)
      {
         MyIO.println("ERRO NA ABERTURA DO ARQUIVO");
      }
   }

   /*Construtor que recebe como parametros os atributos da classe */
   public Personagem(String nome, int altura, double peso, String corDoCabelo,
                     String corDaPele, String corDosOlhos, 
                     String anoNascimento, String genero, String homeWorld){
      this.nome = nome;
      this.altura = altura;
      this.peso = peso;
      this.corDoCabelo = corDoCabelo;
      this.corDaPele = corDaPele;
      this.corDosOlhos = corDosOlhos;
      this.anoNascimento = anoNascimento;
      this.genero = genero;
      this.homeWorld = homeWorld;
   
   }
   /*Metodos get*/
   public String getNome()
   { 
      return this.nome;
   } 
   public int getAltura()
   {
      return this.altura;
   }
   public double getPeso()
   {
      return this.peso;
   }
   public String getCorDoCabelo()
   {
      return this.corDoCabelo;
   }
   public String getCorDaPele()
   {
      return this.corDaPele;
   }
   public String getCorDosOlhos()
   {
      return this.corDosOlhos;
   }
   public String getAnoNascimento()
   {
      return this.anoNascimento;
   }
   public String getGenero()
   {
      return this.genero;
   }
   public String getHomeWorld()
   {
      return this.homeWorld ;
   }
   
   /*Metodos set*/
   public void setNome(String nome)
   { 
      this.nome = nome;
   } 
   public void setAltura(int altura)
   {
      this.altura = altura;
   }
   public void setPeso(double peso)
   {
      this.peso = peso;
   }
   public void setCorDoCabelo(String CorDoCabelo)
   {
      this.corDoCabelo = corDoCabelo;
   }
   public void setCorDaPele(String corDaPele)
   {
      this.corDaPele = corDaPele;
   }
   public void setCorDosOlhos(String corDosOlhos)
   {
      this.corDosOlhos = corDosOlhos;
   }
   public void setAnoNascimento(String anoNascimento)
   {
      this.anoNascimento = anoNascimento;
   }
   public void setGenero(String genero)
   {
      this.genero = genero;
   }
   public void setHomeWorld(String homeWorld)
   {
      this.homeWorld = homeWorld;
   }
   
   /*Metodo para imprimir dados do personagem*/
   public void printDados()
   {
      if((int)this.peso == this.peso)
      {
         MyIO.println(" ## "+this.nome+" ## "+this.altura+" ## "+(int)this.peso+" ## "+this.corDoCabelo+
                   " ## "+this.corDaPele+" ## "+this.corDosOlhos+" ## "+this.anoNascimento+" ## "+
                   this.genero+" ## "+this.homeWorld+" ## ");
      }
      else
         MyIO.println(" ## "+this.nome+" ## "+this.altura+" ## "+this.peso+" ## "+this.corDoCabelo+
                   " ## "+this.corDaPele+" ## "+this.corDosOlhos+" ## "+this.anoNascimento+" ## "+
                   this.genero+" ## "+this.homeWorld+" ## ");
   }
   
   /*Metodo para clonar atributos*/
   public Personagem Clone()
   {
         Personagem p = new Personagem(this.nome, this.altura, this.peso, this.corDoCabelo, 
                           this.corDaPele, this.corDosOlhos, this.anoNascimento,
                           this.genero, this.homeWorld);
         return(p);
   }
}
