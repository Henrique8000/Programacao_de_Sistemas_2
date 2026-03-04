package model.exceptions;

public class PromptInadequadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public PromptInadequadoException(String mensagem) {
		super(mensagem);
	}
}
