package br.com.uniciss.odontologico.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.funcionario.Secretario;

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
			System.out.println("Determine o valor: ");
			setValor(teclado.nextLine());
		} while (getValor() == "");   

		LeituraDeDados leitura = new LeituraDeDados();
		List<Tratamentos>listaTratamento = new ArrayList<Tratamentos>();
		Map<Integer, Tratamentos>mapaTratamento = new HashMap<Integer, Tratamentos>();

		leitura.leituraTratamento(listaTratamento, mapaTratamento);

		setCodigo(listaTratamento.size());
		
		Gravar g = new Gravar();
		g.grava("documentos/tratamentos.txt", toString());
		
		return;
	}

}
