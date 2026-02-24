package model.exceptions;

import java.time.LocalDateTime;

public class ErroComunicacaoIAException extends Exception {
    private final String timestamp;

    public ErroComunicacaoIAException(String mensagem) {
        super(mensagem);
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }
}
