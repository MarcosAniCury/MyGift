package itens;

import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * 
 * Feito por Marcos Ani Cury Vinagre Silva
 * Ultima atualizacao: 26/11/2020
 * 
*/

public class Usuario 
{
	
	//dados do usuario
	private String email;
	private String senha;
    private String nome;
    private String dataNascimento;
    private int idade;
    private char genero;
    private boolean isAdm;
    private String pergunta;

    /**
    * Criar um novo usuario.
    * 
    */

    public Usuario() {}
    
	  public Usuario(String email,String senha, String nome, String dataNascimento, char genero, boolean isAdm, String pergunta) {
	
	      this.email = email;
	      this.senha = senha;
	      this.nome = nome;
	      this.dataNascimento = dataNascimento;
	      this.genero = genero;
	      this.isAdm = isAdm;
	      this.pergunta = pergunta;
	      
	      Date data = new Date();
	      SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
	      String dataAtual = formatador.format(data);
	      //calcula a idade subtraindo o anoAtual pelo anoNascimento
	      int anoNascimento = Integer.parseInt(dataNascimento.substring(0 ,dataNascimento.indexOf("-") ));
	      int anoAtual = Integer.parseInt(dataAtual.substring(dataAtual.lastIndexOf("-") + 1, dataAtual.length()));
	      idade = 0;
	      if (anoNascimento != anoAtual)
	      {
	    	  idade = anoAtual - anoNascimento;
	    	  int mesAtual = Integer.parseInt(dataAtual.substring(dataAtual.indexOf("-") + 1, dataAtual.lastIndexOf("-")));
	    	  int mesNascimento = Integer.parseInt(dataNascimento.substring(dataNascimento.indexOf("-") + 1,dataNascimento.lastIndexOf("-")));
	    	  int diaAtual = Integer.parseInt(dataAtual.substring(0 , dataAtual.indexOf("-")));
	    	  int diaNascimento = Integer.parseInt(dataNascimento.substring(dataNascimento.lastIndexOf("-") + 1,dataNascimento.length()));
	    	  //verifica se ja fez aniversario esse ano
	    	  if (mesNascimento > mesAtual)
	    		  idade--;
	    	  else if (mesNascimento == mesAtual && diaAtual < diaNascimento)
	    		  idade--;
	      }     
	  }
	  
	  public String getEmail() {
	      return email;
	  }
	  
	  public void setEmail(String email) {
	      this.email = email;
	  }
	  
	  public String getSenha()
	  {
		  return senha;
	  }
	  
	  public void setSenha(String senha)
	  {
		  this.senha = senha;
	  }
	  
	  public String getNome() {
	      return nome;
	  }
	  
	  public void setNome(String nome) {
	      this.nome = nome;
	  }
	  
	  public String getDataNascimento() {
	      return dataNascimento;
	  }
	  
	  public void setDataNascimento(String dataNascimento) {
	      this.dataNascimento = dataNascimento;
	  }
	  
	  public int getIdade() {
	      return idade;
	  }
	  
	  public void setIdade(int idade) {
	      this.idade = idade;
	  }
	  
	  public char getGenero() {
	      return genero;
	  }
	  
	  public void setGenero(char genero) {
	      this.genero = genero;
	  }
	  
	  public boolean getIsAdm()
	  {
		  return isAdm;
	  }
	  
	  public void setIsAdm(boolean isAdm)
	  {
		  this.isAdm = isAdm;
	  }
	  
	  public void setPergunta(String pergunta)
	  {
		  this.pergunta = pergunta;
	  }
	  
	  public String getPergunta()
	  {
		  return pergunta;
	  }
}
