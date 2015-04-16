package br.com.uniciss.odontologico.BD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.odontologico.funcionario.Funcionario;
import br.com.uniciss.odontologico.funcionario.Secretario;

public class Gravar {
	public void grava(String aonde,String oque) throws IOException{
		File ficheiro = new File(aonde); 
		try { 
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro, true));  
			if(ficheiro.canWrite()){ 
				bw.write(oque); 
				bw.newLine(); 
				bw.flush(); 
				bw.close(); 
			} 
		}catch (java.io.FileNotFoundException e){
			System.out.println("Erro");
		} 
	}
		public void leituraUsuario(Map<String, Funcionario> listaUsuario){
			try {
				FileReader arq = new FileReader("documentos/users.txt");
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
		public void editar(String aonde) throws IOException{
			File arq = new File(aonde+".txt");
			arq.delete();
			File novo = new File(aonde+".txt");
			
		}
}
