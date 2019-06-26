package SisAgenda;

public class Contato {
	private String nome;
	private Endereco endereco;
	
	public Contato(String novoNome, Endereco end) {
		this.nome = novoNome;
		this.endereco = end;
	}
	
	public Contato() {
		this.nome = "A CADASTRAR!";
		this.endereco = new Endereco();
	}
	public String toString() {
		return "Endereço do contato "+getNome()+"\n"+endereco.toString();
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoN) {
		this.nome = novoN;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	public void setEndereco(Endereco novoEnd) {
		this.endereco = novoEnd;
	}

}
