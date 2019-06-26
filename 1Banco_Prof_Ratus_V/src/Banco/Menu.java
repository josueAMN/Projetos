package Banco;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Menu {
	public static void main(String []args) {
		BancoList banco = new BancoList("A CADASTRAR","A CADASTRAR",new ArrayList<Conta>());
		boolean laco = false;
		while( !laco) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("1.Cadastrar Banco\n2.Listar Banco\n3.Criar Conta"
					+ "\n4.Mostrar Contas com Saldo Negativo\n5.Saldo\n6.Pesquisar Contas"
					+ "\n7.Depositar\n8.Sacar\n9.Transferir\n10.Sair"));
		if(escolha == 10) {
			laco = true;
		}
		
		else if(escolha == 1) {
			String nome = JOptionPane.showInputDialog("Informe o nome do Banco");
			String cnpj = JOptionPane.showInputDialog("Informe o CNPJ do banco "+nome);
			banco.setNomeBanco(nome);
			banco.setCNPJ(cnpj);
		}
		
		else if(escolha == 2) {
				JOptionPane.showMessageDialog(null, banco);
		}
		
		else if(escolha == 3) {
					String titular = JOptionPane.showInputDialog("Informe o nome do cliente");
					String cpfT = JOptionPane.showInputDialog("Informe o CPF do cliente "+titular);
					String numC = JOptionPane.showInputDialog("Informe o número da conta");
					String numA = JOptionPane.showInputDialog("Informe o número da Agência");
					double saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o saldo inicial"));
					banco.abrirConta(titular, cpfT, numC, numA, saldo);
		}
		
		else if(escolha == 4) {
			ArrayList<Conta> Lista = banco.pesquisaContasComSaldoNegativo();
			for(Conta c:Lista) {
				JOptionPane.showMessageDialog(null, c);
			}
		}
		
		else if(escolha == 5) {
			String numC = JOptionPane.showInputDialog("Informe o número da conta");
			String numA = JOptionPane.showInputDialog("Informe o número da Agência");
			banco.consultaSaldoDeConta(numC, numA);
		}
		
		else if(escolha == 6) {
			String cpfT = JOptionPane.showInputDialog("Informe o CPF do cliente ");
			ArrayList<Conta> contas= banco.pesquisaContaDoCliente(cpfT);
				for (Conta c: contas) {
					JOptionPane.showMessageDialog(null, c.toString());
		}
		}
		
		else if(escolha == 7) {
			String numC = JOptionPane.showInputDialog("Informe o número da conta");
			String numA = JOptionPane.showInputDialog("Informe o número da Agência");
			double depo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a depositar"));
			banco.depositar(numC, numA, depo);
		}
		
		else if(escolha == 8) {
			String numC = JOptionPane.showInputDialog("Informe o número da conta");
			String numA = JOptionPane.showInputDialog("Informe o número da Agência");
			double sac = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a sacar"));
			banco.sacar(numC, numA, sac);
		}
		
		else if(escolha == 9) {
			String numCO = JOptionPane.showInputDialog("Informe o número da conta a transferir");
			String numAO = JOptionPane.showInputDialog("Informe o número da Agência a transferir");
			String numCD = JOptionPane.showInputDialog("Informe o número da conta a receber");
			String numAD = JOptionPane.showInputDialog("Informe o número da Agência a receber");
			double sac = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da transferência"));
			banco.transferir(numCO, numAO, numCD, numAD, sac);
			}
		}
	}
}

