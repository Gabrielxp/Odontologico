package br.com.uniciss.odontologico.funcionario;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.cliente.Cliente;

public class Dentista extends Funcionario {
	/**
	 * Variavel cro, relacionada ao cro do dentista
	 */
	protected int cro;


	public void cadastrarDentista() throws FileNotFoundException, IOException{   
		System.out.println("---------CADASTRAR DENTISTA----------");
		super.cadastraFuncionario();
		
		boolean continua; 
		do{
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

		System.out.println(toStringDentista());
		tipo = "dentista"; 
		setStatus(true);
		
		LeituraDeDados leitura = new LeituraDeDados();
		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();
		
		leitura.leituraDentista(listaDentista, mapaDentista);
		
		setCodigo(listaDentista.size());
			
		Gravar g = new Gravar();  
		g.grava("documentos/dentistas.txt", toStringDentista());
		g.grava("documentos/users.txt", toString2());
		return;

		
	}

	//Metodo toString para cadastro de Funcionarios
		public String toStringDentista(){
			return "Dentista"+","+getCodigo()+","+getNome()+","+getRg()+","+getCpf()+","+getEndereco()+","+getDataDeNascimento()+","+isStatus()+","+getCro();
		}
	
	public void consultar(int cro) {
		LeituraDeDados leitura = new LeituraDeDados();
		Dentista dentista = new Dentista();
		
		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();
		
		leitura.leituraDentista(listaDentista, mapaDentista);
		try{
			dentista = mapaDentista.get(cro);
			if(dentista.isStatus()){
				System.out.println("-------Dentista "+dentista.getNome()+"------");
				System.out.println("Codigo:"+dentista.getCodigo());
				System.out.println("Nome:"+dentista.getNome());
				System.out.println("CRO:"+dentista.getCro());
				System.out.println("RG:"+dentista.getRg());
				System.out.println("CPF:"+dentista.getCpf());
				System.out.println("Endereço:"+dentista.getEndereco());
				System.out.println("---------------------");
			} else {
				System.out.println("Dentista esta como inativo");
			}
		}catch(NullPointerException e){
			System.out.println("Dentista não encontrado");
		}
		
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
