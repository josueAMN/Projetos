package atividadeTestesDeUnidade;

public class Torneio {
	
	int duracao = 0;
	public Torneio() {
		this.duracao = 0;
	}
	
	public int duracaoJogo(int horaInicio,int minInicio,int horaTermino,int minTermino) {
		duracao = ((horaTermino*60)-minTermino)-((horaInicio*60)+minInicio);
		if(duracao == 0) {
			duracao = 1440;
		}
		return duracao;
	}
}