package br.com.uniciss.odontologico.funcionario;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;

public class Secretario extends Funcionario {
	
	Scanner teclado = new Scanner(System.in);
	
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

		int opc;
		LeituraDeDados leitura = new LeituraDeDados();
		
		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();
		
		leitura.leituraSecretario(listaSecretario, mapaSecretario);
		
		System.out.println("1- Consultar Secretario por Nome");
		System.out.println("2- Consultar Secretario por ID");
		
		teclado = new Scanner(System.in);
		opc = teclado.nextInt();
		
		switch (opc) {
		case 1:
			System.out.println("Informe o nome do Secretario");
			String nome = teclado.nextLine();
			nome = nome.replace(" ", "");
			nome = nome.toLowerCase();
			
			for(Secretario secretario: listaSecretario){
				String nomeDaVez = secretario.getNome().replace(" ", "");
				
				if(nomeDaVez.toLowerCase().equals(nome)){
					System.out.println("------- Secretario "+secretario.getNome()+"------");
					System.out.println("Codigo:"+secretario.getCodigo());
					System.out.println("Nome:"+secretario.getNome());
					System.out.println("RG:"+secretario.getRg());
					System.out.println("CPF:"+secretario.getCpf());
					System.out.println("Endereço:"+secretario.getEndereco());
					System.out.println("---------------------");
				}
				
			}
			break;
		case 2:
			
			break;
		}
		try{
			
		}catch(NullPointerException e){
			System.out.println("Secretario nao encontrado!");
		}
		
	}

	public void editarPaciente() {

	}

	public void alterarStatusPaciente() {

	}
}
