package br.com.uniciss.odontologico.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Scripts {

	private static Connection conexao;

	public static void insert(String sql) throws SQLException {
		try {
		//	Connection conexao = null;
			conexao = new Conectar().conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			System.out.println("ERRO CADASTRADO!");
		}
		
	}

	public void select() throws ClassNotFoundException, SQLException {

		conexao = new Conectar().conectar();
		String sql = "SELECT id_pessoa, nome, cpf, endereco, data_nascimento FROM pessoa";
		PreparedStatement ps = conexao.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idPessoa = rs.getInt("id_pessoa");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			int endereco = rs.getInt("endereco");

			System.out.println("ID: " + idPessoa + " Nome:" + nome + " cpf: "
					+ cpf + "\n endereco:" + endereco);
		}  

	}

}
