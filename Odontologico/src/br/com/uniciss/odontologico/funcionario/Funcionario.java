package br.com.uniciss.odontologico.funcionario;

import java.util.Date;

import br.com.uniciss.odontologico.cliente.Pessoa;


abstract public class Funcionario extends Pessoa {
	protected Date HoraDeEntrada;
	protected Date HoraDeSaida;
	protected String login;
	protected String senha;
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
	
	public void cadastraFuncionario(){
		
	}

	
}
