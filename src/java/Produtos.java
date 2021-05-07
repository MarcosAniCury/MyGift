package itens;

/*
 * 
 * Feito por Marcos Ani Cury Vinagre Silva
 * Ultima atualizacao: 7/11/2020
 * 
*/

public class Produtos {

	private int id;
	private String nome;
	private double preco;
	private int faixaEtaria;
	private String fotos;
	private String[] hobbies;

	/**
	* Criar um novo Produto.
	* 
	*/
		  
	public Produtos() {}

	public Produtos(String nome, int id, double preco, int faixaEtaria, String fotos, String[] hobbies) {
		
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.faixaEtaria = faixaEtaria;
		this.fotos = fotos;
		this.hobbies = hobbies;
	}
	
	public Produtos(String nome, double preco, int faixaEtaria, String fotos, String[] hobbies) 
	{	
		this.nome = nome;
		this.preco = preco;
		this.faixaEtaria = faixaEtaria;
		this.fotos = fotos;
		this.hobbies = hobbies;
	}

	  public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getFaixaEtaria() {
		return faixaEtaria;
	}


	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	public void setFoto(String foto)
	{
		this.fotos = foto;
	}
	
	public String getFotos()
	{
		return fotos;
	}

	public void setHobbies(String[] hobbies)
	{
		this.hobbies = hobbies;
	}
	
	public String[] getHobbies()
	{
		return hobbies;
	}
	
	public Produtos clone()
	{
		Produtos copia = new Produtos();
		copia.setNome(this.nome);
		copia.setId(this.id);
		copia.setPreco(this.preco);
		copia.setFaixaEtaria(this.faixaEtaria);
		copia.setFoto(this.fotos);
		copia.setHobbies(this.hobbies);
		return copia;
	}
	
}
