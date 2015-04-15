package br.com.uniciss.odontologico.BD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.com.uniciss.odontologico.funcionario.Dentista;

public class LeituraDeDados {
	
	public void leituraDentista(List<Dentista>listaDentista,Map<Integer, Dentista>mapaDentista){
		try {
			
			FileReader arq = new FileReader("src/br/com/uniciss/odontologico/documentos/dentistas.txt");
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
				d.setStatus(Boolean.parseBoolean(palavras[6]));
				d.setCro(Integer.parseInt(palavras[7]));
				
				listaDentista.add(d);
				mapaDentista.put(d.getCro(), d);
			} 
			
			arq.close();
		}catch (IOException e) { 

		} 
	}
}
