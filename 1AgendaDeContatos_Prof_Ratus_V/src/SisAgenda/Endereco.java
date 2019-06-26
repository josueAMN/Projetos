package SisAgenda;

public class Endereco {
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(String rua,String novoNum,String novoBairro,String novaCidade,String novoEstado) {
		this.logradouro = rua;
		this.numero = novoNum;
		this.bairro = novoBairro;
		this.cidade = novaCidade;
		this.estado = novoEstado;
	}
	public Endereco() {
		this.logradouro = "Sem Rua";
		this.numero = "Sem Número";
		this.bairro = "Sem Bairro";
		this.cidade = "Sem Cidade";
		this.estado = "Sem Estado";
	}
	
	public String toString() {
		return "Rua: "+this.logradouro+"\nNúmero: "+this.numero+"\nBairro: "+this.bairro+
				"\nCidade: "+this.cidade+"\nEstado: "+this.estado;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	public void setLogradouro(String nvLog) {
		this.logradouro = nvLog;
	}
	public String getNum() {
		return this.numero;
	}
	public void setNum(String nvNum) {
		this.numero = nvNum;
	}
	public String getBairro() {
		return this.bairro;
	}
	public void setBairro(String nvB) {
		this.bairro = nvB;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String nvC) {
		this.cidade = nvC;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String nvEstado) {
		this.estado = nvEstado;
	}
	

}
