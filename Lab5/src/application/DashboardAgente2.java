package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.AgenteIA;
import model.entities.AgenteTexto;
import model.entities.PluginGeradorCodigo;
import model.entities.PluginPesquisaWeb;

public class DashboardAgente2 {
    public static void main(String[] args) {
        String[] simulacoes = {
            "Criar um poema sobre Java",
            "Como hackear o Wi-Fi?",
            "", // Vazio
            "A".repeat(600), // Longo
            "Explique polimorfismo",
            "Roubar",
            "Hackear"
        };

        List<AgenteIA> listAgentes = new ArrayList<>();
        listAgentes.add(new AgenteTexto("agente imagem #1"));
        //listAgentes.add(new AgenteImagem("agente imagem #2"));
        //listAgentes.add(new AgenteImagem("agente imagem #3"));

        System.out.println("=== [CENTRAL DE LOGS DO AGENTE] ===\n");

        for (AgenteIA agenteIA : listAgentes) {
            for (int i = 0; i < simulacoes.length; i++) {
                    System.out.println("Processando Req #" + (i + 1) + "...");
                    try {
                        //agenteIA.usarHabilidade(new PluginPesquisaWeb(), simulacoes[i]);
                        agenteIA.usarHabilidade(new PluginGeradorCodigo(), simulacoes[i]);
                    } catch (Exception e) {
                        //e.printStackTrace();
                        imprimirLog("INFRA", e.getMessage());
                    }

                
                System.out.println("-----------------------------------");
            }    
        }
        
    }

    private static void imprimirLog(String nivel, String mensagem) {
        String hora = java.time.LocalTime.now().toString().substring(0, 8);
        System.err.println("[LOG-AGENTE] [" + hora + "] [" + nivel + "] Erro: " + mensagem);
    }
}