package br.com.uniciss.odontologico.admin;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.funcionario.Secretario;


public class Admin {
 Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
	
}  
	void updateSecretario() throws FileNotFoundException, IOException,
	ClassNotFoundException, SQLException{
		System.out.println("Insira o nome da pessoa para editar");
	
	}



	
	Scanner entrada = new Scanner(System.in);
	// Metodo que edita um Dentista caso ele exista e esteja com o status Ativo

	public void editarSecretario() throws FileNotFoundException, IOException,
			ClassNotFoundException, SQLException {

		String nome;
		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();
		leia.leituraSecretario(listaSecretario, mapaSecretario);
		Menus m = new Menus();
		System.out.println("Determine o nome da pessoa a ser editado: ");
		nome = entrada.nextLine();
		boolean continua = false;

		for (Secretario s : listaSecretario) {

			if (nome.equals(s.getNome())) {
				if (s.isStatus()) {
					s.editarFuncionario();
					continua = true;
				} else {
					System.out
							.println("Esse Dentista esta cadastrado porem esta inativo");
					continua = false;
				}

			}
			Gravar g = new Gravar();
			g.editar("documentos/secretarios.txt");
			for (Secretario f : listaSecretario) {
				g.grava("documentos/secretarios.txt", f.toString());
			}

		}

		if (continua == false) {

			int escolha;

			System.out
					.println("Determinaste um nome invalido ou o dentista esta inativo"
							+ "\n Deseja voltar ao menu? 1 - sim, 2 - não");
			escolha = entrada.nextInt();
			entrada.nextLine();
			if (escolha == 1) {
				m.menuAdmin();
			} else if (escolha != 1) {
				editarSecretario();
			}
		}
		if (continua == true) {
			System.out.println("\n Edição realizada com sucesso!\n");
			m.menuAdmin();
		}
	}

	// Metodo que edita um Dentista caso ele exista e esteja com o status Ativo

	public void editarDentista() throws FileNotFoundException, IOException,
			ClassNotFoundException, SQLException {

	}

	// Metodo que edita um Paciente caso ele exista e esteja com o status Ativo
	public void editarPaciente() throws FileNotFoundException, IOException,
			ClassNotFoundException, SQLException {
		String nome;
		List<Cliente> listaPacientes = new ArrayList<Cliente>();
		Menus m = new Menus();

		leia.leituraPacientes(listaPacientes);

		System.out.println("Determine o codigo da pessoa a ser editado: ");
		nome = entrada.nextLine();
		boolean continua = false;

		for (Cliente cliente : listaPacientes) {

			if (nome.equals(cliente.getNome())) {
				if (cliente.isStatus()) {
					Secretario secretario = new Secretario();
					cliente.editarPaciente();

					Gravar g = new Gravar();
					g.editar("documentos/pacientes.txt");
					for (Cliente f : listaPacientes) {
						g.grava("documentos/pacientes.txt", f.toString());
					}
					continua = true;
				} else {
					System.out
							.println("Esse Paciente esta cadastrado porem esta inativo");
					continua = false;
				}

			}

		}

		if (continua == false) {

			int escolha;

			System.out
					.println("Determinaste um nome invalido ou o Paciente esta inativo"
							+ "\n Deseja voltar ao menu? 1 - sim, 2 - não");
			escolha = entrada.nextInt();
			entrada.nextLine();
			if (escolha == 1) {
				m.menuAdmin();
			} else if (escolha != 1) {
				editarPaciente();
			}
		}
		if (continua == true) {
			System.out.println("\n Edição realizada com sucesso!\n");
			m.menuSecretario();
		}
	}

}
