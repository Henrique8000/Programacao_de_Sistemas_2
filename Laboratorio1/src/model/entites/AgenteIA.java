package model.entites;

import java.util.List;

import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class AgenteIA {

	private static final int LIMITE_PROMPT = 100;
	private static final List<String> PALAVRAS_PROIBIDAS = List.of("hackear", "roubar");

	public void processarPrompt(String prompt)
			throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {

		// 1) Validações básicas (domínio)
		if (prompt == null || prompt.isEmpty()) {
			throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
		}

		if (prompt.length() > LIMITE_PROMPT) {
			throw new FalhaProcessamentoAgenteException(
					"Prompt muito longo para o modelo (máximo " + LIMITE_PROMPT + ").");
		}

		// 2) Filtro de segurança
		verificarSeguranca(prompt);

		// 3) Simula chamada ao modelo externo
		String resposta = chamarModeloExterno(prompt);

		System.out.println("Agente processando: " + prompt);
		System.out.println("Resposta do modelo: " + resposta);
	}

	public void verificarSeguranca(String prompt) throws PromptInadequadoException {
		String lower = prompt.toLowerCase();

		for (String proibida : PALAVRAS_PROIBIDAS) {
			if (lower.contains(proibida)) {
				throw new PromptInadequadoException("Prompt contém conteúdo proibido: \"" + proibida + "\".");
			}
		}
	}

	public String chamarModeloExterno(String prompt) throws ErroComunicacaoIAException {
		double r = Math.random(); // 0.0 a 1.0

		// Se for maior que 0.7, simulamos timeout/erro de rede
		if (r > 0.7) {
			throw new ErroComunicacaoIAException("Timeout/erro de comunicação ao chamar o modelo externo.");
		}

		// Resposta fake
		return "✅ (simulado) Entendi seu pedido: \"" + prompt + "\"";
	}
}
