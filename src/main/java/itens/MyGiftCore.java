package itens;
import java.util.Random;
import itens.MyIO;
import static spark.Spark.*;

/*
 * 
 * Feito por Marcos Ani Cury Vinagre Silva
 * Ultima atualizacao:22/11/2020
 * 
*/

public class MyGiftCore {

	public static DAO dao = new DAO();
	
	private static MyGiftServices Servicos = new MyGiftServices();
	
	public static void main(String [] args)
	{	
		dao.conectar();
		port(5573);
		staticFiles.location("/public");
		
		//--Usuario--
		
		post("/formulario", (request, response) -> Servicos.formulario(request, response));
		
		post("/autoformulario", (request, response) -> Servicos.autoformulario(request, response));
		
		post("/login", (request, response) -> Servicos.login(request, response));
		
		post("/cadastro", (request, response) -> Servicos.cadastro(request,response));
		
		post("/esquecisenha", (request, response) -> Servicos.esqueciSenha(request,response));
		
		//pegar 1 produto pelo id
		get("/getproduto/:id", (request, response) -> Servicos.getProduto(request,response));
		
		//resposta do formulario
		get("/presenteado/:id", (request, response) -> Servicos.acharProduto(request, response));
		
		//--Admin--
		
		get("/listarprodutos", (request, response) -> Servicos.listarProdutos(request,response));
		
		post("/inserirproduto", (request, response) -> Servicos.inserirProduto(request,response));
		
		post("/deletarproduto", (request, response) -> Servicos.deletarProduto(request,response));
		
		post("/alterarproduto", (request, response) -> Servicos.alterarProduto(request,response));
		
		dao.close();
	}
	
	public static int Recomendacao(String nome,int idade,char sexo,char relacionamento,char valorpresente,String[] hobbies)
	{
		//Algoritmo de Recomendacao
		dao.conectar();
		int melhor = dao.idMelhorProduto(hobbies,idade,valorpresente);
		dao.close();
		return melhor;
	}
	
	public static String[] StringVariavel(String[] vet)
	{
		String[] temp = new String[1];
		if (vet[0].equals("null"))
			temp = new String[1];
		else
		{
			temp = new String[vet.length+1];
			for (int i = 0; i < vet.length;i++)
				temp[i] = vet[i];
		}
		return temp;
	}
	
	public static String[] transformaHobbies(boolean[] hob)
	{
		String[] hobbies = new String[1];
		int conthobbies = 0;
		hobbies[0] = "null";
		String[] todosHobbies = {"Livros","Volei","Futebol","Basquete","Jogos Digitais","Jogos Tabuleiros","Pesca","Musica","Filmes/Series","Gastronomia","Artes","Academia","Jardinagem","Cultura Maker","Colecionador","Escrita","Animes","Mangas","Praia","Casa","Material Escolar","Figurinhas","Pintura","Acampar"};
		for(int i = 0;i < hob.length;i++)
		{
			if(hob[i])
			{
				hobbies = StringVariavel(hobbies);
				hobbies[conthobbies++] = todosHobbies[i];
			}
		}
		return hobbies;
	}
	
	//ordena��o por inser��o
	public static Produtos[] Insercao(Produtos[] produtos)
    {
        for (int i = 1; i < produtos.length; i++) 
        {
            Produtos tmp = produtos[i].clone();
            int j = i - 1;
            
            boolean flag = true;
            while ( (j >= 0) && (produtos[j].getId() >= tmp.getId() && flag))
            {
                produtos[j + 1] = produtos[j].clone();
                j--;
            }
            produtos[j + 1] = tmp;
        }
        return produtos;
    }
}
