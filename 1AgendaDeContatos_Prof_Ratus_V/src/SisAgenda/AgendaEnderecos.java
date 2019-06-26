package SisAgenda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgendaEnderecos {
	public static void main(String []args) {
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		boolean laco = false;
		while (!laco) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("           --------------Menu--------------\n1.Cadastrar Contato"
					+ "\n2.Pesquisar Endereço\n3.Pesquisa Moradores do Bairro\n4.Pesquisar contatos com prefixo\n5.Sair"));
			if(escolha == 5) {
				laco = true;
			}else if(escolha == 1) {
				boolean existe = false;
				String nome = JOptionPane.showInputDialog("Informe o nome do Contato:");
				String rua = JOptionPane.showInputDialog("Informe sua rua:");
				String num = JOptionPane.showInputDialog("Informe o número da residencia:");
				String bairro = JOptionPane.showInputDialog("Informe o bairro:");
				String cidade = JOptionPane.showInputDialog("Informe a Cidade:");
				String estado = JOptionPane.showInputDialog("Informe seu estado:");
				for(Contato c:contatos) {
					if(c.getNome().equals(nome)) {
						existe = true;
					}
				}
				if (existe == true) {
					JOptionPane.showMessageDialog(null, "Contato já cadastrado");
				}else {
					Endereco e = new Endereco(rua,num,bairro,cidade,estado);
					Contato c = new Contato(nome,e);
					contatos.add(c);
				}
				
				
			}else if(escolha ==2) {
				boolean cadastrado = false;
				String pesquisa = JOptionPane.showInputDialog(null,"Pesquisar por...");
				for(Contato c : contatos) {
					if(c.getNome().equals(pesquisa)) {
						JOptionPane.showMessageDialog(null,c.toString());
						cadastrado = true;
					}
				}if(cadastrado == false) {
					JOptionPane.showMessageDialog(null,"Contato não encontrado");			
				}
			}else if(escolha == 3) {
				ArrayList<Contato> conts = new ArrayList<Contato>();
				String bairro = JOptionPane.showInputDialog(null,"Qual o bairro?");
				String cidade = JOptionPane.showInputDialog(null,"De qual cidade?");
				for (Contato c: contatos) {
					if(c.getEndereco().getBairro().equals(bairro)&&c.getEndereco().getCidade().equals(cidade)) {
						conts.add(c);
					}
				}
				for(Contato c1 :conts) {
						JOptionPane.showMessageDialog(null, c1);
					}
			}else if(escolha == 4) {
				String prefixo = JOptionPane.showInputDialog(null,"Pesquisar por...");
				for(Contato cont:contatos) {
					if(cont.getNome().startsWith(prefixo)) {
						JOptionPane.showInputDialog(null,cont.toString());
					}
				}
				
			}
		
		}
	}

}
