package model.entities;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class AgenteTexto extends AgenteIA{
	
	public AgenteTexto() {
		super();
	}
	
	public AgenteTexto(String nome, String status) {
		super(nome, status);
	}

	@Override
	public void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
		
		conectarServidor();
		
		
	}
	
	@Override
	public void processarPrompt(String input) throws FalhaProcessamentoAgenteException,  PromptInadequadoException, ErroComunicacaoIAException {
        if (input == null || input.isEmpty()) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }
        if (input.length() > 500) {
            throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
        }

        verificarSeguranca(input);
        
        chamarModeloExterno();

        System.out.println("🚀 Agente de Texto " + nome + " gerando resposta para: " + input);
	}
}
