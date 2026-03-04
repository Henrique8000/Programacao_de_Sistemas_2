package model.entities;

import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class PluginPesquisaWeb implements IAcaoAgente {

	@Override
	public void processarRequisicao(String prompt) throws PromptInadequadoException, FalhaProcessamentoAgenteException {
		
		if (prompt.equalsIgnoreCase("hackear") || prompt.equalsIgnoreCase("roubar")) {
			throw new PromptInadequadoException("prompt inadequado " + prompt);
		}
		
		System.out.println("Resultado da pesquisa no Google sobre: " + prompt);
		
	}

}
