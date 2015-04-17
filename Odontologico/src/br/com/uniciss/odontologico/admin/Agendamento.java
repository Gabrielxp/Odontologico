package br.com.uniciss.odontologico.admin;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.FileReader;
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
	private int cod;
	private String data = "";
	private String hora = "";
	private int croDentista;
	private int idPaciente;
	private int idTratamento;

	@Override
	public String toString() {
		return "Agendamento,"+getCod()+","+getData()+","+getHora()+","+getCroDentista()+","+getIdPaciente()+","+getIdTratamento();
	}

	public void agendar() throws IOException{
		System.out.println("Informe o CRO do Dentista");
		croDentista = teclado.nextInt();
		teclado.nextLine();

		LeituraDeDados leitura = new LeituraDeDados();

		List<Dentista>listaDentista = new ArrayList<Dentista>();
		Map<Integer, Dentista>mapaDentista = new HashMap<Integer, Dentista>();

		leitura.leituraDentista(listaDentista, mapaDentista);

		Dentista dentista = new Dentista();

		boolean existeDentista = false;

		if(mapaDentista.containsKey(croDentista)){
			if(mapaDentista.get(croDentista).isStatus()){
				existeDentista = true;
				dentista = mapaDentista.get(croDentista);
			}else{
				System.out.println("Dentista existe mas porem esta inativo!");
				existeDentista = false;
			}

		}else{
			existeDentista = false;
		}


		if(!existeDentista){
			System.out.println("Dentista não encontrado");

			System.out.println("1- Deseja continuar");
			System.out.println("2- Deseja voltar ao Menu anterior");
			System.out.println("3- Consultar Dentistas");
			int opc = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				agendar();
				break;

			case 2:
				Menus m = new Menus();
				m.menuSecretario();
				break;
			case 3:
				for(Dentista d : listaDentista){
					if(d.isStatus()){
						System.out.println(d.getNome()+" CRO: "+d.getCro());
					}
				}
				agendar();
				break;

			default:
				System.out.println("Opção invalida");
				break;
			}
		}

		boolean continua = false;

		Scanner tecladoP = new Scanner(System.in);

		do{
			System.out.println("Informe o nome do Paciente");
			String nomePaciente = tecladoP.nextLine();

			List<Cliente>listaPacientes = new ArrayList<Cliente>();

			leitura.leituraPacientes(listaPacientes);
			boolean existePaciente = false;

			Cliente paciente = new Cliente();

			for(Cliente client : listaPacientes){
				if(client.getNome().equals(nomePaciente) && client.isStatus()){
					existePaciente = true;
					paciente = client;
					idPaciente = client.getCodigo();
					continua = false;
				}
			}

			if(!existePaciente){
				System.out.println("Paciente não encontrado");

				System.out.println("1- Deseja continuar");
				System.out.println("2- Deseja voltar ao Menu anterior");
				int opc = tecladoP.nextInt();
				tecladoP.nextLine();

				switch (opc) {
				case 1:
					continua = true;
					break;

				case 2:
					Menus m = new Menus();
					m.menuSecretario();
					continua = false;
					break;
				default:
					System.out.println("Opção invalida");
					break;
				}
			}
		}while(continua);

		boolean cont = false;

		Scanner tecladoT = new Scanner(System.in); 

		// Parte do Tratamento
		do{
			System.out.println("Informe o nome do Tratamento");
			String tratamento = tecladoT.nextLine();

			List<Tratamentos>listaTratamento = new ArrayList<Tratamentos>();
			Map<Integer, Tratamentos>mapaTratamento = new HashMap<Integer, Tratamentos>();

			leitura.leituraTratamento(listaTratamento, mapaTratamento);;

			Tratamentos tratamentos = new Tratamentos();

			boolean existeTratamento = false;

			for(Tratamentos tratado : listaTratamento){
				if(tratado.getTratamento().equals(tratamento)){
					existeTratamento = true;
					tratamentos = tratado;
					idTratamento = tratado.getCodigo();
					cont = false;
				}
			}


			if(!existeTratamento){
				System.out.println("Tratamento não encontrado");

				System.out.println("1- Deseja continuar");
				System.out.println("2- Deseja voltar ao Menu anterior");
				System.out.println("3- Listar Tratamentos");
				int opc = tecladoT.nextInt();
				tecladoT.nextLine();

				switch (opc) {
				case 1:
					cont = true;
					break;

				case 2:
					Menus m = new Menus();
					m.menuSecretario();
					break;
				case 3:
					for(Tratamentos t : listaTratamento){
						System.out.println(t.getTratamento()+" R$"+t.getValor());
					}
					cont = true;
					break;
				default:
					System.out.println("Opção invalida");
					break;
				}
			}
		}while(cont);

		System.out.println("Insira a data da consulta");
		data = teclado.nextLine();


		do{
			System.out.println("Insira a hora da consulta");
			hora = teclado.nextLine();

			if (validaHoraAngendada() == false || validaHoraDiponivel() == true)
				System.out.println("Horario indisponivel");
		}while(validaHoraAngendada() == false || validaHoraDiponivel() == true);

		Gravar gravar = new Gravar();
		gravar.grava("documentos/consultas.txt", toString());
	}







	public boolean validaHoraDiponivel() throws IOException{
		BufferedReader agenda = new BufferedReader(new FileReader("documentos/consultas.txt"));

		while(agenda.ready()) {    
			String linha = agenda.readLine();    
			if (linha.contains(hora)) {    
				return true;
			}
		}
		agenda.close();
		return false;
	}

	public boolean validaHoraAngendada(){
		SimpleDateFormat formata = new SimpleDateFormat("h:mm - a");

		Date horaInformada = new Date();
		formata = new SimpleDateFormat("HH:mm");
		formata.setLenient(false);

		try {
			horaInformada = formata.parse(hora);
			Date horaInicio = formata.parse("07:00");
			Date horaFim = formata.parse("22:00");

			if (horaInformada.getTime() > horaInicio.getTime() && horaInformada.getTime() < horaFim.getTime()){
				return true;
			}else{
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}



	public int getCod() {
		return cod;
	}



	public void setCod(int cod) {
		this.cod = cod;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public int getCroDentista() {
		return croDentista;
	}



	public void setCroDentista(int croDentista) {
		this.croDentista = croDentista;
	}



	public int getIdPaciente() {
		return idPaciente;
	}



	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}



	public int getIdTratamento() {
		return idTratamento;
	}



	public void setIdTratamento(int idTratamento) {
		this.idTratamento = idTratamento;
	}

}
