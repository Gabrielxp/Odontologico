package br.com.uniciss.odontologico.cliente;

import java.util.Scanner;

public class Cliente extends Pessoa{
	public String tratamento;
	
	public void cadastraCliente(){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("--------Cadastrado de Clientes-------");
		System.out.println("Insira o nome do Paciente");
		this.nome = teclado.next();
		
		System.out.println("Insira o RG do Paciente");
		this.rg = teclado.next();
		
		System.out.println("Insira o CPF do Paciente");
		this.cpf = teclado.next();
		
		System.out.println("Insira o endereco do Paciente");
		this.endereco = teclado.next();
		
		System.out.println("Insira o codigo do Cliente");
		this.codigo = teclado.nextInt();
	}
}
