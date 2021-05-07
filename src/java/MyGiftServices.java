package itens;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;

import spark.Request;
import spark.Response;

import itens.MyGiftCore;

/*
 * 
 * Feito por Marcos Ani Cury Vinagre Silva
 * Ultima atualizacao: 28/11/2020
 * 
*/

public class MyGiftServices {
	
	private static DAO MyGiftDAO = new DAO();

	public MyGiftServices() {}

	//------Buscar melhor produto------
	
	public Object formulario(Request request, Response response) 
	{
		response.header("Access-Control-Allow-Origin","*");
		String nome = request.queryParams("nome");
		int idade = Integer.parseInt(request.queryParams("idade"));
		char sexo = request.queryParams("sexo").charAt(0);
		char relacionamento = request.queryParams("relacionamento").charAt(0);
		//checkbox valor do presente
		char valorpresente = request.queryParams("valor").charAt(0);
		//checkbox lazeres
		boolean[] hobbies = new boolean[24];
		for (int i = 0;i < 24;i++)
		{
			if (request.queryParams(Integer.toString(i)) != null)
				hobbies[i] = true;
			else
				hobbies[i] = false;
		}
		String[] hobbiesUser = MyGiftCore.transformaHobbies(hobbies);
		//chamada da API
		int idprodutoselecionado = MyGiftCore.Recomendacao(nome,idade,sexo,relacionamento,valorpresente,hobbiesUser);
		
		//JSON 
		
		JSONObject obj = new JSONObject();
		
		obj.put("id", idprodutoselecionado);
		
		return obj;
	}

	public Object autoformulario(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		String email = request.queryParams("email");
		//checkbox valor do presente
		char valorpresente = request.queryParams("valor").charAt(0);
		//checkbox lazeres
		boolean[] hobbies = new boolean[24];
		for (int i = 0;i < 24;i++)
		{
			if (request.queryParams(Integer.toString(i)) != null)
				hobbies[i] = true;
			else
				hobbies[i] = false;
		}
		Usuario user = MyGiftDAO.acharUsuario(email);
		String[] hobbiesUser = MyGiftCore.transformaHobbies(hobbies);
		//chamada da API
		int idprodutoselecionado = MyGiftCore.Recomendacao(user.getNome(),user.getIdade(),user.getGenero(),'A',valorpresente,hobbiesUser);
		
		//JSON 
		
		JSONObject obj = new JSONObject();
		
		obj.put("id", idprodutoselecionado);
		
		MyGiftDAO.close();
		
		return obj;
	}
	
	public Object acharProduto(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		int id = Integer.parseInt(request.params(":id"));
		Produtos produto = MyGiftDAO.getProduto_id(id);
		
		//JSON
		
		JSONObject obj = new JSONObject();
		if (id != 0)
		{
			obj.put("nome", produto.getNome());
			obj.put("id", produto.getId());
			obj.put("preco", produto.getPreco());
			obj.put("etaria", produto.getFaixaEtaria());
			obj.put("imagem", produto.getFotos());
			obj.put("hobbies", produto.getHobbies());
		}
		else
		{
			obj.put("id", id);
		}
		MyGiftDAO.close();
		return obj;
	}
	
	//----Login e Cadastro-----
	
	public Object login(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		String email = request.queryParams("email");
		String senha = request.queryParams("senha");
		boolean verificacao = false;
		//verificar se o email existe e se a senha e compativel
		if (MyGiftDAO.verificarEmail(email) && MyGiftDAO.verificaSenha(email, senha))
			verificacao = true;
		//JSON
		
		boolean isAdm = MyGiftDAO.verificaisAdm(email, senha);
		
		JSONObject obj = new JSONObject();
		
		obj.put("LoginEfetuado", verificacao);
		obj.put("isAdm", isAdm);
		
		MyGiftDAO.close();
		return obj;
	}
	
	public Object cadastro(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		boolean status = false;
		String email = request.queryParams("email");
		//verificar se esse email ja existe
		if (!MyGiftDAO.verificarEmail(email))
		{
			String nome = request.queryParams("nome");
			String senha = request.queryParams("senha");
			char genero = request.queryParams("genero").charAt(0);
			String datanascimento = request.queryParams("datanascimento");
			String pergunta = request.queryParams("resposta");
			pergunta = pergunta.toLowerCase();
			//criacao do Usuario e armazenamento
			Usuario user = new Usuario(email,nome,senha,datanascimento,genero,false,pergunta);
			status = MyGiftDAO.inserirUsuario(user);
		}
		
		//JSON
		
		JSONObject obj = new JSONObject();
		
		obj.put("CadastroEfetuado", status);
		
		MyGiftDAO.close();
		return obj;
	}
	
	public Object esqueciSenha(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		boolean status = false;
		String email = request.queryParams("email");
		String resposta = request.queryParams("resposta");
		resposta = resposta.toLowerCase();
		String novaSenha = request.queryParams("senha");
		if (MyGiftDAO.verificarEmail(email) && MyGiftDAO.verificarResposta(resposta,email))
		{
			Usuario user = MyGiftDAO.acharUsuario(email);
			user.setSenha(novaSenha);
			status = MyGiftDAO.atualizarUsuario(user);
		}
		
		//JSON
		
		JSONObject obj = new JSONObject();
		
		obj.put("status", status);
		
		MyGiftDAO.close();
		return obj;
	}
	
	//-----ADM-----
	
	public Object listarProdutos(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		Produtos[] produtos = MyGiftDAO.getProdutos();
		
		produtos = MyGiftCore.Insercao(produtos);
		
		//JSON
		
		JSONArray retorno = new JSONArray();
		for(int i = 0;i < produtos.length;i++)
		{
			JSONObject tmp = new JSONObject();
			tmp.put("nome", produtos[i].getNome());
			tmp.put("id", produtos[i].getId());
			tmp.put("preco", produtos[i].getPreco());
			tmp.put("etaria", produtos[i].getFaixaEtaria());
			tmp.put("imagem", produtos[i].getFotos());
			tmp.put("hobbies", produtos[i].getHobbies());
			retorno.put(tmp);
		}
		MyGiftDAO.close();
		return retorno;
	}
	
	public Object inserirProduto(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		boolean resp = false;
		boolean[] temp = new boolean[24];
		for (int i = 0;i < 24;i++)
		{
			if (request.queryParams(Integer.toString(i)) != null)
				temp[i] = true;
			else
				temp[i] = false;
		}
		String[] hobbies = MyGiftCore.transformaHobbies(temp);
		
		Produtos produto = new Produtos(request.queryParams("nome"),Double.parseDouble(request.queryParams("preco")),Integer.parseInt(request.queryParams("etaria")),request.queryParams("imagem"),hobbies);
		
		resp = MyGiftDAO.inserirProduto(produto);
		
		//JSON
		
		JSONObject obj = new JSONObject();
		obj.put("status", resp);
		
		MyGiftDAO.close();
		return obj;
	}
	
	public Object deletarProduto(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		int id = Integer.parseInt(request.queryParams("id"));
		boolean isDeletado = MyGiftDAO.excluirProduto(id);
		
		//JSON
		
		JSONObject obj = new JSONObject();
		obj.put("status", isDeletado);
		
		MyGiftDAO.close();
		return obj;
	}
	
	public Object alterarProduto(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		boolean[] temp = new boolean[24];
		for (int i = 0;i < 24;i++)
		{
			if (request.queryParams(Integer.toString(i)) != null)
				temp[i] = true;
			else
				temp[i] = false;
		}
		String[] hobbies = MyGiftCore.transformaHobbies(temp);
		Produtos produto = new Produtos(request.queryParams("nome"),Integer.parseInt(request.queryParams("id")),Double.parseDouble(request.queryParams("preco")),Integer.parseInt(request.queryParams("etaria")),request.queryParams("imagem"),hobbies);
		boolean status = MyGiftDAO.atualizarProduto(produto);
		
		//JSON
		
		JSONObject obj = new JSONObject();
		obj.put("status", status);
		
		MyGiftDAO.close();
		return obj;
	}
	
	public Object getProduto(Request request, Response response)
	{
		MyGiftDAO.conectar();
		response.header("Access-Control-Allow-Origin","*");
		int id = Integer.parseInt(request.params(":id"));
		Produtos produto = MyGiftDAO.getProduto_id(id);
		
		//JSON
		
		JSONObject obj = new JSONObject();
		obj.put("id", produto.getId());
		obj.put("nome", produto.getNome());
		obj.put("hobbie", produto.getHobbies());
		obj.put("etaria", produto.getFaixaEtaria());
		obj.put("preco", produto.getPreco());
		obj.put("imagem", produto.getFotos());
		MyGiftDAO.close();
		return obj;
	}
}
