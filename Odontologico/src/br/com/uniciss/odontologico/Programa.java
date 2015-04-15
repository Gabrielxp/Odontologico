package br.com.uniciss.odontologico;

import java.io.IOException;


public class Programa {

	public static void main(String[] args) throws IOException {
		System.out.println("Sistema de atendimento Odontologico");
		Menus m = new Menus();
		
		m.Login();
		
		
	}

}
