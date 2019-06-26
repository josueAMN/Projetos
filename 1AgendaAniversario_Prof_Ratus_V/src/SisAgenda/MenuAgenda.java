package SisAgenda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MenuAgenda {
	public static void main(String []args) {
		Agenda agenda = new Agenda();
		boolean laco = false;
		while(!laco) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(("---------------MENU---------------\n"
					+ "1.Cadastrar Contato\n2.Apaga Contato\n3.Aniversariante do Dia\n"
					+ "4.Buscar Pessoa\n5.Exibir Contatos\n6.Sair")));
			if(escolha == 1) {
				String nomeContato = JOptionPane.showInputDialog("Nome:");
				String [] data = JOptionPane.showInputDialog("Data xx/yy/zzzz").split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				String numTel = JOptionPane.showInputDialog("Número para contato:");
				Pessoa p = new Pessoa(nomeContato,numTel,new DataAniversario(dia,mes,ano));
				agenda.cadastraPessoa(p);
			}else if(escolha == 2) {
				String nomeContato = JOptionPane.showInputDialog("Nome:");
				agenda.apagaPessoa(nomeContato);
			}else if(escolha == 3) {
				ArrayList<Pessoa> teste = new ArrayList<Pessoa>();
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Mês:"));
				// quer dizer que teste é igual a agenda.pesquisa....
				teste = agenda.pesquisaAniversariantesDoDia(dia, mes);
				for (Pessoa p:teste){
					JOptionPane.showMessageDialog(null, p+"\n");
				}
				
			}else if(escolha == 4) {
				Pessoa p = new Pessoa();
				String nomeContato = JOptionPane.showInputDialog("Nome:");
				p = agenda.pesquisaPessoa(nomeContato);
				if(p == null) {
					JOptionPane.showMessageDialog(null, "Contato não encontrado");
				}else {
					JOptionPane.showMessageDialog(null, p);
				}
			}else if(escolha == 5) {
				JOptionPane.showMessageDialog(null,agenda.exibeContatos());
			}else if(escolha == 6) {
				laco = true;
			}

		}
	}

}
