package br.com.uniciss.odontologico.cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Conectar;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.BD.Scripts;
import br.com.uniciss.odontologico.funcionario.Funcionario;

public class Cliente extends Pessoa {
	/**
	 * Variavel tratamento, utilizada para determincao do tratamento que o
	 * paciente vai fazer
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
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @method cadastrarCliente();
	 */
	public void cadastrarCliente() throws FileNotFoundException, IOException,
			SQLException, ClassNotFoundException {
		System.out.println("---------Cadastro de Clientes--------");
		cadastro();
		setStatus(true);
		tratamento = "";

		/**
		 * Variavel String insert utilizada para insercao de dados ao banco de
		 * dados
		 */
		String insert = "INSERT INTO pessoa (nome, cpf, endereco, data_nascimento) VALUES ('"
				+ getNome()
				+ "', '"
				+ getCpf()
				+ "' ,'"
				+ getEndereco()
				+ "' ,'" + getDataDeNascimento() + "')";

		Scripts.insert(insert);

		/**
		 * Selecionar id da pessoa e adiciona-la como paciente
		 */

		String select = "SELECT id_pessoa FROM pessoa where cpf='" + cpf + "'";
		Scripts.select(select);
		String seleciona = "SELECT id_pessoa FROM pessoa where cpf='" + cpf
				+ "'";
		int pegaId = Scripts.select(select);

		String inserta = "INSERT INTO paciente (id_pessoa, status) VALUES ('"
				+ pegaId + "','" + true + " ')";
		Scripts.insert(inserta);

		Menus m = new Menus();
		m.menuSecretario();
	}

	/**
	 * Metodo para editar Paciente
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * @method editarPaciente();
	 */
	public void editarPaciente() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("---------Editar Clientes--------");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Deseja Editar o nome? 1 - Sim, 2 - Não");
		int escolha = teclado.nextInt();
		teclado.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Informe o nome : ");
			setNome(teclado.nextLine());
			String select = "SELECT id_pessoa FROM pessoa where nome='" + getNome() + "'";
			int pegaId = Scripts.select(select);
			System.out.println("Novo nome: ");
			String nome2 = teclado.nextLine();
			
			 String update1 = "UPDATE pessoa SET nome='"+nome2+"' where nome='"+getNome()+"'";
			 Scripts.update(update1);
				
			    
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
		}

	}

}
