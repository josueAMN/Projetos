package sistema.mercado.si;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class ProgramaSuperMercadoBrizola {
	public static void main(String [] args){
		
		//Inicio do SISMERCADOSI
		SisMercadoSI sistema = new SisMercadoSI();
		
		//Recupera todos od dados podendo lançar uma exceção no bloco try catch
		try {
			sistema.recuperarDadosUsuario();
			sistema.recuperarDadosCliente();
			sistema.recuperarDadosProduto();
			JOptionPane.showMessageDialog(null, "Dados Recuperados com Sucesso");
		}catch(IOException errinho) {
			JOptionPane.showMessageDialog(null, "Banco de Dados iniciado vazio");
		}
		
		
		//Inicio do programa
		boolean laco = false;
		boolean entrar = false;
		while (!entrar) {
			laco = false;
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("1.Entrar\n2.Cadastro de Usuário\n3. Sair"));
			
			//Permite o Usuario realizar Login
			if(opcao == 1) {
				String loginU = JOptionPane.showInputDialog("Login").toUpperCase();
				String senhaU = JOptionPane.showInputDialog("Senha").toUpperCase();
				if(sistema.verificarLogin(loginU, senhaU)==true ) {
					while(!laco) {
						int escolha = Integer.parseInt(JOptionPane.showInputDialog("1.Cadastrar Cliente\n2.Obter Clientes"
								+ "\n3.Pesquisar Usuário\n4.Obter Todos os Usuarios\n5.Cadastro de Produtos\n6.Listar Produtos\n7.Sair"));
						
						//Permite sair do segundo menu
						if(escolha == 7) {
							laco = true;
							
						//Permite o cadastro de clientes
						}else if(escolha == 1) {
							int tipoPessoa = Integer.parseInt(JOptionPane.showInputDialog("1.Pessoa Fisíca\n2.Pessoa Juridica"));
							if(tipoPessoa == 1) {
								String nome = JOptionPane.showInputDialog("Nome").toUpperCase();
								String cpf = JOptionPane.showInputDialog("CPF").toUpperCase();
								Cliente cliente = new ClienteCPF(nome,cpf);
								try {
									sistema.cadastrarCliente(cliente);
									JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
								}catch(ClienteJaExisteException erro) {
									JOptionPane.showMessageDialog(null, "Erro: "+erro.getMessage());
								}
							}else if(tipoPessoa ==2) {
								String nome = JOptionPane.showInputDialog("Nome").toUpperCase();
								String cnpj = JOptionPane.showInputDialog("CNPJ").toUpperCase();
								Cliente cliente = new ClienteCNPJ(nome,cnpj);
								try {
									sistema.cadastrarCliente(cliente);
									JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
								}catch(ClienteJaExisteException erro) {
									JOptionPane.showMessageDialog(null, "Erro: "+erro.getMessage());
								}
							}
							
						//Lista todos os clientes cadastrados
						}else if(escolha == 2) {
							List<Cliente> lista = sistema.obterListaDeClientes();
							for(Cliente cliente:lista) {
								JOptionPane.showMessageDialog(null, cliente.toString());
							}
						
							
						//Pesquisa clientes que possuem um prefixo em comum
						}else if(escolha == 3) {
							String prefixo = JOptionPane.showInputDialog("Prefixo a pesquisar: ").toUpperCase();
							List<Usuario> lista = sistema.pesquisaUsuarioComecandoCom(prefixo);
							for(Usuario usuario:lista) {
								JOptionPane.showMessageDialog(null, usuario.toString());
							}
							
						//Lista todos os usuarios cadastrados
						}else if(escolha == 4) {
							List<Usuario> lista = sistema.obterListaDeUsuarios();
									for(Usuario u:lista) {
										JOptionPane.showMessageDialog(null, u.toString());	
									}
									
						//Permite o cadastro de Produtos
						}else if(escolha == 5) {
							int tipoProd = Integer.parseInt(JOptionPane.showInputDialog("1.Produtos Perecíveis\n2.Produtos não Perecíveis"));
							if(tipoProd ==1) {
								String produto = JOptionPane.showInputDialog("Nome do produto:").toUpperCase();
								String codigo = JOptionPane.showInputDialog("Código do produto").toUpperCase();
								double quant = Double.parseDouble(JOptionPane.showInputDialog("Quantidade do produto: "));
								String descricao = JOptionPane.showInputDialog("Descrição do produto").toUpperCase();
								String validade = JOptionPane.showInputDialog("Validade do produto").toUpperCase();
								double precoAtacado = Double.parseDouble(JOptionPane.showInputDialog("Preço de Atacado"));
								double precoVarejo = Double.parseDouble(JOptionPane.showInputDialog("Preço de Varejo"));
								Produto prod = new Produto(codigo,produto,quant,descricao,validade,precoAtacado,precoVarejo);
								sistema.cadastrarProduto(prod);
							}else if(tipoProd == 2) {
								String produto = JOptionPane.showInputDialog("Nome do produto:").toUpperCase();
								String codigo = JOptionPane.showInputDialog("Código do produto").toUpperCase();
								double quant = Double.parseDouble(JOptionPane.showInputDialog("Quantidade do produto: "));
								String descricao = JOptionPane.showInputDialog("Descrição do produto").toUpperCase();
								String validade = null;
								double precoAtacado = Double.parseDouble(JOptionPane.showInputDialog("Preço de Atacado"));
								double precoVarejo = Double.parseDouble(JOptionPane.showInputDialog("Preço de Varejo"));
								Produto prod = new Produto(codigo,produto,quant,descricao,validade,precoAtacado,precoVarejo);
								sistema.cadastrarProduto(prod);
							}
						
						//Lista produtos cadastrados
						}else if(escolha == 6) {
							List<Produto> lista = sistema.listaProdutos();
							for(Produto p:lista) {
								JOptionPane.showMessageDialog(null, p.toString());
							}
						}
					}
					
				//Prova de bugs
				}else {
					JOptionPane.showMessageDialog(null, "Login/Senha inválido.");
				}
			
				
			//Opção responsavel por permitir e realizar o cadastro de um Usuario
			}else if(opcao == 2) {
				String nomeU = JOptionPane.showInputDialog("Nome").toUpperCase();
				String loginU = JOptionPane.showInputDialog("Login").toUpperCase();
				String senhaU = JOptionPane.showInputDialog("Senha").toUpperCase();
				Usuario usuario = new Usuario(nomeU,loginU,senhaU);
				try {
					sistema.cadastrarUsuario(usuario);
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
				}catch(UsuarioJaExisteException erro) {
					JOptionPane.showMessageDialog(null, "Erro: "+erro.getMessage());
					}
			
				
			// Opção que salva as alterações e encerra o programa
			}else if(opcao == 3){
				try {
					sistema.gravarDadosUsuario();
					sistema.gravaDadosClientes();
					sistema.gravarDadosProduto();
				}catch(IOException erro) {
					erro.printStackTrace();
				}
				entrar = true;
				
				
			//prova de bug
			}else {
				JOptionPane.showMessageDialog(null, "Entrada INVÁLIDA\nTENTE NOVAMENTE!!!");
			}
		}
	}
}