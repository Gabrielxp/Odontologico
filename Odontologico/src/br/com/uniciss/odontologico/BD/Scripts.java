package br.com.uniciss.odontologico.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.uniciss.odontologico.cliente.Cliente;

public class Scripts {

	private static Connection conexao;

	public static void insert(String sql) throws SQLException, ClassNotFoundException {
		try {
			conexao = new Conectar().conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
	} catch (Exception e) {

			System.out.println("ERRO CADASTRADO!");
		}

	}

	public static int select(String sql) throws ClassNotFoundException,
	SQLException {
		int idPessoa = 0;
		try {
			conexao = new Conectar().conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				idPessoa = rs.getInt("id_pessoa");
				System.out.println("ID: " + idPessoa);

			}
			
			

		} catch (Exception e) {
			
			System.out.println("Algo Errado nos Scripts");
		}

		return idPessoa;
	}

	public static String selectNome(String sql) throws ClassNotFoundException,
	SQLException {
		String nome = "";
		try {

			conexao = new Conectar().conectar();

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nome = rs.getString("nome");
				System.out.println("Nome: " + nome);

			}
		} catch (Exception e) {
			System.out.println("Algo errado nos Scripts!");
		}

		return nome;

	}



	public static String selectNomeUsuario(String sql) throws ClassNotFoundException, SQLException {
		String nome_usuario = "";

		Connection conexao1 = new Conectar().conectar();

		PreparedStatement sp0 = conexao1.prepareStatement(sql);

		ResultSet sr0 = sp0.executeQuery();

		while (sr0.next()) {
			nome_usuario = sr0.getString("nome_usuario");
			System.out.println("Nome: " + nome_usuario );		
		}

		return nome_usuario;

	}

	public static String selectSenha(String sql) throws ClassNotFoundException, SQLException {
		String senha = "";

		Connection conexao2 = new Conectar().conectar();

		PreparedStatement sp1 = conexao2.prepareStatement(sql);

		ResultSet sr1 = sp1.executeQuery();
		while (sr1.next()) {
			senha = sr1.getString("senha");
			System.out.println("Senha: " + senha);

		}	
		return senha;
	}

	public static String selectTipoUsers(String sql) throws ClassNotFoundException, SQLException {
		String tipo_users = "";

		Connection conexao3 = new Conectar().conectar();

		PreparedStatement sp3 = conexao3.prepareStatement(sql);

		ResultSet sr3 = sp3.executeQuery();
		while (sr3.next()) {
			tipo_users = sr3.getString("tipo_users");

			System.out.println("Tipo Usuario: " + tipo_users);

		}
		return tipo_users;
	}
	public static String update(String nome) throws ClassNotFoundException, SQLException{
	try {  
		Connection conexao3 = new Conectar().conectar();
		Statement conecta = conexao3.createStatement();
		
	    // Prepare a statement to update a record  
	    String sql = "UPDATE my_table SET col_string='a new string' WHERE col_string = 'a string'";  
	  
	    // Execute the insert statement  
		
	    int updateCount =  conecta.executeUpdate(nome);    
	    // updateCount contains the number of updated rows  
	} catch (SQLException e) {  
		System.out.println("Erro no update!");
	}
	return nome;
	}
}
