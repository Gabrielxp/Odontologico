package br.com.uniciss.odontologico.cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;

public class Cliente extends Pessoa{
	/**
	 *  Variavel tratamento, utilizada para determincao do tratamento que o paciente vai fazer
	 */
	public String tratamento;
	
	
	public String getTratamento() {
		return tratamento;
	}


	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}


	public void cadastrarCliente() throws FileNotFoundException, IOException{
		System.out.println("---------Cadastro de Clientes--------");
		cadastro();
		setStatus(true);
		tratamento="";
		
		LeituraDeDados leitura = new  LeituraDeDados();
		List<Cliente>listaPacientes = new ArrayList<Cliente>();
		
		leitura.leituraPacientes(listaPacientes);
		setCodigo(listaPacientes.size());
		
		Gravar g = new Gravar();  
		g.grava("documentos/pacientes.txt", toString());
		
		return;
	}
	
	public String toString() {
		return "Paciente" + "," + getCodigo() + "," + getNome() + ","
				+ getRg() + "," + getCpf() + "," + getEndereco() + ","
				+ getDataDeNascimento()+","+ isStatus()+","+getTratamento();
	}
	
}
