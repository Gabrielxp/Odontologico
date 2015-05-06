package br.com.uniciss.odontologico.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
	public String select(String identificador){
	
		
		
		
		
		return identificador;
		}
	
	public void intert(){
		
		
	}

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Projeto_Odontologico",
				"postgres", "gsp020596");
		System.out.println("Conectado!");
		
		
	
		
		try {
			String sql = "INSERT INTO pessoa (id_pessoa, nome, cpf, endereco, data_nascimento) "
					+ "VALUES (7,'Corleone','12345678911',1,'1990-02-04')";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			System.out.println("ID JÁ CADASTRADO!");

		}

		
		String sql1 = "SELECT id_pessoa, nome, cpf, endereco, data_nascimento FROM pessoa";
		PreparedStatement ps1 = conexao.prepareStatement(sql1);
		ps1.execute();
		ResultSet rs = ps1.executeQuery();
		while(rs.next()){
			int idPessoa = rs.getInt("id_pessoa");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			int endereco = rs.getInt("endereco");
			System.out.println("ID: "+idPessoa+" Nome:"+nome+" cpf: "+cpf+"\n endereco:"+endereco);
		}
	

		conexao.close();
	}

}
