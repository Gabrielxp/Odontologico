package br.com.uniciss.odontologico;

import br.com.uniciss.odontologico.funcionario.Dentista;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Sistema de atendimento Odontologico");

		Dentista dentista = new Dentista();

		dentista.cadastrarDentista();
		
		
	}

}
