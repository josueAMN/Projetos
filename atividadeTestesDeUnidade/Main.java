package atividadeTestesDeUnidade;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main (String[]args) {
		Torneio t = new Torneio();
		t.duracaoJogo(13, 00, 13, 30);
		JOptionPane.showMessageDialog(null,t);
		t.duracaoJogo(18, 00, 18, 00);
		System.out.print(t);
		t.duracaoJogo(7,8,9,10);
		System.out.print(t);
	}
}
