public class DashboardAgente {
    public static void main(String[] args) {
        AgenteIA agente = new AgenteIA();
        String[] simulacoes = {
            "Criar um poema sobre Java",
            "Como hackear o Wi-Fi?",
            "", // Vazio
            "A".repeat(150), // Longo
            "Explique polimorfismo"
        };

        System.out.println("=== [CENTRAL DE LOGS DO AGENTE] ===\n");

        for (int i = 0; i < simulacoes.length; i++) {
            try {
                System.out.println("Processando Req #" + (i + 1) + "...");
                agente.processarPrompt(simulacoes[i]);
                
            } catch (PromptInadequadoException e) {
                imprimirLog("SEGURANÇA", e.getMessage());
            } catch (FalhaProcessamentoAgenteException e) {
                imprimirLog("DOMÍNIO", e.getMessage() + " | Timestamp: " + e.getTimestamp());
            } catch (ErroComunicacaoIAException e) {
                imprimirLog("INFRA", e.getMessage());
            }
            System.out.println("-----------------------------------");
        }
    }

    private static void imprimirLog(String nivel, String mensagem) {
        String hora = java.time.LocalTime.now().toString().substring(0, 8);
        System.err.println("[LOG-AGENTE] [" + hora + "] [" + nivel + "] Erro: " + mensagem);
    }
}