package br.com.uniciss.odontologico.funcionario;

import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;

public class Dentista extends Funcionario {

	protected int cro;


	public void cadastrarDentista(){   
		
		super.cadastraFuncionario();
		
		
		
	/*	do{
			try{
				System.out.println("Informe seu CRO:");
				cro = teclado.nextInt();
				continua = false;
			}catch(Exception e ){
				teclado.nextLine();
				continua = true;
				System.err.println("Informe um numero inteiro!");
			}
		}while(continua == true);
*/
		System.out.println(toStringDentista());
		Gravar g = new Gravar();
		g.grava("src/br/com/uniciss/odontologico/documentos/dentistas.txt", toStringDentista());
		g.grava("src/br/com/uniciss/odontologico/documentos/users.txt", toString2());
		
	}

	//Metodo toString para cadastro de Funcionarios
		public String toStringDentista(){
			return "Funcionario"+","+getCodigo()+","+getNome()+","+getRg()+","+getCpf()+","+getEndereco()+","+isStatus()+","+getCro();
		}
	
	public void consultar() {

	}

	public void editarPaciente() {

	}

	public void requisitarMateriais() {

	}

	public void encaminharPaciente() {

	}

	public int getCro() {
		return cro;
	}

	public void setCro(int cro) {
		this.cro = cro;
	}
	
}
