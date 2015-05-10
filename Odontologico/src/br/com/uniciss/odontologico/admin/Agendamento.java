package br.com.uniciss.odontologico.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private String dataDoAgendamento = "";
	private String hora = "";
	private int croDentista;
	private int idPaciente;
	private int idTratamento;
	String procuraData;
	String procuraHora;
	String procuraCRO;

	@Override
	public String toString() {
		return "Agendamento,"+getCod()+","+getDataDoAgendamento()+","+getHora()+","+getCroDentista()+","+getIdPaciente()+","+getIdTratamento();
	}
	
	/**
	 * Metodo para agendar uma consulta
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @method agendar();
	 */
	public void agendar() throws IOException, ClassNotFoundException, SQLException{
		System.out.println("EM CONSTRUÇÃO!");
		
		Menus m = new Menus();
		m.menuSecretario();
	}

	
	
	/**
	 * Metodo que valida se pode agendar
	 * @method validaDataHoraDisponivel
	 */
	@SuppressWarnings("resource")
	public boolean validaDataHoraDiponivel() throws IOException{
		BufferedReader agenda = new BufferedReader(new FileReader("documentos/consultas.txt"));

		while(agenda.ready()) {    
			String linha = agenda.readLine();    
			if (linha.contains(procuraHora) && linha.contains(procuraData) && linha.contains(procuraCRO)) {    
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

		
		public boolean validaDataAgendada(){
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			data.setLenient(false);
				
			SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");

			Date dataInformada = new Date();
			formata = new SimpleDateFormat("dd/MM/yyyy");
			formata.setLenient(false);
				
					
			try {
				dataInformada = formata.parse(dataDoAgendamento);
				data.parse(dataDoAgendamento);
				
				if ((new Date()).getTime() < dataInformada.getTime()){
					return true;
				}
				
			} catch (ParseException e) {
				return false;
		}
			return false;		
	}


	public int getCod() {
		return cod;
	}



	public void setCod(int cod) {
		this.cod = cod;
	}



	public String getDataDoAgendamento() {
		return dataDoAgendamento;
	}



	public void setDataDoAgendamento(String dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
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
