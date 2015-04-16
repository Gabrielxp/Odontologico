package br.com.uniciss.odontologico.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.Menus;
import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.LeituraDeDados;
import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Admin {
	Scanner entrada = new Scanner(System.in);
	LeituraDeDados leia = new LeituraDeDados();

	public void editarSecretario() throws FileNotFoundException, IOException {

		String nome;
		List<Secretario> listaSecretario = new ArrayList<Secretario>();
		Map<Integer, Secretario> mapaSecretario = new HashMap<Integer, Secretario>();
		leia.leituraSecretario(listaSecretario, mapaSecretario);
		Menus m = new Menus();
		System.out.println("Determine o nome da pessoa a ser editado: ");
		nome = entrada.nextLine();
		boolean continua = false;

		for (Secretario s : listaSecretario) {

			if (nome.equals(s.getNome())) {

				s.cadastro();
				continua = true;

			}
			Gravar g = new Gravar();
			g.editar("documentos/secretarios.txt");
			for (Secretario f : listaSecretario) {
				g.grava("documentos/secretarios.txt", f.toString());
			}

		}

		if (continua == false) {

			int escolha;

			System.out.println("Determinaste um nome invalido"
					+ "\n Deseja voltar ao menu? 1 - sim, 2 - não");
			escolha = entrada.nextInt();
			entrada.nextLine();
			if (escolha == 1) {
				m.menuAdmin();
			} else if (escolha != 1) {
				editarSecretario();
			}
		}
		if (continua == true) {
			System.out.println("\n Edição realizada com sucesso!\n");
			m.menuAdmin();
		}
	}

	public void editarDentista() {

	}

}
