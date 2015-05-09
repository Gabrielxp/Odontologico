package br.com.uniciss.odontologico.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
	static Connection conexao;
	public Connection conectar() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		conexao = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Projeto_Odontologico",
				"postgres", "gsp020596");
		System.out.println("Conectado!");
		return conexao;

	}

	public  Connection desconectar() throws SQLException {

		conexao.close();
		return conexao;

	}


}

