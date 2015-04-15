package br.com.uniciss.odontologico.funcionario;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.uniciss.odontologico.BD.Gravar;

public class Secretario extends Funcionario {
	
	public void cadastrarSecretario() throws FileNotFoundException, IOException {
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
