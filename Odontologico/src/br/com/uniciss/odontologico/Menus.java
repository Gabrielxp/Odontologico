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
				// Chamada do menu, conforme o tipo de Usu�rio

				if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("1"))) {
					menuDentista();

				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("2"))) {
					menuSecretario();
				}
			} else {
				System.out.println("Usuario e/ou senha invalido(s)!");
				System.out.println("");
				Login();
			}

		} catch (InputMismatchException e) {

			s.nextLine();
			System.out.println("Voc� informou algum caracter inv�lido(s)! ");

		} catch (NullPointerException b) {

			System.out.println("Login inexistente!");
		}

	}

	public void menuDentista() {

		Dentista d = new Dentista();

		int opc;
		System.out.println();
		System.out.println("-' Dentista '- ");
		System.out.println("Escolha uma op��o:");
		System.out.println("1 - Consultar");
		System.out.println("2 - Editar Paciente");
		System.out.println("3 - Requisitar Materiais");
		System.out.println("4 - Encaminhar Paciente");

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

		default:
			System.out.println("Op��o inv�lida.");
		}
	}

	public void menuSecretario() {

		Secretario c = new Secretario();

		int opc;
		System.out.println();
		System.out.println("-' Secretario '- ");
		System.out.println("Escolha uma op��o:");
		System.out.println("1 - Listar Pacientes");
		System.out.println("2 - Editar Paciente");
		System.out.println("3 - Alterar Status Paciente");

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
			

		default:
			System.out.println("Op��o inv�lida.");
		}
	}

}
