package sistema.mercado.si;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SisMercadoSI implements SisMercado{
	private List<Usuario> usuarios;
	private List<Produto> listaDeProdutos;
	private List<Cliente> clientes;
	private List<Venda> vendas;
	private GravadorDeDados gravador;
	
	//Construtor da classe
	public SisMercadoSI() {
		this.usuarios = new ArrayList<Usuario>();
		this.listaDeProdutos = new ArrayList<Produto>();
		this.clientes = new ArrayList<Cliente>();
		this.vendas = new ArrayList<Venda>();
		this.gravador = new GravadorDeDados();
	}
	
	//Metodo responsavel por cadastrar Usuario
	public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException {
		if(!existeUsuario(usuario)) {
			this.usuarios.add(usuario);
		}else {
			throw new UsuarioJaExisteException("Existe um Usuario com esse Login: "+usuario.getLogin());
		}
	}
	
	//Metodo para verificar se o usuário existe ou não, retorna um boolean
	public boolean existeUsuario(Usuario usuario) {
		for(Usuario u: this.usuarios) {
			if(u.getLogin().equals(usuario.getLogin())) {
				return true;
			}
		}
		return false;
		}
	
	//Metodo responsavel por cadastrar Cliente podendo lançar exceções
	public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException {
		if(!existeCliente(cliente)) {
			this.clientes.add(cliente);
		}else {
			throw new ClienteJaExisteException("Existe um Cliente com esses dados: "+cliente.getCodigo());
		}
	}
	
	//Metodo para verificar se o cliente existe ou não. Retorna um boolean
	public boolean existeCliente(Cliente cliente) {
		for(Cliente c: this.clientes) {
			if(c.getCodigo().equals(cliente.getCodigo())) {
				return true;
			}
		}
		return false;
	}
	
	//Metodo responsavel por cadastrar Produto
	public void cadastrarProduto(Produto produto) {
		this.listaDeProdutos.add(produto);
		JOptionPane.showMessageDialog(null, "Cadastro realizado");
	}
	
	//Metodo responsavel por Listar todos os Produtos
	public List<Produto>listaProdutos(){
		return this.listaDeProdutos;
	}
	
	//Metodo responsavel por cadastar Venda
	public void cadastrarVenda(Venda venda) {
		this.vendas.add(venda);
		JOptionPane.showMessageDialog(null, "Venda Efetuada");
	}
	
	//Metodo responsavel por verificar o login, ao final ele retorna um boolean
	public boolean verificarLogin(String login, String senha) {
		for(Usuario usuario:this.usuarios) {
			if(usuario.getLogin().equals(login)&&usuario.getSenha().equals(senha)) {
				return true;
			}
		}return false;
	}
	
	//Metodo responsavel para procurar Usuario(s) com determinado prefixo e atribui-los a uma lista.Em seguida retorna a lista
	public List<Usuario> pesquisaUsuarioComecandoCom(String prefixo){
		List<Usuario>lista = new ArrayList<Usuario>();
		for(Usuario u:this.usuarios) {
			if(u.getNome().startsWith(prefixo)) {
				lista.add(u);
			}
		}
		return lista;
	}
	
	// Metodo responsavel por retornar a lista de clientes
	public List<Cliente> obterListaDeClientes(){
		return this.clientes;
	}
	
	// Metodo responsavel por retornar a lista de Usuarios
	public List<Usuario> obterListaDeUsuarios(){
		return this.usuarios;
	}
	
	// Metodo responsavel por recuperar os dados do usuario, podendo lançar exceções
	public void recuperarDadosUsuario() throws IOException{
		this.usuarios = this.gravador.recuperaUsuario();
	}
	
	// Metodo responsavel por gravar os dados do usuario, podendo lançar exceções
	public void gravarDadosUsuario() throws IOException{
		this.gravador.gravaUsuario(this.usuarios);
	}
	
	// Metodo responsavel por recuperar os dados do produto, podendo lançar exceções
		public void recuperarDadosProduto() throws IOException{
			this.listaDeProdutos = this.gravador.recuperaProdutos();
		}
		
		// Metodo responsavel por gravar os dados do produto, podendo lançar exceções
		public void gravarDadosProduto() throws IOException{
			this.gravador.gravaProduto(this.listaDeProdutos);
		}

	// Metodo responsavel por recuperar os dados dos CLIENTES CPF E CNPJ, podendo lançar exceções
	public void recuperarDadosCliente() throws IOException{
		this.clientes = this.gravador.recuperaCliente();

	}
	
	// Metodo responsavel por gravar os dados dos CLIENTES CPF E CNPJ, podendo lançar exceções
	public void gravaDadosClientes() throws IOException{
		List<ClienteCNPJ> listacnpj = new ArrayList<ClienteCNPJ>();
		List<ClienteCPF> listacpf = new ArrayList<ClienteCPF>();
		for(Cliente c: this.clientes) {
			if(c.getClass() == sistema.mercado.si.ClienteCNPJ.class) {
				listacnpj.add((ClienteCNPJ)c);
			}else if(c.getClass() == sistema.mercado.si.ClienteCPF.class) {
				listacpf.add((ClienteCPF)c);
			}
		}
		this.gravador.gravaClienteCNPJ(listacnpj);
		this.gravador.gravaClienteCPF(listacpf);
	}
}