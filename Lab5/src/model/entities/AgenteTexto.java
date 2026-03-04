package model.entities;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class AgenteTexto extends AgenteIA {

	public AgenteTexto(String nome) {
		super(nome);

	}

	@Override
	public void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
		ModuloConexao.validarLink();
		
		super.conectarServidor();
		
		if (input.length() > 500) {
			throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
		}
				
		System.out.println("Agente de Texto [" + this.nome + "] gerando resposta para: [" + input + "]");

	}
	
}
