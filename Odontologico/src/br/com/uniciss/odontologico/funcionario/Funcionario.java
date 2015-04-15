package br.com.uniciss.odontologico.funcionario;

import java.util.Scanner;

import br.com.uniciss.odontologico.cliente.Pessoa;

abstract public class Funcionario extends Pessoa {
	/**
	 * Variavel HoraDeEntrada, relacionada a hora de entrada do trabalho
	 */
	protected String HoraDeEntrada;
	/**
	 * Variavel HoraDeSaida, relacionada a hora de saida do trabalho
	 */
	protected String HoraDeSaida;
	/**
	 * Variavel login, relacionada ao acesso de determinado nivel
	 */
	protected String login;
	/**
	 * Variavel senha, relacionada ao acesso de determinado nivel
	 */
	protected String senha;
	/**
	 * Variavel tipo, relacionada ao tipo de funcionario
	 */
	protected String tipo;
	/**
	 * Variavel teclado, relacionada a entrada de dados por meio do teclado
	 */
	protected Scanner teclado;

	// Getters And Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected String getHoraDeEntrada() {
		return HoraDeEntrada;
	}

	public void setHoraDeEntrada(String string) {
		HoraDeEntrada = string;
	}

	public String getHoraDeSaida() {
		return HoraDeSaida;
	}

	public void setHoraDeSaida(String horaDeSaida) {
		HoraDeSaida = horaDeSaida;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Metodo toString para cadastro de Funcionarios
	public String toString() {
		return "Funcionario" + "," + getCodigo() + "," + getNome() + ","
				+ getRg() + "," + getCpf() + "," + getEndereco() + ","
				+ getDataDeNascimento()+","+ isStatus();
	}

	public String toString2() {
		return "Usuario" + "," + getLogin() + "," + getSenha() + ","
				+ getTipo();
	}

	/**
	 * Metodo cadastraFuncionario relacionado ao cadastro de funcionarios
	 */
	public void cadastraFuncionario() {
		teclado = new Scanner(System.in);

		// Metodo com o cadastro de pessoa herdado
		cadastro();

		do {
			System.out.println("Informe o Tipo do Funcionario: ");
			setTipo(teclado.nextLine());

		} while (getTipo().equals(""));

		do {
			System.out.println("Informe a Hora de Entrada no trabalho: ");
			setHoraDeEntrada(teclado.nextLine());
		} while (getHoraDeEntrada().equals(""));

		do {
			System.out.println("Informe a Hora de Saida no trabalho: ");
			setHoraDeSaida(teclado.nextLine());
		} while (getHoraDeEntrada().equals(""));
		setStatus(true);
		do {
			System.out.println("Informe o Login: ");
			setLogin(teclado.nextLine());

		} while (getLogin().equals(""));
		do {
			System.out.println("Informe a Senha: ");
			setSenha(teclado.nextLine());

		} while (getSenha().equals(""));
	}

}
