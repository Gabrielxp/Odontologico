package br.com.uniciss.odontologico.funcionario;

import java.util.Scanner;

import br.com.uniciss.odontologico.cliente.Pessoa;

abstract public class Funcionario extends Pessoa {
	protected String HoraDeEntrada;
	protected String HoraDeSaida;
	protected String login;
	protected String senha;
	protected String tipo;
	private Scanner teclado;

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
				+ isStatus();
	}

	public String toString2() {
		return "Usuario" + "," + getLogin() + "," + getSenha() + ","
				+ getTipo();
	}

	public void cadastraFuncionario() {
		teclado = new Scanner(System.in);

		do {
			System.out.println("Informe o nome do Funcionario: ");
			setNome(teclado.nextLine());
		} while (getNome().equals(""));

		do {
			System.out.println("Informe o Rg do Funcionario: ");
			setRg(teclado.nextLine());
		} while (getRg().equals(""));

		do {
			System.out.println("Informe o Cpf do Funcionario: ");
			setCpf(teclado.nextLine());
		} while (getCpf().equals(""));

		do {
			System.out.println("Informe o Endereço do Funcionario: ");
			setEndereco(teclado.nextLine());
		} while (getEndereco().equals(""));

		do {
			System.out.println("Informe o Login do Funcionario: ");
			setLogin(teclado.nextLine());
		} while (getLogin().equals(""));

		do {
			System.out.println("Informe a Senha do Funcionario: ");
			setSenha(teclado.nextLine());
		} while (getSenha().equals(""));

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

	}

}
