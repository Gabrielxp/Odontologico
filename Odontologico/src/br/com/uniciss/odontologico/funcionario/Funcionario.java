package br.com.uniciss.odontologico.funcionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import br.com.uniciss.odontologico.cliente.Pessoa;

abstract public class Funcionario extends Pessoa {
	/**
	 * Variavel HoraDeEntrada, relacionada a hora de entrada do trabalho
	 */
	protected String horaDeEntrada;
	/**
	 * Variavel HoraDeSaida, relacionada a hora de saida do trabalho
	 */
	protected String horaDeSaida;
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
	
	String hora;
	double horaG;
	
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

	public String getHoraDeEntrada() {
		return horaDeEntrada;
	}

	public void setHoraDeEntrada(String string) {
		horaDeEntrada = string;
	}

	public String getHoraDeSaida() {
		return horaDeSaida;
	}

	public void setHoraDeSaida(String horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
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
				+ getDataDeNascimento()+","+ isStatus()+","+getHoraDeEntrada()+","+getHoraDeSaida();
	}

	public String toString2() {
		return "Usuario" + "," + getLogin() + "," + getSenha() + ","
				+ getTipo();
	}

	/**
	 * Metodo cadastraFuncionario relacionado ao cadastro de funcionarios
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void cadastraFuncionario() throws FileNotFoundException, IOException {
		teclado = new Scanner(System.in);

		// Metodo com o cadastro de pessoa herdado
		cadastro();

		do {
			System.out.println("Informe a Hora de Entrada no trabalho(HH:MM)");
			setHoraDeEntrada(teclado.nextLine());
	
			
		} while (validaHora() == false);

		do {
			System.out.println("Informe a Hora de Saida no trabalho(HH:MM)");
			setHoraDeSaida(teclado.nextLine());
			
		}while (validaHora() == false);
			
		//Cadastro de login
		do {
			System.out.println("Informe o Login: ");
			setLogin(teclado.nextLine());

		} while (getLogin().equals(""));
		do {
			System.out.println("Informe a Senha: ");
			setSenha(teclado.nextLine());

		} while (getSenha().equals(""));
	}

	
	public boolean validaHora(){
		SimpleDateFormat h = new SimpleDateFormat("HH:mm");
		h.setLenient(false);
		
		try{
			h.parse(hora);
			return true;
		}catch (ParseException e){
			System.out.println("Hora invalida, por favor insira novamente");
			return false;
		}
	}
}
