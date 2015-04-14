package br.com.uniciss.odontologico.funcionario;

import java.util.Date;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.cliente.Pessoa;


abstract public class Funcionario extends Pessoa {
	protected Date HoraDeEntrada;
	protected Date HoraDeSaida;
	protected String login;
	protected String senha;
	protected String tipo;
	
	//Getters And Setters
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
	protected Date getHoraDeEntrada() {
		return HoraDeEntrada;
	}
	public void setHoraDeEntrada(Date horaDeEntrada) {
		HoraDeEntrada = horaDeEntrada;
	}
	public Date getHoraDeSaida() {
		return HoraDeSaida;
	}
	public void setHoraDeSaida(Date horaDeSaida) {
		HoraDeSaida = horaDeSaida;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Metodo toString para cadastro de Funcionarios
	public String toString(){
		return "Funcionario"+","+getCodigo()+","+getNome()+","+getRg()+","+getCpf()+","+getEndereco()+","+isStatus();
	}
	
	public String toString2(){
		return "Usuario"+","+getLogin()+","+getSenha()+","+getTipo();
	}
	
	public void cadastraFuncionario(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o codigo do Funcionario: ");
		setCodigo(teclado.nextInt());
		System.out.println("Informe o nome do Funcionario: ");
		setNome(teclado.nextLine());
		System.out.println("Informe o Rg do Funcionario: ");
		setRg(teclado.nextLine());
		System.out.println("Informe o Cpf do Funcionario: ");
		setCpf(teclado.nextLine());
		System.out.println("Informe o Endereço do Funcionario: ");
		setEndereco(teclado.nextLine());
		
		System.out.println("Informe o Login do Funcionario: ");
		setLogin(teclado.nextLine());
		System.out.println("Informe a Senha do Funcionario: ");
		setSenha(teclado.nextLine());
		System.out.println("Informe o Tipo do Funcionario: ");
		setTipo(teclado.nextLine());
		
		Gravar g = new Gravar();
		g.grava("Funcionarios.txt", toString());
		g.grava("Usuarios.txt", toString2());
		teclado.close();
		
		
	}
	
	

	
}
