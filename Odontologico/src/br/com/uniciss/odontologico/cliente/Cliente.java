package br.com.uniciss.odontologico.cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.funcionario.Funcionario;

public class Cliente extends Pessoa{
	/**
	 *  Variavel tratamento, utilizada para determincao do tratamento que o paciente vai fazer
	 */
	public String tratamento;
	
	
	public String getTratamento() {
		return tratamento;
	}


	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	/**
	 * Metodo para Cadastrar Paciente
	 * @method cadastrarCliente();
	 */
	public void cadastrarCliente() throws FileNotFoundException, IOException{
		System.out.println("---------Cadastro de Clientes--------");
		cadastro();
		setStatus(true);
		tratamento="";
		
		LeituraDeDados leitura = new  LeituraDeDados();
		List<Cliente>listaPacientes = new ArrayList<Cliente>();
		
		leitura.leituraPacientes(listaPacientes);
		setCodigo(listaPacientes.size());
		
		Gravar g = new Gravar();  
		g.grava("documentos/pacientes.txt", toStringPaciente());
		
		Menus m = new Menus();
		m.menuSecretario();
	}
	
	/**
	 * Metodo para editar Paciente
	 * @method editarPaciente();
	 */
	public void editarPaciente() throws IOException {
		System.out.println("---------Editar Clientes--------");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Deseja Editar o nome? 1 - Sim, 2 - Não");
		int escolha = teclado.nextInt();
		teclado.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Informe o nome : ");
			setNome(teclado.nextLine());

			break;
		case 2:

			break;
		default:
			System.out.println("Opção Errada!");
			break;
		}
		System.out.println("Deseja Editar o endereço? 1 - Sim, 2 - Não");
		int escolha2 = teclado.nextInt();
		switch (escolha2) {
		case 1:
			teclado.nextLine();
			System.out.println("Informe o Endereço: ");
			endereco = (teclado.next());
			break;
		case 2:

			break;
		default:
			System.out.println("Opção Errada!");
			break;
		}

	}
	
	/**
	 * Metodo para salvar os dados Paciente
	 * @method toStringPaciente();
	 */
	//TERMINARRRRR
	public String toStringPaciente() {
		return "INSERT INTO pessoa (id_pessoa, nome, cpf, endereco, data_nascimento) "
				+ "VALUES ("+ getCodigo()+","+getNome()+","+getCpf()+"',1,'1990-02-04')"
				+ "Paciente" + "," + getCodigo() + "," + getNome() + ","
				+ getRg() + "," + getCpf() + "," + getEndereco() + ","
				+ getDataDeNascimento()+","+ isStatus()+","+getTratamento();
	}
	
}
