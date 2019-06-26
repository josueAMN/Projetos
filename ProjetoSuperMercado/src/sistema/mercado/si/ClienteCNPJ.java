package sistema.mercado.si;

public class ClienteCNPJ extends Cliente{
	private String cnpj;
	
	//Construtor utilizando o Super

	public ClienteCNPJ(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	
	// GET's
	public String getCodigo() {
		return this.cnpj;
	}
	public String getCNPJ() {
		return this.cnpj;
	}
}
