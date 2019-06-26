package sistema.mercado.si;

public class ClienteJaExisteException extends Exception{
	//Foi criado uma constante para não ficar a exclamacao
	private static final long serialVersionUID = 1L;

	public ClienteJaExisteException(String mensagem) {
		super(mensagem);
	}

}
