package sistema.mercado.si;

public class Produto {
	private String codigo;
	private String nome;
	private double quantidade;
	private String descricao;
	private String validade;
	private double precoAtacado;
	private double precoVarejo;
	
	//Construtor com todos os parâmetros
	
	public Produto(String novoCodigo, String novoNome,double quant,String novaDescricao,String data, double novoPrecoAtac, double novoPrecoVar) {
		this.codigo = novoCodigo;
		this.nome = novoNome;
		this.quantidade = quant;
		this.descricao = novaDescricao;
		this.validade = data;
		this.precoAtacado = novoPrecoAtac;
		this.precoVarejo = novoPrecoVar;
	}
	
	//Construtor sem parâmetros
	
	public Produto() {
		this.codigo = "Sem descrição";
		this.nome = "Sem descrição";
		this.quantidade = 0;
		this.descricao = "Sem descrição";
		this.validade = "Não Perecivel";
		this.precoAtacado = 0.0;
		this.precoVarejo = 0.0;
	}
	
	//Todos os SET's
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setQuantidade(double quant) {
		this.quantidade = quant;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public void setPrecoAtacado(double precoAtacado) {
		this.precoAtacado = precoAtacado;
	}
	public void setPrecoVarejo(double precoVarejo) {
		this.precoVarejo = precoVarejo;
	}
	
	//Todos os GET's
	
	public String getCodigo() {
		return this.codigo;
	}
	public String getNome() {
		return this.nome;
	}
	public double getQuantidade() {
		return this.quantidade;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public String getValidade() {
		return this.validade;
	}
	public double getPrecoAtacado() {
		return this.precoAtacado;
	}
	public double getPrecoVarejo() {
		return this.precoVarejo;
	}
	
	//TO STRING
	public String toString() {
		return "Produto: "+getNome()+"\nCódigo:"+getCodigo()+"\nDescrição: "+getDescricao()+"\nPreço Atacado:"
	+getPrecoAtacado()+"\nPreço Varejo: "+getPrecoVarejo();
	}
	
}
