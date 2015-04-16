package br.com.uniciss.odontologico.admin;

import java.awt.Menu;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.cliente.Tratamentos;
import br.com.uniciss.odontologico.funcionario.Dentista;

public class Agendamento {

	Scanner teclado = new Scanner(System.in);

	public void agendar() throws IOException{
		System.out.println("Informe o nome do Dentista");
		String nomeDentista = teclado.nextLine();


		LeituraDeDados leitura = new LeituraDeDados();

		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();

		leitura.leituraDentista(listaDentista, mapaDentista);

		Dentista dentista = new Dentista();

		boolean existe = false;

		for(Dentista denti : listaDentista){
			if(denti.getNome().equals(nomeDentista) && denti.isStatus()){
				existe = true;
				dentista = denti;
			}
		}

		if(!existe){
			System.out.println("Dentista não encontrado");

			System.out.println("1- Deseja continuar");
			System.out.println("2- Deseja voltar ao Menu anterior");
			int opc = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				agendar();
				break;

			case 2:
				Menus m = new Menus();
				m.menuSecretario();
				
			default:
				System.out.println("Opção invalida");
				break;
			}
		}
		
		System.out.println("Informe o nome do Paciente");
		String nomePaciente = teclado.nextLine();
		// Cliente

		List<Cliente>listaPacientes = new ArrayList<Cliente>();
		Map<Integer, Cliente>mapaCliente = new HashMap<Integer, Cliente>();

		leitura.leituraPacientes(listaPacientes);

		Cliente paciente = new Cliente();

		for(Cliente client : listaPacientes){
			if(client.getNome().equals(nomePaciente) && client.isStatus()){
				existe = true;
				paciente = client;
			}
		}

		if(!existe){
			System.out.println("Paciente não encontrado");

			 System.out.println("1- Deseja continuar");
			System.out.println("2- Deseja voltar ao Menu anterior");
			int opc = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				agendar();
				break;

			case 2:
				Menus m = new Menus();
				m.menuSecretario();
				
			default:
				System.out.println("Opção invalida");
				break;
			}
		}
		
		System.out.println("Informe o nome do Tratamento");
		String tratamento = teclado.nextLine();

		List<Tratamentos>listaTratamento = new ArrayList<Tratamentos>();
		Map<Integer, Tratamentos>mapaTratamento = new HashMap<Integer, Tratamentos>();

		leitura.leituraTratamento(listaTratamento, mapaTratamento);;

		Tratamentos tratamentos = new Tratamentos();

		for(Tratamentos tratado : listaTratamento){
			if(tratado.getTratamento().equals(tratamento)){
				existe = true;
				tratamentos = tratado;
			}
		}

		if(!existe){
			System.out.println("Tratamento não encontrado");

			System.out.println("1- Deseja continuar");
			System.out.println("2- Deseja voltar ao Menu anterior");
			int opc = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				agendar();
				break;

			case 2:
				Menus m = new Menus();
				m.menuSecretario();
				
			default:
				System.out.println("Opção invalida");
				break;
			}
		}


	}
}