package br.com.uniciss.odontologico.funcionario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Conectar;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.BD.Scripts;
import br.com.uniciss.odontologico.cliente.Cliente;

public class Dentista extends Funcionario {
	private static Connection conexao;
	/**
	 * Variavel cro, relacionada ao cro do dentista
	 */
	protected int cro;
	String croTexto;
	private BufferedReader buffR;

	public void cadastrarDentista() throws FileNotFoundException, IOException, //OK
			SQLException, ClassNotFoundException {
		System.out.println("---------CADASTRAR DENTISTA----------");
		super.cadastraFuncionario();
		//FALTA IMPLEMENTAR O VALIDA CRO!
		System.out.println("Determine o CRO");
		Scanner entrada = new Scanner(System.in);
		setCro(entrada.nextInt());
		
		
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
				+ pegaId + "','" + getCro() + "','" + getHoraDeEntrada() + "','" + getHoraDeSaida() + " ')";
		Scripts.insert(inserta);

		//SALVA LOGIN E SENHA
		String pega = "SELECT nome FROM pessoa where cpf='" + cpf + "'";
		Scripts.selectNome(pega);
	//String seleciona2 = "SELECT id_pessoa FROM pessoa where cpf='" + cpf
	//			+ "'";
		String peganome = Scripts.selectNome(pega);
		
		String inserta2 = "INSERT INTO users (tipo_users, nome_usuario, senha) VALUES ('"
				+"dentista"+"','"+ peganome + "','" + getSenha() +" ')";
		Scripts.insert(inserta2);
		Menus menu = new Menus();
		menu.menuAdmin();

		
	}

	// Metodo toString para cadastro de Funcionarios
	

	public void consultar(int cro) throws ClassNotFoundException, SQLException { //OK
			
		String select = "SELECT id_pessoa FROM dentista where cro='" + cro + "'";
		int pega = Scripts.select(select);
		
		String emprime = "SELECT id_pessoa, nome, cpf, endereco FROM pessoa where id_pessoa='" + pega + "'";
	
			String nome = "";
			String cpf = "";
			int idPessoa =0;
			int endereco = 0;
			conexao = new Conectar().conectar();
			PreparedStatement ps = conexao.prepareStatement(emprime);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				idPessoa = rs.getInt("id_pessoa");
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				endereco = rs.getInt("endereco");
				System.out.println("Nome: " + nome);

			}		
			
			
				System.out.println("-------Dentista " + nome
						+ "------");
				System.out.println("Codigo:" + idPessoa);
				System.out.println("Nome:" + nome);
				System.out.println("CRO:" + cro);
			//	System.out.println("RG:" + dentista.getRg());
				System.out.println("CPF:" + cpf);
				System.out.println("Endereço:" + endereco);
				System.out.println("---------------------");
		

	}

	public void inativarDentista() throws IOException, SQLException,
			ClassNotFoundException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Dentista> listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista> mapaDentista = new HashMap<Integer, Dentista>();

		leitura.leituraDentista(listaDentista, mapaDentista);
		teclado = new Scanner(System.in);

		System.out.println("Digite o CRO do dentista");
		int cro = teclado.nextInt();

		boolean existe = false;

		
		
	}

	public void ativarDentista() throws IOException, SQLException,
			ClassNotFoundException {
		LeituraDeDados leitura = new LeituraDeDados();

		List<Dentista> listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista> mapaDentista = new HashMap<Integer, Dentista>();

		leitura.leituraDentista(listaDentista, mapaDentista);
		teclado = new Scanner(System.in);

		System.out.println("Digite o CRO do dentista");
		int cro = teclado.nextInt();

		boolean existe = true;

		Menus m = new Menus();
		m.menuAdmin();
	}

	@SuppressWarnings("resource")
	public boolean validaCroExistente() throws IOException {
		BufferedReader d = new BufferedReader(new FileReader(
				"documentos/dentistas.txt"));

		while (d.ready()) {
			String linha = d.readLine();
			if (linha.contains(croTexto)) {
				return true;
			}
		}
		d.close();
		return false;
	}

	public boolean validaCro(String texto) {
		return texto.matches("^[0-9]*$");
	}

	public void encaminharPaciente(String nome) throws IOException,
			ClassNotFoundException, SQLException {
		List<Cliente> listaPaciente = new ArrayList<Cliente>();

		LeituraDeDados leitura = new LeituraDeDados();
		leitura.leituraPacientes(listaPaciente);

		nome = nome.replace(" ", "");
		nome = nome.toLowerCase();

		for (Cliente paciente : listaPaciente) {
			String nomeDaVez = paciente.getNome().replace(" ", "");

			if (nomeDaVez.toLowerCase().equals(nome)) {
				System.out.println("------- Paciente " + paciente.getNome()
						+ "------");
				if (!paciente.isStatus()) {
					System.out
							.println("Atenção este paciente esta como inativo");
				}

				System.out.println("Codigo:" + paciente.getCodigo());
				System.out.println("Nome:" + paciente.getNome());
				System.out.println("RG:" + paciente.getRg());
				System.out.println("CPF:" + paciente.getCpf());
				System.out.println("Endereço:" + paciente.getEndereco());
				System.out.println("---------------------");
				System.out.println("Ficha de Encaminhamento Gerada");

				Date date = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd.MM.YYYY");
				FileWriter arquivo;
				arquivo = new FileWriter(new File(formato.format(date)
						+ paciente.getNome() + ".txt"));
				arquivo.write("-------Ficha Encaminhamento "
						+ paciente.getNome()
						+ "----------"
						+ "\nCodigo: "
						+ paciente.getCodigo()
						+ "\nNome:"
						+ paciente.getNome()
						+ "\nRG:"
						+ paciente.getRg()
						+ "\nCPF:"
						+ paciente.getCpf()
						+ "\nEndereço:"
						+ paciente.getEndereco()
						+ "\nTratamento:___________________________________________"
						+ "\nObservações:__________________________________________"
						+ "\n                     Assinatura           "
						+ "\n                ___________________"
						+ "\n                    " + formato.format(date)

				);
				arquivo.close();
				Menus m = new Menus();
				m.menuDentista();

			} else {
				System.out.println("Paciente Inexistente");
				Menus m = new Menus();
				m.menuDentista();

			}

		}

	}

	public int getCro() {
		return cro;
	}

	public void setCro(int cro) {
		this.cro = cro;
	}

}
