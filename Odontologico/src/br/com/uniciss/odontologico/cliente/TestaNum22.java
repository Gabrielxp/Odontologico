package br.com.uniciss.odontologico.cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class TestaNum22 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
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
			s.consultarSecretario();
		}
		if(opc == 3 ){
			Cliente c = new Cliente();
			c.cadastrarCliente();
		}
	}

}
