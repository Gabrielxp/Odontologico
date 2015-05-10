package br.com.uniciss.odontologico.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.DriverManager;




public class Admin {
	static Scanner scanner = new Scanner(System.in);

	protected static String nome;

	public static void updateSecretario() throws FileNotFoundException, IOException,
			ClassNotFoundException, SQLException {
		String nome;
		String update;
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/projeto_odontologico";
		String usuario = "postgres";
		String senha = "dentista";
		Class.forName("org.postgresql.Driver");
		Connection con;
		con = (DriverManager.getConnection(url, usuario, senha));

		nome = JOptionPane
				.showInputDialog("Insira o nome do secretario para editar");
		Statement stmt = con.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("SELECT nome FROM pessoa WHERE nome = '" + nome
				+ "'");
		while (rs.next()) {
			String name = rs.getString("nome");
		}
		update = JOptionPane
				.showInputDialog("Insira o novo nome para o secretario");
		stmt.executeUpdate("UPDATE pessoa SET nome  = '" + update
				+ "'WHERE nome = '" + nome + "'");
		con.close();
	}

	public static void updatePaciente() throws FileNotFoundException, IOException,
			ClassNotFoundException, SQLException {
		String nome;
		String update;
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/projeto_odontologico";
		String usuario = "postgres";
		String senha = "123";
		Class.forName("org.postgresql.Driver");
		Connection con;
		con = (DriverManager.getConnection(url, usuario, senha));

		nome = JOptionPane
				.showInputDialog("Insira o nome do paciente para editar");
		Statement stmt = con.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("SELECT nome FROM pessoa WHERE nome = '" + nome
				+ "'");
		while (rs.next()) {
			String name = rs.getString("nome");
		}
		update = JOptionPane
				.showInputDialog("Insira o novo nome para o paciente");
		stmt.executeUpdate("UPDATE pessoa SET nome  = '" + update
				+ "'WHERE nome = '" + nome + "'");
		con.close();
	}
}
