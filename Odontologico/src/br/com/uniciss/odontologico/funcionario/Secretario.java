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
import br.com.uniciss.odontologico.admin.Agendamento;
import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.cliente.Tratamentos;

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
		
		System.out.println();
		System.out.println("Cadastro efetuado com sucesso!!");
		System.out.println();
		
		
		Menus m = new Menus();
		m.menuAdmin();
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

	public void consultarSecretario() throws FileNotFoundException, IOException {

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
			Menus m = new Menus();
			m.menuAdmin();
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
			Menus g = new Menus();
			g.menuAdmin();

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
	
	public void ativarSecretario() throws IOException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();

		leitura.leituraSecretario(listaSecretario, mapaSecretario);
		;
		teclado = new Scanner(System.in);

		System.out.println("Informe o codigo do Secretario");
		int codSecretario = teclado.nextInt();

		boolean existe = true;

		for (Secretario s : listaSecretario) {
			if (s.getCodigo() == codSecretario) {

				existe = false;
				if (s.isStatus()) {
					System.out.println("Este Secretario ja foi Ativado");
				} else {
					s.setStatus(true);
					System.out.println("Secretario Ativado Com Sucesso");

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
					System.out.println();
					System.out.println("Paciente Inativado Com Sucesso!");
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
		m.menuSecretario();
	}
	
	public void ativarPaciente() throws IOException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Cliente> listaPacientes = new ArrayList<Cliente>();

		leitura.leituraPacientes(listaPacientes);
		teclado = new Scanner(System.in);

		System.out.println("Informe o codigo do Paciente");
		int codPaciente = teclado.nextInt();

		boolean existe = true;

		for (Cliente client : listaPacientes) {
			if (client.getCodigo() == codPaciente) {

				existe = false;
				if (client.isStatus()) {
					System.out.println("Este Paciente ja foi ativado");
				} else {
					client.setStatus(true);
					System.out.println();
					System.out.println("Paciente Ativado Com Sucesso!");
					Gravar g = new Gravar();
					g.editar("documentos/pacientes.txt");

					for (Cliente cc : listaPacientes) {
						g.grava("documentos/pacientes.txt",
								cc.toStringPaciente());
					}

				}
			}
		}
		if (existe) {
			
			System.out.println("Paciente Inexistente");
		}
		Menus m = new Menus();
		m.menuSecretario();
	}
	
	public void listarConsulta() throws IOException {
		Scanner teclado = new Scanner(System.in);
		
		List<Agendamento> listaConsultas = new ArrayList<Agendamento>();
		List<Tratamentos> listaTratamento = new ArrayList<Tratamentos>();
		Map<Integer, Tratamentos>mapaTratamento = new HashMap<Integer, Tratamentos>();
		List<Cliente> listaPacientes = new ArrayList<Cliente>();
		Map<Integer, Cliente>mapaPacientes = new HashMap<Integer, Cliente>();
		
		//Informaçoes de Dentistas
		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();
		
		LeituraDeDados leitura = new LeituraDeDados();
		leitura.leituraConsultas(listaConsultas);
		leitura.leituraTratamento(listaTratamento, mapaTratamento);
		leitura.leituraPacientes(listaPacientes);
		leitura.leituraDentista(listaDentista, mapaDentista);
		
		for(Cliente c : listaPacientes){
			mapaPacientes.put(c.getCodigo(), c);
		}
		
		System.out.println("Informe a data");
		String data = teclado.nextLine();
		
		for(Agendamento consulta : listaConsultas){
			if(consulta.getDataDoAgendamento().equals(data)){
				System.out.println("--------------------------------------");
				System.out.println("Horario: "+consulta.getHora());
				System.out.println("Tratamento: "+mapaTratamento.get(consulta.getIdTratamento()).getTratamento());
				System.out.println("Paciente: "+mapaPacientes.get(consulta.getIdPaciente()).getNome());
				System.out.println("Dentista: "+mapaDentista.get(consulta.getCroDentista()).getNome());
			}
		}
		Menus m = new Menus();
		m.menuSecretario();
	}
}
