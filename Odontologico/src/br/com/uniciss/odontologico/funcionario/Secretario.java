package br.com.uniciss.odontologico.funcionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Conectar;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.BD.Scripts;
import br.com.uniciss.odontologico.admin.Agendamento;
import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.cliente.Tratamentos;

public class Secretario extends Funcionario {

	Scanner teclado = new Scanner(System.in);

	public void cadastrarSecretario() throws FileNotFoundException,
			IOException, ClassNotFoundException, SQLException {
		System.out.println("---------CADASTRAR DENTISTA----------");
		super.cadastraFuncionario();
		// FALTA IMPLEMENTAR O VALIDA CRO!
		System.out.println("Determine o CRO");
		Scanner entrada = new Scanner(System.in);
		setId(entrada.nextInt());

		String insert = "INSERT INTO pessoa (nome, cpf, endereco, data_nascimento) VALUES ('"
				+ getNome()
				+ "', '"
				+ getCpf()
				+ "' ,'"
				+ getEndereco()
				+ "' ,'" + getDataDeNascimento() + "')";

		Scripts.insert(insert);

		String select = "SELECT id_pessoa FROM pessoa where cpf='" + cpf + "'";
		Scripts.select(select);
		String seleciona = "SELECT id_pessoa FROM pessoa where cpf='" + cpf
				+ "'";
		int pegaId = Scripts.select(select);

		String inserta = "INSERT INTO dentista (id_pessoa, cro, hora_entrada, hora_saida) VALUES ('"
				+ pegaId
				+ "','"
				+ getId()
				+ "','"
				+ getHoraDeEntrada()
				+ "','"
				+ getHoraDeSaida() + " ')";
		Scripts.insert(inserta);

		// SALVA LOGIN E SENHA
		String pega = "SELECT nome FROM pessoa where cpf='" + cpf + "'";
		Scripts.selectNome(pega);

		String peganome = Scripts.selectNome(pega);

		String inserta2 = "INSERT INTO users (tipo_users, nome_usuario, senha) VALUES ('"
				+ "secretario" + "','" + peganome + "','" + getSenha() + " ')";
		Scripts.insert(inserta2);
		Menus menu = new Menus();
		menu.menuAdmin();

	}

	public void consultarPaciente() {
		List<Cliente> listaPaciente = new ArrayList<Cliente>();

		LeituraDeDados leitura = new LeituraDeDados();
		leitura.leituraPacientes(listaPaciente);

		System.out.println("Informe o nome do Paciente");
		String nome = teclado.nextLine();
		nome = nome.replace(" ", "");
		nome = nome.toLowerCase();

		
		

	}

	public void consultarSecretario() throws FileNotFoundException,
			IOException, ClassNotFoundException, SQLException {
		System.out.println("Determine o nome do secretario: ");
		Scanner entrada = new Scanner(System.in);
		int pega = 0;
		String nomex = entrada.nextLine();
		String select2 = "SELECT nome FROM pessoa where nome='" + nomex
				+ "'";
		String pegan = Scripts.selectNome(select2);
		
		
		String select = "SELECT id_pessoa FROM pessoa where nome='" + nomex
				+ "'";
		pega = Scripts.select(select);

		String emprime = "SELECT id_pessoa, nome, cpf, endereco FROM pessoa where id_pessoa='"
				+ pega + "'";

		nome = "";
		String cpf = "";
		int idPessoa = 0;
		int endereco = 0;
		String horaEntrada = "";
		String horaSaida = "";
		Connection conexao = new Conectar().conectar();
		PreparedStatement ps = conexao.prepareStatement(emprime);
		if (idPessoa==0){
			System.out.println("Pessoa Inexistente");
			consultarSecretario();
		}
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			idPessoa = rs.getInt("id_pessoa");
			nome = rs.getString("nome");
			cpf = rs.getString("cpf");
			endereco = rs.getInt("endereco");
			
			System.out.println("Nome: " + nome);
		
		}
		System.out.println("Codigo:" + idPessoa);
		System.out.println("Nome:" + nome);
		System.out.println("CPF:" + cpf);
		System.out.println("Endereço:" + endereco);
		System.out.println("Hora Entrada:" + horaEntrada);
		System.out.println("Hora Saida:" + horaSaida);
		System.out.println("---------------------");

	}


	public void inativarSecretario() throws IOException {
	
		teclado = new Scanner(System.in);

		System.out.println("Informe o codigo do Secretario");
		int codSecretario = teclado.nextInt();

		

	
		
	}

	public void inativarPaciente() throws IOException, ClassNotFoundException,
			SQLException {
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
						g.grava("documentos/pacientes.txt", cc.toString());
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

	public void ativarPaciente() throws IOException, ClassNotFoundException,
			SQLException {
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
						g.grava("documentos/pacientes.txt", cc.toString());
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

	public void listarConsulta() throws IOException, ClassNotFoundException,
			SQLException {
		Scanner teclado = new Scanner(System.in);

		List<Agendamento> listaConsultas = new ArrayList<Agendamento>();
		List<Tratamentos> listaTratamento = new ArrayList<Tratamentos>();
		Map<Integer, Tratamentos> mapaTratamento = new HashMap<Integer, Tratamentos>();
		List<Cliente> listaPacientes = new ArrayList<Cliente>();
		Map<Integer, Cliente> mapaPacientes = new HashMap<Integer, Cliente>();

		// Informaçoes de Dentistas
		List<Dentista> listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista> mapaDentista = new HashMap<Integer, Dentista>();

		LeituraDeDados leitura = new LeituraDeDados();
		leitura.leituraConsultas(listaConsultas);
		leitura.leituraTratamento(listaTratamento, mapaTratamento);
		leitura.leituraPacientes(listaPacientes);
		leitura.leituraDentista(listaDentista, mapaDentista);

		for (Cliente c : listaPacientes) {
			mapaPacientes.put(c.getCodigo(), c);
		}

		System.out.println("Informe a data");
		String data = teclado.nextLine();

		for (Agendamento consulta : listaConsultas) {
			if (consulta.getDataDoAgendamento().equals(data)) {
				System.out.println("--------------------------------------");
				System.out.println("Horario: " + consulta.getHora());
				System.out.println("Tratamento: "
						+ mapaTratamento.get(consulta.getIdTratamento())
								.getTratamento());
				System.out
						.println("Paciente: "
								+ mapaPacientes.get(consulta.getIdPaciente())
										.getNome());
				System.out
						.println("Dentista: "
								+ mapaDentista.get(consulta.getCroDentista())
										.getNome());
			}
		}
		Menus m = new Menus();
		m.menuSecretario();
	}
}
