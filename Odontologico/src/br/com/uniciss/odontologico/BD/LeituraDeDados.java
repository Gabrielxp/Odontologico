package br.com.uniciss.odontologico.BD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.com.uniciss.odontologico.cliente.Cliente;
import br.com.uniciss.odontologico.cliente.Tratamentos;
import br.com.uniciss.odontologico.funcionario.Dentista;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class LeituraDeDados {


	//Metodo que faz a leitura do arquivo dentistas.txt
	public void leituraDentista(List<Dentista>listaDentista,Map<Integer, Dentista>mapaDentista){
		try {

			FileReader arq = new FileReader("documentos/dentistas.txt");
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine();  

			while (linha != null) {
				String palavras[] = linha.split(",");

				Dentista d = new Dentista();
				d.setCodigo(Integer.parseInt(palavras[1]));
				d.setNome(palavras[2]);
				d.setRg(palavras[3]);
				d.setCpf(palavras[4]);
				d.setEndereco(palavras[5]);
				d.setDataDeNascimento(palavras[6]);
				d.setStatus(Boolean.parseBoolean(palavras[7]));
				d.setCro(Integer.parseInt(palavras[8]));

				listaDentista.add(d);
				mapaDentista.put(d.getCro(), d);
				linha = lerArq.readLine();
			} 

			arq.close();
		}catch (IOException e) { 
			System.out.println("Deu Pau");
		} 
	}

	//Metodo que faz a leitura do arquivo secretarios.txt
	public void leituraSecretario(List<Secretario>listaSecretario,Map<Integer, Secretario>mapaSecretario){
		try{
			FileReader arq = new FileReader("documentos/secretarios.txt");
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine();  

			while (linha != null) {
				String palavras[] = linha.split(",");

				Secretario s = new Secretario();
				s.setCodigo(Integer.parseInt(palavras[1]));
				s.setNome(palavras[2]); 
				s.setRg(palavras[3]);
				s.setCpf(palavras[4]);   
				s.setEndereco(palavras[4]);
				s.setDataDeNascimento(palavras[5]);
				s.setStatus(Boolean.parseBoolean(palavras[6]));

				listaSecretario.add(s);
				mapaSecretario.put(s.getCodigo(), s);
				linha = lerArq.readLine();
			} 

			arq.close();
		}catch (IOException e) { 
			System.err.println("ERRO LEITURA");
		}
	}

	//Metodo que faz a leitura do arquivo pacientes.txt
	public void leituraPacientes(List<Cliente>listaPacientes){
		try{
			FileReader arq = new FileReader("documentos/pacientes.txt");
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine();  

			while (linha != null) {
				String palavras[] = linha.split(",");

				Cliente c = new Cliente();
				c.setCodigo(Integer.parseInt(palavras[1]));
				c.setNome(palavras[2]); 
				c.setRg(palavras[3]);
				c.setCpf(palavras[4]);   
				c.setEndereco(palavras[4]);
				c.setDataDeNascimento(palavras[5]);
				c.setStatus(Boolean.parseBoolean(palavras[6]));
				c.setTratamento(palavras[7]);

				listaPacientes.add(c);
				linha = lerArq.readLine();
			} 

			arq.close();
		}catch (IOException e) { 

		}
	}
	
	//Metodo que faz a leitura do arquivo tratamentos.txt
	public void leituraTratamento(List<Tratamentos>listaTratamento,Map<Integer, Tratamentos>mapaTratamento){
		try{  
			FileReader arq = new FileReader("documentos/tratamentos.txt");
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine();  

			while (linha != null) {
				String palavras[] = linha.split(",");

				Tratamentos t = new Tratamentos();
				t.setCodigo(Integer.parseInt(palavras[1]));
				t.setTratamento(palavras[2]);
				t.setValor(palavras[3]);

				listaTratamento.add(t);
				mapaTratamento.put(t.getCodigo(), t);
				
				linha = lerArq.readLine();
			} 

			arq.close();
		}catch (IOException e) { 

		}
	}
}
