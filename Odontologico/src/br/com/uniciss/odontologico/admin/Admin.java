package br.com.uniciss.odontologico.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Admin {
	Scanner entrada = new Scanner(System.in);
	LeituraDeDados leia = new LeituraDeDados();
	public void editarSecretario() throws FileNotFoundException, IOException{
		System.out.println("Determine o nome ");
		String nome = entrada.nextLine();
		List<Secretario>listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario>mapaSecretario = new HashMap<Integer, Secretario>();
		leia.leituraSecretario(listaSecretario, mapaSecretario);
		
		System.out.println("TESTEEE");
		for(Secretario s:listaSecretario){
			if (nome.equals(s.getNome())){
				s.cadastraFuncionario();
			}
		}
	}
	public void editarDentista(){
		
	}
	
	
}
