package br.com.uniciss.odontologico.cliente;

import java.util.Scanner;

import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class TestaNum22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ler  = new Scanner(System.in);
		
		System.out.println("Selecione uma opcao");
		int opc = ler.nextInt();
		
		if (opc == 1){
			Dentista d = new Dentista();
			d.cadastrarDentista();
		}
		if(opc == 2){
			Secretario s = new Secretario();
			s.cadastrarSecretario();
		}
	}

}
