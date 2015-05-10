import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.uniciss.odontologico.BD.Conectar;

public class Teste {
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		String url = "jdbc:postgresql://localhost:5432/projeto_odontologico";
		String usuario = "postgres";
		String senha = "123";
		Class.forName("org.postgresql.Driver").newInstance();
		Connection con;
		con = (DriverManager.getConnection(url, usuario, senha));
		System.out.println("Conexão realizada com sucesso.");

		// Statement stm = con.createStatement();
		// ResultSet rs;
		// rs = stm.executeQuery("SELECT NOME FROM PESSOA");
		// while (rs.next()) {
		// String nomev = rs.getString("nome");
		// System.out.println(nomev);
		// con.close();
		// }
	}
}
