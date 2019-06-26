package SisAgenda;

public class Pessoa {
	private String nome;
	private String numTelefone;
	private DataAniversario data;
	
	public Pessoa() {
		this.nome = "Sem nome";
		this.numTelefone = "0000-0000";
		this.data = new DataAniversario();
	}
	
	public Pessoa(String novoNome) {
		this.nome = novoNome;
		this.numTelefone = "0000-0000";
		this.data = new DataAniversario();
	}
	public Pessoa(String novoNome, String novoNumero, DataAniversario data) {
		this.nome = novoNome;
		this.numTelefone = novoNumero;
		this.data = data;
	}
	
	public String toString() {
		return "Contato "+this.nome+"\nData Nascimento "+this.data.getDia()+
				"/"+this.data.getMes()+"/"+this.data.getAno()+
				"\nTel.: "+this.numTelefone+"\n\n";
	}
	
	public String getNumTel() {
		return this.numTelefone;
	}
	public String getNome() {
		return this.nome;
	}
	public DataAniversario getData() {
		return this.data;
	}
	public void setNumTel(String nvNum) {
		this.numTelefone = nvNum;
	}
	public void setNome(String nvNome) {
		this.nome = nvNome;
	}

}
