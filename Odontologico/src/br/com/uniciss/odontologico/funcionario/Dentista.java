package br.com.uniciss.odontologico.funcionario;


import br.com.uniciss.odontologico.BD.Gravar;

public class Dentista extends Funcionario {
	/**
	 * Variavel cro, relacionada ao cro do dentista
	 */
	protected int cro;


	public void cadastrarDentista(){   
		System.out.println("---------CADASTRAR DENTISTA----------");
		super.cadastraFuncionario();
		
		boolean continua;
		do{
			try{
				System.out.println("Informe seu CRO:");
				cro = teclado.nextInt();
				continua = false;
			}catch(Exception e ){
				teclado.nextLine();
				continua = true;
				System.err.println("Informe um numero inteiro!");
			}
		}while(continua == true);

		System.out.println(toStringDentista());
		tipo = "dentista"; 
		Gravar g = new Gravar();
		g.grava("src/br/com/uniciss/odontologico/documentos/dentistas.txt", toStringDentista());
		g.grava("src/br/com/uniciss/odontologico/documentos/users.txt", toString2());
		return;

		
	}

	//Metodo toString para cadastro de Funcionarios
		public String toStringDentista(){
			return "Dentista"+","+getCodigo()+","+getNome()+","+getRg()+","+getCpf()+","+getEndereco()+","+isStatus()+","+getCro();
		}
	
	public void consultar() {

	}

	public void editarPaciente() {

	}

	public void requisitarMateriais() {

	}

	public void encaminharPaciente() {

	}

	public int getCro() {
		return cro;
	}

	public void setCro(int cro) {
		this.cro = cro;
	}
	
}
