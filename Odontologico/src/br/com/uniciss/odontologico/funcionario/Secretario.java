package br.com.uniciss.odontologico.funcionario;

import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;

public class Secretario extends Funcionario {
	Scanner entrada = new Scanner(System.in);

	public void cadastrarSecretario() {
		super.cadastraPessoa();
		
		Gravar g = new Gravar();
		g.grava("secretarios.txt", toString());
		g.grava("Usuarios.txt", toString2());
		teclado.close();
		
	

	}

	public void listarPaciente() {

	}

	public void editarPaciente() {

	}

	public void alterarStatusPaciente() {

	}
}
