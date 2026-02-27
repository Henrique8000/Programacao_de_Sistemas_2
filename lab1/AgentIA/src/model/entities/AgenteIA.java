package model.entities;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public abstract class AgenteIA {
	
	protected String nome;
	protected String status;
	
	public AgenteIA() {
		
	}
	
	public AgenteIA(String nome, String status) {
		this.nome = nome;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}
	
	public void conectarServidor() throws ErroComunicacaoIAException{
		
	}
	
	public abstract void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException;
	
    // Método principal evoluído
    public void processarPrompt(String prompt) throws 
            FalhaProcessamentoAgenteException, 
            PromptInadequadoException, 
            ErroComunicacaoIAException {
        
        // Validação básica (Enunciado original)
        if (prompt == null || prompt.isEmpty()) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }
        if (prompt.length() > 100) {
            throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
        }

        // Exercício 1: Filtro de Segurança
        verificarSeguranca(prompt);

        // Exercício 2: Simulação de Timeout
        chamarModeloExterno();

        System.out.println("🚀 Agente finalizou processamento com sucesso: " + prompt);
    }

    // Método auxiliar de segurança (Exercício 1)
    public void verificarSeguranca(String prompt) throws PromptInadequadoException {
        String p = prompt.toLowerCase();
        if (p.contains("hackear") || p.contains("roubar")) {
            throw new PromptInadequadoException("Intenção maliciosa detectada pelo Safety Guard.");
        }
    }

    // Método de simulação de API (Exercício 2)
    protected void chamarModeloExterno() throws ErroComunicacaoIAException {
        if (Math.random() > 0.7) { // 30% de chance de falha
            throw new ErroComunicacaoIAException("Falha na conexão com o cluster de GPUs (Timeout).");
        }
    }
}