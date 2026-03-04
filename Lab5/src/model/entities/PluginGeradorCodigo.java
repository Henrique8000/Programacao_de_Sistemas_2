package model.entities;

import model.exceptions.FalhaProcessamentoAgenteException;

public class PluginGeradorCodigo implements IAcaoAgente{

	@Override
	public void processarRequisicao(String prompt) throws FalhaProcessamentoAgenteException, FalhaProcessamentoAgenteException {
		
		if (prompt.length() > 50) {
			throw new FalhaProcessamentoAgenteException("limite de tokens de código");
		}
		
		System.out.println("Snippet de código Java gerado para: " + prompt);
		
	}

}
