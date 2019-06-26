package SisAgenda;

// .equals() só para String, por ser um metodo do tipo String
// .equlsIgnoreCase() ignora maiusculos e minusculos.
// == Serve para INT,Double, Char. 

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Agenda {
	private ArrayList<Pessoa> contatos;
	
	// Construtor da classe Agenda
	public Agenda() {
		contatos = new ArrayList<Pessoa>();
	}
	
	public String exibeContatos() {
		String saida = "";
		for (Pessoa people:contatos) {
			saida += people.toString();
		}
		return saida;
			
	}
	
	// Verifica se um contato já existe ou não e retorna um boolean
	private boolean contatoJaExiste(Pessoa p) {
		for(Pessoa cont:contatos) {
			if (cont.equals(p)){
				return true;
		}
		}
		return false;
	}
	
	// Cadastra um contato a lista de contatos caso ele não esteja cadastrado
	public void cadastraPessoa(Pessoa p) {
		if(contatoJaExiste(p) == true) {
			JOptionPane.showMessageDialog(null, "CONTATO JÁ CADASTRADO!");
		}else if((contatoJaExiste(p) == false)){
			this.contatos.add(p);
			JOptionPane.showMessageDialog(null, "CONTATO CADASTRADO!");
		}
		
	}
	
	// Apaga um contato da lista de contatos
	public void apagaPessoa(String nomePessoa) {
		for(Pessoa pessoa : contatos) {
			if(pessoa.getNome().equals(nomePessoa)){
				contatos.remove(pessoa);
			}
		}
	}
	
	// Varre a lista de contatos a procura de contatos que estão fazendo aniversário no dia e mês indicado e retorna uma lista com esses contatos
	public ArrayList<Pessoa> pesquisaAniversariantesDoDia(int dia, int mes){
		ArrayList<Pessoa> Aniversariantes = new ArrayList<Pessoa>();
		
		for(Pessoa p:contatos) {
			if(p.getData().getDia() == dia && p.getData().getMes()==mes) {
				Aniversariantes.add(p);
			}
		}
		return Aniversariantes;
	}
	// Varre a lista a procura de um contato, caso ele exista, ele retorna o mesmo, caso contrário ele retorna null
	public Pessoa pesquisaPessoa(String nomeContato) {
		for(Pessoa p: contatos) {
			if(p.getNome().equalsIgnoreCase(nomeContato)) {
				return p;
			}
		}
		return null;
	}
}
