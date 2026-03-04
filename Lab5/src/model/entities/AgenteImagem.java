package model.entities;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class AgenteImagem  extends AgenteIA{
	
	public AgenteImagem(String nome) {
		super(nome);
		
	}

	@Override
	public void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
		ModuloConexao.validarLink();
		
		super.conectarServidor();
		
		verificarSeguranca(input);
		
		System.out.println("Agente de Imagem " + this.nome + " sintetizando pixels para " + input);
		
	}
	
	@Override
	public void verificarSeguranca(String prompt) throws PromptInadequadoException {
		String p = prompt.toLowerCase();
		if (p.contains("hackear") || p.contains("roubar") || p.contains("biométrico")) {
			throw new PromptInadequadoException("Prompt inadequado!");
		}
	}
	
}
