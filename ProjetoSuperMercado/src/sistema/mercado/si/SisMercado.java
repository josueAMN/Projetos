package sistema.mercado.si;

import java.io.IOException;
import java.util.List;

public interface SisMercado {
	public void cadastrarUsuario(Usuario u) throws UsuarioJaExisteException;
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException;
	public void cadastrarProduto(Produto p);
	public void cadastrarVenda(Venda v);
	public boolean verificarLogin(String login, String senha);
	public List<Usuario> pesquisaUsuarioComecandoCom(String prefixo);
	public List<Usuario> obterListaDeUsuarios();
	public List<Cliente> obterListaDeClientes();
	public void gravarDadosUsuario()throws IOException;
	public void recuperarDadosUsuario()throws IOException;
}
