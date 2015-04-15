package br.com.uniciss.odontologico.cliente;

public class Cliente extends Pessoa{
	/**
	 *  Variavel tratamento, utilizada para determincao do tratamento que o paciente vai fazer
	 */
	public String tratamento;
	
	
	public String getTratamento() {
		return tratamento;
	}


	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}


	public void cadastrarCliente(){
		System.out.println("---------Cadastro de Clientes--------");
		cadastro();
		
		
		return;
	}
}
