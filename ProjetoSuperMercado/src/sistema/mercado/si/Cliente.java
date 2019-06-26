package sistema.mercado.si;

public abstract class Cliente {
	private String nome;
	
	//Construtor
	public Cliente(String novoNome) {
		this.nome = novoNome;
	}
	
	// GET's e SET's
	public abstract String getCodigo();
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nNome) {
		this.nome = nNome;
	}
	
	//TO STRING
	public String toString() {
		return "Cliente "+this.nome+"\nCódigo: "+getCodigo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (getCodigo() == null) {
			if (other.getCodigo() != null)
				return false;
		} else if (!getCodigo().equals(other.getCodigo()))
			return false;
		return true;
	}
}