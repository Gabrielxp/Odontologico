package br.com.uniciss.odontologico.cliente;

import java.io.IOException;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;

public class Tratamentos {

	protected String valor;
	protected String tratamento;
	protected int codigo;
	Scanner teclado = new Scanner(System.in);

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	
	public String toString() {
		return "Tratamento" + "," + getCodigo() + "," + getTratamento() + ","
				+ getValor();
	}

	public void cadastraTratamentos() throws IOException {
		do {
			System.out.println("Escreva o Tratamento a ser feito: ");
			setTratamento(teclado.nextLine());
		} while (getTratamento() == "");

		do {
			System.out.println("Determine o valor por mês: ");
			setValor(teclado.nextLine());
		} while (getValor() == "");

		Gravar g = new Gravar();
		g.grava("tratamentos.txt", toString());
		
		return;
	}

}
