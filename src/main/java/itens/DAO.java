package itens;
import java.sql.*;

import org.json.JSONObject;

/*
 * 
 * Feito por Marcos Ani Cury Vinagre Silva
 * Ultima atualizacao: 7/11/2020
 * 
*/
public class DAO 
{
	private Connection conexao;
	//construtores
	public DAO() {
		conexao = null;
	}
	//conectar com o banco de dados
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "MyGift";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "postgres";
		String password = "admin";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao com o postgress efetuada");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexao nao efetuada com o postgress -- "+ e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexao nao efetuada com o postgress -- "+ e.getMessage());
		}

		return status;
	}
	//desconectar com o banco de dados
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	//----PRODUTOS----
	
	public boolean inserirProduto(Produtos produto) {
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO produto (nome,preco,etaria,imagem) "
					       + "VALUES (\'" + produto.getNome() + "\', \'"  
					       + produto.getPreco() + "\', \'" + produto.getFaixaEtaria() + "\',\'"+produto.getFotos()+"\')");
			st.close();
			Produtos tmpproduto = getProduto_Name(produto.getNome());
			String[] hobbies = produto.getHobbies();
			for(int i = 0;i < hobbies.length;i++)
			{
				Statement st2 = conexao.createStatement();
				st2.executeUpdate("INSERT INTO hobbies_produto (produto,hobbie) "
						       + "VALUES (\'" + tmpproduto.getId() + "\', \'"  
						       + idHobbie(hobbies[i]) + "\')");
				st2.close();
			}
			status = true;
		} 
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarProduto(Produtos produto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE produto SET id = \'" + produto.getId() + "\', nome = \'"  
				       + produto.getNome() + "\', preco = \'" + produto.getPreco() + "\', etaria = \'" + produto.getFaixaEtaria() + "\', imagem = \'" + produto.getFotos()+"\'"
					   + " WHERE id = \'" + produto.getId()+"\'";
			st.executeUpdate(sql);
			st.close();
			//hobbies
			st = conexao.createStatement();
			st.executeUpdate("DELETE FROM hobbies_produto where produto = \'"+produto.getId()+"\'");
			st.close();
			String[] hobbies = produto.getHobbies();
			for (int i = 0;i < hobbies.length;i++)
			{
				int idhobbie = idHobbie(hobbies[i]);
				st = conexao.createStatement();
				st.executeUpdate("INSERT INTO hobbies_produto (produto,hobbie) VALUES (\'"+produto.getId()+"\',\'"+idhobbie+"\')");
				st.close();
			}
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirProduto(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM produto WHERE id = \'"+ id+"\'");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//SELECTs
	
	public int nProdutos()
	{
		int nprodutos = 0;
		
		try 
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM pr	oduto");	
	        nprodutos = rs.getInt("count");
	        st.close();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return nprodutos;
	}
	
	public Produtos getProduto_id(int id)
	{
		Produtos produto = null;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE id = " + id);
			rs.next();
			String nome = rs.getString("nome");
			int idtmp = rs.getInt("id");
			double preco = rs.getDouble("preco");
			int etaria = rs.getInt("etaria");
			String imagem = rs.getString("imagem");
			String[] hobbies = new String[1];
			hobbies[0] = "null";
			st.close();
			Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2 = st2.executeQuery("SELECT hobbie FROM hobbies_produto WHERE produto = \'" + id+"\'");
			int i = 0;
			while(rs2.next())
			{
				hobbies = MyGiftCore.StringVariavel(hobbies);
				Statement st3 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs3 = st3.executeQuery("SELECT nome FROM hobbies WHERE id = \'" +rs2.getInt("hobbie")+"\'");
				rs3.next();
				hobbies[i++] = rs3.getString("nome");
				st3.close();
			}
			st2.close();
			produto = new Produtos(nome, idtmp, preco, etaria, imagem, hobbies);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	public Produtos getProduto_Name(String name)
	{
		Produtos produto = null;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE nome = \'" + name+"\'");
			rs.next();
			String nome = rs.getString("nome");
			int idtmp = rs.getInt("id");
			double preco = rs.getDouble("preco");
			int etaria = rs.getInt("etaria");
			String imagem = rs.getString("imagem");
			String[] hobbies = new String[1];
			hobbies[0] = "null";
			st.close();
			Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2 = st2.executeQuery("SELECT hobbie FROM hobbies_produto WHERE produto = \'" + idtmp+"\'");
			int i = 0;
			while(rs2.next())
			{
				hobbies = MyGiftCore.StringVariavel(hobbies);
				Statement st3 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs3 = st3.executeQuery("SELECT nome FROM hobbies WHERE id = \'" +rs2.getInt("hobbie")+"\'");
				rs3.next();
				hobbies[i++] = rs3.getString("nome");
				st3.close();
			}
			st2.close();
			produto = new Produtos(nome, idtmp, preco, etaria, imagem, hobbies);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	public Produtos[] getProdutos() {
		Produtos[] produtos = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM produto");		
	         if(rs.next())
	         {
	        	 rs.last();
	             produtos = new Produtos[rs.getRow()];
	             rs.beforeFirst();
	             for(int i = 0; rs.next(); i++) 
	             {
	            	String[] hobbies = new String[1];
	            	hobbies[0] = "null";
	            	Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    			ResultSet rs2 = st2.executeQuery("SELECT hobbie FROM hobbies_produto WHERE produto = \'" + rs.getInt("id")+"\'");
	    			int j = 0;
	    			while(rs2.next())
	    			{
	    				hobbies = MyGiftCore.StringVariavel(hobbies);
	    				Statement st3 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    				ResultSet rs3 = st3.executeQuery("SELECT nome FROM hobbies WHERE id = \'" +rs2.getInt("hobbie")+"\'");
	    				rs3.next();
	    				hobbies[j++] = rs3.getString("nome");
	    				st3.close();
	    			}
	    			st2.close();
	                produtos[i] = new Produtos(rs.getString("Nome"), rs.getInt("id"), rs.getDouble("Preco"), rs.getInt("etaria"), rs.getString("imagem"), hobbies);
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	//-------USUARIO-------
	
	public boolean inserirUsuario(Usuario user)
	{
		boolean status = false;
		try
		{
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuario (nome,idade,email,genero,senha,datanascimento,isadm,pergunta) VALUES(\'"+user.getSenha()+"\',"+user.getIdade()+",\'"+user.getEmail()+"\',\'"
							+user.getGenero()+"\',\'"+user.getNome()+"\',\'"+user.getDataNascimento()+"\',\'"+user.getIsAdm()+"\',\'"+user.getPergunta()+"\');");
			status = true;
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean atualizarUsuario(Usuario user)
	{
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET email =\'"+user.getEmail()+"\', nome=\'"+user.getNome()+"\', idade =\'"+user.getIdade()+"\', genero = \'"+user.getGenero()+"\', senha=\'"+user.getSenha()+"\',datanascimento=\'"+user.getDataNascimento()+"\', isadm=\'"+user.getIsAdm()+"\'"+" WHERE email =\'"+user.getEmail()+"\'";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} 
		catch (SQLException u) 
		{  
			MyIO.println(u.getMessage());
		}
		return status;
	}
	
	//SELECTs
	public boolean verificarEmail(String email)
	{
		boolean existeEmail = false;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT email FROM usuario WHERE email=\'"+email+"\'");
			rs.next();
			if (rs.getString("email") != null)
				existeEmail = true;
			st.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return existeEmail;
	}
	
	public boolean verificaSenha(String email, String senha)
	{
		boolean senhaCorreta = false;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT email, senha FROM usuario WHERE email=\'"+email+"\' and senha=\'"+senha+"\'");
			rs.next();
			if(rs.getString("email") != null && rs.getString("senha") != null)
				senhaCorreta = true;
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return senhaCorreta;
	}
	
	public boolean verificaisAdm(String email, String senha)
	{
		boolean isAdm = false;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT email, senha, isadm FROM usuario WHERE email=\'"+email+"\' and senha=\'"+senha+"\' and isadm=true");
			rs.next();
			if(rs.getString("email") != null && rs.getString("senha") != null && rs.getBoolean("isadm"))
				isAdm = true;
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return isAdm;
	}
	
	public boolean verificarResposta(String resposta, String email)
	{
		boolean isResposta = false;
		try
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT email, pergunta FROM usuario WHERE email=\'"+email+"\' and pergunta=\'"+resposta+"\'");
			rs.next();
			if(rs.getString("email") != null && rs.getString("pergunta") != null)
				isResposta = true;
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return isResposta;
	}
	
	public Usuario acharUsuario(String email)
	{
		Usuario user = new Usuario();
		
		try
		{	Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE email=\'"+email+"\'");
			rs.next();
			user = new Usuario(rs.getString("email"),rs.getString("senha"),rs.getString("nome"),rs.getString("datanascimento"),rs.getString("genero").charAt(0),rs.getBoolean("isadm"),rs.getString("pergunta"));
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage()+"Erro aqui");
		}
		return user;
	}
	
	//-----Hobbie----
	
	public int idHobbie(String hobbie)
	{
		int retorno = 0;
		try
		{	Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT id FROM hobbies WHERE nome=\'"+hobbie+"\'");
			rs.next();
			retorno = rs.getInt("id");
			st.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage()+"Erro aqui");
		}
		return retorno;
	}
	
	//-----Algoritmo de Recomendação----
	
	public int idMelhorProduto(String[] hobbies,int idade,char valor)
	{
		int idMelhorProduto = 0;
		
		try 
		{
			//pegar todos os ids dos hobbies
			int[] idhobbies = new int[hobbies.length];
			for(int i = 0;i < hobbies.length;idhobbies[i] = idHobbie(hobbies[i++]));
			
			//contadores
			int i = 0;
			int contMelhorProduto = 0;
			
			//pegar todos os produtos e escolher o que tem o maior numero de hobbies iguais dentro da faixa etaria
			do
			{
				//pegar produto por produto que existe entre os hobbies
				Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("SELECT produto FROM hobbies_produto WHERE hobbie = "+idhobbies[i++]);		
		        while(rs.next())
		        {
		        	//verificar faixa etaria do produto e se o valor e compativel com o do usuario
		        	boolean isProprio = false;
		        	boolean isPreco = false;
		        	Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		        	ResultSet rs2 = st2.executeQuery("SELECT etaria,preco FROM produto WHERE id = "+ rs.getInt("produto"));		
			        if(rs2.next())
			        {
			        	if(rs2.getInt("etaria") <= idade)
			        		isProprio = true;
			        	switch (valor)
			        	{
			        		case '-': 
			        			if (rs2.getDouble("preco") < 50)
			        				isPreco = true;
			        			break;
			        		case '1':
			        			if (rs2.getDouble("preco") < 150)
			        				isPreco = true;
			        			break;
			        		case '+': isPreco = true;
			        			break;
			        		default:
			        	}
			        }
			        st2.close();
			        if (isProprio && isPreco)
			        {
			        	//verificar todos os hobbies que cada produto possui e ver se possui algum que o hobbie do user tem
			        	st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						rs2 = st2.executeQuery("SELECT hobbie FROM hobbies_produto WHERE produto = "+ rs.getInt("produto"));		
						int tmpconthobbies = 0;
				        while(rs2.next())
				        {
				            for(int j = 0;j < idhobbies.length;j++)
				            {
				        	    if(rs2.getInt("hobbie") == idhobbies[j])
				        	    {
				        	    	tmpconthobbies++;
				        	    	//forcar parada do for caso ache o hobbie no idhobbies
				        	    	j = idhobbies.length;
				        	    }
				            }
				        }
				        st2.close();
				        //verificar se o produto possui um numero maior de hobbies compativeis com o user do que o armazenado atual
				        if (tmpconthobbies >= contMelhorProduto)
				        {
			        		contMelhorProduto = tmpconthobbies;
			        		idMelhorProduto = rs.getInt("produto");
				        }
				        //verificar se o produto tem o mesmo numero de hobbies que o user
				        if (contMelhorProduto == idhobbies.length - 1)
				        	i = idhobbies.length;
				        st.close();
			        }
		        }
	        }while(i < idhobbies.length);
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return idMelhorProduto;
	}
}
