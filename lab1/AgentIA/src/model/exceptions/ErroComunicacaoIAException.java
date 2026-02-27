package model.exceptions;

public class ErroComunicacaoIAException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroComunicacaoIAException(String mensagem) {
		super(mensagem);
	}
}