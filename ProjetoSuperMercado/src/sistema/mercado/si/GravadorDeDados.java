
package sistema.mercado.si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
	
	public static final String ARQUIVO_USUARIOS = "usuarios.txt";
	public static final String ARQUIVO_CLIENTES_CPF = "clientescpf.txt";
	public static final String ARQUIVO_CLIENTES_CNPJ = "clientescnpj.txt";
	public static final String ARQUIVO_PRODUTOS  = "produtos.txt";
	
	
	
	//================= GRAVAÇÃO E RECUPERAÇÃO =============================
	
	
	// Metodo responsavel por recuperar dados de um arquivo txt
	public List<String>recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
		BufferedReader leitor = null;
		List<String>textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			  do{
			  	texto = leitor.readLine();
			  	if(texto!=null) {
			  		textoLido.add(texto);
			  	}
			  }while(texto!=null);
	
		}finally {
			if(leitor!=null) {
				leitor.close();
			}
		}
		return textoLido;
	}
		
		
	// Metodo responsavel por gravar dados em um arquivo txt
	public void gravaTextoEmArquivo(List<String>texto,String nomeArquivo) throws IOException{
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for(String s:texto) {
				gravador.write(s+"\n");
			}
		}finally {
			if(gravador !=null) {
				gravador.close();
			}
		}
	}

	
	//=========================== USUARIO =========================================
	
	
	//Metodo responsavel por realizar a gravação dos usuarios
	public void gravaUsuario(List<Usuario> usuarios)throws IOException{
		List<String>dadosUsuarios = new ArrayList<String>();
		for(Usuario u: usuarios) {
			String textoUsuario = u.getNome()+"##"+u.getLogin()+"##"+u.getSenha();
			dadosUsuarios.add(textoUsuario);
		}
		this.gravaTextoEmArquivo(dadosUsuarios, ARQUIVO_USUARIOS);
	}
	
	//Metodo responsavel por recuperar os usuarios
	public List<Usuario> recuperaUsuario()throws IOException{
		List<String>linhasArq = recuperaTextoDeArquivo(ARQUIVO_USUARIOS);
		List<Usuario>usuarios = new ArrayList<Usuario>();
		for(String s : linhasArq) {
			String[]dados = s.split("##");
			Usuario u = new Usuario(dados[0],dados[1],dados[2]);
			usuarios.add(u);
		}
		return usuarios;
	}


	//=========================== PRODUTO =========================================

	
		//Metodo responsavel por realizar a gravação dos PROdutos
		public void gravaProduto(List<Produto> prods)throws IOException{
			List<String>dadosProdutos = new ArrayList<String>();
			for(Produto p: prods) {
				String textoProduto = p.getCodigo()+"##"+p.getNome()+"##"+p.getQuantidade()+"##"+
			p.getDescricao()+"##"+p.getValidade()+"##"+p.getPrecoAtacado()+"##"+p.getPrecoVarejo();
						//u.getNome()+"##"+u.getLogin()+"##"+u.getSenha();
				dadosProdutos.add(textoProduto);
			}
			this.gravaTextoEmArquivo(dadosProdutos, ARQUIVO_PRODUTOS);
		}
		
		//Metodo responsavel por recuperar os produtos
		public List<Produto> recuperaProdutos()throws IOException{
			List<String>linhasArq = recuperaTextoDeArquivo(ARQUIVO_PRODUTOS);
			List<Produto>produtos = new ArrayList<Produto>();
			for(String s : linhasArq) {
				String[]dados = s.split("##");
				Produto p = new Produto(dados[0],dados[1],Double.parseDouble(dados[2]),dados[3],dados[4],Double.parseDouble(dados[5]),Double.parseDouble(dados[6]));
				produtos.add(p);
			}
			return produtos;
		}
	
	//=========================== CLIENTE CPF =========================================

	
	//Metodo responsavel por realizar a gravação dos CLIENTES CPF
	public void gravaClienteCPF(List<ClienteCPF> clientescpf)throws IOException{
		List<String>dadosClientesCPF = new ArrayList<String>();
		for(ClienteCPF cpf: clientescpf) {
			String textoClienteCPF = cpf.getNome()+"##"+cpf.getCodigo();
			dadosClientesCPF.add(textoClienteCPF);
		}
		this.gravaTextoEmArquivo(dadosClientesCPF, ARQUIVO_CLIENTES_CPF);
	}
	
	//Metodo responsavel por recuperar os CLIENTES CPF
	public List<Cliente> recuperaCliente()throws IOException{
		List<String>linhasArq = recuperaTextoDeArquivo(ARQUIVO_CLIENTES_CPF);
		List<String>linhasArq2 = recuperaTextoDeArquivo(ARQUIVO_CLIENTES_CNPJ);
		List<Cliente>cliente = new ArrayList<Cliente>();
		for(String s : linhasArq) {
			String[]dados = s.split("##");
			ClienteCPF cpf = new ClienteCPF(dados[0],dados[1]);
			cliente.add(cpf);
		}
		for(String s : linhasArq2) {
			String[]dados = s.split("##");
			ClienteCNPJ cnpj = new ClienteCNPJ(dados[0],dados[1]);
			cliente.add(cnpj);
		}
		return cliente;
	}
	
	
	//=========================== CLIENTE CNPJ =========================================

	
	//Metodo responsavel por realizar a gravação dos CLIENTES CNPJ
	public void gravaClienteCNPJ(List<ClienteCNPJ> clientescnpj)throws IOException{
		List<String>dadosClientesCNPJ = new ArrayList<String>();
		for(ClienteCNPJ cnpj: clientescnpj) {
			String textoClienteCNPJ = cnpj.getNome()+"##"+cnpj.getCodigo();
			dadosClientesCNPJ.add(textoClienteCNPJ);
		}
		this.gravaTextoEmArquivo(dadosClientesCNPJ, ARQUIVO_CLIENTES_CNPJ);
	}
}