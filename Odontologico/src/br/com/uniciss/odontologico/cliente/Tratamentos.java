package br.com.uniciss.odontologico.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Tratamentos {

	protected String valor;
	/**
	 * Variavel valor, relacionada valor do tratamento
	 */
	protected String tratamento;
	/**
	 * Variavel tratamento, relacionada ao nome do tratamento
	 */
	protected int codigo;
	/**
	 * Variavel codigo, relacionada ao codigo individual
	 */
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
	/**
	 * Metodo para salvar os dados do Tratamento
	 * @method toString();
	 */
	public String toString() {
		return "Tratamento" + "," + getCodigo() + "," + getTratamento() + ","
				+ getValor();
	}

	/**
	 * Metodo para cadastrar um novo Tratamento
	 * @method cadastraTratamentos();
	 */
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
		
		Menus m = new Menus();
		m.menuDentista();
	}

}
