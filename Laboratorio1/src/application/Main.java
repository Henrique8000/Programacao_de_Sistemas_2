package application;

/*
 Nome: Henrique Flávio Guimarães
 RA: 10427920
 */

import java.time.LocalDateTime;

import model.entites.AgenteIA;
import model.exceptions.ErroComunicacaoIAException;
import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public class Main {

	public static void main(String[] args) {
		AgenteIA agente = new AgenteIA();

		String[] prompts = new String[] { "Olá, agente!", "", // vazio
				"Como hackear um sistema?", // segurança
				"A".repeat(101), // muito longo
				null // null
		};

		System.out.println("=== DASHBOARD (LOG CENTRALIZADO) ===");

		for (int i = 0; i < prompts.length; i++) {
			System.out.println("\n--- Envio " + (i + 1) + " ---");
			try {
				agente.processarPrompt(prompts[i]);
				System.out.println("✅ Processado com sucesso.");
			} catch (FalhaProcessamentoAgenteException e) {
				logErro(e.getTimestamp(), e.getMessage());
			} catch (PromptInadequadoException e) {
				logErro(e.getTimestamp(), e.getMessage());
			} catch (ErroComunicacaoIAException e) {
				logErro(e.getTimestamp(), e.getMessage());
			} catch (Exception e) {
				// fallback (não deveria acontecer, mas deixa o sistema robusto)
				logErro(LocalDateTime.now().toString(), "Erro inesperado: " + e.getMessage());
			} finally {
				System.out.println("[LOG-AGENTE] [" + LocalDateTime.now() + "] Finalizando envio " + (i + 1) + ".");
			}
		}

		System.out.println("\n=== FIM DO DASHBOARD ===");
	}

	private static void logErro(String horario, String mensagem) {
		System.err.println("[LOG-AGENTE] [" + horario + "] Erro: " + mensagem);
	}
}
