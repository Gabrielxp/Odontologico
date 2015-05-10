package br.com.uniciss.odontologico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import javax.swing.MenuSelectionManager;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.admin.Admin;
import br.com.uniciss.odontologico.admin.Agendamento;
import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.cliente.Tratamentos;
import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Funcionario;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Menus {

	ArrayList<Funcionario> listaUsuario = new ArrayList<Funcionario>();
	Map<String, Funcionario> mapaUsuario = new HashMap<String, Funcionario>();

	Scanner s = new Scanner(System.in);
	/**
	 * Método Login, utilizado para validação de login e senha
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	
	
	public void Login() throws IOException, SQLException, ClassNotFoundException {
		Gravar g = new Gravar();
		g.leituraUsuario(mapaUsuario);
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("Informe o Login:");
			String usuario = entrada.readLine();

			System.out.println("Informe a senha:");
			String senha = entrada.readLine();

			if ((mapaUsuario.containsKey(usuario))
					&& (mapaUsuario.get(usuario).getSenha().equals(senha))) {

				if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo()
								.equals("dentista"))) {
					menuDentista();

				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo()
								.equals("secretario"))) {
					menuSecretario();
				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("admin"))) {
					menuAdmin();
				}

			} else {
				System.out.println("Usuario e/ou senha invalido(s)!");
				System.out.println("");
				Login();
			}

		} catch (InputMismatchException e) {

			s.nextLine();
			System.out.println("Você informou algum caracter inválido(s)! ");

		} catch (NullPointerException b) {

			System.out.println("Login inexistente!");
		}

	}
*/
	/**
	 *  Metodo menuDentista, utilizado para escolha de opcoes do usuario dentista
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void menuDentista() throws IOException, ClassNotFoundException, SQLException {

		Dentista d = new Dentista();

		int opc;
		System.out.println();
		System.out.println("-' Dentista '- ");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Editar Paciente");
		System.out.println("2 - Cadastrar Tratamento");
		System.out.println("3 - Encaminhar Paciente");
		System.out.println("4 - Sair");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch (opc) {
	
		case 1:
			Admin admin = new Admin();
			admin.updatePaciente();
			break;
		case 2:
		Tratamentos t = new Tratamentos();
		t.cadastraTratamentos();
			break;
		case 3:
			System.out.println("Determine o nome");
			Scanner teclado = new Scanner(System.in);
			String nome = teclado.nextLine();
			d.encaminharPaciente(nome);
			break;
		case 4:
			Programa.main(null);
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}

	/**
	 *  Metodo menuSecretario, utilizado para escolha de opcoes do usuario secretario
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void menuSecretario() throws IOException, SQLException, ClassNotFoundException {

		Secretario c = new Secretario();

		int opc;
		System.out.println();
		System.out.println("-' Secretario '- ");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Cadastrar Pacientes");
		System.out.println("2 - Listar Pacientes");
		System.out.println("3 - Editar Paciente");
		System.out.println("4 - Inativar Paciente");
		System.out.println("5 - Ativar Paciente");
		System.out.println("6 - Agendar Consulta");
		System.out.println("7 - Listar Consultas");
		System.out.println("8 - Sair");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch (opc) {
		case 1:
			Cliente cliente = new Cliente();
			cliente.cadastrarCliente();
			break;
		case 2:
			Secretario secretario = new Secretario();
			secretario.consultarPaciente();
			break;
		case 3:
			Admin admin = new Admin();
		//	admin.editarPaciente();
			break;
		case 4:
			c.inativarPaciente();
			break;
		case 5:
			c.ativarPaciente();
			break;
		case 6:
			Agendamento ag = new Agendamento();
			ag.agendar();
			break;
		case 7:
			c.listarConsulta();
		case 8:
			Programa.main(null); 
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}
	/**
	 *  Metodo menuAdmin, utilizado para escolha de opcoes do usuario administrador
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */

	public void menuAdmin() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Secretario c = new Secretario();
		Dentista d = new Dentista();
		Admin a = new Admin();
		System.out.println(" -' Administrador '-");
		System.out.println("Escolha a opção: ");
		System.out.println("1 - Cadastrar Secretario");
		System.out.println("2 - Editar Secretario");
		System.out.println("3 - Procurar Secretario");
		System.out.println("4 - Cadastrar Dentista");
		System.out.println("5 - Editar Dentista");
		System.out.println("6 - Procurar Dentista");
		System.out.println("7 - Menu Secretario");
		System.out.println("8 - Menu Dentista");
		System.out.println("9 - Sair");
		s = new Scanner(System.in);
		int opc = s.nextInt();
		if(opc==9){
			System.exit(0);
		}
		switch (opc) {
		case 1:
			c.cadastrarSecretario();
			break;
		case 2:
			Admin admin = new Admin();
			Admin.updateSecretario();
			break;
		case 3:
			c.consultarSecretario();
			break;
		case 4:
			d.cadastrarDentista();
			break;
		case 5:
			//.editarDentista();
			break;
		case 6:
			System.out.println("Informe o CRO do Dentista");
			int cro = s.nextInt();
			d.consultar(cro);
			break;
		case 7:
			menuSecretario();
			break;
		case 8:
			menuDentista();
			break;
		case 9:
			System.exit(0);
			break;
		
		default:
			System.out.println("Opção inválida.");

		}

	}
}
