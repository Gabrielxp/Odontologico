package br.com.uniciss.odontologico.cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa {
	protected String nome;
	protected String rg;
	protected String cpf;
	protected String endereco;
	protected int codigo;
	protected boolean status;

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void cadastro(){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("--------Cadastrado de Clientes-------");
		System.out.println("Insira o nome");
		this.nome = teclado.next();
		
		if(!validaNome(nome)){
			System.out.println("invalido");
		}
		
		//le e valida RG
		do{
			System.out.println("Insira o RG");
			this.rg = teclado.next();
		}while (rg.matches("[a-zA-Z]+"));

		
		//Le e valida CPF
		cpf = "0";
		while (validaCpf() == false) {
			System.out.println("Insira o CPF");
			this.cpf = teclado.next();
			
			cpf = cpf.replace("-", "");
			cpf = cpf.replace(".", "");
		
			if (!validaCpf() == true){
				System.out.println("cpf invalido");
			}
		}
		
		System.out.println("Insira o endereco");
		this.endereco = teclado.next();
		
		System.out.println("Insira o codigo");
		try{
			this.codigo = teclado.nextInt();
			System.out.println("Cadastro COncluido com Sucesso!");
		}catch (java.util.InputMismatchException e) {
			System.out.println("Codigo Invalido");
		}
	}
	
	public boolean validaCpf(){
	
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") ||
			cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||
			cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))
			return (false);
		
	 char dig10, dig11;
	 int sm, i, r, num, peso;
	 
	 try{
		 sm=0;
		 peso=10;
		 for(i=0; i<9;i++){
			 num = (int)(cpf.charAt(i)-48);
			 sm = sm + (num * peso);
			 peso = peso - 1;
		 }
		 
		 r= 11 - (sm % 11);

		 if ((r==10)||(r==11)){
			 dig10='0';
		 }
		 else{
			 dig10 = (char)(r + 48);
		 }
		 
		 sm=0;
		 peso=11;
		 
		 for(i=0; i <10; i++){
		 num = (int)(cpf.charAt(i)-48);
		 sm = sm + (num*peso);
		 peso = peso - 1;			 
	 }
		 
		 r= 11 - (sm%11);
	 
		 if((r == 10) || (r == 11)){
			 dig11 = '0';
		 }
		 else {
			 dig11 = (char)(r+48);
		 }
	 
		 if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
			 return(true);
		 }
		 else{
			 return(false);
		 }
	 }catch(InputMismatchException erro){
		 return(false);
	 }
	}
	
	public boolean validaRg(String texto){
		return texto.matches("^[0-9]*$") ;
	}
	
	public boolean validaNome(String txt){
		return txt.matches("[a-zA-Z]+");
	}
}
