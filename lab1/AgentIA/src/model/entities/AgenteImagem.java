package model.entities;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class AgenteImagem extends AgenteIA{

	
	
	@Override
	public void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
		
		conectarServidor();
		
		verificarSeguranca(input);
		
		System.out.println("🚀 Agente de Imagem " + nome + " sintetizando pixels para: " + input);
	}
	
}
