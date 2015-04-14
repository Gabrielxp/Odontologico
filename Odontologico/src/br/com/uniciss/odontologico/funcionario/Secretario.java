package br.com.uniciss.odontologico.funcionario;

import br.com.uniciss.odontologico.BD.Gravar;

public class Secretario extends Funcionario {
	
	public void cadastrarSecretario() {
		super.cadastraFuncionario();
		
		Gravar g = new Gravar();
		g.grava("br/com/uniciss/odontologico/documentos/secretarios.txt", toString());
		g.grava("br/com/uniciss/odontologico/documentos/users.txt", toString2());
		
	}

	public void listarPaciente() {

	}

	public void editarPaciente() {

	}

	public void alterarStatusPaciente() {

	}
}
