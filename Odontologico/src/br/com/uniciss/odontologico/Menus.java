package br.com.uniciss.odontologico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Funcionario;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Menus {

	ArrayList<Funcionario> listaUsuario = new ArrayList<Funcionario>();
	Map<String, Funcionario> mapaUsuario = new HashMap<String, Funcionario>();

	Scanner s = new Scanner(System.in);

	public void Login() throws IOException {
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
				// Chamada do menu, conforme o tipo de Usuário

				if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("dentista"))) {
					menuDentista();

				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("secretario"))) {
					menuSecretario();
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

	//Menu dentista
	public void menuDentista() {

		Dentista d = new Dentista();

		int opc;
		System.out.println();
		System.out.println("-' Dentista '- ");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Consultar");
		System.out.println("2 - Editar Paciente");
		System.out.println("3 - Requisitar Materiais");
		System.out.println("4 - Encaminhar Paciente");
		System.out.println("5 - Sair");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch (opc) {
		case 1:
			d.consultar();
			break;
		case 2:
			d.editarPaciente();
			break;
		case 3:
			d.requisitarMateriais();
			break;
		case 4:
			d.encaminharPaciente();
			break;
		case 5:
			return;
		default:
			System.out.println("Opção inválida.");
		}
	}
	
	
	//Menu Secretario
	public void menuSecretario() {

		Secretario c = new Secretario();

		int opc;
		System.out.println();
		System.out.println("-' Secretario '- ");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Listar Pacientes");
		System.out.println("2 - Editar Paciente");
		System.out.println("3 - Alterar Status Paciente");
		System.out.println("4 - Sair");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch (opc) {
		case 1:
			c.listarPaciente();
			break;
		case 2:
			c.editarPaciente();
			break;
		case 3:
			c.alterarStatusPaciente();
		break;
		case 4:
			return;
		default:
			System.out.println("Opção inválida.");
		}
	}

}
