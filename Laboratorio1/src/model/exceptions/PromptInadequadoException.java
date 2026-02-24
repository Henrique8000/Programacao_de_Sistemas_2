package model.exceptions;

import java.time.LocalDateTime;

public class PromptInadequadoException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String timestamp;

    public PromptInadequadoException(String mensagem) {
        super(mensagem);
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }
}
