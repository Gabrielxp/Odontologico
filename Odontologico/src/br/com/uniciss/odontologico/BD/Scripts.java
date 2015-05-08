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

}
