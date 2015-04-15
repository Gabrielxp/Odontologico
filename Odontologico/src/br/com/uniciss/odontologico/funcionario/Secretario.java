package br.com.uniciss.odontologico.funcionario;

import br.com.uniciss.odontologico.BD.Gravar;

public class Secretario extends Funcionario {
	
	public void cadastrarSecretario() {
		super.cadastraFuncionario();
		
		tipo = "secretario";  
		setStatus(true);
		Gravar g = new Gravar();
		g.grava("documentos/secretarios.txt", toString());
		g.grava("documentos/users.txt", toString2());
		return;
	}

	public void listarPaciente() {

	}

	public void editarPaciente() {

	}

	public void alterarStatusPaciente() {

	}
}
