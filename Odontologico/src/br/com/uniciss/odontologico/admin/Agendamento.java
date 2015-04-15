package br.com.uniciss.odontologico.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import br.com.uniciss.odontologico.BD.Gravar;

public class Agendamento {


	private String nome;
	private String data;
	private String horario;
	private String observa��es;
	private Scanner s;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getObserva��es() {
		return observa��es;
	}

	public void setObserva��es(String observa��es) {
		this.observa��es = observa��es;
	}

	@Override
	public String toString() {
		return "Consulta," + nome + "," + data + "," + horario + ","
				+ observa��es;
	}

	public void agendarConsulta() throws java.text.ParseException {

		s = new Scanner(System.in);

		System.out.println("Informe o nome do paciente: ");
		setNome(s.nextLine());

		verificaData();

		verificaHoras();

		System.out.println("Informe informa��es sobre a consulta: ");
		setObserva��es(s.nextLine());

		Gravar g = new Gravar();
		g.grava("Consultas.txt", toString());
	}

	@SuppressWarnings("unused")
	public boolean verificaData() {

		String data;

		System.out.println("Informe o dia da consulta: ");
		String a = s.nextLine();

		Date hoje = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		data = formata.format(hoje);

		Date d = new Date();
		formata = new SimpleDateFormat("dd/MM/yyyy");
		formata.setLenient(false);
		try {
			d = formata.parse(a);

			if ((new Date()).getTime() < d.getTime()) {
				setData(a);

			} else if ((new Date()).getTime() >= d.getTime()) {
				System.out
				.println("N�o � possivel marcar consultas para este dia, informe outra data!");
				System.out.println("");
				verificaData();
			}

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Voc� informou uma data inv�lida!");
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	public boolean verificaHoras() {

		s = new Scanner(System.in);
		String hora;

		System.out.println("Informe o hor�rio da consulta: ");
		String a = s.nextLine();

		Date hoje = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("h:mm - a");
		hora = formata.format(hoje);

		Date d = new Date();
		formata = new SimpleDateFormat("HH:mm");
		formata.setLenient(false);

		try {
			d = formata.parse(a);
			setHorario(a);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Voc� informou um hor�rio inv�lido!");
			return false;
		}
		return true;

	}
}