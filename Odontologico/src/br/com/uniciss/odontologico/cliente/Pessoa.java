package br.com.uniciss.odontologico.cliente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa {
	/**
	 * Variavel nome, relacionada ao nome da pessoa
	 */
	protected String nome;
	/**
	 * Variavel rg, relacionada ao rg da pessoa
	 */
	protected int id;
	/**
	 * Variavel id, relacionada ao id da pessoa
	 */
	protected String rg;
	/**
	 * Variavel cpf, relacionada ao cpf da pessoa
	 */
	protected String cpf;
	/**
	 * Variavel endereco, relacionada ao endereco da pessoa. ex.: Rua tal
	 */
	protected String endereco;
	/**
	 * Variavel codigo, relacionada ao codigo individual
	 */
	protected int codigo;
	/**
	 * Variavel status, relacionada ao status se esta pessoa esta ativa ou nao
	 */
	protected boolean status;
	/**
	 * Variavel dataDeNascimento, relacionada a data de nascimento da pessoa
	 */
	protected String dataDeNascimento;
	/**
	 * Variavel teclado, relacionada a entrada de dados do teclado
	 */
	protected String arquivo;

	private Scanner teclado;

	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Metodo public void cadastro(), utilizado para realizacao de cadastro de
	 * pessoas
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void cadastro() throws FileNotFoundException, IOException {
		teclado = new Scanner(System.in);

		do {
			System.out.println("Informe o nome : ");
			setNome(teclado.nextLine());

			if (!validaNome(nome))
				System.out
						.println("Nome invalido, por favor insira novamente!");
		} while (!validaNome(nome));

		// le e valida RG
		do {
			System.out.println("Insira o RG");
			this.rg = teclado.next();

			rg.replace("-", "");
			rg.replace(".", "");

			if (!validaRg(rg) || rg.length() >= 14 || rg.length() < 7)
				System.out.println("Rg invalido, por favor tente novamente");
		} while (!validaRg(rg) || rg.length() >= 14 || rg.length() < 7);

		// Le e valida CPF
		cpf = "0";
		// do{
		System.out.println("Insira o CPF");
		this.cpf = teclado.next();

		cpf = cpf.replace("-", "");
		cpf = cpf.replace(".", "");

		// if ((validaCpf() == false) || (validaCpfExistente() == true))
		// System.out.println("Cpf Invalido, por favor insira novamente");

		// }while ((validaCpf() == false) || (validaCpfExistente() == true));

		// Le o endereco
		teclado.nextLine();
		System.out.println("Informe o Endereço: ");
		endereco = (teclado.next());

		// ativa o status da pessoa
		setStatus(true);

		// Le e valida a data de nascimento

		Scanner pqp = new Scanner(System.in);

		do {
			System.out.println("Insira a data de nascimento(DD/MM/AAAA)");
			dataDeNascimento = pqp.next();

			if (validaData() == false)
				System.out.println("Data invalida! Tente novamente");
		} while (validaData() == false);

	}

	/**
	 * Metodo public boolean validaCpf(), utilizado para realizacao de validacao
	 */
	public boolean validaCpf() {

		if (cpf.equals("00000000000") || cpf.equals("11111111111")
				|| cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999")
				|| (cpf.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			} else {
				dig10 = (char) (r + 48);
			}

			sm = 0;
			peso = 11;

			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char) (r + 48);
			}

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
				return (true);
			} else {
				return (false);
			}
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public boolean validaRg(String texto) {
		return texto.matches("^[0-9]*$");
	}

	public boolean validaNome(String txt) {
		return txt.matches("[a-z A-Z]+");
	}

	@SuppressWarnings("resource")
	public boolean validaCpfExistente() throws IOException,
			FileNotFoundException {

		BufferedReader dentista = new BufferedReader(new FileReader(
				"documentos/dentistas.txt"));
		BufferedReader secretario = new BufferedReader(new FileReader(
				"documentos/secretarios.txt"));
		BufferedReader paciente = new BufferedReader(new FileReader(
				"documentos/pacientes.txt"));

		while (dentista.ready()) {
			String linha = dentista.readLine();
			if (linha.contains(cpf)) {
				return true;
			}

		}
		dentista.close();

		while (secretario.ready()) {
			String linha = secretario.readLine();
			if (linha.contains(cpf)) {
				return true;
			}
		}
		secretario.close();

		while (paciente.ready()) {
			String linha = paciente.readLine();
			if (linha.contains(cpf)) {
				return true;
			}
		}
		paciente.close();

		return false;
	}

	public boolean validaData() {
		DateFormat data = new SimpleDateFormat("yyyy/MM/dd");
		data.setLenient(false);

		SimpleDateFormat formata = new SimpleDateFormat("yyyy/MM/dd");

		Date dataInformada = new Date();
		formata = new SimpleDateFormat("yyyy/MM/dd");
		formata.setLenient(false);

		try {
			dataInformada = formata.parse(dataDeNascimento);
			data.parse(dataDeNascimento);

			if ((new Date()).getTime() > dataInformada.getTime()) {
				return true;
			}

		} catch (ParseException e) {
			return false;
		}
		return false;

	}

}
