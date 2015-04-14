package br.com.uniciss.odontologico;

import br.com.uniciss.odontologico.cliente.Cliente;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Sistema de atendimento Odontologico");
		
		Cliente cliente = new Cliente();
		
		cliente.cadastraCliente();

	}

}
