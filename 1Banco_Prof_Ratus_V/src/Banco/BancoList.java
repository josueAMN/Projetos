package Banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BancoList {
	
	private String nome;
	private String CNPJ;
	private ArrayList<Conta> contas;
	
	public BancoList(String novoNome,String cnpj, ArrayList<Conta> contas) {
		this.nome = novoNome;
		this.CNPJ = cnpj;
		this.contas = contas;
	}
	
	public String getNomeBanco() {
		return this.nome;
	}
	public void setNomeBanco (String novoNome) {
		this.nome = novoNome;
	}
	public String getCNPJ() {
		return this.CNPJ;
	}
	public void setCNPJ(String novoCNPJ) {
		this.CNPJ = novoCNPJ;
	}
	
	
	public void transferir(String numContaO, String numAgO,String numContaD, String numAgD, double valort) {
		for(Conta n:this.contas) {
			if(n.getNumAg().equals(numAgO) && n.getNumConta().equals(numContaO)) {
				for(Conta n2:this.contas) {
					if(n2.getNumConta().equals(numContaD)&&n2.getNumAg().equals(numAgD)) {
						if(n.getSaldo()>=valort) {
							n2.creditar(valort);
							n.debitar(valort);
							JOptionPane.showMessageDialog(null, "Tranferência realizada com sucesso!!!");
						}else if(n.getSaldo()<valort) {
							JOptionPane.showMessageDialog(null, "Saldo insuficiente");
						}
						
					}
				}
			}
		}
	}
	
	public void consultaSaldoDeConta(String numCont, String numAg) {
		for(Conta c:this.contas) {
			if(c.getNumConta().equals(numCont)&&c.getNumAg().equals(numAg)) {
				JOptionPane.showMessageDialog(null, c.getSaldo());
			}
		}
	}
	
	public String toString() {
		return "O Banco "+this.nome+" detem o CNPJ "+this.CNPJ;
	}
	
	private boolean contaJaExiste(String cpf, String ag) {
		for(Conta c:contas) {
			if(c.getCPFTitular().equals(cpf)&&c.getNumAg().equals(ag)) {
				return true;
			}
		}
		return false;
	}
	
	public void abrirConta(String nome, String cpf, String numCont, String numAg, double saldoIn) {
		
		if(!contaJaExiste(cpf,numAg)) {
			contas.add(new Conta(nome,cpf,numCont,numAg,saldoIn));
			JOptionPane.showMessageDialog(null,"Cadastro realizado!!!");
		}else {
			JOptionPane.showMessageDialog(null, "Erro\nCliente já cadastrado!!!");
		}
			
	}
	
	public void sacar (String numCont, String numAg, double saque) {
		for(Conta cont:this.contas) {
			if(cont.getNumConta().equals(numCont)&&cont.getNumAg().equals(numAg)) {
				if(cont.getSaldo()>saque) {
					cont.debitar(saque);
					JOptionPane.showMessageDialog(null, "COMPROVANTE DE SAQUE\nValor "+saque);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
				}
			}
		}
	}
	
	public void depositar(String numCont, String numAg, double deposito) {
		for(Conta cont:this.contas) {
			if(cont.getNumConta().equals(numCont)&&cont.getNumAg().equals(numAg)) {
				cont.creditar(deposito);
				JOptionPane.showMessageDialog(null, "COMPROVANTE DE DEPÓSITO\nValor "+deposito);
			}
		}
	}
	
	public ArrayList<Conta> pesquisaContaDoCliente(String cpf){
		ArrayList<Conta> Lista = new ArrayList<Conta>();
		for(Conta existe:this.contas) {
			if(existe.getCPFTitular().equals(cpf)) {
				Lista.add(existe);
			}
		}
		return Lista;
	}
	
	public ArrayList<Conta> pesquisaContasComSaldoNegativo(){
		ArrayList<Conta> ListaDeContas = new ArrayList<Conta>();
		for(Conta neg:this.contas) {
			if(neg.getSaldo()<0) {
				ListaDeContas.add(neg);
			}
		}
		return ListaDeContas;
	}

}
