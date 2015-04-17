package br.com.uniciss.odontologico.funcionario;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;

public class Dentista extends Funcionario {
	/**
	 * Variavel cro, relacionada ao cro do dentista
	 */
	protected int cro;
	String croTexto;

	public void cadastrarDentista() throws FileNotFoundException, IOException{   
		System.out.println("---------CADASTRAR DENTISTA----------");
		super.cadastraFuncionario();

		do{
			System.out.println("Informe seu CRO:");
			cro = teclado.nextInt();
			croTexto = String.valueOf(cro);

			if ((!validaCro(croTexto) || validaCro() == true))
				System.out.println("CRO invalido ou ja cadastrado");

		}while((!validaCro(croTexto) || validaCro() == true));

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
		return "Dentista"+","+getCodigo()+","+getNome()+","+getRg()+","+getCpf()+","+getEndereco()+","+getDataDeNascimento()+","+isStatus()+","+getCro()+","+getHoraDeEntrada()+","+getHoraDeSaida();
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
				System.out.println("Endere�o:"+dentista.getEndereco());
				System.out.println("---------------------");
			} else {
				System.out.println("Dentista esta como inativo");
			}
		}catch(NullPointerException e){
			System.err.println("Dentista n�o encontrado");
		}

	}
	
	public void inativarDentista() throws IOException{
		LeituraDeDados leitura = new LeituraDeDados();
		
		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();

		leitura.leituraDentista(listaDentista, mapaDentista);
		teclado = new Scanner(System.in);
		
		System.out.println("Digite o CRO do dentista");
		int cro = teclado.nextInt();
		
		boolean existe = false;
		
		for(Dentista d : listaDentista){
			if(d.getCro() == cro){
				existe = true;
				if(!d.isStatus()){
					System.out.println("Este Dentista ja foi inativado");
				}else{
					d.setStatus(false);
					
					Gravar g = new Gravar();
					g.editar("documentos/dentistas.txt");
					
					for (Dentista f : listaDentista) {
						g.grava("documentos/dentistas.txt", f.toStringDentista());
					}
					
				}
			}
		}
		if(!existe){
			System.out.println("CRO inexistente");
		}
	}

	@SuppressWarnings("resource")
	public boolean validaCro() throws IOException{
		BufferedReader d = new BufferedReader(new FileReader("documentos/dentistas.txt"));

		while(d.ready()) {    
			String linha = d.readLine();    
			if (linha.contains(croTexto)) {    
				return true;
			}
		}
		d.close();
		return false;
	}

	public boolean validaCro(String texto) {
		return texto.matches("^[0-9]*$");
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
