package br.com.uniciss.odontologico.funcionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.cliente.Cliente;

public class Secretario extends Funcionario {

	Scanner teclado = new Scanner(System.in);

	public void cadastrarSecretario() throws FileNotFoundException, IOException {
		super.cadastraFuncionario();

		tipo = "secretario";
		setStatus(true);

		LeituraDeDados leitura = new LeituraDeDados();
		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();

		leitura.leituraSecretario(listaSecretario, mapaSecretario);

		setCodigo(listaSecretario.size());

		Gravar g = new Gravar();
		g.grava("documentos/secretarios.txt", toString());
		g.grava("documentos/users.txt", toString2());
		return;
	}

	public void consultarPaciente() {
		List<Cliente> listaPaciente = new ArrayList<Cliente>();

		LeituraDeDados leitura = new LeituraDeDados();
		leitura.leituraPacientes(listaPaciente);

		System.out.println("Informe o nome do Paciente");
		String nome = teclado.nextLine();
		nome = nome.replace(" ", "");
		nome = nome.toLowerCase();

		for (Cliente paciente : listaPaciente) {
			String nomeDaVez = paciente.getNome().replace(" ", "");

			if (nomeDaVez.toLowerCase().equals(nome)) {
				System.out.println("------- Paciente " + paciente.getNome()
						+ "------");
				if (!paciente.isStatus()) {
					System.out
							.println("Atenção estre paciente esta como inativo");
				}
				System.out.println("Codigo:" + paciente.getCodigo());
				System.out.println("Nome:" + paciente.getNome());
				System.out.println("RG:" + paciente.getRg());
				System.out.println("CPF:" + paciente.getCpf());
				System.out.println("Endereço:" + paciente.getEndereco());
				System.out.println("---------------------");
			}
		}

	}

	public void consultarSecretario() {

		int opc;
		LeituraDeDados leitura = new LeituraDeDados();

		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();

		leitura.leituraSecretario(listaSecretario, mapaSecretario);

		System.out.println("    SELECIONE UMA OPÇÃO ");
		System.out.println("1- Consultar Secretario por Nome");
		System.out.println("2- Consultar Secretario por ID");

		teclado = new Scanner(System.in);
		opc = teclado.nextInt();
		teclado.nextLine();

		switch (opc) {
		case 1:
			System.out.println("Informe o nome do Secretario");
			String nome = teclado.nextLine();
			nome = nome.replace(" ", "");
			nome = nome.toLowerCase();

			for (Secretario secretario : listaSecretario) {
				String nomeDaVez = secretario.getNome().replace(" ", "");

				if (nomeDaVez.toLowerCase().equals(nome)) {
					System.out.println("------- Secretario "
							+ secretario.getNome() + "------");
					if (!secretario.isStatus()) {
						System.out
								.println("Atenção estre paciente esta como inativo");
					}
					System.out.println("Codigo:" + secretario.getCodigo());
					System.out.println("Nome:" + secretario.getNome());
					System.out.println("RG:" + secretario.getRg());
					System.out.println("CPF:" + secretario.getCpf());
					System.out.println("Endereço:" + secretario.getEndereco());
					System.out.println("Hora Entrada:"
							+ secretario.getHoraDeEntrada());
					System.out.println("Hora Saida:"
							+ secretario.getHoraDeSaida());
					System.out.println("---------------------");
				}

			}
			break;
		case 2:
			Secretario secretario = new Secretario();

			System.out.println("Informe seu ID");
			int cro = teclado.nextInt();

			try {
				secretario = listaSecretario.get(cro);
				System.out.println("------- Secretario " + secretario.getNome()
						+ "------");
				if (!secretario.isStatus()) {
					System.out
							.println("Atenção estre paciente esta como inativo");
				}
				System.out.println("Codigo:" + secretario.getCodigo());
				System.out.println("Nome:" + secretario.getNome());
				System.out.println("RG:" + secretario.getRg());
				System.out.println("CPF:" + secretario.getCpf());
				System.out.println("Endereço:" + secretario.getEndereco());
				System.out.println("Hora Entrada:"
						+ secretario.getHoraDeEntrada());
				System.out.println("Hora Saida:" + secretario.getHoraDeSaida());
				System.out.println("---------------------");
			} catch (NullPointerException e) {
				System.out.println("Secretario não encontrado");
			}

			break;
		}

	}

	public String toStringSecretario() {
		return "Secretario" + "," + getCodigo() + "," + getNome() + ","
				+ getRg() + "," + getCpf() + "," + getEndereco() + ","
				+ getDataDeNascimento() + "," + isStatus() + ","
				+ getHoraDeEntrada() + "," + getHoraDeSaida();
	}

	public void inativarSecretario() throws IOException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();

		leitura.leituraSecretario(listaSecretario, mapaSecretario);
		;
		teclado = new Scanner(System.in);

		System.out.println("Informe o codigo do Secretario");
		int codSecretario = teclado.nextInt();

		boolean existe = false;

		for (Secretario s : listaSecretario) {
			if (s.getCodigo() == codSecretario) {

				existe = true;
				if (!s.isStatus()) {
					System.out.println("Este Secretario ja foi inativado");
				} else {
					s.setStatus(false);
					System.out.println("Paciente Inativado Com Sucesso");

					Gravar g = new Gravar();
					g.editar("documentos/secretarios.txt");

					for (Secretario ss : listaSecretario) {
						g.grava("documentos/secretarios.txt",
								ss.toStringSecretario());
					}

				}
			}
		}

		if (!existe) {
			System.out.println("Secretario Inexistente");
		}
	}

	public void inativarPaciente() throws IOException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Cliente> listaPacientes = new ArrayList<Cliente>();

		leitura.leituraPacientes(listaPacientes);
		teclado = new Scanner(System.in);

		System.out.println("Informe o codigo do Paciente");
		int codPaciente = teclado.nextInt();

		boolean existe = false;

		for (Cliente client : listaPacientes) {
			if (client.getCodigo() == codPaciente) {

				existe = true;
				if (!client.isStatus()) {
					System.out.println("Este Paciente ja foi inativado");
				} else {
					client.setStatus(false);
					System.out.println("Paciente Inativado Com Sucesso");
					Gravar g = new Gravar();
					g.editar("documentos/pacientes.txt");

					for (Cliente cc : listaPacientes) {
						g.grava("documentos/pacientes.txt",
								cc.toStringPaciente());
					}

				}
			}
		}
		if (!existe) {
			System.out.println("Paciente Inexistente");
		}
		Menus m = new Menus();
		m.menuAdmin();
	}

	public void editarPaciente() throws IOException {
		System.out.println("---------Editar Clientes--------");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Deseja Editar o nome? 1 - Sim, 2 - Não");
		int escolha = teclado.nextInt();
		switch (escolha) {
		case 1:
			System.out.println("Informe o nome : ");
			setNome(teclado.nextLine());

			break;
		case 2:

			break;
		default:
			System.out.println("Opção Errada!");
			break;
		}
		System.out.println("Deseja Editar o endereço? 1 - Sim, 2 - Não");
		int escolha2 = teclado.nextInt();
		switch (escolha2) {
		case 1:
			teclado.nextLine();
			System.out.println("Informe o Endereço: ");
			endereco = (teclado.next());
			break;
		case 2:

			break;
		default:
			System.out.println("Opção Errada!");
			break;
		}

		LeituraDeDados leitura = new LeituraDeDados();
		List<Cliente> listaPacientes = new ArrayList<Cliente>();

		leitura.leituraPacientes(listaPacientes);
		setCodigo(listaPacientes.size());

		Gravar g = new Gravar();
		g.grava("documentos/pacientes.txt", toString());

		Menus m = new Menus();
		m.menuSecretario();

	}

	public void alterarStatusPaciente() {

	}
}
