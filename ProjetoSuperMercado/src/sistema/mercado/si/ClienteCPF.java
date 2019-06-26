package sistema.mercado.si;

public class ClienteCPF extends Cliente{
	private String cpf;
	
	//Construtor utilizando o Super
	public ClienteCPF(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}
	
	// GET's
	public String getCodigo() {
		return this.cpf;
	}
	public String getCPF() {
		return this.cpf;
	}
}
