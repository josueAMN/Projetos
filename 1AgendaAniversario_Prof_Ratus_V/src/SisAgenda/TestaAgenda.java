package SisAgenda;

import javax.swing.JOptionPane;

public class TestaAgenda {
	public static void main(String []args) {
	Agenda agenda = new Agenda();
	
	String nome = JOptionPane.showInputDialog(null,"Qual o nome do contato?");
	int dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Que dia o contato nasceu?"));
	int mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Que mês o contato nasceu?"));
	int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Que ano o contato nasceu?"));
	String numTel = JOptionPane.showInputDialog(null,"Qual o numero do contato?");
	
	Pessoa p = new Pessoa(nome,numTel, new DataAniversario(dia,mes,ano));
	
	agenda.cadastraPessoa(p);
	
	String nome1 = JOptionPane.showInputDialog(null,"Qual o nome do contato?");
	int dia1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Que dia o contato nasceu?"));
	int mes1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Que mês o contato nasceu?"));
	int ano1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Que ano o contato nasceu?"));
	String numTel1 = JOptionPane.showInputDialog(null,"Qual o numero do contato?");
	
	Pessoa p1 = new Pessoa(nome1,numTel1, new DataAniversario(dia1,mes1,ano1));
	
	agenda.cadastraPessoa(p1);
	
	JOptionPane.showMessageDialog(null, "Digite o dia e o mês para ver o aniversariante do dia");
	int diaA = Integer.parseInt(JOptionPane.showInputDialog(null,"Que dia o contato nasceu?"));
	int mesA = Integer.parseInt(JOptionPane.showInputDialog(null,"Que mês o contato nasceu?"));
	JOptionPane.showMessageDialog(null, agenda.pesquisaAniversariantesDoDia(diaA, mesA));
	
	String pesquisa = JOptionPane.showInputDialog(null, "Qual o nome a pesquisar?");
	JOptionPane.showMessageDialog(null, agenda.pesquisaPessoa(pesquisa));

}
}