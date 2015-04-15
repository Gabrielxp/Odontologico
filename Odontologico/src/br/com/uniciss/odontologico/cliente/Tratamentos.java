package br.com.uniciss.odontologico.cliente;

import java.util.Scanner;

public class Tratamentos {

	protected String tempo;
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

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
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

	public void cadastraTratamentos() {
		do {
			System.out.println("Escreva o Tratamento a ser feito: ");
			setTratamento(teclado.nextLine());
		} while (getTratamento() == "");

		do {
			System.out.println("Determine o valor por mês: ");
			setValor(teclado.nextLine());
		} while (getValor() == "");

		// SALVAR O TRATAMENTO NO TXT E GERAR UM CODIGO PARA ELE
		return;
	}

	public void selecionaTratamento() {
		// RELACIONAR O CLIENTE COM O TRATAMENTO
		//EMPRIMIR A LISTA DE TRATAMENTOS
		//SELECIONAR UM
		
		do {
			System.out.println("Determine o tempo de tratamento em meses: ");
			setTempo(teclado.nextLine());
		} while (getTempo() == "");

		// SALVAR NO CLIENTE OS TRATAMENTOS A SEREM FEITOS
		return;
	}
}
