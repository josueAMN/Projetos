package sistema.mercado.si;

public class UsuarioJaExisteException extends Exception{
	////Foi criado uma constante para n�o ficar a exclamacao
	private static final long serialVersionUID = 1L;

	public UsuarioJaExisteException(String mensagem) {
		super(mensagem);
	}
}
