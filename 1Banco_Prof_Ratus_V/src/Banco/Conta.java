package Banco;

public class Conta {
	private String titular;
	private String cpfTitular;
	private String numeroConta;
	private String numeroAgencia;
	private double saldo;
	
	public Conta() {
		this.titular = "Não Cadastrado";
		this.cpfTitular = "Não Cadastrado";
		this.numeroConta = "Não Cadastrado";
		this.numeroAgencia = "Não Cadastrado";
	}
	public Conta(String nome, String cpf, String NumConta, String NumAg,double saldo) {
		this.titular = nome;
		this.cpfTitular = cpf;
		this.numeroConta = NumConta;
		this.numeroAgencia = NumAg;
		this.saldo = saldo;
	}
	public String toString() {
		return "Dados do Cliente "+this.titular+"\nCPF: "+this.cpfTitular+"\nConta: "+this.numeroConta+"\nAgência: "+this.numeroAgencia+"\nSaldo: "+this.saldo;
	}
	
	public String getCPFTitular() {
		return this.cpfTitular;
	}
	public String getNumConta() {
		return this.numeroConta;
	}
	public String getNumAg() {
		return this.numeroAgencia;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setCPFTitular(String cpf) {
		this.cpfTitular = cpf;
	}
	public void setNumConta(String nconta) {
		this.numeroConta = nconta;
	}
	public void setNumAg(String nAg) {
		this.numeroAgencia = nAg;
	}
	public void setSaldo(double sal) {
		this.saldo = sal; 
	}
	public double creditar(double valor) {
		this.saldo +=valor;
		return this.saldo;
	}
	public double debitar(double valor) {
		this.saldo -=valor;
		return this.saldo;
	}
}
