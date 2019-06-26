package sistema.mercado.si;

public class Usuario {
	private String nome;
	private String login;
	private String senha;
	
	//Contrutor com três parâmetros
	public Usuario(String novoNome,String novoLogin, String novaSenha) {
		this.nome = novoNome;
		this.login = novoLogin;
		this.senha = novaSenha;
	}
	
	//Contrutor com dois parâmetros
	public Usuario(String novoNome,String novoLogin) {
		this.nome = novoNome;
		this.login = novoLogin;
		this.senha = "";
	}
	
	//Todos os "GET's"
	public String getLogin() {
		return this.login;
	}
	public String getNome() {
		return this.nome;
	}
	public String getSenha() {
		return this.senha;
	}
	//Todos os "SET's"
	public void setLogin(String nLogin) {
		this.login = nLogin;
	}
	public void setNome(String nNome) {
		this.nome = nNome;
	}
	public void setSenha(String nSenha) {
		this.senha = nSenha;
	}
	
	//to string
	public String toString() {
		return "Usuário "+this.nome+"\nLogin: "+this.login;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}	
}
