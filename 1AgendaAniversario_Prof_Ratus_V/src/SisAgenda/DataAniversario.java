package SisAgenda;

public class DataAniversario {
	private int dia;
	private int mes;
	private int ano;
	
	public DataAniversario() {
		this.dia = 0;
		this.mes = 0;
		this.ano = 0;
	}
	public DataAniversario(int nvDia, int nvMes, int nvAno) {
		this.dia = nvDia;
		this.mes = nvMes;
		this.ano = nvAno;
	}
	
	public String toString() {
		return "Data de Nascimento: "+this.dia+"/"+this.mes+"/"+this.ano;
	}
	
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}
	
	public void setDia(int nvDia) {
		this.dia = nvDia;
	}
	public void setMes(int nvMes) {
		this.mes = nvMes;
	}
	public void setANo(int nvAno) {
		this.ano = nvAno;
	}

}
