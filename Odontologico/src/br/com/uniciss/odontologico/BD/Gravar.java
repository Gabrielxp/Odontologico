package br.com.uniciss.odontologico.BD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import br.com.uniciss.odontologico.funcionario.Funcionario;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Gravar {
	public void grava(String aonde,String oque){
		File ficheiro = new File(aonde); 
		try { 
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro, true));  
			if(ficheiro.canWrite()){ 
				bw.write(oque); 
				bw.newLine(); 
				bw.flush(); 
				bw.close(); 
			} 
		}catch (IOException e){
			
		} 
	}
		public void leituraUsuario(Map<String, Funcionario> listaUsuario){
			try {
				FileReader arq = new FileReader("users.txt");
				BufferedReader lerArq = new BufferedReader(arq); 
				String linha = lerArq.readLine();  
				
				
				while (linha != null) {
					String palavras[]=linha.split(",");
					Funcionario f = new Secretario();
					
					f.setLogin(palavras[1]);
					f.setSenha(palavras[2]);
					f.setTipo(palavras[3]);
					
					listaUsuario.put(f.getLogin(), f);
					linha = lerArq.readLine();
				} 
				arq.close(); 
			} 
			catch (IOException e) { 
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			}	

	}
}
