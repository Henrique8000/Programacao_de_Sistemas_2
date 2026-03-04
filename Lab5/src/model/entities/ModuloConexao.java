package model.entities;

import model.exceptions.ErroComunicacaoIAException;

public class ModuloConexao {
	
	public static void validarLink() throws ErroComunicacaoIAException {
		
		Double n = Math.random();
		
		if (n > 0.8) {
			throw new ErroComunicacaoIAException("Comunicação Falhou");
		}
		
	}
	
}
