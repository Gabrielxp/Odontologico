package br.com.uniciss.odontologico.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Scripts {

	private static Connection conexao;

	public static void insert(String sql) throws SQLException {
		try {
			conexao = new Conectar().conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			
			System.out.println("ERRO CADASTRADO!");
		}
		
	}

	public static int select(String sql) throws ClassNotFoundException, SQLException {
		int idPessoa = 0;

		conexao = new Conectar().conectar();
	//	String sql = "SELECT id_pessoa, nome, cpf, endereco, data_nascimento FROM pessoa";
		PreparedStatement ps = conexao.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			idPessoa = rs.getInt("id_pessoa");
			//String nome = rs.getString("nome");
			//String cpf = rs.getString("cpf");
			//int endereco = rs.getInt("endereco");
			
			System.out.println("ID: " + idPessoa );
					
		}
		return idPessoa;
		
		
	 

	}
	public static String selectNome(String sql) throws ClassNotFoundException, SQLException {
		String nome = "";
		conexao = new Conectar().conectar();
	//	String sql = "SELECT id_pessoa, nome, cpf, endereco, data_nascimento FROM pessoa";
		PreparedStatement ps = conexao.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			//idPessoa = rs.getInt("id_pessoa");
			 nome = rs.getString("nome");
			//String cpf = rs.getString("cpf");
			//int endereco = rs.getInt("endereco");
			
			System.out.println("Nome: " + nome );
					
		}
		return nome;
		
		
	 

	}


}
